package generics_collections.collectionsframework.collections.linkedlists.linkedlistsmanipulation.singlylinkedlists;

public class TestMusicLinkedList {

    public static void main(String[] args) {
        // create the head and tail ponters

        /* Both are null and the list is empty... */
        Music<Song> head = null; // will point to the first node
        Music<Song> tail = null; // will point to the last node

        /* insert first music node in the linkedlist */
        // create new music node

        Music<Song> song1 = new Music<>(new Song("A wonderful Saviour", "Fountain View"));

        // insert song1 node in the list
        head = song1;
        tail = head;

        /* insert second music node into list */

        Music<Song> song2 = new Music<>(new Song("Fairest Lord Jesus", "unkown"));

        // tail = song2;

        // insert second

        // insert third...

        System.out.println("Hello, Uganda!"); // testing....


        
    }
    


}
