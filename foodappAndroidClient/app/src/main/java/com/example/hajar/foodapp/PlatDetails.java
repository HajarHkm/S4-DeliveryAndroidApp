package com.example.hajar.foodapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import SQLiteCartdb.BackGroundTask;
import SQLiteCartdb.CartDb;
import SQLiteCartdb.CartOperations;

public class PlatDetails extends AppCompatActivity {


    ImageView imageplat ;
    TextView description;
    TextView price,sonid;
    TextView quantity_text_view;
    TextView cost_text_view;
    Button cart_button;

    String product_image,product_name,product_price,product_quantity,product_id;

    int prix;
    private int mQuantity = 1;
    private int mTotalPrice;

    private int mNotificationsCount = 0;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat_details);

        CartOperations dbHelper = new CartOperations(this);
        mDb = dbHelper.getWritableDatabase();

        imageplat = (ImageView) findViewById(R.id.productImage);

        Glide.with(this)
                .load(getIntent().getStringExtra("imageplat"))
                .into(imageplat);


        description =(TextView) findViewById(R.id.description);
        price =(TextView) findViewById(R.id.price);
        sonid=(TextView) findViewById(R.id.sonid) ;
        quantity_text_view =(TextView) findViewById(R.id.quantity_text_view);
        cost_text_view =(TextView) findViewById(R.id.cost_text_view);
        description.setText(getIntent().getStringExtra("nomplat"));
        price.setText(String.valueOf(getIntent().getExtras().getInt("prixplat")));
        cost_text_view.setText(String.valueOf(getIntent().getExtras().getInt("prixplat")));
        System.out.println("*****second"+getIntent().getStringExtra("idplat"));
        sonid.setText(String.valueOf(getIntent().getStringExtra("idplat")));
        //RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingLevel);
        //ratingBar.setRating(2); // should actually get rating from cart table


        cart_button =(Button) findViewById(R.id.cart_button);
    }


    public void increment(View view){

        prix = getIntent().getExtras().getInt("prixplat");
        mQuantity = mQuantity + 1;
        displayQuantity(mQuantity);
        mTotalPrice = mQuantity * prix;
        displayCost(mTotalPrice);
    }

    public void decrement(View view){
        if (mQuantity > 1){

            mQuantity = mQuantity - 1;
            displayQuantity(mQuantity);
            mTotalPrice = mQuantity * prix;
            displayCost(mTotalPrice);

        }
    }

    private void updateNotificationsBadge(int count) {
        mNotificationsCount = count;

        // force the ActionBar to relayout its MenuItems.
        // onCreateOptionsMenu(Menu) will be called again.
        invalidateOptionsMenu();
    }

    private void displayQuantity(int numberOfItems) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(numberOfItems));
    }

    private void displayCost(double totalPrice) {

        //String convertPrice = NumberFormat.getCurrencyInstance().format(totalPrice);
        cost_text_view.setText(String.valueOf(totalPrice));
    }

    BackGroundTask backGroundTask=new BackGroundTask(this);
    public void addToCart(View view){
        product_image=getIntent().getStringExtra("imageplat");
        product_name=getIntent().getStringExtra("nomplat");
        product_price=String.valueOf(price.getText().toString());
        product_quantity= quantity_text_view.getText().toString();
        product_id=sonid.getText().toString();

        backGroundTask.execute("add_product",product_image,product_name,product_price,product_quantity,product_id);
        finish();
    }
    class FetchCountTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected Integer doInBackground(Void... params) {
            String countQuery = "SELECT  * FROM " + CartDb.TableInfo.table_name;
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
