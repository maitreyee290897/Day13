
import java.util.Comparator;

class increasingCalories implements Comparator<Dish>{
	@Override
	public int compare(Dish a,Dish b) {
		return (int)(a.getCalories() - b.getCalories());
	}
}

class decreasingCalories implements Comparator<Dish>{
	@Override
	public int compare(Dish a,Dish b) {
		return (int)(b.getCalories() - a.getCalories());
		//return Integer.valueOf(b.getCalories()).compareTo(a.getCalories());
	}
}
class increasingPrice implements Comparator<Dish>{
	public int compare(Dish a,Dish b) {
		return (int)(a.getPrice() - b.getPrice());
	}
}


class decreasingPrice implements Comparator<Dish>{
	public int compare(Dish a,Dish b) {
		return (int)(a.getPrice() - b.getPrice());
	}
}