public class TestMobilePhone {
	public static void main(String args[]) {
		MobilePhone mobilePhone = new MobilePhone();
		MobilePhone mobilePhone1 = new MobilePhone("Samsung", "S24", 512);
		MobilePhone mobilePhone2 = new MobilePhone("Apple Iphone", "13 pro", 128, 95, true);
		
		System.out.println(mobilePhone.displayInfo());
		System.out.println(mobilePhone.powerOn());
		System.out.println(mobilePhone.powerOff());
		System.out.println(mobilePhone.chargeBattery(23));
		System.out.println(mobilePhone.useBattery(60));
		System.out.println();
		
		System.out.println(mobilePhone1.displayInfo());
		System.out.println(mobilePhone1.powerOn());
		System.out.println(mobilePhone1.powerOff());
		System.out.println(mobilePhone1.chargeBattery(5));
		System.out.println(mobilePhone1.useBattery(120));
		System.out.println();
		
		System.out.println(mobilePhone2.displayInfo());
		System.out.println(mobilePhone2.powerOn());
		System.out.println(mobilePhone2.powerOff());
		System.out.println(mobilePhone2.chargeBattery(6));
		System.out.println(mobilePhone2.useBattery(100));
		System.out.println();
	}
}