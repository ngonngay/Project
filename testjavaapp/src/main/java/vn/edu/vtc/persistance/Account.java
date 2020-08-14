package vn.edu.vtc.persistance;

import vn.edu.vtc.service.StaticFuncitionService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String userName;
    private String password;
    private Integer staff_id;
    private String name;
    private Integer isAmin=1;

    public Account(String userName, String password, Integer staff_id, String name, Integer isAmin) {
        this.userName = userName;
        this.password = password;
        this.staff_id = staff_id;
        this.name = name;
        this.isAmin = isAmin;
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
        this.password= StaticFuncitionService.getMd5(password);
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

    public Integer getIsAmin() {
        return isAmin;
    }

    public void setIsAmin(Integer isAmin) {
        this.isAmin = isAmin;
    }
    public boolean validateUsername(String userName){
        Pattern pattern=Pattern.compile("[^!,#,$,%,^,&,*,(,),-,=,+,/,\\,]*");
        Matcher matcher=pattern.matcher(userName);
        if (matcher.matches()&&userName.length()<20&&(userName.length()>8||userName.length()==8)){
            return true;
        }
        return false;
    }
    public boolean validatePassword(String password){
        Pattern pattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$");
        Matcher matcher=pattern.matcher(password);
        if (matcher.matches()){
            return true;
        }
        return  false;
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
                ", isAmin=" + isAmin +
                '}';
    }
}
