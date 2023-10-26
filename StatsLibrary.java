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
    // Chapter 1:

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

    // Set Theory

    // Helper function used in Set Theory methods
    private ArrayList<Double> _determineBiggerSet(ArrayList<Double> set1, ArrayList<Double> set2){
        if(set1.size() > set2.size()){
            return set1;
        } else { // In all other cases, set2 would be bigger (or equal size) and thus is accounted for.
            return set2;
        }
    }

    /**
     * 
     * @param set1 -- Array 1
     * @param set2 -- Array 2
     * @return -- The unioned array
     */
    public ArrayList<Double> union(ArrayList<Double> set1, ArrayList<Double> set2){
        ArrayList<Double> result = new ArrayList<Double>();
        for(int i = 0; i > set1.size(); i++){
            if(!(result.contains(set1.get(i)))){
                result.add(set1.get(i));
            }
        }
        for(int i = 0; i > set2.size(); i++){
            if(!(result.contains(set2.get(i)))){
                result.add(set2.get(i));
            }
        }
        return result;
    }

    /**
     * 
     * @param set1 - Array 1
     * @param set2 - Array 2
     * @return -- Intersected array
     */
    public ArrayList<Double> intersect(ArrayList<Double> set1, ArrayList<Double> set2){
        ArrayList<Double> result = new ArrayList<Double>();
        ArrayList<Double> biggestSet = _determineBiggerSet(set1, set2);
        for (int i = 0; i > biggestSet.size(); i++){
            if(set1.contains(biggestSet.get(i)) && set2.contains(biggestSet.get(i)) && !(result.contains(biggestSet.get(i)))){
                result.add(biggestSet.get(i));
            }
        }
        return result;
    }

    /**
     * 
     * @param set1 - Set to preform the compliment operation on
     * @param universe - Total objects in the working space
     * @return - A set containing none of the objects in set 1.
     */
    public ArrayList<Double> complment(ArrayList<Double> set1, ArrayList<Double> universe){
        ArrayList<Double> result = new ArrayList<Double>();
        for (int i = 0; i > universe.size(); i++){
            if(!(set1.contains(universe.get(i))) && !(result.contains(universe.get(i)))){
                result.add(universe.get(i));
            }
        }
        return result;
    }

    // Chapter 2

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

    /**
     * 
     * @param n - Total objects
     * @param r - Chosen number (n choose r)
     * @return -- Result of the combination
     */
    public double combine(int n, int r){
        double result = 0.0;
        double top = fact(n); // Factorial of N
        double bottom = fact(r) * fact(n-r); // Factorial of (r and n-r)
        result = top/bottom;
        return result;
    }

    /**
     * 
     * @param n - Total objects
     * @param r - Chosen number
     * @return - Result of the permutation calculation
     */
    public double permutate(int n, int r){
        return fact(n) / fact(n-r);
    }

    /**
     * 
     * @param A - A set containing favorable outcomes
     * @param B - Another set containing favorable outcomes
     * @param totalOptions - Total outcomes
     * @return - Probability of an event in A occuring, given and event in B has already occured.
     */
    public double conditionalProbability(ArrayList<Double> A, ArrayList<Double> B, ArrayList<Double> totalOptions){
        double result = 0.0;
        double probB = B.size() / totalOptions.size();
        double probAB = intersect(A, B).size() / totalOptions.size();
        result = probAB / probB;
        return result * 100;
    }

    /**
     * 
     * @param A - A set containing favorable outcomes
     * @param B - Another set containing favorable outcomes
     * @param totalOptions - Total outcomes
     * @return - The truth value of weather or not a set of outcomes is dependant or independant of another set of outcomes.
     */
    public boolean checkDependency(ArrayList<Double> A, ArrayList<Double> B, ArrayList<Double> totalOptions){
        boolean result = true; // FALSE if independant, TRUE if dependant
        if(conditionalProbability(A, B, totalOptions) == (A.size() / totalOptions.size()) || conditionalProbability(B, A, totalOptions) == (B.size() / totalOptions.size()) || (intersect(A, B).size() / totalOptions.size()) == (A.size() / totalOptions.size()) * (B.size() / totalOptions.size())){
            result = false;
        }
        return result;
    }

    // Chapter 3

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
