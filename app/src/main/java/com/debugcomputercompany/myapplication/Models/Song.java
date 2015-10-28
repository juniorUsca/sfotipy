package com.debugcomputercompany.myapplication.Models;

/**
 * Created by Junior on 27/10/2015.
 */
public class Song {
    private String songName;
    private String songArtist;
    private int songStars;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public int getSongStars() {
        return songStars;
    }

    public void setSongStars(int songStars) {
        this.songStars = songStars;
    }
}
