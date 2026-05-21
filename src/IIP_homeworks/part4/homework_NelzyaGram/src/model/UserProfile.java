package IIP_homeworks.part4.homework_NelzyaGram.src.model;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private static final long serialVersionUID= 1L;

    private String username;
    private int postsWritten;
    private long lastActiveTimestamp;
    private String status;

    public UserProfile(String username, int postsWritten, long lastActiveTimestamp, String status) {
        this.username = username;
        this.postsWritten = postsWritten;
        this.lastActiveTimestamp = lastActiveTimestamp;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public int getPostsWritten() {
        return postsWritten;
    }

    public long getLastActiveTimestamp() {
        return lastActiveTimestamp;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return username + " | posts: " + postsWritten +
                " | status: " + status +
                " | time: " + lastActiveTimestamp;
    }
}
