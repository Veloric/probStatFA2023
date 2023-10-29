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

    /**
     * Helper function to switch the winning door in a given simulation.
     */
    private void _changeWinningDoor(){
        this.winningDoor = (int)(1 + Math.random() * 3);
    }

    /**
     * Simulate the Three Doors problem with a set number of trials, and weather to keep the same selected door or not.
     * @param trials - Number of trials to run
     * @param change - TRUE to change the contestant CHOSEN door after each trial. FALSE to change the WINNING door after each trial.
     * @return - The probability of winning as a percent.
     */
    public double simulate(int trials, boolean change){
        double prob = 0;
        int totalWins = 0;
        if (change == true){
            for(int i = 1; i <= trials; i++){
                int chosenDoor = (int)(1 + Math.random() * 3);
                if(chosenDoor == this.winningDoor){
                    totalWins = totalWins + 1;
                }
            }
            prob = (double)totalWins / trials;
        } else if(change == false){
            int chosenDoor = (int)(1 + Math.random() * 3);
            for(int i = 1; i <= trials; i++){
                if(chosenDoor == this.winningDoor){
                    totalWins = totalWins + 1;
                }
                _changeWinningDoor();
            }
            prob = (double)totalWins / trials;
        }
        return prob * 100;
    }
}
