package com.igexin.push.core.a;

import com.igexin.push.core.b.c;
import com.igexin.push.core.g;
import com.igexin.push.f.a;
import java.util.Iterator;
import org.json.JSONObject;

class p extends a {
    final /* synthetic */ m a;

    p(m mVar) {
        this.a = mVar;
    }

    protected void a() {
        try {
            c cVar = new c(g.f);
            JSONObject c = cVar.c();
            Iterator keys = c.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONObject jSONObject = c.getJSONObject(str);
                StringBuilder stringBuilder = new StringBuilder("LoginResultAction|send unFeedback taskid = ");
                stringBuilder.append(str);
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                jSONObject.put("appid", g.a);
                jSONObject.put("appkey", g.b);
                f.a().a(jSONObject, jSONObject.getString("multaid"));
                keys.remove();
            }
            cVar.d();
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("LoginResultAction|feedbackMultiBrandPushMessage exception :");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
    }
}
