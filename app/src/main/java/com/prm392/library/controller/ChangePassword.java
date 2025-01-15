package com.prm392.library.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.prm392.library.R;
import com.prm392.library.entities.Employee;
import com.prm392.library.enums.ActionName;
import com.prm392.library.repository.EmployeeRepository;
import com.prm392.library.repository.LogRepository;

public class ChangePassword extends AppCompatActivity {

    private EditText editTextOldPassword, editTextNewPassword, editTextConfirmPassword;
    private Button buttonChangePassword;
    private static EmployeeRepository employeeRepository;
    private Long userId;
    private String userRole;
    private Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        // Get user info
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        userId = sharedPreferences.getLong("userId", -1L);
        userRole = sharedPreferences.getString("userRole", "");

        // initial variable
        employeeRepository = new EmployeeRepository(this);
        editTextOldPassword = findViewById(R.id.editTextOldPassword);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonChangePassword = findViewById(R.id.buttonChangePassword);

        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(ChangePassword.this);
                builder.setTitle("Confirm Change Password");
                builder.setMessage("Are you sure you want to change the password?");

                // Add button "yes"
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String oldPassword = editTextOldPassword.getText().toString();
                        String newPassword = editTextNewPassword.getText().toString();
                        String confirmPassword = editTextConfirmPassword.getText().toString();

                        // Check old password, new password and confirm password
                        if (validatePasswords(oldPassword, newPassword, confirmPassword)) {
                            changePassword(newPassword);
                            // To Do: Add action to history
                            Toast.makeText(ChangePassword.this, "Password changed successfully", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(ChangePassword.this, "Password changed fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                // Add button "no"
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Close AlertDialog
                        dialog.dismiss();
                    }
                });

                // Show AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    private boolean validatePasswords(String oldPassword, String newPassword, String confirmPassword) {
        // Validate old password
        if (oldPassword.isEmpty()) {
            editTextOldPassword.setError("Please enter old password");
            return false;
        }

        // Validate new password
        if (newPassword.isEmpty()) {
            editTextNewPassword.setError("Please enter new password");
            return false;
        }

        employee = employeeRepository.getEmployeeById(userId);
        if(employee != null){
            if(employee.getPassword().equals(oldPassword)){
                if(newPassword.equals(confirmPassword)){
                    return true;
                }
            }
        }
        return false;
    }

    private void changePassword(String newPassword){
        Employee employeeBefore = employee;
        employee.setPassword(newPassword);
        LogRepository logRepository = new LogRepository(this);
        employeeRepository.updateEmployee(employee);
        //create log
        logRepository.insertLog(ActionName.CHANGE_PASSWORD.getDisplayName(), userId, "", "");
    }

}