package com.example.alexcaban.proyectofinal.Vista.Carrito;

import android.arch.core.executor.TaskExecutor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexcaban.proyectofinal.R;

import java.util.ArrayList;

public class CarritoFragment extends Fragment {
    RecyclerView carritoRecyclerView;
    CarritoRecyclerViewAdapter carritoRecyclerViewAdapter;
    TextView tvPrecio;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_carrito, container, false);

        carritoRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewCarrito);
        tvPrecio = (TextView)v.findViewById(R.id.TotalPrecio);

        carritoRecyclerView.setHasFixedSize(true);
        carritoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        tvPrecio.setText(Double.toString(CarritoDTO.getTotal()));
        if (CarritoDTO.getArrayList() != null ) {
            carritoRecyclerViewAdapter = new CarritoRecyclerViewAdapter(getContext(), CarritoDTO.getArrayList());
            carritoRecyclerView.setAdapter(carritoRecyclerViewAdapter);
        }
        return v;
    }
}
