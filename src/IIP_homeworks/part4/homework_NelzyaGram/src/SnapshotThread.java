package IIP_homeworks.part4.homework_NelzyaGram.src;

import IIP_homeworks.part4.homework_NelzyaGram.src.model.Post;
import IIP_homeworks.part4.homework_NelzyaGram.src.model.UserProfile;
import java.io.*;
import java.util.List;

public class SnapshotThread extends Thread {
    private String username;
    private String status;
    private List<Post> posts;

    public SnapshotThread(String username, String status, List<Post> posts) {
        this.username = username;
        this.status = status;
        this.posts = posts;
        setDaemon(true);
    }

    @Override
    public void run() {
        File dir = new File("data/snapshots");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        int num = 1;
        while (true) {
            try {
                Thread.sleep(3000);

                UserProfile profile = new UserProfile(
                        username,
                        posts.size(),
                        System.currentTimeMillis(),
                        status
                );

                File snapshotFile = new File(dir, "profile_" + num + ".ser");

                try (ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(snapshotFile))) {
                    oos.writeObject(profile);
                }

                System.out.println("Snapshot #" + num + " (posts: " + posts.size() + ")");
                num++;

            } catch (InterruptedException e) {
                break;
            } catch (IOException e) {
                // молчим
            }
        }
    }
}