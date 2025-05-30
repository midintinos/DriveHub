package com.drivehub;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.adapters.BookingAdapter;
import com.drivehub.data.BookingStore;
import com.drivehub.models.Booking;

import java.util.List;

public class MyBookingsActivity extends AppCompatActivity {

    private RecyclerView bookingsRecyclerView;
    private BookingAdapter bookingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        bookingsRecyclerView = findViewById(R.id.bookingsRecyclerView);
        bookingsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 🔁 Φόρτωση κρατήσεων από το BookingStore
        List<Booking> bookings = BookingStore.getInstance().getBookings();

        // 📦 Adapter
        bookingAdapter = new BookingAdapter(bookings);
        bookingsRecyclerView.setAdapter(bookingAdapter);
    }
}
