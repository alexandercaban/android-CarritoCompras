package com.example.alexcaban.proyectofinal.Vista.StockCategorias;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alexcaban.proyectofinal.R;

import java.util.ArrayList;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class StockCategoriasFragment extends Fragment {

    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewAdapter verticalRecyclerViewAdapter;
    ArrayList<VerticalModel> arrayListVertical;
    FlipperLayout flipperLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stock_categorias, container, false);

        verticalRecyclerView = (RecyclerView)v.findViewById(R.id.recyclerViewCategorias);
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        arrayListVertical = new ArrayList<>();

        verticalRecyclerViewAdapter = new VerticalRecyclerViewAdapter(getContext(),arrayListVertical);
        verticalRecyclerView.setAdapter(verticalRecyclerViewAdapter);
        flipperLayout = (FlipperLayout)v.findViewById(R.id.flipper);
        
        setData();
        setLayout();

        return v;
    }

    private void setData() {

        for (int i=1; i<=10; i++){
            VerticalModel verticalModel = new VerticalModel();
            verticalModel.setTitulo("Categoría "+ i);
            ArrayList<HorizontalModel> arrayListHorizontal = new ArrayList<>();

            for (int j= 0; j<=10; j++){
                HorizontalModel horizontalModel = new HorizontalModel();
                horizontalModel.setDescripcion("Descripcion "+ j);
                horizontalModel.setNombre("Producto "+ j);

                arrayListHorizontal.add(horizontalModel);
            }

            verticalModel.setArrayList(arrayListHorizontal);
            arrayListVertical.add(verticalModel);
        }
        verticalRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void setLayout(){
        int url[] = new int[]{
                R.drawable.tp008,
                R.drawable.pr902,
                R.drawable.techbox,
                R.drawable.pda001
        };

        for (int i = 0; i <3; i++){
            FlipperView view = new FlipperView(getActivity().getBaseContext());
            view.setImageDrawable(url[i]).setDescription("image" +(i+1));
            flipperLayout.addFlipperView(view);
            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {
                    Toast.makeText( getActivity(), ""+ (flipperLayout.getCurrentPagePosition()+ 1), Toast.LENGTH_LONG).show();
                }
            });
        }
    }


}
