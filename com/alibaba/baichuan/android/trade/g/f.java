package com.alibaba.baichuan.android.trade.g;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.b.a;
import com.alibaba.baichuan.android.trade.callback.b;
import com.alibaba.baichuan.android.trade.d.d;
import com.alibaba.baichuan.android.trade.f.c;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.alibaba.baichuan.android.trade.model.ApplinkOpenType;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f extends b {
    public Map b;

    public f(String str) {
        this.a = str;
    }

    private boolean i() {
        if (this.a != null) {
            for (String matches : AlibcContext.k) {
                if (this.a.trim().matches(matches)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a() {
        return (getClass().getSuperclass() != null && getClass().getSuperclass().getName().equals(f.class.getName())) || this.a != null;
    }

    public final boolean a(AlibcTaokeParams alibcTaokeParams) {
        return i() && alibcTaokeParams != null;
    }

    public final String b() {
        return c.j;
    }

    public final String c() {
        return URLUtil.isNetworkUrl(this.a) ? this.a.trim() : null;
    }

    public final Map h() {
        return this.b;
    }

    public final void a(AlibcTaokeParams alibcTaokeParams, a aVar, b bVar) {
        if (!TextUtils.isEmpty(this.a)) {
            int i = -1;
            if (!TextUtils.isEmpty(this.a)) {
                for (String matches : AlibcContext.k) {
                    if (this.a.matches(matches)) {
                        i = 1;
                    }
                }
                if (1 == i) {
                    Matcher matcher = Pattern.compile("(\\?|&)id=([^&?]*)").matcher(this.a);
                    Object obj = null;
                    if (matcher.find()) {
                        String group = matcher.group();
                        obj = group.substring(group.indexOf(61) + 1);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("itemId", obj);
                    if (aVar.e != null) {
                        com.alibaba.baichuan.android.trade.d.b.a.a(hashMap, c(), true, alibcTaokeParams, c.j, aVar, bVar, aVar.e);
                    }
                }
            }
        }
    }

    public final boolean a(AlibcTaokeParams alibcTaokeParams, com.alibaba.baichuan.android.trade.model.a aVar, Map map, Activity activity) {
        if (i()) {
            String substring;
            Matcher matcher = Pattern.compile("(\\?|&)id=([^&?]*)").matcher(this.a);
            String str = null;
            if (matcher.find()) {
                String group = matcher.group();
                substring = group.substring(group.indexOf(61) + 1);
            } else {
                substring = null;
            }
            if (alibcTaokeParams != null) {
                str = alibcTaokeParams.pid;
            }
            String str2 = str;
            if (aVar == null || TextUtils.isEmpty(aVar.b) != null) {
                alibcTaokeParams = "alisdk://";
            } else {
                alibcTaokeParams = aVar.b;
            }
            AlibcTaokeParams alibcTaokeParams2 = alibcTaokeParams;
            alibcTaokeParams = "";
            if (aVar != null) {
                alibcTaokeParams = aVar.c;
            }
            map.put("appType", alibcTaokeParams);
            return d.a(activity, ApplinkOpenType.SHOWITEM, null, substring, com.alibaba.baichuan.android.trade.e.a.g().f(), str2, alibcTaokeParams2, map);
        }
        Object obj = "";
        if (aVar != null) {
            obj = aVar.c;
        }
        map.put("appType", obj);
        return super.a(alibcTaokeParams, aVar, map, activity);
    }
}
