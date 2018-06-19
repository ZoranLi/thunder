package com.igexin.push.core.c;

import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.b.af;
import com.igexin.push.f.a.b;
import com.umeng.message.common.inter.ITagManager;
import java.util.ArrayList;
import org.json.JSONObject;

public class k extends b {
    public static final String a = "com.igexin.push.core.c.k";
    private String g;
    private ArrayList<com.igexin.push.core.bean.k> h;

    public k(byte[] bArr, String str, ArrayList<com.igexin.push.core.bean.k> arrayList) {
        super(SDKUrlConfig.getBiUploadServiceUrl());
        a(bArr, str, arrayList);
    }

    private void a(byte[] r3, java.lang.String r4, java.util.ArrayList<com.igexin.push.core.bean.k> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r2.g = r4;
        r2.h = r5;
        r5 = new org.json.JSONObject;
        r5.<init>();
        r0 = "action";	 Catch:{ Exception -> 0x0038 }
        r1 = "upload_BI";	 Catch:{ Exception -> 0x0038 }
        r5.put(r0, r1);	 Catch:{ Exception -> 0x0038 }
        r0 = "BIType";	 Catch:{ Exception -> 0x0038 }
        r5.put(r0, r4);	 Catch:{ Exception -> 0x0038 }
        r4 = "cid";	 Catch:{ Exception -> 0x0038 }
        r0 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0038 }
        r5.put(r4, r0);	 Catch:{ Exception -> 0x0038 }
        r4 = "BIData";	 Catch:{ Exception -> 0x0038 }
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0038 }
        r1 = 0;	 Catch:{ Exception -> 0x0038 }
        r3 = com.igexin.b.a.b.f.f(r3, r1);	 Catch:{ Exception -> 0x0038 }
        r1 = "UTF-8";	 Catch:{ Exception -> 0x0038 }
        r0.<init>(r3, r1);	 Catch:{ Exception -> 0x0038 }
        r5.put(r4, r0);	 Catch:{ Exception -> 0x0038 }
        r3 = r5.toString();	 Catch:{ Exception -> 0x0038 }
        r3 = r3.getBytes();	 Catch:{ Exception -> 0x0038 }
        r2.b(r3);	 Catch:{ Exception -> 0x0038 }
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.k.a(byte[], java.lang.String, java.util.ArrayList):void");
    }

    public void a(byte[] bArr) {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        if (jSONObject.has("result") && ITagManager.SUCCESS.equals(jSONObject.getString("result"))) {
            af.a().a(this.g, this.h);
        }
    }

    public int b() {
        return 0;
    }
}
