package com.xunlei.downloadprovider.d.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.d.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: WebsConfig */
public final class q extends a {
    private static String b = "WebsConfig";
    private static final Map<String, String> c;
    public Map<String, String> a = new HashMap();
    private JSONObject d;

    public static String d() {
        return "http://m.sjzhushou.com/h5/movie/share/index.html";
    }

    static {
        Map hashMap = new HashMap();
        c = hashMap;
        hashMap.put("short_movie_url", "http://h5.m.xunlei.com/h5/page/wx-short-video/index.html?type=shortVideo&");
        c.put("download_task_url", "http://downshare.m.xunlei.com/h5/page/download-share/index.html?type=download");
        c.put("photo_article_url", "http://m.sjzhushou.com/h5/page/share-2.0/article/index.html");
        c.put("search_result_url", "http://h5.m.xunlei.com/h5/page/com.xunlei.downloadprovider.ad.common/redirect.html?type=searchV533");
        c.put("publisher_share_url", "http://h5.m.xunlei.com/h5/page/sjxunlei-personal/index.html?type=publishercenter");
        c.put("website_share_url", "http://h5.m.xunlei.com/sj/page/share/url-share/index.html");
    }

    public final void a(JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject != null) {
            jSONObject.toString();
        }
        this.d = jSONObject;
        if (jSONObject != null) {
            jSONObject = jSONObject.keys();
            while (jSONObject.hasNext()) {
                String str = (String) jSONObject.next();
                if (!TextUtils.isEmpty(str)) {
                    String optString = this.d.optString(str);
                    if (!(str == null || optString == null)) {
                        this.a.put(str, optString);
                    }
                    StringBuilder stringBuilder = new StringBuilder("key=");
                    stringBuilder.append(str);
                    stringBuilder.append("  url=");
                    stringBuilder.append(optString);
                }
            }
        }
    }

    public final String a() {
        if (this.a == null) {
            return "http://downshare.m.xunlei.com/h5/page/download-share/index.html?type=download";
        }
        String str = (String) this.a.get("download_task_url");
        return TextUtils.isEmpty(str) ? "http://downshare.m.xunlei.com/h5/page/download-share/index.html?type=download" : str;
    }

    public final String b() {
        if (this.a == null) {
            return "http://h5.m.xunlei.com/h5/page/wx-short-video/index.html?type=shortVideo&";
        }
        String str = (String) this.a.get("short_movie_url");
        if (TextUtils.isEmpty(str)) {
            return "http://h5.m.xunlei.com/h5/page/wx-short-video/index.html?type=shortVideo&";
        }
        StringBuilder stringBuilder;
        if (!str.contains("?")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("?");
            str = stringBuilder.toString();
        } else if (str.charAt(str.length() - 1) != '&') {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&");
            str = stringBuilder.toString();
        }
        return str;
    }

    public final String c() {
        String str = (String) this.a.get("website_share_url");
        return TextUtils.isEmpty(str) ? "http://h5.m.xunlei.com/sj/page/share/url-share/index.html" : str;
    }

    public final String toString() {
        return this.d == null ? null : this.d.toString();
    }

    public final String d(String str) {
        String str2 = (String) c.get(str);
        if (this.a != null) {
            if (this.a.containsKey(str)) {
                str = (String) this.a.get(str);
                return TextUtils.isEmpty(str) ? str2 : str;
            }
        }
        return str2;
    }
}
