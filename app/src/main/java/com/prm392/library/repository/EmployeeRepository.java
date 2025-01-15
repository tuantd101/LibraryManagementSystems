package com.prm392.library.repository;

import android.content.Context;

import com.prm392.library.DAO.EmployeeDAO;
import com.prm392.library.database.LibraryApp;
import com.prm392.library.entities.Employee;

import java.util.List;

public class EmployeeRepository {
    private EmployeeDAO employeeDAO;
    public EmployeeRepository(Context context) {
        LibraryApp libraryApp = LibraryApp.getInstance(context);
        employeeDAO = libraryApp.employeeDAO();
    }
    public void addEmployee(Employee employee){
         employeeDAO.insertEmployee(employee);
    }
    public List<Employee> getAll(){
       return employeeDAO.getAllEmployees();
    }
    public Employee getEmployeeByUsernameAndPassword(String username, String password){
        return employeeDAO.getEmployeeByUsernameAndPassword(username, password);
    }
    public Employee getEmployeeById(Long id){
        return employeeDAO.getEmployeeById(id);
    }
    public void updateEmployee(Employee employee){
        employeeDAO.updateEmployee(employee);
    }
}
