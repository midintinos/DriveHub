package com.drivehub;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.drivehub.models.Booking;
import com.drivehub.BookingStore;
import com.drivehub.models.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminReportsActivity extends AppCompatActivity {

    private TextView reportText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_reports);

        reportText = findViewById(R.id.reportText);

        List<Booking> bookings = BookingStore.getInstance().getAllBookings();

        Map<String, Integer> carBookings = new HashMap<>();
        Map<String, Double> carRevenue = new HashMap<>();

        for (Booking booking : bookings) {
            Car car = booking.getCar();
            String carName = car.getBrand() + " " + car.getModel();

            carBookings.put(carName, carBookings.getOrDefault(carName, 0) + 1);
            carRevenue.put(carName, carRevenue.getOrDefault(carName, 0.0) + car.getPrice());
        }

        StringBuilder report = new StringBuilder("📊 Αναφορά:\n\n");
        for (String carName : carBookings.keySet()) {
            report.append("🚗 ").append(carName)
                    .append("\n  Κρατήσεις: ").append(carBookings.get(carName))
                    .append("\n  Έσοδα: ").append(carRevenue.get(carName)).append("€\n\n");
        }

        reportText.setText(report.toString());
    }
}
