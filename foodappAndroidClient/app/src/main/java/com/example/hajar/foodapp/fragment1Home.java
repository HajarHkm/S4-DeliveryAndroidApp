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

import Adapters.PubRecyclerAdapter;
import ServerCall.ApiRetrofit;
import entities.Pub;
import interfaces.ApiPubInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment1Home extends Fragment {


    //recycler
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Pub> pubs;
    private PubRecyclerAdapter adapt;
    private ApiPubInterface apiPubInterface;


    public fragment1Home() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("****************** inonCreate will next fetchInfo");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment1_home, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.pub_recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fetchInformation();

        return v;
    }


    public void fetchInformation()
    {
        System.out.println("*******************fetching");

        apiPubInterface= ApiRetrofit.getApiClient().create(ApiPubInterface.class);
        Call<List<Pub>> call  = apiPubInterface.getPubs();
        call.enqueue(new Callback<List<Pub>>() {
            @Override
            public void onResponse(Call<List<Pub>> call, Response<List<Pub>> response) {
                pubs = response.body();
                System.out.println("****************** in onresponsehome");

                adapt = new PubRecyclerAdapter(pubs,getContext());
                recyclerView.setAdapter(adapt);
            }
            @Override
            public void onFailure(Call<List<Pub>> call, Throwable t) {
                System.out.println("****************** in onfailurehome");

            }
        });

    }
}
