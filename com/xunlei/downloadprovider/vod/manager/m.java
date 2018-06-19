package com.xunlei.downloadprovider.vod.manager;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: VideoPublishManager */
public final class m implements c<String> {
    final /* synthetic */ e$d a;
    final /* synthetic */ j b;

    public m(j jVar, e$d com_xunlei_downloadprovider_member_payment_a_e_d) {
        this.b = jVar;
        this.a = com_xunlei_downloadprovider_member_payment_a_e_d;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            try {
                obj = new JSONObject(str).optJSONArray("data");
                if (obj != null && obj.length() > 0) {
                    CharSequence optString = obj.getJSONObject(0).optString("gcid");
                    obj = obj.getJSONObject(0).optString("uploadToken");
                    j.b;
                    j.b;
                    j.b;
                    if (!(TextUtils.isEmpty(optString) || TextUtils.isEmpty(obj))) {
                        if (this.a != null) {
                            this.a.a(optString, obj);
                        }
                        return;
                    }
                }
            } catch (Object obj2) {
                j.b;
                new StringBuilder().append(obj2.getMessage());
            }
        }
        if (this.a != null) {
            this.a.a("requestToken error");
        }
    }

    public final void onFail(String str) {
        if (this.a != null) {
            e$d com_xunlei_downloadprovider_member_payment_a_e_d = this.a;
            StringBuilder stringBuilder = new StringBuilder("requestToken onFail : ");
            stringBuilder.append(str);
            com_xunlei_downloadprovider_member_payment_a_e_d.a(stringBuilder.toString());
        }
    }
}
