package com.igexin.push.core.a;

import com.igexin.assist.action.MessageManger;
import com.igexin.b.a.c.a;
import com.igexin.push.core.b.c;
import com.igexin.push.core.g;
import com.igexin.push.d.c.p;
import java.util.Timer;
import org.json.JSONObject;

public class r extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        try {
            p pVar = (p) obj;
            if (jSONObject.has("action") && jSONObject.getString("action").equals("pushmessage")) {
                byte[] bArr = null;
                if (pVar.f != null && (pVar.f instanceof byte[])) {
                    bArr = (byte[]) pVar.f;
                }
                String string = jSONObject.getString("taskid");
                if (g.ak.containsKey(string)) {
                    ((Timer) g.ak.get(string)).cancel();
                    g.ak.remove(string);
                }
                StringBuilder stringBuilder = new StringBuilder("getui receive message : ");
                stringBuilder.append(jSONObject.toString());
                a.b(stringBuilder.toString());
                if (bArr == null || !com.igexin.assist.sdk.a.e(g.f)) {
                    f.a().a(jSONObject, bArr, true);
                    return true;
                }
                f a;
                String stringBuilder2;
                c cVar = new c(g.f);
                if (cVar.a(string)) {
                    a = f.a();
                    StringBuilder stringBuilder3 = new StringBuilder("1");
                    stringBuilder3.append(MessageManger.getInstance().getBrandCode(g.f));
                    stringBuilder2 = stringBuilder3.toString();
                } else {
                    cVar.b(string);
                    f.a().a(jSONObject, bArr, true);
                    a = f.a();
                    stringBuilder2 = "10";
                }
                a.a(jSONObject, stringBuilder2);
                return true;
            }
        } catch (Exception e) {
            StringBuilder stringBuilder4 = new StringBuilder("PushmessageAction|");
            stringBuilder4.append(e.toString());
            a.b(stringBuilder4.toString());
        }
        return true;
    }
}
