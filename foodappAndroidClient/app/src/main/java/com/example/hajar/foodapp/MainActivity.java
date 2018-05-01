package com.example.hajar.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button signIn,register,order;

    public void order(){
        order= (Button)findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainActivity.this, Home.class);
                startActivity(login);
            }
        });
    }

    public void SignIn(){
        signIn= (Button)findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });
    }

    public void Register(){
        register= (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainActivity.this, Register.class);
                startActivity(login);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIn();
        Register();
        order();
    }
}
