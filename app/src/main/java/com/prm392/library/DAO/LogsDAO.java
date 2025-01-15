package com.prm392.library.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.prm392.library.entities.Logs;

import java.util.List;

@Dao
public interface LogsDAO {
    @Query("SELECT * FROM Logs")
    List<Logs> getAllLogs();

    @Query("SELECT * FROM Logs WHERE uuid = :uuid")
    Logs getLogById(Long uuid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLog(Logs log);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateLog(Logs log);

    @Delete
    void deleteLog(Logs log);

    @Query("SELECT * FROM logs LIMIT :limit OFFSET :offset")
    List<Logs> getLogsLimit(int limit, int offset);
}
