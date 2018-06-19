package com.xunlei.downloadprovider.contentpublish.website.a;

import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.downloadprovider.d.a.g;
import com.xunlei.downloadprovider.h.k.a;
import java.util.HashSet;
import org.json.JSONArray;

/* compiled from: WebsiteWhiteListConfig */
public class m extends g {
    private static final String[] a = new String[]{"www.", "m.", "3g."};
    private static volatile m c;
    private final HashSet<String> b = new HashSet();

    private m() {
        super("website_white_list", "http://api-shoulei-ssl.xunlei.com/fav_site/sitewhitelist");
    }

    public static m a() {
        if (c == null) {
            synchronized (m.class) {
                if (c == null) {
                    c = new m();
                }
            }
        }
        return c;
    }

    protected final void a(boolean z, JSONArray jSONArray) {
        super.a(z, jSONArray);
        if (jSONArray != null) {
            z = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                CharSequence optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    optString = optString.replaceFirst("http://", "").replaceFirst("https://", "");
                }
                if (!TextUtils.isEmpty(optString)) {
                    z.add(optString);
                }
            }
            synchronized (this.b) {
                this.b.clear();
                this.b.addAll(z);
            }
        }
    }

    public final boolean d(String str) {
        str = e(str);
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        while (i < a.length) {
            String str2 = a[i];
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
                break;
            }
            i++;
        }
        return this.b.contains(str);
    }

    private static String e(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (a.d(str)) {
                if (!TextUtils.isEmpty(str)) {
                    if (!str.startsWith("http://")) {
                        if (!str.startsWith("https://")) {
                            StringBuilder stringBuilder = new StringBuilder("http://");
                            stringBuilder.append(str);
                            str = stringBuilder.toString();
                        }
                    }
                }
                try {
                    return Uri.parse(str).getHost();
                } catch (String str2) {
                    str2.printStackTrace();
                    return "";
                }
            }
        }
        return "";
    }
}
