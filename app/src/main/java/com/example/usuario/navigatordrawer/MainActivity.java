package com.example.usuario.navigatordrawer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnFragmentOneListener, FragmentTwo.OnFragmentTwoListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupNavigationView();
    }

    /**
     * Método que inicializa el Listener NavigationItemSelected, y en base a la opción seleccionada se realiza una acción
     */
    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.action_home:
                        Log.d("navigatioDrawer", "Se ha pulsado la opción home");

                            fragmentOne = new FragmentOne();
                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.flContent, fragmentOne, FragmentOne.TAG);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();

                        break;
                    case R.id.action_dependency:
                        Log.d("navigatioDrawer", "Se ha pulsado la opción dependency");

                            fragmentTwo = new FragmentTwo();
                            FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction2.replace(R.id.flContent, fragmentTwo, FragmentTwo.TAG);
                            fragmentTransaction2.addToBackStack(null);
                            fragmentTransaction2.commit();

                        break;
                    case R.id.action_sector:
                        Log.d("navigatioDrawer", "Se ha pulsado la opción sector");
                        break;
                    case R.id.action_settings:
                        Log.d("navigatioDrawer", "Se ha pulsado la opción settings");

                        startActivity(new Intent(MainActivity.this,Preferent.class));

                        break;
                    case R.id.action_help:
                        Log.d("navigatioDrawer", "Se ha pulsado la opción help");
                        break;
                }
                item.setChecked(true);
                getSupportActionBar().setTitle(item.getTitle());
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Log.d("NavigatorDrawer", "Se ha pulsado el icono home");
                drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
