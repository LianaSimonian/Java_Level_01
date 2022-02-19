package com.aca.classroom.week5;

import jdk.swing.interop.SwingInterOpUtils;

public class JuniorDeveloper extends Developer{
    private long salary;
   public JuniorDeveloper(){
       super("Helee");
   }
   public JuniorDeveloper(String name,long salary){
       super(name);
       salary = this.salary;
   }

    @Override
    public long getSalary() {
        return salary;
    }

    public static void main(String[] args) {

        JuniorDeveloper juniorDeveloper = new JuniorDeveloper("name",300_000);
        JuniorDeveloper juniorDeveloper1 = new JuniorDeveloper();
        juniorDeveloper.toString();
        System.out.println(juniorDeveloper1.getClass());
        System.out.println(juniorDeveloper1==juniorDeveloper);
        System.out.println(juniorDeveloper1.equals(juniorDeveloper));



    }

}
