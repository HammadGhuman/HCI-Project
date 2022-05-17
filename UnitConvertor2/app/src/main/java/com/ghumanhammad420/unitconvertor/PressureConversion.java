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

public class PressureConversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText Value;
    TextView Result;
    Button Convert;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pressure_nav_activity);
        spinner = findViewById(R.id.spinner);
        Convert = findViewById(R.id.ConvertBtn);
        Result = findViewById(R.id.result);
        Result.setGravity(Gravity.CENTER);
        final double barVal = 1.013225;
        final double pascalVal = 101325;
        final double ppsi = 14.696;
        final double torr = 760;

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.PressureUnits, android.R.layout.simple_spinner_item);
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
                    case "Bar":
                        Result.setText("Pascal  = " + val*pascalVal + "\nPound per Square Inch  = " + val*ppsi +"Torr = "+val*torr+"Standard Atmosphere = "+val);
                        break;
                    case "Pascal":
                        val = val/pascalVal;
                        Result.setText("Bar  = " + val*barVal + "\nPound per Square Inch  = " + val*ppsi +"Torr = "+val*torr+"Standard Atmosphere = "+val);
                        break;
                    case "Pound per Square Inch":
                        val = val/ppsi;
                        Result.setText("Bar  = " + val*barVal + "\nPascal  = " + val*pascalVal +"Torr = "+val*torr+"Standard Atmosphere = "+val);
                        break;
                    case "Standard Atmosphere":
                        Result.setText("Bar  = " + barVal + "\nPascal  = " + pascalVal +"Pound per SSquare Inch = "+ppsi+"Torr = "+torr);
                        break;
                    case "Torr":
                        val = val/torr;
                        Result.setText("Bar  = " + val*barVal + "\nPascal  = " + val*pascalVal +"Pound per SSquare Inch = "+val*ppsi+"Standard Atmosphere = "+val);
                        break;
                }
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    Intent intent = new Intent(PressureConversion.this,HomeActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_weight){
                    Intent intent = new Intent(PressureConversion.this,WeightConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_temperature){
                    Intent intent = new Intent(PressureConversion.this,TemperatureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_length){
                    Intent intent = new Intent(PressureConversion.this,LengthConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_pressure){
                    Toast.makeText(PressureConversion.this, "Already At Pressure", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId() == R.id.nav_volume){
                    Intent intent = new Intent(PressureConversion.this,VolumeConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_logout){
                    Intent intent = new Intent(PressureConversion.this,LoginActivity.class);
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