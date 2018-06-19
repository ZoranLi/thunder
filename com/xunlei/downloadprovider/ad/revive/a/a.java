package com.xunlei.downloadprovider.ad.revive.a;

import android.content.Context;
import com.umeng.message.proguard.k;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.ad.common.report.j;
import com.xunlei.downloadprovider.ad.revive.ReviveAdActivity;
import com.xunlei.downloadprovider.ad.splash.b.b;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.d.e;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.member.login.ui.LoginActivity;
import org.json.JSONObject;

/* compiled from: AdvertisementUtil */
public class a {
    private static final String a = "a";
    private static boolean b = false;

    public static void a(Context context) {
        for (com.xunlei.downloadprovider.ad.cache.task.a.a a : com.xunlei.downloadprovider.ad.cache.task.a.a().a) {
            a.a();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String name = context.getClass().getName();
        String string = new PreferenceHelper(a.a(context).b, "preference_revive_ad").getString("last_context_name", "");
        StringBuilder stringBuilder = new StringBuilder("[AD] OnForeground: ");
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append(k.s);
        stringBuilder.append(a.a);
        stringBuilder.append(") - ");
        stringBuilder.append(name);
        stringBuilder.append(" (");
        stringBuilder.append(string);
        stringBuilder.append(k.t);
        if (!(context instanceof LaunchActivity)) {
            if (com.xunlei.downloadprovider.launch.c.a.a(context) == 0) {
                if (!((context instanceof LoginActivity) && d.a().e.a()) && LaunchActivity.a) {
                    if (com.xunlei.downloadprovider.h.a.a) {
                        j.c();
                        j.a(b.b(2));
                        ReviveAdActivity.a(context, true);
                    } else {
                        boolean z;
                        j.c();
                        j.a(b.b(1));
                        long j = new PreferenceHelper(a.a(context).b, "preference_revive_ad").getLong("backgroud_moment", -1);
                        long j2 = new PreferenceHelper(a.a(context).b, "preference_revive_ad").getLong("backgroud_session", 0);
                        if (name == null || !(name.contains("com.xunlei.downloadprovider.vod") || name.contains("com.xunlei.downloadprovider.task.create."))) {
                            z = false;
                        } else {
                            com.xunlei.downloadprovider.ad.common.report.a.a("player");
                            z = true;
                        }
                        if (name.contains("com.xunlei.downloadprovider.member.payment.")) {
                            com.xunlei.downloadprovider.ad.common.report.a.a("vippay");
                            z = true;
                        }
                        if (com.xunlei.downloadprovider.launch.c.a.a(context) != 0) {
                            z = true;
                        }
                        if (j > 0) {
                            long j3 = currentTimeMillis >= j ? currentTimeMillis - j : 0;
                            if (a.a == 0) {
                                a.a = currentTimeMillis;
                            } else if (!z && a.a == j2) {
                                long optLong;
                                a a2 = a.a(context);
                                com.xunlei.downloadprovider.d.e.a aVar = e.a().e;
                                if (aVar.a != null) {
                                    name = AndroidConfig.getPartnerId();
                                    JSONObject optJSONObject;
                                    if (!"0x10800030".equals(name)) {
                                        if (!"0x10800013".equals(name)) {
                                            if (!"0x10810054".equals(name)) {
                                                optLong = aVar.a.optLong("revive_ad_time", 15);
                                            }
                                        }
                                        if (aVar.a != null) {
                                            optJSONObject = aVar.a.optJSONObject("ad_360");
                                            if (optJSONObject != null) {
                                                optLong = (long) optJSONObject.optInt("revive_ad_time", 0);
                                            }
                                        }
                                    } else if (aVar.a != null) {
                                        optJSONObject = aVar.a.optJSONObject("ad_baidu");
                                        if (optJSONObject != null) {
                                            optLong = (long) optJSONObject.optInt("revive_ad_time", 0);
                                        }
                                    }
                                    optLong = 0;
                                } else {
                                    optLong = 15;
                                }
                                optLong *= 60;
                                stringBuilder = new StringBuilder("[AD] checkReviveAd - Background lifeTime: ");
                                stringBuilder.append(j3);
                                stringBuilder.append(", reviveTime: ");
                                stringBuilder.append(optLong);
                                if ((optLong <= 0 || j3 < optLong) && !(b && a2.b.getClass().getSimpleName().equals("DownloadCenterActivity"))) {
                                    com.xunlei.downloadprovider.ad.common.report.a.a("less_interval");
                                } else {
                                    ReviveAdActivity.a(context);
                                    b = false;
                                }
                            }
                        } else {
                            if (!BrothersApplication.getSingletonInstance().hasLaunched) {
                                ReviveAdActivity.a(context);
                            }
                            if (context.getClass().getSimpleName().equals("DownloadCenterActivity")) {
                                if (com.xunlei.downloadprovider.launch.c.a.a(context) == 0) {
                                    ReviveAdActivity.a(context);
                                }
                            } else if (context.getClass().getSimpleName().equals("BHOActivity")) {
                                b = true;
                            }
                            new StringBuilder("[AD] BackgroudMoment not exists ").append(context.getClass().getSimpleName());
                        }
                    }
                    a.a(context).a(0, a.a, "");
                }
            }
        }
    }

    public static void b(Context context) {
        for (com.xunlei.downloadprovider.ad.cache.task.a.a b : com.xunlei.downloadprovider.ad.cache.task.a.a().a) {
            b.b();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (a.a == 0) {
            a.a = currentTimeMillis;
        }
        String name = context.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder("[AD] OnBackground: ");
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append(k.s);
        stringBuilder.append(a.a);
        stringBuilder.append(") - ");
        stringBuilder.append(name);
        a.a(context).a(currentTimeMillis, a.a, name);
    }
}
