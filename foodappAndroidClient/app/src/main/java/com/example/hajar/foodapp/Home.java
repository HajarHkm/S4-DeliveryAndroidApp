package com.example.hajar.foodapp;

import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabs);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        mSectionsPagerAdapter.addFragment(new fragment1Home(),"");
        mSectionsPagerAdapter.addFragment(new fragment2Home(),"");
        mSectionsPagerAdapter.addFragment(new fragment3Home(),"");

        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search);
        tabLayout.getTabAt(2).setIcon(R.drawable.deliveryman);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_fork_round);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_notifications);
        LayerDrawable icon = (LayerDrawable) item.getIcon();

        // Update LayerDrawable's BadgeDrawable
        //Utils.setBadgeCount(this, icon, mNotificationsCount);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Bundle extras;

        extras = getIntent().getExtras();
        //idclient = extras.getInt("idclient");
        //System.out.println("client id i got in homepage: "+ idclient);

        switch (item.getItemId()) {

            case R.id.action_notifications: {
                Intent intent = new Intent(this, Cart.class);

               // intent.putExtra("idclient",idclient);

                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    public static class SectionsPagerAdapter extends FragmentPagerAdapter {


        private final List<Fragment> lstFragment = new ArrayList<>();
        private final List<String> titles = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return lstFragment.get(position) ;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return lstFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        public void addFragment(Fragment fragment, String title){
            lstFragment.add(fragment);
            titles.add(title);
        }
    }
}
