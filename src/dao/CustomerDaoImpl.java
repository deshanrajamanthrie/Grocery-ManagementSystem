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
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
      return SQLutil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",
              dto.getId(),dto.getName(),dto.getAddress());
    }
}
/*"");
                pstm.setString(1, id);
                pstm.setString(2, name);
                pstm.setString(3, address);*/