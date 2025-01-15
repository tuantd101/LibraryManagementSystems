package com.prm392.library.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.prm392.library.DAO.BookDAO;
import com.prm392.library.DAO.CustomerDAO;
import com.prm392.library.DAO.EmployeeDAO;
import com.prm392.library.DAO.LogsDAO;
import com.prm392.library.DAO.MasterDataDAO;
import com.prm392.library.DAO.OrderDAO;
import com.prm392.library.DAO.OrderDetailsDAO;
import com.prm392.library.entities.Book;
import com.prm392.library.entities.Customer;
import com.prm392.library.entities.Employee;
import com.prm392.library.entities.Logs;
import com.prm392.library.entities.MasterData;
import com.prm392.library.entities.Order;
import com.prm392.library.entities.OrderDetails;
import com.prm392.library.validation.DateConverter;

@Database(entities = {Book.class, Customer.class, Employee
        .class, Logs.class, MasterData.class, Order.class, OrderDetails.class}, version = 6, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class LibraryApp extends RoomDatabase {
    private static LibraryApp INSTANCE = null;
    public static LibraryApp getInstance(Context context){
        if(INSTANCE== null){
            synchronized (LibraryApp.class){
                INSTANCE = Room.databaseBuilder(context,LibraryApp.class,"LibraryDatabase")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }

        }
        return INSTANCE;
    }
    public abstract BookDAO bookDAO();
    public abstract CustomerDAO customerDAO();
    public abstract EmployeeDAO employeeDAO();
    public abstract LogsDAO logsDAO();
    public abstract MasterDataDAO masterDataDAO();
    public abstract OrderDAO orderDAO();
    public abstract OrderDetailsDAO orderDetailsDAO();
}
