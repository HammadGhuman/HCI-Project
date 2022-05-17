package com.ghumanhammad420.unitconvertor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
TextView Weight,Temperature,Lenght,Pressure,Volume;
ImageView weicon,temicon,lenicon,pressicon,volicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_nav_activity);
        Weight = findViewById(R.id.weight);
        Temperature = findViewById(R.id.temperature);
        Lenght = findViewById(R.id.lenght);
        Pressure = findViewById(R.id.pressure);
        Volume = findViewById(R.id.volume);

        weicon = findViewById(R.id.KG);
        temicon = findViewById(R.id.Tempe);
        lenicon = findViewById(R.id.LengIMG);
        pressicon = findViewById(R.id.PressImg);
        volicon = findViewById(R.id.volIMG);

        Weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Weight", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,WeightConversion.class);
                startActivity(intent);
            }
        });

        Temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Temperature", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,TemperatureConversion.class);
                startActivity(intent);
            }
        });

        Lenght.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Length", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,LengthConversion.class);
                startActivity(intent);
            }
        });

        Pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Pressure", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,PressureConversion.class);
                startActivity(intent);
            }
        });
        Volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Volume", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,VolumeConversion.class);
                startActivity(intent);
            }
        });

        weicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Weight", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,WeightConversion.class);
                startActivity(intent);
            }
        });

        temicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Temperature", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,TemperatureConversion.class);
                startActivity(intent);
            }
        });

        lenicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Length", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,LengthConversion.class);
                startActivity(intent);
            }
        });

        pressicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Pressure", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,PressureConversion.class);
                startActivity(intent);
            }
        });
        volicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Volume", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,VolumeConversion.class);
                startActivity(intent);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    Toast.makeText(HomeActivity.this, "Already At Home", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId() == R.id.nav_weight){
                    Intent intent = new Intent(HomeActivity.this,WeightConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_temperature){
                    Intent intent = new Intent(HomeActivity.this,TemperatureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_length){
                    Intent intent = new Intent(HomeActivity.this,LengthConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_pressure){
                    Intent intent = new Intent(HomeActivity.this,PressureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_volume){
                    Intent intent = new Intent(HomeActivity.this,VolumeConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_logout){
                    Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });





    }
}