package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.GeneralArrays.PartialArrays;

/**
 * This class contains a list of playerList involved in 
 * a game. 
 */
public class PlayerList {

    int playerCt = 0; // number of playerList in the game
    Player[] playerList = new Player[10]; // array of playerList

    /**
     * This method takes a player as input and adds it
     * to the list of playerList; incrementing the player count
     * @param player
     */
    public boolean addPlayer(Player player) {
        playerList[playerCt] = player;
        playerCt++;
        return true;
    }

    /**
     * This methods is to add a player to the end of the list if it already exists
     * and has some players in it. It considers when the list is not full and
     * when it is full. When not full, it adds the element to the next index but 
     * when full, it creates a new temporary array twice the size of the old and
     * reassigns the old to the new bigger arrays after copying its items into the 
     * new and bigger array. Now the array will have more space. 
     * However, if it has no players, then it calls its other overload method
     * to add the player to the list.
     * @param playerCt
     * @param player
     * @return
     */
    public boolean addPlayer(int playerCt, Player player) {
        this.playerCt = playerCt;
        if (playerCt == 0) {// playerList is empty
            addPlayer(player);
        } else if (playerCt == playerList.length) { // when partial array is full
            // create new array twice the size of the partial now full array
            Player[] temp = new Player[2 * playerList.length];
            // copy items from the old array into the new
            for (int i = 0; i < playerList.length; i++) {
                temp[i] = playerList[i];
            } // all items in the old array put in the new
            
            playerList = temp; // playerList now points to the new, bigger array.
            playerList[playerCt+1] = player;
            playerCt++; 
        }
        else {// playerList is not full
            playerList[playerCt+1] = player;
        }
        return false;
    }

    /**
     * This method takes a position of player in the list
     * as input and removes the player at that position; then
     * decrements the player count.
     * @param k
     */
    public String removePlayer(int k) {
        // remove from any position k in the list of playerList
        // replace playerList[k] with playerList[playerCt-1]
        playerList[k] = playerList[playerCt - 1];
        playerCt--;
        return ("\nremoved player: " + k + "\n");
    }
    
    /**
     * This method overrides the removePlayer method. It maintains
     * the order if order == true, otherwise it calls removePlayer(int k) 
     * which does not mind the order of the players in the list.
     * @param order
     * @param k
     * @return String
     */
    public String removePlayer(boolean order, int k) {
        if (order == false) {
            removePlayer(k);
        } else {
            for (int i = k + 1; i < playerCt; i++) {
                // replace player at k with playerList at k+1
                playerList[i - 1] = playerList[i]; 
            }
            playerCt--; // decrement player count
        }

        return ("\nremoved player: " + k + "\n");
        
    }

    /**
     * This prints all the playerList in the list of playerList
     */
    public static void printplayerList(PlayerList playerList) {
        for (int i = 0; i < playerList.playerCt; i++) {
            System.out.println(playerList.playerList[i].name);            
        }
        
    }
    
}
