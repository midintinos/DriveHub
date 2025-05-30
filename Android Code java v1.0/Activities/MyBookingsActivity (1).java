package com.drivehub;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.models.Booking;
import com.drivehub.BookingAdapter;
import com.drivehub.BookingStore;

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

        // ✅ Λήψη όλων των κρατήσεων
        List<Booking> bookings = BookingStore.getInstance().getAllBookings();

        // ✅ Προβολή μόνο Renter (isAdmin = false)
        bookingAdapter = new BookingAdapter(bookings, false);
        bookingsRecyclerView.setAdapter(bookingAdapter);
    }
}
