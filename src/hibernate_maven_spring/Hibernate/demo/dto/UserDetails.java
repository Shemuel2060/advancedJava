package hibernate_maven_spring.Hibernate.demo.dto;

public class UserDetails {
    // only two member/instance variables

    
    private int userId;
    private String userName;


    // getters and setters
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
}
