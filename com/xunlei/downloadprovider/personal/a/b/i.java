package com.xunlei.downloadprovider.personal.a.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: UserGridOverWriteMgr */
public final class i {
    public Map<String, List<b>> a;

    /* compiled from: UserGridOverWriteMgr */
    private static class a {
        private static final i a = new i();
    }

    private i() {
        this.a = new HashMap();
    }

    final void a(h hVar, JSONObject jSONObject) {
        if (!(TextUtils.isEmpty(hVar.c) || jSONObject == null)) {
            if (jSONObject.length() > 0) {
                String str = hVar.c;
                Collection arrayList = new ArrayList(jSONObject.length());
                b bVar = new b(MessageInfo.ORIGINAL, (byte) 0);
                bVar.a = hVar.d;
                bVar.b = hVar.e;
                bVar.c = hVar.f;
                bVar.d = hVar.k;
                bVar.e = hVar.l;
                bVar.f = hVar.m;
                arrayList.add(bVar);
                try {
                    hVar = jSONObject.keys();
                    while (hVar.hasNext()) {
                        byte b;
                        b bVar2;
                        JSONObject jSONObject2;
                        String str2 = (String) hVar.next();
                        boolean z = true;
                        if (!(TextUtils.equals("new_user", str2) || TextUtils.equals("member_user", str2))) {
                            if (!TextUtils.equals("expried_member_user", str2)) {
                                b = (byte) 0;
                                if (b != (byte) 0) {
                                    bVar2 = new b(str2, (byte) 0);
                                    jSONObject2 = jSONObject.getJSONObject(str2);
                                    bVar2.a = jSONObject2.optString("icon_title");
                                    bVar2.b = jSONObject2.optString("icon_desc");
                                    bVar2.c = jSONObject2.optString("icon_url");
                                    jSONObject2 = jSONObject2.optJSONObject("redot");
                                    if (jSONObject2 != null) {
                                        z = false;
                                    }
                                    bVar2.g = z;
                                    if (jSONObject2 != null) {
                                        bVar2.d = jSONObject2.optInt("enable");
                                        bVar2.e = jSONObject2.optString("start_time");
                                        bVar2.f = jSONObject2.optString("end_time");
                                    }
                                    arrayList.add(bVar2);
                                }
                            }
                        }
                        b = true;
                        if (b != (byte) 0) {
                            bVar2 = new b(str2, (byte) 0);
                            jSONObject2 = jSONObject.getJSONObject(str2);
                            bVar2.a = jSONObject2.optString("icon_title");
                            bVar2.b = jSONObject2.optString("icon_desc");
                            bVar2.c = jSONObject2.optString("icon_url");
                            jSONObject2 = jSONObject2.optJSONObject("redot");
                            if (jSONObject2 != null) {
                                z = false;
                            }
                            bVar2.g = z;
                            if (jSONObject2 != null) {
                                bVar2.d = jSONObject2.optInt("enable");
                                bVar2.e = jSONObject2.optString("start_time");
                                bVar2.f = jSONObject2.optString("end_time");
                            }
                            arrayList.add(bVar2);
                        }
                    }
                    if (d.a(arrayList) == null) {
                        if (this.a.containsKey(str) == null) {
                            this.a.put(str, new ArrayList());
                        } else {
                            ((List) this.a.get(str)).clear();
                        }
                        ((List) this.a.get(str)).addAll(arrayList);
                    }
                } catch (h hVar2) {
                    hVar2.printStackTrace();
                }
            }
        }
    }
}
