import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Введите строку:");
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    boolean qwe = true;
    while (qwe == true) {
      System.out.println("Выберите действие:");
      System.out.println("1. Найти подстроку");
      System.out.println("2. Заменить подстроку");
      System.out.println("3. Разбить строку на слова");
      System.out.println("4. Объединить слова в строку");
      System.out.println("0. Выход");
      int task = scan.nextInt();
      scan.nextLine();
      if (task == 1) {
        System.out.println("Введите подстроку:");
        String podstr = scan.nextLine();
        int pos = -10000000;
        for (int i = 0; i <= str.length() - podstr.length(); i++) {
          boolean f = true;
          for (int j = 0; j < podstr.length(); j++) {
            char charN = str.charAt(i + j);
            char charT = podstr.charAt(j);
            if (charN != charT) {
              f = false;
              break;
            }
          }
          if (f == true) {
            pos = i;
            break;
          }
        }
        if (pos > 0) {
          System.out.println("Позиция: " + pos);
        } else {
          System.out.println("Нет такой подстроки");
        }
      }
      
      if (task == 2) {
        System.out.println("Введите подстроку, которую хотите заменить:");
        String oldstr = scan.nextLine();
        System.out.println("Введите новую подстроку:");
        String newstr = scan.nextLine();
        String res = "";
        int i = 0;
        while (i < str.length()) {
          boolean f = true;
          if (str.length() - i < oldstr.length()) {
            f = false;
          } else {
            for (int j = 0; j < oldstr.length(); j++) {
              if (str.charAt(i + j) != oldstr.charAt(j)) {
                f = false;
                break;
              }
            }
          }
          if (f == false) {
            res = res + str.charAt(i);
            i++;
          } else {
            res = res + newstr;
            i += oldstr.length();
          }
        }
        System.out.println("Результат: " + res);
      }
      
      if (task == 3) {
        System.out.println("Слова:");
        for (int i = 0; i < str.length(); i++) {
          char c = str.charAt(i);
          if (c != ' ') {
            System.out.print(c);
          } else {
            System.out.println();
          }
        }
      }
      
      if (task == 4) {
        System.out.println("Результат:");
        for (int i = 0; i < str.length(); i++) {
          char c = str.charAt(i);
          if (c != ' ') {
            System.out.print(c);
          } else {
            System.out.print(", ");
          }
        }
      }
      
      if (task == 0) {
        qwe = false;
      }
      System.out.println();
      System.out.println();
    }
  }
}