package model;

public class User {
    private  int userId;
    private String name;
    private String password;

    // alt + insert:代码自动生成，如生成对象的 set / get 方法，构造函数，toString() 等
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
