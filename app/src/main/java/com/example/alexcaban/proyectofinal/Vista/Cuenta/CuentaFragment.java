package com.example.alexcaban.proyectofinal.Vista.Cuenta;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.alexcaban.proyectofinal.LoginActivity;
import com.example.alexcaban.proyectofinal.MainActivity;
import com.example.alexcaban.proyectofinal.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CuentaFragment extends Fragment {

    Button btnCerrarSesion;
    TextView tvEmail;
    private FirebaseAuth firebaseAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cuenta, container, false);
        btnCerrarSesion = v.findViewById(R.id.btnCerrarSesion);
        tvEmail = v.findViewById(R.id.correo);
        firebaseAuth = FirebaseAuth.getInstance();

        tvEmail.setText(firebaseAuth.getCurrentUser().getEmail() + firebaseAuth.getCurrentUser().getPhoneNumber());
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        return v;
    }

    public void signOut() {
        firebaseAuth.signOut();
        startActivity(new Intent(getActivity(), LoginActivity.class));
        //LoginManager.getInstance().logOut();
        //updateUI(null);

    }


}
