package util;

import db.DBConnection;
import org.omg.CORBA.Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLutil {
    private static PreparedStatement execute(String sql,Object...parms) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        for(int i=0;i< parms.length;i++){
            stm.setObject((i+1),parms[i]);

        }
        return stm;
    }
    public static ResultSet exeuteQurey(String sql,Object... parms) throws SQLException, ClassNotFoundException {
        return execute(sql,parms).executeQuery();
    }
    public static boolean executeUpdate(String sql,Object... parms) throws SQLException, ClassNotFoundException {
        return execute(sql, parms).executeUpdate()>0;
    }
}
