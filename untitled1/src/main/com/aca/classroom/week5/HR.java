package com.aca.classroom.week5;

public class HR {
    public static void main(String[] args) {
        Developer juniorDeveloper1 = new JuniorDeveloper("Eric",300_000);
        Developer juniorDeveloper2= new JuniorDeveloper("Jane",350_000);
        Developer juniorDeveloper3 = new JuniorDeveloper("Jane",290_000);

        Developer[]  juniorDevelopers = {juniorDeveloper1,juniorDeveloper2,juniorDeveloper3} ;

        MidDeveloper mid1 = new MidDeveloper("Yan",30_000);
        MidDeveloper mid2 = new MidDeveloper("Jan",300_000);
        System.out.println();
        MidDeveloper[] midDevelopers = {mid1,mid2};
        printAllDevelopers(midDevelopers);
        //System.out.println(calculateSalary(midDevelopers) + calculateSalary(juniorDevelopers));

//JunirDeveloper poxel Developer
    }
    public static long calculateSalary(JuniorDeveloper[] juniorDevelopers){
        long sum = 0;
        for( int i =0;i<juniorDevelopers.length;i++){
            sum+=juniorDevelopers[i].getSalary();
        }
        return sum;
    }
    //printSalary

    public static long calculateSalary(MidDeveloper[] midDevelopers){
        long sum = 0;
        for( int i =0;i<midDevelopers.length;i++){
            sum+=midDevelopers[i].getSalary();
        }
        return sum;
    }
    public static void printAllDevelopers(Object []developers){
        for(int i =0;i<developers.length;i++){
            System.out.println(developers.toString());
        }
    }
}
