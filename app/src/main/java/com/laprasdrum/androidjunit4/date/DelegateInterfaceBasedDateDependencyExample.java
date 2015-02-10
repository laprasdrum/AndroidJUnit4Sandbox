package com.laprasdrum.androidjunit4.date;

import java.util.Date;

public class DelegateInterfaceBasedDateDependencyExample {
    public Date date = new Date();
    public DateFactoryInterface dataFactory = new DateFactoryImpl();

    /**
     * テスト対象となるコードを Override 可能なオブジェクトにする
     */
    public void doSomething() {
        date = dataFactory.newDate();
    }
}
