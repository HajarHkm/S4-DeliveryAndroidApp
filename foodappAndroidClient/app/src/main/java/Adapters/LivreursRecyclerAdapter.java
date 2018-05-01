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
import com.example.hajar.foodapp.LivreurProfil;
import com.example.hajar.foodapp.PlatDetails;
import com.example.hajar.foodapp.R;
import com.example.hajar.foodapp.profil;

import org.w3c.dom.Text;

import java.util.List;

import entities.Livreur;
import entities.Plat;

/**
 * Created by Hajar on 01/05/2018.
 */

public class LivreursRecyclerAdapter extends RecyclerView.Adapter<LivreursRecyclerAdapter.MyViewHolder> {

    private List<Livreur> livreurs;
    private Context context;

    public LivreursRecyclerAdapter(List<Livreur> livreurs, Context context) {
        this.livreurs = livreurs;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.livreurs,parent,false);

        return new MyViewHolder(view,livreurs,context);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nomlivreur.setText(livreurs.get(position).getNomlivreur());
        holder.emaillivreur.setText(livreurs.get(position).getEmaillivreur());
        holder.tellivreur.setText(livreurs.get(position).getTellivreurt());
        Glide.with(context).load(livreurs.get(position).getImagelivreur()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return livreurs.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image ;
        TextView nomlivreur;
        TextView emaillivreur, tellivreur;

        private List<Livreur> livreurs;
        private Context context;

        public MyViewHolder(View itemView, List<Livreur> livreurs, Context context) {
            super(itemView);

            this.livreurs = livreurs;
            this.context = context;

            itemView.setOnClickListener((View.OnClickListener) this);

            image = (ImageView) itemView.findViewById(R.id.imagelivreur);
            nomlivreur = itemView.findViewById(R.id.nomlivreur);
            emaillivreur = itemView.findViewById(R.id.emaillivreuro);
            tellivreur = itemView.findViewById(R.id.tellivreuro);

        }
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                Livreur livreur=this.livreurs.get(position);

                Intent toy= new Intent(context, LivreurProfil.class);
                toy.putExtra("nomlivreur",livreur.getNomlivreur());
                toy.putExtra("emaillivreur",livreur.getEmaillivreur());
                toy.putExtra("tellivreur",livreur.getTellivreurt());
                toy.putExtra("imagelivreur",livreur.getImagelivreur());
                this.context.startActivity(toy);
            }


    }

}
