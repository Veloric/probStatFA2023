/**
 * Preforms a simulation of the Monte's three door problem
 * @author Kyle Geddes
 * 10/29/30
 */

public class ThreeDoors {
    private int winningDoor;

    /**
     * Default constructor that randomly assigns a winning door (1 to 3)
     */
    public ThreeDoors(){
        this.winningDoor = (int)(1 + Math.random() * 3);
    }

    /**
     * Allows for manually assigning the winning door value
     * @param winningDoor - Manually assign the winning door value
     */
    public ThreeDoors(int winningDoor){
        this.winningDoor = winningDoor;
    }

    /**
     * Check the winning door value
     * @return - Winning door as an integer.
     */
    public int getWinningDoor(){
        return this.winningDoor;
    }
}
