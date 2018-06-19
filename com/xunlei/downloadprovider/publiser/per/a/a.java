package com.xunlei.downloadprovider.publiser.per.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.per.model.PersonalFeedInfo;
import java.util.List;
import org.json.JSONObject;

/* compiled from: PublishNetworkHelper */
public class a extends e {
    private static final String a = "a";

    public final void a(long j, long j2, e$d<Integer, List<PersonalFeedInfo>> com_xunlei_downloadprovider_member_payment_a_e_d_java_lang_Integer__java_util_List_com_xunlei_downloadprovider_publiser_per_model_PersonalFeedInfo) {
        XLThreadPool.execute(new b(this, j, j2, com_xunlei_downloadprovider_member_payment_a_e_d_java_lang_Integer__java_util_List_com_xunlei_downloadprovider_publiser_per_model_PersonalFeedInfo));
    }

    private static JSONObject c(long j, long j2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userid", j);
            jSONObject.put("cursor", j2);
            jSONObject.put("size", i);
        } catch (long j3) {
            j3.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject d(long j, long j2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userid", j);
            jSONObject.put("cursor", j2);
            jSONObject.put("size", i);
        } catch (long j3) {
            j3.printStackTrace();
        }
        return jSONObject;
    }

    protected final void a(Request<?> request) {
        request.setTag(a);
        request.setRetryPolicy(new d(10000, 1, 1.0f));
        super.a(request);
    }

    public final void a(Object obj) {
        super.a(a);
    }
}
