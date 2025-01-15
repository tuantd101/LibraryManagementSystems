package com.prm392.library.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.prm392.library.entities.Order;

import java.util.List;

@Dao
public interface OrderDAO {
    @Query("SELECT * FROM `Order`")
    List<Order> getAllOrders();

    @Query("SELECT * FROM `Order` WHERE uuid = :uuid")
    Order getOrderById(Long uuid);

    @Insert
    void insertOrder(Order order);

    @Update
    void updateOrder(Order order);

    @Delete
    void deleteOrder(Order order);
}
