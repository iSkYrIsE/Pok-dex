package com.ms_diez.pokeupsa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

public class PokemonIndividualDescription extends AppCompatActivity implements View.OnClickListener{

    public static final String POKEMON_POSITION = "pokemonPosition";

    private Button botonAnadir;
    private PokemonViewModel pokemonViewModel;
    private ImageView pokemonImageView;
    private TextView nombre;
    private TextView peso;
    private TextView altura;
    private ListView movimientos;
    private ArrayAdapter<String> adaptador;
    private List<String> movimientosString;
    private int pokemonPosition;
    private PokemonDTO pokemonDto;
    private int personal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_pokemon);

        this.pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);


        pokemonDto = pokemonViewModel.getPokemon();
        anadirMovimientos(pokemonDto);
        buscarElementosView();

        pokemonImageView.setImageBitmap(pokemonDto.getImagePokemon());

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movimientosString) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                tv.setTextColor(Color.WHITE);
                tv.setTextSize(22);
                return view;
            }
        };
        movimientos.setAdapter(adaptador);


        nombre.append(" "+pokemonDto.getNombre().substring(0, 1).toUpperCase() + pokemonDto.getNombre().substring(1));
        peso.append(" "+ (double)pokemonDto.getPeso()/10 +" kilos");
        altura.append(" "+ (double) pokemonDto.getAltura() / 10 +" metros");

        if(personal == 1){
            botonAnadir.setVisibility(View.INVISIBLE);
        }


    }

    private void buscarElementosView(){

        this.botonAnadir = findViewById(R.id.botonAnadir);
        this.pokemonImageView = findViewById(R.id.pokemon_image);
        this.nombre = findViewById(R.id.nombre);
        this.peso = findViewById(R.id.peso);
        this.altura = findViewById(R.id.altura);
        this.movimientos = findViewById(R.id.movimientos);

        botonAnadir.setOnClickListener(this);
    }

    private void anadirMovimientos(PokemonDTO pokemonDTO){
        this.movimientosString = new ArrayList<>();

        for(int i=0; i<3; i++){
            movimientosString.add(pokemonDTO.getMovimientos().get(i).component1().getName().substring(0,1).toUpperCase() + pokemonDTO.getMovimientos().get(i).component1().getName().substring(1));
        }
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        System.out.println("Boton pulsado");

        Intent intent = new Intent();
        intent.putExtra(POKEMON_POSITION, pokemonPosition);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
