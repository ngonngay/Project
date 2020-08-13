package vn.edu.vtc.persistance;

public class Account {
    private String userName;
    private String password;
    private Integer staff_id;
    private String name;
    private short isAmin=1;

    public Account(String userName, String password, Integer staff_id, String name, short isAmin) {
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
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public short getIsAmin() {
        return isAmin;
    }

    public void setIsAmin(short isAmin) {
        this.isAmin = isAmin;
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
