class Account{
	private String owner;
	private int balance;
	private int accountNumber;
	
	public Account(String owner,int balance, int accountNumber){
		this.owner = owner ;
		this.balance = balance ;
		this.accountNumber = accountNumber ;
		
	}
	public void deposit(int amount){
		balance += amount;
	}
	public void withdraw(int amount){
		if (amount < balance){
			balance -= amount;
		}
		else{
			System.out.print("Your balance not enough!");
		}
	}
	public void printInfo(){
		System.out.println("Owner" + " : " + owner);
		System.out.println("balance" + " : " + balance);
		System.out.println("accountNumber" + " : " + accountNumber);
		//print all information
	}
	public String getOwner(){
		return owner;
		//getter method
	}
	public int getAccountNumber(){
		return accountNumber;
		//getter method
	}
	public int getBalance(){
		return balance;
		//getter method
	}
	
}