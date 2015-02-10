package com.laprasdrum.audioresearch.date;

import java.util.Date;

public class DateFactoryImpl implements DateFactoryInterface {
    @Override
    public Date newDate() {
        return new Date();
    }
}
