package generics_collections.collectionsframework.collections.linkedlists.linkedlistsmanipulation.singlylinkedlists;

public class Song {

    private String title;
    private String artist;
    public int noOfSongs;

    public Song(String title, String artiste) {
        this.title = title;
        this.artist = artiste;
    }
    
    public void playSong() {
        System.out.println("Song playing: " + this.title);

    }
    
    public int getNoOfSongs() {
        return noOfSongs;
    }
    
    public void setSongTitle(String songTitle) {
        this.title = songTitle;

    }
    
    public void setSongArtist(String artiste) {
        this.artist = artiste;

    }
    
    public String getSongArtist() {
        return this.artist;
    }


}
