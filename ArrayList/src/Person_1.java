
public class Person_1 {
	private String name;
	//private Address address;
	private int age;
	
	
	public Person_1(String name, int age)
	{
		this.name =name;
		this.age= age;
		//this.address=address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Name :" +name + "\n" + "Age:" +age+  "\nAddress: ";
	}
	

}
