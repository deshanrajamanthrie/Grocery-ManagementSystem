package dao.impl;

import model.ItemDTO;
import util.SQLutil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl {
    public ArrayList<ItemDTO>getAllitem() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLutil.exeuteQurey("SELECT * FROM Item");
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        while (resultSet.next()){
            allItems .add(new ItemDTO(resultSet.getString(1),
                    resultSet.getString(2),resultSet.getBigDecimal(4),resultSet.getInt(3)));
        }
        return allItems;
    }
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return SQLutil.executeUpdate("DELETE FROM Item WHERE code=?",id);
    }
    public boolean saveItems(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLutil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
              dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLutil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
               dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }


}
