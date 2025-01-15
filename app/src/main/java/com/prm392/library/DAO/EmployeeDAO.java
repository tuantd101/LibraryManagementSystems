package com.prm392.library.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.prm392.library.entities.Employee;

import java.util.List;

@Dao
public interface EmployeeDAO {
    @Query("SELECT * FROM Employee")
    List<Employee> getAllEmployees();

    @Query("SELECT * FROM Employee WHERE uuid = :uuid")
    Employee getEmployeeById(Long uuid);

    @Query("SELECT * FROM Employee WHERE email = :username and password = :password")
    Employee getEmployeeByUsernameAndPassword(String username, String password);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployee(Employee employee);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateEmployee(Employee employee);


    @Delete
    void deleteEmployee(Employee employee);
}
