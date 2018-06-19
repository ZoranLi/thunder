package com.xunlei.downloadprovider.publiser.websitetopic.c;

import com.xunlei.downloadprovider.member.payment.a.e;

/* compiled from: WebsiteTopicNetworkHelper */
public final class d extends e {
    static /* synthetic */ String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/fav_site/api/topic_site_list?cursor=");
        stringBuilder.append(str);
        stringBuilder.append("&id=");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
