import java.util.Scanner;

public class main_1 {
	Scanner sc = new Scanner(System.in);
	String street;
	String city;
	String state;
	String name;
	int age;
	int option1;
	
	//BankAccount account1=null;
	//do {

	option1  = sc.nextInt();
	if (option1 ==1 )
	{
	System.out.println("Enter the account type");
	System.out.println("0: Saving");
	System.out.println("1: Current");
	System.out.println("2: Salary");
	int AccountTypeOption;
	AccountTypeOption= sc.nextInt();
	System.out.println("Enter name and age");
	name= sc.next();
	age = sc.nextInt();
	
	Person_1 person1 = new Person_1(name,age);

	SalaryAccount_1 account1= new SalaryAccount_1(person1);
	//accountList.add(account1);
	System.out.println("**Successfull creation of account**");
	System.out.println("Following are the account details: ");
	System.out.println(account1);

	//Iterator <BankAccount> it = A
	System.out.println("Enter the account no");
	int accno;
	accno=sc.nextInt();
	if(accno==account1.getAccountno())
	{
	System.out.println("Verified! Select an a opertaion");
	boolean flag2=true;
	do {
	System.out.println("1:Withdraw");
	System.out.println("2:Deposit");
	System.out.println("3:Check Balance");
	System.out.println("4:Finish");
	 
	int operationOption = sc.nextInt();
	if(operationOption ==1)
	{
	System.out.println("Enter the amount");
	int amount = sc.nextInt();
	System.out.println(account1.withdraw(amount));
	}
	else if(operationOption ==2)
	{
	System.out.println("Enter the amount");
	int amount = sc.nextInt();
	account1.deposit(amount);
	}
	else if(operationOption ==3)
	{
	System.out.println("Balance is " + account1.getBalance());
	}
	else if(operationOption ==4)
	{
	flag2=false;

	}

	}while(flag2);
	}
	}
	else {
	flag=false;
	}
	//}while(flag);
	System.out.println("Exited");


	}
}

