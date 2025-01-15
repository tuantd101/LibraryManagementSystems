package com.prm392.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.prm392.library.entities.Employee;
import com.prm392.library.repository.EmployeeRepository;
import com.prm392.library.validation.Utils;

public class CreateStaffActivity extends AppCompatActivity {
    private EditText editStaffID, editStaffName, editStaffAddress, editStaffEmail, editStaffPhone;
    private Button add_staff;
    private long role;
    private EmployeeRepository employeeRepository = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_staff);

        // Display Action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Create Staff");//Title
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        employeeRepository = new EmployeeRepository(this);
        Employee employee = new Employee();

        editStaffID = findViewById(R.id.edit_staff_id);
        editStaffName = findViewById(R.id.edit_staff_name);
        editStaffAddress = findViewById(R.id.edit_staff_address);
        editStaffEmail = findViewById(R.id.edit_staff_email);
        editStaffPhone = findViewById(R.id.edit_staff_phone);

        //get role by Radio Button
        RadioButton radioButtonStaffA = findViewById(R.id.role_staff_a);
        radioButtonStaffA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                role = Utils.EMPLOYEE_A;
                Toast.makeText(CreateStaffActivity.this, "Role: Staff A", Toast.LENGTH_SHORT).show();
            }
        });
        RadioButton radioButtonStaffB = findViewById(R.id.role_staff_b);
        radioButtonStaffB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                role = Utils.EMPLOYEE_B;
                Toast.makeText(CreateStaffActivity.this, "Role: Staff B", Toast.LENGTH_SHORT).show();
            }
        });
        RadioButton radioButtonManager = findViewById(R.id.role_manager);
        radioButtonManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                role = Utils.MANAGER;
                Toast.makeText(CreateStaffActivity.this, "Role: Manager", Toast.LENGTH_SHORT).show();
            }
        });

        add_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = Long.parseLong(editStaffID.getText().toString());
                String name = editStaffName.getText().toString();
                String address = editStaffAddress.getText().toString();
                String email = editStaffEmail.getText().toString();
                String phone = editStaffPhone.getText().toString();

                employee.setId(id);
                employee.setName(name);
                employee.setAddress(address);
                employee.setEmail(email);
                employee.setPhone(phone);
                employee.setRole(role);


                employeeRepository.addEmployee(employee);
                Toast.makeText(CreateStaffActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                setResult(2);
                finish();

            }
        });

    }
}