package com.drivehub;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;



import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class CarDetailsActivity extends AppCompatActivity {

    private TextView brandModelText, plateText, priceText;
    private Button bookBtn, editCarBtn, deleteCarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        brandModelText = findViewById(R.id.brandModelText);
        plateText = findViewById(R.id.plateText);
        priceText = findViewById(R.id.priceText);
        Button bookBtn = findViewById(R.id.bookBtn);
        editCarBtn = findViewById(R.id.editCarBtn);
        deleteCarBtn = findViewById(R.id.deleteCarBtn);


        // Get data from intent
        String brand = getIntent().getStringExtra("brand");
        String model = getIntent().getStringExtra("model");
        String plate = getIntent().getStringExtra("plate");
        double price = getIntent().getDoubleExtra("price", 0);

        // Set data to views
        brandModelText.setText(brand + " " + model);
        plateText.setText("Πινακίδα: " + plate);
        priceText.setText("Τιμή/ημέρα: €" + price);

        // Κουμπί κράτησης
        bookBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CarDetailsActivity.this, BookingActivity.class);
            intent.putExtra("brand", brand);
            intent.putExtra("model", model);
            startActivity(intent);

        });

        // Κουμπί επεξεργασίας
        editCarBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Η λειτουργία επεξεργασίας δεν είναι ακόμα διαθέσιμη", Toast.LENGTH_SHORT).show();
        });

        // Κουμπί διαγραφής
        deleteCarBtn.setOnClickListener(v -> {
            String plateToRemove = getIntent().getStringExtra("plate");

            for (int i = 0; i < RegisterCarActivity.carList.size(); i++) {
                if (RegisterCarActivity.carList.get(i).getPlateNumber().equals(plateToRemove)) {
                    RegisterCarActivity.carList.remove(i);
                    break;
                }
            }

            Toast.makeText(this, "Το όχημα διαγράφηκε", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
}
