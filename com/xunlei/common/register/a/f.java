package com.xunlei.common.register.a;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLPhoneInfo;
import com.xunlei.common.base.permission.XLAndroidPermission;
import com.xunlei.common.base.permission.XLAndroidPermissionListener;
import com.xunlei.common.base.permission.XLAndroidPermissionOptions.Builder;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.register.XLRegisterListener;
import com.xunlei.common.register.b.a;
import com.xunlei.common.register.b.b;
import com.xunlei.common.register.b.c;
import com.xunlei.common.register.b.d;
import com.xunlei.common.register.b.e;
import com.xunlei.common.register.b.g;
import com.xunlei.common.register.b.h;
import com.xunlei.common.register.b.i;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.base.XLStatCommandID;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.common.AgooConstants;

/* compiled from: XLRegisterUtilProxy */
public final class f {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 4;
    private static int f = 5;
    private static int g = 6;
    private static int h = 7;
    private static int i = 8;
    private static int j = 9;
    private static int k = 268439588;
    private static f l;
    private String A;
    private String B;
    private ContentObserver C = new ContentObserver(this, this.o) {
        private /* synthetic */ f a;

        public final void onChange(boolean z) {
            super.onChange(z);
            this.a.o.sendEmptyMessage(268439588);
        }
    };
    private List<XLRegisterListener> m = new Vector();
    private Context n = null;
    private Handler o = null;
    private int p = -1;
    private boolean q = false;
    private String r = "2.7.2.178225";
    private String s = "1";
    private String t = "ABCDEF";
    private int u = 0;
    private Activity v = null;
    private boolean w = false;
    private XLStatUtil x = null;
    private g y = null;
    private boolean z = true;

    public static String f() {
        return "3.1";
    }

    private f() {
    }

    private static String m() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            XLLog.e("WifiPreference IpAddress", e.toString());
        }
        return null;
    }

    private InetAddress n() throws UnknownHostException {
        int ipAddress = ((WifiManager) this.n.getSystemService("wifi")).getConnectionInfo().getIpAddress();
        return InetAddress.getByName(String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf(ipAddress >>> 24)}));
    }

    public final void a(int i, Object... objArr) {
        this.o.obtainMessage(i, objArr).sendToTarget();
    }

    private void a(Message message) {
        f fVar = this;
        Message message2 = message;
        int i = message2.what;
        Object[] objArr = (Object[]) message2.obj;
        if (i == 0) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onPhoneRegister(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
            }
        } else if (i == 2) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onCheckBind(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        } else if (i == 3) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onSendMessage(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), (String) objArr[4]);
            }
        } else if (i == 4) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onCheckNeedVerifyCode(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), (String) objArr[4]);
            }
        } else if (i == 5) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onGetVerifyCode(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), (byte[]) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7]);
            }
        } else if (i == 1) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onEmailRegister(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
            }
        } else if (i == 7) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onCheckPassWordStrength(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        } else if (i == 8) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onPhoneRegAndLogin(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
            }
        } else if (i == 9) {
            for (i = fVar.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar.m.get(i)).onOldUserNameRegister(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
            }
        } else {
            if (i == 268439588) {
                if (fVar.z) {
                    XLAndroidPermission.getInstance(fVar.n).request(new Builder().setPermissions(new String[]{"android.permission.READ_SMS"}).build(), new XLAndroidPermissionListener(fVar) {
                        private /* synthetic */ f a;

                        {
                            this.a = r1;
                        }

                        public final void onGranted() {
                            this.a.r();
                        }

                        public final void onDenied(List<String> list) {
                            XLLog.v("XLRegisterUtilProxy", "user deny read sms permission!");
                        }
                    });
                } else if (ContextCompat.checkSelfPermission(fVar.n, "android.permission.READ_SMS") == 0) {
                    r();
                }
            }
        }
    }

    public static f a() {
        if (l != null) {
            return l;
        }
        synchronized (f.class) {
            if (l == null) {
                l = new f();
            }
        }
        return l;
    }

    public final boolean a(Context context, int i, String str, String str2, String str3, boolean z) {
        if (this.q || Looper.myLooper() == null) {
            return null;
        }
        this.q = true;
        this.z = z;
        this.o = new Handler(this) {
            private /* synthetic */ f a;

            {
                this.a = r1;
            }

            public final void handleMessage(Message message) {
                f.a(this.a, message);
            }
        };
        d.a().a(context);
        this.n = context;
        this.p = i;
        this.s = str;
        this.t = str2;
        this.u = u();
        try {
            XLDeviceGen.getInstance().initialize(this.p, str3, this.r, context);
        } catch (Context context2) {
            context2.printStackTrace();
            str = new StringBuilder("XLDeviceGen initialize error = ");
            str.append(context2.getMessage());
            XLLog.v("RegisterUtilProxy", str.toString());
        }
        if (this.w == null) {
            this.n.getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, this.C);
            this.w = true;
        }
        this.x = XLStatUtil.getInstance();
        this.x.init(this.n, this.p, this.s, this.r, this.t);
        this.x.setRegisterFrom("android-sdk");
        this.y = new g(this.x);
        a(this.y);
        return true;
    }

    private void o() {
        this.s = this.r;
        this.t = "ABCDEF";
    }

    public final boolean b() {
        b(this.y);
        d.a();
        this.x.uninit();
        return true;
    }

    public final void a(XLRegisterListener xLRegisterListener) {
        if (this.q && !this.m.contains(xLRegisterListener)) {
            this.m.add(xLRegisterListener);
        }
    }

    public final void b(XLRegisterListener xLRegisterListener) {
        if (this.q && this.m.contains(xLRegisterListener)) {
            this.m.remove(xLRegisterListener);
        }
    }

    private void p() {
        if (this.q) {
            this.m.clear();
        }
    }

    public final Context c() {
        return this.n;
    }

    public final int d() {
        return this.p;
    }

    public final String e() {
        return this.r;
    }

    public final String g() {
        return this.s;
    }

    private boolean q() {
        return this.z;
    }

    public final String h() {
        return this.n.getApplicationInfo().packageName;
    }

    private void r() {
        String str;
        Activity activity = this.v;
        String str2 = "";
        if (activity != null) {
            int i = 2;
            Cursor managedQuery = activity.managedQuery(Uri.parse("content://sms/inbox"), new String[]{"address", AgooConstants.MESSAGE_BODY}, "read=0", new String[0], "date desc");
            if (managedQuery != null && managedQuery.getCount() > 0) {
                managedQuery.moveToFirst();
                Object string = managedQuery.getString(managedQuery.getColumnIndex(AgooConstants.MESSAGE_BODY));
                if (string.indexOf("迅雷网络") != -1) {
                    str = "";
                    Matcher matcher = Pattern.compile("\\d{6}").matcher(string);
                    if (matcher.find()) {
                        str = matcher.group();
                    }
                    if (string.indexOf("注册") != -1) {
                        i = 1;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append(str);
                    str2 = stringBuilder.toString();
                }
            }
        }
        if (str2 != null && str2 != "") {
            String substring = str2.substring(0, 1);
            str = str2.substring(1);
            for (int size = this.m.size() - 1; size >= 0; size--) {
                ((XLRegisterListener) this.m.get(size)).onMobileVerifyCodeAccept(str, Integer.valueOf(substring).intValue());
            }
            this.v = null;
        }
    }

    private void s() {
        if (!this.w) {
            this.n.getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, this.C);
            this.w = true;
        }
    }

    private void t() {
        if (this.w) {
            this.n.getContentResolver().unregisterContentObserver(this.C);
            this.w = false;
        }
    }

    private static String c(String str) {
        String str2 = "";
        str = Pattern.compile("\\d{6}").matcher(str);
        return str.find() ? str.group() : str2;
    }

    private int u() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.r;
        r1 = ".";
        r0 = r0.lastIndexOf(r1);
        r1 = -1;
        if (r0 == r1) goto L_0x001c;
    L_0x000b:
        r1 = r2.r;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x001c }
        r0 = r0.intValue();	 Catch:{ NumberFormatException -> 0x001c }
        goto L_0x001d;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.register.a.f.u():int");
    }

    private String a(Activity activity) {
        String str = "";
        if (activity == null) {
            return str;
        }
        int i = 2;
        activity = activity.managedQuery(Uri.parse("content://sms/inbox"), new String[]{"address", AgooConstants.MESSAGE_BODY}, "read=0", new String[0], "date desc");
        if (activity == null || activity.getCount() <= 0) {
            return str;
        }
        activity.moveToFirst();
        activity = activity.getString(activity.getColumnIndex(AgooConstants.MESSAGE_BODY));
        if (activity.indexOf("迅雷网络") == -1) {
            return str;
        }
        str = "";
        Matcher matcher = Pattern.compile("\\d{6}").matcher(activity);
        if (matcher.find()) {
            str = matcher.group();
        }
        if (activity.indexOf("注册") != -1) {
            i = 1;
        }
        activity = new StringBuilder();
        activity.append(i);
        activity.append(str);
        return activity.toString();
    }

    private boolean v() {
        return this.v != null;
    }

    public final int i() {
        return this.u;
    }

    private String w() {
        String str = "NONE";
        switch (XLPhoneInfo.getNetworkType(this.n)) {
            case 0:
                return "NONE";
            case 1:
                return "WIFI";
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "2G";
            default:
                return str;
        }
    }

    private String x() {
        int providersName = XLPhoneInfo.getProvidersName(this.n);
        String str = "NONE";
        if (providersName == 0) {
            return "CMCC";
        }
        switch (providersName) {
            case 2:
                return "CUCC";
            case 3:
                return "CTC";
            case 4:
                return "OTHER";
            case 5:
                return "NONE";
            default:
                return str;
        }
    }

    public final int a(String str, int i) {
        if (!this.q) {
            return -1;
        }
        a aVar = new a(this);
        aVar.d(str);
        aVar.a(i);
        aVar.d();
        return aVar.a();
    }

    public final int a(String str, int i, Activity activity, String str2, String str3, String str4, boolean z) {
        if (!this.q) {
            return -1;
        }
        this.v = activity;
        activity = new i(this);
        activity.a(str2, str3, str4);
        activity.a(i);
        activity.d(str);
        activity.b(true);
        activity.d();
        this.x.registerStatReq(activity.a());
        this.x.registerSpecialStatReq(activity.a(), i);
        return activity.a();
    }

    public final int a(String str, String str2, String str3) {
        if (this.q == null) {
            return -1;
        }
        str3 = new h(this);
        str3.e(str2);
        str3.d(str);
        str3.a(0);
        str3.d();
        this.x.registerStatReq(str3.a());
        str2 = new XLStatPack();
        str2.mCommandID = XLStatCommandID.XLCID_PHONE_CODE_REQTVER;
        if (XLStatUtil.mAcceptPhoneCode) {
            str2.mCommandID = XLStatCommandID.XLCID_PHONE_CODE_ACPTTVER;
            XLStatUtil.mAcceptPhoneCode = false;
        }
        str2.mErrorCode = 0;
        str2.mSvrDomain = "zhuce.xunlei.com";
        this.x.reportSpecialStat(2, str2);
        this.x.registerSpecialStatReq(str3.a(), 2);
        return str3.a();
    }

    public final int a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.q == null) {
            return -1;
        }
        str6 = new d(this);
        str6.d(str);
        str6.e(str2);
        str6.g(str3);
        str6.h(str4);
        str6.i(str5);
        try {
            str6.a(n().getHostAddress());
        } catch (String str8) {
            str8.printStackTrace();
        }
        str6.d();
        this.x.registerStatReq(str6.a());
        return str6.a();
    }

    public final int a(String str, String str2, String str3, String str4) {
        if (this.q == null) {
            return -1;
        }
        str4 = new g(this);
        str4.a(str, str2, str3);
        try {
            str4.a(n().getHostAddress());
        } catch (String str5) {
            str5.printStackTrace();
        }
        str4.d();
        this.x.registerStatReq(str4.a());
        str5 = new XLStatPack();
        str5.mCommandID = XLStatCommandID.XLCID_PHONE_CODE_REQTVER;
        if (XLStatUtil.mAcceptPhoneCode != null) {
            str5.mCommandID = XLStatCommandID.XLCID_PHONE_CODE_ACPTTVER;
            XLStatUtil.mAcceptPhoneCode = false;
        }
        str5.mErrorCode = 0;
        str5.mSvrDomain = "zhuce.xunlei.com";
        this.x.reportSpecialStat(1, str5);
        this.x.registerSpecialStatReq(str4.a(), 1);
        return str4.a();
    }

    public final int b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.q == null) {
            return -1;
        }
        str6 = new com.xunlei.common.register.b.f(this);
        str6.a(str, str2, str3, str4, str5);
        try {
            str6.a(n().getHostAddress());
        } catch (String str8) {
            str8.printStackTrace();
        }
        str6.d();
        this.x.registerStatReq(str6.a());
        return str6.a();
    }

    public final int l() {
        if (!this.q) {
            return -1;
        }
        b bVar = new b(this);
        try {
            bVar.a(n().getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
        bVar.d();
        return bVar.a();
    }

    public final int a(String str) {
        if (!this.q) {
            return -1;
        }
        e eVar = new e(this);
        eVar.d(str);
        eVar.d();
        this.x.registerStatReq(eVar.a());
        return eVar.a();
    }

    public final int b(String str) {
        if (!this.q) {
            return -1;
        }
        c cVar = new c(this);
        cVar.d(str);
        cVar.d();
        return cVar.a();
    }

    public final String j() {
        String str = "NONE";
        switch (XLPhoneInfo.getNetworkType(this.n)) {
            case 0:
                str = "NONE";
                break;
            case 1:
                str = "WIFI";
                break;
            case 2:
                str = "2G";
                break;
            case 3:
                str = "3G";
                break;
            case 4:
                str = "4G";
                break;
            case 5:
                str = "2G";
                break;
            default:
                break;
        }
        this.A = str;
        return this.A;
    }

    public final String k() {
        int providersName = XLPhoneInfo.getProvidersName(this.n);
        String str = "NONE";
        if (providersName != 0) {
            switch (providersName) {
                case 2:
                    str = "CUCC";
                    break;
                case 3:
                    str = "CTC";
                    break;
                case 4:
                    str = "OTHER";
                    break;
                case 5:
                    str = "NONE";
                    break;
                default:
                    break;
            }
        }
        str = "CMCC";
        this.B = str;
        return this.B;
    }

    static /* synthetic */ void a(f fVar, Message message) {
        f fVar2 = fVar;
        Message message2 = message;
        int i = message2.what;
        Object[] objArr = (Object[]) message2.obj;
        if (i == 0) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onPhoneRegister(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
            }
        } else if (i == 2) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onCheckBind(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        } else if (i == 3) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onSendMessage(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), (String) objArr[4]);
            }
        } else if (i == 4) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onCheckNeedVerifyCode(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), (String) objArr[4]);
            }
        } else if (i == 5) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onGetVerifyCode(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), (byte[]) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7]);
            }
        } else if (i == 1) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onEmailRegister(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
            }
        } else if (i == 7) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onCheckPassWordStrength(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        } else if (i == 8) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onPhoneRegAndLogin(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
            }
        } else if (i == 9) {
            for (i = fVar2.m.size() - 1; i >= 0; i--) {
                ((XLRegisterListener) fVar2.m.get(i)).onOldUserNameRegister(((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (String) objArr[4]);
            }
        } else {
            if (i == 268439588) {
                if (fVar2.z) {
                    XLAndroidPermission.getInstance(fVar2.n).request(new Builder().setPermissions(new String[]{"android.permission.READ_SMS"}).build(), /* anonymous class already generated */);
                } else if (ContextCompat.checkSelfPermission(fVar2.n, "android.permission.READ_SMS") == 0) {
                    fVar.r();
                }
            }
        }
    }
}
