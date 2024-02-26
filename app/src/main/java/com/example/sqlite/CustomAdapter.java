package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

   private Context context;
    private ArrayList<String> player_id, player_name, player_number, player_club,player_position;

    CustomAdapter(Context context, ArrayList player_id, ArrayList player_name, ArrayList player_club, ArrayList player_number, ArrayList player_position){

        this.context = context;
        this.player_id = player_id;
        this.player_name = player_name;
        this.player_number = player_number;
        this.player_club = player_club;
        this.player_position = player_position;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context); // Obtain a LayoutInflater instance from the given context.
        View view = inflater.inflate(R.layout.players,parent,false); //Inflate the layout specified by R.layout.players to create a View
        return  new ViewHolder(view); //Return a new ViewHolder instance, passing the inflated view as a parameter.
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        // fill the textview from the arraylist

        holder.playerId.setText(String.valueOf(player_id.get(position)));
        holder.playerClub.setText(String.valueOf(player_club.get(position)));
        holder.playerName.setText(String.valueOf(player_name.get(position)));
        holder.playerPosition.setText(String.valueOf(player_position.get(position)));
        holder.playerNumber.setText(String.valueOf(player_number.get(position)));
    }

    @Override
    public int getItemCount() {
        return player_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView playerId, playerName, playerClub,playerNumber, playerPosition;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // obtain the differents textviews and associate it wtih each id
            playerId = itemView.findViewById(R.id.player_id);
            playerName = itemView.findViewById(R.id.PlayerName);
            playerClub = itemView.findViewById(R.id.player_club);
            playerNumber = itemView.findViewById(R.id.player_number);
            playerPosition = itemView.findViewById(R.id.player_position);
        }
    }
}
