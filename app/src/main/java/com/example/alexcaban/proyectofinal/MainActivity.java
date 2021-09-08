package com.example.alexcaban.proyectofinal;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.alexcaban.proyectofinal.Vista.Stock.StockFragment;
import com.example.alexcaban.proyectofinal.Vista.StockCategorias.StockCategoriasFragment;


public class MainActivity extends AppCompatActivity  {
    private BottomNavigationView bottomNavigationView;

    private FrameLayout frameLayout;
    private StockFragment stockFragment;
    private StockCategoriasFragment stockCategoriasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.tabs) ;
        frameLayout = (FrameLayout) findViewById(R.id.contenido);

        stockFragment = new StockFragment();
        stockCategoriasFragment = new StockCategoriasFragment();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.tab_stock:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(stockCategoriasFragment);
                        return true;
                    case R.id.tab_stock2:


                        default:
                            return false;
                }

            }
        });



    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contenido, fragment);
        fragmentTransaction.commit();
    }

}
