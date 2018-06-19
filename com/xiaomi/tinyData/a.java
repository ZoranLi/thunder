package com.xiaomi.tinyData;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.service.XMPushService.k;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.be;
import com.xiaomi.xmpush.thrift.f;
import com.xiaomi.xmpush.thrift.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a implements k {
    private Context a;
    private boolean b;
    private int c;

    public a(Context context) {
        this.a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private HashMap<String, ArrayList<f>> a(List<f> list) {
        if (list != null) {
            if (list.size() != 0) {
                HashMap<String, ArrayList<f>> hashMap = new HashMap();
                for (f fVar : list) {
                    a(fVar);
                    ArrayList arrayList = (ArrayList) hashMap.get(fVar.k());
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        hashMap.put(fVar.k(), arrayList);
                    }
                    arrayList.add(fVar);
                }
                return hashMap;
            }
        }
        return null;
    }

    private void a(Context context) {
        this.b = am.a(context).a(g.aj.a(), true);
        this.c = am.a(context).a(g.ak.a(), 7200);
        this.c = Math.max(60, this.c);
    }

    private void a(c cVar, ArrayList<f> arrayList, String str) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder("A tinyData is uploaded immediately for ");
            stringBuilder.append(((f) arrayList.get(0)).d());
            b.c(stringBuilder.toString());
            cVar.a(arrayList, ((f) arrayList.get(0)).p(), str);
        }
    }

    private void a(f fVar) {
        if (fVar.f) {
            fVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(fVar.m())) {
            fVar.f(be.a());
        }
        fVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(fVar.p())) {
            fVar.e(this.a.getPackageName());
        }
        if (TextUtils.isEmpty(fVar.k())) {
            fVar.e(fVar.p());
        }
    }

    private boolean a(c cVar) {
        if (!d.c(this.a) || cVar == null || TextUtils.isEmpty(a(this.a.getPackageName()))) {
            return false;
        }
        if (new File(this.a.getFilesDir(), "tiny_data.data").exists()) {
            return true;
        }
        b.a("TinyData(TinyDataCacheUploader) no ready file to get data.");
        return false;
    }

    private boolean b() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.a.getSharedPreferences("mipush_extra", 0).getLong("last_tiny_data_upload_timestamp", -1)) > ((long) this.c);
    }

    private void c() {
        Editor edit = this.a.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    public void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.a;
        r4.a(r0);
        r0 = r4.b;
        if (r0 == 0) goto L_0x005b;
    L_0x0009:
        r0 = r4.b();
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return;
    L_0x0010:
        r0 = r4.a;
        r0 = com.xiaomi.tinyData.b.a(r0);
        r0 = r0.a();
        r1 = r4.a(r0);
        if (r1 != 0) goto L_0x0021;
    L_0x0020:
        return;
    L_0x0021:
        r1 = r4.a;
        r1 = com.xiaomi.push.service.bf.a(r1);
        r1 = r4.a(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x002d:
        r2 = r1.size();
        if (r2 != 0) goto L_0x0034;
    L_0x0033:
        return;
    L_0x0034:
        r1 = r1.entrySet();
        r1 = r1.iterator();
    L_0x003c:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0058;
    L_0x0042:
        r2 = r1.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getValue();	 Catch:{ Exception -> 0x003c }
        r3 = (java.util.ArrayList) r3;	 Catch:{ Exception -> 0x003c }
        r2 = r2.getKey();	 Catch:{ Exception -> 0x003c }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x003c }
        r4.a(r0, r3, r2);	 Catch:{ Exception -> 0x003c }
        goto L_0x003c;
    L_0x0058:
        r4.c();
    L_0x005b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.tinyData.a.a():void");
    }
}
