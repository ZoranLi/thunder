package com.xunlei.downloadprovider.discovery.kuainiao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.common.accelerator.XLAccelUtil;
import com.xunlei.common.accelerator.bean.KnParams;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.base.XLAlarmBaseTimer;
import com.xunlei.common.base.XLAlarmBaseTimer.TimerListener;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.discovery.kuainiao.a.a;
import com.xunlei.downloadprovider.discovery.kuainiao.a.b;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: KuaiNiaoManager */
public class d implements TimerListener, a {
    public static boolean f = true;
    private static d h;
    public boolean a;
    public PreferenceHelper b;
    public boolean c = false;
    public boolean d = false;
    String e;
    private boolean g;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private String l;
    private List<a> m = new ArrayList();

    public static d a() {
        if (h == null) {
            synchronized (d.class) {
                if (h == null) {
                    h = new d();
                }
            }
        }
        return h;
    }

    private d() {
        XLAccelUtil.getInstance().init(BrothersApplication.getApplicationInstance(), XLDeviceGen.getInstance().getDeviceId(), "shoulei");
        XLAccelUtil.getInstance().getAccelerator().attachListener(this);
        this.b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "kuai_niao_info");
    }

    public static boolean b() {
        return BrothersApplication.getApplicationInstance().getSharedPreferences("first_Get_kuaiNiao_Acc_Info", 0).getBoolean("firstGetKuaiNiaoAccInfo", true);
    }

    public static void c() {
        Editor edit = BrothersApplication.getApplicationInstance().getSharedPreferences("first_Get_kuaiNiao_Acc_Info", 0).edit();
        edit.putBoolean("firstGetKuaiNiaoAccInfo", false);
        edit.apply();
    }

    public final void d() {
        if (!this.g) {
            this.g = true;
            b.a();
            b.d();
        }
    }

    public static void e() {
        b.a();
        b.c();
    }

    public final void a(a aVar) {
        if (!this.m.contains(aVar)) {
            this.m.add(aVar);
        }
    }

    public final void b(a aVar) {
        this.m.remove(aVar);
    }

    private void a(String str, int i, KnParams knParams) {
        for (a a : this.m) {
            a.a(str, i, knParams);
        }
    }

    private void a(int i, XLAccelBandInfo xLAccelBandInfo) {
        this.g = false;
        if (i != 0 || xLAccelBandInfo == null) {
            this.a = false;
        } else {
            this.a = true;
        }
        for (a a : this.m) {
            a.a(i, xLAccelBandInfo);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void callBack(int r5, int r6, java.lang.String r7) {
        /*
        r4 = this;
        r0 = 18;
        r1 = 0;
        r2 = 1;
        r3 = 0;
        if (r5 == r0) goto L_0x00b5;
    L_0x0007:
        r0 = 20;
        if (r5 == r0) goto L_0x00a5;
    L_0x000b:
        switch(r5) {
            case 2: goto L_0x0070;
            case 3: goto L_0x0062;
            case 4: goto L_0x0050;
            case 5: goto L_0x0024;
            case 6: goto L_0x00a5;
            case 7: goto L_0x00a5;
            case 8: goto L_0x0016;
            default: goto L_0x000e;
        };
    L_0x000e:
        switch(r5) {
            case 11: goto L_0x0070;
            case 12: goto L_0x0012;
            default: goto L_0x0011;
        };
    L_0x0011:
        goto L_0x0066;
    L_0x0012:
        r4.a(r3);
        return;
    L_0x0016:
        r5 = "start";
        r7 = r4.f();
        com.xunlei.downloadprovider.discovery.kuainiao.j.a(r5, r7, r6);
        r4.j = r3;
        r4.k = r3;
        return;
    L_0x0024:
        r5 = r4.i;
        if (r5 != 0) goto L_0x0038;
    L_0x0028:
        r4.i = r2;
        r5 = com.xunlei.common.base.XLAlarmBaseTimer.getInstance();
        r0 = 124442; // 0x1e61a float:1.7438E-40 double:6.14825E-319;
        r1 = com.xunlei.common.accelerator.http.XLAccelHttpReqInfo.getInitTryStatusTime();
        r5.registerTimer(r0, r1, r3, r4);
    L_0x0038:
        r4.a(r2);
        r4.a(r7);
        r5 = r4.k;
        if (r5 != 0) goto L_0x004d;
    L_0x0042:
        r5 = "end";
        r7 = r4.f();
        com.xunlei.downloadprovider.discovery.kuainiao.j.a(r5, r7, r6);
        r4.k = r2;
    L_0x004d:
        r4.j = r3;
        return;
    L_0x0050:
        r5 = r4.j;
        if (r5 != 0) goto L_0x005f;
    L_0x0054:
        r5 = "success";
        r7 = r4.f();
        com.xunlei.downloadprovider.discovery.kuainiao.j.a(r5, r7, r6);
        r4.j = r2;
    L_0x005f:
        r4.k = r3;
        return;
    L_0x0062:
        r4.j = r3;
        r4.k = r3;
    L_0x0066:
        r4.g();
        r4.a(r7);
        f = r2;
        goto L_0x014e;
    L_0x0070:
        r5 = -1;
        r4.a(r5, r1);
        r5 = com.xunlei.common.accelerator.XLAccelUtil.getInstance();
        r5 = r5.getAccelerator();
        r5 = r5.isKuaiNiao();
        r0 = com.xunlei.common.accelerator.XLAccelUtil.getInstance();
        r0 = r0.getAccelerator();
        r0 = r0.getKnParams();
        r4.a(r7, r5, r0);
        r4.g();
        r4.a(r3);
        r5 = "exception";
        r7 = r4.f();
        com.xunlei.downloadprovider.discovery.kuainiao.j.a(r5, r7, r6);
        r4.j = r3;
        r4.k = r3;
        f = r2;
        return;
    L_0x00a5:
        r5 = r4.k;
        if (r5 != 0) goto L_0x014e;
    L_0x00a9:
        r5 = "exception";
        r7 = r4.f();
        com.xunlei.downloadprovider.discovery.kuainiao.j.a(r5, r7, r6);
        r4.k = r2;
        return;
    L_0x00b5:
        r5 = f;
        if (r5 == 0) goto L_0x00be;
    L_0x00b9:
        r4.a(r7);
        f = r3;
    L_0x00be:
        r4.k = r3;
        r5 = r4.j;
        if (r5 != 0) goto L_0x00cf;
    L_0x00c4:
        r5 = "success";
        r7 = r4.f();
        com.xunlei.downloadprovider.discovery.kuainiao.j.a(r5, r7, r6);
        r4.j = r2;
    L_0x00cf:
        r5 = r4.l;
        if (r5 == 0) goto L_0x00dd;
    L_0x00d3:
        r5 = r4.l;
        r6 = com.xunlei.downloadprovider.discovery.kuainiao.KuaiNiaoFragment.a;
        r5 = r5.equals(r6);
        if (r5 != 0) goto L_0x014e;
    L_0x00dd:
        r5 = com.xunlei.downloadprovider.discovery.kuainiao.KuaiNiaoFragment.a;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x014e;
    L_0x00e5:
        r5 = com.xunlei.common.accelerator.XLAccelUtil.getInstance();
        r5 = r5.getAccelerator();
        r5 = r5.getUsingCardInfo();
        r6 = android.text.TextUtils.isEmpty(r5);
        if (r6 != 0) goto L_0x014d;
    L_0x00f7:
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x010a }
        r6.<init>(r5);	 Catch:{ JSONException -> 0x010a }
        r5 = "cardid";
        r5 = r6.optString(r5);	 Catch:{ JSONException -> 0x010a }
        r7 = "cardtime";
        r6.optInt(r7);	 Catch:{ JSONException -> 0x0108 }
        goto L_0x010f;
    L_0x0108:
        r6 = move-exception;
        goto L_0x010c;
    L_0x010a:
        r6 = move-exception;
        r5 = r1;
    L_0x010c:
        r6.printStackTrace();
    L_0x010f:
        r6 = com.xunlei.downloadprovider.discovery.kuainiao.KuaiNiaoFragment.a;
        r5 = r6.equals(r5);
        if (r5 == 0) goto L_0x014d;
    L_0x0117:
        r5 = com.xunlei.downloadprovider.discovery.kuainiao.KuaiNiaoFragment.a;
        r4.l = r5;
        r5 = r4.l;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r7 = r7.g;
        r0 = r7.c();
        r7 = "http://api-shoulei-ssl.xunlei.com/red_packets_cli/info_game_cdk_used?";
        r6.append(r7);
        r7 = "status=2&gift_type=31&code=";
        r6.append(r7);
        r6.append(r5);
        r5 = "&uid=";
        r6.append(r5);
        r5 = java.lang.String.valueOf(r0);
        r6.append(r5);
        r5 = new com.xunlei.downloadprovider.discovery.kuainiao.e;
        r5.<init>(r4, r6);
        com.xunlei.common.concurrent.XLThreadPool.execute(r5);
    L_0x014d:
        return;
    L_0x014e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.discovery.kuainiao.d.callBack(int, int, java.lang.String):void");
    }

    private void a(String str) {
        XLAccelBandInfo xLAccelBandInfo;
        if (TextUtils.isEmpty(XLAccelUtil.getInstance().getAccelerator().getBandInfo())) {
            xLAccelBandInfo = null;
        } else {
            xLAccelBandInfo = new XLAccelBandInfo();
        }
        a(0, xLAccelBandInfo);
        a(str, XLAccelUtil.getInstance().getAccelerator().isKuaiNiao(), XLAccelUtil.getInstance().getAccelerator().getKnParams());
    }

    private void g() {
        if (this.i) {
            this.i = false;
            XLAlarmBaseTimer.getInstance().unRegisterTimer(124442);
        }
    }

    public void onTimerTick(int i) {
        g();
        XLAccelUtil.getInstance().getAccelerator().reInit();
    }

    private void a(boolean z) {
        this.d = z;
        this.b.setBoolean("has_try_accel", z);
    }

    public final String f() {
        if (this.e == null) {
            return "";
        }
        return this.e;
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str = jSONObject.optString("card_id");
                int optInt = jSONObject.optInt("time_length");
                if (!TextUtils.isEmpty(str)) {
                    Intent a = KuaiNiaoActivity.a(context, "k_an_shoulei_hytq_knhb");
                    a.putExtra("extra_card_id", str);
                    a.putExtra("extra_card_time", optInt);
                    str = jSONObject.optString("validity_end_date");
                    if (!TextUtils.isEmpty(str)) {
                        a.putExtra("extra_card_validate_time", Uri.encode(str));
                    }
                    str = jSONObject.optString("receive_time");
                    if (!TextUtils.isEmpty(str)) {
                        a.putExtra("extra_card_receive_time", Uri.encode(str));
                    }
                    context.startActivity(a);
                }
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str = Pattern.compile("\\d+").matcher(str);
        if (str.find()) {
            try {
                str = Integer.valueOf(str.group()).intValue();
            } catch (String str2) {
                str2.printStackTrace();
            }
            return str2;
        }
        str2 = null;
        return str2;
    }

    public static void a(Context context, @NonNull String str, String str2) {
        str2 = str2 != null ? b(str2) : 60;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("card_id", str);
            jSONObject.put("time_length", str2);
        } catch (String str3) {
            str3.printStackTrace();
        }
        a();
        a(context, jSONObject.toString());
    }
}
