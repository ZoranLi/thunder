package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener aj;
    private String am;
    private int as;
    private String url;

    static class a {
        public OAuthErrCode al;
        public String at;
        public int au;

        a() {
        }

        public static com.tencent.mm.opensdk.diffdev.a.f.a d(byte[] r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:25:0x005f in {4, 14, 16, 18, 19, 20, 21, 22, 24, 27, 28, 30, 32, 33} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = new com.tencent.mm.opensdk.diffdev.a.f$a;
            r0.<init>();
            if (r6 == 0) goto L_0x007f;
        L_0x0007:
            r1 = r6.length;
            if (r1 != 0) goto L_0x000c;
        L_0x000a:
            goto L_0x007f;
        L_0x000c:
            r1 = 0;
            r2 = 1;
            r3 = new java.lang.String;	 Catch:{ Exception -> 0x0073 }
            r4 = "utf-8";	 Catch:{ Exception -> 0x0073 }
            r3.<init>(r6, r4);	 Catch:{ Exception -> 0x0073 }
            r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0060 }
            r6.<init>(r3);	 Catch:{ Exception -> 0x0060 }
            r3 = "wx_errcode";	 Catch:{ Exception -> 0x0060 }
            r3 = r6.getInt(r3);	 Catch:{ Exception -> 0x0060 }
            r0.au = r3;	 Catch:{ Exception -> 0x0060 }
            r3 = "nooping uuidStatusCode = %d";	 Catch:{ Exception -> 0x0060 }
            r4 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0060 }
            r5 = r0.au;	 Catch:{ Exception -> 0x0060 }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0060 }
            r4[r1] = r5;	 Catch:{ Exception -> 0x0060 }
            java.lang.String.format(r3, r4);	 Catch:{ Exception -> 0x0060 }
            r3 = r0.au;	 Catch:{ Exception -> 0x0060 }
            r4 = 408; // 0x198 float:5.72E-43 double:2.016E-321;	 Catch:{ Exception -> 0x0060 }
            if (r3 == r4) goto L_0x005c;	 Catch:{ Exception -> 0x0060 }
        L_0x0037:
            r4 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Exception -> 0x0060 }
            if (r3 == r4) goto L_0x0059;	 Catch:{ Exception -> 0x0060 }
        L_0x003b:
            switch(r3) {
                case 402: goto L_0x0056;
                case 403: goto L_0x0053;
                case 404: goto L_0x0050;
                case 405: goto L_0x0043;
                default: goto L_0x003e;
            };	 Catch:{ Exception -> 0x0060 }
        L_0x003e:
            r6 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0060 }
        L_0x0040:
            r0.al = r6;	 Catch:{ Exception -> 0x0060 }
            return r0;	 Catch:{ Exception -> 0x0060 }
        L_0x0043:
            r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0060 }
            r0.al = r3;	 Catch:{ Exception -> 0x0060 }
            r3 = "wx_code";	 Catch:{ Exception -> 0x0060 }
            r6 = r6.getString(r3);	 Catch:{ Exception -> 0x0060 }
            r0.at = r6;	 Catch:{ Exception -> 0x0060 }
            return r0;	 Catch:{ Exception -> 0x0060 }
        L_0x0050:
            r6 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0060 }
            goto L_0x0040;	 Catch:{ Exception -> 0x0060 }
        L_0x0053:
            r6 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel;	 Catch:{ Exception -> 0x0060 }
            goto L_0x0040;	 Catch:{ Exception -> 0x0060 }
        L_0x0056:
            r6 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout;	 Catch:{ Exception -> 0x0060 }
            goto L_0x0040;	 Catch:{ Exception -> 0x0060 }
        L_0x0059:
            r6 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;	 Catch:{ Exception -> 0x0060 }
            goto L_0x0040;	 Catch:{ Exception -> 0x0060 }
        L_0x005c:
            r6 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;	 Catch:{ Exception -> 0x0060 }
            goto L_0x0040;
            return r0;
        L_0x0060:
            r6 = move-exception;
            r3 = "parse json fail, ex = %s";
            r2 = new java.lang.Object[r2];
            r6 = r6.getMessage();
            r2[r1] = r6;
        L_0x006b:
            java.lang.String.format(r3, r2);
            r6 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
        L_0x0070:
            r0.al = r6;
            return r0;
        L_0x0073:
            r6 = move-exception;
            r3 = "parse fail, build String fail, ex = %s";
            r2 = new java.lang.Object[r2];
            r6 = r6.getMessage();
            r2[r1] = r6;
            goto L_0x006b;
        L_0x007f:
            r6 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            goto L_0x0070;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.f.a.d(byte[]):com.tencent.mm.opensdk.diffdev.a.f$a");
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.am = str;
        this.aj = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        if (this.am != null) {
            if (this.am.length() != 0) {
                while (!isCancelled()) {
                    String str;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.url);
                    if (this.as == 0) {
                        str = "";
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder("&last=");
                        stringBuilder2.append(this.as);
                        str = stringBuilder2.toString();
                    }
                    stringBuilder.append(str);
                    String stringBuilder3 = stringBuilder.toString();
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] b = e.b(stringBuilder3, 60000);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    a d = a.d(b);
                    String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", new Object[]{stringBuilder3, d.al.toString(), Integer.valueOf(d.au), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
                    if (d.al == OAuthErrCode.WechatAuth_Err_OK) {
                        this.as = d.au;
                        if (d.au == g.UUID_SCANED.getCode()) {
                            this.aj.onQrcodeScanned();
                        } else if (d.au != g.UUID_KEEP_CONNECT.getCode() && d.au == g.UUID_CONFIRM.getCode()) {
                            if (d.at == null || d.at.length() == 0) {
                                d.al = OAuthErrCode.WechatAuth_Err_NormalErr;
                            }
                            return d;
                        }
                    }
                    String.format("nooping fail, errCode = %s, uuidStatusCode = %d", new Object[]{d.al.toString(), Integer.valueOf(d.au)});
                    return d;
                }
                aVar = new a();
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
                aVar.al = oAuthErrCode;
                return aVar;
            }
        }
        aVar = new a();
        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.al = oAuthErrCode;
        return aVar;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.aj.onAuthFinish(aVar.al, aVar.at);
    }
}
