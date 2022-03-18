package week10.mapper;

public class UserModel {
    private String username;
    private String firstName;

    public UserModel(String username, String firstName) {
        this.username = username;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }
}
