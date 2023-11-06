package edu.hillel.lesson24.v2;

import java.util.List;

public class DBStorage implements Storage {

    private static final String USER_NAME = "api_user";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:postgresql://localhost:58001/test";

    private final DBConnectionProvider dbConnectionProvider;
    private final DataDAO dataDAO;

    public DBStorage(DBConnectionProvider dbConnectionProvider) {
        this.dbConnectionProvider=dbConnectionProvider;
        dataDAO = dbConnectionProvider.getDataDAO();
    }

    @Override
    public void saveData(List<String> data) {
        dataDAO.addData(data);
    }

    @Override
    public List<String> getData() {
        return dataDAO.getData();
    }

    @Override
    public void clearData() {
        dataDAO.clearData();
    }

}
