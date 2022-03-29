package com.aca.homework.week12.stopwatch;

public enum DisplayType {
    SECONDS_AND_MILLIS {
        @Override
        public String displayFormat(long timeMillis) {
            return timeMillis / 1000 + "." + timeMillis % 1000 + "sec";
        }
    },
    SECONDS {
        @Override
        public String displayFormat(long timeMillis) {
            return timeMillis / 1000 + "sec";
        }
    };

    public abstract String displayFormat(long timeMillis);
}
