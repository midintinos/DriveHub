package com.drivehub;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.models.Booking;
import com.drivehub.models.BookingStore;
import com.drivehub.BookingAdapter;

import java.util.List;

public class ManageBookingsActivity extends AppCompatActivity {

    private RecyclerView bookingsRecyclerView;
    private BookingAdapter bookingAdapter;
    private List<Booking> allBookings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_bookings);

        bookingsRecyclerView = findViewById(R.id.bookingsRecyclerView);
        bookingsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        allBookings = BookingStore.getAllBookings(); // ή όποια λίστα κρατήσεων έχεις
        bookingAdapter = new BookingAdapter(allBookings, true); // admin mode
        bookingsRecyclerView.setAdapter(bookingAdapter);
    }
}
