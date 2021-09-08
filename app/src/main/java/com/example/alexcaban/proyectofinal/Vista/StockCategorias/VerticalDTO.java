package com.example.alexcaban.proyectofinal.Vista.StockCategorias;


import java.util.ArrayList;

public class VerticalDTO {
    String Titulo;
    ArrayList<HorizontalDTO> arrayList;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public ArrayList<HorizontalDTO> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<HorizontalDTO> arrayList) {
        this.arrayList = arrayList;
    }


}
