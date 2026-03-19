package IIP_homeworks.homework5;
import IIP_homeworks.homework5.CW.MyHashSet;

import java.util.Random;

public class Generator {
    private static final String CHARACTERS = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789";
    private static final int STRING_LENGTH = 10;
    private static final Random random = new Random();

    private static String generateRandomString(){
        StringBuilder sb = new StringBuilder(STRING_LENGTH);
        for (int i = 0; i < STRING_LENGTH; i++){
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static String[] generateWithDuplicate(int size){
        MyHashSet<String> uniqueStrings = new MyHashSet<>();
        String[] result = new String[size];

        for (int i = 0; i < size - 1; i++){
            String str = generateRandomString();

            while (uniqueStrings.contains(str)){
                str = generateRandomString();
            }
            uniqueStrings.add(str);
            result[i] = str;
        }

        int duplicateIndex = random.nextInt(size / 2);
        String duplicate = result[duplicateIndex];
        result[size - 1] = duplicate;

        return result;
    }
}
