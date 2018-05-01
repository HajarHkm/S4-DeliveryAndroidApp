package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hajar.foodapp.R;

import java.util.List;

import entities.Pub;

/**
 * Created by Hajar on 25/04/2018.
 */

public class PubRecyclerAdapter extends RecyclerView.Adapter<PubRecyclerAdapter.MyViewHolder> {

    private List<Pub> pubs;
    private Context context;

    public PubRecyclerAdapter(List<Pub> pubs, Context context) {
        this.pubs = pubs;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pub,parent,false);

        return new MyViewHolder(view,pubs,context);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Glide.with(context).load(pubs.get(position).getPath()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return pubs.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image ;


        public MyViewHolder(View itemView, List<Pub> pubs, Context context) {
            super(itemView);

            image=(ImageView) itemView.findViewById(R.id.imagePub);

        }
    }
}
