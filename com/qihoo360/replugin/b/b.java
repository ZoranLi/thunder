package com.qihoo360.replugin.b;

import android.os.Build.VERSION;
import com.qihoo360.replugin.g;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSONHelper */
public final class b {
    private static final boolean a = g.a;

    public static <T> void a(JSONObject jSONObject, String str, T t) {
        try {
            jSONObject.put(str, t);
        } catch (JSONObject jSONObject2) {
            if (a != null) {
                jSONObject2.printStackTrace();
            }
        }
    }

    public static void a(JSONArray jSONArray, int i) {
        if (VERSION.SDK_INT >= 19) {
            jSONArray.remove(i);
            return;
        }
        if (i >= 0) {
            try {
                Field declaredField = JSONArray.class.getDeclaredField("values");
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(jSONArray);
                if (i < list.size()) {
                    list.remove(i);
                }
            } catch (JSONArray jSONArray2) {
                jSONArray2.printStackTrace();
            }
        }
    }
}
