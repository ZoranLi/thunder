package com.xunlei.downloadprovider.personal.lixianspace.d;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONObject;

/* compiled from: GetLXBtTaskInfoRequest */
public final class k extends a {
    private k(Object obj) {
        IMethod iMethod = IMethod.POST;
        Builder buildUpon = Uri.parse("http://download.lixian.vip.xunlei.com/task/parse_bt").buildUpon();
        buildUpon.appendQueryParameter("bt_type", "0");
        super(obj, iMethod, buildUpon.build().toString());
    }

    public k(Object obj, byte b) {
        this(obj);
    }

    public final void a(@NonNull String str, d dVar) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("magnet", str);
                new StringBuilder("GetLXBtTaskInfoRequest==").append(jSONObject.toString());
                a(jSONObject, dVar);
            } catch (String str2) {
                str2.printStackTrace();
            }
        }
    }
}
