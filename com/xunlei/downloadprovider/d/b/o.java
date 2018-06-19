package com.xunlei.downloadprovider.d.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: RedPointCloudConfig */
public final class o {
    public int A;
    public int B = 0;
    public String C;
    public String D;
    public String E;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public long l;
    public long m;
    public long n;
    public String o;
    public String p;
    public String q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v = -1;
    public List<a> w = new ArrayList();
    public long x;
    public long y;
    public long z;

    /* compiled from: RedPointCloudConfig */
    public static class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public o e;
    }

    public final boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= this.y) {
            if (currentTimeMillis >= this.x) {
                if (this.z == 0 && this.r == 1) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= this.m) {
            if (currentTimeMillis >= this.l) {
                if (this.n > this.m || this.n < this.l) {
                    this.n = 0;
                }
                if (this.n == 0 && this.k == 1) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RedPointCloudConfig [mBusName=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mCofText=");
        stringBuilder.append(this.c);
        stringBuilder.append(", mPicUrl=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mJumpUrl=");
        stringBuilder.append(this.e);
        stringBuilder.append(", mStartTime=");
        stringBuilder.append(this.o);
        stringBuilder.append(", mEndTime=");
        stringBuilder.append(this.p);
        stringBuilder.append(", mName=");
        stringBuilder.append(this.q);
        stringBuilder.append(", mDisplay=");
        stringBuilder.append(this.r);
        stringBuilder.append(", mLevel=");
        stringBuilder.append(this.s);
        stringBuilder.append(", mPhase=");
        stringBuilder.append(this.t);
        stringBuilder.append(", mStatus=");
        stringBuilder.append(this.u);
        stringBuilder.append(", mRedPoint=");
        stringBuilder.append(this.v);
        stringBuilder.append(", mStartTimeMill=");
        stringBuilder.append(this.x);
        stringBuilder.append(", mEndTimeMill=");
        stringBuilder.append(this.y);
        stringBuilder.append(", mLastClickTime=");
        stringBuilder.append(this.z);
        stringBuilder.append(", mGroupId=");
        stringBuilder.append(this.A);
        stringBuilder.append(", mBusId=");
        stringBuilder.append(this.B);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
