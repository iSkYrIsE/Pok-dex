package com.ms_diez.pokeupsa;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

import me.sargunvohra.lib.pokekotlin.model.Item;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;

public class ObjetoService {

    public static ObjetoService objetoService;
    public static List<ObjetoDTO> listaItems;
    private ObjetoAsyncData asyncData;
    private ObjetoAsyncImg asyncImg;

    private final int primero = 1;
    private final int ultimo = 17;

    public static ObjetoService getInstance(){

        if(objetoService == null){
            System.out.println("Pokemon service");
            objetoService = new ObjetoService();
        }

        return objetoService;
    }

    public ObjetoService(){

        listaItems = new ArrayList<>();

        for(int i=primero; i<ultimo; i++){
            asyncData = new ObjetoAsyncData();
            asyncImg = new ObjetoAsyncImg();

            try {
                Object objeto = asyncData.execute(Integer.toString(i)).get();
                Object imagenItem = asyncImg.execute(((Item) objeto).getSprites().getDefault()).get();
                listaItems.add(new ObjetoDTO((Item) objeto, (Bitmap) imagenItem));

            }catch(Exception e){
                System.out.println("Exception: "+e);
            }
        }
    }

    public List<ObjetoDTO> getListaItems(){
        return listaItems;
    }

    public ObjetoDTO getObjeto(int position){
        return listaItems.get(position);
    }

}
