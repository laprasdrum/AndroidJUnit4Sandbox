package com.laprasdrum.androidjunit4.date;

import java.util.Date;

public class DateFactoryImpl implements DateFactoryInterface {
    @Override
    public Date newDate() {
        return new Date();
    }
}
