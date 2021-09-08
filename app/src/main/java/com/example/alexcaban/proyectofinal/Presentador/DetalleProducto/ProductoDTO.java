package com.example.alexcaban.proyectofinal.Presentador.DetalleProducto;

import com.example.alexcaban.proyectofinal.R;

public class ProductoDTO {
    private static final String LARGE_BASE_URL = "";
    private static final String THUMB_BASE_URL = "";
    private final String Descripcion;
    private final String Detalle;
    private final int Imagen;

    public String getDescripcion() {
        return Descripcion;
    }

    public String getDetalle() {
        return Detalle;
    }

    public int getImagen() {
        return Imagen;
    }



    ProductoDTO(String descripcion, String detalle, int imagen) {
        Descripcion = descripcion;
        Detalle = detalle;
        Imagen = imagen;
    }

    public static ProductoDTO[] PRODUCTOS = new ProductoDTO[] {
            new ProductoDTO("TP008", "",R.drawable.tp008),
            new ProductoDTO("PR902", "",R.drawable.pr902),
            new ProductoDTO("TechBox", "",R.drawable.techbox),
            new ProductoDTO("PDA001", "",R.drawable.pda001),
            new ProductoDTO("POS", "",R.drawable.pos),
            new ProductoDTO("LO 500", "",R.drawable.lo500),
            new ProductoDTO("LO 502", "", R.drawable.lo502),
            new ProductoDTO("CT130", "",R.drawable.ct130),
            new ProductoDTO("TP008", "",R.drawable.tp008),
            new ProductoDTO("PR902", "",R.drawable.pr902),
            new ProductoDTO("TechBox", "",R.drawable.techbox),
            new ProductoDTO("PDA001", "",R.drawable.pda001),
            new ProductoDTO("POS", "",R.drawable.pos),
            new ProductoDTO("LO 500", "",R.drawable.lo500),
            new ProductoDTO("LO 502", "", R.drawable.lo502),
            new ProductoDTO("CT130", "",R.drawable.ct130)

    };

    public static ProductoDTO getProducto(int id) {
        for (ProductoDTO item : PRODUCTOS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public int getId() {
        return Descripcion.hashCode() + Imagen;
    }
}
