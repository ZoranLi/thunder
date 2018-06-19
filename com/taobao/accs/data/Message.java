package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.base.TaoBaseService$ExtHeaderType;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.d;
import com.taobao.accs.utl.e$a;
import com.taobao.accs.utl.g;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class Message {
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;
    public static int a = 5;
    static long b = 1;
    String A = null;
    Integer B = null;
    String C = null;
    String D = null;
    public String E = null;
    public String F = null;
    String G = null;
    String H = null;
    String I = null;
    String J = null;
    String K = null;
    byte[] L;
    public String M;
    int N;
    public long O = 0;
    public int P = 0;
    public int Q = com.taobao.accs.net.b.ACCS_RECEIVE_TIMEOUT;
    public long R;
    long S;
    public String T = null;
    transient NetPerformanceMonitor U;
    String V = null;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public URL f;
    byte g = (byte) 0;
    byte h = (byte) 0;
    short i;
    short j;
    short k;
    byte l;
    byte m;
    String n;
    String o;
    int p = -1;
    public String q;
    Map<Integer, String> r;
    String s = null;
    public Integer t = null;
    Integer u = Integer.valueOf(0);
    String v = null;
    public String w = null;
    Integer x = null;
    String y = null;
    String z = null;

    /* compiled from: Taobao */
    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i) {
            switch (i) {
                case 0:
                    return DATA;
                case 1:
                    return ACK;
                case 2:
                    return REQ;
                case 3:
                    return RES;
                default:
                    return DATA;
            }
        }
    }

    /* compiled from: Taobao */
    public static class b {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static int a(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                default:
                    return 0;
            }
        }

        public static String b(int i) {
            switch (i) {
                case 0:
                    return "CONTROL";
                case 1:
                    return "DATA";
                case 2:
                    return "PING";
                case 3:
                    return "HANDSHAKE";
                default:
                    return "INVALID";
            }
        }
    }

    private Message() {
        synchronized (Message.class) {
            long j = b;
            b = j + 1;
            this.q = String.valueOf(j);
        }
        this.R = System.currentTimeMillis();
    }

    public int a() {
        return this.p;
    }

    public String b() {
        return this.q;
    }

    public boolean c() {
        return Constants.TARGET_CONTROL.equals(this.n);
    }

    public int d() {
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
        r0 = r3.c;	 Catch:{ Exception -> 0x0014 }
        if (r0 != 0) goto L_0x000f;	 Catch:{ Exception -> 0x0014 }
    L_0x0004:
        r0 = r3.q;	 Catch:{ Exception -> 0x0014 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0014 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0014 }
        goto L_0x002d;	 Catch:{ Exception -> 0x0014 }
    L_0x000f:
        r0 = b;	 Catch:{ Exception -> 0x0014 }
        r0 = (int) r0;
        r0 = -r0;
        goto L_0x002d;
    L_0x0014:
        r0 = "Msg_";
        r1 = new java.lang.StringBuilder;
        r2 = "parse int dataId error ";
        r1.<init>(r2);
        r2 = r3.q;
        r1.append(r2);
        r1 = r1.toString();
        r2 = 0;
        r2 = new java.lang.Object[r2];
        com.taobao.accs.utl.ALog.w(r0, r1, r2);
        r0 = -1;
    L_0x002d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.Message.d():int");
    }

    public void a(long j) {
        this.S = j;
    }

    public NetPerformanceMonitor e() {
        return this.U;
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder("Msg_");
        stringBuilder.append(this.V);
        return stringBuilder.toString();
    }

    public String f() {
        return this.s == null ? "" : this.s;
    }

    public boolean g() {
        boolean z = (System.currentTimeMillis() - this.R) + this.O >= ((long) this.Q);
        if (z) {
            String j = j();
            StringBuilder stringBuilder = new StringBuilder("delay time:");
            stringBuilder.append(this.O);
            stringBuilder.append(" beforeSendTime:");
            stringBuilder.append(System.currentTimeMillis() - this.R);
            stringBuilder.append(" timeout");
            stringBuilder.append(this.Q);
            ALog.e(j, stringBuilder.toString(), new Object[0]);
        }
        return z;
    }

    public byte[] a(Context context, int i) {
        try {
            i();
        } catch (Throwable e) {
            ALog.e(j(), "build1", e, new Object[0]);
        } catch (Throwable e2) {
            ALog.e(j(), "build2", e2, new Object[0]);
        }
        String str = this.L != null ? new String(this.L) : "";
        h();
        if (!this.c) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(UtilityImpl.getDeviceId(context));
            stringBuilder.append("|");
            stringBuilder.append(this.s);
            stringBuilder.append("|");
            stringBuilder.append(this.F == null ? "" : this.F);
            stringBuilder.append("|");
            stringBuilder.append(this.E == null ? "" : this.E);
            this.o = stringBuilder.toString();
        }
        try {
            context = new StringBuilder();
            context.append(this.q);
            context = context.toString().getBytes("utf-8");
            this.m = (byte) this.o.getBytes("utf-8").length;
            this.l = (byte) this.n.getBytes("utf-8").length;
        } catch (Context context2) {
            context2.printStackTrace();
            ALog.e(j(), "build3", context2, new Object[0]);
            context2 = new StringBuilder();
            context2.append(this.q);
            context2 = context2.toString().getBytes();
            this.m = (byte) this.o.getBytes().length;
            this.l = (byte) this.n.getBytes().length;
        }
        short a = a(this.r);
        this.j = (short) ((((((((3 + this.l) + 1) + this.m) + 1) + context2.length) + (this.L == null ? 0 : this.L.length)) + a) + 2);
        this.i = (short) (this.j + 2);
        g gVar = new g((this.i + 2) + 4);
        ALog.d(j(), "Build Message", new Object[0]);
        try {
            String j;
            StringBuilder stringBuilder2;
            StringBuilder stringBuilder3;
            gVar.a((byte) (32 | this.g));
            if (ALog.isPrintLog(Level.D)) {
                j = j();
                stringBuilder2 = new StringBuilder("\tversion:2 compress:");
                stringBuilder2.append(this.g);
                ALog.d(j, stringBuilder2.toString(), new Object[0]);
            }
            if (i == 0) {
                gVar.a((byte) -128);
                ALog.d(j(), "\tflag: 0x80", new Object[0]);
            } else {
                gVar.a((byte) 64);
                ALog.d(j(), "\tflag: 0x40", new Object[0]);
            }
            gVar.a(this.i);
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\ttotalLength:");
                stringBuilder3.append(this.i);
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.a(this.j);
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\tdataLength:");
                stringBuilder3.append(this.j);
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.a(this.k);
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\tflags:");
                stringBuilder3.append(Integer.toHexString(this.k));
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.a(this.l);
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\ttargetLength:");
                stringBuilder3.append(this.l);
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.write(this.n.getBytes("utf-8"));
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\ttarget:");
                stringBuilder3.append(new String(this.n));
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.a(this.m);
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\tsourceLength:");
                stringBuilder3.append(this.m);
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.write(this.o.getBytes("utf-8"));
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\tsource:");
                stringBuilder3.append(new String(this.o));
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.a((byte) context2.length);
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\tdataIdLength:");
                stringBuilder3.append(context2.length);
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.write(context2);
            if (ALog.isPrintLog(Level.D) != 0) {
                i = j();
                stringBuilder3 = new StringBuilder("\tdataId:");
                stringBuilder3.append(new String(context2));
                ALog.d(i, stringBuilder3.toString(), new Object[0]);
            }
            gVar.a(a);
            if (ALog.isPrintLog(Level.D) != null) {
                context2 = j();
                i = new StringBuilder("\textHeader len:");
                i.append(a);
                ALog.d(context2, i.toString(), new Object[0]);
            }
            if (this.r != null) {
                for (Integer intValue : this.r.keySet()) {
                    i = intValue.intValue();
                    String str2 = (String) this.r.get(Integer.valueOf(i));
                    if (!TextUtils.isEmpty(str2)) {
                        gVar.a((short) ((((short) i) << 10) | ((short) (str2.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN))));
                        gVar.write(str2.getBytes("utf-8"));
                        if (ALog.isPrintLog(Level.D)) {
                            j = j();
                            stringBuilder2 = new StringBuilder("\textHeader key:");
                            stringBuilder2.append(i);
                            stringBuilder2.append(" value:");
                            stringBuilder2.append(str2);
                            ALog.d(j, stringBuilder2.toString(), new Object[0]);
                        }
                    }
                }
            }
            if (this.L != null) {
                gVar.write(this.L);
            }
            if (ALog.isPrintLog(Level.D) != null) {
                context2 = j();
                i = new StringBuilder("\toriData:");
                i.append(str);
                ALog.d(context2, i.toString(), new Object[0]);
            }
            gVar.flush();
        } catch (Context context22) {
            ALog.e(j(), "build4", context22, new Object[0]);
        }
        byte[] toByteArray = gVar.toByteArray();
        a(toByteArray);
        try {
            gVar.close();
        } catch (int i2) {
            ALog.e(j(), "build5", i2, new Object[0]);
        }
        return toByteArray;
    }

    short a(Map<Integer, String> map) {
        short s = (short) 0;
        if (map != null) {
            try {
                for (Integer intValue : map.keySet()) {
                    String str = (String) map.get(Integer.valueOf(intValue.intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        s = (short) (s + (2 + ((short) (str.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN))));
                    }
                }
            } catch (Map<Integer, String> map2) {
                map2.toString();
            }
        }
        return s;
    }

    void h() {
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
        r6 = this;
        r0 = 0;
        r1 = r6.L;	 Catch:{ Throwable -> 0x0042, all -> 0x003d }
        if (r1 != 0) goto L_0x0006;	 Catch:{ Throwable -> 0x0042, all -> 0x003d }
    L_0x0005:
        return;	 Catch:{ Throwable -> 0x0042, all -> 0x003d }
    L_0x0006:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0042, all -> 0x003d }
        r1.<init>();	 Catch:{ Throwable -> 0x0042, all -> 0x003d }
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ Throwable -> 0x0038, all -> 0x0033 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x0038, all -> 0x0033 }
        r0 = r6.L;	 Catch:{ Throwable -> 0x0031 }
        r2.write(r0);	 Catch:{ Throwable -> 0x0031 }
        r2.finish();	 Catch:{ Throwable -> 0x0031 }
        r0 = r1.toByteArray();	 Catch:{ Throwable -> 0x0031 }
        if (r0 == 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0031 }
    L_0x001e:
        r3 = r0.length;	 Catch:{ Throwable -> 0x0031 }
        r4 = r6.L;	 Catch:{ Throwable -> 0x0031 }
        r4 = r4.length;	 Catch:{ Throwable -> 0x0031 }
        if (r3 >= r4) goto L_0x0029;	 Catch:{ Throwable -> 0x0031 }
    L_0x0024:
        r6.L = r0;	 Catch:{ Throwable -> 0x0031 }
        r0 = 1;	 Catch:{ Throwable -> 0x0031 }
        r6.g = r0;	 Catch:{ Throwable -> 0x0031 }
    L_0x0029:
        r2.close();	 Catch:{ Exception -> 0x0030 }
        r1.close();	 Catch:{ Exception -> 0x0030 }
        return;
    L_0x0030:
        return;
    L_0x0031:
        r0 = move-exception;
        goto L_0x0046;
    L_0x0033:
        r2 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x005d;
    L_0x0038:
        r2 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0046;
    L_0x003d:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x005d;
    L_0x0042:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
    L_0x0046:
        r6.j();	 Catch:{ all -> 0x005c }
        r0.toString();	 Catch:{ all -> 0x005c }
        r0.printStackTrace();	 Catch:{ all -> 0x005c }
        if (r2 == 0) goto L_0x0054;
    L_0x0051:
        r2.close();	 Catch:{ Exception -> 0x005a }
    L_0x0054:
        if (r1 == 0) goto L_0x005b;	 Catch:{ Exception -> 0x005a }
    L_0x0056:
        r1.close();	 Catch:{ Exception -> 0x005a }
        goto L_0x005b;
    L_0x005a:
        return;
    L_0x005b:
        return;
    L_0x005c:
        r0 = move-exception;
    L_0x005d:
        if (r2 == 0) goto L_0x0062;
    L_0x005f:
        r2.close();	 Catch:{ Exception -> 0x0067 }
    L_0x0062:
        if (r1 == 0) goto L_0x0067;	 Catch:{ Exception -> 0x0067 }
    L_0x0064:
        r1.close();	 Catch:{ Exception -> 0x0067 }
    L_0x0067:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.Message.h():void");
    }

    void i() throws JSONException, UnsupportedEncodingException {
        if (!(this.t == null || this.t.intValue() == 100 || this.t.intValue() == 102)) {
            if (this.t.intValue() != 105) {
                this.L = new e$a().a("command", this.t.intValue() == 100 ? null : this.t).a("appKey", this.v).a(Constants.KEY_OS_TYPE, this.x).a("sign", this.w).a(Constants.KEY_SDK_VERSION, this.B).a("appVersion", this.A).a(Constants.KEY_TTID, this.C).a(Constants.KEY_MODEL, this.G).a("brand", this.H).a("imei", this.I).a(Constants.KEY_IMSI, this.J).a("os", this.y).a(Constants.KEY_EXTS, this.z).a().toString().getBytes("utf-8");
            }
        }
    }

    void a(byte[] bArr) {
        String str = "";
        if (ALog.isPrintLog(Level.D)) {
            String j = j();
            StringBuilder stringBuilder = new StringBuilder("len:");
            stringBuilder.append(bArr.length);
            ALog.d(j, stringBuilder.toString(), new Object[0]);
            if (bArr.length < 512) {
                j = str;
                for (byte b : bArr) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(j);
                    stringBuilder.append(Integer.toHexString(b & 255));
                    stringBuilder.append(" ");
                    j = stringBuilder.toString();
                }
                ALog.d(j(), j, new Object[0]);
            }
        }
    }

    public static Message a(boolean z, int i) {
        Message message = new Message();
        message.p = 2;
        message.t = Integer.valueOf(201);
        message.d = z;
        message.O = (long) i;
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            intent.getStringExtra(Constants.KEY_USER_ID);
            String stringExtra2 = intent.getStringExtra("appKey");
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            String stringExtra4 = intent.getStringExtra("appVersion");
            Context context2 = context;
            context = a(context2, bVar.m, stringExtra2, intent.getStringExtra("app_sercet"), stringExtra, stringExtra3, stringExtra4);
            try {
                a(bVar, (Message) context);
            } catch (Exception e) {
                bVar = e;
                ALog.e("Msg_", "buildBindApp", bVar, new Object[0]);
                bVar.printStackTrace();
                return context;
            }
        } catch (Exception e2) {
            bVar = e2;
            context = null;
            ALog.e("Msg_", "buildBindApp", bVar, new Object[0]);
            bVar.printStackTrace();
            return context;
        }
        return context;
    }

    public static Message a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        String str7 = null;
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        try {
            message.N = 1;
            message.a(1, ReqType.DATA, 1);
            message.x = Integer.valueOf(1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(VERSION.SDK_INT);
            message.y = stringBuilder.toString();
            message.s = str4;
            message.n = Constants.TARGET_CONTROL;
            message.t = Integer.valueOf(1);
            message.v = str2;
            message.w = UtilityImpl.getAppsign(context, str2, str3, UtilityImpl.getDeviceId(context), str);
            message.B = Integer.valueOf(221);
            message.A = str6;
            message.s = str4;
            message.C = str5;
            message.G = Build.MODEL;
            message.H = Build.BRAND;
            message.M = KEY_BINDAPP;
            message.V = str;
            message.z = new e$a().a("notifyEnable", UtilityImpl.isNotificationEnabled(context)).a("romInfo", new d().a()).a().toString();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            message.I = telephonyManager != null ? telephonyManager.getDeviceId() : null;
            if (telephonyManager != null) {
                str7 = telephonyManager.getSubscriberId();
            }
            message.J = str7;
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return message;
    }

    public static Message b(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        StringBuilder stringBuilder = new StringBuilder("buildUnbindApp1");
        stringBuilder.append(UtilityImpl.getStackMsg(new Exception()));
        ALog.e("Msg_", stringBuilder.toString(), new Object[0]);
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            intent = a(bVar, stringExtra);
            try {
                a(bVar, (Message) intent);
            } catch (Exception e) {
                bVar = e;
                ALog.e("Msg_", "buildUnbindApp1", bVar, new Object[0]);
                bVar.printStackTrace();
                return intent;
            }
        } catch (Exception e2) {
            bVar = e2;
            intent = null;
            ALog.e("Msg_", "buildUnbindApp1", bVar, new Object[0]);
            bVar.printStackTrace();
            return intent;
        }
        return intent;
    }

    public static Message a(com.taobao.accs.net.b bVar, String str) {
        Message message;
        try {
            StringBuilder stringBuilder = new StringBuilder("buildUnbindApp");
            stringBuilder.append(UtilityImpl.getStackMsg(new Exception()));
            ALog.e("Msg_", stringBuilder.toString(), new Object[0]);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            message = new Message();
            try {
                message.N = 1;
                message.a(1, ReqType.DATA, 1);
                message.s = str;
                message.n = Constants.TARGET_CONTROL;
                message.t = Integer.valueOf(2);
                message.s = str;
                message.B = Integer.valueOf(221);
                message.M = KEY_UNBINDAPP;
                a(bVar, message);
            } catch (Exception e) {
                bVar = e;
                ALog.e("Msg_", "buildUnbindApp", bVar, new Object[0]);
                bVar.printStackTrace();
                return message;
            }
            return message;
        } catch (Exception e2) {
            bVar = e2;
            message = null;
            ALog.e("Msg_", "buildUnbindApp", bVar, new Object[0]);
            bVar.printStackTrace();
            return message;
        }
    }

    public static Message a(com.taobao.accs.net.b bVar, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra("appKey");
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            intent = a(stringExtra, stringExtra2);
            try {
                intent.V = bVar.m;
                a(bVar, (Message) intent);
            } catch (Exception e) {
                bVar = e;
                ALog.e("Msg_", "buildBindService", bVar, new Object[0]);
                bVar.printStackTrace();
                return intent;
            }
        } catch (Exception e2) {
            bVar = e2;
            intent = null;
            ALog.e("Msg_", "buildBindService", bVar, new Object[0]);
            bVar.printStackTrace();
            return intent;
        }
        return intent;
    }

    public static Message a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                Message message = new Message();
                message.N = 1;
                message.a(1, ReqType.DATA, 1);
                message.s = str;
                message.F = str2;
                message.n = Constants.TARGET_CONTROL;
                message.t = Integer.valueOf(5);
                message.s = str;
                message.F = str2;
                message.B = Integer.valueOf(221);
                message.M = KEY_BINDSERVICE;
                return message;
            }
        }
        return null;
    }

    public static Message b(com.taobao.accs.net.b bVar, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra("appKey");
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            intent = b(stringExtra, stringExtra2);
            try {
                intent.V = bVar.m;
                a(bVar, (Message) intent);
            } catch (Exception e) {
                bVar = e;
                ALog.e("Msg_", "buildUnbindService", bVar, new Object[0]);
                bVar.printStackTrace();
                return intent;
            }
        } catch (Exception e2) {
            bVar = e2;
            intent = null;
            ALog.e("Msg_", "buildUnbindService", bVar, new Object[0]);
            bVar.printStackTrace();
            return intent;
        }
        return intent;
    }

    public static Message b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                Message message = new Message();
                message.N = 1;
                message.a(1, ReqType.DATA, 1);
                message.s = str;
                message.F = str2;
                message.n = Constants.TARGET_CONTROL;
                message.t = Integer.valueOf(6);
                message.s = str;
                message.F = str2;
                message.B = Integer.valueOf(221);
                message.M = KEY_UNBINDSERVICE;
                return message;
            }
        }
        return null;
    }

    public static Message c(com.taobao.accs.net.b bVar, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra("appKey");
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            intent = c(stringExtra, stringExtra2);
            try {
                intent.V = bVar.m;
                a(bVar, (Message) intent);
            } catch (Exception e) {
                bVar = e;
                ALog.e("Msg_", "buildBindUser", bVar, new Object[0]);
                bVar.printStackTrace();
                return intent;
            }
        } catch (Exception e2) {
            bVar = e2;
            intent = null;
            ALog.e("Msg_", "buildBindUser", bVar, new Object[0]);
            bVar.printStackTrace();
            return intent;
        }
        return intent;
    }

    public static Message c(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                Message message = new Message();
                message.N = 1;
                message.a(1, ReqType.DATA, 1);
                message.s = str;
                message.E = str2;
                message.n = Constants.TARGET_CONTROL;
                message.t = Integer.valueOf(3);
                message.s = str;
                message.E = str2;
                message.B = Integer.valueOf(221);
                message.M = KEY_BINDUSER;
                return message;
            }
        }
        return null;
    }

    public static Message d(com.taobao.accs.net.b bVar, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra("appKey");
            intent.getStringExtra("sid");
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            intent = a(stringExtra);
            try {
                intent.V = bVar.m;
                a(bVar, (Message) intent);
            } catch (Exception e) {
                bVar = e;
                ALog.e("Msg_", "buildUnbindUser", bVar, new Object[0]);
                bVar.printStackTrace();
                return intent;
            }
        } catch (Exception e2) {
            bVar = e2;
            intent = null;
            ALog.e("Msg_", "buildUnbindUser", bVar, new Object[0]);
            bVar.printStackTrace();
            return intent;
        }
        return intent;
    }

    public static Message a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.N = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.n = Constants.TARGET_CONTROL;
        message.t = Integer.valueOf(4);
        message.B = Integer.valueOf(221);
        message.M = KEY_UNBINDUSER;
        return message;
    }

    public static Message a(String str, Map<String, Integer> map) {
        if (map == null) {
            return null;
        }
        Message message = new Message();
        try {
            message.a(1, ReqType.DATA, 1);
            message.N = 1;
            message.s = str;
            message.n = Constants.TARGET_ELECTION;
            message.t = Integer.valueOf(105);
            JSONArray jSONArray = new JSONArray();
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.KEY_ELECTION_PKG, entry.getKey());
                jSONObject.put("sdkv", entry.getValue());
                jSONArray.put(jSONObject);
            }
            message.L = new e$a().a("sdkv", Integer.valueOf(221)).a(Constants.KEY_ELECTION_PACKS, jSONArray).a().toString().getBytes("utf-8");
        } catch (String str2) {
            ALog.e("Msg_", "buildElection", str2, new Object[0]);
        }
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, String str, AccsRequest accsRequest) {
        return a(bVar, context, str, accsRequest, true);
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, String str, AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.N = 1;
        message.a(1, ReqType.DATA, 1);
        message.t = Integer.valueOf(100);
        message.s = str;
        message.F = accsRequest.serviceId;
        message.E = accsRequest.userId;
        message.L = accsRequest.data;
        str = TextUtils.isEmpty(accsRequest.targetServiceName) != null ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder stringBuilder = new StringBuilder(Constants.TARGET_SERVICE_PRE);
        stringBuilder.append(str);
        stringBuilder.append("|");
        stringBuilder.append(accsRequest.target == null ? "" : accsRequest.target);
        message.n = stringBuilder.toString();
        message.M = accsRequest.dataId;
        message.T = accsRequest.businessId;
        if (accsRequest.timeout > null) {
            message.Q = accsRequest.timeout;
        }
        if (z) {
            a(bVar, message, accsRequest);
        } else {
            message.f = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(bVar.m), GlobalClientInfo.getInstance(context).getUserId(bVar.m), GlobalClientInfo.c, accsRequest.businessId, accsRequest.tag);
        message.U = new NetPerformanceMonitor();
        message.U.setDataId(accsRequest.dataId);
        message.U.setServiceId(accsRequest.serviceId);
        message.U.setHost(message.f.toString());
        message.V = bVar.m;
        return message;
    }

    public static Message b(com.taobao.accs.net.b bVar, Context context, String str, AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.N = 1;
        message.a(1, ReqType.REQ, 1);
        message.t = Integer.valueOf(100);
        message.s = str;
        message.F = accsRequest.serviceId;
        message.E = accsRequest.userId;
        message.L = accsRequest.data;
        str = TextUtils.isEmpty(accsRequest.targetServiceName) != null ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder stringBuilder = new StringBuilder(Constants.TARGET_SERVICE_PRE);
        stringBuilder.append(str);
        stringBuilder.append("|");
        stringBuilder.append(accsRequest.target == null ? "" : accsRequest.target);
        message.n = stringBuilder.toString();
        message.M = accsRequest.dataId;
        message.T = accsRequest.businessId;
        message.V = bVar.m;
        if (accsRequest.timeout > null) {
            message.Q = accsRequest.timeout;
        }
        if (z) {
            a(bVar, message, accsRequest);
        } else {
            message.f = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(bVar.m), GlobalClientInfo.getInstance(context).getUserId(bVar.m), GlobalClientInfo.c, accsRequest.businessId, accsRequest.tag);
        message.U = new NetPerformanceMonitor();
        message.U.setDataId(accsRequest.dataId);
        message.U.setServiceId(accsRequest.serviceId);
        message.U.setHost(message.f.toString());
        message.V = bVar.m;
        return message;
    }

    private static void a(com.taobao.accs.net.b bVar, Message message, AccsRequest accsRequest) {
        if (accsRequest.host == null) {
            try {
                message.f = new URL(bVar.b(null));
                return;
            } catch (com.taobao.accs.net.b bVar2) {
                ALog.e("Msg_", "setUnit", bVar2, new Object[0]);
                bVar2.printStackTrace();
                return;
            }
        }
        message.f = accsRequest.host;
    }

    private static void a(com.taobao.accs.net.b bVar, Message message) {
        try {
            message.f = new URL(bVar.b(null));
        } catch (com.taobao.accs.net.b bVar2) {
            ALog.e("Msg_", "setControlHost", bVar2, new Object[0]);
        }
    }

    public static Message a(com.taobao.accs.net.b bVar, String str, String str2, String str3, boolean z, short s, String str4, Map<Integer, String> map) {
        Message message = new Message();
        message.N = 1;
        message.a(s, z);
        message.o = str;
        message.n = str2;
        message.q = str3;
        message.c = true;
        message.r = map;
        try {
            if (TextUtils.isEmpty(str4) != null) {
                GlobalClientInfo.getContext();
                message.f = new URL(bVar.b(null));
            } else {
                message.f = new URL(str4);
            }
            message.V = bVar.m;
            if (message.f == null) {
                try {
                    GlobalClientInfo.getContext();
                    message.f = new URL(bVar.b(null));
                } catch (com.taobao.accs.net.b bVar2) {
                    bVar2.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (message.f == null) {
                try {
                    GlobalClientInfo.getContext();
                    message.f = new URL(bVar2.b(null));
                } catch (com.taobao.accs.net.b bVar22) {
                    bVar22.printStackTrace();
                }
            }
        }
        return message;
    }

    public static Message a(String str, int i) {
        Message message = new Message();
        message.a(1, ReqType.ACK, 0);
        message.t = Integer.valueOf(i);
        message.s = str;
        return message;
    }

    private static void a(Message message, String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str5) || str3 != null) {
            message.r = new HashMap();
            if (str4 != null && UtilityImpl.getByteLen(str4) <= EXT_HEADER_VALUE_MAX_LEN) {
                message.r.put(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_BUSINESS.ordinal()), str4);
            }
            if (str != null && UtilityImpl.getByteLen(str) <= 1023) {
                message.r.put(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_SID.ordinal()), str);
            }
            if (str2 != null && UtilityImpl.getByteLen(str2) <= 1023) {
                message.r.put(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_USERID.ordinal()), str2);
            }
            if (str5 != null && UtilityImpl.getByteLen(str5) <= 1023) {
                message.r.put(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_TAG.ordinal()), str5);
            }
            if (str3 != null && UtilityImpl.getByteLen(str3) <= 1023) {
                message.r.put(Integer.valueOf(TaoBaseService$ExtHeaderType.TYPE_COOKIE.ordinal()), str3);
            }
        }
    }

    private void a(int i, ReqType reqType, int i2) {
        this.p = i;
        if (i != 2) {
            this.k = (short) (((((i & 1) << 4) | (reqType.ordinal() << 2)) | i2) << 11);
        }
    }

    private void a(short s, boolean z) {
        this.p = 1;
        this.k = s;
        this.k = (short) (this.k & -16385);
        this.k = (short) (this.k | 8192);
        this.k = (short) (this.k & -2049);
        this.k = (short) (this.k & -65);
        if (z) {
            this.k = (short) (this.k | 32);
        }
    }
}
