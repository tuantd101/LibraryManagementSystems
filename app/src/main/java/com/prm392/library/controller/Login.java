package com.prm392.library.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.prm392.library.R;

import com.prm392.library.validation.FontUtils;

import com.prm392.library.entities.Employee;
import com.prm392.library.enums.ActionName;
import com.prm392.library.repository.EmployeeRepository;
import com.prm392.library.repository.LogRepository;

import java.util.List;


public class Login extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btLogin;
    private TextView tvError;
    private TextView tvForgotPassword;
    private CheckBox rememberPasswordCheckBox;
    private static EmployeeRepository employeeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FontUtils.applyFont(this);
        // Initial
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btLogin = findViewById(R.id.btLogin);
        tvError = findViewById(R.id.tvError);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        employeeRepository = new EmployeeRepository(this);

        // Recover username and password if user click in remember checkbox
        recoverUsernameAndPassword();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Validate login info and direct to Dashboard
                validateAccountAndDirect(username, password);
            }
        });
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
    }

    private void validateAccountAndDirect(String username, String password) {
        Employee employee = null;
        employee = employeeRepository.getEmployeeByUsernameAndPassword(username, password);

        if (employee != null) {

            // login success
            tvError.setText("");
            Long userId = employee.getUuid();
            Long userRole = employee.getRole();
            Toast.makeText(Login.this, "Successfully", Toast.LENGTH_SHORT).show();

            // Create Log and add
            LogRepository logRepository = new LogRepository(this);
            logRepository.insertLog(ActionName.LOGIN.getDisplayName(), userId, "", "");

            // Create user info
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong("userId", userId);
            editor.putLong("userRole", userRole);
            editor.apply();

            // Check remember or not
            boolean rememberPassword = rememberPasswordCheckBox.isChecked();
            if (rememberPassword) {
                // if remember
                editor.putBoolean("rememberPassword", true);
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();

            } else {
                // Not Remember
                editor.remove("rememberPassword");
                editor.remove("username");
                editor.remove("password");
                editor.apply();
            }

            // Direct to dashboard
            Intent intentDashboard = new Intent(Login.this, Dashboard.class);
            startActivity(intentDashboard);
        } else {
            // login fail
            tvError.setText("Username or Password wrong. Please try again!");
            Toast.makeText(Login.this, "Fail to login", Toast.LENGTH_SHORT).show();
        }
    }
    private void recoverUsernameAndPassword(){
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean rememberPassword = preferences.getBoolean("rememberPassword", false);
        rememberPasswordCheckBox = findViewById(R.id.checkBoxRememberPassword);
        rememberPasswordCheckBox.setChecked(rememberPassword);
        if(rememberPassword){
            etUsername.setText(preferences.getString("username", ""));
            etPassword.setText(preferences.getString("password", ""));
        }
    }
}