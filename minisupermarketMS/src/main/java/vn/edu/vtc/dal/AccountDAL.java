package vn.edu.vtc.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        account.setIsAdmin(rs.getInt("isAdmin"));
        return account;
    }


    @Override
    public int insert(Account account) {
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into Accounts(username,pass,staff_name,isAdmin)values(?,?,?,?);")){
            preparedStatement.setString(1,account.getUserName());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setString(3,account.getName());
            preparedStatement.setInt(4,account.getIsAdmin());
            if (preparedStatement.executeUpdate()!=1){
                return 0;
            }
        }catch (Exception e){
            return 0;
        }
        return 1;
    }
    public List<Account> getAll(){
        List<Account> accounts=new ArrayList<>();
        try(Connection connection=DbUtil.getConnection();
            Statement statement = connection.createStatement();){
            ResultSet resultSet=statement.executeQuery("select * from Accounts;");
            while (resultSet.next()){
                Account account=setInfo(resultSet);
                account.setUserName(resultSet.getString("username"));
                accounts.add(account);
            }
        }catch (Exception e){

        }
        return accounts;
    }
    public  int delete(String userName){
        try (Connection connection=DbUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("delete from Accounts where username=?;")){
                    try(PreparedStatement preparedStatement1 = connection.prepareStatement("select isAdmin from Accounts where username=?;");){
                        preparedStatement1.setString(1,userName);
                        ResultSet rs = preparedStatement1.executeQuery();
                        while (rs.next()){
                            int check=rs.getInt("isAdmin");
                            if (check==0){
                                return -2;
                            }
                        }
                    }catch (Exception e){
                        return 0;
                    }
                    preparedStatement.setString(1,userName);
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

    public boolean changePassword(String newPassword,String userName) {
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update Accounts set pass=? where username=?;");){
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,userName);
            if (preparedStatement.executeUpdate()!=1){
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean updateInfo(String userName, String newStaffName, String actor) {
        try(Connection connection=DbUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update Accounts set staff_name=?,isAdmin=? where username=?;");){
            preparedStatement.setString(1,newStaffName);
            if (actor.equalsIgnoreCase("Nhân Viên")){
                preparedStatement.setInt(2,1);
            }else {
                preparedStatement.setInt(2,0);
            }
            preparedStatement.setString(3,userName);
            if (preparedStatement.executeUpdate()!=1){
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
	public boolean checkExist(String userName) {
		try (Connection connection=DbUtil.getConnection();) {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from Accounts where username=?;");
            preparedStatement.setString(1, userName);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
        return false;
	}
}