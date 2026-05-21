package IIP_homeworks.part4.homework_NelzyaGram.src;

import java.io.*;
import java.util.*;

public class FeedAggregator implements Runnable{
    private String file1;
    private String file2;

    private int totalPosts;
    private long totalLikes;
    private long totalReposts;
    private String topAuthor;
    private int topAuthorLikes;
    private Map<String, Integer> authorLikes;

    public FeedAggregator(String file1, String file2) {
        this.file1 = file1;
        this.file2 = file2;
        this.authorLikes = new HashMap<>();
    }

    public int getTotalPosts() { return totalPosts; }
    public long getTotalLikes() { return totalLikes; }
    public long getTotalReposts() { return totalReposts; }
    public String getTopAuthor() { return topAuthor; }
    public int getTopAuthorLikes() { return topAuthorLikes; }
    public Map<String, Integer> getAuthorLikes() { return authorLikes; }

    @Override
    public void run() {
        System.out.println("FeedAggregator is running");

        readFile(file1);
        readFile(file2);

        findTopAuthors();
        System.out.println("FeedAggregator has completed the analysis");
    }

    private void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String author = parts[0];
                    int likes = Integer.parseInt(parts[2]);
                    int reposts = Integer.parseInt(parts[3]);

                    totalPosts++;
                    totalLikes += likes;
                    totalReposts += reposts;
                    authorLikes.put(author, authorLikes.getOrDefault(author, 0) + likes);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void findTopAuthors() {
        // Сортируем по лайкам
        List<Map.Entry<String, Integer>> list = new ArrayList<>(authorLikes.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        if (!list.isEmpty()) {
            topAuthor = list.get(0).getKey();
            topAuthorLikes = list.get(0).getValue();
        }
    }
}
