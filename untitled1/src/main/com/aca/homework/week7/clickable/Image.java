package com.aca.homework.week7.clickable;

public class Image extends AbstractClickable {
    private String name;

    public Image(String name, Action action) {
        super(action);
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void click() {
        getAction().doAction(this);
    }

    public static Image ofImage(String name) {
        return new Image(name, new Action() {
            @Override
            public void doAction(Clickable clickable) {
                System.out.println("The click method is invoked on the " + clickable.getClass().getSimpleName() + " object having a name " + clickable.name());
            }
        });
    }
}
