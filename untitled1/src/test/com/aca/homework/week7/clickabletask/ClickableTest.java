package com.aca.homework.week7.clickabletask;

import java.util.Scanner;

class ClickableTest {
    public static Clickable[] createClickableObjects() {
        Clickable[] clickables = new Clickable[5];
        for (int i = 0; i < clickables.length; i++) {
            System.out.println("Please type a clickable object name.");
            String clickableObjectName = new Scanner(System.in).nextLine();
            if (clickableObjectName.startsWith("button")) {
                clickables[i] = new Button(clickableObjectName, new Action() {
                    @Override
                    public void doAction(Clickable clickable) {
                        System.out.println("The click method is invoked on the " + clickable.getClass().getSimpleName() + " object having a name " + clickable.name());
                    }
                });
            }
            if (clickableObjectName.startsWith("image"))
                clickables[i] = new Image(clickableObjectName, new Action() {
                    @Override
                    public void doAction(Clickable clickable) {
                        System.out.println("The click method is invoked on the " + clickable.getClass().getSimpleName() + " object having a name " + clickable.name());
                    }
                });
            System.out.println("The " + clickables[i].getClass().getSimpleName() + " object created having a name " + clickables[i].name());
        }
        return clickables;
    }

    public static void main(String[] args) {
        Clickable[] clickableobjects = createClickableObjects();
        invokeClickAllObjects(clickableobjects);

    }

    public static void invokeClickAllObjects(Clickable[] clickables) {
        for (int i = 0; i < clickables.length; i++) {
            System.out.println("Please enter a clickable name to invoke the click method.");
            boolean isObjectByNameFound = false;
            String clickableObjectName = new Scanner(System.in).nextLine();
            for (Clickable clickable : clickables) {
                if (clickable.name().equals(clickableObjectName)) {
                    clickable.click();
                    isObjectByNameFound = true;
                }
            }
            if (isObjectByNameFound == false)
                System.out.println("the clickable object having " + clickableObjectName + " name does not found, click() method does not invoke");
        }
    }
}
