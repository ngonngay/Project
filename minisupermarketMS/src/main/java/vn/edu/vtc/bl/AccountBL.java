package vn.edu.vtc.bl;

import vn.edu.vtc.dal.AccountDAL;
import vn.edu.vtc.dal.DAL;
import vn.edu.vtc.dal.DalFactory;
import vn.edu.vtc.persistance.Account;

import java.util.List;

public class AccountBL {
    private DAL<Account> dal= DalFactory.getDAL(Account.class);
    AccountDAL accountDAL=(AccountDAL) dal;

    public int delete(String username) {
        return accountDAL.delete(username);
    }

    public Account login (String userName,String password){
        return accountDAL.getAccount(userName, password);
    }
    public boolean createNewAccount(Account account){
        return dal.insert(account)>0;
    }
    public List<Account> getAll(){
        return accountDAL.getAll();
    }

    public boolean changePassword(String newPassword,String userName) {
        return accountDAL.changePassword(newPassword,userName);
    }

    public boolean updateInfo(String userName, String newStaffName, String actor) {
        return accountDAL.updateInfo(userName,newStaffName,actor);
    }
}