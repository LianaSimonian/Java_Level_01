package com.aca.classroom.week5.objects;

public class User {
    private String name;
    private String password;
    private int age;

    public User(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public boolean equals(Object obj) {
        User user = (User) obj;
        //Integer integer = user.age;
        //Integer
        if(this ==obj){
            return true;
        }

        if(obj == null || obj.getClass()!=User.class){
            return false;
        }
        return user.age ==this.age && user.name.equals(this.name) && user.password.equals(this.password);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
   //395-418
    public static void main(String[] args) {
        User user1 = new User("Korun", "koryun2005", 16);
        User user2 = new User("Korun", "koryun2005", 16);
        User user3 = new User("Korun", "koryun2005", 16);

        User[] users = {user1,user2,user3};
        System.out.println(user1.equals(user2));
        System.out.println(getUserIndex(users,user1));
       // Main main = new Main();
        //System.out.println(user1.equals(main));
        //SubUser subUser = new SubUser("Korun", "koryun2005", 16);
    }
    public static int getUserIndex(User[] users,User user){
        for ( int i =0;i<users.length;i++){
            if(users[i].equals(users))
                return i;
        }
        return -1;
    }
}


