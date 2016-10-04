package com.example.philip.pokedex;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;
import static android.content.Intent.parseUri;

/**
 * Created by Philip.
 */

public class SpecificPokemonAdapter extends RecyclerView.Adapter<SpecificPokemonAdapter.MyViewHolder>{

    private ArrayList<Pokemon> pokeList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView id, name, type, ability, basehp, baseatk, basedef, basespatk, basespdef, basespd, total;


        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.pokeid);
            name = (TextView) view.findViewById(R.id.name);
            type = (TextView) view.findViewById(R.id.type);
            ability = (TextView) view.findViewById(R.id.ability);
            basehp = (TextView) view.findViewById(R.id.basehp);
            baseatk = (TextView) view.findViewById(R.id.baseatk);
            basedef = (TextView) view.findViewById(R.id.basedef);
            basespatk = (TextView) view.findViewById(R.id.basespatk);
            basespdef = (TextView) view.findViewById(R.id.basespdef);
            basespd = (TextView) view.findViewById(R.id.basespd);
            total = (TextView) view.findViewById(R.id.total);
        }
        @Override
        public void onClick(View v) {
        }
    }

    public SpecificPokemonAdapter(ArrayList<Pokemon> pokeList) {
        this.pokeList = pokeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.specific_pokemon_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    //Displays the stats, from the ArrayList
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pokemon pokemon = pokeList.get(position);
        holder.id.setText("#" + String.valueOf(pokemon.getId()));
        holder.name.setText(pokemon.getName());
        holder.type.setText("Type: " + pokemon.getType());
        holder.ability.setText("Abilities: " + pokemon.getAbility());
        holder.basehp.setText("Base HP: " + pokemon.getBaseHp());
        holder.baseatk.setText("Base Attack: " + pokemon.getBaseAtk());
        holder.basedef.setText("Base Defence: " + pokemon.getBaseDef());
        holder.basespatk.setText("Base SP Attack: " + pokemon.getBaseSpAtk());
        holder.basespdef.setText("Base SP Defence: " + pokemon.getBaseSpDef());
        holder.basespd.setText("Base Speed: " + pokemon.getBaseSpd());
        holder.total.setText("Total: " + pokemon.getTotal());

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

