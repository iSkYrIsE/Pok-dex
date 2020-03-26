package com.ms_diez.pokeupsa;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ObjetoActivity extends AppCompatActivity {

    private ObjetoViewModel objetoViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ObjetoAdapter objetoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);

        this.objetoViewModel = ViewModelProviders.of(this).get(ObjetoViewModel.class);
        this.recyclerView = findViewById(R.id.rv_objeto);
        this.layoutManager = new LinearLayoutManager(this, recyclerView.VERTICAL, false);
        this.objetoAdapter = new ObjetoAdapter(this);

        recyclerView.setAdapter(objetoAdapter);
        recyclerView.setLayoutManager(layoutManager);
        objetoAdapter.setListaObjetos(objetoViewModel.getListaObjetos());




    }
}
