package com.ms_diez.pokeupsa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<PokemonDTO> listaPokemon;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public static interface OnItemClickListener
    {
        public void onItemClick(View view, int posotion);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }



    public PokemonAdapter(Context context){
        this.context = context;
    }

    public void setListaPokemon(List<PokemonDTO> listaPokemon){

        //System.out.println("fsafafasfa"+listaPokemon.get(0).getNombre());
        this.listaPokemon = listaPokemon;
        notifyDataSetChanged();
    }

    public void setListaPersonalPokemon(List<PokemonDTO> listaPokemon){

        this.listaPokemon = listaPokemon;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.item_pokemon, parent, false);

        return new PokemonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        PokemonDTO pokemonDTO = listaPokemon.get(position);
        holder.bind(pokemonDTO);
    }

    @Override
    public int getItemCount() {
        return(listaPokemon == null)? 0: listaPokemon.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView pokemonNombre;
        private ImageView pokemonImagen;
        private TextView pokemonTipo;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);

            pokemonNombre = itemView.findViewById(R.id.pokemnon_name);
            pokemonTipo = itemView.findViewById(R.id.pokemon_type);
            pokemonImagen = itemView.findViewById(R.id.imagePokemon);

            itemView.setOnClickListener(this);
        }

        public void bind(PokemonDTO pokemonDTO){
            pokemonNombre.setText(pokemonDTO.getNombre().substring(0, 1).toUpperCase() + pokemonDTO.getNombre().substring(1));
            pokemonTipo.setText(pokemonDTO.getTipos().get(0).getType().component1().substring(0, 1).toUpperCase() + pokemonDTO.getTipos().get(0).getType().component1().substring(1));
            if(pokemonDTO.getTipos().size() == 2){
                pokemonTipo.setText(pokemonDTO.getTipos().get(0).getType().component1().substring(0, 1).toUpperCase() + pokemonDTO.getTipos().get(0).getType().component1().substring(1)+
                        "/"+pokemonDTO.getTipos().get(1).getType().component1().substring(0, 1).toUpperCase() + pokemonDTO.getTipos().get(1).getType().component1().substring(1));
            }
            pokemonImagen.setImageBitmap(pokemonDTO.getImagePokemon());
        }


        @Override
        public void onClick(View view) {
            if ( onItemClickListener != null )
            {
                onItemClickListener.onItemClick(this.itemView, this.getAdapterPosition() );
            }
        }
    }
}
