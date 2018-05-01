package SQLiteDb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hajar.foodapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hajar on 29/04/2018.
 */

public class CartAdapter extends ArrayAdapter {

    List list=new ArrayList();
    private Context context;

    int highLightedItemNumber = -1;

    public CartAdapter( Context context, int resource) {
        super(context, resource);
    }


    @Override
    public void add( Object object) {

        list.add(object);
        super.add(object);
    }



    @Override
    public int getCount() {
        return list.size();
    }



    @Override
    public Object getItem(int position) {
        return list.get(position);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row= convertView;
        ProductHolder productHolder;
        if(row == null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row= layoutInflater.inflate(R.layout.cart_item,parent,false);
            productHolder = new ProductHolder();
            productHolder.cartImage=(ImageView) row.findViewById(R.id.cartImage);
            productHolder.productCartName=(TextView) row.findViewById(R.id.productCartName);
            productHolder.Cartquantity=(TextView) row.findViewById(R.id.Cartquantity);
            productHolder.Cartprice=(TextView) row.findViewById(R.id.Cartprice);
            productHolder.product_id=(TextView) row.findViewById(R.id.product_id);
            row.setTag(productHolder);

        }
        else
        {
            productHolder=(ProductHolder) row.getTag();
        }

        Cartclass plat =(Cartclass) getItem(position);
        productHolder.productCartName.setText(plat.getPlat_nom());
        productHolder.Cartquantity.setText(Integer.toString(plat.getPlat_quantity()));
        productHolder.Cartprice.setText(Integer.toString(plat.getPlat_prix()));
        productHolder.product_id.setText(Integer.toString(plat.getPlat_id()));

        String image=plat.getPlat_image();
        Glide.with(getContext()).load(plat.getPlat_image()).into(productHolder.cartImage);



        return row;
    }

    static class ProductHolder {
        TextView productCartName,Cartquantity,Cartprice,product_id;
        ImageView cartImage;

    }

}
