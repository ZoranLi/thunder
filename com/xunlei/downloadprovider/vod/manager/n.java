package com.xunlei.downloadprovider.vod.manager;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.a.e$b;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: VideoPublishManager */
final class n implements c<String> {
    final /* synthetic */ e$b a;
    final /* synthetic */ j b;

    n(j jVar, e$b com_xunlei_downloadprovider_member_payment_a_e_b) {
        this.b = jVar;
        this.a = com_xunlei_downloadprovider_member_payment_a_e_b;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (new JSONObject(str).optInt("result", -1) == null) {
                    if (this.a != null) {
                        this.a.a();
                        return;
                    }
                } else if (this.a != null) {
                    j.b;
                    this.a.a(j.f);
                }
                return;
            } catch (Object obj2) {
                j.b;
                new StringBuilder("commitUpload onSuccess exception : ").append(obj2.getMessage());
            }
        }
        if (this.a != null) {
            j.b;
            this.a.a(j.f);
        }
    }

    public final void onFail(String str) {
        if (this.a != null) {
            j.b;
            this.a.a(j.f);
        }
    }
}
