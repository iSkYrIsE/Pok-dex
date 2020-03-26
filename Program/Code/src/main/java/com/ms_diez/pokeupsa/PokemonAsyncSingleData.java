package com.ms_diez.pokeupsa;

import android.os.AsyncTask;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

public class PokemonAsyncSingleData  extends AsyncTask<String, Pokemon, Pokemon> {

    private Pokemon pokemon;

    @Override
    protected Pokemon doInBackground(String... strings) {

        PokeApi pokeApi;
        pokeApi = new PokeApiClient();
        pokemon = null;

        pokemon = pokeApi.getPokemon(Integer.parseInt(strings[0]));

        return pokemon;
    }
}
