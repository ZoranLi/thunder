package com.igexin.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.util.a;
import com.igexin.push.util.e;
import com.igexin.sdk.a.c;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;

public class PushManager {
    private long a;
    private long b;
    private long c;
    private byte[] d;
    private Class e;
    private String f;
    private String g;

    private PushManager() {
    }

    private Class a(Context context) {
        return GTServiceManager.getInstance().getUserPushService(context);
    }

    private java.lang.String a(java.lang.String r6) {
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
        r5 = this;
        r0 = "MD5";	 Catch:{ Exception -> 0x003a }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x003a }
        r6 = r6.getBytes();	 Catch:{ Exception -> 0x003a }
        r0.update(r6);	 Catch:{ Exception -> 0x003a }
        r6 = r0.digest();	 Catch:{ Exception -> 0x003a }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003a }
        r1 = "";	 Catch:{ Exception -> 0x003a }
        r0.<init>(r1);	 Catch:{ Exception -> 0x003a }
        r1 = r6.length;	 Catch:{ Exception -> 0x003a }
        r2 = 0;	 Catch:{ Exception -> 0x003a }
    L_0x001a:
        if (r2 >= r1) goto L_0x0035;	 Catch:{ Exception -> 0x003a }
    L_0x001c:
        r3 = r6[r2];	 Catch:{ Exception -> 0x003a }
        if (r3 >= 0) goto L_0x0022;	 Catch:{ Exception -> 0x003a }
    L_0x0020:
        r3 = r3 + 256;	 Catch:{ Exception -> 0x003a }
    L_0x0022:
        r4 = 16;	 Catch:{ Exception -> 0x003a }
        if (r3 >= r4) goto L_0x002b;	 Catch:{ Exception -> 0x003a }
    L_0x0026:
        r4 = "0";	 Catch:{ Exception -> 0x003a }
        r0.append(r4);	 Catch:{ Exception -> 0x003a }
    L_0x002b:
        r3 = java.lang.Integer.toHexString(r3);	 Catch:{ Exception -> 0x003a }
        r0.append(r3);	 Catch:{ Exception -> 0x003a }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x003a }
        goto L_0x001a;	 Catch:{ Exception -> 0x003a }
    L_0x0035:
        r6 = r0.toString();	 Catch:{ Exception -> 0x003a }
        return r6;
    L_0x003a:
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.PushManager.a(java.lang.String):java.lang.String");
    }

    private void a(android.content.Context r4, android.os.Bundle r5) {
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
        r0 = new android.content.Intent;	 Catch:{ Throwable -> 0x0020 }
        r1 = r4.getApplicationContext();	 Catch:{ Throwable -> 0x0020 }
        r2 = r3.a(r4);	 Catch:{ Throwable -> 0x0020 }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0020 }
        r1 = "action";	 Catch:{ Throwable -> 0x0020 }
        r2 = "com.igexin.sdk.action.pushmanager";	 Catch:{ Throwable -> 0x0020 }
        r0.putExtra(r1, r2);	 Catch:{ Throwable -> 0x0020 }
        r1 = "bundle";	 Catch:{ Throwable -> 0x0020 }
        r0.putExtra(r1, r5);	 Catch:{ Throwable -> 0x0020 }
        r4 = r4.getApplicationContext();	 Catch:{ Throwable -> 0x0020 }
        r4.startService(r0);	 Catch:{ Throwable -> 0x0020 }
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.PushManager.a(android.content.Context, android.os.Bundle):void");
    }

    public static PushManager getInstance() {
        return d.a;
    }

    private <T extends Activity> void registerPushActivity(Context context, Class<T> cls) {
        String name;
        StringBuilder stringBuilder;
        if (cls != null) {
            try {
                Class.forName(cls.getName());
                if (a.a(context, (Class) cls)) {
                    name = cls.getName();
                } else {
                    return;
                }
            } catch (Exception e) {
                new StringBuilder("can't load activity = ").append(e.toString());
                stringBuilder = new StringBuilder("PushManager|registerPushActiviy|");
                stringBuilder.append(e.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return;
            } catch (Throwable th) {
                stringBuilder = new StringBuilder("PushManager|registerPushActiviy|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return;
            }
        }
        name = "";
        this.g = name;
        if (this.e != null) {
            Intent intent = new Intent(context.getApplicationContext(), this.e);
            intent.putExtra("ua", this.g);
            context.getApplicationContext().startService(intent);
        }
    }

    public boolean bindAlias(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder("bindAlias_");
        stringBuilder.append(System.currentTimeMillis());
        return bindAlias(context, str, stringBuilder.toString());
    }

    public boolean bindAlias(Context context, String str, String str2) {
        com.igexin.b.a.c.a.b("PushManager|call bindAlias");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.c < 5000) {
            return false;
        }
        this.c = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString("action", "bindAlias");
        bundle.putString("alias", str);
        bundle.putString("sn", str2);
        a(context, bundle);
        return true;
    }

    public String getClientid(Context context) {
        if (this.d == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    Object string = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID);
                    Object string2 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPSECRET);
                    Object string3 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPKEY);
                    if (string != null) {
                        string = string.trim();
                    }
                    if (string2 != null) {
                        string2 = string2.trim();
                    }
                    if (string3 != null) {
                        string3 = string3.trim();
                    }
                    if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3))) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string);
                        stringBuilder.append(string2);
                        stringBuilder.append(string3);
                        stringBuilder.append(context.getPackageName());
                        String a = a(stringBuilder.toString());
                        if (a != null) {
                            this.d = a.getBytes();
                        }
                    }
                }
            } catch (Exception e) {
                StringBuilder stringBuilder2 = new StringBuilder("PushManager|");
                stringBuilder2.append(e.toString());
                com.igexin.b.a.c.a.b(stringBuilder2.toString());
            }
        }
        if (this.d != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(context.getFilesDir().getPath());
            stringBuilder3.append("/init.pid");
            byte[] a2 = e.a(stringBuilder3.toString());
            if (!(this.d == null || a2 == null || this.d.length != a2.length)) {
                byte[] bArr = new byte[a2.length];
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (this.d[i] ^ a2[i]);
                }
                return new String(bArr);
            }
        }
        return null;
    }

    public String getVersion(Context context) {
        return PushBuildConfig.sdk_conf_version;
    }

    public <T extends Service> void initialize(Context context, Class<T> cls) {
        try {
            String packageName = context.getApplicationContext().getPackageName();
            String a = a.a(context);
            if (a != null && (a.contains("gtsync") || a.contains("gtdms"))) {
                StringBuilder stringBuilder = new StringBuilder("PushManager|init by default = ");
                stringBuilder.append(a);
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            } else if (a.a("PushManager", context, (Class) cls)) {
                Class cls2;
                if (cls == null || com.igexin.push.core.a.n.equals(cls.getName())) {
                    cls2 = PushService.class;
                }
                Intent intent = new Intent(context.getApplicationContext(), cls2);
                intent.putExtra("action", PushConsts.ACTION_SERVICE_INITIALIZE);
                intent.putExtra("op_app", packageName);
                intent.putExtra("us", cls2.getName());
                if (this.f != null) {
                    intent.putExtra("uis", this.f);
                }
                if (this.g != null) {
                    intent.putExtra("ua", this.g);
                }
                context.getApplicationContext().startService(intent);
                this.e = cls2;
            } else {
                com.igexin.b.a.c.a.b("PushManager|init checkServiceSetCorrectly false");
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("PushManager|initialize|");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
    }

    public boolean isPushTurnedOn(Context context) {
        return new c(context).c();
    }

    public <T extends GTIntentService> void registerPushIntentService(Context context, Class<T> cls) {
        String name;
        StringBuilder stringBuilder;
        com.igexin.b.a.c.a.b("PushManager|call registerPushIntentService");
        if (cls != null) {
            try {
                Class.forName(cls.getName());
                if (a.b(new Intent(context, cls), context)) {
                    name = cls.getName();
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder("call - > registerPushIntentService, parameter [userIntentService] is set, but didn't find class \"");
                    stringBuilder2.append(cls.getName());
                    stringBuilder2.append("\", please check your AndroidManifest");
                    return;
                }
            } catch (Exception e) {
                new StringBuilder("can't load IntentService = ").append(e.toString());
                stringBuilder = new StringBuilder("PushManager|registerPushIntentService|");
                stringBuilder.append(e.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return;
            } catch (Throwable th) {
                stringBuilder = new StringBuilder("PushManager|registerPushIntentService|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return;
            }
        }
        name = "";
        this.f = name;
        if (this.e != null) {
            Intent intent = new Intent(context.getApplicationContext(), this.e);
            intent.putExtra("uis", this.f);
            context.getApplicationContext().startService(intent);
        }
    }

    public boolean sendFeedbackMessage(Context context, String str, String str2, int i) {
        if (!(str == null || str2 == null || i < PushConsts.MIN_FEEDBACK_ACTION)) {
            if (i <= PushConsts.MAX_FEEDBACK_ACTION) {
                Bundle bundle = new Bundle();
                bundle.putString("action", "sendFeedbackMessage");
                bundle.putString("taskid", str);
                bundle.putString("messageid", str2);
                bundle.putString("actionid", String.valueOf(i));
                a(context, bundle);
                return true;
            }
        }
        return false;
    }

    public boolean sendMessage(Context context, String str, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!(str == null || bArr == null || ((long) bArr.length) > 4096)) {
            if (currentTimeMillis - this.b >= 1000) {
                this.b = currentTimeMillis;
                Bundle bundle = new Bundle();
                bundle.putString("action", "sendMessage");
                bundle.putString("taskid", str);
                bundle.putByteArray("extraData", bArr);
                a(context, bundle);
                return true;
            }
        }
        return false;
    }

    public boolean setHeartbeatInterval(Context context, int i) {
        if (i < 0) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "setHeartbeatInterval");
        bundle.putInt(MsgConstant.KEY_LOCATION_INTERVAL, i);
        a(context, bundle);
        return true;
    }

    public boolean setSilentTime(Context context, int i, int i2) {
        if (i >= 0 && i < 24 && i2 >= 0) {
            if (i2 <= 23) {
                Bundle bundle = new Bundle();
                bundle.putString("action", "setSilentTime");
                bundle.putInt("beginHour", i);
                bundle.putInt(SocializeProtocolConstants.DURATION, i2);
                a(context, bundle);
                return true;
            }
        }
        return false;
    }

    public boolean setSocketTimeout(Context context, int i) {
        if (i < 0) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "setSocketTimeout");
        bundle.putInt(com.alipay.sdk.data.a.f, i);
        a(context, bundle);
        return true;
    }

    public int setTag(Context context, Tag[] tagArr, String str) {
        if (tagArr == null) {
            com.igexin.b.a.c.a.b("PushManager|tags is null");
            return PushConsts.SETTAG_ERROR_NULL;
        } else if (str == null) {
            com.igexin.b.a.c.a.b("PushManager|sn is null");
            return PushConsts.SETTAG_SN_NULL;
        } else if (((long) tagArr.length) > 200) {
            com.igexin.b.a.c.a.b("PushManager|tags len > 200 is exceeds");
            return 20001;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a < 1000) {
                return 20002;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Tag tag : tagArr) {
                if (!(tag == null || tag.getName() == null)) {
                    stringBuilder.append(tag.getName());
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            if (stringBuilder.length() <= 0) {
                return PushConsts.SETTAG_ERROR_NULL;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            Bundle bundle = new Bundle();
            bundle.putString("action", "setTag");
            bundle.putString("tags", stringBuilder.toString());
            bundle.putString("sn", str);
            this.a = currentTimeMillis;
            a(context, bundle);
            return 0;
        }
    }

    public void stopService(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "stopService");
        a(context, bundle);
    }

    public void turnOffPush(Context context) {
        com.igexin.b.a.c.a.b("PushManager|call turnOffPush");
        Bundle bundle = new Bundle();
        bundle.putString("action", "turnOffPush");
        a(context, bundle);
    }

    public void turnOnPush(Context context) {
        com.igexin.b.a.c.a.b("PushManager|call turnOnPush");
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra("action", PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
        intent.putExtra("op_app", context.getApplicationContext().getPackageName());
        intent.putExtra("isSlave", true);
        context.getApplicationContext().startService(intent);
    }

    public boolean unBindAlias(Context context, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("unBindAlias_");
        stringBuilder.append(System.currentTimeMillis());
        return unBindAlias(context, str, z, stringBuilder.toString());
    }

    public boolean unBindAlias(Context context, String str, boolean z, String str2) {
        com.igexin.b.a.c.a.b("PushManager|call unBindAlias");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.c < 5000) {
            return false;
        }
        this.c = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString("action", "unbindAlias");
        bundle.putString("alias", str);
        bundle.putBoolean("isSeft", z);
        bundle.putString("sn", str2);
        a(context, bundle);
        return true;
    }
}
