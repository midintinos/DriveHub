package com.drivehub;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drivehub.models.Booking;
import com.drivehub.BookingStore;
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

        // 🔧 Χρήση του singleton BookingStore σωστά
        allBookings = BookingStore.getInstance().getAllBookings();


        // 👑 Χρήση σε admin mode (true)
        bookingAdapter = new BookingAdapter(allBookings, true);
        bookingsRecyclerView.setAdapter(bookingAdapter);
    }
}
