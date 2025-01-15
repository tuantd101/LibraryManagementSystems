package com.prm392.library.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prm392.library.R;


public class ForgotPassword extends AppCompatActivity {
    private EditText emailEditText;
    private Button sendPasswordButton;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = findViewById(R.id.etEmail);
        sendPasswordButton = findViewById(R.id.btResetPassword);
        errorTextView = findViewById(R.id.tvErrorResetPass);

        sendPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                if (isValidEmail(email)) {
                    // Send password to email
                    sendPasswordToEmail(email);
                    // Show success message
                    errorTextView.setText("New password has been sent to your email.");
                } else {
                    errorTextView.setText("Invalid email!");
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        // Implement email validation logic here
        return true;
    }

    private void sendPasswordToEmail(String email) {

    }



    private void sendEmailMessage(String email, String message) {
        // Code to send email to specific email address with message
        // Here, you need to use a library or API to send email, such as JavaMail API or another email sending service.
        // Below is an example using JavaMail API:

    }

}