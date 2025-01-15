package com.prm392.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.prm392.library.DAO.EmployeeDAO;
import com.prm392.library.entities.Employee;
import com.prm392.library.repository.EmployeeRepository;

public class EmployeeProfileActivity extends AppCompatActivity {


    private EmployeeRepository employeeRepository = null;
    private Employee employee = new Employee();

    private TextView tv_name, tv_dob, tv_address, tv_email, tv_phone;
    private Button bt_edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile);

        // Display Action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Profile");//Title
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // get id from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        long id = sharedPreferences.getLong("userId", 0);

        employeeRepository = new EmployeeRepository(this);
        employee = employeeRepository.getEmployeeById(id);

        tv_name = findViewById(R.id.fullNameTextView);
        tv_dob = findViewById(R.id.tv_dob);
        tv_address = findViewById(R.id.tv_address);
        tv_email = findViewById(R.id.tv_email);
        tv_phone = findViewById(R.id.tv_phone);
        bt_edit_profile = findViewById(R.id.button_edit_profile);

        tv_name.setText(employee.getName());
        tv_dob.setText(employee.getDob().toString());
        tv_address.setText(employee.getAddress());
        tv_email.setText(employee.getEmail());
        tv_phone.setText(""+employee.getPhone());
        bt_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}