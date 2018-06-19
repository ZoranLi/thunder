package com.alibaba.fastjson.parser;

import com.alipay.sdk.util.h;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.av;

/* compiled from: JSONToken */
public class e {
    public static String a(int i) {
        switch (i) {
            case 1:
                return "error";
            case 2:
                return "int";
            case 3:
                return "float";
            case 4:
                return "string";
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return av.b;
            case 8:
                return "null";
            case 9:
                return "new";
            case 10:
                return k.s;
            case 11:
                return k.t;
            case 12:
                return "{";
            case 13:
                return h.d;
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return Constants.ACCEPT_TIME_SEPARATOR_SP;
            case 17:
                return Constants.COLON_SEPARATOR;
            case 18:
                return "ident";
            case 19:
                return "fieldName";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
            default:
                return "Unknown";
        }
    }
}
