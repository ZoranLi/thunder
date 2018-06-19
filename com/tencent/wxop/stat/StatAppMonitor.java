package com.tencent.wxop.stat;

public class StatAppMonitor implements Cloneable {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;
    private String a = null;
    private long b = 0;
    private long c = 0;
    private int d = 0;
    private long e = 0;
    private int f = 0;
    private int g = 1;

    public StatAppMonitor(String str) {
        this.a = str;
    }

    public StatAppMonitor(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.a = str;
        this.b = j;
        this.c = j2;
        this.d = i;
        this.e = j3;
        this.f = i2;
        this.g = i3;
    }

    public com.tencent.wxop.stat.StatAppMonitor clone() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x0007 }
        r0 = (com.tencent.wxop.stat.StatAppMonitor) r0;	 Catch:{ CloneNotSupportedException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.StatAppMonitor.clone():com.tencent.wxop.stat.StatAppMonitor");
    }

    public String getInterfaceName() {
        return this.a;
    }

    public long getMillisecondsConsume() {
        return this.e;
    }

    public long getReqSize() {
        return this.b;
    }

    public long getRespSize() {
        return this.c;
    }

    public int getResultType() {
        return this.d;
    }

    public int getReturnCode() {
        return this.f;
    }

    public int getSampling() {
        return this.g;
    }

    public void setInterfaceName(String str) {
        this.a = str;
    }

    public void setMillisecondsConsume(long j) {
        this.e = j;
    }

    public void setReqSize(long j) {
        this.b = j;
    }

    public void setRespSize(long j) {
        this.c = j;
    }

    public void setResultType(int i) {
        this.d = i;
    }

    public void setReturnCode(int i) {
        this.f = i;
    }

    public void setSampling(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.g = i;
    }
}
