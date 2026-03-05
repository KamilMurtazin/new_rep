package AISD_homeworks.HW2;

public class MergeQueues {
    public static Queue merge(Queue q1, Queue q2){
        Queue result = new Queue();
        while (!q1.isEmpty() && !q2.isEmpty()){
            if (q1.getHead() <= q2.getHead()){
                result.add(q1.remove());
            } else {
                result.add(q2.remove());
            }
        }
        while (!q1.isEmpty()){
            result.add(q1.remove());
        }
        while (!q2.isEmpty()){
            result.add(q2.remove());
        }
        return result;
    }
    public static void main(String[] args) {
        Queue queue1 = new Queue();
        queue1.add(1);
        queue1.add(3);
        queue1.add(5);

        Queue queue2 = new Queue();
        queue2.add(2);
        queue2.add(4);
        queue2.add(6);

        System.out.println("Первая очередь:");
        queue1.print();
        System.out.println("Вторая очередь:");
        queue2.print();


        Queue merged = MergeQueues.merge(queue1, queue2);

        System.out.println("Объединенная очередь:");
        merged.print();
    }
}
