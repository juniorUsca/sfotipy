package com.debugcomputercompany.myapplication.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.debugcomputercompany.myapplication.Adapters.SongAdapter;
import com.debugcomputercompany.myapplication.Models.Song;
import com.debugcomputercompany.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DestacadosFragment extends Fragment {

    ArrayList<Song> dataSet;

    public DestacadosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destacados, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ArrayList<Song> songArrayLis = new ArrayList<Song>();
        final SongAdapter asd = new SongAdapter(R.layout.row_songs);
        final RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_song);

        String URL = "https://script.google.com/macros/s/AKfycbyxjE2mD-1eOX-_hzxh6jC6ZGo2cGGyrjmFLW0v6esaHbAp-74/exec";

        RequestQueue queue = Volley.newRequestQueue(getActivity());

        final ProgressDialog progressDialog = ProgressDialog.show(getActivity(), "procesando", "espere x favor!");
        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(getActivity(), "Hola recogimos los datos!", Toast.LENGTH_SHORT).show();
                Log.e("respuesta", response.toString());

                dataSet = parser(response);
                asd.setSongs(dataSet);
                //asd.notifyDataSetChanged();
                recyclerView.setAdapter(asd);

                progressDialog.cancel();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Hola no hay internet!", Toast.LENGTH_SHORT).show();
                progressDialog.cancel();
            }
        });

        queue.add(request);

        Song song = new Song();
        song.setSongName("Mi cancion");
        song.setSongArtist("@xj");
        song.setSongStars(3);

        songArrayLis.add(song);



        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(new SongAdapter(songArrayLis, R.layout.row_songs));
        //recyclerView.setAdapter(asd);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public ArrayList<Song> parser(JSONArray resp) {
        ArrayList<Song> tmp = new ArrayList<Song>();
        for (int i = 0; i<resp.length();++i){
            Song song = new Song();
            try {
                JSONObject jbject = (JSONObject) resp.get(i);
                song.setSongName(jbject.getString("nombre"));
                song.setSongArtist(jbject.getString("artista"));
                song.setSongStars(jbject.getInt("estrellas"));
                tmp.add(song);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return tmp;
    }
}
