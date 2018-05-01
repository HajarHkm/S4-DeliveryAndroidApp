package com.example.hajar.foodapp;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Adapters.LivreursRecyclerAdapter;
import Adapters.PubRecyclerAdapter;
import Dialogs.ConfirmationDialog;
import SQLiteDb.BackGroundTask;
import SQLiteDb.CartAdapter;
import SQLiteDb.Cartclass;
import ServerCall.ApiRetrofit;
import entities.Commande;
import entities.LigneCommande;
import entities.Livreur;
import entities.Pub;
import interfaces.ApiCommandInterface;
import interfaces.ApiLivreurInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment3Home extends Fragment {


    ApiLivreurInterface apiLivreurInterface;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Livreur> livreurs;
    private LivreursRecyclerAdapter adapt;

    public fragment3Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment3_home, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.livreurs_recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInformation();
        return v;
    }


    public void fetchInformation()
    {
        System.out.println("*******************fetching");

        apiLivreurInterface= ApiRetrofit.getApiClient().create(ApiLivreurInterface.class);
        Call<List<Livreur>> call  = apiLivreurInterface.getLivreurs();
        call.enqueue(new Callback<List<Livreur>>() {
            @Override
            public void onResponse(Call<List<Livreur>> call, Response<List<Livreur>> response) {
                livreurs = response.body();
                System.out.println("****************** in onrespons delivery men");
                System.out.println("****************** first image"+ livreurs.indexOf(0));
                adapt = new LivreursRecyclerAdapter(livreurs,getContext());
                recyclerView.setAdapter(adapt);
            }
            @Override
            public void onFailure(Call<List<Livreur>> call, Throwable t) {
                System.out.println("****************** in onfailure delivery men");

            }
        });

    }

}
