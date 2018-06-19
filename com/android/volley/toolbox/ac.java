package com.android.volley.toolbox;

/* compiled from: Args */
public final class ac {
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" may not be null");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
