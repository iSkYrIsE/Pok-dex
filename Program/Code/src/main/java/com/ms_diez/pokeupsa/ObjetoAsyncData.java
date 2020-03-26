package com.ms_diez.pokeupsa;

import android.os.AsyncTask;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Item;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

public class ObjetoAsyncData extends AsyncTask<String, Item, Item> {

    private Item item;

    @Override
    protected Item doInBackground(String... strings) {

        PokeApi pokeApi;

        pokeApi = new PokeApiClient();
        item = null;
        item = pokeApi.getItem(Integer.parseInt(strings[0]));

        return item;
    }
}
