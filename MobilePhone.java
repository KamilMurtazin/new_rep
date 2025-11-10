public class MobilePhone {
	
	private String brand;
	private String model;
	private int storageGB;
	private int batteryLevel;
	private boolean isPower;
	
	public MobilePhone() {
		this("Apple Iphone", "Unknown model", 256, 100, false);
	}
	public MobilePhone(String brand, String model, int storageGB) {
		this(brand, model, storageGB, 90, true);
	}
	public MobilePhone(String brand, String model, int storageGB, int batteryLevel, boolean isPower) {
		this.brand = brand;
		this.model = model;
		this.storageGB = storageGB;
		this.batteryLevel = batteryLevel;
		this.isPower = isPower;
	}
	
	public String displayInfo() {
		return brand + " " + model + " " + storageGB + " " + batteryLevel + " " + isPower;
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
			this.batteryLevel = 100;
			return "Your phone fully charged";
		} else {
			this.batteryLevel = batteryLevel + percent;
			return "Your phone not fully charged. Current battery level: " +  batteryLevel;
		}
	}
	public String useBattery(int percent) {
		if (batteryLevel - percent < 0) {
			int difference = percent - batteryLevel;
			this.batteryLevel = 0;
			return "Your phone fully discharged. You can't spend " + difference + " percents";
		} else {
			this.batteryLevel = batteryLevel - percent;
			return "Current battery level: " +  batteryLevel;
		}
	}
}