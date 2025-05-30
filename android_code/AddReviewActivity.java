package com.drivehub;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;

import com.drivehub.models.*;

public class AddReviewActivity extends AppCompatActivity {

    private EditText commentInput;
    private RatingBar ratingBar;
    private Button submitReviewBtn;

    private Car car;
    private Renter renter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        commentInput = findViewById(R.id.commentInput);
        ratingBar = findViewById(R.id.ratingBar);
        submitReviewBtn = findViewById(R.id.submitReviewBtn);

        // Mock δεδομένα για demo
        car = BookingStore.getInstance().getCars().get(0); // ή getCarById(...)
        renter = new Renter("r1", "Γιώργος", "test@email.com", "1234");

        submitReviewBtn.setOnClickListener(v -> {
            String comment = commentInput.getText().toString();
            int rating = (int) ratingBar.getRating();

            if (comment.isEmpty() || rating == 0) {
                Toast.makeText(this, "Συμπλήρωσε σχόλιο και βαθμολογία", Toast.LENGTH_SHORT).show();
                return;
            }

            Review review = new Review(renter, comment, rating);
            car.addReview(review);

            Toast.makeText(this, "Αξιολόγηση υποβλήθηκε!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
