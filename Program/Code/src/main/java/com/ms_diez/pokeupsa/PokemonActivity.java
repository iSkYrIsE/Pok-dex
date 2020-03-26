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

public class PokemonActivity extends AppCompatActivity implements PokemonAdapter.OnItemClickListener{

    public static final String POKEMON_POSITION = "pokemonPosition";
    private PokemonViewModel pokemonViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        this.pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        this.recyclerView = findViewById(R.id.rv);
        this.layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        pokemonAdapter = new PokemonAdapter(this);
        this.pokemonAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(layoutManager);



        pokemonAdapter.setListaPokemon(pokemonViewModel.getListaPokemon());
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, PokemonDescriptionActivity.class );
        intent.putExtra(PokemonDescriptionActivity.POKEMON_POSITION, position);
        intent.putExtra("Identificador", "Aleatoria");
        startActivityForResult(intent, 1);
    }

    @Override
    public void onBackPressed() {

        PokemonService.resetPokemonService();
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if(resultCode == Activity.RESULT_OK && requestCode == 1){
            int pokemonPosition = data.getIntExtra(POKEMON_POSITION, -1);

            int resultado = PokemonService.anadirPokemonPersonal(pokemonViewModel.getPokemon(pokemonPosition));

            if(resultado == 0){
                Toast.makeText(this, "Pokemon anadido correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El pokemon existia en la lista", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
