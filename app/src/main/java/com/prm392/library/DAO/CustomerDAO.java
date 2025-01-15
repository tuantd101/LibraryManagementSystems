package com.prm392.library.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.prm392.library.entities.Customer;

import java.util.List;

@Dao
public interface CustomerDAO {
    @Query("SELECT * FROM Customer")
    List<Customer> getAllCustomers();

    @Query("SELECT * FROM Customer WHERE uuid = :uuid")
    Customer getCustomerById(Long uuid);

    @Insert
    void insertCustomer(Customer customer);

    @Update
    void updateCustomer(Customer customer);

    @Delete
    void deleteCustomer(Customer customer);
}
