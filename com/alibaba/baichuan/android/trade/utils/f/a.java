package com.alibaba.baichuan.android.trade.utils.f;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.baichuan.android.trade.model.AliPayResult;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static Long a(JSONObject jSONObject, String str) {
        return jSONObject.has(str) ? Long.valueOf(jSONObject.optLong(str)) : null;
    }

    public static Object a(String str, Class cls) {
        if (str == null) {
            return null;
        }
        if (String.class.equals(cls)) {
            return str;
        }
        if (!Short.TYPE.equals(cls)) {
            if (!Short.class.equals(cls)) {
                if (!Integer.TYPE.equals(cls)) {
                    if (!Integer.class.equals(cls)) {
                        if (!Long.TYPE.equals(cls)) {
                            if (!Long.class.equals(cls)) {
                                if (!Boolean.TYPE.equals(cls)) {
                                    if (!Boolean.class.equals(cls)) {
                                        if (!Float.TYPE.equals(cls)) {
                                            if (!Float.class.equals(cls)) {
                                                if (!Double.TYPE.equals(cls)) {
                                                    if (!Double.class.equals(cls)) {
                                                        if (!Byte.TYPE.equals(cls)) {
                                                            if (!Byte.class.equals(cls)) {
                                                                int i = 0;
                                                                if (!Character.TYPE.equals(cls)) {
                                                                    if (!Character.class.equals(cls)) {
                                                                        if (Date.class.isAssignableFrom(cls)) {
                                                                            try {
                                                                                return new SimpleDateFormat("yyyyMMddHHmmssSSSZ", Locale.US).parse(str);
                                                                            } catch (Throwable e) {
                                                                                throw new RuntimeException("Parse Date error", e);
                                                                            }
                                                                        }
                                                                        char charAt = str.charAt(0);
                                                                        if (cls.isArray()) {
                                                                            cls = cls.getComponentType();
                                                                            if (charAt == '[') {
                                                                                try {
                                                                                    return a(new JSONArray(str), cls);
                                                                                } catch (Throwable e2) {
                                                                                    throw new RuntimeException(e2);
                                                                                }
                                                                            } else if (String.class.equals(cls)) {
                                                                                return str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                                                            } else {
                                                                                if (Character.TYPE.equals(cls)) {
                                                                                    return str.toCharArray();
                                                                                }
                                                                                Object obj;
                                                                                if (Character.class.equals(cls)) {
                                                                                    char[] toCharArray = str.toCharArray();
                                                                                    obj = new Character[toCharArray.length];
                                                                                    while (i < obj.length) {
                                                                                        obj[i] = Character.valueOf(toCharArray[i]);
                                                                                        i++;
                                                                                    }
                                                                                    return obj;
                                                                                } else if (Byte.TYPE.equals(cls)) {
                                                                                    return Base64.decode(str, 0);
                                                                                } else {
                                                                                    if (!Byte.class.equals(cls)) {
                                                                                        return null;
                                                                                    }
                                                                                    byte[] decode = Base64.decode(str, 0);
                                                                                    obj = new Byte[decode.length];
                                                                                    while (i < obj.length) {
                                                                                        obj[i] = Byte.valueOf(decode[i]);
                                                                                        i++;
                                                                                    }
                                                                                    return obj;
                                                                                }
                                                                            }
                                                                        } else if (charAt != '{') {
                                                                            return cls.isAssignableFrom(String.class) ? str : null;
                                                                        } else {
                                                                            try {
                                                                                JSONObject jSONObject = new JSONObject(str);
                                                                                return Map.class.isAssignableFrom(cls) ? b(jSONObject) : a(jSONObject, cls);
                                                                            } catch (Throwable e22) {
                                                                                throw new RuntimeException(e22);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                return Character.valueOf(str.charAt(0));
                                                            }
                                                        }
                                                        return Byte.valueOf(str);
                                                    }
                                                }
                                                return Double.valueOf(str);
                                            }
                                        }
                                        return Float.valueOf(str);
                                    }
                                }
                                return Boolean.valueOf(str);
                            }
                        }
                        return Long.valueOf(str);
                    }
                }
                return Integer.valueOf(str);
            }
        }
        return Short.valueOf(str);
    }

    private static Object a(JSONObject jSONObject, Class cls) {
        if (!(jSONObject == null || cls == null)) {
            if (cls != Void.TYPE) {
                try {
                    Object newInstance = cls.newInstance();
                    for (Field field : cls.getFields()) {
                        Class type = field.getType();
                        String name = field.getName();
                        if (jSONObject.has(name)) {
                            if (!type.isPrimitive()) {
                                Object string;
                                if (type == String.class) {
                                    string = jSONObject.getString(name);
                                } else {
                                    if (!(type == Boolean.class || type == Integer.class || type == Short.class || type == Long.class)) {
                                        if (type != Double.class) {
                                            string = type.isArray() ? a(jSONObject.getJSONArray(name), type.getComponentType()) : Map.class.isAssignableFrom(type) ? b(jSONObject.getJSONObject(name)) : a(jSONObject.getJSONObject(name), type);
                                        }
                                    }
                                    string = jSONObject.get(name);
                                }
                                field.set(newInstance, string);
                            } else if (type == Boolean.TYPE) {
                                field.setBoolean(newInstance, jSONObject.getBoolean(name));
                            } else if (type == Byte.TYPE) {
                                field.setByte(newInstance, (byte) jSONObject.getInt(name));
                            } else if (type == Character.TYPE) {
                                char charAt;
                                String string2 = jSONObject.getString(name);
                                if (string2 != null) {
                                    if (string2.length() != 0) {
                                        charAt = string2.charAt(0);
                                        field.setChar(newInstance, charAt);
                                    }
                                }
                                charAt = '\u0000';
                                field.setChar(newInstance, charAt);
                            } else if (type == Short.TYPE) {
                                field.setShort(newInstance, (short) jSONObject.getInt(name));
                            } else if (type == Integer.TYPE) {
                                field.setInt(newInstance, jSONObject.getInt(name));
                            } else if (type == Long.TYPE) {
                                field.setLong(newInstance, jSONObject.getLong(name));
                            } else if (type == Float.TYPE) {
                                field.setFloat(newInstance, (float) jSONObject.getDouble(name));
                            } else if (type == Double.TYPE) {
                                field.setDouble(newInstance, jSONObject.getDouble(name));
                            }
                        }
                    }
                    return newInstance;
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

    public static String a(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(List list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (Object put : list) {
                jSONArray.put(put);
            }
        }
        return jSONArray.toString();
    }

    public static Map a(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, jSONObject.getString(str));
        }
        return hashMap;
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object[] a(JSONArray jSONArray, Class cls) {
        if (!(jSONArray == null || cls == null)) {
            if (cls != Void.TYPE) {
                Object newInstance = Array.newInstance(cls, jSONArray.length());
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        if (!cls.isPrimitive()) {
                            Object string;
                            if (cls == String.class) {
                                string = jSONArray.getString(i);
                            } else {
                                if (!(cls == Boolean.class || cls == Integer.class || cls == Short.class || cls == Long.class)) {
                                    if (cls != Double.class) {
                                        string = cls.isArray() ? a(jSONArray.getJSONArray(i), cls.getComponentType()) : Map.class.isAssignableFrom(cls) ? b(jSONArray.getJSONObject(i)) : a(jSONArray.getJSONObject(i), cls);
                                    }
                                }
                                string = jSONArray.get(i);
                            }
                            Array.set(newInstance, i, string);
                        } else if (cls == Boolean.TYPE) {
                            Array.setBoolean(newInstance, i, jSONArray.getBoolean(i));
                        } else if (cls == Byte.TYPE) {
                            Array.setByte(newInstance, i, (byte) jSONArray.getInt(i));
                        } else if (cls == Character.TYPE) {
                            char charAt;
                            String string2 = jSONArray.getString(i);
                            if (string2 != null) {
                                if (string2.length() != 0) {
                                    charAt = string2.charAt(0);
                                    Array.setChar(newInstance, i, charAt);
                                }
                            }
                            charAt = '\u0000';
                            Array.setChar(newInstance, i, charAt);
                        } else if (cls == Short.TYPE) {
                            Array.setShort(newInstance, i, (short) jSONArray.getInt(i));
                        } else if (cls == Integer.TYPE) {
                            Array.setInt(newInstance, i, jSONArray.getInt(i));
                        } else if (cls == Long.TYPE) {
                            Array.setLong(newInstance, i, jSONArray.getLong(i));
                        } else if (cls == Float.TYPE) {
                            Array.setFloat(newInstance, i, (float) jSONArray.getDouble(i));
                        } else if (cls == Double.TYPE) {
                            Array.setDouble(newInstance, i, jSONArray.getDouble(i));
                        }
                        i++;
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                }
                return (Object[]) newInstance;
            }
        }
        return null;
    }

    public static String[] a(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray == null) {
            return new String[0];
        }
        String[] strArr = new String[jSONArray.length()];
        int length = jSONArray.length();
        while (i < length) {
            strArr[i] = jSONArray.optString(i);
            i++;
        }
        return strArr;
    }

    public static AliPayResult b(String str) {
        AliPayResult aliPayResult = new AliPayResult();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("paySuccessOrders");
            int i = 0;
            if (optJSONArray != null) {
                List arrayList = new ArrayList(optJSONArray.length());
                aliPayResult.paySuccessOrders = arrayList;
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(Long.valueOf(optJSONArray.optLong(i2)));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("payFailedOrders");
            if (optJSONArray2 != null) {
                List arrayList2 = new ArrayList(optJSONArray2.length());
                aliPayResult.payFailedOrders = arrayList2;
                int length2 = optJSONArray2.length();
                while (i < length2) {
                    arrayList2.add(Long.valueOf(optJSONArray2.optLong(i)));
                    i++;
                }
            }
            return aliPayResult;
        } catch (JSONException e) {
            e.toString();
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return null;
        }
    }

    private static List b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        List arrayList = new ArrayList(jSONArray.length());
        int i = 0;
        int length = jSONArray.length();
        while (i < length) {
            Object obj = jSONArray.get(i);
            obj = obj instanceof JSONObject ? b((JSONObject) obj) : obj instanceof JSONArray ? b((JSONArray) obj) : jSONArray.get(i);
            arrayList.add(obj);
            i++;
        }
        return arrayList;
    }

    private static Map b(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt instanceof JSONObject) {
                opt = b((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                opt = b((JSONArray) opt);
            }
            hashMap.put(str, opt);
        }
        return hashMap;
    }
}
