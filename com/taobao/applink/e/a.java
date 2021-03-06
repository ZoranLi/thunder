package com.taobao.applink.e;

import com.taobao.applink.param.TBAuthParam;
import com.taobao.applink.param.TBBaseParam;
import com.taobao.applink.param.TBDetailParam;
import com.taobao.applink.param.TBNavParam;
import com.taobao.applink.param.TBShopParam;
import com.taobao.applink.param.TBURIParam;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static Map a;

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put("jumpShop", TBShopParam.class);
        a.put("jumpDetail", TBDetailParam.class);
        a.put("jumpH5", TBURIParam.class);
        a.put("doAuth", TBAuthParam.class);
        a.put("jumpNav", TBNavParam.class);
    }

    public static TBBaseParam a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                Constructor declaredConstructor = ((Class) a.get(jSONObject.getString("method"))).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                TBBaseParam tBBaseParam = (TBBaseParam) declaredConstructor.newInstance(new Object[0]);
                if (!tBBaseParam.checkParams(jSONObject)) {
                    return null;
                }
                tBBaseParam.setParams(jSONObject);
                return tBBaseParam;
            } catch (Throwable th) {
                th.toString();
                return null;
            }
        } catch (JSONException e) {
            e.toString();
            return null;
        }
    }
}
