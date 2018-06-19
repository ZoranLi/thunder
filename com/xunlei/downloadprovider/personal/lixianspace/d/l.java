package com.xunlei.downloadprovider.personal.lixianspace.d;

import android.net.Uri;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GetLXTaskDownloadUrlRequest */
public final class l extends a {
    public l(Object obj) {
        super(obj, IMethod.POST, "http://download.lixian.vip.xunlei.com/resource/dllink");
    }

    public final void a(d dVar, String str, int... iArr) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            if (iArr == null || iArr.length <= 0) {
                jSONArray.put(0);
            } else {
                int length = iArr.length;
                while (i < length) {
                    jSONArray.put((long) iArr[i]);
                    i++;
                }
            }
            jSONObject.put("fileindexs", jSONArray);
            jSONObject.put("url", Uri.encode(str, "-![.:/,%?&=@|]"));
            a(jSONObject, dVar);
        } catch (d dVar2) {
            dVar2.printStackTrace();
        }
    }
}
