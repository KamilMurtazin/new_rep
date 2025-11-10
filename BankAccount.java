public class BankAccount {
	
	private String accountNumber;
	private String ownerName;
	private double balance;
	private String currency;
	private boolean isActive;
	
	public BankAccount() {
		this("Unknown number of account", "Unknown owner", 0.0, "USD", false);
	}
	public BankAccount(String accountNumber, String ownerName) {
		this(accountNumber, ownerName, 0.0, "USD", true);
	}
	public BankAccount(String accountNumber, String ownerName, double balance, String currency, boolean isActive) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
		this.currency = currency;
		this.isActive = isActive;
	}
	
	public String displayInfo() {
		return accountNumber + " " + ownerName + " " + balance + " " + currency + " " + isActive;
	}
	public String deposit(double amount) {
		this.balance = balance + amount;
		return "The account was topped up in the amount of: " + amount + ". New balance:" + balance;
	}
	public String withdraw(double amount) {
		if (amount > balance) {
			return "You don't have enough cash";
		} else {
			this.balance = balance - amount;
			return "You get " + amount + " cash. Your current balance: " + balance;
		}
	}
	public String activateAccount() {
		if (!isActive) {
			this.isActive = true;
			return "You acctivate this account";
		} else {
			return "Your account already has been activated";
		}
	}
	public String deactivateAccount() {
		if (isActive) {
			this.isActive = false;
			return "You have blocked your account";
		} else {
			return "Your account already has been blocked";
		}
	}
}