package com.aca.homework.week10.template;

import com.aca.homework.week10.template.PageRenderer;
import com.aca.homework.week10.template.TopAndDownPageNumberAwarePageRenderer;
import com.aca.homework.week10.template.TopPageNumberAwarePageRenderer;

class PageRendererTest {
    public static void main(String[] args) {
        PageRenderer pageRenderer = new PageRenderer();
        pageRenderer.print();
        PageRenderer pageRenderer1 = new TopPageNumberAwarePageRenderer();
        pageRenderer1.print();
        PageRenderer pageRenderer2 = new TopAndDownPageNumberAwarePageRenderer();
        pageRenderer2.print();
    }
}