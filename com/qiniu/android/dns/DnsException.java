package com.qiniu.android.dns;

import java.io.IOException;

public class DnsException extends IOException {
    public DnsException(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(": ");
        stringBuilder.append(str2);
        super(stringBuilder.toString());
    }
}
