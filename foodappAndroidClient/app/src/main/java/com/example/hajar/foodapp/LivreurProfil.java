package com.example.hajar.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class LivreurProfil extends AppCompatActivity {

    TextView nomlivreur, emaillivreur, tellivreur;
    ImageView imagelivreur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livreur_profil);

        Bundle extras;
        extras = getIntent().getExtras();
        String nom = extras.getString("nomlivreur");


        imagelivreur = (ImageView) findViewById(R.id.imagelivreur1);
        nomlivreur =(TextView) findViewById(R.id.nomlivreur1);
        emaillivreur =(TextView) findViewById(R.id.emaillivreur1);
        tellivreur =(TextView) findViewById(R.id.tellivreur1);

        nomlivreur.setText(nom);
       emaillivreur.setText(extras.getString("emaillivreur"));
        tellivreur.setText(extras.getString("tellivreur"));
        Glide.with(this)
                .load(extras.getString("imagelivreur"))
                .into(imagelivreur);
    }
}
