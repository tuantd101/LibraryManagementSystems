package com.prm392.library;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prm392.library.adapter.StaffListAdapter;
import com.prm392.library.bean.StaffShow;
import com.prm392.library.entities.Employee;
import com.prm392.library.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class StaffListActivity extends AppCompatActivity {
    private List<StaffShow> staffShowList = new ArrayList<>();
    private EmployeeRepository employeeRepository;
    private StaffListAdapter staffListAdapter = null;
    private Button btAddNew = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_list);
        // Display Action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Staff");//Title
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        employeeRepository = new EmployeeRepository(this);
        List<Employee> employees = employeeRepository.getAll();
        staffShowList.addAll(convertObject(employees));

        RecyclerView recyclerViewStaff = findViewById(R.id.recycle_view_staff_list);
        staffListAdapter = new StaffListAdapter(staffShowList,this);
        recyclerViewStaff.setAdapter(staffListAdapter);
        recyclerViewStaff.setLayoutManager((new LinearLayoutManager(this)));
        btAddNew = findViewById(R.id.bt_add_new_staff);
        btAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffListActivity.this, CreateStaffActivity.class);
                startActivityForResult(intent, 2);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, requestCode, intent);
        if (requestCode == 2) {
            staffShowList.clear();
            List<Employee> employees = new ArrayList<>();
            employees = employeeRepository.getAll();
            staffShowList.addAll(convertObject(employees));
            staffListAdapter.notifyDataSetChanged();
        }
    }


    private List<StaffShow> convertObject(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        List<StaffShow> staffShows = new ArrayList<>();
        for (Employee employee : employees) {

            StaffShow staffShow = new StaffShow();
            staffShow.setId(employee.getUuid());
            staffShow.setName(employee.getName());
            staffShow.setRole(employee.getRole());
            staffShows.add(staffShow);
        }
        return staffShows;
    }
}