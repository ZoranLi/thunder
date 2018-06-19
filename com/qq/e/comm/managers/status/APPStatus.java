package com.qq.e.comm.managers.status;

import android.content.Context;

public class APPStatus {
    private String a;
    private Context b;

    public APPStatus(String str, Context context) {
        this.a = str;
        this.b = context;
    }

    public String getAPPID() {
        return this.a;
    }

    public String getAPPName() {
        return this.b.getPackageName();
    }

    public java.lang.String getAPPRealName() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.getAPPName();
        r1 = com.qq.e.comm.util.StringUtil.isEmpty(r0);
        r2 = 0;
        if (r1 != 0) goto L_0x0027;
    L_0x000b:
        r1 = r4.b;	 Catch:{ Exception -> 0x0027 }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x0027 }
        r3 = 0;	 Catch:{ Exception -> 0x0027 }
        r0 = r1.getPackageInfo(r0, r3);	 Catch:{ Exception -> 0x0027 }
        r0 = r0.applicationInfo;	 Catch:{ Exception -> 0x0027 }
        r1 = r4.b;	 Catch:{ Exception -> 0x0027 }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x0027 }
        r0 = r0.loadLabel(r1);	 Catch:{ Exception -> 0x0027 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0027 }
        return r0;
    L_0x0027:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.APPStatus.getAPPRealName():java.lang.String");
    }

    public java.lang.String getAPPVersion() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.getAPPName();
        r1 = com.qq.e.comm.util.StringUtil.isEmpty(r0);
        r2 = 0;
        if (r1 != 0) goto L_0x0019;
    L_0x000b:
        r1 = r4.b;	 Catch:{ Exception -> 0x0019 }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x0019 }
        r3 = 0;	 Catch:{ Exception -> 0x0019 }
        r0 = r1.getPackageInfo(r0, r3);	 Catch:{ Exception -> 0x0019 }
        r0 = r0.versionName;	 Catch:{ Exception -> 0x0019 }
        return r0;
    L_0x0019:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.APPStatus.getAPPVersion():java.lang.String");
    }
}
