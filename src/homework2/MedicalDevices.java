package homework2;

public class MedicalDevices extends LaboratoryItem{
    private String deviceName;
    private double precision;

    public MedicalDevices(String serialNumber, int biohazardLevel, Integer sessionID, String deviceName, double precision) {
        super(serialNumber, biohazardLevel, sessionID);
        this.deviceName = deviceName;
        this.precision = precision;
    }

    public String getDeviceName() {
        return deviceName;
    }
    public double getPrecision() {
        return precision;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public void setPrecision(double precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return String.format("[MedicalDevice] ID: %s | Имя: %s", serialNumber, deviceName);
    }
}
