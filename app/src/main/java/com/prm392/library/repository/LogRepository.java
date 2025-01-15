package com.prm392.library.repository;

import android.content.Context;

import com.prm392.library.DAO.LogsDAO;
import com.prm392.library.database.LibraryApp;
import com.prm392.library.entities.Logs;

import java.util.Date;
import java.util.List;

public class LogRepository {
    private LogsDAO logDAO;

    public LogRepository(Context context) {
        LibraryApp libraryApp = LibraryApp.getInstance(context);
        logDAO = libraryApp.logsDAO();
    }
    public void insertLog(String actionName, Long createdBy, String before, String after){
        Logs log = new Logs();
        log.setAction_name(actionName);
        log.setCreated_by(createdBy);
        log.setCreated_at(new Date());
        log.setOld(before);
        log.setNews(after);
        logDAO.insertLog(log);
    }

    public Logs getLog(Long id){
        return logDAO.getLogById(id);
    }

    public List<Logs> getListLog(){
        return logDAO.getAllLogs();
    }

    public List<Logs> getListLogLimit(int limit, int offset){
        return logDAO.getLogsLimit(limit, offset);
    }
}
