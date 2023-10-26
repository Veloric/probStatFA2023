/*
 * @author Kyle Geddes
 * 09/11/2023
 * Library of all satastic functions and calculations throughout the semester
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.math.BigInteger;
import java.util.HashMap;

 public class StatsLibrary{


    /**
     * @param nums -- Starting array of doubles
     * @return -- the mean as a double.
     */
    public double findMean(ArrayList<Double> nums){
        double sum = 0.0;
        for(double i: nums){
            sum = sum + i;
        }
        return sum / nums.size();
    }
    
    /**
     * @param nums -- starting array of doubles
     * @return - the middle value in the arraylist
     */
    public double findMedian(ArrayList<Double> nums){
        nums.sort(Comparator.naturalOrder());
        double result = 0.0;
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
    public double findMode(ArrayList<Double> nums){
        nums.sort(Comparator.naturalOrder());
        double result = 0.0; // Value
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

    /**
     * @param nums -- Starting array
     * @return The variance as a double
     */
    public double findVariance(ArrayList<Double> nums){
        double result = 0.0;
        double mean = findMean(nums);
        for(double i: nums){
            result = result + (Math.pow((i - mean), 2));
        }
        return result;
    }

    /**
     * @param nums -- Array of doubles
     * @return -- The standard deviation as a double
     */
    public double findSTDev(ArrayList<Double> nums){
        double top_bar = findVariance(nums);
        return Math.sqrt((top_bar / nums.size() - 1));
    }

    public ArrayList<Double> union(ArrayList<Double> set1, ArrayList<Double> set2){
        ArrayList<Double> result = new ArrayList<Double>();
        if(set1.size() > set2.size()){ // if set1 > set2, use set2 as base set
            for(int i = 0; i > set2.size(); i++){
                
            }

        }
        return result;
    }

    /**
     * @param n -- Integer to compute a factorial on
     * @return -- The answer as a double
     */
    public double fact(int n){
      BigInteger fact = BigInteger.ONE;
      for (int i = n; i > 0; i--){
        fact = fact.multiply(BigInteger.valueOf(i));
      }
      return fact.doubleValue();
    }


    public double combine(int n, int r){
        double result = 0.0;
        double top = fact(n); // Factorial of N
        double bottom = fact(r) * fact(n-r); // Factorial of (r and n-r)
        result = top/bottom;
        return result;
    }

    public double permutate(int n, int r){
        return fact(n) / fact(n-r);
    }

    public double hyperGeometric(int bigN, int n, int y, int r){
      double ans = 0.0;
      double top = combine(r, y) * combine(bigN - r, n - y);
      double bottom = combine(bigN, n);
      ans = (top / bottom) * 100;

      return ans;
    }

   public double negBinomialDist(int y, int r, double p){
     double ans = 0.0;
     ans = combine(y-1, r-1) * (Math.pow(p, y) * Math.pow(1 - p, y - r));

     return ans;
   }
 }
