package com.drivehub;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.drivehub.BookingStore;
import com.drivehub.models.Booking;
import com.drivehub.models.Car;
import com.drivehub.models.Renter;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    private TextView carInfoText;
    private EditText startDateInput, endDateInput;
    private Button confirmBtn;

    private String brand, model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // Get data from intent
        brand = getIntent().getStringExtra("brand");
        model = getIntent().getStringExtra("model");

        carInfoText = findViewById(R.id.carInfoText);
        startDateInput = findViewById(R.id.startDateInput);
        endDateInput = findViewById(R.id.endDateInput);
        confirmBtn = findViewById(R.id.confirmBtn);

        carInfoText.setText(brand + " " + model);

        startDateInput.setOnClickListener(v -> showDatePicker(startDateInput));
        endDateInput.setOnClickListener(v -> showDatePicker(endDateInput));

        confirmBtn.setOnClickListener(v -> {
            String startDate = startDateInput.getText().toString();
            String endDate = endDateInput.getText().toString();

            if (startDate.isEmpty() || endDate.isEmpty()) {
                Toast.makeText(this, "Συμπλήρωσε και τις δύο ημερομηνίες", Toast.LENGTH_SHORT).show();
                return;
            }

            // ➕ Δημιουργία Booking και προσθήκη στο BookingStore
            Car dummyCar = new Car("id", brand, model, "XXX1234", null, 50.0, null, null);
            Renter dummyRenter = new Renter("r1", "Demo", "demo@email.com", "1234");
            Booking newBooking = new Booking(dummyCar, dummyRenter, startDate, endDate);
            BookingStore.getInstance().addBooking(newBooking);

            Toast.makeText(this,
                    "Κράτηση για " + brand + " από " + startDate + " έως " + endDate,
                    Toast.LENGTH_LONG).show();

            finish(); // Προαιρετικά κλείνει το activity
        });
    }

    private void showDatePicker(EditText input) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(
                this,
                (DatePicker view, int year, int month, int day) -> input.setText(day + "/" + (month + 1) + "/" + year),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }
}
