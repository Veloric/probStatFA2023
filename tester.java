import java.util.ArrayList;

public class tester {

    public static void main(String[] args){
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
    }
}
