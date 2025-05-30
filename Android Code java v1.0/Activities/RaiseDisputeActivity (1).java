package com.drivehub;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.drivehub.models.Booking;
import com.drivehub.models.Dispute;
import com.drivehub.models.Renter;
import com.drivehub.BookingStore; // Σωστό import

public class RaiseDisputeActivity extends AppCompatActivity {

    private EditText reasonInput;
    private Button submitBtn;
    private Booking booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise_dispute);

        reasonInput = findViewById(R.id.reasonInput);
        submitBtn = findViewById(R.id.submitBtn);

        // Πάρε την κράτηση από το BookingStore
        int bookingIndex = getIntent().getIntExtra("bookingIndex", -1);
        booking = BookingStore.getInstance().getAllBookings().get(bookingIndex);

        submitBtn.setOnClickListener(v -> {
            String reason = reasonInput.getText().toString().trim();
            if (reason.isEmpty()) {
                Toast.makeText(this, "Συμπλήρωσε λόγο διαφωνίας", Toast.LENGTH_SHORT).show();
                return;
            }

            // Δημιουργία νέας διαφωνίας
            Renter renter = booking.getRenter(); // σωστό τύπο
            Dispute dispute = new Dispute(reason, booking, renter);

            booking.setDispute(dispute);
            Toast.makeText(this, "Η διαφωνία καταχωρήθηκε", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
