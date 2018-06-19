package com.xunlei.downloadprovider.download.taskdetails.report;

import android.os.Bundle;
import java.io.Serializable;

public class DetailsPeriod implements Serializable {
    static final long serialVersionUID = 0;
    private long mBirth = -1;
    private long mDuration = 0;
    private long mSessionStart = -1;

    public static com.xunlei.downloadprovider.download.taskdetails.report.DetailsPeriod createOrRestore(android.os.Bundle r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r1 == 0) goto L_0x000f;
    L_0x0002:
        r0 = com.xunlei.downloadprovider.download.taskdetails.report.DetailsPeriod.class;	 Catch:{ Exception -> 0x000f }
        r0 = r0.getName();	 Catch:{ Exception -> 0x000f }
        r1 = r1.getSerializable(r0);	 Catch:{ Exception -> 0x000f }
        r1 = (com.xunlei.downloadprovider.download.taskdetails.report.DetailsPeriod) r1;	 Catch:{ Exception -> 0x000f }
        goto L_0x0010;
    L_0x000f:
        r1 = 0;
    L_0x0010:
        if (r1 != 0) goto L_0x0017;
    L_0x0012:
        r1 = new com.xunlei.downloadprovider.download.taskdetails.report.DetailsPeriod;
        r1.<init>();
    L_0x0017:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.taskdetails.report.DetailsPeriod.createOrRestore(android.os.Bundle):com.xunlei.downloadprovider.download.taskdetails.report.DetailsPeriod");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DetailsPeriod{mBirth=");
        stringBuilder.append(this.mBirth);
        stringBuilder.append(", mDuration=");
        stringBuilder.append(this.mDuration);
        stringBuilder.append(", mSessionStart=");
        stringBuilder.append(this.mSessionStart);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getLifetime() {
        return System.currentTimeMillis() - this.mBirth;
    }

    public void onStart() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mSessionStart = currentTimeMillis;
        if (this.mBirth == -1) {
            this.mBirth = currentTimeMillis;
        }
    }

    public void onStop() {
        if (this.mSessionStart != -1) {
            this.mDuration += System.currentTimeMillis() - this.mSessionStart;
            this.mSessionStart = -1;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        onStop();
        if (bundle != null) {
            bundle.putSerializable(DetailsPeriod.class.getName(), this);
        }
    }
}
