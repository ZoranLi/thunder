package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import com.xunlei.downloadprovider.member.payment.network.b;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DelLXTaskRequest */
public final class i extends a {
    public i(Object obj) {
        super(obj, IMethod.POST, "http://download.lixian.vip.xunlei.com/task/delete");
    }

    public final void a(b bVar, long... jArr) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i <= 0; i++) {
                jSONArray.put(jArr[0]);
            }
            jSONObject.put(AgooConstants.MESSAGE_TASK_ID, jSONArray);
            new StringBuilder("DelLXTaskRequest==").append(jSONObject.toString());
            a(jSONObject, new f(this, bVar), new g(this, bVar));
        } catch (b bVar2) {
            bVar2.printStackTrace();
        }
    }
}
