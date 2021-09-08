package com.example.alexcaban.proyectofinal.Vista.StockCategorias;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexcaban.proyectofinal.R;
import com.example.alexcaban.proyectofinal.Vista.Stock.StockFragment;

import java.util.ArrayList;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalRVViewHolder> {

    Context context;
    ArrayList<VerticalModel> arrayList;
    private StockFragment stockFragment;


    public VerticalRecyclerViewAdapter(Context context, ArrayList<VerticalModel> arrayList){
        this.arrayList = arrayList;
        this.context = context;

    }
    @NonNull
    @Override
    public VerticalRVViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vertical, viewGroup, false);
        return new VerticalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRVViewHolder verticalRVViewHolder, int i) {

        final VerticalModel verticalModel = arrayList.get(i);
        String Titulo = verticalModel.getTitulo();
        
        ArrayList<HorizontalModel> arrayListHorizontalModels= verticalModel.getArrayList();
        verticalRVViewHolder.textViewTitulo.setText(Titulo);

        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(context, arrayListHorizontalModels );

        verticalRVViewHolder.recyclerView.setHasFixedSize(true);
        verticalRVViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));
        verticalRVViewHolder.recyclerView.setAdapter(horizontalRecyclerViewAdapter);
        stockFragment = new StockFragment();

        verticalRVViewHolder.btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();

                FragmentTransaction fragmentTransaction =  activity.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.contenido, stockFragment);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalRVViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView textViewTitulo;
        Button btnMas;
        
        public VerticalRVViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.recyclerViewHorizontalCategorias);
            textViewTitulo = (TextView)itemView.findViewById(R.id.tvTitulo);
            btnMas = (Button)itemView.findViewById(R.id.btnMas);
        }
    }
}
