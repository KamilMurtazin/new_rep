package IIP_homeworks.part4.homework_NelzyaGram.src;

import IIP_homeworks.part4.homework_NelzyaGram.src.model.AppConfig;
import IIP_homeworks.part4.homework_NelzyaGram.src.model.Post;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.Scanner;

public class PostWriter implements Runnable{
    private AppConfig config;
    private PipedOutputStream pipedOut;
    private Scanner scanner;

    public PostWriter(AppConfig config, PipedOutputStream pipedOut) {
        this.config = config;
        this.pipedOut = pipedOut;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(){
        System.out.println("==== PostWriter is launched ====");
        System.out.println("Maximum posts: " + config.getMaxPosts());
        System.out.println("Enter 'exit' to exit");

        try (DataOutputStream dataOut = new DataOutputStream(pipedOut)){
            int postCount = 0;

            while (postCount < config.getMaxPosts()){
                System.out.print("Post #" + (postCount+1) + ": ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exit using the exit command)");
                    break;
                }

                if (input.trim().isEmpty()){
                    System.out.println("Post can't be empty!");
                    continue;
                }

                Post post = new Post(
                        postCount + 1,
                        System.currentTimeMillis(),
                        input
                );

                dataOut.writeInt(post.getId());
                dataOut.writeLong(post.getTimestamp());
                dataOut.writeUTF(post.getText());
                dataOut.flush();

                System.out.println("The post has been saved)");
                postCount++;
            }

            System.out.println("Posts sent:" + postCount);

        } catch (IOException e){
            System.err.println("PostWriter error: " + e.getMessage());
        } finally {

            try {
                pipedOut.close();
            } catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("PostWriter completed");
        }
    }
}
