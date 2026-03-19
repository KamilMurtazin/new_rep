package IIP_homeworks.homework2;

public abstract class LaboratoryItem {
    protected String serialNumber;
    protected int biohazardLevel;
    protected Integer sessionID;

    public LaboratoryItem(String serialNumber, int biohazardLevel, Integer sessionID){
        this.serialNumber = serialNumber;
        if (biohazardLevel >= 0 && biohazardLevel <= 10) {
            this.biohazardLevel = biohazardLevel;
        } else {
            System.out.println("Incorrect level!");
        }
        this.sessionID = sessionID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public int getBiohazardLevel() {
        return biohazardLevel;
    }
    public Integer getSessionID() {
        return sessionID;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public void setBiohazardLevel(int biohazardLevel) {
        this.biohazardLevel = biohazardLevel;
    }
    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }
}
