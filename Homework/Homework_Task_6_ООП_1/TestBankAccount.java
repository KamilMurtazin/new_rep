public class TestBankAccount {
	public static void main(String args[]) {
		BankAccount bankAccount = new BankAccount();
		BankAccount bankAccount1 = new BankAccount("1234567890", "John Pork");
		BankAccount bankAccount2 = new BankAccount("666777666777", "Tony Stark", 7890.15, "EUR", false);
		
		
		System.out.println(bankAccount1.displayInfo());
		System.out.println(bankAccount1.deposit(1053));
		System.out.println(bankAccount1.deposit(1785, "Salary"));
		System.out.println(bankAccount1.withdraw(153));
		System.out.println(bankAccount1.withdraw(365, "Shopping"));
		System.out.println(bankAccount1.activateAccount());
		System.out.println(bankAccount1.deactivateAccount());
		System.out.println();
		
		System.out.println(bankAccount2.displayInfo(true));
		System.out.println(bankAccount2.deposit(109.85));
		System.out.println(bankAccount2.withdraw(2700));
		System.out.println(bankAccount2.activateAccount());
		System.out.println(bankAccount2.deactivateAccount());
		System.out.println();
		
		double interest = BankAccount.calculateInterest(1000, 5, 3);
        System.out.println("Compound interest: " + interest);
        
        BankAccount.displayBankInfo();
	}
}
		