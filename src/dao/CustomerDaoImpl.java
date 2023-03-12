package dao;

import model.CustomerDTO;
import util.SQLutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl {
    public ArrayList<CustomerDTO> getall() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLutil.exeuteQurey("SELECT * FROM Customer");
        ArrayList<CustomerDTO> getAllCustomer = new ArrayList<>();
        while (rst.next()){
            getAllCustomer.add(new CustomerDTO(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return getAllCustomer;
    }
}
