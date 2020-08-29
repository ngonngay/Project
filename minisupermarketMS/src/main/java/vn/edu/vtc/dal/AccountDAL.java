package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.edu.vtc.persistance.Account;

public class AccountDAL implements DAL<Account> {
    public Account getAccount(String userName,String password){
        Account account=null;
        try (Connection connection=DbUtil.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement("select * from Accounts where username=? and pass =?;");) {
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            try (ResultSet resultSet=preparedStatement.executeQuery();){
                if (resultSet.next()){
                    account = setInfo(resultSet);
                    account.setUserName(userName);
                }
            }
        } catch (Exception e) {
            return null;
        }
        return account;
    }
    private Account setInfo(ResultSet rs) throws SQLException {
        Account account=new Account();
        account.setName(rs.getString("staff_name"));
        account.setStaff_id(rs.getInt("staff_id"));
        account.setIsAmin(rs.getInt("isAdmin"));
        return account;
    }


    @Override
    public int insert(Account account) {
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into Accounts(username,pass,staff_name,isAdmin)values(?,?,?,?);")){
            preparedStatement.setString(1,account.getUserName());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setString(3,account.getName());
            preparedStatement.setInt(4,account.getIsAmin());
            if (preparedStatement.executeUpdate()!=1){
                return 0;
            }
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public Account getById(int idE) {
        return null;
    }

    @Override
    public int update(Account account) {
        return 0;
    }
}