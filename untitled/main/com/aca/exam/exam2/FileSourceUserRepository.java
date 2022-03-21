package com.aca.exam.exam2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Repository
public class FileSourceUserRepository implements CrudRepository<User, String> {
    private static FileSourceUserRepository singletonObject = null;

    private FileSourceUserRepository() {

    }

    @Override
    public User findById(@Nullable String id) {
        if (id == null) throw new IllegalArgumentException("id can not be null");
        List<User> userList = findAll();
        for (User user : userList)
            if (user.getId().equals(id))
                return user;
        return null;
    }

    @Override
    public List<User> findAll() {
        File file = new File("D:\\Users\\user\\IdeaProjects\\aca\\Java_Level_01\\untitled\\main\\\\com\\aca\\exam\\exam2\\User.txt");
        List<User> userList = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNext()) {
                String element = scanner.nextLine();
                userList.add(createUserObjectFromString(element));
            }
            return userList;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static User createUserObjectFromString(String string) {
        String[] strings = string.split(",");
        return new User(strings[0], strings[1], strings[2]);
    }

    public static FileSourceUserRepository getInstance() {
        if (singletonObject == null)
            singletonObject = new FileSourceUserRepository();
        return singletonObject;
    }
}
