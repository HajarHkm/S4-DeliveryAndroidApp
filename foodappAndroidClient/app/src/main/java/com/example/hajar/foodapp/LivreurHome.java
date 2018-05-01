package com.example.hajar.foodapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class LivreurHome extends AppCompatActivity {

    private Home.SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livreur_home);

        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabsdelivery);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new Home.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.containerdelivery);

        mSectionsPagerAdapter.addFragment(new ChooseToDeliver(),"");
        mSectionsPagerAdapter.addFragment(new HistoryDelivered(),"");
        mSectionsPagerAdapter.addFragment(new profil(),"");

        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_check);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_person);
    }
}
