package com.xunlei.downloadprovider.personal.lixianspace.business;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xunlei.downloadprovider.personal.lixianspace.b.s;
import com.xunlei.downloadprovider.personal.lixianspace.d.a;
import com.xunlei.downloadprovider.personal.lixianspace.d.e;
import com.xunlei.downloadprovider.personal.lixianspace.d.n;
import com.xunlei.xllib.b.d;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LXSpaceTaskStateMgr */
final class f extends Handler {
    final /* synthetic */ c a;

    f(c cVar, Looper looper) {
        this.a = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            if (this.a.b.isEmpty() == null) {
                message = "lx_tag:default";
                Set<Long> set = this.a.b;
                if (!d.a(set)) {
                    long[] jArr = new long[set.size()];
                    int i = 0;
                    int i2 = 0;
                    for (Long longValue : set) {
                        jArr[i2] = longValue.longValue();
                        i2++;
                    }
                    a nVar = new n(message);
                    message = new s();
                    if (jArr.length > 0) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            int length = jArr.length;
                            while (i < length) {
                                jSONArray.put(jArr[i]);
                                i++;
                            }
                            jSONObject.put(AgooConstants.MESSAGE_TASK_ID, jSONArray);
                            new StringBuilder("GetLXTaskStateRequest==").append(jSONObject.toString());
                            nVar.a(jSONObject, new com.xunlei.downloadprovider.personal.lixianspace.d.d(nVar, message), new e(nVar, message));
                        } catch (Message message2) {
                            message2.printStackTrace();
                        }
                    }
                }
            }
            this.a.a.sendEmptyMessageDelayed(1, this.a.c);
        }
    }
}
