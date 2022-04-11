package com.aca.homework.week7.ui;

import com.aca.homework.week7.ui.ColorType;
import com.aca.homework.week7.ui.UIText;
import com.aca.homework.week7.ui.UIView;

class UITextTest {
    public static void main(String[] args) {
        UIView uiTextObject = new UIText(4, 5, "MyText", ColorType.BLUE);
        uiTextObject.click();
    }
}