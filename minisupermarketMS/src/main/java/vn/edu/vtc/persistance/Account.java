package vn.edu.vtc.persistance;

import vn.edu.vtc.pl.StaticFunctionService;

public class Account {
    private String userName;
    private String password;
    private Integer staff_id;
    private String name;
    private Integer isAdmin=1;

    public Account(String userName, String password, Integer staff_id, String name, Integer isAdmin) {
        this.userName = userName;
        this.password = password;
        this.staff_id = staff_id;
        this.name = name;
        this.isAdmin = isAdmin;
    }
    public Account(String userName, String password,String name, Integer isAdmin) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
    }
    public Account() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName=userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password= StaticFunctionService.getMd5(password);
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public boolean equals(Object object){
        if (object instanceof Account){
            Account another=(Account) object;
            if (this.userName.equals(another.getUserName())
                    &&this.staff_id.equals(another.getStaff_id())){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", staff_id=" + staff_id +
                ", name='" + name + '\'' +
                ", isAmin=" + isAdmin +
                '}';
    }
}