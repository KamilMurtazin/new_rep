package IIP_homeworks.part4.homework_NelzyaGram.src.model;

public class AppConfig {
    private String username;
    private int maxPosts;
    private String bio;
    private char asciiChar;

    public AppConfig(String username, int maxPosts, String bio, char asciiChar) {
        this.username = username;
        this.maxPosts = maxPosts;
        this.bio = bio;
        this.asciiChar = asciiChar;
    }

    public String getUsername() {
        return username;
    }

    public int getMaxPosts() {
        return maxPosts;
    }

    public String getBio() {
        return bio;
    }

    public char getAsciiChar() {
        return asciiChar;
    }

    @Override
    public String toString(){
        return "AppConfig{" +
                "username=" + username + '\'' +
                ", maxPosts=" + maxPosts +
                ", bio='" + bio + '\'' +
                ", asciiChar=" + asciiChar +
                '}';
    }
}
