import java.util.*;
import java.io.*;
class Main{
	public static void main(String[] args)throws FileNotFoundException{
		Bank bank = new Bank();
		int exit=1;
		bank.reader();
		//raed a file 
		while(exit == 1){
			System.out.println("1)Open an account");
			System.out.println("2)Show all accounts");
			System.out.println("3)Search an account with owner");
			System.out.println("4)Search an account with account number");
			System.out.println("5)Group search");
			System.out.println("6)Deposit");
			System.out.println("7)Withdraw");
			System.out.println("8)Deposit and withdraw for another account");
			System.out.println("9)Exit");
			System.out.print("Please Enter your choice!");
			//show menu
			Scanner choice = new Scanner(System.in);
			switch(choice.nextInt()){
				case 1 :
					bank.openAccount();
					break;
				case 2 :
					bank.showList();
					break;
				case 3 :
					bank.Ownersearch();
					break;
				case 4 :
					bank.AccountNumberSearch();
					break;
				case 5 :
					bank.groupSearch();
					break;
				case 6 :
					bank.deposit();
					break;
				case 7 :
					bank.withdraw();
					break;
				case 8 :
					bank.depositAndWithdraw();
					break;
				case 9 :
					exit=0;
					bank.writer();
					System.out.println("See you Later!");
					break;
			}
		}
	}
}