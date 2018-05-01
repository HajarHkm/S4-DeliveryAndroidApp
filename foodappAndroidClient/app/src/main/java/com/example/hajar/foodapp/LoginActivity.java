package com.example.hajar.foodapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ServerCall.ApiRetrofit;
import entities.Client;
import entities.Livreur;
import interfaces.ApiClientInterface;
import interfaces.ApiLivreurInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {


    // UI references.
    private EditText mloginView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button signin;

    //api
    private ApiClientInterface clientInterface;
    private ApiLivreurInterface livreurInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mloginView = (EditText) findViewById(R.id.login);
        mPasswordView = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_fork_round);

    }

    public void signIn(View view){
        clientInterface = ApiRetrofit.getApiClient().create(ApiClientInterface.class);
        final Call<Client> call=clientInterface.login(mloginView.getText().toString(),mPasswordView.getText().toString());
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                System.out.println("*******in on responseclient:" +response.body());
                Client client;
                client= response.body();
                if(client.getIdclient() != 0){
                System.out.println("id "+ client.getIdclient());
                System.out.println("name: "+ client.getNomclient());
                System.out.println("login: "+ client.getLoginclient());
                Intent toy = new Intent(LoginActivity.this, Home.class);
                toy.putExtra("idclient",client.getIdclient());
                startActivity(toy);}

            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {

            }
        });

        livreurInterface = ApiRetrofit.getApiClient().create(ApiLivreurInterface.class);
        final Call<Livreur> call1=livreurInterface.login(mloginView.getText().toString(),mPasswordView.getText().toString());
        call1.enqueue(new Callback<Livreur>() {
            @Override
            public void onResponse(Call<Livreur> call, Response<Livreur> response) {
                System.out.println("*******in on responselivreur:" +response.body());
                Livreur livreur;
                livreur= response.body();
                if(livreur.getIdlivreur() != 0){
                System.out.println("idlivreur "+ livreur.getIdlivreur());
                System.out.println("name: "+ livreur.getNomlivreur());
                System.out.println("login: "+ livreur.getLoginlivreur());
                Intent toy = new Intent(LoginActivity.this, LivreurHome.class);
                toy.putExtra("idlivreur",livreur.getIdlivreur());
                startActivity(toy);}

            }

            @Override
            public void onFailure(Call<Livreur> call, Throwable t) {

            }
        });


    }



}

