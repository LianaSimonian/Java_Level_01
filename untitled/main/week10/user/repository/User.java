package week10.user.repository;

public class User {
    private Long id;
    private String username;
    private int age;

    public User(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", username='" + username + '\'' +
                        ", age=" + age;
    }
}
