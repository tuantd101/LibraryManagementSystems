package com.prm392.library.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.prm392.library.entities.MasterData;

import java.util.List;

@Dao
public interface MasterDataDAO {
    @Query("SELECT * FROM MasterData")
    List<MasterData> getAllMasterData();

    @Query("SELECT * FROM MasterData WHERE uuid = :uuid")
    MasterData getMasterDataById(Long uuid);

    @Insert
    void insertMasterData(MasterData masterData);

    @Update
    void updateMasterData(MasterData masterData);

    @Delete
    void deleteMasterData(MasterData masterData);
}
