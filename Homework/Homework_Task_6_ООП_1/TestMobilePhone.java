public class TestMobilePhone {
	public static void main(String args[]) {
		MobilePhone mobilePhone = new MobilePhone();
		MobilePhone mobilePhone1 = new MobilePhone("Samsung", "S24", 512);
		MobilePhone mobilePhone2 = new MobilePhone("Apple Iphone", "13 pro", 128, 95, true);
		
		System.out.println(mobilePhone1.displayInfo(true));
		System.out.println(mobilePhone1.powerOn());
		System.out.println(mobilePhone1.powerOff());
		System.out.println(mobilePhone1.chargeBattery(5, 8));
		System.out.println(mobilePhone1.useBattery(120));
		System.out.println();
		
		System.out.println(mobilePhone2.displayInfo());
		System.out.println(mobilePhone2.powerOn());
		System.out.println(mobilePhone2.powerOff());
		System.out.println(mobilePhone2.chargeBattery(6));
		System.out.println(mobilePhone2.useBattery(100, "Gaming"));
		System.out.println();
		
		MobilePhone.displayTechSupport();
        System.out.println("Total phones created: " + MobilePhone.getTotalPhones());
	}
}