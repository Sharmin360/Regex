package com.example.regex;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextName, editTextPassword,editTextPhoneNumber;
    private Button buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonValidate = findViewById(R.id.buttonValidate);

        buttonValidate.setOnClickListener(v -> validateInputs());
    }

    private void validateInputs() {
        String email = editTextEmail.getText().toString().trim();
        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (!isValidEmail(email)) {
            editTextEmail.setError("Invalid email address");
            return;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            editTextPhoneNumber.setError("Invalid phone number");
            return;
        }

        if (!isValidName(name)) {
            editTextName.setError("Invalid name");
            return;
        }

        if (!isValidPassword(password)) {
            editTextPassword.setError("Invalid password");
            return;
        }
        Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show();
    }

    private boolean isValidEmail(String email) {
        return Pattern.matches("^[a-z0-9.]+@[a-z]{5}+\\.[a-z]{3}", email);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches("^01\\d{9}$", phoneNumber);
    }

    private boolean isValidName(String name) {
        return Pattern.matches("^[a-zA-Z]+\\s[a-zA-Z]$", name);
    }

    private boolean isValidPassword(String password) {
        return Pattern.matches("^[a-zA-Z\\d@$!*?&]{8,}", password);
    }
}