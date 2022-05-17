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

public class VolumeConversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText Value;
    TextView Result;
    Button Convert;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_nav_activity);
        spinner = findViewById(R.id.spinner);
        Convert = findViewById(R.id.ConvertBtn);
        Result = findViewById(R.id.result);
        Result.setGravity(Gravity.CENTER);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.VolumeUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        final double LiterVal = 1000 ;
        final double USGalVal = 264.17206;
        final double impGalVal = 219.96925;
        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Value = findViewById(R.id.Value);
                double val =Integer.parseInt(Value.getText().toString());
                String unitSelected = spinner.getSelectedItem().toString();
                switch(unitSelected){
                    case "Cubic Meter":
                        Result.setText("LiterVal = " + val * LiterVal+ "\nUs Gallon = " + val*USGalVal + "Imp Gallon = "+val*impGalVal);
                        break;
                    case "Liter":
                        val = val/LiterVal;
                        Result.setText("Cubic Meter = " + val+ "\nUs Gallon = " + val*USGalVal + "Imp Gallon = "+val*impGalVal);
                        break;
                    case "Us Gallon":
                        val = val/USGalVal;
                        Result.setText("LiterVal = " + val * LiterVal+ "\nCubic Meter = " + val + "Imp Gallon = "+val*impGalVal);
                        break;
                    case "imp Gallon":
                        val = val/impGalVal;
                        Result.setText("LiterVal = " + val * LiterVal+ "\nCubic Meter = " + val + "Us Gallon = "+val*USGalVal);
                        break;
                }
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    Intent intent = new Intent(VolumeConversion.this,HomeActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_weight){
                    Intent intent = new Intent(VolumeConversion.this,WeightConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_temperature){
                    Intent intent = new Intent(VolumeConversion.this,TemperatureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_length){
                    Intent intent = new Intent(VolumeConversion.this,LengthConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_pressure){
                    Intent intent = new Intent(VolumeConversion.this,PressureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_volume){
                    Toast.makeText(VolumeConversion.this, "Already At Volume", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId() == R.id.nav_logout){
                    Intent intent = new Intent(VolumeConversion.this,LoginActivity.class);
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