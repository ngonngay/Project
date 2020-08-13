package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.edu.vtc.persistance.Account;

public class AccountDAL {
    public Account getAccount(String userName,String password){
        Account account=null;
        try (Connection connection=DbUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("select * from Accounts where username=? and pass =?;");) {
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            try (ResultSet resultSet=preparedStatement.executeQuery();){
                if (resultSet.next()){
                    account = setInfo(resultSet);
                    account.setPassword(password);
                    account.setUserName(userName);
                }
            }
    } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }
    private Account setInfo(ResultSet rs) throws SQLException {
        Account account=new Account();
        account.setName(rs.getString("staff_name"));
        account.setStaff_id(rs.getInt("staff_id"));
        account.setIsAmin(rs.getShort("isAdmin"));
        return account;
    }
}
