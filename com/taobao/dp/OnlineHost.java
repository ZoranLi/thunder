package com.taobao.dp;

import java.security.InvalidParameterException;

public final class OnlineHost {
    private static final int Custrom_Imdex = 3;
    public static final OnlineHost GENERAL = new OnlineHost("GENERAL", "ynuf.alipay.com", 0);
    public static final OnlineHost JAPAN = new OnlineHost("JAPAN", "fcumid.ynuf.alipay.com", 2);
    public static final OnlineHost USA = new OnlineHost("USA", "us.ynuf.alipay.com", 1);
    private String mHost;
    private int mIndex;
    private String mName;

    private OnlineHost(String str, String str2, int i) {
        this.mName = str;
        this.mHost = str2;
        this.mIndex = i;
    }

    public static OnlineHost valueof(String str) {
        if (str != null) {
            if (str.length() != 0) {
                return new OnlineHost("", str, 3);
            }
        }
        throw new InvalidParameterException("Invalid Host");
    }

    public final String getHost() {
        return this.mHost;
    }

    public final int getIndex() {
        return this.mIndex;
    }

    public final String getName() {
        return this.mName;
    }
}
