



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Restaurent {

	public static void main(String[] args) {
		List<Dish> list=new ArrayList<Dish>();//Creating arraylist 
		   // TreeSet<Dish> list = new TreeSet<Dish>(new DishIdDESCComparator()); 
			Dish d1 = new Dish(5,"neer-dosa",50,100);
			Dish d2 = new Dish(2,"Idli-Vada",40,200);
			Dish d3 = new Dish(4,"Roti-Curry",100,250);
			Dish d4 = new Dish(1, "Dosa", 50,300);
			list.add(d1);
			list.add(d2);
			list.add(d3);
			list.add(d4);
			//System.out.println(list); 
			Scanner sc = new Scanner(System.in);
			System.out.println("===================================");
			System.out.println("Please choose from the below options");
			System.out.println("1 => To sort the dishes in the increasing order of calories");
			System.out.println("2 => To sort the dishes in the decreasing order of calories");
			System.out.println("3 => To sort the dishes in the increasing order of price");
			System.out.println("4 => To sort the dishes in the decreasing order of price ");
			System.out.println("===================================");
			int ans = sc.nextInt();
			if(ans == 1) {
				Collections.sort(list, new increasingCalories());
			}
			else if(ans == 2) {
				Collections.sort(list, new decreasingCalories());
			}
			else if(ans == 3) {
				Collections.sort(list, new increasingPrice());
			}
			else if(ans == 4) {
				Collections.sort(list, new decreasingPrice());
			}
			else {
				System.out.println("ERRORRR!!!!!!!!!!!!!!!");
			}
			
			for (int i = 0; i < 4; i++) 
		    { 
		        Dish data = list.get(i); 
		        System.out.println(data.getId()+" "+data.getName()+"     "+data.getCalories()+"     "+data.getPrice()); 
		    } 
			
			
			System.out.println("=Please select the Dish Id and hit enter=");
			int option = sc.nextInt();
			for (int i = 0; i < 4; i++) 
		    { 
		        Dish data1 = list.get(i); 
		        if(data1.getId()==option) {
		        System.out.println("YOU HAVE SELECTED  "+data1.getName()+"     "+data1.getCalories()+"     "+data1.getPrice()); 
		        System.out.println("please enter your name");
		        String name1 = sc.next();
		        System.out.println("pay the bill of " + data1.getPrice());
		        System.out.println("Enter the money you are paying");
		        double money = sc.nextDouble();
		        double n= (data1.getPrice() - money);
		        if(money > data1.getPrice() )
		        {
			        System.out.println("======Thanks for your order. Please collect the change = Rs " + n);
		        }
		        else if(money == data1.getPrice()) {
		        	System.out.println("========Thanks for your order. ================");
		        }
		        else {
		        	System.out.println("========Amount paid is less than Bill Amount ================");
		        }
		        }
		    } 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			}
	
}
