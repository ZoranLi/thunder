package com.xunlei.downloadprovider.publiser.campaign.a;

import android.text.TextUtils;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.personal.message.data.a;
import com.xunlei.downloadprovider.publiser.campaign.m;
import com.xunlei.xllib.b.k;

/* compiled from: TopicNetWork */
public class e extends a {
    private static final String a = "e";

    public final void a(int i, String str, String str2, boolean z, c cVar, m mVar) {
        a(a(i, str, str2, false), new f(this, str2, cVar, z, mVar), new g(this, cVar, z, mVar));
    }

    public final void b(int i, String str, String str2, boolean z, c cVar, m mVar) {
        a(a(i, str, str2, true), new h(this, str2, cVar, z, mVar), new i(this, cVar, z, mVar));
    }

    private static String a(int i, String str, String str2, boolean z) {
        StringBuilder stringBuilder;
        if (i == 2) {
            stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/suite/audio_list?");
        } else if (i == 3) {
            stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/suite/location_list?");
        } else {
            stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/ivideo_v4/topic_list?");
        }
        stringBuilder.append("peerid=");
        stringBuilder.append(AndroidConfig.getPeerid());
        stringBuilder.append("&size=8");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append("&cursor=");
            stringBuilder.append(k.c(str, "UTF-8"));
        }
        if (i == 2) {
            stringBuilder.append("&audio_id=");
            stringBuilder.append(str2);
        } else if (i == 3) {
            stringBuilder.append("&code=");
            stringBuilder.append(str2);
        } else {
            stringBuilder.append("&tag=");
            stringBuilder.append(k.c(str2, "UTF-8"));
        }
        stringBuilder.append("&category=");
        stringBuilder.append(z ? "new" : "hot");
        return stringBuilder.toString();
    }
}
