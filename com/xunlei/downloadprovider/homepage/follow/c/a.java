package com.xunlei.downloadprovider.homepage.follow.c;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e$f;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;
import org.json.JSONArray;

/* compiled from: FollowNetworkHelper */
public final class a extends e {
    public final <T> void a(List<T> list, c<List<T>> cVar) {
        JSONArray jSONArray = new JSONArray();
        for (Object next : list) {
            if (next instanceof Long) {
                jSONArray.put(next);
            } else if (next instanceof com.xunlei.downloadprovider.homepage.follow.b.a) {
                jSONArray.put(((com.xunlei.downloadprovider.homepage.follow.b.a) next).b);
            } else {
                cVar.onFail("传入参数错误");
                return;
            }
        }
        XLThreadPool.execute(new w(this, jSONArray, cVar, list));
    }

    public final void b(List<Long> list, c<List<Long>> cVar) {
        a((List) list, (c) cVar);
    }

    public final void a(int i, String str, e$f<Integer, List<com.xunlei.downloadprovider.homepage.follow.b.a>, String, Boolean> com_xunlei_downloadprovider_member_payment_a_e_f_java_lang_Integer__java_util_List_com_xunlei_downloadprovider_homepage_follow_b_a__java_lang_String__java_lang_Boolean) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/follow/follow_list_v3");
        stringBuilder.append("?size=");
        stringBuilder.append(i);
        stringBuilder.append("&cursor=");
        stringBuilder.append(str);
        XLThreadPool.execute(new af(this, stringBuilder, com_xunlei_downloadprovider_member_payment_a_e_f_java_lang_Integer__java_util_List_com_xunlei_downloadprovider_homepage_follow_b_a__java_lang_String__java_lang_Boolean));
    }
}
