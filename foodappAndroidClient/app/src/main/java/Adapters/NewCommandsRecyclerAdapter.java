package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hajar.foodapp.R;

import java.util.List;

import entities.Commande;

/**
 * Created by Hajar on 28/04/2018.
 */

public class NewCommandsRecyclerAdapter extends RecyclerView.Adapter<NewCommandsRecyclerAdapter.MyViewHolder>{

    private List<Commande> commandes;
    private Context context;

    public NewCommandsRecyclerAdapter(List<Commande> commandes, Context context) {
        this.commandes = commandes;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.newcommandes,parent,false);

        return new MyViewHolder(view,commandes,context);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.adressecom.setText(commandes.get(position).getAdresselivraison());
        holder.idcommande.setText(Integer.toString(commandes.get(position).getIdcommande()));
        holder.idclientcom.setText(Integer.toString(commandes.get(position).getIdclient()));

    }

    @Override
    public int getItemCount() {
        return commandes.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView idcommande,idclientcom,adressecom;

        public MyViewHolder(View itemView,List<Commande> commandes, Context context) {
            super(itemView);
            idcommande=(TextView) itemView.findViewById(R.id.idcommande);
            idclientcom=(TextView) itemView.findViewById(R.id.idclientcom);
            adressecom=(TextView) itemView.findViewById(R.id.adressecom);
        }
    }
}
