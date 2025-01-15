package com.prm392.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.prm392.library.entities.Employee;
import com.prm392.library.repository.EmployeeRepository;

public class StaffDetailActivity extends AppCompatActivity {
    private EmployeeRepository employeeRepository = null;
    private TextView tv_name, tv_address, tv_role, tv_email, tv_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail);

        // Display Action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Edit Profile");//Title
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tv_name = findViewById(R.id.textViewUserName);
        tv_role = findViewById(R.id.textViewRole);
        tv_address = findViewById(R.id.textViewAddress);
        tv_email = findViewById(R.id.textViewEmail);
        tv_phone = findViewById(R.id.textViewPhoneNumber);

        //get id from intent
        long id = 0L;
        Intent intent = getIntent();
        if(intent!=null){
            id = Long.parseLong(intent.getStringExtra("ID"));
            employeeRepository = new EmployeeRepository(this);
            Employee employee = employeeRepository.getEmployeeById(id);
            tv_name.setText(employee.getName());
            tv_role.setText(""+employee.getRole());
            tv_address.setText(employee.getAddress());
            tv_email.setText(employee.getEmail());
            tv_phone.setText(employee.getPhone());
            tv_phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("tel:" + tv_phone.getText().toString());
                    Intent it = new Intent(Intent.ACTION_DIAL, uri);
                    startActivity(it);
                }
            });
        }
    }
}