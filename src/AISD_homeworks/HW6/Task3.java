package AISD_homeworks.HW6;

public class Task3 {
    public static void main(String[] args) {
        String name = "Hello my name is Havrick";
        String newWord = "";
        String now = "";
        for(int i = 0; i < name.length() ; i++){
            now += name.charAt(i);
            if(name.charAt(i) == ' '){
                newWord = now + newWord;
                now = "";
            }
            if(i == name.length() - 1){
                newWord = now + " " + newWord;
                now = "";
            }

        }
        System.out.println(newWord);
    }
}
