package com.qiniu.android.dns.local;

import com.qiniu.android.dns.DnsException;

public class DnshijackingException extends DnsException {
    public DnshijackingException(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("has hijacked by ");
        stringBuilder.append(str2);
        super(str, stringBuilder.toString());
    }

    public DnshijackingException(String str, String str2, int i) {
        StringBuilder stringBuilder = new StringBuilder("has hijacked by ");
        stringBuilder.append(str2);
        stringBuilder.append(" ttl ");
        stringBuilder.append(i);
        super(str, stringBuilder.toString());
    }
}
