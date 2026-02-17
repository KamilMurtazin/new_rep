public class MobilePhone {
	
	private String brand;
	private String model;
	private int storageGB;
	private int batteryLevel;
	private boolean isPower;
	
	private static int totalPhones = 0;
	private static final int MAX_BATTERY = 100;
	
	public MobilePhone() {
		this("Apple Iphone", "Unknown model", 256, 100, false);
	}
	public MobilePhone(String brand, String model, int storageGB) {
		this(brand, model, storageGB, 90, true);
	}
	public MobilePhone(String brand, String model, int storageGB, int batteryLevel, boolean isPower) {
		setBrand(brand);
		setModel(model);
		setStorageGB(storageGB);
		setBatteryLevel(batteryLevel);
		setPower(isPower);
		totalPhones ++;
	}
	
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public int getStorageGB() {
		return storageGB;
	}
	public int getBatteryLevel() {
		return batteryLevel;
	}
	public boolean isPower() {
		return isPower;
	}
	public static int getTotalPhones() {
		return totalPhones;
	}
	public static int getMaxBattery() {
		return MAX_BATTERY;
	}
	
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setStorageGB(int storageGB) {
		if (storageGB > 0) {
			this.storageGB = storageGB;
		} else {
			System.out.println("Incorrect storage value (GB)");
		}
	}
	public void setBatteryLevel(int batteryLevel) {
		if (batteryLevel >= 0 && batteryLevel <= 100) {
			this.batteryLevel = batteryLevel;
		} else {
			System.out.println("Incorrect battery level");
		}
	}
	public void setPower(boolean power) {
		this.isPower = power;
	}
	
	
	public String displayInfo() {
		return displayInfo(false);
	}
	public String displayInfo(boolean showPowerStatus) {
		if (showPowerStatus) {
			return "Phone: " + brand + " " + model + " " + storageGB + " GB. Battery level: " + batteryLevel + ". Is Powered on: " + isPower;
		} else {
			return "Phone: " + brand + " " + model + " " + storageGB;
		}
	}
	
	public String powerOn() {
		if (!isPower) {
			this.isPower = true;
			return "You activated phone";
		} else {
			return "Your phone already has been activated";
		}
	}
	public String powerOff() {
		if (isPower) {
			this.isPower = false;
			return "You turned off the phone";
		} else {
			return "Your phone already has been turned off";
		}
	}
	public String chargeBattery(int percent) {
		if (batteryLevel + percent > 100) {
			setBatteryLevel(100);
			return "Your phone fully charged";
		} else {
			setBatteryLevel(batteryLevel + percent);
			return "Your phone not fully charged. Current battery level: " +  batteryLevel;
		}
	}
	public String chargeBattery(int percent, int minutes) {
		if (batteryLevel + percent > 100) {
			setBatteryLevel(100);
			return "Your phone fully charged. Time of charging: " + minutes + " minutes";
		} else {
			setBatteryLevel(batteryLevel + percent);
			return "Your phone not fully charged. Current battery level: " +  batteryLevel + ". Time of charging: " + minutes + " minutes";
		}
	}
	
	public String useBattery(int percent) {
		if (percent <= 0) {
			return "Usage percentage must be positive";
		}
		if (batteryLevel - percent < 0) {
			int difference = percent - batteryLevel;
			setBatteryLevel(0);
			return "Your phone fully discharged. You can't spend " + difference + " percents";
		} else {
			setBatteryLevel(batteryLevel - percent);
			return "Current battery level: " +  batteryLevel;
		}
	}
	public String useBattery(int percent, String appName) {
		if (percent <= 0) {
			return "Usage percentage must be positive";
		}
		if (batteryLevel - percent < 0) {
			int difference = percent - batteryLevel;
			setBatteryLevel(0);
			return "Your phone fully discharged. You can't spend " + difference + " percents. You use phone for " + appName;
		} else {
			setBatteryLevel(batteryLevel - percent);
			return "Current battery level: " +  batteryLevel + ". You use phone for " + appName;
		}
	}
	
	public static void displayTechSupport() {
		System.out.println("=== Technical Support ===");
		System.out.println("Tech support: +7 (917) 891-19-95");
		System.out.println("Email: kamilmurtazin87788@gmail.com");
		System.out.println("Hours: 24/7");
        System.out.println("Total phones in system: " + totalPhones);
	}
}