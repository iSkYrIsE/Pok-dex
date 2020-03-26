package com.ms_diez.pokeupsa;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class PokemonViewModel extends ViewModel {

    private PokemonService pokemonService;

    public PokemonViewModel(){
        pokemonService = PokemonService.getInstance(1);
    }


    public List<PokemonDTO> getListaPokemon()
    {
        return pokemonService.getListaPokemonDTO();
    }
    public List<PokemonDTO> getListaPersonalPokemon()
    {
        return pokemonService.getListaPersonalPokemonDTO();
    }

    public PokemonDTO getPokemon(int position)
    {
        return pokemonService.getPokemon(position);
    }

    public PokemonDTO getPokemonListaPersonal(int position)
    {
        return pokemonService.getPokemonListaPersonal(position);
    }

    public PokemonDTO getPokemon(){
        return pokemonService.getPokemon();
    }

    public void setPokemon(String nombre){
        pokemonService.obtnerPokemonNombre(nombre);
    }

    public void borrarPokemon(int position){
        pokemonService.borrarPokemon(position);
    }

}
