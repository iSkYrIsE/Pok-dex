package com.ms_diez.pokeupsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonListaPersonalActivity extends AppCompatActivity implements PokemonAdapter.OnItemClickListener{

    public static final String POKEMON_POSITION = "pokemonPosition";
    private PokemonViewModel pokemonViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PokemonAdapter pokemonAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        this.pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        this.recyclerView = findViewById(R.id.rv);
        this.layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        pokemonAdapter = new PokemonAdapter(this);
        pokemonAdapter.setListaPersonalPokemon(pokemonViewModel.getListaPersonalPokemon());
        this.pokemonAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public void onItemClick(View view, int position) {

        Intent intent = new Intent(this, PokemonDescriptionActivity.class );
        intent.putExtra(PokemonDescriptionActivity.POKEMON_POSITION, position);
        intent.putExtra("Identificador", "Personal");
        startActivityForResult(intent, 1);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(resultCode == Activity.RESULT_OK && requestCode == 1){

            pokemonAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Elemento borrado", Toast.LENGTH_SHORT).show();
        }
    }

}
