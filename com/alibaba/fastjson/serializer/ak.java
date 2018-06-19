package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.a;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: MapSerializer */
public final class ak implements ao {
    public static ak a = new ak();

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        type = afVar.a;
        if (obj == null) {
            type.write("null");
            return;
        }
        Map map = (Map) obj;
        if (afVar.a(obj)) {
            afVar.b(obj);
            return;
        }
        at atVar = afVar.m;
        afVar.a(atVar, obj, obj2);
        try {
            Class cls;
            type.write(123);
            afVar.d();
            Object obj3 = 1;
            if (type.b(SerializerFeature.WriteClassName) != null) {
                cls = map.getClass();
                obj2 = ((cls == JSONObject.class || cls == HashMap.class || cls == LinkedHashMap.class) && map.containsKey(a.DEFAULT_TYPE_KEY) != null) ? 1 : null;
                if (obj2 == null) {
                    type.d(a.DEFAULT_TYPE_KEY);
                    type.b(obj.getClass().getName());
                    obj3 = null;
                }
            }
            obj2 = null;
            Object obj4 = null;
            for (Entry entry : map.entrySet()) {
                Object obj5;
                String str;
                Class cls2;
                ao a;
                ao aoVar;
                Object value = entry.getValue();
                Object key = entry.getKey();
                List list = afVar.g;
                if (list != null && list.size() > 0) {
                    if (key != null) {
                        if (!(key instanceof String)) {
                            if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                a.toJSONString(key);
                                if (afVar.m()) {
                                }
                            }
                        }
                    }
                    if (!afVar.m()) {
                    }
                }
                list = afVar.d;
                if (list != null && list.size() > 0) {
                    if (key != null) {
                        if (!(key instanceof String)) {
                            if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                a.toJSONString(key);
                                if (afVar.n()) {
                                }
                            }
                        }
                    }
                    if (!afVar.n()) {
                    }
                }
                list = afVar.f;
                if (list != null && list.size() > 0) {
                    if (key != null) {
                        if (!(key instanceof String)) {
                            if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = afVar.b(a.toJSONString(key));
                            }
                        }
                    }
                    key = afVar.b((String) key);
                }
                Object obj6 = key;
                List list2 = afVar.e;
                list = afVar.i;
                if ((list2 != null && list2.size() > 0) || (list != null && list.size() > 0)) {
                    if (obj6 != null) {
                        if (!(obj6 instanceof String)) {
                            if (obj6.getClass().isPrimitive() || (obj6 instanceof Number)) {
                                key = afVar.a(a.toJSONString(obj6), value);
                                obj5 = key;
                                if (obj5 == null || type.b(SerializerFeature.WriteMapNullValue)) {
                                    if (obj6 instanceof String) {
                                        str = (String) obj6;
                                        if (obj3 == null) {
                                            type.write(44);
                                        }
                                        if (type.b(SerializerFeature.PrettyFormat)) {
                                            afVar.f();
                                        }
                                        type.e(str);
                                    } else {
                                        if (obj3 == null) {
                                            type.write(44);
                                        }
                                        if (!(type.b(SerializerFeature.BrowserCompatible) || type.b(SerializerFeature.WriteNonStringKeyAsString))) {
                                            if (!type.b(SerializerFeature.BrowserSecure)) {
                                                afVar.c(obj6);
                                                type.write(58);
                                            }
                                        }
                                        afVar.a(a.toJSONString(obj6));
                                        type.write(58);
                                    }
                                    if (obj5 == null) {
                                        type.write("null");
                                    } else {
                                        cls2 = obj5.getClass();
                                        if (cls2 == obj2) {
                                            obj4.a(afVar, obj5, obj6, null, 0);
                                        } else {
                                            a = afVar.a(cls2);
                                            a.a(afVar, obj5, obj6, null, 0);
                                            aoVar = a;
                                            cls = cls2;
                                        }
                                    }
                                    obj3 = null;
                                }
                            }
                        }
                    }
                    key = afVar.a((String) obj6, value);
                    obj5 = key;
                    if (obj5 == null) {
                    }
                    if (obj6 instanceof String) {
                        if (obj3 == null) {
                            type.write(44);
                        }
                        if (!type.b(SerializerFeature.BrowserSecure)) {
                            afVar.c(obj6);
                            type.write(58);
                        } else {
                            afVar.a(a.toJSONString(obj6));
                            type.write(58);
                        }
                    } else {
                        str = (String) obj6;
                        if (obj3 == null) {
                            type.write(44);
                        }
                        if (type.b(SerializerFeature.PrettyFormat)) {
                            afVar.f();
                        }
                        type.e(str);
                    }
                    if (obj5 == null) {
                        cls2 = obj5.getClass();
                        if (cls2 == obj2) {
                            a = afVar.a(cls2);
                            a.a(afVar, obj5, obj6, null, 0);
                            aoVar = a;
                            cls = cls2;
                        } else {
                            obj4.a(afVar, obj5, obj6, null, 0);
                        }
                    } else {
                        type.write("null");
                    }
                    obj3 = null;
                }
                obj5 = value;
                if (obj5 == null) {
                }
                if (obj6 instanceof String) {
                    str = (String) obj6;
                    if (obj3 == null) {
                        type.write(44);
                    }
                    if (type.b(SerializerFeature.PrettyFormat)) {
                        afVar.f();
                    }
                    type.e(str);
                } else {
                    if (obj3 == null) {
                        type.write(44);
                    }
                    if (!type.b(SerializerFeature.BrowserSecure)) {
                        afVar.a(a.toJSONString(obj6));
                        type.write(58);
                    } else {
                        afVar.c(obj6);
                        type.write(58);
                    }
                }
                if (obj5 == null) {
                    type.write("null");
                } else {
                    cls2 = obj5.getClass();
                    if (cls2 == obj2) {
                        obj4.a(afVar, obj5, obj6, null, 0);
                    } else {
                        a = afVar.a(cls2);
                        a.a(afVar, obj5, obj6, null, 0);
                        aoVar = a;
                        cls = cls2;
                    }
                }
                obj3 = null;
            }
            afVar.e();
            if (type.b(SerializerFeature.PrettyFormat) != null && map.size() > null) {
                afVar.f();
            }
            type.write(125);
        } finally {
            afVar.m = atVar;
        }
    }
}
