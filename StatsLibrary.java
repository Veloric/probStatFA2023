/*
 * @author Kyle Geddes
 * 09/11/2023
 * Library of all satastic functions and calculations throughout the semester
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

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
        nums.sort(Comparator.naturalOrder());
        Double result = 0.0; // Value
        int maxCount = 0; // Frequency
        HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
        for(int i = 0; i < nums.size(); i++){
            if(hm.get(nums.get(i)) != null){
                int current = hm.get(nums.get(i));
                current++;
                hm.put(nums.get(i), current);

                if(current > maxCount){
                    maxCount = current;
                    result = nums.get(i);
                }
            } else {
                hm.put(nums.get(i), 1);
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

    public Double fact(int n){
        if(n <= 0){
            return 1.0;
        } else {
            return(n * fact(n-1));
        }
    }


    public Double combine(int n, int r){
        Double result = 0.0;
        Double top = fact(n); // Factorial of N
        Double bottom = fact(r) * fact(n-r); // Factorial of (r and n-r)
        result = top/bottom;
        return result;
    }

    public Double permutate(int n, int r){
        return fact(n) / fact(n-r);
    }

 }