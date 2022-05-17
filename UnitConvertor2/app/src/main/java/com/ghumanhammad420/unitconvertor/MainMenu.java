package com.ghumanhammad420.unitconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
    TextView Weight,Temperature,Lenght,Pressure,Volume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
//        Weight = findViewById(R.id.weight);
//        Temperature = findViewById(R.id.temperature);
//        Lenght = findViewById(R.id.lenght);
//        Weight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainMenu.this, "Weight", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainMenu.this,WeightConversion.class);
//                startActivity(intent);
//            }
//        });
//
//        Temperature.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainMenu.this, "Temperature", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainMenu.this,TemperatureConversion.class);
//                startActivity(intent);
//            }
//        });
//
//        Lenght.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainMenu.this, "Length", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainMenu.this,LengthConversion.class);
//                startActivity(intent);
//            }
//        });
//
//        Pressure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainMenu.this, "Pressure", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainMenu.this,LengthConversion.class);
//                startActivity(intent);
//            }
//        });
//        Volume.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainMenu.this, "Volume", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainMenu.this,LengthConversion.class);
//                startActivity(intent);
//            }
//        });
    }
}