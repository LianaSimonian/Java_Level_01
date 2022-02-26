package com.aca.homework.week7.clickable;

import java.util.Scanner;

class ClickableTest {
    public static AbstractClickable[] createClickableObjects() {
        AbstractClickable[] clickables = new AbstractClickable[5];
        for (int i = 0; i < clickables.length; i++) {
            System.out.println("Please type a clickable object name.");
            String clickableObjectName = new Scanner(System.in).nextLine();
            if (clickableObjectName.substring(0, 6).equals("button")) {
                clickables[i] = Button.ofButton(clickableObjectName);
            }
            if (clickableObjectName.substring(0, 5).equals("image"))
                clickables[i] = Image.ofImage(clickableObjectName);
            System.out.println("The " + clickables[i].getClass().getSimpleName() + " object created having a name " + clickables[i].name());
        }
        return clickables;
    }

    public static void main(String[] args) {
        AbstractClickable[] clickableobjects = createClickableObjects();
        invokeClickAllObjects(clickableobjects);

    }

    public static void invokeClickAllObjects(AbstractClickable[] clickables) {
        for (int i = 0; i < clickables.length; i++) {
            System.out.println("Please enter a clickable name to invoke the click method.");
            boolean isObjectByNameFound=false;
            String clickableObjectName = new Scanner(System.in).nextLine();
            for (AbstractClickable clickable : clickables) {
                if (clickable.name().equals(clickableObjectName)) {
                    clickable.click();
                    isObjectByNameFound=true;
                }
            }
            if(isObjectByNameFound==false)
            System.out.println("the clickable object having " + clickableObjectName + " name does not found, click() method does not invoke" );
        }
    }
}