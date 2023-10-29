/**
 * Evaluates People in a classroom, comparing their birthdays.
 * @author Kyle Geddes
 * 10/29/2023
 */

import java.util.ArrayList;

public class ClassEvaluator {
    
    /**
     * Generates a random list of people up to the target amount
     * @param amount - Target amount
     * @return - ArrayList of generated people.
     */
    public ArrayList<Person> generateRandomPeople(int amount){
        ArrayList<Person> arrayOfPeople = new ArrayList<Person>();
        for(int i = 0; i < amount; i++){
            int month = (int) (1 + Math.random() * 12); // 12 months in a year
            int day = (int) (1 + Math.random() * 30); // 30 days typically equals one month
            Person p = new Person(month, day);
            arrayOfPeople.add(p);
        }
        return arrayOfPeople;
    }

    /**
     * Runs a nested loop to determine if there are any matching birthdays within a set of people
     * @param people - A set of Person's
     * @return - The amount of matching birthdays, if none, matching will be 0.
     */
    public int determineSameBirthdays(ArrayList<Person> people){
        int matching = 0;
        for(int i = 0; i < people.size(); i++){
            Person p = people.get(i);
            for (int j = 0; j < people.size(); j++){
                Person pj = people.get(j);
                if(!p.equals(pj)){
                    if(p.compareBirthday(pj)){
                        matching = matching + 1;
                    }
                }
            }
        }
        return matching;
    }
}
