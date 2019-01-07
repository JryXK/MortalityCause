/**

 * 
 */
package project;

/**
 * This class is used to represent abstract object ADT which stores different
 * values including different state variable such as year, age, gender, cause,
 * unit and value which willed be loaded from data set by readFile class and
 * bunch of accessor for encapsulation purpose.
 * 
 * @author Jiamin
 *
 */
public class ADT {
	private int year;
	private int age;
	private int gender;
	private String cause;
	private int unit;
	private double value;

	public ADT(int year, int age, int gender, String cause, int unit, double value) { // constructor that build the
																						// abstract object ADT
		this.year = year;
		this.age = age;
		this.gender = gender;
		this.cause = cause;
		this.unit = unit;
		this.value = value;
	}

	public int getYear() { // get year
		return this.year;
	}

	public int getAge() {// get age
		return this.age;
	}

	public int getGender() {// get gender
		return this.gender;
	}

	public String getCause() {// get cause
		return this.cause;
	}

	public int getUnit() {// get unit
		return this.unit;
	}

	public double getValue() {// get value
		return this.value;
	}

	@Override
	public String toString() { // print ADT for test purpose
		return this.year + " " + this.age + " " + this.gender + " " + this.cause + " " + this.unit + " " + this.value;
	}

	public int compareTo(ADT a) { // mutator compareTo to compare the order of 2 ADT
		if (Double.compare(this.value, a.getValue()) == 0)
			return cause.compareTo(a.getCause());
		else
			return Double.compare(this.value, a.getValue());
	}
}
