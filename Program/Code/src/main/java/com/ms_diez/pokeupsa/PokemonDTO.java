package com.ms_diez.pokeupsa;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonAbility;
import me.sargunvohra.lib.pokekotlin.model.PokemonForm;
import me.sargunvohra.lib.pokekotlin.model.PokemonMove;
import me.sargunvohra.lib.pokekotlin.model.PokemonType;

public class PokemonDTO {

    private String nombre;
    private List<PokemonType> tipos;
    private List<PokemonAbility> habilidades;
    private List<PokemonMove> movimientos;
    private List<NamedApiResource> especies;
    private int altura;
    private int peso;
    private int id;

    private Bitmap imagePokemon;

    public PokemonDTO(Pokemon pokemon, Bitmap imagenPokemon){

        this.imagePokemon = imagenPokemon;
        this.nombre = pokemon.getName();
        this.tipos = pokemon.getTypes();
        this.habilidades = pokemon.getAbilities();
        this.altura = pokemon.getHeight();
        this.peso = pokemon.getWeight();
        this.movimientos = pokemon.getMoves();
        this.id = pokemon.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PokemonAbility> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<PokemonAbility> habilidades) {
        this.habilidades = habilidades;
    }

    public List<NamedApiResource> getEspecies() {
        return especies;
    }

    public void setEspecies(List<NamedApiResource> especies) {
        this.especies = especies;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public List<PokemonMove> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<PokemonMove> movimientos) {
        this.movimientos = movimientos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PokemonType> getTipos() {
        return tipos;
    }

    public void setTipos(List<PokemonType> tipos) {
        this.tipos = tipos;
    }

    public Bitmap getImagePokemon() {
        return imagePokemon;
    }

    public void setImagePokemon(Bitmap imagePokemon) {
        this.imagePokemon = imagePokemon;
    }
}
