package com.laprasdrum.audioresearch.date;

import java.util.Date;

public class DelegateObjectBasedDateDependencyExample {
    public Date date = new Date();
    public DateFactory dataFactory = new DateFactory();

    /**
     * テスト対象となるコードを Override 可能なオブジェクトにする
     */
    public void doSomething() {
        date = dataFactory.newDate();
    }
}
