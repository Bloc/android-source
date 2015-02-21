package apples; 
import colors.*;
/************************************************
 *	YOU MAY MODIFY THIS FILE AND/OR ITS LOCATION
/************************************************/

public class Fruit extends Object {
	// The name of the fruit
	public String mName;
	// Number of calories
	public int mCalories;
	// Color of the fruit
	public Color mColor;
	// Weight of the fruit, in pounds
	public double mWeight;

	public Fruit() {
		this("Apple");
		// Default fruit
	}

	Fruit(String name) {
		this(name, 0);
	}

	Fruit(String name, int calories) {
		this(name, calories, null);
	}

	Fruit(String name, int calories, Color color) {
		this(name, calories, color, 0d);
	}

	public Fruit(String name, int calories, Color color, double weight) {
		this.mName = name;
		this.mCalories = calories;
		this.mColor = color;
		this.mWeight = weight;
	}

	private String getName() {
		return mName;
	}

	private void setName(String name) {
		mName = name;
	}

	int getCalories() {
		return mCalories;
	}

	void setCalories(int calories) {
		mCalories = calories;
	}

	public Color getColor() {
		return mColor;
	}

	private void setColor(Color color) {
		mColor = color;
	}

	double getWeight() {
		return mWeight;
	}

	public void setWeight(double weight) {
		mWeight = weight;
	}
}