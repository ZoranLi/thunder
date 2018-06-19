package com.baidu.mobads.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobads.a.a;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.FileProvider;
import com.baidu.mobads.openad.d.c;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.av;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.new_ptl.pay.XLPayType;
import java.io.File;
import java.util.List;

public class m implements IXAdPackageUtils {
    public boolean isInstalled(android.content.Context r2, java.lang.String r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = 0;
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r2.getApplicationInfo(r3, r0);	 Catch:{ NameNotFoundException -> 0x0014 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ NameNotFoundException -> 0x0014 }
    L_0x000b:
        r2 = r2.packageName;	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r3.equals(r2);	 Catch:{ NameNotFoundException -> 0x0014 }
        if (r2 == 0) goto L_0x0014;
    L_0x0013:
        r0 = 1;
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.m.isInstalled(android.content.Context, java.lang.String):boolean");
    }

    public boolean isSystemPackage(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & 1) != null ? true : null;
    }

    @android.annotation.TargetApi(3)
    public void openApp(android.content.Context r2, java.lang.String r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r2.getPackageManager();	 Catch:{ Exception -> 0x0011 }
        r3 = r0.getLaunchIntentForPackage(r3);	 Catch:{ Exception -> 0x0011 }
        r0 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x0011 }
        r3.addFlags(r0);	 Catch:{ Exception -> 0x0011 }
        r2.startActivity(r3);	 Catch:{ Exception -> 0x0011 }
        return;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.m.openApp(android.content.Context, java.lang.String):void");
    }

    @java.lang.Deprecated
    public android.content.Intent getInstallIntent(java.lang.String r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0020 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0020 }
        r3 = android.net.Uri.fromFile(r0);	 Catch:{ Exception -> 0x0020 }
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x0020 }
        r1 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x0020 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0020 }
        r1 = "android.intent.category.DEFAULT";	 Catch:{ Exception -> 0x0021 }
        r0.addCategory(r1);	 Catch:{ Exception -> 0x0021 }
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x0021 }
        r0.addFlags(r1);	 Catch:{ Exception -> 0x0021 }
        r1 = "application/vnd.android.package-archive";	 Catch:{ Exception -> 0x0021 }
        r0.setDataAndType(r3, r1);	 Catch:{ Exception -> 0x0021 }
        return r0;
    L_0x0020:
        r0 = 0;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.m.getInstallIntent(java.lang.String):android.content.Intent");
    }

    public Intent a(Context context, File file) {
        Intent intent = null;
        if (file != null) {
            try {
                if (file.exists()) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    if (a(context)) {
                        intent2.addFlags(XLPayType.XL_WX_PAY);
                        context = c(context, file);
                    } else {
                        intent2.addFlags(268435456);
                        context = Uri.fromFile(file);
                    }
                    if (context == null) {
                        return null;
                    }
                    intent2.setDataAndType(context, ApkHelper.MIME_TYPE_APK);
                    intent = intent2;
                }
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return intent;
    }

    public static boolean a(Context context) {
        return (VERSION.SDK_INT < 24 || d(context) < 24) ? null : true;
    }

    private static Uri c(Context context, File file) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(".bd.provider");
            return FileProvider.getUriForFile(context, stringBuilder.toString(), file);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public static boolean b(android.content.Context r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = a(r3);	 Catch:{ Exception -> 0x002a }
        r2 = 1;	 Catch:{ Exception -> 0x002a }
        if (r1 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x002a }
    L_0x000b:
        return r2;	 Catch:{ Exception -> 0x002a }
    L_0x000c:
        r1 = c(r3);	 Catch:{ Exception -> 0x002a }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x002a }
    L_0x0012:
        return r2;	 Catch:{ Exception -> 0x002a }
    L_0x0013:
        r1 = 0;	 Catch:{ Exception -> 0x002a }
        r1 = r3.getExternalFilesDir(r1);	 Catch:{ Exception -> 0x002a }
        if (r1 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x002a }
    L_0x001a:
        r1 = r1.getPath();	 Catch:{ Exception -> 0x002a }
        r1 = com.baidu.mobads.utils.k.a(r1);	 Catch:{ Exception -> 0x002a }
        r3 = c(r3, r1);	 Catch:{ Exception -> 0x002a }
        if (r3 == 0) goto L_0x0029;
    L_0x0028:
        return r2;
    L_0x0029:
        return r0;
    L_0x002a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.m.b(android.content.Context):boolean");
    }

    public static boolean c(Context context) {
        return (!XAdSDKFoundationFacade.getInstance().getCommonUtils().checkSelfPermission(context, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) || c(context, k.a(Environment.getExternalStorageDirectory().getPath())) == null) ? null : true;
    }

    private static boolean c(Context context, String str) {
        if (!a(context)) {
            return true;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(DispatchConstants.TIMESTAMP);
            File file = new File(stringBuilder.toString());
            if (file.exists() == null) {
                file.mkdir();
            }
            return c(context, file) != null;
        } catch (Throwable e) {
            l.a().e(e);
            return false;
        }
    }

    public Intent a(Context context, String str) {
        try {
            return a(context, new File(str));
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public void b(Context context, File file) {
        try {
            context.startActivity(a(context, file));
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void b(Context context, String str) {
        try {
            context.startActivity(a(context, str));
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public int getAppVersion(android.content.Context r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0011 }
        r3 = r3.getPackageName();	 Catch:{ NameNotFoundException -> 0x0011 }
        r1 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;	 Catch:{ NameNotFoundException -> 0x0011 }
        r3 = r0.getPackageInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0011 }
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r3 = 0;
    L_0x0012:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.m.getAppVersion(android.content.Context):int");
    }

    public com.baidu.mobads.interfaces.utils.IXAdPackageUtils.ApkInfo getLocalApkFileInfo(android.content.Context r4, java.lang.String r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = r4.getPackageManager();	 Catch:{ Exception -> 0x0013 }
        r2 = 1;	 Catch:{ Exception -> 0x0013 }
        r5 = r1.getPackageArchiveInfo(r5, r2);	 Catch:{ Exception -> 0x0013 }
        if (r5 == 0) goto L_0x0012;	 Catch:{ Exception -> 0x0013 }
    L_0x000c:
        r1 = new com.baidu.mobads.interfaces.utils.IXAdPackageUtils$ApkInfo;	 Catch:{ Exception -> 0x0013 }
        r1.<init>(r4, r5);	 Catch:{ Exception -> 0x0013 }
        r0 = r1;
    L_0x0012:
        return r0;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.m.getLocalApkFileInfo(android.content.Context, java.lang.String):com.baidu.mobads.interfaces.utils.IXAdPackageUtils$ApkInfo");
    }

    public boolean isForeground(android.content.Context r4, java.lang.String r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = "activity";	 Catch:{ Exception -> 0x002f }
        r4 = r4.getSystemService(r1);	 Catch:{ Exception -> 0x002f }
        r4 = (android.app.ActivityManager) r4;	 Catch:{ Exception -> 0x002f }
        r4 = r4.getRunningAppProcesses();	 Catch:{ Exception -> 0x002f }
        r4 = r4.iterator();	 Catch:{ Exception -> 0x002f }
    L_0x0011:
        r1 = r4.hasNext();	 Catch:{ Exception -> 0x002f }
        if (r1 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x002f }
    L_0x0017:
        r1 = r4.next();	 Catch:{ Exception -> 0x002f }
        r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1;	 Catch:{ Exception -> 0x002f }
        r2 = r1.processName;	 Catch:{ Exception -> 0x002f }
        r2 = r2.equals(r5);	 Catch:{ Exception -> 0x002f }
        if (r2 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x002f }
    L_0x0025:
        r4 = r1.importance;	 Catch:{ Exception -> 0x002f }
        r5 = 100;
        if (r4 != r5) goto L_0x002d;
    L_0x002b:
        r4 = 1;
        return r4;
    L_0x002d:
        return r0;
    L_0x002e:
        return r0;
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.m.isForeground(android.content.Context, java.lang.String):boolean");
    }

    public void sendAPOIsSuccess(Context context, boolean z, int i, String str, String str2) {
        d commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
        str = uRIUitls.encodeUrl(str);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("aposuccess=");
        stringBuilder2.append(z);
        stringBuilder.append(stringBuilder2.toString());
        if (!z) {
            z = new StringBuilder("&failtime=");
            z.append(i);
            stringBuilder.append(z.toString());
        }
        z = new StringBuilder("&sn=");
        z.append(systemUtils.getEncodedSN(context));
        stringBuilder.append(z.toString());
        z = new StringBuilder("&mac=");
        z.append(base64.encode(systemUtils.getMacAddress(context)));
        stringBuilder.append(z.toString());
        z = new StringBuilder("&cuid=");
        z.append(systemUtils.getCUID(context));
        stringBuilder.append(z.toString());
        z = new StringBuilder("&pack=");
        z.append(context.getPackageName());
        stringBuilder.append(z.toString());
        context = new StringBuilder("&v=");
        z = new StringBuilder("android_");
        z.append(a.c);
        z.append("_4.1.30");
        context.append(z.toString());
        stringBuilder.append(context.toString());
        context = new StringBuilder("&targetscheme=");
        context.append(str);
        stringBuilder.append(context.toString());
        context = new StringBuilder("&pk=");
        context.append(str2);
        stringBuilder.append(context.toString());
        try {
            c cVar = new c(uRIUitls.addParameters(commonUtils.vdUrl(stringBuilder.toString(), true), false), "");
            cVar.e = 1;
            new com.baidu.mobads.openad.d.a().a(cVar);
        } catch (Context context2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", context2.getMessage());
        }
    }

    public boolean sendAPOInfo(Context context, String str, String str2, int i, int i2, int i3) {
        String str3;
        boolean z;
        Exception exception;
        StringBuilder stringBuilder;
        String str4 = str2;
        int i4 = i3;
        PackageManager packageManager = context.getPackageManager();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        d commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        String encodeUrl = uRIUitls.encodeUrl(str);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        StringBuilder stringBuilder2 = new StringBuilder("&sn=");
        stringBuilder2.append(systemUtils.getEncodedSN(context));
        stringBuilder2.append("&fb_act=");
        stringBuilder2.append(i2);
        stringBuilder2.append("&pack=");
        stringBuilder2.append(context.getPackageName());
        stringBuilder2.append("&v=");
        StringBuilder stringBuilder3 = new StringBuilder("android_");
        stringBuilder3.append(a.c);
        stringBuilder3.append("_4.1.30");
        stringBuilder2.append(stringBuilder3.toString());
        stringBuilder2.append("&targetscheme=");
        stringBuilder2.append(encodeUrl);
        stringBuilder2.append("&pk=");
        stringBuilder2.append(str4);
        String stringBuilder4 = stringBuilder2.toString();
        encodeUrl = "&open=";
        boolean z2 = false;
        if (queryIntentActivities.size() > 0) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(encodeUrl);
            stringBuilder2.append("true");
            encodeUrl = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(encodeUrl);
            stringBuilder2.append("&n=");
            stringBuilder2.append(queryIntentActivities.size());
            encodeUrl = stringBuilder2.toString();
            String str5 = "";
            str3 = encodeUrl;
            z = true;
            int i5 = 0;
            while (i5 < queryIntentActivities.size()) {
                StringBuilder stringBuilder5;
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i5);
                if (i5 == 0) {
                    stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(str3);
                    stringBuilder5.append("&p=");
                    stringBuilder5.append(resolveInfo.activityInfo.packageName);
                    str3 = stringBuilder5.toString();
                } else {
                    stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(str3);
                    stringBuilder5.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    stringBuilder5.append(resolveInfo.activityInfo.packageName);
                    str3 = stringBuilder5.toString();
                }
                if (str4.equals(resolveInfo.activityInfo.packageName)) {
                    int i6;
                    try {
                        i6 = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, z2).versionCode;
                        if (i6 < i4) {
                            z = z2;
                        }
                        try {
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append(str5);
                            stringBuilder5.append("&installedVersion=");
                            stringBuilder5.append(i6);
                            stringBuilder5.append("&requiredVersion=");
                            stringBuilder5.append(i4);
                            stringBuilder5.append("&realopen=");
                            stringBuilder5.append(z);
                            str5 = stringBuilder5.toString();
                        } catch (Exception e) {
                            exception = e;
                            stringBuilder5 = new StringBuilder();
                            stringBuilder5.append(str5);
                            stringBuilder5.append("&exception=true&installedVersion=");
                            stringBuilder5.append(i6);
                            stringBuilder5.append("&requiredVersion=");
                            stringBuilder5.append(i4);
                            stringBuilder5.append("&realopen=");
                            stringBuilder5.append(z);
                            str5 = stringBuilder5.toString();
                            exception.printStackTrace();
                            i5++;
                            z2 = false;
                        }
                    } catch (Exception e2) {
                        exception = e2;
                        i6 = -1;
                        stringBuilder5 = new StringBuilder();
                        stringBuilder5.append(str5);
                        stringBuilder5.append("&exception=true&installedVersion=");
                        stringBuilder5.append(i6);
                        stringBuilder5.append("&requiredVersion=");
                        stringBuilder5.append(i4);
                        stringBuilder5.append("&realopen=");
                        stringBuilder5.append(z);
                        str5 = stringBuilder5.toString();
                        exception.printStackTrace();
                        i5++;
                        z2 = false;
                    }
                }
                i5++;
                z2 = false;
            }
            if (!str5.equals("")) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                stringBuilder.append(str5);
                str3 = stringBuilder.toString();
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(encodeUrl);
            stringBuilder.append(av.b);
            str3 = stringBuilder.toString();
            z = false;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder4);
        stringBuilder.append(str3);
        try {
            c cVar = new c(uRIUitls.addParameters(commonUtils.vdUrl(stringBuilder.toString(), i), null), "");
            cVar.e = 1;
            new com.baidu.mobads.openad.d.a().a(cVar);
            return z;
        } catch (Exception e22) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", e22.getMessage());
            return z;
        }
    }

    public void sendDialerIsSuccess(Context context, boolean z, int i, String str) {
        d commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("callstate=");
        stringBuilder2.append(z);
        stringBuilder.append(stringBuilder2.toString());
        if (!z) {
            z = new StringBuilder("&duration=");
            z.append(i);
            stringBuilder.append(z.toString());
        }
        z = new StringBuilder("&sn=");
        z.append(systemUtils.getEncodedSN(context));
        stringBuilder.append(z.toString());
        z = new StringBuilder("&mac=");
        z.append(base64.encode(systemUtils.getMacAddress(context)));
        stringBuilder.append(z.toString());
        z = new StringBuilder("&bdr=");
        z.append(VERSION.SDK_INT);
        stringBuilder.append(z.toString());
        z = new StringBuilder("&cuid=");
        z.append(systemUtils.getCUID(context));
        stringBuilder.append(z.toString());
        z = new StringBuilder("&pack=");
        z.append(context.getPackageName());
        stringBuilder.append(z.toString());
        context = new StringBuilder("&v=");
        z = new StringBuilder("android_");
        z.append(a.c);
        z.append("_4.1.30");
        context.append(z.toString());
        stringBuilder.append(context.toString());
        context = new StringBuilder("&pk=");
        context.append(str);
        stringBuilder.append(context.toString());
        try {
            c cVar = new c(uRIUitls.addParameters(commonUtils.vdUrl(stringBuilder.toString(), true), false), "");
            cVar.e = 1;
            new com.baidu.mobads.openad.d.a().a(cVar);
        } catch (Context context2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", context2.getMessage());
        }
    }

    public static int d(Context context) {
        try {
            return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }
}
