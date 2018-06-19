package com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.android.volley.d;
import com.qq.e.comm.constants.Constants.KEYS;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.c;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: TouTiaoNetwork */
public final class b extends com.xunlei.downloadprovider.download.tasklist.list.feed.e.b {

    /* compiled from: TouTiaoNetwork */
    public static class a {

        /* compiled from: TouTiaoNetwork */
        public static class a<DATA> {
            public DATA a;
            public int b;
            public String c;
        }

        public static boolean a(a aVar, @Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                aVar.b = -1001;
                aVar.c = "jsonObject is null";
            } else {
                aVar.b = jSONObject.optInt(KEYS.RET);
                aVar.c = jSONObject.optString("msg");
            }
            return a(aVar);
        }

        public static boolean a(a aVar) {
            return aVar.b == null ? true : null;
        }
    }

    public final void a(@NonNull com.xunlei.downloadprovider.download.tasklist.list.feed.e.a<com.xunlei.downloadprovider.download.tasklist.list.feed.a.a.a> aVar) {
        StringBuilder a = a("http://open.snssdk.com/auth/access/device/", aVar);
        if (a != null) {
            Map hashMap = new HashMap();
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "udid", (Object) AndroidConfig.getIMEI());
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "openudid", (Object) a());
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "os", (Object) "Android");
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, SocializeProtocolConstants.PROTOCOL_KEY_OS_VERSION, (Object) String.valueOf(AndroidConfig.getAndroidVersion()));
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "device_model", (Object) AndroidConfig.getPhoneModel());
            d(new a(a.toString(), hashMap, new c(this, aVar), new d(this, aVar)));
        }
    }

    public final void a(String str, com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b bVar, @NonNull com.xunlei.downloadprovider.download.tasklist.list.feed.e.a<c> aVar) {
        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a.a().a(new h(this, str, bVar, aVar));
    }

    private static String a() {
        return System.getString(BrothersApplication.getApplicationInstance().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }

    @Nullable
    private static StringBuilder a(String str, com.xunlei.downloadprovider.download.tasklist.list.feed.e.a aVar) {
        StringBuilder stringBuilder = new StringBuilder(str);
        try {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long nextInt = (long) new Random().nextInt(500000);
            List arrayList = new ArrayList();
            arrayList.add(String.valueOf(currentTimeMillis));
            arrayList.add(String.valueOf(nextInt));
            arrayList.add("a3236ed796b28e75e49962bbcc7db863");
            str = a(arrayList);
            if (!com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.b(stringBuilder.toString())) {
                stringBuilder.append((stringBuilder.indexOf("?") != -1 ? 1 : null) != null ? "&" : "?");
            }
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(stringBuilder, "timestamp", (Object) Long.valueOf(currentTimeMillis));
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(stringBuilder, "nonce", (Object) Long.valueOf(nextInt));
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(stringBuilder, com.alipay.sdk.app.statistic.c.D, (Object) "union_zx_xl_andr");
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(stringBuilder, "signature", (Object) str);
            return stringBuilder;
        } catch (String str2) {
            str2.printStackTrace();
            aVar.a(-1003, "签名失败");
            return null;
        }
    }

    private static String a(@NonNull List<String> list) throws IOException, NoSuchAlgorithmException {
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(append);
        }
        return com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a((String) stringBuilder.toString());
    }

    private static void a(boolean z, com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b bVar, Map<String, String> map) {
        com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a((Map) map, Impl.COLUMN_GROUP_ID, (Object) Long.valueOf(bVar.a));
        com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a((Map) map, "type", (Object) z ? "ad" : "news");
        com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a((Map) map, "client_at", (Object) Long.valueOf(System.currentTimeMillis() / 1000));
    }

    static /* synthetic */ void a(b bVar, com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b bVar2, String str, com.xunlei.downloadprovider.download.tasklist.list.feed.e.a aVar) {
        if (bVar2 == null) {
            aVar.a(-1, "toutiaoInfo is null");
            return;
        }
        StringBuilder a = a("http://open.snssdk.com/log/app_log_for_partner/v3/", aVar);
        if (a != null) {
            Map hashMap = new HashMap();
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "access_token", (Object) str);
            a(false, bVar2, hashMap);
            com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "category", (Object) "__all__");
            bVar2 = new a(a.toString(), hashMap, new f(bVar, aVar), new g(bVar, aVar));
            bVar2.setShouldCache(false);
            bVar2.setRetryPolicy(new d(10000, 0, 1.0f));
            bVar.c(bVar2);
        }
    }

    static /* synthetic */ void a(b bVar, String str, com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b bVar2, String str2, com.xunlei.downloadprovider.download.tasklist.list.feed.e.a aVar) {
        if (bVar2 == null) {
            aVar.a(-1, "toutiaoInfo is null");
        } else if (!bVar2.o) {
            aVar.a(-2, "toutiaoInfo is ad");
        } else if (str.equals(NotificationADInfo.REPORT_STATUS_SHOW) || str.equals(NotificationADInfo.REPORT_STATUS_CLICK)) {
            StringBuilder a = a("http://open.snssdk.com/log/app_log_for_partner/v4/", aVar);
            if (a != null) {
                Map hashMap = new HashMap();
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "access_token", (Object) str2);
                a(true, bVar2, hashMap);
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "ua", (Object) AndroidConfig.getUserAgent());
                long currentTimeMillis = str.equals(NotificationADInfo.REPORT_STATUS_SHOW) != null ? bVar2.u - bVar2.t : str.equals(NotificationADInfo.REPORT_STATUS_CLICK) != null ? System.currentTimeMillis() - bVar2.u : 0;
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "show_time", (Object) Long.valueOf(currentTimeMillis));
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "client_ip", (Object) com.xunlei.xllib.android.b.g(BrothersApplication.getApplicationInstance()));
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, MsgConstant.INAPP_LABEL, (Object) str);
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "ad_id", (Object) Long.valueOf(bVar2.n));
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "log_extra", (Object) bVar2.s);
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "device_type", (Object) DispatchConstants.ANDROID);
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "pdid", (Object) AndroidConfig.getIMEI());
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "openudid", (Object) a());
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "os", (Object) "Android");
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, SocializeProtocolConstants.PROTOCOL_KEY_OS_VERSION, (Object) String.valueOf(AndroidConfig.getAndroidVersion()));
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "device_model", (Object) AndroidConfig.getPhoneModel());
                com.xunlei.downloadprovider.download.tasklist.list.feed.e.b.a(hashMap, "device_brand", (Object) AndroidConfig.getPhoneBrand());
                str = new a(a.toString(), hashMap, new i(bVar, aVar), new j(bVar, aVar));
                str.setShouldCache(false);
                str.setRetryPolicy(new d(10000, 0, 1.0f));
                bVar.c(str);
            }
        } else {
            bVar2 = new StringBuilder("eventType error. eventType: ");
            bVar2.append(str);
            aVar.a(-3, bVar2.toString());
        }
    }
}
