package AISD_homeworks.semestrovka1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Генерация наборов данных:\n");
        GenerateData.main(args);

        System.out.println("\nТестирование производительности:\n");
        TestRBTree.main(args);

        System.out.println("\nСистема заказов:\n");
        OrderSystem system = new OrderSystem();

        int id1 = system.addOrder("Иван", "Ноутбук");
        int id2 = system.addOrder("Динар", "Мышка");
        int id3 = system.addOrder("Максон", "Клавиатура");

        System.out.println(system.findOrder(id1));
        System.out.println(system.findOrder(id2));
        System.out.println(system.findOrder(id3));

        system.removeOrder(id2);

        System.out.println("\nПосле удаления:");
        System.out.println(system.findOrder(id1));
        System.out.println(system.findOrder(id2));
        System.out.println(system.findOrder(id3));

        System.out.println("\nВсего заказов: " + system.size());
    }
}