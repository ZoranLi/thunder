package com.xunlei.downloadprovider.personal.lixianspace.b;

import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.CollectState;
import com.xunlei.downloadprovider.personal.lixianspace.d.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LXSpaceRequestMgr */
final class n implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ Object b;
    final /* synthetic */ m c;

    n(m mVar, JSONObject jSONObject, Object obj) {
        this.c = mVar;
        this.a = jSONObject;
        this.b = obj;
    }

    public final void run() {
        String str;
        Exception e;
        String a = p.a(-20000);
        int i = 0;
        int i2;
        try {
            a.a.a(this.a);
            JSONArray optJSONArray = this.a.optJSONArray("tasks");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                i2 = -20000;
                str = a;
                if (i == 0) {
                    this.c.a(i2, str);
                }
            }
            JSONObject jSONObject = optJSONArray.getJSONObject(0);
            i2 = jSONObject.getInt("code");
            try {
                str = jSONObject.optString("hit");
                if (i2 == 0 || i2 == 241) {
                    try {
                        LXTaskInfo a2 = LXTaskInfo.a(jSONObject);
                        if (a2 != null) {
                            if (i2 != 241) {
                                if (a2.c < 100) {
                                    a2.i = CollectState.downloading;
                                    a.a.a(a2, 0, "");
                                    i = 1;
                                }
                            }
                            a2.j = true;
                            a2.i = CollectState.complete;
                            a.a.a(a2, 0, "");
                            i = 1;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (i == 0) {
                            this.c.a(i2, str);
                        }
                    }
                }
            } catch (Exception e3) {
                String str2 = a;
                e = e3;
                str = str2;
                e.printStackTrace();
                if (i == 0) {
                    this.c.a(i2, str);
                }
            }
            if (i == 0) {
                this.c.a(i2, str);
            }
        } catch (Exception e4) {
            i2 = -20000;
            str = a;
            e = e4;
            e.printStackTrace();
            if (i == 0) {
                this.c.a(i2, str);
            }
        }
    }
}
