package com.aca.homework.week10.template;

public class TopPageNumberAwarePageRenderer extends PageRenderer {

    public TopPageNumberAwarePageRenderer() {
        super(true, false);
    }

    protected TopPageNumberAwarePageRenderer(boolean downPageNumber) {
        super(true, downPageNumber);
    }

}
