package com.ms_diez.pokeupsa;

import android.graphics.Bitmap;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.sargunvohra.lib.pokekotlin.model.Pokemon;

public class PokemonService {

    public static PokemonService pokemonService;
    public static PokemonDTO pokemonDTO;
    public static List<PokemonDTO> listaPersonalPokemon;

    private PokemonAsycnData asycnData;
    private PokemonAsyncImg asyncImg;

    private List<PokemonDTO> listaPokemonDTO;
    private ArrayList<Integer> listaEnteros;

    final int min = 1;
    final int max = 152;
    private final int primeraGeneracion = 151;
    private final int segundaGeneracion = 251;
    private final int terceraGeneracion = 386;

    public static PokemonService getInstance(int generacion){

        if(pokemonService == null){
            System.out.println("Pokemon service");
            pokemonService = new PokemonService(generacion);
        }

        if(listaPersonalPokemon == null){
            listaPersonalPokemon = new ArrayList<>();
        }

        return pokemonService;
    }

    private PokemonService(int generacion) {

        int random;
        listaPokemonDTO = new ArrayList<>();
        listaEnteros = new ArrayList<>();

        try {


            for (int i = 1; i < 10; i++) {
                asycnData = new PokemonAsycnData();
                asyncImg = new PokemonAsyncImg();
                random = new Random().nextInt((max - min) + 1) + min;

                while(listaEnteros.contains(random)){
                    random = new Random().nextInt((max - min) + 1) + min;
                }

                listaEnteros.add(random);

                Object pokemon = asycnData.execute(Integer.toString(random)).get();
                Object imagenPokemon = asyncImg.execute(((Pokemon) pokemon).getSprites().getFrontDefault()).get();

                PokemonDTO pokemonDTO = new PokemonDTO(((Pokemon) pokemon), ((Bitmap) imagenPokemon));
                listaPokemonDTO.add(pokemonDTO);
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }


    }

    public void obtnerPokemonNombre(String nombre){
        asycnData = new PokemonAsycnData();
        asyncImg = new PokemonAsyncImg();


        try{
            Object pokemon = asycnData.execute(Integer.toString(Integer.parseInt(nombre))).get();
            Object imagenPokemon = asyncImg.execute(((Pokemon) pokemon).getSprites().getFrontDefault()).get();

            pokemonDTO = null;
            pokemonDTO = new PokemonDTO((Pokemon) pokemon, (Bitmap) imagenPokemon);
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }

    }

    public PokemonDTO getPokemon(){
        return pokemonDTO;
    }

    public List<PokemonDTO> getListaPokemonDTO() {
        return listaPokemonDTO;

    }

    public List<PokemonDTO> getListaPersonalPokemonDTO() {

        return listaPersonalPokemon;
    }

    public PokemonDTO getPokemon(int position) {
        return listaPokemonDTO.get(position);
    }

    public PokemonDTO getPokemonListaPersonal(int position) {
        return listaPersonalPokemon.get(position);
    }

    public static void resetPokemonService() {
        System.out.println("Función de reseteo");
        pokemonService = null;
    }

    public static int anadirPokemonPersonal(PokemonDTO pokemonDTO){

        int flag = 0;

        for(int i=0; i<listaPersonalPokemon.size(); i++){
            if(pokemonDTO.getId() == listaPersonalPokemon.get(i).getId()){
                flag = 1;
            }
        }

        System.out.println("Tamaño de la lista: "+listaPersonalPokemon.size());
        if(flag == 0){
            listaPersonalPokemon.add(pokemonDTO);
            return 0;
        }else{
            return 1;
        }
    }


    public void borrarPokemon(int position){
        listaPersonalPokemon.remove(position);
    }



}
