package com.baidu.android.common.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;

public class ConnectManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "ConnectManager";
    private String mApn;
    private String mNetType;
    private String mPort;
    private String mProxy;
    private int mSubType;
    private String mSubTypeName;
    private boolean mUseWap;

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    private void checkApn(Context context, NetworkInfo networkInfo) {
        String toLowerCase;
        if (networkInfo.getExtraInfo() != null) {
            toLowerCase = networkInfo.getExtraInfo().toLowerCase();
            if (toLowerCase != null) {
                if (!(toLowerCase.startsWith("cmwap") || toLowerCase.startsWith("uniwap"))) {
                    if (!toLowerCase.startsWith("3gwap")) {
                        if (toLowerCase.startsWith("ctwap")) {
                            this.mUseWap = true;
                            this.mApn = toLowerCase;
                            this.mProxy = "10.0.0.200";
                            this.mPort = "80";
                            return;
                        } else if (toLowerCase.startsWith("cmnet") || toLowerCase.startsWith("uninet") || toLowerCase.startsWith("ctnet") || toLowerCase.startsWith("3gnet")) {
                            this.mUseWap = false;
                            this.mApn = toLowerCase;
                            return;
                        }
                    }
                }
                this.mUseWap = true;
                this.mApn = toLowerCase;
                this.mProxy = "10.0.0.172";
                this.mPort = "80";
                return;
            }
        }
        toLowerCase = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (toLowerCase == null || toLowerCase.length() <= 0) {
            this.mUseWap = false;
            return;
        }
        this.mProxy = toLowerCase;
        if ("10.0.0.172".equals(this.mProxy.trim())) {
            this.mUseWap = true;
            this.mPort = "80";
        } else if ("10.0.0.200".equals(this.mProxy.trim())) {
            this.mUseWap = true;
            this.mPort = "80";
        } else {
            this.mUseWap = false;
            this.mPort = Integer.toString(defaultPort);
        }
    }

    private void checkNetworkType(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r4.getApplicationContext();
        r1 = "connectivity";
        r0 = r0.getSystemService(r1);
        r0 = (android.net.ConnectivityManager) r0;
        r0 = r0.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r0 = 0;
    L_0x0012:
        if (r0 == 0) goto L_0x003f;
    L_0x0014:
        r1 = "wifi";
        r2 = r0.getTypeName();
        r2 = r2.toLowerCase();
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x002c;
    L_0x0024:
        r4 = "wifi";
        r3.mNetType = r4;
        r4 = 0;
        r3.mUseWap = r4;
        goto L_0x0033;
    L_0x002c:
        r3.checkApn(r4, r0);
        r4 = r3.mApn;
        r3.mNetType = r4;
    L_0x0033:
        r4 = r0.getSubtype();
        r3.mSubType = r4;
        r4 = r0.getSubtypeName();
        r3.mSubTypeName = r4;
    L_0x003f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.net.ConnectManager.checkNetworkType(android.content.Context):void");
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false;
    }

    public String getApn() {
        return this.mApn;
    }

    public String getNetType() {
        return this.mNetType;
    }

    public String getProxy() {
        return this.mProxy;
    }

    public String getProxyPort() {
        return this.mPort;
    }

    public int getSubType() {
        return this.mSubType;
    }

    public String getSubTypeName() {
        return this.mSubTypeName;
    }

    public boolean isWapNetwork() {
        return this.mUseWap;
    }
}
