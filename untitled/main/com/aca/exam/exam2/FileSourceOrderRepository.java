package com.aca.exam.exam2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Repository
public class FileSourceOrderRepository implements CrudRepository<Order, Integer> {
    @Override
    public Order findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("id can not be null");
        List<Order> orderList = findAll();
        for (Order order : orderList)
            if (Integer.valueOf(order.getId()).equals(id))
                return order;
        return null;
    }

    @Override
    public List<Order> findAll() {
        File file = new File("D:\\Users\\user\\IdeaProjects\\aca\\Java_Level_01\\untitled\\main\\com\\aca\\exam\\exam2\\order.txt");
        List<Order> orderList = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNext()) {
                String element = scanner.nextLine();
                orderList.add(createOrderObjectFromString(element));
            }
            return orderList;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Order createOrderObjectFromString(String string) {
        String[] strings = string.split(",");
        List<User> userList = FileSourceUserRepository.getInstance().findAll();
        User userOrder = null;
        for (User user : userList)
            if (user.getFirstName().equals(strings[3]))
                userOrder = user;
        return new Order(Integer.valueOf(strings[0]), strings[1], Integer.valueOf(strings[2]), userOrder);
    }
}
