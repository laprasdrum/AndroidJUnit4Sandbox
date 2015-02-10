package com.laprasdrum.androidjunit4;

public class Member {
    public static Boolean canEntry(int age, Gender gender) {
        return gender == Gender.FEMALE && age <= 25;
    }
}
