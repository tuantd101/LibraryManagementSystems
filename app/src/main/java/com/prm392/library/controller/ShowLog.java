package com.prm392.library.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.prm392.library.R;
import com.prm392.library.adapter.LogListAdapter;
import com.prm392.library.bean.LogShow;
import com.prm392.library.entities.Logs;
import com.prm392.library.repository.LogRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ShowLog extends AppCompatActivity {
    private static LogRepository logRepository;

    private LogListAdapter logAdapter = null;
    private List<LogShow> logShowList = new ArrayList<>();
    private Long userId;
    private String userRole;
    private int pageNumber = 0;
    private final int pageSize = 15;
    private boolean loading = false;
    private boolean lastPage = false;
    private int currentYear, currentMonth, currentDay;
    private int startDate = 0, startMonth = 0, startYear = 0;
    private int endDate = 0, endMonth = 0, endYear = 0;
    private Button btStartDate, btEndDate;

    private EditText etSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        // get user info
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        userId = sharedPreferences.getLong("userId", -1L);
        userRole = sharedPreferences.getString("userRole", "");

        // set up adapter
        RecyclerView recyclerViewLog = findViewById(R.id.recycle_view_logs);
        logAdapter = new LogListAdapter(logShowList, this);
        recyclerViewLog.setAdapter(logAdapter);
        recyclerViewLog.setLayoutManager(new LinearLayoutManager(this));

        // add data
        logRepository = new LogRepository(this);
        loadLogs();

        // Initial for variables
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH);
        currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        btStartDate = findViewById(R.id.btStartDatePicker);
        btEndDate = findViewById(R.id.btEndDatePicker);
        etSearch = findViewById(R.id.etSearch);

        recyclerViewLog.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading() && !isLastPage()) {
                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                            && firstVisibleItemPosition >= 0) {
                        loadLogs();
                    }
                }
            }
        });

    }

    private void loadLogs() {
        setLoading(true);
        List<Logs> logEntities = logRepository.getListLogLimit(pageNumber * pageSize, pageSize);
        if (logEntities != null) {
            if (logEntities.size() < pageSize) {
                setLastPage(true);
            }
            List<LogShow> logShowNoneFilter = convertLogObject(logEntities);
            logShowList.addAll(applyFilter(logShowNoneFilter));
            pageNumber++;
            logAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Failed to load logs", Toast.LENGTH_SHORT).show();
        }
        setLoading(false);
    }

    private List<LogShow> convertLogObject(List<Logs> logEntities) {
        if (logEntities == null || logEntities.isEmpty()) {
            return new ArrayList<>();
        }
        int number = pageNumber * pageSize;
        List<LogShow> logShowList = new ArrayList<>();
        for (Logs logEntity : logEntities) {
            LogShow logShow = new LogShow();
            logShow.setNumber(number);
            logShow.setAction_name(logEntity.getAction_name());
            logShow.setCreated_at(logEntity.getCreated_at());
            logShow.setCreated_by(logEntity.getCreated_by());
            number++;
            logShowList.add(logShow);
        }
        return logShowList;
    }

    private List<LogShow> applyFilter(List<LogShow> logShowList) {
        List<LogShow> logShowListApplyFilter = new ArrayList<>();

        // filter date
        if(startDate != 0 && startMonth != 0 && startYear != 0){
            if(endDate != 0 && endMonth !=0 && endYear != 0){
                if(startDate <= endDate && startMonth <= endMonth && startYear <= endYear){
                    int dateLog = 0, monthLog = 0, yearLog = 0;
                    for(LogShow logshow: logShowList){
                        dateLog = logshow.getCreated_at().getDate();
                        monthLog = logshow.getCreated_at().getMonth();
                        yearLog = logshow.getCreated_at().getYear();
                        if(dateLog >= startDate && dateLog <= endDate){
                            if(monthLog >= startMonth && monthLog <= startMonth){
                                if(yearLog >= startYear && monthLog <= endYear){
                                    logShowListApplyFilter.add(logshow);
                                }
                            }
                        }
                    }
                }
            }
        }
        // Filter search
        String searchString = etSearch.toString().trim();
        if(searchString == null || searchString == ""){
            return logShowListApplyFilter;
        }
        if(logShowListApplyFilter != null  && !logShowListApplyFilter.isEmpty()){
            String actionName = "";
            for(LogShow logshow: logShowListApplyFilter){
                actionName = logshow.getAction_name().toLowerCase();
                if (actionName.contains(searchString)) {
                    logShowListApplyFilter.remove(logshow);
                }
            }
        }

        if(logShowListApplyFilter == null || logShowListApplyFilter.isEmpty()){
            logShowListApplyFilter.addAll(logShowList);
        }
        return logShowListApplyFilter;
    }
    private boolean isLoading() {
        return loading;
    }

    private void setLoading(boolean loading) {
        this.loading = loading;
    }

    private boolean isLastPage() {
        return lastPage;
    }

    private void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public void showStartDatePicker(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                btStartDate.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year);
                startDate = dayOfMonth;
                startMonth = monthOfYear;
                startYear = year;
            }
        };

        // Show DatePicker
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, currentYear, currentMonth, currentDay);
        datePickerDialog.show();
    }

    public void showEndDatePicker(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                btEndDate.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year);
                endDate = dayOfMonth;
                endMonth = monthOfYear;
                endYear = year;
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener, currentYear, currentMonth, currentDay);
        datePickerDialog.show();
    }

}
