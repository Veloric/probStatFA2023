/**
 * @author Kyle Geddes
 * 10/28/2023
 * Factory for Car.java
 */

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Factory {
	/**
	 * Generates an array list of cars to the specified amount
	 * @param amt -- Amount of random cars to generate
	 * @return - An array of randomly generated cars
	 */
	public ArrayList<Car> generateCars(int amt) {
		ArrayList<Car> carArray = new ArrayList<Car>();
		String[] carTypes = {"Sedan", "Truck", "Van", "Muscle", "Sedan"};
		String[] colors = {"Black", "White", "Charcoal", "Red", "Red", "Blue", "Grey"};
		for(int i = 0; i < amt; i++) {
			int selectedCarType = (int) (Math.random() * carTypes.length);
			int selectedColor = (int) (Math.random() * colors.length);
			int year = (int) ((Math.random() * (2023 - 1950)) + 1950);
			int miles = (int) (Math.random() * 250000);
			carArray.add(new Car(carTypes[selectedCarType], year, colors[selectedColor], miles));
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

	/**
	 * Outputs the list of cars to a .csv file
	 * @param carArray - Array of cars to export to a csv file
	 * @param fileName - Name of the file
	 * @return - A boolean value of either true or false, true if the output is written to the file, false otherwise.
	 */
	public boolean outputToFile(ArrayList<Car> carArray, String fileName){
		boolean success = false;
		// Attempt to make a file.
		try{
			File newFile = new File(fileName);
			newFile.createNewFile();
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
		//Now write to it
		try{
			FileWriter writer = new FileWriter(fileName);
			for(int i = 0; i < carArray.size(); i++){
				String outputString = carArray.get(i).getType() + "," + carArray.get(i).getYear() + "," + carArray.get(i).getColor() + "," + carArray.get(i).getMiles();
				writer.write(outputString + "\n");
			}
			writer.close();
			success = true;
		} catch(IOException e){
			e.printStackTrace();
			return false;
		}
		return success;
	}

	/**
	 * Accepts input from a CSV file
	 * @param fileName - Name of the file to read from
	 * @return - An array list containing all the car data read from the file.
	 */
	public ArrayList<Car> readFromFile(String fileName){
		ArrayList<Car> carArray = new ArrayList<Car>();
		try{
			File file = new File(fileName);
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()){
				String data = reader.nextLine();
				if(data != " "){
					String[] tokens = data.split(",");
					carArray.add(new Car(tokens[0], Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3])));
				}
			}
			reader.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return carArray;
	}
}
