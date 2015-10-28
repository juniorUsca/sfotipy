package com.debugcomputercompany.myapplication.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.debugcomputercompany.myapplication.Models.Song;
import com.debugcomputercompany.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Junior on 28/10/2015.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>{

    private ArrayList<Song> songs;
    private int itemLayout;

    public SongAdapter(int itemLayout) {
        this.itemLayout = itemLayout;
    }

    public SongAdapter(ArrayList<Song> songs, int itemLayout) {
        this.songs = songs;
        this.itemLayout = itemLayout;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }



    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.songName.setText(song.getSongName());
        holder.songArtist.setText(song.getSongArtist());
        holder.starts.setRating(song.getSongStars());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView songName;
        public TextView songArtist;
        public RatingBar starts;

        public ViewHolder(View itemView) {
            super(itemView);

            songName= (TextView) itemView.findViewById(R.id.name_song);
            songArtist = (TextView) itemView.findViewById(R.id.artist_song);
            starts = (RatingBar) itemView.findViewById(R.id.ratingBar);

        }
    }
}
