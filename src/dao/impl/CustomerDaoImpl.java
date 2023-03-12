package dao.impl;

import dao.custom.CustomerDAO;
import model.CustomerDTO;
import util.SQLutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDAO {
    public ArrayList<CustomerDTO> getall() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutil.exeuteQurey("SELECT * FROM Customer");
        ArrayList<CustomerDTO> getAllCustomer = new ArrayList<>();
        while (rst.next()){
            getAllCustomer.add(new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return getAllCustomer;
    }
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
      return SQLutil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",
              dto.getId(),dto.getName(),dto.getAddress());
    }
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
      return SQLutil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),
      dto.getId());
    }
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return SQLutil.exeuteQurey("SELECT id FROM Customer WHERE id=?",id).next();

    }
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return SQLutil.executeUpdate("DELETE FROM Customer WHERE id=?",id);
    }
    public ResultSet genarateCustomerID() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLutil.exeuteQurey("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        return resultSet;
    }
}
