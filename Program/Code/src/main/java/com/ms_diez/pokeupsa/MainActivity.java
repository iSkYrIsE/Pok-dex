package com.ms_diez.pokeupsa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button pokedexAleatoria;
    private Button buscarPokemonNombre;
    private Button listaPersonalPokemon;
    private Button listaPersonalObjetos;
    private PokemonViewModel pokemonViewModel;
    private ObjetoViewModel objetoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        //this.objetoViewModel = ViewModelProviders.of(this).get(ObjetoViewModel.class);

        buscarElementosView();

    }


    private void buscarElementosView(){

        this.pokedexAleatoria = findViewById(R.id.pokedex_aleatoria);
        this.buscarPokemonNombre = findViewById(R.id.buscar_pokemon);
        this.listaPersonalPokemon = findViewById(R.id.listaPersonal);
        this.listaPersonalObjetos = findViewById(R.id.listaObjetos);
        this.pokedexAleatoria.setOnClickListener(this);
        this.buscarPokemonNombre.setOnClickListener(this);
        this.listaPersonalPokemon.setOnClickListener(this);
        this.listaPersonalObjetos.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){

            case R.id.pokedex_aleatoria:
                intent = new Intent(this, PokemonActivity.class);
                startActivity(intent);

                break;

            case R.id.buscar_pokemon:
                EditText et = findViewById(R.id.nombre_pokemon);

                if(Integer.parseInt(""+et.getText()) > 0 && Integer.parseInt(""+et.getText())< 400){
                    pokemonViewModel.setPokemon(""+et.getText());
                    et.setText("");
                    intent = new Intent(this, PokemonIndividualDescription.class);
                    startActivityForResult(intent, 1);
                }else{
                    Toast.makeText(this, "No existe un pokemon para ese ID", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.listaPersonal:
                intent = new Intent(this, PokemonListaPersonalActivity.class);
                startActivity(intent);
                break;

            case R.id.listaObjetos:
                intent = new Intent(this, ObjetoActivity.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if(resultCode == Activity.RESULT_OK && requestCode == 1){

            int resultado = PokemonService.anadirPokemonPersonal(pokemonViewModel.getPokemon());

            if(resultado == 0){
                Toast.makeText(this, "Pokemon anadido correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El pokemon existia en la lista", Toast.LENGTH_SHORT).show();
            }
        }

    }
}