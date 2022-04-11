package com.aca.homework.week7.ui;

import com.aca.homework.week7.ui.ColorType;
import com.aca.homework.week7.ui.UIButton;
import com.aca.homework.week7.ui.UIView;

class UIButtonTest {
    public static void main(String[] args) {
        UIView uiButtonObject = new UIButton(4, 5, ColorType.YELLOW);
        uiButtonObject.click();
    }
}