package banking;

public class BankAccountApp {

	public static void main(String[] args) {
		BankAccount acc1 = new BankAccount("456821596", 1000);		
		acc1.setName("Pachee Lee");
		acc1.payBill(500);
		acc1.makeDeposit(2500);
	}

}

class BankAccount implements IInterest{
	private static int id = 1000;
	private String accountNumber; // id+2-digit number + first 2 digits of SSN
	private static final String routingNumber = "002851200";
	private String name;
	private String SSN;
	private double balance;
	
	// Constructors
	
	public BankAccount(String SSN, double initDeposit){
		System.out.println("New account Created");
		id++;
		this.SSN = SSN;
		setAccountNumber();
		balance = initDeposit;
	}
	
	private void setAccountNumber(){
		int random = (int) Math.random()*100;
		accountNumber = id + "" + random + SSN.substring(0,2);
		System.out.println("Your Account Number: "+ accountNumber);
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void payBill(double amount){
		balance = balance - amount;
		showBalance();
	}
	public void makeDeposit(double amount){
		balance = balance + amount;
		showBalance();
	}
	public void showBalance(){
		System.out.println("Current Balance: "+ balance);
	}
	@Override
	public void accrue(){
		balance = balance * (1+rate/100);
	}
}