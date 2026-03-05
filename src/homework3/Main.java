package homework3;

public class Main {
    public static void main(String[] args) {
        // 1. Создаем отсеки
        CargoBay<Phone> phoneBay = new CargoBay<>(10);
        phoneBay.add(new Phone("iPhone 15"));
        phoneBay.add(new Phone("Samsung S24"));

        CargoBay<Electronics> electronicsBay = new CargoBay<>(10);
        CargoBay<Cargo> generalCargoBay = new CargoBay<>(20);
        CargoBay<Food> foodBay = new CargoBay<>(10);

        // ==========================================
        // ПРОВЕРКА 1: inspectCargo (Producer Extends)
        // ==========================================
        // Должно работать для любых типов, наследующих Cargo
        CustomsTerminal.inspectCargo(phoneBay);
        CustomsTerminal.inspectCargo(foodBay);

        // ==========================================
        // ПРОВЕРКА 2: loadHumanitarianApples (Consumer Super)
        // ==========================================
        // Мы можем положить фрукты в отсек для еды и в общий отсек
        CustomsTerminal.loadHumanitarianApples(foodBay);
        CustomsTerminal.loadHumanitarianApples(generalCargoBay);

        // РАСКОММЕНТИРУЙТЕ СТРОКУ НИЖЕ — ОНА ДОЛЖНА ВЫДАВАТЬ ОШИБКУ КОМПИЛЯЦИИ!

                // CustomsTerminal.loadHumanitarianApples(electronicsBay);
// Ошибка: Электроника не может хранить яблоки

                // ==========================================
                // ПРОВЕРКА 3: transferCargo (PECS в чистом виде)
                // ==========================================
                // Перегружаем телефоны в отсек для электроники
                CustomsTerminal.transferCargo(phoneBay, electronicsBay);

        // Перегружаем ВСЮ электронику в общий грузовой отсек
        CustomsTerminal.transferCargo(electronicsBay,
                generalCargoBay);

        // РАСКОММЕНТИРУЙТЕ СТРОКУ НИЖЕ — ОНА ДОЛЖНА ВЫДАВАТЬ ОШИБКУ КОМПИЛЯЦИИ!
                // CustomsTerminal.transferCargo(foodBay, electronicsBay);
// Ошибка: Нельзя еду выгрузить к электронике

                System.out.println("Если код скомпилировался и вывел это сообщение — вы стали мастером Wildcards и PECS!");
    }
}
