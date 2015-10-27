package com.debugcomputercompany.myapplication.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.debugcomputercompany.myapplication.Adapters.AmigosAdapter;
import com.debugcomputercompany.myapplication.Models.Amigo;
import com.debugcomputercompany.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmigosFragment extends Fragment {


    public AmigosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amigos, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Amigo> amigoArrayLis = new ArrayList<Amigo>();

        Amigo amigo = new Amigo();
        amigo.setNombre("Junior");
        amigo.setTwitter("@junior.usca");
        amigo.setUltimaCancion("q se vaya!");

        Amigo amigo1 = new Amigo();
        amigo1.setNombre("xarito");
        amigo1.setTwitter("@junior.usca");
        amigo1.setUltimaCancion("q se vaya!");

        Amigo amigo2 = new Amigo();
        amigo2.setNombre("asd");
        amigo2.setTwitter("@junior.usca");
        amigo2.setUltimaCancion("q se vaya!");

        amigoArrayLis.add(amigo);
        amigoArrayLis.add(amigo1);
        amigoArrayLis.add(amigo2);

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AmigosAdapter(amigoArrayLis, R.layout.row_amigos));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
