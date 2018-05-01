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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import Adapters.MenuRecyclerAadapet;
import Adapters.PubRecyclerAdapter;
import ServerCall.ApiRetrofit;
import entities.Plat;
import entities.Pub;
import interfaces.ApiPlatInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment2Home extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Plat> plats;
    private MenuRecyclerAadapet adapt;
    private ApiPlatInterface apiPlatInterface;
    Spinner spinner;
    String spinner_value;
    ArrayAdapter<CharSequence> adapter;

    public fragment2Home() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* System.out.println("****************** inonCreate will next fetchInfo");
        fetchInformation("pizzahut");*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment2_home, container, false);

        spinner = (Spinner) v.findViewById(R.id.cat_spinner);
        recyclerView = (RecyclerView) v.findViewById(R.id.menu_recyclerView);
        adapter=ArrayAdapter.createFromResource(getActivity(),R.array.restaurants_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getContext(),adapterView.getItemAtPosition(i)+"selected", Toast.LENGTH_LONG).show();
                spinner_value= (String) adapterView.getItemAtPosition(i);

                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);

                //push into lignes[]

                fetchInformation(spinner_value);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return v;
    }

    public void fetchInformation(String restau)
    {
        System.out.println("*******************fetching");

        apiPlatInterface= ApiRetrofit.getApiClient().create(ApiPlatInterface.class);
        Call<List<Plat>> call  = apiPlatInterface.getMenu(restau);
        call.enqueue(new Callback<List<Plat>>() {
            @Override
            public void onResponse(Call<List<Plat>> call, Response<List<Plat>> response) {
                plats = response.body();
                System.out.println("****************** in onresponsehome2;response: "+response.toString());

                adapt = new MenuRecyclerAadapet(plats,getContext());
                recyclerView.setAdapter(adapt);
            }
            @Override
            public void onFailure(Call<List<Plat>> call, Throwable t) {
                System.out.println("****************** in onfailurehome2 and call is:"+t.getMessage().toString());

            }
        });

    }


}
