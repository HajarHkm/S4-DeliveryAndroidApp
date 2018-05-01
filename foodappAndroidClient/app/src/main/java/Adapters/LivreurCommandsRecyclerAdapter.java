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
 * Created by Hajar on 29/04/2018.
 */

public class LivreurCommandsRecyclerAdapter extends RecyclerView.Adapter<LivreurCommandsRecyclerAdapter.MyViewHolder> {

    private List<Commande> mycommandes;
    private Context context;

    public LivreurCommandsRecyclerAdapter(List<Commande> mycommandes, Context context) {
        this.mycommandes = mycommandes;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.livreurcommands,parent,false);

        return new MyViewHolder(view,mycommandes,context);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.adressecom.setText(mycommandes.get(position).getAdresselivraison());
        holder.idcommande.setText(Integer.toString(mycommandes.get(position).getIdcommande()));
        holder.idclientcom.setText(Integer.toString(mycommandes.get(position).getIdclient()));
    }

    @Override
    public int getItemCount() {
        return mycommandes.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView idcommande,idclientcom,adressecom;

        public MyViewHolder(View itemView,List<Commande> mycommandes, Context context) {
            super(itemView);
            idcommande=(TextView) itemView.findViewById(R.id.idcommandeliv);
            idclientcom=(TextView) itemView.findViewById(R.id.idclientcom);
            adressecom=(TextView) itemView.findViewById(R.id.adressecom);
        }
    }
}
