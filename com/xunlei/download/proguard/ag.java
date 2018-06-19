package com.xunlei.download.proguard;

import java.io.IOException;

/* compiled from: Protocol */
public enum ag {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String e;

    private ag(String str) {
        this.e = str;
    }

    public static ag a(String str) throws IOException {
        if (str.equals(HTTP_1_0.e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.e)) {
            return SPDY_3;
        }
        StringBuilder stringBuilder = new StringBuilder("Unexpected protocol: ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
    }

    public final String toString() {
        return this.e;
    }
}
