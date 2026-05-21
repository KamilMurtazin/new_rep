package IIP_homeworks.part4.homework_NelzyaGram.src;

import IIP_homeworks.part4.homework_NelzyaGram.src.model.AppConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigReader {
    private String filePath;

    public ConfigReader(String filePath) {
        this.filePath = filePath;
    }

    public AppConfig read() throws IOException {
        String username = "";
        int maxPosts = 5;
        String bio = "";
        char asciiChar = '@';

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))){
            String line;
            while ((line = reader.readLine())  != null){
                if (line.trim().isEmpty() || line.trim().startsWith("#")){
                    continue;
                }

                String[] parts = line.split("=", 2);
                if (parts.length == 2){
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key){
                        case "username":
                            username = value;
                            break;
                        case "maxPosts":
                            maxPosts = Integer.parseInt(value);
                            break;
                        case "bio":
                            bio = value;
                            break;
                        case "asciiChar":
                            asciiChar = value.charAt(0);
                            break;
                    }
                }
            }
        }

        return new AppConfig(username, maxPosts, bio, asciiChar);
    }
}
