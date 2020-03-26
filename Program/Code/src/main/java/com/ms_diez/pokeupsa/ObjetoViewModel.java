package com.ms_diez.pokeupsa;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class ObjetoViewModel extends ViewModel {

    private ObjetoService objetoService;

    public ObjetoViewModel(){
        objetoService = ObjetoService.getInstance();
    }

    public List<ObjetoDTO> getListaObjetos(){
        return objetoService.getListaItems();
    }

    public ObjetoDTO getObjeto(int position){
        return objetoService.getObjeto(position);
    }
}
