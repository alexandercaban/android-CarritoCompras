package com.example.alexcaban.proyectofinal.Vista.StockCategorias;


import java.util.ArrayList;

public class VerticalModel{
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public ArrayList<HorizontalModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<HorizontalModel> arrayList) {
        this.arrayList = arrayList;
    }

    String Titulo;
    ArrayList<HorizontalModel> arrayList;

}
