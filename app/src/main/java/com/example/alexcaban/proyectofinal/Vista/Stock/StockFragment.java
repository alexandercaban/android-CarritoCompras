package com.example.alexcaban.proyectofinal.Vista.Stock;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexcaban.proyectofinal.Presentador.DetalleProducto.ProductoDTO;
import com.example.alexcaban.proyectofinal.R;
import com.example.alexcaban.proyectofinal.Vista.DetalleProducto.DetalleProductoFragment;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class StockFragment extends Fragment implements AdapterView.OnItemClickListener {

    private GridView mGridView;
    private CuadriculaAdapter mAdapter = new CuadriculaAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stock, container, false);

        mAdapter = new CuadriculaAdapter();

        mGridView = v.findViewById(R.id.grid);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview_item);
        TextView textView = (TextView) view.findViewById(R.id.textview_name);
        ProductoDTO producto = (ProductoDTO) parent.getItemAtPosition(position);
        Bundle bundle = new Bundle();
        bundle.putInt(DetalleProductoFragment.EXTRA_PARAM_ID, producto.getId());

        setSharedElementReturnTransition(TransitionInflater.from(getActivity()).inflateTransition(R.transition.change_image_transform));
        setEnterTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.fade));

        DetalleProductoFragment fragmentDetalleProducto = new DetalleProductoFragment();
        fragmentDetalleProducto.setArguments(bundle);
        fragmentDetalleProducto.setSharedElementEnterTransition(TransitionInflater.from(getActivity()).inflateTransition(R.transition.change_image_transform));
        fragmentDetalleProducto.setExitTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.fade));


        ViewCompat.setTransitionName(imageView, DetalleProductoFragment.VIEW_NAME_HEADER_IMAGE);
        ViewCompat.setTransitionName(textView, DetalleProductoFragment.VIEW_NAME_HEADER_TITLE);

        FragmentTransaction ft = getFragmentManager().beginTransaction()
                .replace(R.id.contenido, fragmentDetalleProducto);
        ft.addToBackStack(DetalleProductoFragment.VIEW_NAME_HEADER_IMAGE);
        ft.addSharedElement(imageView, DetalleProductoFragment.VIEW_NAME_HEADER_IMAGE);
        ft.addSharedElement(textView, DetalleProductoFragment.VIEW_NAME_HEADER_TITLE);
        ft.commit();
    }


    public class CuadriculaAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ProductoDTO.PRODUCTOS.length;
        }


        @Override
        public ProductoDTO getItem(int position) {
            return ProductoDTO.PRODUCTOS[position];
        }


        @Override
        public long getItemId(int position) {
            return getItem(position).getId();
        }


        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.cuadricula_producto, viewGroup, false);
            }

            final ProductoDTO producto = getItem(position);

            ImageView image = (ImageView) view.findViewById(R.id.imageview_item);
            image.setBackgroundResource(producto.getImagen());

            TextView name = (TextView) view.findViewById(R.id.textview_name);
            name.setText(producto.getDescripcion());


            return view;
        }

    }

}
