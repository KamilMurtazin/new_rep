package IIP_homeworks.homework2;

public class LabUtils {

    public static LaboratoryItem findMaxHazardLevel(LaboratoryItem[] items){
        if (items == null || items.length == 0){
            return null;
        }
        LaboratoryItem max = items[0];
        for (int i = 1; i < items.length; i ++){
            if (items[i].getBiohazardLevel() > max.getBiohazardLevel()) {
                max = items[i];
            }
        }
        return max;
    }

    public static boolean compareHubTypes(ResearchHub<?> hub1, ResearchHub<?> hub2){
        return hub1.getClass().equals(hub2.getClass());
    }

    public static void generateReport(ResearchHub<?> hub) {
        for (int i = 0; i < hub.getCount(); i++) {
            System.out.println(hub.getStorage()[i]);
        }
    }

    public static void toStr(ResearchHub<?> hub){
        LaboratoryItem[] items = hub.getStorage();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }
}
