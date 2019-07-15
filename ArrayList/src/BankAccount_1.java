
abstract public class BankAccount_1 {
	protected static  int accountid=0 ;
	protected final int accountno ;
	protected double balance=0;
	//private String name ;
	//private Address add;
	protected final Person_1 person;
	/*private final AccountType accType;
	public enum AccountType{
		SAVING_ACCOUNT,
		CURRENT_ACCOUNT,
		SALARY_ACCOUNT
	}*/
	public  BankAccount_1(Person_1 person)
	{
		accountid++;
		this.accountno=accountid;
		this.person=person;
		//this.accType = accType;
		
	}
	

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public  int getAccountno() {
		return accountno;
	}
	
	abstract public void deposit(double amount);// {
		//balance+=amount;
	//}

	abstract public double  withdraw(double amount);//{
//		if(MIN_ACCOUNT_BALANCE>(balance-amount)) {
//			System.out.println("Insufficient Balance");
//			return -1;
//		}
//		else {
//		balance-=amount;
//		return amount;
//		}
		//return 0;
	//}


	public Person_1 getPerson() {
		return person;
	}


	/*public AccountType getAccType() {
		return accType;
	}*/
	
	@Override
	public String toString() {
		return  "AccountNo: "+accountno + "\n" +  "Details: "+ person ;
	}
	
}
