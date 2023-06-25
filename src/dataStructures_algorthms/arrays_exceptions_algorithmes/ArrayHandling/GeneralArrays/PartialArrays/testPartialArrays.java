package dataStructures_algorthms.arrays_exceptions_algorithmes.ArrayHandling.GeneralArrays.PartialArrays;

public class testPartialArrays {
    static boolean success; // when player is added to the list
    static PlayerList players; // list of players
    
    public static void main(String[] args) throws Exception {
        players = new PlayerList(); // empty player list of 10 spaces

        /**create only six players to be added to the player list. 
         * This makes it a partial array of players */
        
        // for (int i = 0; i < 6; i++) {
        //     Player player = new Player("player " + i);
        //     // add player to player list
        //     success = players.addPlayer(player);
        // }
        // System.out.println("\nAfter adding players"); 
        // PlayerList.printplayerList(players);

        // // remove player 3 who is at position 4 - maintain the order of players
        
        // System.out.print(players.removePlayer(true,3));
        // System.out.println("\nAfter removing players");
        // PlayerList.printplayerList(players); // after removing a player

        // // remove player 3 who is at position 4 - DON'T maintain the order of players

        // System.out.print(players.removePlayer(3));
        // System.out.println("\nAfter removing players");
        // PlayerList.printplayerList(players); // after removing a player

        // testing when partially full array is full

        // create a full list

        for (int i = 0; i < 10; i++) {
            Player player = new Player("player " + i);
            // add player to player list
            success = players.addPlayer(player);
        }
        System.out.println("\nAfter Making a full list of players");
        PlayerList.printplayerList(players);


        // adding  a new player to the full list
        System.out.println("\nAdding new player to a full array\n");
        Player newPlayer = new Player("newPlayer");
        boolean op = players.addPlayer(10,newPlayer);
        if (op == true) {
            System.out.println("\nSuccessfully added new player\n");
            PlayerList.printplayerList(players);
        } else {
            System.out.println("\nfailed\n");
        }

    }
    
}
