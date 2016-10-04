package com.example.philip.pokedex;

/**
 * Created by Philip
 */
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {

    private ArrayList<Pokemon> pokeList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView id, name;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.pokeid);
            name = (TextView) view.findViewById(R.id.name);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent showPokeIntent = new Intent(context, PokemonActivity.class);
            //Source: https://developer.android.com/training/basics/firstapp/starting-activity.html
            //Create intent, send to PokemonActivity.class
            TextView textview = (TextView) v.findViewById(R.id.pokeid);
            showPokeIntent.putExtra(Intent.EXTRA_TEXT, textview.getText().toString());
            System.out.println(textview.getText().toString());
            context.startActivity(showPokeIntent);
        }
    }

    public PokemonAdapter(ArrayList<Pokemon> pokeList) {
        this.pokeList = pokeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pokemon pokemon = pokeList.get(position);
        holder.id.setText(String.valueOf(pokemon.getId()));
        holder.name.setText(pokemon.getName());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return pokeList.size();
    }
}

