import java.util.ArrayList;

public class tester {

    public static void main(String[] args){
        //Stats Library Tests
        ArrayList<Double> nums = new ArrayList<>();
        StatsLibrary lib = new StatsLibrary();
        nums.add(1.0);
        nums.add(2.0);
        nums.add(2.0);
        nums.add(3.0);
        nums.add(3.0);
        nums.add(3.0);
        nums.add(5.0);
        nums.add(5.0);
        System.out.println("The mean is: " + lib.findMean(nums));
        System.out.println("The mode is: " + lib.findMode(nums));
        System.out.println("The median is: " + lib.findMedian(nums));
        System.out.println("The Standard Deviation is: " + lib.findSTDev(nums));
        System.out.println(String.format("A combination from a total of %d taken %d times is: %.2f", 10, 5, lib.combine(10, 5)));
        System.out.println(String.format("A permutation between %d and %d is: %.2f", 30, 3, lib.permutate(30, 3)));

        // Three Doors Simulation
        

        //Car factory tests
        /*
        Factory carFactory = new Factory();
        ArrayList<Car> carArray = carFactory.generateCars(2000);
        carFactory.outputToFile(carArray, "carData.csv");
        ArrayList<Car> newArray = carFactory.readFromFile("carData.csv");
        for(int i = 0; i < newArray.size(); i++){
            System.out.println(i + ": " + newArray.get(i).print());
        }
        */

        //Birthday Comparison Test
        ClassEvaluator cv = new ClassEvaluator();
        ArrayList<Person> people = cv.generateRandomPeople(30);
        int sameBirthdays = cv.determineSameBirthdays(people);
        System.out.println("Out of " + people.size() + " people, " + sameBirthdays + " have matching birthdays. Which makes " + ((double)sameBirthdays / people.size()) * 100 + " percent the probability of any two people sharing the same birthday.");

        //Card/Hand/Poker Test

    }
}
