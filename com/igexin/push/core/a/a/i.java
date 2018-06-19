package com.igexin.push.core.a.a;

import com.igexin.b.a.b.c;
import com.igexin.b.a.c.a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.l;
import com.igexin.push.config.m;
import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.f;
import com.igexin.push.core.c.j;
import com.igexin.push.core.g;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class i implements a {
    private static final String a = l.a;

    public b a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return b.success;
    }

    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new com.igexin.push.core.bean.BaseAction;	 Catch:{ JSONException -> 0x001d }
        r0.<init>();	 Catch:{ JSONException -> 0x001d }
        r1 = "reportext";	 Catch:{ JSONException -> 0x001d }
        r0.setType(r1);	 Catch:{ JSONException -> 0x001d }
        r1 = "actionid";	 Catch:{ JSONException -> 0x001d }
        r1 = r3.getString(r1);	 Catch:{ JSONException -> 0x001d }
        r0.setActionId(r1);	 Catch:{ JSONException -> 0x001d }
        r1 = "do";	 Catch:{ JSONException -> 0x001d }
        r3 = r3.getString(r1);	 Catch:{ JSONException -> 0x001d }
        r0.setDoActionId(r3);	 Catch:{ JSONException -> 0x001d }
        return r0;
    L_0x001d:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.i.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (!(pushTaskBean == null || baseAction == null || m.s == null || m.s.b() == null || m.s.b().isEmpty())) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2;
            try {
                File[] listFiles = new File(g.ac).listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return true;
                }
                Map b = m.s.b();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a);
                stringBuilder3.append("|DynamicConfig.extInfos");
                a.b(stringBuilder3.toString());
                Iterator it = b.entrySet().iterator();
                boolean z = true;
                while (true) {
                    int i = 0;
                    if (!it.hasNext()) {
                        break;
                    }
                    Entry entry = (Entry) it.next();
                    int intValue = ((Integer) entry.getKey()).intValue();
                    f fVar = (f) entry.getValue();
                    if (z) {
                        stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
                        stringBuilder.append("|");
                        stringBuilder.append(g.r);
                        stringBuilder.append("|");
                        stringBuilder.append(g.a);
                        stringBuilder.append("|");
                        stringBuilder.append(g.N);
                        stringBuilder.append("|");
                        z = false;
                    }
                    while (i < listFiles.length) {
                        if (listFiles[i].getName().equals(fVar.c())) {
                            stringBuilder.append(intValue);
                            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            stringBuilder.append(fVar.b());
                            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            stringBuilder.append(fVar.c());
                            stringBuilder.append("|");
                        }
                        i++;
                    }
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append("check ext data : ");
                stringBuilder2.append(stringBuilder.toString());
                a.b(stringBuilder2.toString());
                if (stringBuilder.length() > 0) {
                    c.b().a(new com.igexin.push.f.a.c(new j(SDKUrlConfig.getStatServiceUrl(), stringBuilder.toString().getBytes(), 17)), false, true);
                    return true;
                }
            } catch (Exception e) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append(" | ");
                stringBuilder2.append(e.toString());
                a.b(stringBuilder2.toString());
            }
        }
        return true;
    }
}
