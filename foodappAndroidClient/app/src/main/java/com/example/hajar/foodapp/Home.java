package com.example.hajar.foodapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import SQLiteCartdb.CartDb;
import SQLiteCartdb.CartOperations;
import countNotif.Utils;

public class Home extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private int mNotificationsCount = 0;
    private SQLiteDatabase mDb;

    int idclient;
    String pubvalue=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        try {
            Bundle extras;

            extras = getIntent().getExtras();
            idclient = extras.getInt("idclient");
            pubvalue = extras.getString("nomrestau");

            System.out.println("client id i got in homepage: " + idclient);
            System.out.println("nomrestau i got in homepage: " + pubvalue);




        }catch(Exception e)
        {

        }

        CartOperations dbHelper = new CartOperations(this);
        mDb = dbHelper.getWritableDatabase();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabs);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container1);


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

        if(pubvalue != null)
        {
            mViewPager.setCurrentItem(1);
            Toast.makeText(this,"Check Menu",Toast.LENGTH_LONG).show();
        }
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bot = new Intent(Home.this, QnA.class);
                startActivity(bot);
            }
        });

        /*FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.container1, new fragment1Home());
        tx.commit();*/

    }

    public void selectFragment(int position){
        mViewPager.setCurrentItem(position, true);
// true is to animate the transaction
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_notifications);
        LayerDrawable icon = (LayerDrawable) item.getIcon();

        // Update LayerDrawable's BadgeDrawable
        Utils.setBadgeCount(this, icon, mNotificationsCount);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.action_notifications: {
                if(idclient != 0) {
                    Intent intent = new Intent(this, Cart.class);
                    intent.putExtra("idclient", idclient);

                    startActivity(intent);
                }else {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
                return true;

            }
            case R.id.action_history: {
                if(idclient != 0) {
                    Intent intent = new Intent(this, ClientHistory.class);
                    intent.putExtra("idclient", idclient);

                    startActivity(intent);
                }else {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        }
        return super.onOptionsItemSelected(item);

    }


    private void updateNotificationsBadge(int count) {
        mNotificationsCount = count;

        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu();
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        new FetchCountTask().execute();
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


    class FetchCountTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... params) {
            String countQuery = "SELECT  * FROM "+ CartDb.TableInfo.table_name;
            Cursor cursor = mDb.rawQuery(countQuery, null);
            int count = cursor.getCount();
            cursor.close();
            return count;
        }

        @Override
        public void onPostExecute(Integer count) {
            updateNotificationsBadge(count);
        }
    }
}
