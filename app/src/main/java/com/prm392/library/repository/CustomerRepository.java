package com.prm392.library.repository;

import android.content.Context;

import com.prm392.library.DAO.CustomerDAO;
import com.prm392.library.database.LibraryApp;
import com.prm392.library.entities.Customer;

import java.util.List;

public class CustomerRepository {
    CustomerDAO customerDAO;
    public CustomerRepository(Context context) {
        LibraryApp libraryApp = LibraryApp.getInstance(context);
        customerDAO = libraryApp.customerDAO();
    }
    public void addEmployee(Customer customer){
        customerDAO.insertCustomer(customer);
    }
    public List<Customer> getAll(){
        return customerDAO.getAllCustomers();
    }
}
