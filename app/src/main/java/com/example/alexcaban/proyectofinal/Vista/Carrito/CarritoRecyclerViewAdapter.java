package com.example.alexcaban.proyectofinal.Vista.Carrito;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexcaban.proyectofinal.R;

import java.util.ArrayList;

public class CarritoRecyclerViewAdapter extends RecyclerView.Adapter<CarritoRecyclerViewAdapter.CarritoViewHolder> {
    Context context;
    ArrayList<CarritoDTO> arrayList;

    public CarritoRecyclerViewAdapter(Context context, ArrayList<CarritoDTO> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_carrito,viewGroup, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder carritoViewHolder, int i) {
        final CarritoDTO carritoDTO = arrayList.get(i);

        carritoViewHolder.tvDetalleCarrito.setText(carritoDTO.getDetalle());
        carritoViewHolder.tvPrecio.setText(Double.toString(carritoDTO.getPrecio()));
        carritoViewHolder.ivImagenCarrito.setBackgroundResource(carritoDTO.getImagen());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CarritoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagenCarrito;
        TextView tvDetalleCarrito;
        TextView tvPrecio;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenCarrito = (ImageView)itemView.findViewById(R.id.ivProductoCarrito);
            tvDetalleCarrito = (TextView)itemView.findViewById(R.id.tvDetalleCarrito);
            tvPrecio = (TextView)itemView.findViewById(R.id.tvPrecio);
        }
    }
}
