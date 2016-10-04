package com.example.philip.pokedex;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Philip.
 */

public class PokemonActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();
    private SpecificPokemonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specific_pokemon);

        SQLiteDatabase sqLiteDatabase = getBaseContext().openOrCreateDatabase("pokeDB", MODE_PRIVATE, null);
        //Get the intent from PokemonAdapter
        Intent intent = getIntent();
        int pokeid = Integer.parseInt(intent.getStringExtra(Intent.EXTRA_TEXT));
        //Getting data from the database
        Cursor query = sqLiteDatabase.rawQuery("SELECT id, name, type, ability, basehp, " +
                "baseatk, basedef, basespatk, basespdef, basespd, total from POKEMON WHERE id = '" + pokeid +"'", null);

        if (query.moveToFirst()) {
            int id = query.getInt(0);
            String name = query.getString(1);
            String type = query.getString(2);
            String ability = query.getString(3);
            String basehp = query.getString(4);
            String baseatk = query.getString(5);
            String basedef = query.getString(6);
            String basespatk = query.getString(7);
            String basespdef = query.getString(8);
            String basespd = query.getString(9);
            String total = query.getString(10);

            pokeList.add(new Pokemon(id, name, type, ability, basehp,
                    baseatk, basedef, basespatk, basespdef, basespd, total));
        } else {
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        initialiseAdapter();
    }

    private void initialiseAdapter() {
        mAdapter = new SpecificPokemonAdapter(pokeList);
        mRecyclerView.setAdapter(mAdapter);
    }
}

