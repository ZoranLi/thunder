package com.igexin.push.core.c;

import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.f;
import com.igexin.push.core.g;
import com.igexin.push.d.c.a;
import com.igexin.push.d.c.c;
import com.igexin.push.d.c.e;
import com.igexin.push.e.j;
import com.igexin.push.util.q;
import java.util.Timer;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class b extends com.igexin.push.f.a.b {
    private String a;
    private String g;
    private a h;
    private PushTaskBean i;

    public b(String str, a aVar, PushTaskBean pushTaskBean) {
        super(str);
        this.g = str;
        this.a = pushTaskBean.getMessageId();
        this.h = aVar;
        this.i = pushTaskBean;
    }

    protected void a(PushTaskBean pushTaskBean, a aVar) {
        e cVar = new c();
        cVar.a();
        StringBuilder stringBuilder = new StringBuilder("RTV");
        stringBuilder.append(pushTaskBean.getMessageId());
        stringBuilder.append("@");
        stringBuilder.append(pushTaskBean.getTaskId());
        cVar.c = stringBuilder.toString();
        cVar.d = g.r;
        cVar.a = (int) System.currentTimeMillis();
        j g = f.a().g();
        StringBuilder stringBuilder2 = new StringBuilder("C-");
        stringBuilder2.append(g.r);
        g.a(stringBuilder2.toString(), cVar);
        StringBuilder stringBuilder3 = new StringBuilder("cdnRetrieve|");
        stringBuilder3.append(pushTaskBean.getMessageId());
        stringBuilder3.append("|");
        stringBuilder3.append(pushTaskBean.getTaskId());
        com.igexin.b.a.c.a.b(stringBuilder3.toString());
        if (aVar.c() < 2) {
            long a = q.a();
            Timer timer = new Timer();
            timer.schedule(new d(this, pushTaskBean, aVar), a);
            g.ak.put(pushTaskBean.getTaskId(), timer);
        }
    }

    public void a(Exception exception) {
        if (this.h.a() < 2) {
            new Timer().schedule(new c(this), q.a());
            return;
        }
        a(this.i, this.h);
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            bArr = com.igexin.b.a.b.f.d(com.igexin.b.a.a.a.c(bArr, g.c));
            if (bArr != null) {
                JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                jSONObject.put(AgooConstants.MESSAGE_ID, this.a);
                jSONObject.put("messageid", this.a);
                jSONObject.put("cdnType", true);
                bArr = null;
                try {
                    if ("pushmessage".equals(jSONObject.getString("action"))) {
                        if (jSONObject.has("extraData")) {
                            bArr = jSONObject.getString("extraData").getBytes();
                        }
                        com.igexin.push.core.a.f.a().a(jSONObject, bArr, true);
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            throw new Exception("Get error CDNData, can not UnGzip it...");
        }
    }

    public int b() {
        return 0;
    }
}
