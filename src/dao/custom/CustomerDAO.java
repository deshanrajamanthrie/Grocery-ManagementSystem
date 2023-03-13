package dao.custom;

import dao.CrudDAO;
import model.CustomerDTO;
import util.SQLutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO,String> {
    ResultSet genarateCustomerID() throws SQLException, ClassNotFoundException;

}
