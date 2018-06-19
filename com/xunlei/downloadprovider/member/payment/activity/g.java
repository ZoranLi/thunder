package com.xunlei.downloadprovider.member.payment.activity;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.a;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: IActivityConfigImpl */
final class g extends e implements f {
    private Map<String, a> a;
    private String b;
    private ConcurrentHashMap<String, List<r>> c;
    private Handler d;
    private Comparator<a> f = new l(this);

    g() {
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        this.a = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(applicationInstance.getFilesDir().getPath());
        stringBuilder.append("/pay_activity.cfg");
        this.b = stringBuilder.toString();
        this.d = new Handler(Looper.getMainLooper());
    }

    private void d(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        a(jSONObject);
        b(jSONObject);
    }

    private void a(JSONObject jSONObject) throws Exception {
        this.a.clear();
        jSONObject = jSONObject.getJSONObject(SocialConstants.PARAM_ACT);
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 != null) {
                    a a = a.a(jSONObject2, str);
                    if (a != null) {
                        this.a.put(a.a, a);
                    }
                }
            }
        }
    }

    private void b(JSONObject jSONObject) throws Exception {
        this.c.clear();
        jSONObject = jSONObject.optJSONObject("referfrom");
        if (jSONObject != null && jSONObject.length() > 0) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONArray optJSONArray = jSONObject.optJSONObject(str).optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        r a = r.a(optJSONArray.optJSONObject(i));
                        if (a != null) {
                            a.a = str;
                            if (!this.c.containsKey(str)) {
                                this.c.put(str, new ArrayList());
                            }
                            ((List) this.c.get(str)).add(a);
                            Object obj = a.c;
                            if (!TextUtils.isEmpty(obj)) {
                                this.d.post(new k(this, obj));
                            }
                        }
                    }
                }
            }
        }
    }

    public final a a(String str) {
        if (!this.a.isEmpty()) {
            if (this.a.containsKey(str)) {
                return (a) this.a.get(str);
            }
        }
        return null;
    }

    public final List<a> b(String str) {
        List arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            for (a aVar : this.a.values()) {
                if (!(aVar == null || aVar.b() || !aVar.a())) {
                    arrayList.add(aVar);
                }
            }
            Collections.sort(arrayList, this.f);
        } else {
            Collection arrayList2 = new ArrayList();
            Collection arrayList3 = new ArrayList();
            for (a aVar2 : this.a.values()) {
                if (!(aVar2 == null || aVar2.b() || !aVar2.a())) {
                    if (TextUtils.isEmpty(aVar2.d) || !aVar2.d.contains(str)) {
                        arrayList3.add(aVar2);
                    } else {
                        arrayList2.add(aVar2);
                    }
                }
            }
            Collections.sort(arrayList2, this.f);
            Collections.sort(arrayList3, this.f);
            arrayList.addAll(arrayList2);
            arrayList.addAll(arrayList3);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final r c(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<r> list = (List) this.c.get(str);
            if (d.a(list)) {
                return null;
            }
            str = c.a().a(str, j.a().b() ? 204 : -1);
            if (str != null) {
                for (r rVar : list) {
                    if (rVar != null && !TextUtils.isEmpty(str.d()) && str.d().contains(rVar.a) && TextUtils.equals(rVar.e, str.c())) {
                        return rVar;
                    }
                }
            }
            for (r rVar2 : list) {
                if (TextUtils.isEmpty(rVar2.e)) {
                    Object obj;
                    if (!d.a(rVar2.f)) {
                        for (List a : rVar2.f) {
                            if (LimitCondition.a(a)) {
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            return rVar2;
                        }
                    }
                    obj = 1;
                    if (obj != null) {
                        return rVar2;
                    }
                }
            }
        }
        return null;
    }

    public final void a(boolean z) {
        if (!z) {
            if (!(Math.abs(System.currentTimeMillis() - new PreferenceHelper(BrothersApplication.getApplicationInstance(), "pf_configuration_param").getLong("pay:activity_save_time", 0)) >= 3600000)) {
                if (this.a.isEmpty()) {
                    try {
                        d(a.b("xlvip.payment.activity.config", com.xunlei.downloadprovider.h.e.a(this.b, "UTF-8").toString()));
                        return;
                    } catch (boolean z2) {
                        z2.printStackTrace();
                    }
                }
                return;
            }
        }
        this.a.clear();
        a("tag:activity_config_quest");
        z2 = new BaseJsonRequest(IMethod.GET, "http://act.vip.xunlei.com/source/config/slpay_v3.js");
        z2.a = "tag:activity_config_quest";
        z2.a(null, new h(this), new j(this));
    }

    static /* synthetic */ void b(g gVar, String str) throws Exception {
        com.xunlei.downloadprovider.h.e.b(gVar.b, a.a("xlvip.payment.activity.config", str));
        new PreferenceHelper(BrothersApplication.getApplicationInstance(), "pf_configuration_param").putLong("pay:activity_save_time", System.currentTimeMillis());
    }
}
