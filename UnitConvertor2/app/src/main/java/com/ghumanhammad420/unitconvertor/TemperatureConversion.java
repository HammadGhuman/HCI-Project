package com.ghumanhammad420.unitconvertor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class TemperatureConversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText Value;
    TextView Result;
    Button Convert;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature_nav_activity);
        spinner = findViewById(R.id.spinner);
        Convert = findViewById(R.id.ConvertBtn);
        Result = findViewById(R.id.result);
        Result.setGravity(Gravity.CENTER);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.TemperatureUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Value = findViewById(R.id.Value);
                double val =Integer.parseInt(Value.getText().toString());
                String unitSelected = spinner.getSelectedItem().toString();
                switch(unitSelected){
                    case "Celsius":
                        Result.setText("Fahrenheit = " + ((val*9)/5)+32 + "\nKelvin = " + val+273.15);
                        break;
                    case "Fahrenheit":
                        double d = (32*val) - (32) * 5/9;
                        Result.setText("Celsius = " + d + "\nKelvin = " + d+273.15);
                        break;
                    case "Kelvin":
                        double e = val - 273.15;
                        double f = (((val - 273.15)*9/5)+32);
                        Result.setText("Celsius = " + e + "\nKelvin = " +f);
                        break;
                }            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    Intent intent = new Intent(TemperatureConversion.this,HomeActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_weight){
                    Intent intent = new Intent(TemperatureConversion.this,WeightConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_temperature){
                    Toast.makeText(TemperatureConversion.this, "Already At Temperature", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId() == R.id.nav_length){
                    Intent intent = new Intent(TemperatureConversion.this,LengthConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_pressure){
                    Intent intent = new Intent(TemperatureConversion.this,PressureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_volume){
                    Intent intent = new Intent(TemperatureConversion.this,VolumeConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_logout){
                    Intent intent = new Intent(TemperatureConversion.this,LoginActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}