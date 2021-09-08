package com.example.alexcaban.proyectofinal.Vista.Carrito;

import java.util.ArrayList;

public class CarritoDTO {
    public String Detalle;
    public int Imagen;
    public double precio;
    public static ArrayList<CarritoDTO> arrayList;
    public static double totalPrecio;


    public static double getTotal() {
        return totalPrecio;
    }

    public static void setTotal(double total) {
        totalPrecio = total;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public static ArrayList<CarritoDTO> getArrayList() {
        return arrayList;
    }

    public static void setArrayList(ArrayList<CarritoDTO> arrayLista) {
        arrayList = arrayLista;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }


}
