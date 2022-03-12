package com.aca.classroom.week9.clone;

class CloneMaker<T extends ConstructorCloneable<T>> {
    public T printCloneAndPrint(T input) {
        System.out.println(input);
        T newClonedObject = input.doClone();
        System.out.println(newClonedObject);
        return newClonedObject;
    }

    public static void main(String[] args) {
        CloneMaker<Car> carCloneMaker = new CloneMaker<>();
        carCloneMaker.printCloneAndPrint(new Car(11));

        CloneMaker<Computer> computerCloneMaker = new CloneMaker<>();
        computerCloneMaker.printCloneAndPrint(new Computer("Toshiba"));
    }
}
/*
public class CloneMaker<T extends ConstrunctorClonable<T>> {
  // public T doClone(T input){
       //return  (T)input.clone();
  // }
    public T printCloneAndPrint(T  input){
        System.out.println(input);
        T newClonedObject = input.doClone();
        System.out.println(newClonedObject);
        return newClonedObject;
    }

    public static void main(String[] args) {
        CloneMaker<Car>
    }
}


 */