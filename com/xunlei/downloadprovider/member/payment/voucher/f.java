package com.xunlei.downloadprovider.member.payment.voucher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ThunderVoucherProcessor */
final class f implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ e b;

    f(e eVar, JSONObject jSONObject) {
        this.b = eVar;
        this.a = jSONObject;
    }

    public final void run() {
        try {
            if (this.a.getInt("result") != 0) {
                d.a(this.b.b, this.b.a, false);
                return;
            }
            synchronized (this.b.b.d) {
                JSONObject jSONObject = this.a.getJSONObject("data");
                if (this.b.b.a.containsKey(this.b.a)) {
                    ((List) this.b.b.a.get(this.b.a)).clear();
                } else {
                    this.b.b.a.put(this.b.a, new ArrayList(8));
                }
                Iterator keys = jSONObject.keys();
                Collection arrayList = new ArrayList();
                while (keys.hasNext()) {
                    Voucher a = Voucher.a(jSONObject.getJSONObject((String) keys.next()));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                Collections.sort(arrayList);
                ((List) this.b.b.a.get(this.b.a)).addAll(arrayList);
                d.a(this.b.b, this.b.a, true);
            }
        } catch (Exception e) {
            d.a(this.b.b, this.b.a, false);
            new StringBuilder("get voucher list response invalid = ").append(e.toString());
        }
    }
}
