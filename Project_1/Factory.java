/**
 * @author Kyle Geddes
 * 10/28/2023
 * Factory for Car.java
 */
public class Factory {
	/**
	 * 
	 * @param amt -- Amount of random cars to generate
	 * @return - An array of randomly generated cars
	 */
	public Car[] generateCars(int amt) {
		Car[] carArray = new Car[amt];
		String[] carTypes = {"Sedan", "Truck", "Van", "Muscle", "Sedan"};
		String[] colors = {"Black", "White", "Charcoal", "Red", "Red", "Blue", "Grey"};
		for(int i = 0; i < carArray.length; i++) {
			int selectedCarType = (int) (Math.random() * carTypes.length);
			int selectedColor = (int) (Math.random() * colors.length);
			int year = (int) ((Math.random() * (2023 - 1950)) + 1950);
			int miles = (int) (Math.random() * 250000);
			carArray[i] = new Car(carTypes[selectedCarType], year, colors[selectedColor], miles);
		}
		
		return carArray;
	}
	/**
	 * 
	 * @param type - Car body
	 * @param color - Car color
	 * @param year - Year car was made
	 * @param miles - Miles on the car
	 * @return - Car generated within specifications
	 */
	public Car generateCar(String type, int year, String color, int miles){
		return new Car(type, year, color, miles);
	}
}
