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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import Adapters.NewCommandsRecyclerAdapter;
import ServerCall.ApiRetrofit;
import entities.Commande;
import interfaces.ApiCommandInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChooseToDeliver extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Commande> commandes;
    private NewCommandsRecyclerAdapter adapt;
    private ApiCommandInterface apiCommandInterface;

    public ChooseToDeliver() {
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

        View v =inflater.inflate(R.layout.fragment_choose_to_deliver, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.newCommand_recyclerView);
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
        Call<List<Commande>> call  = apiCommandInterface.getNewCommands();
        call.enqueue(new Callback<List<Commande>>() {
            @Override
            public void onResponse(Call<List<Commande>> call, Response<List<Commande>> response) {
                commandes = response.body();
                System.out.println("****************** in onresponse new commands"+call.toString());

                adapt = new NewCommandsRecyclerAdapter(commandes,getContext());
                recyclerView.setAdapter(adapt);
            }
            @Override
            public void onFailure(Call<List<Commande>> call, Throwable t) {
                System.out.println("****************** in onfailure new commands"+t.getMessage().toString());

            }
        });

    }

}
