package IIP_homeworks.part4.homework_NelzyaGram.src;

import IIP_homeworks.part4.homework_NelzyaGram.src.model.Achievement;
import IIP_homeworks.part4.homework_NelzyaGram.src.model.Post;
import java.io.*;
import java.util.*;

public class AchievementManager {
    private List<Achievement> achievements;
    private String savePath;
    private int postsThisSession;

    public AchievementManager(String savePath) {
        this.savePath = savePath;
        this.achievements = new ArrayList<>();
        this.postsThisSession = 0;
        loadAchievements();
    }

    @SuppressWarnings("unchecked")
    private void loadAchievements() {
        File file = new File(savePath);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            achievements = (List<Achievement>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Ошибка загрузки: " + e.getMessage());
        }
    }

    public void saveAchievements() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savePath))) {
            oos.writeObject(achievements);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    public void check(Post post, int totalPostsAllTime) {
        postsThisSession++;

        // Первый пост
        if (totalPostsAllTime == 1) {
            addAchievement("Первый пост", "Написан первый пост");
        }

        // Пять из пяти
        if (postsThisSession == 5) {
            addAchievement("Пять из пяти", "Написано 5 постов за сессию");
        }

        // 3. Многословный (пост длиннее 100 символов)
        if (post.getText().length() > 100) {
            addAchievement("Многословный", "Пост длиннее 100 символов");
        }

        // 4. Ночной кодер (с 23:00 до 4:00)
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(post.getTimestamp());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 23 || hour < 4) {
            addAchievement("Ночной кодер", "Пост написан с 23:00 до 4:00");
        }
    }

    private void addAchievement(String title, String description) {
        for (Achievement a : achievements) {
            if (a.getTitle().equals(title)) return;
        }
        achievements.add(new Achievement("🏆", title, description, System.currentTimeMillis()));
        System.out.println("\n New achieve: " + title + "!\n");
    }

    public void printAchievements() {
        if (achievements.isEmpty()) {
            System.out.println("Achieves (0):");
        } else {
            System.out.println("\nAchieves (" + achievements.size() + "/4):");
            for (Achievement a : achievements) {
                System.out.println("   " + a.getTitle());
            }
        }
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}
