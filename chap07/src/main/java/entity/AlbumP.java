package entity;


import javax.persistence.Entity;

@Entity
public class AlbumP extends ItemP{

    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "AlbumS{" +
                "artist='" + artist + '\'' +
                '}';
    }
}
