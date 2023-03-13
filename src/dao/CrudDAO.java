package dao;

import model.CustomerDTO;
import util.SuperDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T,ID> extends SuperDAO {
    ArrayList<T> getall() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean exist(ID txtid) throws SQLException, ClassNotFoundException;

    boolean delete(ID txtid) throws SQLException, ClassNotFoundException;


}
