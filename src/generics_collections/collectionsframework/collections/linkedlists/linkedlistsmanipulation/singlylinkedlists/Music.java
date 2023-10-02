package generics_collections.collectionsframework.collections.linkedlists.linkedlistsmanipulation.singlylinkedlists;

/**
 * This class implements a singly linked list, whci is 
 * a collection of music. It is generic to contain a
 * variety of genres of music. 
 * The possible genres are country, classical, gospel, 
 * and instrumentals.
 */
public class Music<S> {
    S song;
    Music<S> next;

    Music(S s) {
        song = s;
    }
}


