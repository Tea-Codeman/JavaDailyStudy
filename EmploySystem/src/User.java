package EmploySystem.src;

public class User {
    private String username;
    private String loginUsername;
    private String password;
    
    public User(String username, String loginUsername, String password) {
        this.username = username;
        this.loginUsername = loginUsername;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getLoginUsername() {
        return loginUsername;
    }
    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
