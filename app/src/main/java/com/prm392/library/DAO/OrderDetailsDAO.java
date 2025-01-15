package com.prm392.library.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.prm392.library.entities.OrderDetails;

import java.util.List;
@Dao
public interface OrderDetailsDAO {
    @Query("SELECT * FROM OrderDetails")
    List<OrderDetails> getAllOrderDetails();

    @Query("SELECT * FROM OrderDetails WHERE uuid = :uuid")
    OrderDetails getOrderDetailsById(Long uuid);

    @Insert
    void insertOrderDetails(OrderDetails orderDetails);

    @Update
    void updateOrderDetails(OrderDetails orderDetails);

    @Delete
    void deleteOrderDetails(OrderDetails orderDetails);
}
