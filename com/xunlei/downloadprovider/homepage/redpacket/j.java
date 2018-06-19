package com.xunlei.downloadprovider.homepage.redpacket;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.stat.base.XLStatCommandID;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.b.n;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.homepage.redpacket.a.d;
import com.xunlei.downloadprovider.homepage.redpacket.a.d.a;
import com.xunlei.downloadprovider.homepage.redpacket.a.e;
import com.xunlei.downloadprovider.homepage.redpacket.a.h;
import com.xunlei.downloadprovider.homepage.redpacket.a.k;
import com.xunlei.downloadprovider.loading.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovidershare.a.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RedPacketHelper */
public class j {
    public static String a = "";
    public static String b = "";
    private static final String d = "j";
    private static j f;
    public boolean c = f.b(BrothersApplication.getApplicationInstance(), "key_is_choiceness_lottie_showed", false);
    private List<String> e = new ArrayList();

    private j() {
    }

    public static j a() {
        if (f == null) {
            synchronized (j.class) {
                if (f == null) {
                    f = new j();
                }
            }
        }
        return f;
    }

    public static void a(a aVar) {
        d a = d.a();
        boolean d = com.xunlei.downloadprovider.d.d.a().l.d();
        boolean b = f.b(BrothersApplication.getApplicationInstance(), "key_has_show_new_packet");
        StringBuilder stringBuilder = new StringBuilder("getIsNeedShowRedPacketGuide isRedPacketShare, hasShowedNewPacket, LoadingUtil.isFirstLaunch() = ");
        stringBuilder.append(d);
        stringBuilder.append(", ");
        stringBuilder.append(b);
        stringBuilder.append(", ");
        stringBuilder.append(c.b());
        if (!b) {
            if (d) {
                XLThreadPool.execute(new e(a, aVar));
            }
        }
    }

    public static void b(a aVar) {
        XLThreadPool.execute(new h(d.a(), aVar));
    }

    public final void a(String str) {
        if (!this.e.contains(str)) {
            this.e.add(str);
        }
    }

    public final boolean b(String str) {
        return this.e.contains(str);
    }

    public static void a(com.xunlei.downloadprovider.member.payment.a.e.c<com.xunlei.downloadprovider.homepage.redpacket.a.c> cVar) {
        k.a().a(0, "http://api-shoulei-ssl.xunlei.com/ares/api/balance", "", cVar);
    }

    public final void a(Context context, com.xunlei.downloadprovidershare.a.f fVar) {
        if (com.xunlei.downloadprovider.d.d.a().l.d()) {
            if (fVar != null) {
                LoginHelper.a();
                boolean c = l.c();
                Context applicationInstance = BrothersApplication.getApplicationInstance();
                StringBuilder stringBuilder = new StringBuilder("key_first_share_time");
                stringBuilder.append(LoginHelper.a().g.c());
                boolean isTheSameDay = DateUtil.isTheSameDay(f.b(applicationInstance, stringBuilder.toString(), 0), System.currentTimeMillis());
                stringBuilder = new StringBuilder("getRedPacketShareProfit() isLogined, isFirstShareSameDay  = ");
                stringBuilder.append(c);
                stringBuilder.append(", ");
                stringBuilder.append(isTheSameDay);
                if (c) {
                    if (isTheSameDay) {
                        d();
                    } else {
                        i iVar = (i) fVar;
                        fVar = fVar.j;
                        k.a().a(1, "http://api-shoulei-ssl.xunlei.com/ares/api/operation/first_share", iVar.a, new k(this, context, fVar));
                    }
                }
            }
        }
    }

    private void d() {
        a(new l(this));
    }

    public static void a(Context context, String str) {
        String str2 = !TextUtils.isEmpty(b) ? b : "抢钱啦";
        String str3 = !TextUtils.isEmpty(a) ? a : "http://h5.m.xunlei.com/sj/activity/share-redpacket/index.html";
        com.xunlei.downloadprovider.personal.redenvelope.f.b(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append("?from=");
        stringBuilder.append(str);
        str3 = stringBuilder.toString();
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(context, str3, str2, str);
    }

    public final void a(Activity activity, String str, BaseVideoInfo baseVideoInfo, com.xunlei.downloadprovidershare.k kVar, com.xunlei.downloadprovidershare.b.c cVar) {
        Activity activity2 = activity;
        com.xunlei.downloadprovidershare.k kVar2 = kVar;
        com.xunlei.downloadprovidershare.b.c cVar2 = cVar;
        int b = com.xunlei.downloadprovider.d.d.a().l.b();
        if (b == n.b) {
            q.a().a(activity2, "com.xunlei.plugin.qrcode", new o(this, activity2, str, baseVideoInfo, b, kVar2, cVar2));
        } else if (b == n.c) {
            r0 = com.xunlei.downloadprovider.f.c.a(activity2, str, baseVideoInfo, b);
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.b(activity2, r0, kVar2, cVar2);
        } else {
            r0 = com.xunlei.downloadprovider.f.c.a(str, baseVideoInfo);
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.b(activity2, r0, kVar2, cVar2);
        }
    }

    public static String a(int i) {
        if (i >= 10000000) {
            i = (i / 1000) * 1000;
        } else if (i >= XLPayErrorCode.XLP_NET_GATE_ERROR_BASE) {
            i = (i / 100) * 100;
        } else if (i >= XLStatCommandID.XLCID_LOGIN) {
            i = (i / 10) * 10;
        }
        i = ((float) i) / 1148846080;
        if (i >= 1176256512) {
            i = String.valueOf((int) i);
        } else {
            i = String.valueOf(i);
        }
        StringBuilder stringBuilder = new StringBuilder("可提现：");
        stringBuilder.append(i);
        stringBuilder.append("元");
        return stringBuilder.toString();
    }
}
