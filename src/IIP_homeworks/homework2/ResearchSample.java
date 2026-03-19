package IIP_homeworks.homework2;

public class ResearchSample<T extends Number> extends LaboratoryItem {
    private String materialName;
    private T purity;

    public ResearchSample(String serialnumber, int biohazardLevel, Integer sessionID, String materialName, T purity){
        super(serialnumber, biohazardLevel, sessionID);
        this.materialName = materialName;
        this.purity = purity;
    }

    public String getMaterialName() {
        return materialName;
    }
    public T getPurity() {
        return purity;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    public void setPurity(T purity) {
        this.purity = purity;
    }

    public void adjustPurity(Number offset, Number multiplier) {
        double currentValue = purity.doubleValue();
        double newValue = (currentValue + offset.doubleValue()) * multiplier.doubleValue();

        if (purity instanceof Integer) {
            purity = (T) Integer.valueOf((int) Math.round(newValue));
        } else if (purity instanceof Double) {
            purity = (T) Double.valueOf(newValue);
        } else if (purity instanceof Fraction) {
            Fraction result = new Fraction((int) Math.round(newValue * 1000), 1000);
            purity = (T) result;
        }
    }
    @Override
    public String toString() {
        return String.format("[ResearchSample] ID: %s | Имя: %s", serialNumber, materialName);
    }

}
