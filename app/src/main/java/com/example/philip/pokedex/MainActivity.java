package com.example.philip.pokedex;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Philip.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private PokemonAdapter mAdapter;
    ArrayList<Pokemon> pokeList= new ArrayList<Pokemon>();

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_TABLE = " (" +
                    "ID" + " INTEGER PRIMARY KEY," +
                    "NAME" + TEXT_TYPE + COMMA_SEP +
                    "TYPE" + TEXT_TYPE + COMMA_SEP +
                    "ABILITY" + TEXT_TYPE + COMMA_SEP +
                    "BASEHP" + TEXT_TYPE + COMMA_SEP +
                    "BASEATK" + TEXT_TYPE + COMMA_SEP +
                    "BASEDEF" + TEXT_TYPE + COMMA_SEP +
                    "BASESPATK" + TEXT_TYPE + COMMA_SEP +
                    "BASESPDEF" + TEXT_TYPE + COMMA_SEP +
                    "BASESPD" + TEXT_TYPE + COMMA_SEP +
                    "TOTAL" + TEXT_TYPE + " )";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        SQLiteDatabase sqLiteDatabase = getBaseContext().openOrCreateDatabase("pokeDB", MODE_PRIVATE, null);

        //checking for pokemon table existing.
        String checkingForTable = "SELECT name FROM sqlite_master WHERE type='table' AND name='POKEMON'";
        Cursor checkQuery = sqLiteDatabase.rawQuery(checkingForTable, null);
        if(checkQuery.moveToFirst()) {

        } else {
            try {
                //source: http://stackoverflow.com/questions/27281718/how-to-import-csv-into-sqlite-on-android-and-list-the-information
                //create pokemon table + insert data
                InputStreamReader is = new InputStreamReader(getAssets()
                        .open("pokemon.csv"));
                BufferedReader buffer = new BufferedReader(is);
                String line = "";
                String columns = "id, name, type, ability, basehp, baseatk, basedef, basespatk, basespdef, basespd, total";
                String str1 = "INSERT INTO " + "POKEMON" + " (" + columns + ") values(";
                String str2 = ");";

                sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS POKEMON" + SQL_CREATE_TABLE);
                while ((line = buffer.readLine()) != null) {
                    StringBuilder sb = new StringBuilder(str1);
                    String[] str = line.split(",");
                    sb.append("'" + str[0] + "',");
                    sb.append("'" + str[1] + "',");
                    sb.append("'" + str[2] + "',");
                    sb.append("'" + str[3] + "',");
                    sb.append("'" + str[4] + "',");
                    sb.append("'" + str[5] + "',");
                    sb.append("'" + str[6] + "',");
                    sb.append("'" + str[7] + "',");
                    sb.append("'" + str[8] + "',");
                    sb.append("'" + str[9] + "',");
                    sb.append("'" + str[10] + "'");
                    sb.append(str2);
                    sqLiteDatabase.execSQL(sb.toString());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Cursor query = sqLiteDatabase.rawQuery("SELECT id, name from POKEMON", null);
        //should have data now, add into array list
        if (query.moveToFirst()) {
            do {
                int id = query.getInt(0);
                String name = query.getString(1);
                pokeList.add( new Pokemon(id, name));
            } while (query.moveToNext());
        } else {
        }
        //setup up the views
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        initialiseAdapter();
    }

    private void initialiseAdapter() {
        mAdapter = new PokemonAdapter(pokeList);
        mRecyclerView.setAdapter(mAdapter);
    }

}
