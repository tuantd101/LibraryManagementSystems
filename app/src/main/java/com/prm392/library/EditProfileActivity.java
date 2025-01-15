package com.prm392.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.prm392.library.DAO.EmployeeDAO;
import com.prm392.library.entities.Employee;
import com.prm392.library.repository.EmployeeRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class EditProfileActivity extends AppCompatActivity {
    private EditText ed_name, ed_dob, ed_address, ed_email, ed_phone;
    private Button bt_save, bt_change_avt;
    private SharedPreferences sharedPreferences;

    private EmployeeDAO employeeDAO;
    private Employee employee = new Employee();
    private ImageView imageView;
    private EmployeeRepository employeeRepository = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Display Action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Edit Profile");//Title
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // get id from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        long id = sharedPreferences.getLong("userId", 0);
        employee = employeeDAO.getEmployeeById(id);

        employeeRepository = new EmployeeRepository(this);

        imageView = findViewById(R.id.imageView);
        ed_name = findViewById(R.id.ed_name);
        ed_dob = findViewById(R.id.ed_dob);
        ed_address = findViewById(R.id.ed_address);
        ed_email = findViewById(R.id.ed_email);
        ed_phone = findViewById(R.id.ed_phone);
        bt_save = findViewById(R.id.button_save_profile);
        bt_change_avt = findViewById(R.id.bt_change_avt);

        ed_name.setText(employee.getName());
        ed_dob.setText(employee.getDob().toString());
        ed_address.setText(employee.getAddress());
        ed_phone.setText("" + employee.getPhone());
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee1 = new Employee();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                employee1.setName(ed_name.getText().toString());
                try {
                    Date date = dateFormat.parse(ed_dob.getText().toString());
                    employee1.setDob(date);

                } catch (Exception e) {
                }
                employee1.setAddress(ed_address.getText().toString());
                employee1.setEmail(ed_email.getText().toString());
                employee1.setPhone(ed_phone.getText().toString());

                employeeRepository.updateEmployee(employee1);
                finish();
            }
        });

        bt_change_avt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);
        if (requestCode == 2){
            imageView.setImageURI(intent.getData());
        }
    }
}