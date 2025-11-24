public class BankAccount {
	
	private String accountNumber;
	private String ownerName;
	private double balance;
	private String currency;
	private boolean isActive;
	
	private static int totalAccounts;
	private static final String BANK_NAME = "National Bank";
	
	public BankAccount() {
		this("Unknown number of account", "Unknown owner", 0.0, "USD", false);
	}
	public BankAccount(String accountNumber, String ownerName) {
		this(accountNumber, ownerName, 0.0, "USD", true);
	}
	public BankAccount(String accountNumber, String ownerName, double balance, String currency, boolean isActive) {
		setAccountNumber(accountNumber);
		setOwnerName(ownerName);
		setBalance(balance);
		setCurrency(currency);
		setActive(isActive);
		totalAccounts ++;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public double getBalance() {
		return balance;
	}
	public String getCurrency() {
		return currency;
	}
	public boolean isActive() {
		return isActive;
	}
	public static int getTotalAccounts() {
		return totalAccounts;
	}
	public static String getBankName() {
		return BANK_NAME;
	}
	
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setBalance(double balance) {
		if (balance >= 0 && balance <= 1000000000) {
			this.balance = balance;
		} else {
			System.out.println("Incorrect value");
		}
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setActive(boolean active) {
		this.isActive = active;
	}
	
	public static double calculateInterest(double amount, double rate, int years) {
		return amount * Math.pow(1 + rate / 100, years);
	}
	
	public String displayInfo() {
		return displayInfo(false);
	}
	public String displayInfo(boolean showStatus) {
		if (showStatus) {
		return "Bank: " + BANK_NAME + " | Account: " + accountNumber + " " + ownerName + " " + balance + " " + currency + " | Active " + isActive;
		} else {
			return "Account: " + accountNumber + " " + ownerName + " " + balance;
		}
	}
	public String deposit(double amount) {
		if (amount > 0 && isActive) {
			setBalance(this.balance + amount);
			return "The account was topped up in the amount of: " + amount + ". New balance:" + balance;
		} else if (!isActive) {
			return "Error: Cannot deposit to inactive account";
		} else {
			return "Error: Deposit amount must be positive";
		}
	}
	public String deposit(double amount, String description) {
		if (amount > 0 && isActive) {
			setBalance(this.balance + amount);
			return "The account was topped up in the amount of: " + amount + "| Description: " + description + ". New balance:" + balance;
		} else if (!isActive) {
			return "Error: Cannot deposit to inactive account";
		} else {
			return "Error: Deposit amount must be positive";
		}
	}
	
	public String withdraw(double amount) {
		if (amount <= balance && amount > 0 && isActive) {
			setBalance(balance - amount);
			return "You get " + amount + " cash. Your current balance: " + balance;
		} else if (!isActive) {
			return "Error: Cannot withdraw from inactive account";
		} else {
			return "You don't have enough cash";
		}
	}
	public String withdraw(double amount, String purpose) {
		if (amount <= balance && amount > 0 && isActive) {
			setBalance(balance - amount);
			return "You get " + amount + " cash | Purpose: " + purpose + ". Your current balance: " + balance;
		} else if (!isActive) {
			return "Error: Cannot withdraw from inactive account";
		} else {
			return "You don't have enough cash for: " + purpose;
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
	public static void displayBankInfo() {
        System.out.println("Bank: " + BANK_NAME);
        System.out.println("Total accounts created: " + totalAccounts);
    }
}