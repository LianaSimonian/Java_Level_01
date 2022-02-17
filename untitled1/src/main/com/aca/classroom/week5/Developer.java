package com.aca.classroom.week5;

public class Developer {
    private String name;

    public Developer(){
        super();
    }
    public Developer(String name ){

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getSalary(){
        return 60_000;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
       return "name" + name + "Salary" + getSalary();
    }
    public boolean equals(final Object o){
        Developer o1 = (Developer)o;
        return this.name.equals(o1.name);

    }

    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.setName("Lian");
        Developer developer1 = new Developer("Lian");
        System.out.println();

    }
}
