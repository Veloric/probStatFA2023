/**
 * For this purpose, a person will only have a birthday.
 * @author Kyle Geddes
 * 10/29/2023
 */

public class Person {
    private int month;
    private int day;
    private int id;

    /**
     * Initalize a Person
     * @param month - Integer, 1 - 12
     * @param day - Integer, 1 - 30.
     */
    public Person(int month, int day){
        this.id = (int) (1 + Math.random() * 1000);
        this.month = month;
        this.day = day;
    }

    /**
     * Compares this person's birthday to another person's birthday.
     * @param compare -- Person to compare
     * @return -- True if same birthday, false otherwise
     */
    public boolean compareBirthday(Person compare){
        if(this.month == compare.month && this.day == compare.day){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks to see if two people are equal
     * @param compare - Person to compare
     * @return - True if same ID, false otherwise
     */
    public boolean equals(Person compare){
        if(this.id == compare.id){
            return true;
        } else {
            return false;
        }
    }
    
}
