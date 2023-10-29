/**
 * @author Kyle Geddes
 * 10/28/2023
 */
public class Car {
	private String carType;
	private int year;
	private String color;
	private int miles;
	
	public Car(String carType, int year, String color, int miles) {
		this.carType = carType;
		this.year = year;
		this.color = color;
		this.miles = miles;
	}

	public String getType(){
		return this.carType;
	}
	
	public int getYear(){
		return this.year;
	}

	public String getColor(){
		return this.color;
	}

	public int getMiles(){
		return this.miles;
	}

	public String print(){
		return this.carType + " " + this.year + " " + this.color + " " + this.miles;
	}
	
}
