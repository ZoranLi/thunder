package com.alibaba.baichuan.android.trade.utils;

import com.alibaba.baichuan.android.trade.f.b;
import java.util.regex.Pattern;

public class m {
    protected static final String a = "com.alibaba.baichuan.android.trade.utils.m";

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        for (String matches : b.a) {
            if (Pattern.matches(matches, str)) {
                return true;
            }
        }
        return false;
    }
}
