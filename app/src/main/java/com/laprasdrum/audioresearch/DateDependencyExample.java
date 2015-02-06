package com.laprasdrum.audioresearch;

import java.util.Date;

public class DateDependencyExample {
    public Date date;

    public void doSomething() {
        date = newDate();
    }

    /**
     * テスト対象となるコードを Override 可能なメソッドにする
     * @return current date
     */
    protected Date newDate() {
        return new Date();
    }
}
