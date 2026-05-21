package IIP_homeworks.part4.homework_NelzyaGram.src;

import IIP_homeworks.part4.homework_NelzyaGram.src.model.Post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PostSaver implements Runnable{
    private PipedInputStream pipedIn;
    private String savePath;
    private List<Post> savedPosts;

    public PostSaver(PipedInputStream pipedIn, String savePath) {
        this.pipedIn = pipedIn;
        this.savePath = savePath;
        this.savedPosts = new ArrayList<>();
    }

    @Override
    public void run(){
        System.out.println("==== PostSaver is launched ====");

        try (DataInputStream dataIn = new DataInputStream(pipedIn)){
            while (true){
                try{
                    int id = dataIn.readInt();
                    long timestamp = dataIn.readLong();
                    String text = dataIn.readUTF();

                    Post post = new Post(id, timestamp, text);
                    savedPosts.add(post);

                    System.out.println("Received the post#" + id + ", save...");

                    savePostToFile(post);

                    System.out.println("Post #" + id + " has been saved!");

                } catch (EOFException e){
                    System.out.println("The channel is closed, there are no new posts");
                    break;
                }
            }
        } catch (IOException e){
            System.out.println("PostSaver is shutting down");
        }

        System.out.println("Total posts saved:" + savedPosts.size());
        System.out.println("PostSaver completed");
    }

    private void savePostToFile(Post post) throws IOException{
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(savePath, true))){
            dos.writeInt(post.getId());
            dos.writeLong(post.getTimestamp());
            dos.writeUTF(post.getText());
        }
    }

    public List<Post> getSavedPosts(){
        return savedPosts;
    }

    public static List<Post> loadAllPosts(String filePath) throws  IOException{
        List<Post> posts = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return posts;
        }

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file))){
            while (dis.available() > 0){
                try{
                    int id = dis.readInt();
                    long timestamp = dis.readLong();
                    String text = dis.readUTF();
                    posts.add(new Post(id, timestamp, text));
                } catch (EOFException e){
                    break;
                }
            }
        }
        return posts;
    }
}
