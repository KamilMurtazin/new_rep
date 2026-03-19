package IIP_homeworks.homework2;

public class Main {
    public static void main(String[] args) {
        scenario1();
        scenario2();
        scenario3();
        scenario4();
        scenario5();
    }

    public static void scenario1() {
        System.out.println("=== СЦЕНАРИЙ 1 ===");
        ResearchHub<ResearchSample<Double>> sampleHub = new ResearchHub<>();
        System.out.println("Ошибка компиляции: нельзя добавить MedicalDevice в ResearchHub<ResearchSample<Double>>");
        System.out.println("Причина: типобезопасность дженериков\n");
    }

    public static void scenario2() {
        System.out.println("=== СЦЕНАРИЙ 2 ===");
        ResearchHub<LaboratoryItem> hub = new ResearchHub<>();
        hub.register(new ResearchSample<>("S001", 2, 100, "Вода", 0.95));
        hub.register(new MedicalDevices("D001", 1, 100, "Микроскоп", 0.01));
        hub.register(new ResearchSample<>("S002", 3, 100, "Этанол", 95));
        System.out.println("count = " + hub.getCount());
        hub.release(1);
        for (int i = 0; i < hub.getCount(); i++) System.out.println("Индекс " + i + ": " + hub.getStorage()[i]);
        System.out.println();
    }

    public static void scenario3() {
        System.out.println("=== СЦЕНАРИЙ 3 ===");
        ResearchHub<LaboratoryItem> hub = new ResearchHub<>();
        hub.register(new ResearchSample<>("S001", 1, 100, "Двойной", 0.5));
        hub.register(new ResearchSample<>("S002", 1, 100, "Целый", 50));
        hub.register(new ResearchSample<>("S003", 1, 100, "Дробь", new Fraction(1, 2)));
        hub.adjustPurity(10, 0.5);
        System.out.println("Средняя чистота = " + hub.getAveragePurity());
}

    public static void scenario4() {
        System.out.println("=== СЦЕНАРИЙ 4 ===");
        ResearchHub<LaboratoryItem> hub = new ResearchHub<>();
        ResearchSample<Double> s100 = new ResearchSample<>("S001", 1, 100, "Обр100", 0.5);
        MedicalDevices d100 = new MedicalDevices("D001", 1, 100, "Приб100", 0.1);
        ResearchSample<Double> s250 = new ResearchSample<>("S002", 1, 250, "Обр250", 0.5);
        MedicalDevices d250 = new MedicalDevices("D002", 1, 250, "Приб250", 0.1);
        System.out.println("ID=100: " + hub.checkSession(s100, 100) + ", " + hub.checkSession(d100, 100));
        System.out.println("ID=250: " + hub.checkSession(s250, 250) + ", " + hub.checkSession(d250, 250));
        System.out.println("Integer кэширует -128..127, поэтому == работает для 100, но не для 250\n");
    }

    public static void scenario5() {
        System.out.println("=== СЦЕНАРИЙ 5 ===");
        LaboratoryItem[] items = {
                new ResearchSample<>("S001", 2, null, "Обр1", 0.5),
                new MedicalDevices("D001", 9, null, "Приб1", 0.1),
                new ResearchSample<>("S002", 4, null, "Обр2", 0.8),
                new MedicalDevices("D002", 10, null, "Приб2", 0.01),
                new ResearchSample<>("S003", 3, null, "Обр3", 0.95)
        };
        System.out.println("Макс опасность: " + LabUtils.findMaxHazardLevel(items));
        ResearchHub<LaboratoryItem> hub = new ResearchHub<>();
        for (LaboratoryItem item : items) hub.register(item);
        hub.clearByHazardLevel(5);
        LabUtils.generateReport(hub);
        System.out.println("Сравнение типов: " + LabUtils.compareHubTypes(hub, new ResearchHub<ResearchSample<Double>>()) + "\n");//тут почему то выводит true. я если честно сам не понимаю почему не false выводит
    }
}
