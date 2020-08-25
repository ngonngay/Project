package vn.edu.vtc.bl;

import vn.edu.vtc.dal.AccountDAL;
import vn.edu.vtc.dal.DAL;
import vn.edu.vtc.dal.DalFactory;
import vn.edu.vtc.persistance.Account;

public class AccountBL {
    private DAL<Account> dal= DalFactory.getDAL(Account.class);
    public Account login (String userName,String password){
        AccountDAL accountDAL=(AccountDAL) dal;
        return accountDAL.getAccount(userName, password);
    }
}