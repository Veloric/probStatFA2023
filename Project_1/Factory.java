
public class Factory {
	public Car[] generateCars(int amt) {
		Car[] carArray = new Car[amt];
		String[] carTypes = {"Sedan", "Truck", "Van", "Muscle", "Sedan"};
		String[] colors = {"Black", "White", "Charcoal", "Red", "Red", "Blue", "Grey"};
		for(int i = 0; i < carArray.length; i++) {
			int selectedCarType = (int) (Math.random() * carTypes.length);
			int selectedColor = (int) (Math.random() * colors.length);
			System.out.println(selectedCarType);
			System.out.println(selectedColor);
			int year = (int) ((Math.random() * (2023 - 1950)) + 1950);
			int miles = (int) (Math.random() * 250000);
			System.out.println(miles);
			carArray[i] = new Car(carTypes[selectedCarType], year, colors[selectedColor], miles);
		}
		
		return carArray;
	}
}
