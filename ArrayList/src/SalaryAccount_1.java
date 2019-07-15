
public class SalaryAccount_1 extends BankAccount_1 {


	private static final double MIN_ACCOUNT_BALANCE =0;

	public SalaryAccount_1(Person_1 person) {
		super(person);
		// TODO Auto-generated constructor stub
	}
	
	public double withdraw(double amount) {
		if(MIN_ACCOUNT_BALANCE>(balance-amount)) {
			System.out.println("Insufficient Balance");
			return -1;
		}
		else 
		{
			System.out.println("Withdrawed");
			balance-=amount;
			return amount;
		}
	}

	public void deposit(double amount) {
		if(amount<=50000) {
		balance+=amount;
		System.out.println("Deposited");
		}
		else
		{
			System.out.println("Exceeds Limit");

		}
		
	}
	@Override
	public String toString() {
		return  "Accouunt no: "+accountno + "\n" +  "Details: SALARY ACCOUNT\n "+ person ;
	}
}
