package com.xunlei.downloadprovider.download.tasklist.list.feed.d;

import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.feed.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.c;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.n;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TaskListFeedNetworkResponse */
public final class d {
    public int a;
    public String b;
    List<e> c;
    private String d;
    private long e;
    private JSONObject f;

    public final boolean a() {
        if (TextUtils.isEmpty(this.d)) {
            return false;
        }
        return ITagManager.SUCCESS.endsWith(this.d);
    }

    public static d a(JSONObject jSONObject) throws JSONException {
        d dVar = new d();
        dVar.f = jSONObject;
        dVar.d = jSONObject.getString("result");
        dVar.e = jSONObject.optLong(MsgConstant.KEY_TS);
        JSONArray optJSONArray = jSONObject.optJSONArray("card_list");
        dVar.a = jSONObject.optInt("toutiao_ret");
        dVar.b = jSONObject.optString("toutiao_message");
        if (dVar.a == 1) {
            a.a().b(null);
        }
        jSONObject = null;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            List arrayList = new ArrayList();
            JSONObject jSONObject2 = null;
            while (jSONObject < optJSONArray.length()) {
                try {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(jSONObject);
                    CharSequence string = jSONObject3.getString(PushResult.RES_TYPE);
                    if (!TextUtils.isEmpty(string)) {
                        com.xunlei.downloadprovider.homepage.choiceness.a.a.e a;
                        Object eVar;
                        if (!"toutiao_cell".equals(string)) {
                            if (!"toutiao_ad".equals(string)) {
                                if ("short_video".equals(string)) {
                                    a = m.a(jSONObject3);
                                    eVar = a.k == 7 ? new e(306, a, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a()) : new e(305, a, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a());
                                } else if ("website".equals(string)) {
                                    a = n.a(jSONObject3);
                                    eVar = new e(308, a, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a());
                                } else if ("photo_article".equals(string)) {
                                    a = c.a(jSONObject3);
                                    eVar = (a == null || ((c) a).a == null) ? null : a.k == 41 ? new e(SecExceptionCode.SEC_ERROR_STA_INVALID_ENCRYPTED_DATA, a, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a()) : (a.k != 42 || ((c) a).a.e.size() < 3) ? new e(309, a, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a()) : new e(SecExceptionCode.SEC_ERROR_STA_DECRYPT_MISMATCH_KEY_DATA, a, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a());
                                } else if ("advertisement".equals(string)) {
                                    j.a a2 = j.a(THUNDER_AD_INFO.DOWNLOAD_CENTER_FEED, jSONObject3.optJSONObject("res_info"));
                                    if (!(a2 == null || a2.b == null || !TextUtils.isEmpty(a2.b.H))) {
                                        a2.b.H = a2.f;
                                    }
                                    l a3 = com.xunlei.downloadprovider.ad.common.d.a(a2, THUNDER_AD_INFO.DOWNLOAD_CENTER_FEED);
                                    if (a3 != null) {
                                        eVar = new e(304, a3, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a());
                                        arrayList.add(eVar);
                                        a = null;
                                    }
                                } else {
                                    if ("baidu_cell".equals(string)) {
                                        JSONObject optJSONObject = jSONObject3.optJSONObject("res_info");
                                        if (optJSONObject != null) {
                                            com.xunlei.downloadprovider.homepage.choiceness.a.a.e a4 = com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a.a(optJSONObject.optString("data"));
                                            if (a4 != null) {
                                                a4.k = jSONObject3.optInt(PushResult.DISPLAY_TYPE);
                                            }
                                            jSONObject2 = 1;
                                            com.xunlei.downloadprovider.homepage.choiceness.a.a.e eVar2 = a4;
                                            eVar = com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a.a((com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a) a4);
                                            a = eVar2;
                                        }
                                    }
                                    a = null;
                                    eVar = a;
                                }
                                if (a == null) {
                                    if (!com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a(a.k)) {
                                        arrayList.add(eVar);
                                    }
                                }
                            }
                        }
                        a = com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.a.a(jSONObject3);
                        eVar = com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.a.a((com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.a) a);
                        if (a == null) {
                            if (!com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a(a.k)) {
                                arrayList.add(eVar);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONObject++;
            }
            dVar.c = arrayList;
            jSONObject = jSONObject2;
        }
        if (jSONObject != null) {
            jSONObject = b.a();
            com.xunlei.downloadprovider.ad.downloadlist.c.a();
            int i = com.xunlei.downloadprovider.ad.downloadlist.c.c;
            jSONObject.a.put(Integer.valueOf(i), Integer.valueOf(jSONObject.a(i) + 1));
        }
        return dVar;
    }
}
