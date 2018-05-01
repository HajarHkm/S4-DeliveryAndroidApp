package com.example.hajar.foodapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Adapters.LivreurCommandsRecyclerAdapter;
import ServerCall.ApiRetrofit;
import entities.Commande;
import interfaces.ApiCommandInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HistoryDelivered extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Commande> commandes;
    private LivreurCommandsRecyclerAdapter adapt;
    private ApiCommandInterface apiCommandInterface;

    public HistoryDelivered() {
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


        View v =inflater.inflate(R.layout.fragment_history_delivered, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.livreurCommand_recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInformation();

        return v;
    }

    public void fetchInformation()
    {
        System.out.println("*******************fetching");

        apiCommandInterface= ApiRetrofit.getApiClient().create(ApiCommandInterface.class);
        Call<List<Commande>> call  = apiCommandInterface.getLivreurCommands(3);
        call.enqueue(new Callback<List<Commande>>() {
            @Override
            public void onResponse(Call<List<Commande>> call, Response<List<Commande>> response) {
                commandes = response.body();
                System.out.println("****************** in onresponse livreur commands"+call.toString()+"+++resonse: "+response.body().toString());

                adapt = new LivreurCommandsRecyclerAdapter(commandes,getContext());
                recyclerView.setAdapter(adapt);
            }
            @Override
            public void onFailure(Call<List<Commande>> call, Throwable t) {
                System.out.println("****************** in onfailure livreurcommands error: "+t.getMessage().toString());

            }
        });

    }

}
