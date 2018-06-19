package com.xunlei.downloadprovider.plugin;

import android.os.AsyncTask;

/* compiled from: XLPluginDownloadTask */
class o extends AsyncTask<p, Integer, Boolean> {
    private static final String a = "o";
    private a$a b;

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((p[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        if (this.b != null) {
            if (bool.booleanValue() != null) {
                this.b.a();
                return;
            }
            this.b.b();
        }
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        Integer[] numArr = (Integer[]) objArr;
        if (this.b != null) {
            this.b.a(numArr[0].intValue());
        }
    }

    public o(a$a com_xunlei_downloadprovider_plugin_a_a) {
        this.b = com_xunlei_downloadprovider_plugin_a_a;
    }

    private java.lang.Boolean a(com.xunlei.downloadprovider.plugin.p... r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        r0 = 0;
        r15 = r15[r0];
        r1 = new java.lang.StringBuilder;
        r2 = "pluginName : ";
        r1.<init>(r2);
        r2 = r15.a;
        r1.append(r2);
        r2 = " version : ";
        r1.append(r2);
        r2 = r15.b;
        r1.append(r2);
        r1 = new java.lang.StringBuilder;
        r2 = "md5 : ";
        r1.<init>(r2);
        r2 = r15.a();
        r1.append(r2);
        r1 = 0;
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x0101, all -> 0x00fd }
        r3 = r15.h;	 Catch:{ Exception -> 0x0101, all -> 0x00fd }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0101, all -> 0x00fd }
        r2 = r2.openConnection();	 Catch:{ Exception -> 0x0101, all -> 0x00fd }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0101, all -> 0x00fd }
        r3 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2.setConnectTimeout(r3);	 Catch:{ Exception -> 0x00fb, all -> 0x00f8 }
        r2.connect();	 Catch:{ Exception -> 0x00fb, all -> 0x00f8 }
        r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x00fb, all -> 0x00f8 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x00fb, all -> 0x00f8 }
        if (r3 == r4) goto L_0x0054;	 Catch:{ Exception -> 0x00fb, all -> 0x00f8 }
    L_0x0045:
        r15 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00fb, all -> 0x00f8 }
        if (r2 == 0) goto L_0x0053;
    L_0x004b:
        r2.disconnect();	 Catch:{ Exception -> 0x004f }
        goto L_0x0053;
    L_0x004f:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0053:
        return r15;
    L_0x0054:
        r3 = r2.getContentLength();	 Catch:{ Exception -> 0x00fb, all -> 0x00f8 }
        r4 = r2.getInputStream();	 Catch:{ Exception -> 0x00fb, all -> 0x00f8 }
        r5 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ Exception -> 0x0103 }
        r15 = r15.a;	 Catch:{ Exception -> 0x0103 }
        r15 = com.xunlei.downloadprovider.plugin.q.a(r5, r15);	 Catch:{ Exception -> 0x0103 }
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0103 }
        r5.<init>(r15);	 Catch:{ Exception -> 0x0103 }
        r6 = r5.exists();	 Catch:{ Exception -> 0x0103 }
        if (r6 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x0103 }
    L_0x0071:
        r5.delete();	 Catch:{ Exception -> 0x0103 }
    L_0x0074:
        r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0103 }
        r5.<init>(r15);	 Catch:{ Exception -> 0x0103 }
        r15 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r15 = new byte[r15];	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r6 = 0;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
    L_0x007f:
        r1 = r4.read(r15);	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r8 = -1;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r9 = 1;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        if (r1 == r8) goto L_0x00d2;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
    L_0x0087:
        r8 = r14.isCancelled();	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        if (r8 == 0) goto L_0x00b1;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
    L_0x008d:
        r4.close();	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r15 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r5.close();	 Catch:{ Exception -> 0x0098 }
        goto L_0x009c;
    L_0x0098:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x009c:
        if (r4 == 0) goto L_0x00a6;
    L_0x009e:
        r4.close();	 Catch:{ Exception -> 0x00a2 }
        goto L_0x00a6;
    L_0x00a2:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00a6:
        if (r2 == 0) goto L_0x00b0;
    L_0x00a8:
        r2.disconnect();	 Catch:{ Exception -> 0x00ac }
        goto L_0x00b0;
    L_0x00ac:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00b0:
        return r15;
    L_0x00b1:
        r10 = (long) r1;
        r12 = r6 + r10;
        r6 = r14.b;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        if (r6 == 0) goto L_0x00cd;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
    L_0x00b8:
        if (r3 <= 0) goto L_0x00cd;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
    L_0x00ba:
        r6 = new java.lang.Integer[r9];	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r7 = 96;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r7 = r7 * r12;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r9 = (long) r3;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r7 = r7 / r9;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r7 = (int) r7;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r7 = r7 + 3;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r6[r0] = r7;	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r14.publishProgress(r6);	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
    L_0x00cd:
        r5.write(r15, r0, r1);	 Catch:{ Exception -> 0x00f6, all -> 0x00f3 }
        r6 = r12;
        goto L_0x007f;
    L_0x00d2:
        r5.close();	 Catch:{ Exception -> 0x00d6 }
        goto L_0x00da;
    L_0x00d6:
        r15 = move-exception;
        r15.printStackTrace();
    L_0x00da:
        if (r4 == 0) goto L_0x00e4;
    L_0x00dc:
        r4.close();	 Catch:{ Exception -> 0x00e0 }
        goto L_0x00e4;
    L_0x00e0:
        r15 = move-exception;
        r15.printStackTrace();
    L_0x00e4:
        if (r2 == 0) goto L_0x00ee;
    L_0x00e6:
        r2.disconnect();	 Catch:{ Exception -> 0x00ea }
        goto L_0x00ee;
    L_0x00ea:
        r15 = move-exception;
        r15.printStackTrace();
    L_0x00ee:
        r15 = java.lang.Boolean.valueOf(r9);
        return r15;
    L_0x00f3:
        r15 = move-exception;
        r1 = r5;
        goto L_0x0127;
    L_0x00f6:
        r1 = r5;
        goto L_0x0103;
    L_0x00f8:
        r15 = move-exception;
        r4 = r1;
        goto L_0x0127;
    L_0x00fb:
        r4 = r1;
        goto L_0x0103;
    L_0x00fd:
        r15 = move-exception;
        r2 = r1;
        r4 = r2;
        goto L_0x0127;
    L_0x0101:
        r2 = r1;
        r4 = r2;
    L_0x0103:
        r15 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x0126 }
        if (r1 == 0) goto L_0x0111;
    L_0x0109:
        r1.close();	 Catch:{ Exception -> 0x010d }
        goto L_0x0111;
    L_0x010d:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0111:
        if (r4 == 0) goto L_0x011b;
    L_0x0113:
        r4.close();	 Catch:{ Exception -> 0x0117 }
        goto L_0x011b;
    L_0x0117:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x011b:
        if (r2 == 0) goto L_0x0125;
    L_0x011d:
        r2.disconnect();	 Catch:{ Exception -> 0x0121 }
        goto L_0x0125;
    L_0x0121:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0125:
        return r15;
    L_0x0126:
        r15 = move-exception;
    L_0x0127:
        if (r1 == 0) goto L_0x0131;
    L_0x0129:
        r1.close();	 Catch:{ Exception -> 0x012d }
        goto L_0x0131;
    L_0x012d:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0131:
        if (r4 == 0) goto L_0x013b;
    L_0x0133:
        r4.close();	 Catch:{ Exception -> 0x0137 }
        goto L_0x013b;
    L_0x0137:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x013b:
        if (r2 == 0) goto L_0x0145;
    L_0x013d:
        r2.disconnect();	 Catch:{ Exception -> 0x0141 }
        goto L_0x0145;
    L_0x0141:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0145:
        throw r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.plugin.o.a(com.xunlei.downloadprovider.plugin.p[]):java.lang.Boolean");
    }
}
