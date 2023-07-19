package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MerchantFragmentAdapter extends RecyclerView.Adapter<MerchantFragmentAdapter.MyViewHolder> {

    Context context;
    ArrayList<itemsofcardview> itemsofcardviewArrayList;
    public MerchantFragmentAdapter(Context context, ArrayList<itemsofcardview> itemsofcardviewArrayList) {
        this.context=context;
        this.itemsofcardviewArrayList=itemsofcardviewArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  v= LayoutInflater.from(context).inflate(R.layout.cardviewmerchant,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        itemsofcardview itemsofcardview=itemsofcardviewArrayList.get(position);

        holder.profileImage.setImageResource(itemsofcardview.profileImage);
//        holder.distanceofstudent.setImageResource(itemsofcardview.distanceofstudent);
        holder.name.setText(itemsofcardview.name);
        holder.address.setText(itemsofcardview.address);
        holder.distance.setText(itemsofcardview.distance);
        holder.bio.setText(itemsofcardview.bio);
        holder.description.setText(itemsofcardview.description);

    }

    @Override
    public int getItemCount() {
        return itemsofcardviewArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView profileImage;
        ProgressBar distanceofstudent;
        TextView name;
        TextView address;
        TextView distance;
        TextView bio;
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage=itemView.findViewById(R.id.profileImageView);
            distanceofstudent=itemView.findViewById(R.id.distanceofstudentIV);
            name=itemView.findViewById(R.id.nameTxtView);
            address=itemView.findViewById(R.id.addressTxtView);
            distance=itemView.findViewById(R.id.distanceTxtView);
            bio=itemView.findViewById(R.id.bioTxtView);
            description=itemView.findViewById(R.id.descriptionTxtView);
        }
    }

}


