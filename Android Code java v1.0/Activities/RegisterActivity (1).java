package com.drivehub;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameInput, emailInput, passwordInput;
    private Spinner roleSpinner;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        roleSpinner = findViewById(R.id.roleSpinner);
        registerBtn = findViewById(R.id.registerBtn);

        // Populate role spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        registerBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            String role = roleSpinner.getSelectedItem().toString();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Συμπλήρωσε όλα τα πεδία", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Εγγραφή ως " + role + " επιτυχής!", Toast.LENGTH_SHORT).show();
                finish(); // Επιστρέφει στο login
            }
        });
    }
}
