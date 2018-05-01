package SQLiteDb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hajar on 29/04/2018.
 */

public class CartOperations extends SQLiteOpenHelper {

    public static final int db_version=1;


    public String create_query = "CREATE TABLE "+CartDb.TableInfo.table_name+" (plat_id INTEGER, plat_nom TEXT, plat_image TEXT,plat_prix INTEGER,plat_quantity INTEGER);";


    public CartOperations(Context context) {
        super(context, CartDb.TableInfo.DB_NAME, null, db_version);
        Log.d("Db operations","Db created "+CartDb.TableInfo.DB_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        System.out.println("heere"+create_query);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CartDb.TableInfo.table_name);
        Log.d("query",create_query);
        sqLiteDatabase.execSQL(create_query);
        Log.d("Db operations","table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void putInformation(CartOperations cartOp, String name,String image, int price, int quantity,int id){

        SQLiteDatabase sq = cartOp.getWritableDatabase();
        ContentValues cv= new ContentValues();

        cv.put("plat_nom",name);
        cv.put("plat_image",image);
        cv.put("plat_prix",price);
        cv.put("plat_quantity",quantity);
        cv.put("plat_id",id);
        long k=sq.insert("cart",null,cv);
        Log.d("Db operations","plat added to cart");

    }

    public Cursor getInformation(CartOperations cartOp)
    {
        SQLiteDatabase sq = cartOp.getReadableDatabase();
        String columns[]= {"plat_nom", "plat_image","plat_prix", "plat_quantity", "plat_id"};
        Cursor cr=sq.query("cart",columns,null,null,null,null,null);
        return cr;
    }


    public void delete(int product_id)
    {
        String[] args={String.valueOf(product_id)};
        getWritableDatabase().delete("cart", "product_id=?", args);

    }

    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(CartDb.TableInfo.table_name,null,null);
        db.execSQL("delete from "+ CartDb.TableInfo.table_name);
        //db.execSQL("TRUNCATE table" + Cart.TableInfo.table_name);
        db.close();
    }

}
