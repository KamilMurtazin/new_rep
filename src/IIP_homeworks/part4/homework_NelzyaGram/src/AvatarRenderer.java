package IIP_homeworks.part4.homework_NelzyaGram.src;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class AvatarRenderer {
    private String avatarPath;
    private String backupPath;

    public AvatarRenderer(String avatarPath, String backupPath) {
        this.avatarPath = avatarPath;
        this.backupPath = backupPath;
    }

    public void render() throws IOException{
        try (FileReader reader = new FileReader(avatarPath)) {
            int ch;
            while ((ch = reader.read()) != -1){
                System.out.print((char) ch);
            }
        }
        System.out.println();

        copyByteByByte(avatarPath, backupPath);
    }

    private void copyByteByByte(String source, String dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            int oneByte;
            while ((oneByte = fis.read()) != -1){
                fos.write(oneByte);
            }
        }
        System.out.println("Avatar has been saved in backup: " + dest);
    }
}


