package com.example.hajar.foodapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import ServerCall.ApiRetrofit;
import entities.Client;
import entities.Livreur;
import interfaces.ApiClientInterface;
import interfaces.ApiLivreurInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    public Button register;
    ApiClientInterface apiClientInterface;
    ApiLivreurInterface apiLivreurInterface;
    public TextView loginclient,prenomclient,nomclient,adresseclient,telclient,emailclient,mdpclient,mdpconfirm ;
    RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginclient=findViewById(R.id.loginclient);
        prenomclient=findViewById(R.id.prenomclient);
        nomclient=findViewById(R.id.nomclient);
        adresseclient=findViewById(R.id.adresseclient);
        telclient=findViewById(R.id.telclient);
        emailclient=findViewById(R.id.emailclient);
        mdpclient=findViewById(R.id.mdpclient);
        mdpconfirm=findViewById(R.id.mdpconfirm);

        radioGroup = (RadioGroup) findViewById(R.id.type_radio_group);

        register = (Button) findViewById(R.id.signin);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_fork_round);
    }

    public void Register(View view){

        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);



        if(radioButton.getText().toString().equals("SimpleUser")){
        apiClientInterface = ApiRetrofit.getApiClient().create(ApiClientInterface.class);
        Client client = new Client(nomclient.getText().toString() ,prenomclient.getText().toString(),loginclient.getText().toString(),mdpclient.getText().toString(), emailclient.getText().toString(),adresseclient.getText().toString(),telclient.getText().toString());
        Call<Client> call = apiClientInterface.createClient(client);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {

            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {

            }
        });}

        //if livreur
        if(radioButton.getText().toString().equals("Delivery")){
       apiLivreurInterface = ApiRetrofit.getApiClient().create(ApiLivreurInterface.class);
        Livreur livreur = new Livreur(nomclient.getText().toString() ,prenomclient.getText().toString(),loginclient.getText().toString(),mdpclient.getText().toString(), emailclient.getText().toString(),adresseclient.getText().toString(),telclient.getText().toString());
        Call<Livreur> call1 = apiLivreurInterface.createLivreur(livreur);
        call1.enqueue(new Callback<Livreur>() {
            @Override
            public void onResponse(Call<Livreur> call, Response<Livreur> response) {

            }

            @Override
            public void onFailure(Call<Livreur> call, Throwable t) {

            }
        });}

        Toast.makeText(Register.this,
                "Account created: "+radioButton.getText()+"\nSign In", Toast.LENGTH_SHORT).show();

    }
}
