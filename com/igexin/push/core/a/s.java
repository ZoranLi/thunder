package com.igexin.push.core.a;

import com.igexin.b.a.c.a;
import com.igexin.push.core.b.d;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class s extends b {
    public boolean a(Object obj, JSONObject jSONObject) {
        StringBuilder stringBuilder;
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("received")) {
                String string = jSONObject.getString(AgooConstants.MESSAGE_ID);
                stringBuilder = new StringBuilder("ReceivedAction received, cmd id :");
                stringBuilder.append(string);
                a.b(stringBuilder.toString());
                try {
                    d.a().a(Long.parseLong(string));
                    f.a().h();
                } catch (NumberFormatException e) {
                    stringBuilder = new StringBuilder("ReceivedAction|");
                    stringBuilder.append(e.toString());
                    a.b(stringBuilder.toString());
                }
            }
        } catch (Exception e2) {
            stringBuilder = new StringBuilder("ReceivedAction|");
            stringBuilder.append(e2.toString());
            a.b(stringBuilder.toString());
        }
        return true;
    }
}
