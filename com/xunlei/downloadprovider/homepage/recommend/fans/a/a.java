package com.xunlei.downloadprovider.homepage.recommend.fans.a;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.a.e$e;
import java.util.List;

/* compiled from: FansAndFollowNetWork */
public class a extends com.xunlei.downloadprovider.personal.message.data.a {
    private static final String a = "a";

    public final void a(long j, long j2, String str, e$e<List<com.xunlei.downloadprovider.homepage.follow.b.a>, String, Boolean> com_xunlei_downloadprovider_member_payment_a_e_e_java_util_List_com_xunlei_downloadprovider_homepage_follow_b_a__java_lang_String__java_lang_Boolean) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/follow/fans_list_v3");
        stringBuilder.append("?uid=");
        stringBuilder.append(j);
        stringBuilder.append("&size=");
        stringBuilder.append(j2);
        stringBuilder.append("&cursor=");
        stringBuilder.append(str);
        new StringBuilder("getHotCampaignList url=").append(stringBuilder.toString());
        XLThreadPool.execute(new b(this, stringBuilder, com_xunlei_downloadprovider_member_payment_a_e_e_java_util_List_com_xunlei_downloadprovider_homepage_follow_b_a__java_lang_String__java_lang_Boolean));
    }
}
