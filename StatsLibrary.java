/*
 * @author Kyle Geddes
 * 09/11/2023
 * Library of all satastic functions and calculations throughout the semester
 */
import java.util.ArrayList;
import java.util.Comparator;

 public class StatsLibrary{


    /**
     * @param nums -- Starting array of doubles
     * @return -- the mean as a double.
     */
    public Double findMean(ArrayList<Double> nums){
        Double sum = 0.0;
        for(Double i: nums){
            sum = sum + i;
        }
        return sum / nums.size();
    }
    
    /**
     * @param nums -- starting array of doubles
     * @return - the middle value in the arraylist
     */
    public Double findMedian(ArrayList<Double> nums){
        nums.sort(Comparator.naturalOrder());
        Double result = 0.0;
        if(nums.size() % 2 == 0){
            result = (double) nums.get(nums.size() / 2) + (double) nums.get(nums.size() / 2 - 1) / 2;
        } else {
            result = (double) nums.get(nums.size() / 2);
        }
        return result;
    }

    /**
     * @param nums -- starting array of doubles
     * @return -- the value appearing most often (returning 0 means NO MODE)
     */
    public Double findMode(ArrayList<Double> nums){
        Double result = 0.0;
        int maxCount = 0;
        for(int i = 0; i < nums.size(); i++){
            int count = 0;
            for(int j = 0; j < nums.size(); j++){
                if(nums.get(i) == nums.get(j)) {
                    count = count + 1;
                }
            }
            if(count >= maxCount){
                maxCount = count;
                result = nums.get(i);
            }
        }
        return result;
    }

    public Double findSTDev(ArrayList<Double> nums){
        Double result = 0.0;
        Double mean = findMean(nums);
        Double top_bar = 0.0;
        for(Double i: nums){
            top_bar = top_bar + (Math.pow((i - mean), 2));
        }
        result = Math.sqrt((top_bar / nums.size() - 1));
        return result;
    }

 }