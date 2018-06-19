package com.xunlei.downloadprovider.thirdpart.content;

import android.database.AbstractCursor;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;

/* compiled from: XLInfoCursor */
public final class b extends AbstractCursor {
    String a;
    int b;
    String c;
    String d;
    private int e = 1;

    public final double getDouble(int i) {
        return 0.0d;
    }

    public final long getLong(int i) {
        return 0;
    }

    public final short getShort(int i) {
        return (short) 0;
    }

    public final boolean isNull(int i) {
        return false;
    }

    public final int getCount() {
        return this.e;
    }

    public final String[] getColumnNames() {
        return new String[]{INoCaptchaComponent.sessionId, "userId", "userName", "nickName"};
    }

    public final String getString(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            i = new StringBuilder();
            i.append(this.b);
            return i.toString();
        } else if (i == 2) {
            return this.c;
        } else {
            return i == 3 ? this.d : 0;
        }
    }

    public final int getInt(int i) {
        return this.b;
    }

    public final float getFloat(int i) {
        return (float) this.b;
    }
}
