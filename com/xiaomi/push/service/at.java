package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostFilter;
import com.xiaomi.network.HostManager;
import com.xiaomi.network.HostManager.HostManagerFactory;
import com.xiaomi.network.HostManager.HttpGet;
import com.xiaomi.smack.util.d;
import com.xiaomi.stats.f;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class at extends com.xiaomi.push.service.az.a implements HostManagerFactory {
    private XMPushService a;
    private long b;

    static class a implements HttpGet {
        a() {
        }

        public String a(String str) {
            Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", "31");
            buildUpon.appendQueryParameter("osver", String.valueOf(VERSION.SDK_INT));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Build.MODEL);
            stringBuilder.append(Constants.COLON_SEPARATOR);
            stringBuilder.append(VERSION.INCREMENTAL);
            buildUpon.appendQueryParameter("os", d.a(stringBuilder.toString()));
            buildUpon.appendQueryParameter("mi", String.valueOf(h.c()));
            str = buildUpon.toString();
            StringBuilder stringBuilder2 = new StringBuilder("fetch bucket from : ");
            stringBuilder2.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(stringBuilder2.toString());
            URL url = new URL(str);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = com.xiaomi.channel.commonutils.network.d.a(h.a(), url);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(url.getHost());
                stringBuilder3.append(Constants.COLON_SEPARATOR);
                stringBuilder3.append(port);
                com.xiaomi.stats.h.a(stringBuilder3.toString(), (int) currentTimeMillis2, null);
                return a;
            } catch (Exception e) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(url.getHost());
                stringBuilder4.append(Constants.COLON_SEPARATOR);
                stringBuilder4.append(port);
                com.xiaomi.stats.h.a(stringBuilder4.toString(), -1, e);
                throw e;
            }
        }
    }

    static class b extends HostManager {
        protected b(Context context, HostFilter hostFilter, HttpGet httpGet, String str) {
            super(context, hostFilter, httpGet, str);
        }

        protected String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                if (f.a().c()) {
                    str2 = az.e();
                }
                return super.getRemoteFallbackJSON(arrayList, str, str2, z);
            } catch (IOException e) {
                com.xiaomi.stats.h.a(0, com.xiaomi.push.thrift.a.GSLB_ERR.a(), 1, null, com.xiaomi.channel.commonutils.network.d.c(sAppContext));
                throw e;
            }
        }
    }

    at(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        com.xiaomi.push.service.az.a atVar = new at(xMPushService);
        az.a().a(atVar);
        synchronized (HostManager.class) {
            HostManager.setHostManagerFactory(atVar);
            HostManager.init(xMPushService, null, new a(), "0", "push", "2.2");
        }
    }

    public HostManager a(Context context, HostFilter hostFilter, HttpGet httpGet, String str) {
        return new b(context, hostFilter, httpGet, str);
    }

    public void a(com.xiaomi.push.protobuf.a.a aVar) {
    }

    public void a(com.xiaomi.push.protobuf.b.b bVar) {
        if (bVar.e() && bVar.d() && System.currentTimeMillis() - this.b > 3600000) {
            StringBuilder stringBuilder = new StringBuilder("fetch bucket :");
            stringBuilder.append(bVar.d());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            this.b = System.currentTimeMillis();
            HostManager instance = HostManager.getInstance();
            instance.clear();
            instance.refreshFallbacks();
            com.xiaomi.smack.a h = this.a.h();
            if (h != null) {
                Fallback fallbacksByHost = instance.getFallbacksByHost(h.d().e());
                if (fallbacksByHost != null) {
                    ArrayList d = fallbacksByHost.d();
                    boolean z = true;
                    Iterator it = d.iterator();
                    while (it.hasNext()) {
                        if (((String) it.next()).equals(h.e())) {
                            z = false;
                            break;
                        }
                    }
                    if (z && !d.isEmpty()) {
                        com.xiaomi.channel.commonutils.logger.b.a("bucket changed, force reconnect");
                        this.a.a(0, null);
                        this.a.a(false);
                    }
                }
            }
        }
    }
}
