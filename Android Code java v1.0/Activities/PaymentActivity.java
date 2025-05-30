package com.drivehub;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.drivehub.models.Payment;

import java.util.UUID;

public class PaymentActivity extends AppCompatActivity {

    private EditText amountInput, methodInput;
    private Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        amountInput = findViewById(R.id.amountInput);
        methodInput = findViewById(R.id.methodInput);
        payBtn = findViewById(R.id.payBtn);

        payBtn.setOnClickListener(v -> {
            String method = methodInput.getText().toString();
            double amount;

            try {
                amount = Double.parseDouble(amountInput.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Μη έγκυρο ποσό", Toast.LENGTH_SHORT).show();
                return;
            }

            String paymentId = UUID.randomUUID().toString();
            Payment payment = new Payment(paymentId, amount, method);

            Toast.makeText(this, "Πληρωμή καταχωρήθηκε!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
