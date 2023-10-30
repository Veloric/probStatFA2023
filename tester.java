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
        ThreeDoors sim = new ThreeDoors();
        double probNoChange = sim.simulate(10000, false);
        double probWithChange = sim.simulate(10000, true);
        System.out.println("Monte's Three Door simulation, running with: 10000 trials and changing the chosen door each time: " + probWithChange + " percent win chance. Now without changing the chosen door: " + probNoChange + " percent win chance.");

        //Car factory tests
       /* Factory carFactory = new Factory();
        ArrayList<Car> carArray = carFactory.generateCars(2000);
        carFactory.outputToFile(carArray, "carData.csv");
        ArrayList<Car> newArray = carFactory.readFromFile("carData.csv");
        for(int i = 0; i < newArray.size(); i++){
            System.out.println(i + ": " + newArray.get(i).print());
        } */

        //Birthday Comparison Test
        ClassEvaluator cv = new ClassEvaluator();
        ArrayList<Person> people = cv.generateRandomPeople(30);
        int sameBirthdays = cv.determineSameBirthdays(people);
        System.out.println("Out of " + people.size() + " people, " + sameBirthdays + " have matching birthdays. Which makes " + ((double)sameBirthdays / people.size()) * 100 + " percent the probability of any two people sharing the same birthday.");

        //Card/Hand/Poker Test
        HandEvaluator hv = new HandEvaluator();
        hv.populateDeck(52);
        System.out.println(hv.simulate(10000));
    }
}
