package com.prm392.library.repository;

import android.content.Context;

import com.prm392.library.DAO.MasterDataDAO;
import com.prm392.library.database.LibraryApp;
import com.prm392.library.entities.MasterData;

import java.util.List;

public class MasterDataRepository {
    MasterDataDAO masterDataDAO;
    public MasterDataRepository(Context context) {
        LibraryApp libraryApp = LibraryApp.getInstance(context);
        masterDataDAO = libraryApp.masterDataDAO();
    }
    public void addMasterData(MasterData masterData){
        masterDataDAO.insertMasterData(masterData);
    }
    public List<MasterData> getAll(){
        return masterDataDAO.getAllMasterData();
    }
}
