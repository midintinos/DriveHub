package com.drivehub;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.drivehub.models.Car;

import java.util.ArrayList;
import java.util.List;

public class RegisterCarActivity extends AppCompatActivity {

    private EditText brandInput, modelInput, plateInput, priceInput;
    private Button submitBtn, cancelBtn;

    // ΠΡΟΣΩΡΙΝΗ static λίστα για καταχώρηση
    public static List<Car> carList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_car);

        brandInput = findViewById(R.id.brandInput);
        modelInput = findViewById(R.id.modelInput);
        plateInput = findViewById(R.id.plateInput);
        priceInput = findViewById(R.id.priceInput);
        submitBtn = findViewById(R.id.submitBtn);
        cancelBtn = findViewById(R.id.cancelBtn);

        submitBtn.setOnClickListener(v -> {
            String brand = brandInput.getText().toString().trim();
            String model = modelInput.getText().toString().trim();
            String plate = plateInput.getText().toString().trim();
            String priceStr = priceInput.getText().toString().trim();

            if (brand.isEmpty() || model.isEmpty() || plate.isEmpty() || priceStr.isEmpty()) {
                Toast.makeText(this, "Συμπλήρωσε όλα τα πεδία", Toast.LENGTH_SHORT).show();
                return;
            }

            double price;
            try {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Μη έγκυρη τιμή", Toast.LENGTH_SHORT).show();
                return;
            }

            // Δημιουργία και αποθήκευση αυτοκινήτου
            Car newCar = new Car("car" + plate, brand, model, plate, null, price, null);
            carList.add(newCar);

            Toast.makeText(this, "Το όχημα καταχωρήθηκε επιτυχώς!", Toast.LENGTH_LONG).show();
            finish();
        });

        cancelBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Η διαδικασία ακυρώθηκε", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
