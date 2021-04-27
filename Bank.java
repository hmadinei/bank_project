import java.util.*;
import java.io.*;
class Bank{
	Account[] accounts = new Account[100];
	//create an array of account
	int count=0 , flag=0;
	public void reader(){
		try{
			for (int i=0 ; i < 100 ; i++){
				accounts[i] = new Account("owner",0,0);			
			}
			//fill array
			FileReader reader = new FileReader("accounts.txt");
			Scanner input = new Scanner(reader);
			int k = 0;
			while(input.hasNextLine()){			
				String owner = input.nextLine();
				String balance = input.nextLine();
				String accountNumber = input.nextLine();
				Account acc = new Account(owner,Integer.parseInt(balance),Integer.parseInt(accountNumber));
				accounts[k++] = acc;
				count++;
				//count an account
			}
			//reading File line by line 
			input.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("File Not Found!");
		}
	}
	public void openAccount(){		
		System.out.println("Welcome!" + "\n" + "Please Enter your Name");
		Scanner owner = new Scanner(System.in);
		Random rand = new Random();
		accounts[count++] = new Account(owner.nextLine(),0,rand.nextInt(100));
		System.out.println("You successfully sign in!");
		System.out.println("Your account number is " + accounts[--count].getAccountNumber());
		count++;
		//creating an account for each person
	}
	public void showList(){
		for (int i=0 ; i < count ; i++){
			if(!accounts[i].getOwner().equals("owner")){
				accounts[i].printInfo();
			}
		}
		//show the list of account 
	}
	public void Ownersearch(){
		System.out.println("Enter your Name for searching!");
		//getting a specific name
		Scanner name = new Scanner(System.in);
		String nameSearch = name.nextLine();
		for(int i=0 ; i < count ; i++){
			if(accounts[i].getOwner().equals(nameSearch)){
			//find the name in the list of account
				accounts[i].printInfo();
				//show its information
				flag = 1;
				break;
			}
		}
		if(flag == 0){
			System.out.println("Your account Not Found!");
		} 
		else {
			flag = 0;
		}
	}
	public void AccountNumberSearch(){
		System.out.println("Enter your account number for searching!");
		//getting a specific account number
		Scanner accountNum = new Scanner(System.in);
		int accountNumSearch = accountNum.nextInt();
		for(int i=0 ; i < count ; i++ ){
		//find the account number in the list of account
			if ( accountNumSearch == accounts[i].getAccountNumber()){
				accounts[i].printInfo();
				//show its information
				flag = 1;
				break;
			}
		}
		if(flag == 0){
			System.out.println("Your account number Not Found!");
		} 
		else {
			flag = 0 ;
		}
	}
	public void groupSearch(){
		System.out.println("Enter the amount of balance that some person has more!");
		Scanner amount = new Scanner(System.in);
		int amo = amount.nextInt();
		//getting amount of balance that some person has more
		for (int i=0 ; i < count ; i++){
		//find a person
			if (amo < accounts[i].getBalance()){
				accounts[i].printInfo();
				//show its information
				flag = 1;
			}
		}
		if(flag == 0){
			System.out.println("Nobody has more than " + amo + "!");
		} 
		else {
			flag = 0 ;
		}
	}
	public void deposit(){
		System.out.println("Enter your Name for depositing!");
		Scanner ownerDeposit = new Scanner(System.in);
		String x = ownerDeposit.nextLine();
		for(int i=0 ; i < count ; i++ ){
		//search for person who want to deposit
			if (x.equals(accounts[i].getOwner())){
				System.out.println("Enter The amount of deposit to your bankaccount!");
				Scanner amountDeposit = new Scanner(System.in);
				accounts[i].deposit(amountDeposit.nextInt());
				//enter the amount of deposit and depositing is done
				System.out.println("You successfully Deposit!");
				flag = 1;
				break;
			}
		}
		if(flag == 0){
			System.out.println("Your Name Is Not Sing in!");
		} 
		else {
			flag = 0 ;
		}
	}
	public void withdraw(){
		System.out.println("Enter your Name for withdrawing!");
		Scanner ownerWithdraw = new Scanner(System.in);
		String y = ownerWithdraw.nextLine();
		for(int i=0 ; i < count ; i++){
		//search for person who want to withdraw
			if (y.equals(accounts[i].getOwner())){
				System.out.println("Enter The amount of withdraw from your bankaccount!");
				Scanner amountWithdraw = new Scanner(System.in);
				accounts[i].withdraw(amountWithdraw.nextInt());
				//enter the amount of withdraw and withdrawing is done
				flag = 1;
				break;
			}
		}
		if(flag == 0){
			System.out.println("Your Name Is Not Sing in!");
		} 
		else {
			flag = 0 ;
		}
	}
	public void depositAndWithdraw(){
		System.out.println("Enter the Name for depositing!");
		//First getting the name of person who want to deposit
		Scanner ownerDeposit = new Scanner(System.in);
		String x = ownerDeposit.nextLine();
		for(int i=0 ; i < count ; i++ ){
		//search for the name of person who want to deposit
			if (x.equals(accounts[i].getOwner())){
			//find Firs person
				System.out.println("Enter the Name for withdrawing!");
				//Second getting the name of person who want to withdraw
				Scanner ownerWithdraw = new Scanner(System.in);
				String y = ownerWithdraw.nextLine();
				for(int j=0 ; j < count ; j++){
				//search for the name of person who want to withdraw
					if (y.equals(accounts[j].getOwner())){
					//find Second person
						System.out.println("Enter The amount of money to deposit and withdraw!");
						Scanner amountMoney = new Scanner(System.in);
						int amou = amountMoney.nextInt();
						accounts[i].deposit(amou);
						accounts[j].withdraw(amou);
						break;
					}
				}
			}
		}
	}
	public void writer(){ 
		try{
			PrintWriter output = new PrintWriter("accounts.txt");
			for (int i=0 ; i < count ; i++){
				output.println(accounts[i].getOwner());
				output.println(accounts[i].getBalance());
				output.println(accounts[i].getAccountNumber());
				//each information of person write in one line
			}
			output.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("File Not Found!");
		}
	}
}