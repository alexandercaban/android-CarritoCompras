package com.example.alexcaban.proyectofinal.Vista.DetalleProducto;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexcaban.proyectofinal.Presentador.DetalleProducto.ProductoDTO;
import com.example.alexcaban.proyectofinal.R;
import com.example.alexcaban.proyectofinal.Vista.Stock.StockFragment;

public class DetalleProductoFragment extends Fragment {
    public static final String EXTRA_PARAM_ID = "detail:_id";
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    private ImageView mHeaderImageView;
    private TextView mHeaderTitle;

    private ProductoDTO producto;
    public View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_detalle_producto, container, false);

        Bundle bundle= getArguments();
        producto = ProductoDTO.getProducto(bundle.getInt(EXTRA_PARAM_ID, 0));

        mHeaderImageView = v.findViewById(R.id.imageview_header);
        mHeaderTitle = v.findViewById(R.id.textview_title);

        ViewCompat.setTransitionName(mHeaderImageView, VIEW_NAME_HEADER_IMAGE);
        ViewCompat.setTransitionName(mHeaderTitle, VIEW_NAME_HEADER_TITLE);

        loadProducto();
        return v;
    }


    private void loadProducto() {
        mHeaderTitle.setText(getString(R.string.image_header, producto.getDescripcion(), producto.getDetalle()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            loadThumbnail();
        } else {
            loadFullSizeImage();
        }
    }

    private void loadThumbnail() {
        mHeaderImageView.setBackgroundResource(producto.getImagen());
    }

    private void loadFullSizeImage() {
        mHeaderImageView.setBackgroundResource(producto.getImagen());
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TransitionSet transitionSet = (TransitionSet) getSharedElementEnterTransition();
        if (transitionSet != null) {
            transitionSet.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionEnd(@NonNull Transition transition) {
                    loadFullSizeImage();
                    // remove listener as otherwise there are side-effects
                    transition.removeListener(this);
                    // do something here
                }

                @Override
                public void onTransitionStart(@NonNull Transition transition) {}
                @Override
                public void onTransitionCancel(@NonNull Transition transition) {
                    transition.removeListener(this);
                }
                @Override
                public void onTransitionPause(@NonNull Transition transition) {}
                @Override
                public void onTransitionResume(@NonNull Transition transition) {}
            });
        }
    }



}
