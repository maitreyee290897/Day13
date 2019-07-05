
import java.util.Objects;

public class Dish {

	private int id;
    private String name; 
    private double calories;
    private double price;
    
    public Dish(int id,String name,double calories,double price) {
    	this.id=id;
    	this.name=name;
    	this.calories=calories;
    	this.price=price;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "dish id" + this.id + this.name + this.calories + this.price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id);//hash can be found for any entities that are constant 
	}
	
	@Override
	public boolean equals(Object o) {
	if(o == null) {
	return false;
	}
	if(o.getClass() != Dish.class) {
	return false;
	}
	Dish other = (Dish) o;
	return Objects.equals(this.id, other.id) && Objects.equals(this.name, other.name) && Objects.equals(this.price, other.price) && Objects.equals(this.calories, other.calories);
	}

	
}
