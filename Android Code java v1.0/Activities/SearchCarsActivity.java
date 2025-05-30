package com.drivehub;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.drivehub.models.Car;

import androidx.appcompat.app.AppCompatActivity;

public class SearchCarsActivity extends AppCompatActivity {

    private EditText brandInput, maxPriceInput;
    private Button searchBtn;

    private RecyclerView carsRecyclerView;
    private CarAdapter carAdapter;
    private List<Car> carList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_cars);

        brandInput = findViewById(R.id.brandInput);
        maxPriceInput = findViewById(R.id.maxPriceInput);
        searchBtn = findViewById(R.id.searchBtn);

        carsRecyclerView = findViewById(R.id.carsRecyclerView);
        carsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

// mock δεδομένα
        carList = new ArrayList<>();
        carList.add(new Car("1", "Toyota", "Corolla", "AX1234", null, 45.0, null,0));
        carList.add(new Car("2", "Fiat", "Panda", "FI4567", null, 30.0, null,0));

        carAdapter = new CarAdapter(carList);
        carsRecyclerView.setAdapter(carAdapter);


        searchBtn.setOnClickListener(v -> {
            String brand = brandInput.getText().toString().trim().toLowerCase();
            String maxPriceStr = maxPriceInput.getText().toString().trim();

            double maxPrice = Double.MAX_VALUE;
            if (!maxPriceStr.isEmpty()) {
                try {
                    maxPrice = Double.parseDouble(maxPriceStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Μη έγκυρη τιμή", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            List<Car> filtered = new ArrayList<>();
            for (Car car : carList) {
                boolean matchesBrand = brand.isEmpty() || car.getBrand().toLowerCase().contains(brand);
                boolean matchesPrice = car.getPrice() <= maxPrice;

                if (matchesBrand && matchesPrice) {
                    filtered.add(car);
                }
            }

            carAdapter = new CarAdapter(filtered);
            carsRecyclerView.setAdapter(carAdapter);

            Toast.makeText(this, "Βρέθηκαν " + filtered.size() + " αποτελέσματα", Toast.LENGTH_SHORT).show();
        });

    }
}
