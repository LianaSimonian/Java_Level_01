package week10.mapper;

public class User {
    private Long id;
    private String username;
    private String firstName;

    public User(Long id, String username, String firstName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
