package IIP_homeworks.part4.homework_NelzyaGram.src.model;

import java.io.Serializable;

public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private long timestamp;
    private String text;

    public Post(int id, long timestamp, String text) {
        this.id = id;
        this.timestamp = timestamp;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString(){
        return "Post #" + id + " [" + timestamp + "] " + text;
    }
}