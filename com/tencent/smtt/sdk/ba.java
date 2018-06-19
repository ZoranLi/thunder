package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

class ba {
    private Context a = null;
    private Context b = null;
    private String c = null;
    private String[] d = null;
    private DexLoader e = null;
    private String f = "TbsDexOpt";
    private String g = null;

    public ba(Context context, Context context2, String str, String str2, String[] strArr, String str3) {
        TbsLog.i("TbsWizard", "construction start...");
        if (!(context == null || ((context2 == null && TbsShareManager.getHostCorePathAppDefined() == null) || TextUtils.isEmpty(str) || strArr == null))) {
            if (strArr.length != 0) {
                this.a = context.getApplicationContext();
                this.b = context2;
                this.c = str;
                this.d = strArr;
                this.f = str2;
                this.e = new DexLoader(str3, this.a, this.d, str2, QbSdk.l);
                libwebp.loadWepLibraryIfNeed(context2, this.c);
                if ("com.nd.android.pandahome2".equals(this.a.getApplicationInfo().packageName)) {
                    this.e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.a);
                }
                if (QbSdk.l != null) {
                    this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.l);
                }
                int a = a(context);
                if (a < 0) {
                    StringBuilder stringBuilder = new StringBuilder("TbsWizard init error: ");
                    stringBuilder.append(a);
                    stringBuilder.append("; msg: ");
                    stringBuilder.append(this.g);
                    throw new Exception(stringBuilder.toString());
                }
                TbsLog.i("TbsWizard", "construction end...");
                return;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("TbsWizard paramter error:-1callerContext:");
        stringBuilder2.append(context);
        stringBuilder2.append("hostcontext");
        stringBuilder2.append(context2);
        stringBuilder2.append("isEmpty");
        stringBuilder2.append(TextUtils.isEmpty(str));
        stringBuilder2.append("dexfileList");
        stringBuilder2.append(strArr);
        throw new Exception(stringBuilder2.toString());
    }

    private int a(Context context) {
        Object invokeStaticMethod;
        int i;
        String str;
        if (this.b != null || TbsShareManager.getHostCorePathAppDefined() == null) {
            invokeStaticMethod = r0.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, r0.b, r0.e, r0.c, r0.f, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf(43500), QbSdk.a());
        } else {
            invokeStaticMethod = r0.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, r0.b, r0.e, r0.c, r0.f, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf(43500), QbSdk.a(), TbsShareManager.getHostCorePathAppDefined());
        }
        if (invokeStaticMethod == null) {
            c();
            d();
            invokeStaticMethod = r0.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, r0.b, r0.e, r0.c, r0.f);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().a(r0.a, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            invokeStaticMethod = r0.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod;
                StringBuilder stringBuilder = new StringBuilder("#");
                stringBuilder.append(th.getMessage());
                stringBuilder.append("; cause: ");
                stringBuilder.append(th.getCause());
                stringBuilder.append("; th: ");
                stringBuilder.append(th);
                r0.g = stringBuilder.toString();
            }
            if (invokeStaticMethod instanceof String) {
                str = (String) invokeStaticMethod;
            }
            return i;
        }
        str = null;
        r0.g = str;
        return i;
    }

    private void c() {
        this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    private void d() {
        this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43500));
    }

    public String a() {
        Class[] clsArr = new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class};
        r3 = new Object[5];
        String str = null;
        r3[3] = null;
        r3[4] = new Object[0];
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", clsArr, r3);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            String valueOf = String.valueOf(invokeStaticMethod);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(valueOf);
            stringBuilder.append(" ReaderPackName=");
            stringBuilder.append(TbsReaderView.gReaderPackName);
            stringBuilder.append(" ReaderPackVersion=");
            stringBuilder.append(TbsReaderView.gReaderPackVersion);
            str = stringBuilder.toString();
        }
        return str == null ? "X5 core get nothing..." : str;
    }

    public boolean a(Context context, String str, String str2, Bundle bundle) {
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public DexLoader b() {
        return this.e;
    }
}
