package com.prm392.library.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.prm392.library.R;
import com.prm392.library.entities.Employee;
import com.prm392.library.repository.EmployeeRepository;
import com.squareup.picasso.Picasso;

public class Dashboard extends AppCompatActivity {
    private Toolbar toolbar;
    private Long userId;
    private String userRole, userName;
    private TextView tvHello;
    private ImageView userImage;
    private Employee employee = null;
    private static EmployeeRepository employeeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Set the toolbar as the action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get user info
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        userId = sharedPreferences.getLong("userId", -1L);
        userRole = sharedPreferences.getString("userRole", "");

        // Set up variable
        loadEmployeeInfo();
    }

    // Function to handle click on Function 1 button
    public void onClickFunction1(View view) {
        Toast.makeText(this, "Hello " + userName, Toast.LENGTH_SHORT).show();
        // Start Function 1 activity
//        Intent intent = new Intent(this, Function1Activity.class);
//        startActivity(intent);
    }

    // Function to handle click on Function 2 button
    public void onClickFunction2(View view) {
        // Start Function 2 activity
//        Intent intent = new Intent(this, Function2Activity.class);
//        startActivity(intent);
    }

    // Function to handle click on Function 3 button
    public void onClickFunction3(View view) {
        // Start Function 3 activity
//        Intent intent = new Intent(this, Function3Activity.class);
//        startActivity(intent);
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Handle action bar item clicks here.
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.option_setting) {

        } else if (menuItem.getItemId() == R.id.option_change_password) {
            Intent changePasswordIntent = new Intent(this, ChangePassword.class);
            startActivity(changePasswordIntent);
        } else if (menuItem.getItemId() == R.id.option_logout) {
            logout();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void loadEmployeeInfo() {
        if(userId != null && userId != -1L){
            employee = employeeRepository.getEmployeeById(userId);
        }

        if (employee != null) {
            // Set user image
            userImage = findViewById(R.id.imageViewUserProfile);
            userImage.setImageResource(R.drawable.ic_launcher_background);
            String imageUrl = employee.getImage_src();
            Picasso.with(this).load(imageUrl).placeholder(R.drawable.ic_launcher_background).error(R.drawable.error_image).into(userImage);

            // Set user's name
            tvHello = findViewById(R.id.tvHello);
            tvHello.setText("Hello" + userName);
        }
    }

    private void logout(){
        // Create AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Logout");
        builder.setMessage("Are you sure you want to logout?");

        // Agree button
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Log out action
                Intent intent = new Intent(Dashboard.this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        // Cancel button
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
}