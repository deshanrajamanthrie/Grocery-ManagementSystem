package dao.custom;

import dao.CrudDAO;
import model.ItemDTO;
import util.SQLutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO,String> {
    ResultSet genarateItemCode() throws SQLException, ClassNotFoundException;

}
