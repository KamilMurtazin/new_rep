package IIP_homeworks.part4.classwork4_2;

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.FileReader;

public class Task3 {

    static class Buffer{
        private Queue<String> queue = new LinkedList<>();
        private int maxSize;
        private boolean finished = false;

        public Buffer(int maxSize) {
            this.maxSize = maxSize;
        }

        public synchronized void produce(String line) throws InterruptedException {
            while (queue.size() == maxSize){
                wait();
            }
            queue.add(line);
            System.out.println("Produced: " + line);
            notifyAll();
        }

        public synchronized String consume() throws InterruptedException{
            while (queue.isEmpty() && !finished) {
                wait();
            }
            if (queue.isEmpty() && finished) {
                return null;
            }
            String line = queue.poll();
            System.out.println("Consumed: " + line);
            notifyAll();
            return line;
        }

        public synchronized void setFinished() {
            finished = true;
            notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        Buffer buffer = new Buffer(5);

        // Producer
        Thread producer = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Downloads\\access_new.log"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.produce(line);
                }
                buffer.setFinished();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Consumer
        Thread consumer = new Thread(() -> {
            int errorCount = 0;
            try {
                String line;
                while ((line = buffer.consume()) != null) {
                    if (line.contains("ERROR")) {
                        errorCount++;
                    }
                }
                System.out.println("ERROR count: " + errorCount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}
