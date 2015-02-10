package com.laprasdrum.audioresearch.date;

import java.util.Date;

/**
 * 委譲されるメソッドを引き受けるオブジェクト
 * Java ではメソッドはクラス定義の一部でありオブジェクトとして委譲できない
 */
public class DateFactory {
    protected Date newDate() {
        return new Date();
    }
}