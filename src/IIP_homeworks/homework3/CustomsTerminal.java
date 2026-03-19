package IIP_homeworks.homework3;

public class CustomsTerminal {

    public static void inspectCargo(CargoBay<? extends Cargo> bay){
        Object[] objects = bay.getAll();
        for (int i = 0; i < bay.getSize(); i++){
            Cargo item = (Cargo) objects[i];
            System.out.println(item.getName());
        }
    }

    public static void loadHumanitarianApples(CargoBay<? super Fruit> bay){
        bay.add(new Fruit("Apple"));
    }

    public static <T> void transferCargo(CargoBay<? extends T> source, CargoBay<T> destination){
        Object[] objects = source.getAll();
        for (int i = 0; i < source.getSize(); i ++){
            T item = (T) objects[i];
            destination.add(item);
        }
    }
}
