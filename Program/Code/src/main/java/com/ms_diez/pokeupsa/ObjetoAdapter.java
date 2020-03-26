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

public class ObjetoAdapter extends RecyclerView.Adapter<ObjetoAdapter.ObjetoViewHolder> {

    private Context context;
    private List<ObjetoDTO> listaObjetos;

    public ObjetoAdapter(Context context){
        this.context = context;
    }

    public void setListaObjetos(List<ObjetoDTO> listaObjetos){
        this.listaObjetos = listaObjetos;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ObjetoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_objeto, parent, false);
        return new ObjetoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjetoViewHolder holder, int position) {
        ObjetoDTO objetoDTO = listaObjetos.get(position);
        holder.bind(objetoDTO);

    }

    @Override
    public int getItemCount() {
        return (listaObjetos == null)? 0 : listaObjetos.size();
    }

    public class ObjetoViewHolder extends RecyclerView.ViewHolder{

        private TextView nombreObjeto;
        private TextView precioObjeto;
        private TextView categoriaObjeto;
        private ImageView imagenObjeto;


        public ObjetoViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreObjeto = itemView.findViewById(R.id.objeto_name);
            precioObjeto = itemView.findViewById(R.id.objeto_cost);
            categoriaObjeto = itemView.findViewById(R.id.objeto_categoria);
            imagenObjeto = itemView.findViewById(R.id.imagen_objeto);
        }


        public void bind(ObjetoDTO objetoDTO){

            nombreObjeto.setText(objetoDTO.getNombre().substring(0, 1).toUpperCase() + objetoDTO.getNombre().substring(1));
            precioObjeto.setText(""+objetoDTO.getPrecio()+" pokes");
            categoriaObjeto.setText(""+objetoDTO.getCategoria().substring(0, 1).toUpperCase() + objetoDTO.getNombre().substring(1));
            imagenObjeto.setImageBitmap(objetoDTO.getImagen());

        }
    }
}
