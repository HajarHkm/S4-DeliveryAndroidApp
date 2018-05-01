package SQLiteDb;

import android.provider.BaseColumns;

/**
 * Created by Hajar on 29/04/2018.
 */

public class CartDb
{

        public CartDb() {
        }

        public static abstract class TableInfo implements BaseColumns
        {
            public final String plat_id ="id";
            public final String plat_nom ="name";
            public final String plat_image="image";
            public final String plat_prix="price";
            public final String plat_quantity="quantity";
            public static final String DB_NAME="cart_db";
            public static final String table_name="cart";

        }
}
