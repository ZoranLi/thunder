package com.xunlei.downloadprovider.discovery.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.a.h;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: HotTopicManager */
public final class a extends h {
    private static a c;
    public List<a> a = new ArrayList();
    private Context b;

    public static a a(Context context) {
        if (c == null) {
            c = new a();
        }
        c.b = context;
        return c;
    }

    private a() {
        super("http://api-shoulei-ssl.xunlei.com/pss/static/tabTopic/config.json");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(org.json.JSONArray r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.a;	 Catch:{ all -> 0x003f }
        if (r0 == 0) goto L_0x003d;
    L_0x0005:
        r0 = r5.a;	 Catch:{ all -> 0x003f }
        r0.clear();	 Catch:{ all -> 0x003f }
        if (r6 == 0) goto L_0x003b;
    L_0x000c:
        r0 = r6.length();	 Catch:{ all -> 0x003f }
        r1 = 6;
        if (r0 < r1) goto L_0x003b;
    L_0x0013:
        r0 = 0;
    L_0x0014:
        if (r0 >= r1) goto L_0x003b;
    L_0x0016:
        r2 = r6.optJSONObject(r0);	 Catch:{ all -> 0x003f }
        if (r2 == 0) goto L_0x0039;
    L_0x001c:
        r3 = new com.xunlei.downloadprovider.discovery.a.a$a;	 Catch:{ all -> 0x003f }
        r3.<init>();	 Catch:{ all -> 0x003f }
        r4 = "poster";
        r4 = r2.optString(r4);	 Catch:{ all -> 0x003f }
        r3.a = r4;	 Catch:{ all -> 0x003f }
        r4 = "topicName";
        r2 = r2.optString(r4);	 Catch:{ all -> 0x003f }
        r3.b = r2;	 Catch:{ all -> 0x003f }
        r2 = r5.a;	 Catch:{ all -> 0x003f }
        r2.add(r3);	 Catch:{ all -> 0x003f }
        r0 = r0 + 1;
        goto L_0x0014;
    L_0x0039:
        monitor-exit(r5);
        return;
    L_0x003b:
        monitor-exit(r5);
        return;
    L_0x003d:
        monitor-exit(r5);
        return;
    L_0x003f:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.discovery.a.a.b(org.json.JSONArray):void");
    }

    public static void a() {
        if (c != null) {
            c.b = null;
        }
    }

    public final synchronized List<a> b() {
        return this.a;
    }

    public final boolean a(View view, int i) {
        if (this.a == null || this.a.size() <= i || view == null) {
            return false;
        }
        a aVar = (a) this.a.get(i);
        if (aVar == null) {
            return false;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_poster);
        if (aVar.a == null) {
            return false;
        }
        b.a().a(aVar.a, imageView, null);
        if (aVar.b == null) {
            return false;
        }
        ((TextView) view.findViewById(R.id.hot_topic_title)).setText(aVar.b);
        view.setOnClickListener(new b(this, aVar));
        return true;
    }

    protected final void a(JSONArray jSONArray) {
        b(jSONArray);
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.b)) {
            Map hashMap = new HashMap();
            hashMap.put("tag", URLEncoder.encode(aVar.b));
            com.xunlei.downloadprovider.ad.home.a.a("android_find", "find_tag_click", hashMap);
        }
    }
}
