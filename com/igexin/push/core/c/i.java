package com.igexin.push.core.c;

import android.content.ContentValues;
import com.igexin.push.core.b.g;
import com.igexin.push.core.f;
import com.igexin.push.f.a.b;
import com.igexin.push.util.e;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

public class i extends b {
    public boolean a;
    private boolean g = false;
    private int h;

    public i(String str, byte[] bArr, int i, boolean z) {
        super(str);
        this.g = z;
        this.h = i;
        a(bArr, i);
    }

    private void a(byte[] r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "action";	 Catch:{ Exception -> 0x0038 }
        r2 = "upload_BI";	 Catch:{ Exception -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0038 }
        r1 = "BIType";	 Catch:{ Exception -> 0x0038 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0038 }
        r0.put(r1, r5);	 Catch:{ Exception -> 0x0038 }
        r5 = "cid";	 Catch:{ Exception -> 0x0038 }
        r1 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0038 }
        r0.put(r5, r1);	 Catch:{ Exception -> 0x0038 }
        r5 = "BIData";	 Catch:{ Exception -> 0x0038 }
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x0038 }
        r2 = 0;	 Catch:{ Exception -> 0x0038 }
        r4 = com.igexin.b.a.b.f.f(r4, r2);	 Catch:{ Exception -> 0x0038 }
        r2 = "UTF-8";	 Catch:{ Exception -> 0x0038 }
        r1.<init>(r4, r2);	 Catch:{ Exception -> 0x0038 }
        r0.put(r5, r1);	 Catch:{ Exception -> 0x0038 }
        r4 = r0.toString();	 Catch:{ Exception -> 0x0038 }
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0038 }
        r3.b(r4);	 Catch:{ Exception -> 0x0038 }
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.i.a(byte[], int):void");
    }

    public void a(byte[] bArr) {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        if (jSONObject.has("result")) {
            if (ITagManager.SUCCESS.equals(jSONObject.getString("result"))) {
                this.a = true;
                if (this.h == 10) {
                    e.g();
                }
                if (this.g) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("type", "0");
                    f.a().k().a("bi", contentValues, new String[]{"type"}, new String[]{"2"});
                    g.a().c(System.currentTimeMillis());
                }
            }
        }
    }

    public int b() {
        return 0;
    }
}
