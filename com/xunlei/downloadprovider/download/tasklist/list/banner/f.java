package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BannerOnlineServerHelper */
final class f implements b<JSONObject> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        boolean z = true;
        this.a.a.hasRequestRedList = true;
        DownloadTaskInfo downloadTaskInfo = this.a.a;
        RedPacketConditionsInfo redPacketConditionsInfo = this.a.b;
        a aVar = this.a.c;
        List arrayList = new ArrayList();
        try {
            if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
                obj = jSONObject.getJSONArray("list");
                if (obj.length() <= 0) {
                    aVar.a();
                    return;
                }
                int i = 0;
                for (int i2 = 0; i2 < obj.length(); i2++) {
                    arrayList.add((Integer) obj.get(i2));
                }
                if (arrayList.size() <= null) {
                    aVar.a();
                    return;
                }
                long b;
                obj = redPacketConditionsInfo.redpack_type;
                boolean contains = obj.contains("7");
                LoginHelper.a();
                if (l.c()) {
                    LoginHelper.a();
                    if (l.b()) {
                        while (i < obj.size()) {
                            if (arrayList.contains(Integer.valueOf(Integer.parseInt((String) obj.get(i))))) {
                                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                                b = com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.b();
                                if (b < 10) {
                                    if (contains || !r1) {
                                        aVar.a(downloadTaskInfo, redPacketConditionsInfo, b);
                                        return;
                                    } else {
                                        a.a(downloadTaskInfo, redPacketConditionsInfo, b, false, aVar);
                                        return;
                                    }
                                }
                            }
                            i++;
                        }
                        aVar.a();
                    }
                }
                z = false;
                while (i < obj.size()) {
                    if (arrayList.contains(Integer.valueOf(Integer.parseInt((String) obj.get(i))))) {
                        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                        b = com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.b();
                        if (b < 10) {
                            if (contains) {
                            }
                            aVar.a(downloadTaskInfo, redPacketConditionsInfo, b);
                            return;
                        }
                    }
                    i++;
                }
                aVar.a();
            }
        } catch (Object obj2) {
            aVar.a();
            obj2.printStackTrace();
        }
    }
}
