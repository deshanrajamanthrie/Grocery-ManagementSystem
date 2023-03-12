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

}
