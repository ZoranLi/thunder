package com.alibaba.fastjson;

import com.alibaba.fastjson.a.b;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.g;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JSONObject extends a implements Serializable, Cloneable, InvocationHandler, Map<String, Object> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long serialVersionUID = 1;
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, false);
    }

    public JSONObject(Map<String, Object> map) {
        this.map = map;
    }

    public JSONObject(boolean z) {
        this(16, z);
    }

    public JSONObject(int i) {
        this(i, false);
    }

    public JSONObject(int i, boolean z) {
        if (z) {
            this.map = new LinkedHashMap(i);
        } else {
            this.map = new HashMap(i);
        }
    }

    public int size() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public JSONObject getJSONObject(String str) {
        str = this.map.get(str);
        if (str instanceof JSONObject) {
            return (JSONObject) str;
        }
        return (JSONObject) a.toJSON(str);
    }

    public JSONArray getJSONArray(String str) {
        str = this.map.get(str);
        if (str instanceof JSONArray) {
            return (JSONArray) str;
        }
        return (JSONArray) a.toJSON(str);
    }

    public <T> T getObject(String str, Class<T> cls) {
        return j.a(this.map.get(str), (Class) cls);
    }

    public Boolean getBoolean(String str) {
        str = get(str);
        if (str == null) {
            return null;
        }
        return j.o(str);
    }

    public byte[] getBytes(String str) {
        str = get(str);
        if (str == null) {
            return null;
        }
        return j.n(str);
    }

    public boolean getBooleanValue(String str) {
        str = get(str);
        if (str == null) {
            return null;
        }
        return j.o(str).booleanValue();
    }

    public Byte getByte(String str) {
        return j.b(get(str));
    }

    public byte getByteValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return j.b(obj).byteValue();
    }

    public Short getShort(String str) {
        return j.d(get(str));
    }

    public short getShortValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return j.d(obj).shortValue();
    }

    public Integer getInteger(String str) {
        return j.m(get(str));
    }

    public int getIntValue(String str) {
        str = get(str);
        if (str == null) {
            return null;
        }
        return j.m(str).intValue();
    }

    public Long getLong(String str) {
        return j.l(get(str));
    }

    public long getLongValue(String str) {
        str = get(str);
        if (str == null) {
            return 0;
        }
        return j.l(str).longValue();
    }

    public Float getFloat(String str) {
        return j.g(get(str));
    }

    public float getFloatValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return j.g(obj).floatValue();
    }

    public Double getDouble(String str) {
        return j.h(get(str));
    }

    public double getDoubleValue(String str) {
        str = get(str);
        if (str == null) {
            return 0.0d;
        }
        return j.h(str).doubleValue();
    }

    public BigDecimal getBigDecimal(String str) {
        return j.e(get(str));
    }

    public BigInteger getBigInteger(String str) {
        return j.f(get(str));
    }

    public String getString(String str) {
        str = get(str);
        if (str == null) {
            return null;
        }
        return str.toString();
    }

    public Date getDate(String str) {
        return j.i(get(str));
    }

    public java.sql.Date getSqlDate(String str) {
        return j.j(get(str));
    }

    public Timestamp getTimestamp(String str) {
        return j.k(get(str));
    }

    public Object put(String str, Object obj) {
        return this.map.put(str, obj);
    }

    public JSONObject fluentPut(String str, Object obj) {
        this.map.put(str, obj);
        return this;
    }

    public void putAll(Map<? extends String, ? extends Object> map) {
        this.map.putAll(map);
    }

    public JSONObject fluentPutAll(Map<? extends String, ? extends Object> map) {
        this.map.putAll(map);
        return this;
    }

    public void clear() {
        this.map.clear();
    }

    public JSONObject fluentClear() {
        this.map.clear();
        return this;
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public JSONObject fluentRemove(Object obj) {
        this.map.remove(obj);
        return this;
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public Set<Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public Object clone() {
        return new JSONObject(this.map instanceof LinkedHashMap ? new LinkedHashMap(this.map) : new HashMap(this.map));
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        obj = method.getParameterTypes();
        Object obj2 = null;
        b bVar;
        if (obj.length == 1) {
            if (method.getName().equals("equals") != null) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() != Void.TYPE) {
                throw new JSONException("illegal setter");
            }
            bVar = (b) method.getAnnotation(b.class);
            obj = (bVar == null || bVar.b().length() == 0) ? null : bVar.b();
            if (obj == null) {
                obj = method.getName();
                if (obj.startsWith("set") == null) {
                    throw new JSONException("illegal setter");
                }
                obj = obj.substring(3);
                if (obj.length() == null) {
                    throw new JSONException("illegal setter");
                }
                method = new StringBuilder();
                method.append(Character.toLowerCase(obj.charAt(0)));
                method.append(obj.substring(1));
                obj = method.toString();
            }
            this.map.put(obj, objArr[0]);
            return null;
        } else if (obj.length != null) {
            throw new UnsupportedOperationException(method.toGenericString());
        } else if (method.getReturnType() == Void.TYPE) {
            throw new JSONException("illegal getter");
        } else {
            bVar = (b) method.getAnnotation(b.class);
            if (!(bVar == null || bVar.b().length() == null)) {
                obj2 = bVar.b();
            }
            if (obj2 == null) {
                obj = method.getName();
                if (obj.startsWith("get") != null) {
                    obj = obj.substring(3);
                    if (obj.length() == null) {
                        throw new JSONException("illegal getter");
                    }
                    objArr = new StringBuilder();
                    objArr.append(Character.toLowerCase(obj.charAt(0)));
                    objArr.append(obj.substring(1));
                    obj2 = objArr.toString();
                } else if (obj.startsWith("is") != null) {
                    obj = obj.substring(2);
                    if (obj.length() == null) {
                        throw new JSONException("illegal getter");
                    }
                    objArr = new StringBuilder();
                    objArr.append(Character.toLowerCase(obj.charAt(0)));
                    objArr.append(obj.substring(1));
                    obj2 = objArr.toString();
                } else if (obj.startsWith("hashCode") != null) {
                    return Integer.valueOf(hashCode());
                } else {
                    if (obj.startsWith("toString") != null) {
                        return toString();
                    }
                    throw new JSONException("illegal getter");
                }
            }
            return j.a(this.map.get(obj2), method.getGenericReturnType(), g.a());
        }
    }
}
