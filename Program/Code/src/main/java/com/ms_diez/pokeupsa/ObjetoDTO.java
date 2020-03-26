package com.ms_diez.pokeupsa;

import android.graphics.Bitmap;

import me.sargunvohra.lib.pokekotlin.model.Item;

public class ObjetoDTO {

    private String nombre;
    private String categoria;
    private int precio;
    private Bitmap imagen;

    public ObjetoDTO(Item item, Bitmap bitmap){

        this.nombre = item.getName();
        this.precio = item.getCost();
        this.categoria = item.getCategory().component1();
        this.imagen = bitmap;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }
}
