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

public class WeightConversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText Value;
    TextView Result;
    Button Convert;
    private Spinner WeightSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_nav_activity);
        final double poundVal = 2.205;
        final double ounceVal = 35.274;
        final double stoneVal = 0.1574803149606299;
        final double gram = 1000;
        final double miligram = 1000000;
        WeightSpinner = findViewById(R.id.spinner);
        Convert = findViewById(R.id.ConvertBtn);
        Result = findViewById(R.id.result);
        Result.setGravity(Gravity.CENTER);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.WeightUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        WeightSpinner.setAdapter(adapter);

        WeightSpinner.setOnItemSelectedListener(this);


        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Value = findViewById(R.id.Value);
                double kgVal =Integer.parseInt(Value.getText().toString());
                String unitSelected = WeightSpinner.getSelectedItem().toString();
                switch(unitSelected){
                    case "kg":
                        Result.setText("Pounds = " + kgVal*poundVal + "\nOunce = " +kgVal*ounceVal+ "\nStone = " + kgVal*stoneVal + "\nGram = " +kgVal*gram + "\nMiligram = "+ kgVal*miligram);
                        break;
                    case "pound":
                        kgVal = kgVal/2.205;
                        Result.setText("Kg = " + kgVal+ "\nOunce = " +kgVal*ounceVal+ "\nStone = " + kgVal*stoneVal + "\nGram = " +kgVal*gram + "\nMiligram = "+ kgVal*miligram);
                        break;
                    case "gram":
                        kgVal = kgVal/1000;
                        Result.setText("Kg = " + kgVal+ "\nOunce = " +kgVal*ounceVal+ "\nStone = " + kgVal*stoneVal + "\npound = " +kgVal*poundVal + "\nMiligram = "+ kgVal*miligram);
                        break;
                    case "miligram":
                        kgVal = kgVal/miligram;
                        Result.setText("Kg = " + kgVal+ "\nOunce = " +kgVal*ounceVal+ "\nStone = " + kgVal*stoneVal + "\npound = " +kgVal*poundVal + "\ngram = "+ kgVal*gram);
                        break;
                    case "stone":
                        kgVal = kgVal*6.35;
                        Result.setText("Kg = " + kgVal+ "\nOunce = " +kgVal*ounceVal+ "\nMiligram = " + kgVal*miligram + "\npound = " +kgVal*poundVal + "\nMiligram = "+ kgVal*miligram);
                        break;
                    case "ounce":
                        kgVal = kgVal/35.274;
                        Result.setText("Kg = " + kgVal+ "\nstone = " +kgVal*stoneVal+ "\nMiligram = " + kgVal*miligram + "\npound = " +kgVal*poundVal + "\nMiligram = "+ kgVal*miligram);
                        break;
                    default:
                        Result.setText("Kg = " + 0+ "\nOunce = " +0+ "\nMiligram = " + 0 + "\npound = " +0 + "\nMiligram = "+ 0);

                }

            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    Intent intent = new Intent(WeightConversion.this,HomeActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_weight){
                    Toast.makeText(WeightConversion.this, "Already At Weight", Toast.LENGTH_SHORT).show();

                }
                else if(item.getItemId() == R.id.nav_temperature){
                    Intent intent = new Intent(WeightConversion.this,TemperatureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_length){
                    Intent intent = new Intent(WeightConversion.this,LengthConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_pressure){
                    Intent intent = new Intent(WeightConversion.this,PressureConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_volume){
                    Intent intent = new Intent(WeightConversion.this,VolumeConversion.class);
                    startActivity(intent);
                }
                else if(item.getItemId() == R.id.nav_logout){
                    Intent intent = new Intent(WeightConversion.this,LoginActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String UnitSelected = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, UnitSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}