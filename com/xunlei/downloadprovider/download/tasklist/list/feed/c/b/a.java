package com.xunlei.downloadprovider.download.tasklist.list.feed.c.b;

import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.feed.d.b;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import java.util.Collections;
import org.json.JSONObject;

/* compiled from: TaskListFeedTouTiaoInfo */
public final class a extends com.xunlei.downloadprovider.download.tasklist.list.feed.c.a {
    public b a = null;
    private String b = null;

    public static a a(JSONObject jSONObject) {
        b bVar;
        if (jSONObject == null) {
            return null;
        }
        com.xunlei.downloadprovider.homepage.choiceness.a.a.a aVar = new a();
        int optInt = jSONObject.optInt(PushResult.DISPLAY_TYPE);
        aVar.b = jSONObject.optString("res_from");
        jSONObject = jSONObject.optJSONObject("res_info");
        if (jSONObject == null) {
            bVar = null;
        } else {
            bVar = new b();
            bVar.a = jSONObject.optLong(Impl.COLUMN_GROUP_ID);
            bVar.c = jSONObject.optString("tag");
            bVar.d = jSONObject.optString("title");
            bVar.e = jSONObject.optString("abstract");
            bVar.f = jSONObject.optString("source");
            bVar.g = jSONObject.optString("article_url");
            bVar.h = jSONObject.optLong("publish_time");
            bVar.i = jSONObject.optLong("behot_time");
            b.a(bVar.i);
            bVar.j = jSONObject.optString("share_url");
            bVar.p = jSONObject.optLong("comment_count");
            bVar.b = jSONObject.optString(PushResult.VIDEO_ID);
            boolean z = false;
            bVar.k = jSONObject.optBoolean("has_video", false);
            if (bVar.k) {
                bVar.l = jSONObject.optLong("video_watch_count");
                bVar.m = jSONObject.optLong("video_duration");
            }
            bVar.q = 0;
            bVar.r = com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b.a.a(jSONObject.optJSONArray("large_image_list"));
            if (bVar.r != null) {
                bVar.q = 1;
            } else {
                bVar.r = com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b.a.a(jSONObject.optJSONArray("image_list"));
                if (bVar.r == null || bVar.r.size() != 3) {
                    com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b.a a = com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b.a.a(jSONObject.optJSONObject("middle_image"));
                    if (a != null) {
                        bVar.r = Collections.singletonList(a);
                        bVar.q = 3;
                    }
                } else {
                    bVar.q = 2;
                }
            }
            bVar.n = jSONObject.optLong("ad_id", 0);
            if (bVar.n != 0) {
                z = true;
            }
            bVar.o = z;
            try {
                bVar.s = new JSONObject(jSONObject.optString("log_extra", "{}"));
            } catch (JSONObject jSONObject2) {
                bVar.s = new JSONObject();
                jSONObject2.printStackTrace();
            }
            new StringBuilder("parse success. toutiaoInfo: ").append(bVar);
        }
        if (bVar == null) {
            return null;
        }
        aVar.a = bVar;
        jSONObject2 = new StringBuilder("toutiao_");
        jSONObject2.append(bVar.a);
        aVar.i = jSONObject2.toString();
        aVar.k = optInt;
        return aVar;
    }

    public static e a(a aVar) {
        e eVar = null;
        if (aVar == null) {
            return null;
        }
        switch (aVar.a.q) {
            case 1:
                eVar = new e(300, aVar, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a());
                break;
            case 2:
                eVar = new e(301, aVar, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a());
                break;
            case 3:
                eVar = new e(302, aVar, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a());
                break;
            default:
                break;
        }
        return eVar;
    }

    public final boolean c() {
        return this.a != null && this.a.o;
    }

    public final boolean d() {
        if (c()) {
            return true;
        }
        return super.d();
    }

    public final boolean e() {
        return (this.a == null || !this.a.k) ? super.e() : true;
    }
}
