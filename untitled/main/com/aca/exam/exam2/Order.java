package com.aca.exam.exam2;

public class Order {
    private int id;
    private String name;
    private int price;
    private User purchasedUser;

    public Order(int id, String name, int price, User purchasedUser) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.purchasedUser = purchasedUser;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public User getPurchasedUser() {
        return purchasedUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return id == ((Order) o).id && name.equals(((Order) o).name) && price == ((Order) o).price && purchasedUser.equals(((Order) o).purchasedUser);
    }
}
