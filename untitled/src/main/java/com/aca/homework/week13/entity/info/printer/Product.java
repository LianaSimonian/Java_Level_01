package com.aca.homework.week13.entity.info.printer;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

