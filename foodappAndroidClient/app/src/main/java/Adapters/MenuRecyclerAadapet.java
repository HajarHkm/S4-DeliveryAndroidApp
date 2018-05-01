package Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hajar.foodapp.PlatDetails;
import com.example.hajar.foodapp.R;

import java.util.List;

import entities.Plat;

/**
 * Created by Hajar on 25/04/2018.
 */

public class MenuRecyclerAadapet extends RecyclerView.Adapter<MenuRecyclerAadapet.MyViewHolder> {

    private List<Plat> plats;
    private Context context;

    public MenuRecyclerAadapet(List<Plat> plats, Context context) {
        this.plats = plats;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu,parent,false);

        return new MyViewHolder(view,plats,context);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.nomplat.setText(plats.get(position).getNomplat());
        holder.prixplat.setText(Integer.toString(plats.get(position).getPrixplat())+"DH");
        holder.idplat.setText(Integer.toString(plats.get(position).getIdplat()));
        Glide.with(context).load(plats.get(position).getImagepath()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return plats.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        ImageView image ;
        TextView nomplat,idplat;
        List<Plat> plats;
        Context context;
        TextView prixplat;


        public MyViewHolder(View itemView, List<Plat> plats, Context context) {
            super(itemView);


            this.plats=plats;
            this.context=context;

            itemView.setOnClickListener((View.OnClickListener) this);

            image=(ImageView) itemView.findViewById(R.id.imagePlat);
            nomplat=(TextView) itemView.findViewById(R.id.nomplat);
            idplat=(TextView) itemView.findViewById(R.id.idplat);
            prixplat=(TextView) itemView.findViewById(R.id.prixplat);
        }
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Plat plat=this.plats.get(position);
            Intent toy= new Intent(context, PlatDetails.class);
            toy.putExtra("nomplat",plat.getNomplat());
            toy.putExtra("idplat",idplat.getText().toString());
            toy.putExtra("prixplat",plat.getPrixplat());
            toy.putExtra("imageplat",plat.getImagepath());
            this.context.startActivity(toy);
        }
    }
}
