package com.example.ferryticketsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumOfTickets;
    TextView txtViewTotalCost;
    Button btnComputeCost;
    DecimalFormat moneyFormat = new DecimalFormat("$0.00");
    int totalCost, numberOfTickets;
    int costToCatalina = 34, costToLongBeach = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumOfTickets = findViewById(R.id.editTextNumOfTickets);
        txtViewTotalCost = findViewById(R.id.textViewTotalCost);
        btnComputeCost = findViewById(R.id.buttonComputeCost);
        Spinner spinner = findViewById(R.id.departures_spinner);

        btnComputeCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    numberOfTickets = Integer.parseInt(editTextNumOfTickets.getText().toString());
                } catch (NumberFormatException e) {
                    txtViewTotalCost.setText("Please enter the number of tickets you need!");
                    return;
                }
                String destination = spinner.getSelectedItem().toString();
                if(spinner.getSelectedItemPosition() == 0) {
                    totalCost = costToCatalina * numberOfTickets;
                } else {
                    totalCost = costToLongBeach * numberOfTickets;
                }
                txtViewTotalCost.setText("One way trip to " + destination + " for " +
                        numberOfTickets + " passengers: " + moneyFormat.format(totalCost));
            }
        });
    }
}