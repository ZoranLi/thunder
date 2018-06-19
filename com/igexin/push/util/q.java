package com.igexin.push.util;

import java.util.Random;

public class q {
    private static char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz`~!@#$%^&*()-_=+[{}];:'/?.>,<".toCharArray();

    public static long a() {
        return ((long) (2 + new Random().nextInt(6))) * 60000;
    }

    public static String a(int i) {
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str.charAt(random.nextInt(str.length())));
        }
        return stringBuilder.toString();
    }
}
