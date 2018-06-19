package com.xunlei.downloadprovider.d;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.d;
import com.qihoo360.replugin.RePlugin;
import com.taobao.accs.AccsClientConfig;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.net.volley.BaseJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.a.f;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* compiled from: OnlineConfigure */
public final class e {
    public static String a = "OnlineConfigure";
    private static e g;
    boolean b = false;
    long c = 0;
    boolean d = false;
    public final a e = new a();
    private int f = 0;
    private String h;

    /* compiled from: OnlineConfigure */
    public static class a {
        public JSONObject a;

        /* compiled from: OnlineConfigure */
        public static class a {
            public static boolean k = false;
            public static int m = 0;
            public static int n = 100;
            public int a;
            public boolean b = true;
            public int c = 1;
            public int d = 0;
            public boolean e = true;
            public boolean f = true;
            public boolean g = true;
            public boolean h = true;
            public boolean i = true;
            public boolean j = true;
            public int l = 1;
            public Map<Integer, Integer> o = new HashMap();
            public Map<AD_SYSTEM_TYPE, Integer> p;

            public a() {
                this.o.put(Integer.valueOf(2), Integer.valueOf(n));
                this.o.put(Integer.valueOf(1), Integer.valueOf(m));
                this.p = new HashMap();
                this.p.put(AD_SYSTEM_TYPE.SOURCE_GDT_FLAG, Integer.valueOf(100));
                this.p.put(AD_SYSTEM_TYPE.SOURCE_XUNLEI_FLAG, Integer.valueOf(0));
            }
        }

        public final a a() {
            JSONObject optJSONObject;
            a aVar = new a();
            String partnerId = AndroidConfig.getPartnerId();
            JSONObject jSONObject = null;
            boolean z = false;
            if (this.a != null) {
                JSONObject optJSONObject2 = this.a.optJSONObject("ad_switch_513");
                optJSONObject = optJSONObject2 != null ? optJSONObject2.has(partnerId) ? optJSONObject2.optJSONObject(partnerId) : optJSONObject2.optJSONObject(AccsClientConfig.DEFAULT_CONFIGTAG) : null;
                if ("5.60.2.5510".equals(this.a.optString("app_version", RePlugin.PROCESS_UI))) {
                    if (optJSONObject != null && optJSONObject.has("switch_new")) {
                        optJSONObject = optJSONObject.optJSONObject("switch_new");
                    }
                    optJSONObject = this.a.optJSONObject("downloadinfo_ad_chance");
                    if (optJSONObject != null) {
                        aVar.p.put(AD_SYSTEM_TYPE.SOURCE_GDT_FLAG, Integer.valueOf(optJSONObject.optInt(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT, 100)));
                        aVar.p.put(AD_SYSTEM_TYPE.SOURCE_XUNLEI_FLAG, Integer.valueOf(optJSONObject.optInt("shoulei", 0)));
                    }
                    optJSONObject = this.a.optJSONObject("launchStyle");
                    if (optJSONObject != null) {
                        aVar.o.put(Integer.valueOf(2), Integer.valueOf(optJSONObject.optInt("piecesTogether", a.n)));
                        aVar.o.put(Integer.valueOf(1), Integer.valueOf(optJSONObject.optInt("fullScreen", a.m)));
                    }
                } else {
                    if (optJSONObject != null && optJSONObject.has("switch")) {
                        optJSONObject = optJSONObject.optJSONObject("switch");
                    }
                    optJSONObject = this.a.optJSONObject("downloadinfo_ad_chance");
                    if (optJSONObject != null) {
                        aVar.p.put(AD_SYSTEM_TYPE.SOURCE_GDT_FLAG, Integer.valueOf(optJSONObject.optInt(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT, 100)));
                        aVar.p.put(AD_SYSTEM_TYPE.SOURCE_XUNLEI_FLAG, Integer.valueOf(optJSONObject.optInt("shoulei", 0)));
                    }
                    optJSONObject = this.a.optJSONObject("launchStyle");
                    if (optJSONObject != null) {
                        aVar.o.put(Integer.valueOf(2), Integer.valueOf(optJSONObject.optInt("piecesTogether", a.n)));
                        aVar.o.put(Integer.valueOf(1), Integer.valueOf(optJSONObject.optInt("fullScreen", a.m)));
                    }
                }
                jSONObject = optJSONObject;
                optJSONObject = this.a.optJSONObject("downloadinfo_ad_chance");
                if (optJSONObject != null) {
                    aVar.p.put(AD_SYSTEM_TYPE.SOURCE_GDT_FLAG, Integer.valueOf(optJSONObject.optInt(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT, 100)));
                    aVar.p.put(AD_SYSTEM_TYPE.SOURCE_XUNLEI_FLAG, Integer.valueOf(optJSONObject.optInt("shoulei", 0)));
                }
                optJSONObject = this.a.optJSONObject("launchStyle");
                if (optJSONObject != null) {
                    aVar.o.put(Integer.valueOf(2), Integer.valueOf(optJSONObject.optInt("piecesTogether", a.n)));
                    aVar.o.put(Integer.valueOf(1), Integer.valueOf(optJSONObject.optInt("fullScreen", a.m)));
                }
            }
            if (jSONObject != null) {
                boolean z2 = (this.a == null || this.a.optInt("ad_type", 0) == 0) ? false : true;
                if (z2) {
                    optJSONObject = jSONObject.optJSONObject("launch_ad_chance_522");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("is_show");
                        if (optString == null || !optString.equals("1")) {
                            if (optString == null) {
                                aVar.b = true;
                            } else {
                                aVar.b = false;
                            }
                        } else if (optJSONObject.optJSONObject("config") != null) {
                            aVar.b = true;
                        }
                    }
                    aVar.c = jSONObject.optInt("downrecommend_ad", 1);
                    aVar.d = jSONObject.optInt("searchtab_ad", 0);
                    aVar.l = jSONObject.optInt("main_page_ad_type", 0);
                    aVar.e = jSONObject.optInt("ad_downloadtab1_ad_enable", 1) == 1;
                    aVar.f = jSONObject.optInt("ad_downloadtab2_ad_enable", 1) == 1;
                    aVar.g = jSONObject.optInt("ad_downloadtab3_ad_enable", 1) == 1;
                    a.k = jSONObject.optInt("baidu_ad_block_enable", 0) == 1;
                    aVar.h = jSONObject.optInt("downloadinfo_ad_enable", 1) == 1;
                    aVar.i = jSONObject.optInt("shortvideoinforec_ad_enable", 1) == 1;
                    if (jSONObject.optInt("shortvideo_ad_enable", 1) == 1) {
                        z = true;
                    }
                    aVar.j = z;
                    aVar.a = this.a.optInt("launch_countdown", 3);
                }
            }
            return aVar;
        }

        public final int b() {
            if (this.a != null) {
                return this.a.optInt("launch_timeout", 5);
            }
            return 5;
        }

        public final boolean c() {
            if (this.a == null || this.a.optInt("ad_downloadtag_close_enable", 1) == 1) {
                return true;
            }
            return false;
        }
    }

    private File d() {
        if (TextUtils.isEmpty(this.h)) {
            File cacheDir = BrothersApplication.getApplicationInstance().getCacheDir();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cacheDir.getAbsolutePath());
            stringBuilder.append("thunder_config.json");
            this.h = stringBuilder.toString();
        }
        return new File(this.h);
    }

    private e() {
    }

    public static e a() {
        if (g == null) {
            g = new e();
        }
        return g;
    }

    protected final void b() {
        Object a;
        File d = d();
        if (d.exists()) {
            new StringBuilder("loadConfigureFromLocalCache - cache : ").append(d.getAbsolutePath());
            a = f.a(d);
        } else {
            a = null;
        }
        try {
            if (!TextUtils.isEmpty(a)) {
                a(new JSONObject(a), 1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    final void c() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/thunder_config.json?versionCode=11100&rd=");
        stringBuilder.append(SystemClock.elapsedRealtime());
        String stringBuilder2 = stringBuilder.toString();
        this.d = false;
        Request baseJsonObjectRequest = new BaseJsonObjectRequest(0, stringBuilder2, null, new g(this), new h(this, stringBuilder2));
        baseJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        baseJsonObjectRequest.setShouldCache(false);
        VolleyRequestManager.getRequestQueue().a(baseJsonObjectRequest);
    }

    protected final void a(JSONObject jSONObject, int i) {
        new StringBuilder("loadConfigureJson - ").append(jSONObject);
        if (jSONObject != null) {
            this.f = i | this.f;
            this.e.a = jSONObject.optJSONObject("ad");
            this.b = true;
            this.c = System.currentTimeMillis();
        }
    }

    static /* synthetic */ void a(e eVar, JSONObject jSONObject) {
        com.xunlei.downloadprovider.app.e.a("You should not write file on main thread");
        if (jSONObject != null) {
            try {
                File d = eVar.d();
                new StringBuilder("saveConfigureToFile - cache : ").append(d.getAbsolutePath());
                f.a(d, jSONObject.toString());
            } catch (e eVar2) {
                eVar2.printStackTrace();
            }
        }
    }
}
