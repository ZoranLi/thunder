package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.xunlei.common.androidutil.notification.NotificationManagerWrapper;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.util.i;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui.RedEnvelopesActivity;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.xllib.b.d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: VoucherPacketHelper */
public class f {
    private static f q;
    public Editor a = this.r.edit();
    public boolean b = false;
    public RedPacketConditionsInfo c;
    public long d = 0;
    public boolean e = false;
    public ArrayList<a> f;
    public long g = 0;
    public long h = 0;
    String i = "";
    String j = "";
    String k = "";
    String l = "";
    public Handler m = new Handler();
    public i n;
    public a o;
    public long p;
    private SharedPreferences r = BrothersApplication.getApplicationInstance().getSharedPreferences("voucher:record_sp", 0);
    private int s = 0;
    private String t = "";

    /* compiled from: VoucherPacketHelper */
    public interface a {
        void a();
    }

    static /* synthetic */ boolean a(int i) {
        if (!(i == 11 || i == 12)) {
            if (i != 13) {
                return false;
            }
        }
        return true;
    }

    public static f a() {
        if (q == null) {
            synchronized (f.class) {
                if (q == null) {
                    q = new f();
                }
            }
        }
        return q;
    }

    private f() {
        LoginHelper.a().a(new g(this));
        LoginHelper.a().a(new h(this));
        XLThreadPool.execute(new i(this));
    }

    public static String b() {
        StringBuilder stringBuilder = new StringBuilder("get_state");
        stringBuilder.append(LoginHelper.a().g.c());
        return stringBuilder.toString();
    }

    private static String u() {
        StringBuilder stringBuilder = new StringBuilder("record_time");
        stringBuilder.append(LoginHelper.a().g.c());
        return stringBuilder.toString();
    }

    public final boolean a(long r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = com.xunlei.downloadprovider.d.d.a();
        r0 = r0.l;
        r0 = r0.a();
        r1 = 0;
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = new java.lang.StringBuilder;
        r2 = "[isCanShow] mLastTaskId=";
        r0.<init>(r2);
        r2 = r4.g;
        r0.append(r2);
        r2 = " ,taskId=";
        r0.append(r2);
        r0.append(r5);
        r2 = r4.g;
        r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r5 = r4.b;
        if (r5 != 0) goto L_0x0077;
    L_0x002d:
        r5 = r4.r;
        r6 = b();
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x0045;
    L_0x0039:
        r5 = r4.r;
        r6 = b();
        r5 = r5.getBoolean(r6, r1);
        r4.b = r5;
    L_0x0045:
        r5 = r4.b;	 Catch:{ Exception -> 0x0077 }
        if (r5 != 0) goto L_0x0077;	 Catch:{ Exception -> 0x0077 }
    L_0x0049:
        r5 = t();	 Catch:{ Exception -> 0x0077 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0077 }
        if (r5 != 0) goto L_0x0068;	 Catch:{ Exception -> 0x0077 }
    L_0x0053:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0077 }
        r6 = t();	 Catch:{ Exception -> 0x0077 }
        r0 = b();	 Catch:{ Exception -> 0x0077 }
        r5.<init>(r6, r0);	 Catch:{ Exception -> 0x0077 }
        r5 = r5.exists();	 Catch:{ Exception -> 0x0077 }
        if (r5 == 0) goto L_0x0068;	 Catch:{ Exception -> 0x0077 }
    L_0x0066:
        r5 = 1;	 Catch:{ Exception -> 0x0077 }
        goto L_0x0069;	 Catch:{ Exception -> 0x0077 }
    L_0x0068:
        r5 = r1;	 Catch:{ Exception -> 0x0077 }
    L_0x0069:
        r4.b = r5;	 Catch:{ Exception -> 0x0077 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0077 }
        r6 = "[isCanShow] sdcard hasGet=";	 Catch:{ Exception -> 0x0077 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0077 }
        r6 = r4.b;	 Catch:{ Exception -> 0x0077 }
        r5.append(r6);	 Catch:{ Exception -> 0x0077 }
    L_0x0077:
        r5 = r4.r;
        r6 = u();
        r0 = "";
        r5 = r5.getString(r6, r0);
        r6 = new java.lang.StringBuilder;
        r0 = "[isCanShow] isNewUser=";
        r6.<init>(r0);
        r0 = v();
        r6.append(r0);
        r0 = " ,recordTime=";
        r6.append(r0);
        r6.append(r5);
        r0 = " ,hasGet=";
        r6.append(r0);
        r0 = r4.b;
        r6.append(r0);
        r6 = r4.b;
        if (r6 == 0) goto L_0x00a8;
    L_0x00a7:
        return r1;
    L_0x00a8:
        r6 = v();
        if (r6 != 0) goto L_0x00af;
    L_0x00ae:
        return r1;
    L_0x00af:
        r6 = r4.c();
        if (r6 != 0) goto L_0x00b6;
    L_0x00b5:
        return r1;
    L_0x00b6:
        r5 = b(r5);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a(long):boolean");
    }

    public final RedPacketConditionsInfo c() {
        if (this.c == null) {
            new StringBuilder("[getMatchVoucherRedpacketInfo] isNewUser=").append(v());
            BannerManager.a();
            List<RedPacketConditionsInfo> d = BannerManager.d();
            if (!d.a(d)) {
                new StringBuilder("[getMatchVoucherRedpacketInfo] redPacketConditionsInfoList size=").append(d.size());
                if (v()) {
                    for (RedPacketConditionsInfo redPacketConditionsInfo : d) {
                        if (TextUtils.equals(redPacketConditionsInfo.user_type, "7")) {
                            break;
                        }
                    }
                }
            }
            RedPacketConditionsInfo redPacketConditionsInfo2 = null;
            this.c = redPacketConditionsInfo2;
        }
        return this.c;
    }

    private void w() {
        NotificationManagerWrapper.getInstance(BrothersApplication.getApplicationInstance()).cancelNotification(256);
        this.s = 0;
    }

    public final void d() {
        SharedPreferences sharedPreferences = this.r;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("key:get_voucher_packet_list");
        XLThreadPool.execute(new o(this, sharedPreferences.getString(stringBuilder.toString(), "")));
    }

    public final void a(a aVar) {
        if (!d.a(this.f)) {
            if (aVar != null) {
                new StringBuilder("[removeRedPaketStateListener] ").append(aVar.toString());
                this.f.remove(aVar);
            }
        }
    }

    public static boolean e() {
        LoginHelper.a();
        return l.c();
    }

    public static long a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Long.parseLong(r2);	 Catch:{ Exception -> 0x0005 }
        goto L_0x0007;
    L_0x0005:
        r0 = 0;
    L_0x0007:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a(java.lang.String):long");
    }

    public final void g() {
        Editor editor = this.a;
        String y = y();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.r.getString(y(), ""));
        stringBuilder.append(this.t);
        editor.putString(y, stringBuilder.toString()).commit();
        w();
        NotificationManagerWrapper.getInstance(BrothersApplication.getApplicationInstance()).cancelNotification(256);
        this.e = false;
    }

    private static String y() {
        StringBuilder stringBuilder = new StringBuilder("key:voucher_code");
        stringBuilder.append(LoginHelper.a().g.c());
        return stringBuilder.toString();
    }

    public static boolean b(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r6);
        r1 = 1;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = 0;
        r2 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0061 }
        r3 = "yyyy-MM-dd";	 Catch:{ Exception -> 0x0061 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0061 }
        r6 = r2.parse(r6);	 Catch:{ Exception -> 0x0061 }
        r2 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0061 }
        r2.setTime(r6);	 Catch:{ Exception -> 0x0061 }
        r6 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0061 }
        r3 = new java.util.Date;	 Catch:{ Exception -> 0x0061 }
        r3.<init>();	 Catch:{ Exception -> 0x0061 }
        r6.setTime(r3);	 Catch:{ Exception -> 0x0061 }
        r3 = r2.get(r1);	 Catch:{ Exception -> 0x0061 }
        r4 = r6.get(r1);	 Catch:{ Exception -> 0x0061 }
        if (r3 <= r4) goto L_0x0032;	 Catch:{ Exception -> 0x0061 }
    L_0x0031:
        return r0;	 Catch:{ Exception -> 0x0061 }
    L_0x0032:
        r3 = r2.get(r1);	 Catch:{ Exception -> 0x0061 }
        r4 = r6.get(r1);	 Catch:{ Exception -> 0x0061 }
        if (r3 >= r4) goto L_0x003d;	 Catch:{ Exception -> 0x0061 }
    L_0x003c:
        return r1;	 Catch:{ Exception -> 0x0061 }
    L_0x003d:
        r3 = 2;	 Catch:{ Exception -> 0x0061 }
        r4 = r2.get(r3);	 Catch:{ Exception -> 0x0061 }
        r5 = r6.get(r3);	 Catch:{ Exception -> 0x0061 }
        if (r4 <= r5) goto L_0x0049;	 Catch:{ Exception -> 0x0061 }
    L_0x0048:
        return r0;	 Catch:{ Exception -> 0x0061 }
    L_0x0049:
        r4 = r2.get(r3);	 Catch:{ Exception -> 0x0061 }
        r3 = r6.get(r3);	 Catch:{ Exception -> 0x0061 }
        if (r4 >= r3) goto L_0x0054;	 Catch:{ Exception -> 0x0061 }
    L_0x0053:
        return r1;	 Catch:{ Exception -> 0x0061 }
    L_0x0054:
        r3 = 6;	 Catch:{ Exception -> 0x0061 }
        r2 = r2.get(r3);	 Catch:{ Exception -> 0x0061 }
        r6 = r6.get(r3);	 Catch:{ Exception -> 0x0061 }
        if (r2 >= r6) goto L_0x0060;
    L_0x005f:
        return r1;
    L_0x0060:
        return r0;
    L_0x0061:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.b(java.lang.String):boolean");
    }

    public final String h() {
        if (i()) {
            return "有新红包到账";
        }
        if (this.e) {
            return "有红包即将过期";
        }
        return f() ? "有红包待使用" : null;
    }

    public final boolean i() {
        return this.r.getBoolean(z(), false);
    }

    public final boolean j() {
        if (!i()) {
            if (!this.e) {
                return false;
            }
        }
        return true;
    }

    public final void a(boolean z) {
        this.a.putBoolean(z(), z).commit();
        x();
    }

    private static String z() {
        StringBuilder stringBuilder = new StringBuilder("key:new_packet_red_dot");
        stringBuilder.append(LoginHelper.a().g.c());
        return stringBuilder.toString();
    }

    public final void k() {
        long j = this.h;
        if (j < 0) {
            A();
            return;
        }
        int i;
        int i2 = 0;
        if (j >= 60) {
            long j2 = j % 60;
            if (j2 == 0) {
                i2 = (int) (j / 60);
                i = 0;
            } else {
                i2 = (int) (j / 60);
                i = (int) j2;
            }
        } else {
            i = (int) j;
        }
        long j3 = (long) i2;
        if (j3 >= 10 || i2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j3 / 10);
            this.i = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(j3 % 10);
            this.j = stringBuilder.toString();
        } else {
            this.i = "0";
            this.j = String.valueOf(i2);
        }
        if (i >= 10 || i < 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            long j4 = (long) i;
            stringBuilder2.append(j4 / 10);
            this.k = stringBuilder2.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(j4 % 10);
            this.l = stringBuilder3.toString();
            return;
        }
        this.k = "0";
        this.l = String.valueOf(i);
    }

    final void l() {
        m();
        f a = a();
        new StringBuilder("[saveRecord] isNewUser=").append(v());
        if (v()) {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            a.a.putString(u(), format).commit();
            a.g = 0;
            XLThreadPool.execute(new j(a, format));
        }
        if (this.m != null) {
            this.m.removeCallbacksAndMessages(null);
        }
        if (this.n != null) {
            this.n.b();
            this.n = null;
        }
        this.h = 0;
        BannerManager.a().a(false, BannerManager$BannerType.TYPE_VOUCHER_PACKET, this.p, null);
    }

    final void m() {
        if (this.n != null) {
            this.n.b();
        }
        if (this.o != null) {
            this.o.d(8);
        }
        A();
    }

    private void A() {
        this.i = "0";
        this.j = "0";
        this.k = "0";
        this.l = "0";
    }

    private static String t() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append("/xunlei/.voucher");
        return stringBuilder.toString();
    }

    private static boolean v() {
        LoginHelper.a();
        return l.c() && j.a().d() == 0;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            LoginHelper.a();
            if (l.c()) {
                XLThreadPool.execute(new l(this, jSONObject));
            }
        }
    }

    public final void a(List<e> list, JSONObject jSONObject) {
        LoginHelper.a();
        if (l.c() && !d.a(list)) {
            a(jSONObject);
            XLThreadPool.execute(new m(this, list));
        }
    }

    private void x() {
        LoginHelper.a();
        boolean c = l.c();
        if (!d.a(this.f)) {
            if (c) {
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a();
                }
            }
        }
    }

    public final boolean f() {
        LoginHelper.a();
        return l.c() && this.s > 0;
    }

    static /* synthetic */ void b(f fVar) {
        fVar.e = false;
        fVar.w();
        fVar.g = 0;
        fVar.t = "";
        fVar.b = false;
        fVar.h = 0;
        fVar.m();
        fVar.h = 0;
    }

    static /* synthetic */ String q() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BrothersApplication.getApplicationInstance().getCacheDir().getPath());
        stringBuilder.append("/");
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("/voucherlist");
        return stringBuilder.toString();
    }

    static /* synthetic */ void h(f fVar) {
        fVar.e = true;
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        String str = "现金红包即将过期提醒";
        Builder b = m.b(applicationInstance, str, "哎呀，你的现金红包就快不翼而飞啦，快去看看！", SettingStateController.getInstance().isSoundOn());
        if (!com.xunlei.downloadprovider.h.l.b()) {
            b.setLargeIcon(BitmapFactory.decodeResource(applicationInstance.getResources(), R.mipmap.ic_launcher));
        }
        Notification build = b.build();
        Intent intent = new Intent(applicationInstance, RedEnvelopesActivity.class);
        intent.putExtra("extra:from_expired_push_click", true);
        intent.addFlags(268435456);
        build.contentIntent = PendingIntent.getActivity(applicationInstance, 0, intent, 134217728);
        NotificationManagerWrapper.getInstance(applicationInstance).postNotification(256, build);
        fVar.x();
        fVar = HubbleEventBuilder.build("android_push", "push_pop");
        fVar.add("type", "viphb_overdue");
        fVar.add("if_pop", 1);
        fVar.add("title_id", str);
        ThunderReport.reportEvent(fVar);
    }
}
