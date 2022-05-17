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

public class LengthConversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText Value;
    TextView Result;
    Button Convert;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_nav_activity);

        spinner = findViewById(R.id.spinner);
        Convert = findViewById(R.id.ConvertBtn);
        Result = findViewById(R.id.result);
        Result.setGravity(Gravity.CENTER);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.LenghtUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        final double kilometerVal = 1.603;
        final double meterVal = 1609;
        final double centiVal = 160934;
        final double milliVal = 16090000;
        final double footVal = 5280;

        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Value = findViewById(R.id.Value);
                double val =Integer.parseInt(Value.getText().toString());
                String unitSelected = spinner.getSelectedItem().toString();
                switch(unitSelected){
                    case "Kilometer":
                        Result.setText("Miles = "+val*kilometerVal+"\nMeter = "+val*meterVal+"\nCentimeter = "+val * centiVal+"\nMillimeter = "+val*milliVal+"\nFoot = "+val* footVal);
                        break;
                    case "Meter":
                        val = val/1609;
                        Result.setText("Miles = "+val+"\nKilometer = "+val*kilometerVal+"\nCentimeter = "+val * centiVal+"\nMillimeter = "+val*milliVal+"\nFoot = "+val* footVal);
                        break;
                    case "Centimeter":
                        val = val/centiVal;
                        Result.setText("Miles = "+val+"\nMeter = "+val*meterVal+"\nKilometer = "+val * kilometerVal+"\nMillimeter = "+val*milliVal+"\nFoot = "+val* footVal);
                        break;
                    case "Millimeter":
                        val=val/milliVal;
                        Result.setText("Miles = "+val+"\nMeter = "+val*meterVal+"\nCentimeter = "+val * centiVal+"\nKilometer = "+val*kilometerVal+"\nFoot = "+val* footVal);
                        break;
                    case "Miles":
                        Result.setText("Kilometer = "+kilometerVal+"\nMeter = "+meterVal+"\nCentimeter = "+centiVal+"\nMillimeter = "+milliVal+"\nFoot = "+footVal);
                        break;
                    case "Foot":
                        val = val/footVal;
                        Result.setText("Miles = "+val+"\nMeter = "+val*meterVal+"\nCentimeter = "+val * centiVal+"\nMillimeter = "+val*milliVal+"\nKilometer = "+val* kilometerVal);
                        break;
                }
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    Intent intent = new Intent(LengthConversion.this,HomeActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_weight){
                    Intent intent = new Intent(LengthConversion.this,WeightConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_temperature){
                    Intent intent = new Intent(LengthConversion.this,TemperatureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_length){
                    Toast.makeText(LengthConversion.this, "Already At Length", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId() == R.id.nav_pressure){
                    Intent intent = new Intent(LengthConversion.this,PressureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_volume){
                    Intent intent = new Intent(LengthConversion.this,VolumeConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_logout){
                    Intent intent = new Intent(LengthConversion.this,LoginActivity.class);
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