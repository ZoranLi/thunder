package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import android.text.TextUtils;
import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: FreeTrialRedPacketHelper */
final class j implements b<String> {
    final /* synthetic */ f a;

    j(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            try {
                int optInt = new JSONObject(str).optInt("result");
                f.a(this.a, str);
                f.c(this.a);
                if (optInt == -2) {
                    obj = this.a;
                    StringBuilder stringBuilder = new StringBuilder("state:");
                    stringBuilder.append(optInt);
                    f.c(obj, stringBuilder.toString());
                }
            } catch (Object obj2) {
                obj2.printStackTrace();
            }
        }
    }
}
