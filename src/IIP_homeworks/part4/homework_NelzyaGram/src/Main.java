package IIP_homeworks.part4.homework_NelzyaGram.src;

import IIP_homeworks.part4.homework_NelzyaGram.src.model.AppConfig;
import IIP_homeworks.part4.homework_NelzyaGram.src.model.Post;


import java.io.File;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        try {
            new File("data/snapshots").mkdirs();
            new File("reports").mkdir();

            //Modul1
            System.out.println("==== NelzyaGram (v1.0) ====");

            ConfigReader configReader = new ConfigReader("src/IIP_homeworks/part4/homework_NelzyaGram/config/settings.cfg");
            AppConfig config = configReader.read();
            System.out.println("Hello, " + config.getUsername() + "!");
            System.out.println("Your bio: " + config.getBio() + "\n");

            //Modul2
            System.out.println("Your Avatar:");
            AvatarRenderer avatarRenderer = new AvatarRenderer(
                    "src/IIP_homeworks/part4/homework_NelzyaGram/config/avatar.txt",
                    "src/IIP_homeworks/part4/homework_NelzyaGram/data/avatar_backup.jpg"
            );
            avatarRenderer.render();
            System.out.println();

            //Modul3
            System.out.println("==== START OF THE PUBLICATION SESSION ====");

            PipedOutputStream pipedOut = new PipedOutputStream();
            PipedInputStream pipedIn = new PipedInputStream(pipedOut);

            PostWriter writer = new PostWriter(config, pipedOut);
            String postsPath = "src/IIP_homeworks/part4/homework_NelzyaGram/data/posts.dat";
            System.out.println("Посты будут сохранены в: " + postsPath);
            PostSaver saver = new PostSaver(pipedIn, postsPath);

            Thread writerThread = new Thread(writer, "PostWriter");
            Thread saverThread = new Thread(saver, "PostSaver");

            //Modul4
            String userStatus = "sleeepy";

            SnapshotThread snapshotThread = new SnapshotThread(
                    config.getUsername(),
                    userStatus,
                    saver.getSavedPosts()
            );
            snapshotThread.start();

            writerThread.start();
            saverThread.start();

            writerThread.join();
            saverThread.join();

            Thread.sleep(1000);

            System.out.println("==== THE SESSION IS OVER ====");

            //ВЫВОД РЕЗУЛЬТАТОВ
            List<Post> posts = saver.getSavedPosts();
            if (!posts.isEmpty()){
                System.out.println("Saved posts (" + posts.size() + "):");
                for (Post post : posts){
                    System.out.println("    " + post);
                }
            } else {
                System.out.println("No posts saved");
            }

            //Modul5
            System.out.println("\n==== FEED AGGREGATOR ====");

            FeedAggregator feedAggregator = new FeedAggregator(
                    "src/IIP_homeworks/part4/homework_NelzyaGram/config/feed_part1.txt",
                    "src/IIP_homeworks/part4/homework_NelzyaGram/config/feed_part2.txt"
            );
            Thread feedThread = new Thread(feedAggregator);
            feedThread.start();
            feedThread.join();

            // Выводим статистику
            System.out.println("\n=== FEED STATISTICS ===");
            System.out.println("Total posts: " + feedAggregator.getTotalPosts());
            System.out.println("Total likes: " + feedAggregator.getTotalLikes());
            System.out.println("Total reposts: " + feedAggregator.getTotalReposts());
            System.out.println("Top author: " + feedAggregator.getTopAuthor() + " (" + feedAggregator.getTopAuthorLikes() + " likes)");

            System.out.println("\n=== ACTIVITY GRAPH (top-5) ===");
            List<Map.Entry<String, Integer>> list = new ArrayList<>(feedAggregator.getAuthorLikes().entrySet());
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                String name = list.get(i).getKey();
                int likes = list.get(i).getValue();
                int stars = likes / 10;
                System.out.println(name + ": " + "*".repeat(stars) + " (" + likes + " likes)");
            }

            //Modul6
            System.out.println("\n==== ACHIEVEMENT MANAGER ====");
            AchievementManager achievementManager = new AchievementManager(
                    "src/IIP_homeworks/part4/homework_NelzyaGram/data/achievements.ser"
            );

            List<Post> allPosts = saver.getSavedPosts();
            for (int i = 0; i < allPosts.size(); i++) {
                achievementManager.check(allPosts.get(i), i + 1);
            }

            achievementManager.saveAchievements();
            achievementManager.printAchievements();

            //Modul7
            System.out.println("\n==== FINAL SUMMARY ====");

            String summaryPath = "reports/summary.txt";
            try (java.io.PrintWriter printWriter = new java.io.PrintWriter(new java.io.FileWriter(summaryPath))) {
                printWriter.println(config.getUsername());
                printWriter.println("   " + config.getBio());
                printWriter.println();

                printWriter.println("Posts this session:");
                List<Post> sessionPosts = saver.getSavedPosts();
                for (Post post : sessionPosts) {
                    printWriter.println("   #" + post.getId() + "  [" + new java.util.Date(post.getTimestamp()) + "]  " + post.getText());
                }
                printWriter.println();

                printWriter.println("Achievements (total: " + achievementManager.getAchievements().size() + "):");
                for (IIP_homeworks.part4.homework_NelzyaGram.src.model.Achievement a : achievementManager.getAchievements()) {
                    printWriter.println("   " + a.getTitle());
                }
                printWriter.println();

                printWriter.println("Feed statistics:");
                printWriter.println("   Total posts: " + feedAggregator.getTotalPosts());
                printWriter.println("   Total likes: " + feedAggregator.getTotalLikes());
                printWriter.println("   Top author: " + feedAggregator.getTopAuthor() + " (" + feedAggregator.getTopAuthorLikes() + " likes)");
                printWriter.println();

                // Размер аватара
                java.io.File avatarBackup = new java.io.File("src/IIP_homeworks/part4/homework_NelzyaGram/data/avatar_backup.jpg");
                printWriter.println("Avatar backup size: " + avatarBackup.length() + " bytes");
                printWriter.println();

                // Последний снапшот
                java.io.File snapDir = new java.io.File("data/snapshots");
                java.io.File[] snaps = snapDir.listFiles();
                if (snaps != null && snaps.length > 0) {
                    java.io.File lastSnap = snaps[snaps.length - 1];
                    try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(lastSnap))) {
                        IIP_homeworks.part4.homework_NelzyaGram.src.model.UserProfile profile =
                                (IIP_homeworks.part4.homework_NelzyaGram.src.model.UserProfile) ois.readObject();
                        printWriter.println("Last snapshot:");
                        printWriter.println("   Total posts all time: " + profile.getPostsWritten());
                        printWriter.println("   Status: \"" + profile.getStatus() + "\"");
                        printWriter.println("   Time: " + new java.util.Date(profile.getLastActiveTimestamp()));
                    }
                }

                System.out.println("Summary saved to: " + summaryPath);
                System.out.println("Avatar backup size: " + avatarBackup.length() + " bytes");
            }


        } catch (Exception e){
            System.out.println("Critical error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
