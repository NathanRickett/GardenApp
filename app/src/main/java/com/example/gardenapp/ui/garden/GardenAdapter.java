package com.example.gardenapp.ui.garden;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gardenapp.R;
import com.example.gardenapp.RecyclerViewInterface;
import com.example.gardenapp.data.plant.Plant;

import java.util.ArrayList;

public class GardenAdapter extends RecyclerView.Adapter<GardenAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Plant> plants;

    private MyViewHolder viewHolder;

    private final RecyclerViewInterface rvInterface;

    public GardenAdapter(Context context, ArrayList<Plant> plants, RecyclerViewInterface rvInterface) {
        this.context = context;
        this.plants = plants;
        this.rvInterface = rvInterface;
    }


    @NonNull
    @Override
    public GardenAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this is where you inflate the layout (Gives a look to our cards)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.garden_card_layout, parent, false);
        viewHolder = new GardenAdapter.MyViewHolder(view, rvInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GardenAdapter.MyViewHolder holder, int position) {
        //assigning values to the views we created in the layout file
        //based on the position of the recycler view
        holder.plantCardTitle.setText(this.plants.get(position).getPlantName());
    }

    @Override
    public int getItemCount() {
        //get the number of items that need to be updated
        if (this.plants != null) {
            return this.plants.size();
        }
        return 0;
    }

    public MyViewHolder getViewHolder() {
        return viewHolder;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //grabbing the views from our layout file
        //somewhat like an on create method, and how that would fetch the XML file and inflate it to get a view

        CardView plantCard;
        TextView plantCardTitle;
        RecyclerViewInterface rvInterface;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface rvInterface) {
            super(itemView);
            this.plantCard = itemView.findViewById(R.id.plant_card);
            this.plantCardTitle = itemView.findViewById(R.id.plant_card_title);
            this.rvInterface = rvInterface;

            //listen to a card click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (rvInterface != null) {
                        if (position != RecyclerView.NO_POSITION) {
                            rvInterface.onItemClick(position);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    if (rvInterface != null) {
                        if (position != RecyclerView.NO_POSITION) {
                            rvInterface.onItemLongClick(position);
                        }
                    }
                    return false;
                }
            });
        }

        public CardView getPlantCard() {
            return plantCard;
        }
    }
}