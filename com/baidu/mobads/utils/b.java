package com.baidu.mobads.utils;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.xiaomi.mipush.sdk.Constants;

public class b implements IXAdActivityUtils {
    public java.lang.Boolean isFullScreen(android.app.Activity r3) {
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
        r0 = 0;
        if (r3 == 0) goto L_0x001a;
    L_0x0003:
        r3 = r3.getWindow();	 Catch:{ Exception -> 0x001f }
        r3 = r3.getAttributes();	 Catch:{ Exception -> 0x001f }
        r3 = r3.flags;	 Catch:{ Exception -> 0x001f }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Exception -> 0x001f }
        r3 = r3 & r1;	 Catch:{ Exception -> 0x001f }
        if (r3 != r1) goto L_0x0014;	 Catch:{ Exception -> 0x001f }
    L_0x0012:
        r3 = 1;	 Catch:{ Exception -> 0x001f }
        goto L_0x0015;	 Catch:{ Exception -> 0x001f }
    L_0x0014:
        r3 = r0;	 Catch:{ Exception -> 0x001f }
    L_0x0015:
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ Exception -> 0x001f }
        return r3;	 Catch:{ Exception -> 0x001f }
    L_0x001a:
        r3 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x001f }
        return r3;
    L_0x001f:
        r3 = java.lang.Boolean.valueOf(r0);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.b.isFullScreen(android.app.Activity):java.lang.Boolean");
    }

    public void showAlertDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (activity != null) {
            try {
                new Builder(activity).setCancelable(z).setTitle(str).setMessage(str2).setPositiveButton(str3, onClickListener).setNegativeButton(str4, onClickListener2).create().show();
            } catch (Throwable e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
            }
        }
    }

    public boolean webviewMultiProcess(Activity activity) {
        if (activity == null) {
            return false;
        }
        activity = activity.getPackageManager().queryIntentActivities(new Intent(activity, AppActivity.class), 0);
        if (activity == null || activity.size() <= 0) {
            return false;
        }
        activity = ((ResolveInfo) activity.get(0)).activityInfo.processName;
        if (TextUtils.isEmpty(activity)) {
            return false;
        }
        if (activity.contains(Constants.COLON_SEPARATOR) || activity.endsWith("webview") != null) {
            return true;
        }
        return false;
    }
}
