package com.baidu.mobads.interfaces.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;

public interface IXAdPackageUtils {

    public static class ApkInfo {
        private PackageInfo a;
        public final String appName;
        public final String packageName;
        public final int versionCode;
        public final String versionName;

        public ApkInfo(Context context, PackageInfo packageInfo) {
            this.a = packageInfo;
            this.packageName = packageInfo.packageName;
            this.versionName = packageInfo.versionName;
            this.versionCode = packageInfo.versionCode;
            this.appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
        }

        public org.json.JSONObject toJSONObject() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
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
            r4 = this;
            r0 = new org.json.JSONObject;
            r0.<init>();
            r1 = "p";	 Catch:{ JSONException -> 0x002e }
            r2 = r4.packageName;	 Catch:{ JSONException -> 0x002e }
            r0.put(r1, r2);	 Catch:{ JSONException -> 0x002e }
            r1 = "v";	 Catch:{ JSONException -> 0x002e }
            r2 = r4.versionName;	 Catch:{ JSONException -> 0x002e }
            r0.put(r1, r2);	 Catch:{ JSONException -> 0x002e }
            r1 = "c";	 Catch:{ JSONException -> 0x002e }
            r2 = r4.versionCode;	 Catch:{ JSONException -> 0x002e }
            r0.put(r1, r2);	 Catch:{ JSONException -> 0x002e }
            r1 = "s";	 Catch:{ JSONException -> 0x002e }
            r2 = new java.io.File;	 Catch:{ JSONException -> 0x002e }
            r3 = r4.a;	 Catch:{ JSONException -> 0x002e }
            r3 = r3.applicationInfo;	 Catch:{ JSONException -> 0x002e }
            r3 = r3.sourceDir;	 Catch:{ JSONException -> 0x002e }
            r2.<init>(r3);	 Catch:{ JSONException -> 0x002e }
            r2 = r2.lastModified();	 Catch:{ JSONException -> 0x002e }
            r0.put(r1, r2);	 Catch:{ JSONException -> 0x002e }
        L_0x002e:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.interfaces.utils.IXAdPackageUtils.ApkInfo.toJSONObject():org.json.JSONObject");
        }

        public org.json.JSONObject toRecentJSONObject() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
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
            r3 = this;
            r0 = new org.json.JSONObject;
            r0.<init>();
            r1 = "p";	 Catch:{ JSONException -> 0x001a }
            r2 = r3.packageName;	 Catch:{ JSONException -> 0x001a }
            r0.put(r1, r2);	 Catch:{ JSONException -> 0x001a }
            r1 = "v";	 Catch:{ JSONException -> 0x001a }
            r2 = r3.versionName;	 Catch:{ JSONException -> 0x001a }
            r0.put(r1, r2);	 Catch:{ JSONException -> 0x001a }
            r1 = "c";	 Catch:{ JSONException -> 0x001a }
            r2 = r3.versionCode;	 Catch:{ JSONException -> 0x001a }
            r0.put(r1, r2);	 Catch:{ JSONException -> 0x001a }
        L_0x001a:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.interfaces.utils.IXAdPackageUtils.ApkInfo.toRecentJSONObject():org.json.JSONObject");
        }
    }

    int getAppVersion(Context context);

    Intent getInstallIntent(String str);

    ApkInfo getLocalApkFileInfo(Context context, String str);

    boolean isForeground(Context context, String str);

    boolean isInstalled(Context context, String str);

    boolean isSystemPackage(PackageInfo packageInfo);

    void openApp(Context context, String str);

    boolean sendAPOInfo(Context context, String str, String str2, int i, int i2, int i3);

    void sendAPOIsSuccess(Context context, boolean z, int i, String str, String str2);

    void sendDialerIsSuccess(Context context, boolean z, int i, String str);
}
