package IIP_homeworks.part4.homework_NelzyaGram.src.model;

import java.io.Serializable;

public class Achievement implements Serializable {
    private static final long serialVersionUID = 1L;

    private String emoji;
    private String title;
    private String description;
    private long unlockedAt;

    public Achievement(String emoji, String title, String description, long unlockedAt) {
        this.emoji = emoji;
        this.title = title;
        this.description = description;
        this.unlockedAt = unlockedAt;
    }

    public String getEmoji() { return emoji; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public long getUnlockedAt() { return unlockedAt; }

    @Override
    public String toString() {
        return emoji + " " + title + " - " + description;
    }
}