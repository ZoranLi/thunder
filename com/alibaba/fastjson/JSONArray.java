package com.alibaba.fastjson;

import com.alibaba.fastjson.c.j;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class JSONArray extends a implements Serializable, Cloneable, List<Object>, RandomAccess {
    private static final long serialVersionUID = 1;
    protected transient Type componentType;
    private final List<Object> list;
    protected transient Object relatedArray;

    public JSONArray() {
        this.list = new ArrayList(10);
    }

    public JSONArray(List<Object> list) {
        this.list = list;
    }

    public JSONArray(int i) {
        this.list = new ArrayList(i);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public void setRelatedArray(Object obj) {
        this.relatedArray = obj;
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public void setComponentType(Type type) {
        this.componentType = type;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.list.toArray(tArr);
    }

    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    public JSONArray fluentAdd(Object obj) {
        this.list.add(obj);
        return this;
    }

    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    public JSONArray fluentRemove(Object obj) {
        this.list.remove(obj);
        return this;
    }

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public boolean addAll(Collection<? extends Object> collection) {
        return this.list.addAll(collection);
    }

    public JSONArray fluentAddAll(Collection<? extends Object> collection) {
        this.list.addAll(collection);
        return this;
    }

    public boolean addAll(int i, Collection<? extends Object> collection) {
        return this.list.addAll(i, collection);
    }

    public JSONArray fluentAddAll(int i, Collection<? extends Object> collection) {
        this.list.addAll(i, collection);
        return this;
    }

    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    public JSONArray fluentRemoveAll(Collection<?> collection) {
        this.list.removeAll(collection);
        return this;
    }

    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    public JSONArray fluentRetainAll(Collection<?> collection) {
        this.list.retainAll(collection);
        return this;
    }

    public void clear() {
        this.list.clear();
    }

    public JSONArray fluentClear() {
        this.list.clear();
        return this;
    }

    public Object set(int i, Object obj) {
        if (i == -1) {
            this.list.add(obj);
            return null;
        } else if (this.list.size() > i) {
            return this.list.set(i, obj);
        } else {
            for (int size = this.list.size(); size < i; size++) {
                this.list.add(null);
            }
            this.list.add(obj);
            return null;
        }
    }

    public JSONArray fluentSet(int i, Object obj) {
        set(i, obj);
        return this;
    }

    public void add(int i, Object obj) {
        this.list.add(i, obj);
    }

    public JSONArray fluentAdd(int i, Object obj) {
        this.list.add(i, obj);
        return this;
    }

    public Object remove(int i) {
        return this.list.remove(i);
    }

    public JSONArray fluentRemove(int i) {
        this.list.remove(i);
        return this;
    }

    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    public ListIterator<Object> listIterator(int i) {
        return this.list.listIterator(i);
    }

    public List<Object> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    public Object get(int i) {
        return this.list.get(i);
    }

    public JSONObject getJSONObject(int i) {
        i = this.list.get(i);
        if (i instanceof JSONObject) {
            return (JSONObject) i;
        }
        return (JSONObject) a.toJSON(i);
    }

    public JSONArray getJSONArray(int i) {
        i = this.list.get(i);
        if (i instanceof JSONArray) {
            return (JSONArray) i;
        }
        return (JSONArray) a.toJSON(i);
    }

    public <T> T getObject(int i, Class<T> cls) {
        return j.a(this.list.get(i), (Class) cls);
    }

    public Boolean getBoolean(int i) {
        i = get(i);
        if (i == 0) {
            return 0;
        }
        return j.o(i);
    }

    public boolean getBooleanValue(int i) {
        i = get(i);
        if (i == 0) {
            return false;
        }
        return j.o(i).booleanValue();
    }

    public Byte getByte(int i) {
        return j.b(get(i));
    }

    public byte getByteValue(int i) {
        Object obj = get(i);
        if (obj == 0) {
            return (byte) 0;
        }
        return j.b(obj).byteValue();
    }

    public Short getShort(int i) {
        return j.d(get(i));
    }

    public short getShortValue(int i) {
        Object obj = get(i);
        if (obj == 0) {
            return (short) 0;
        }
        return j.d(obj).shortValue();
    }

    public Integer getInteger(int i) {
        return j.m(get(i));
    }

    public int getIntValue(int i) {
        i = get(i);
        if (i == 0) {
            return 0;
        }
        return j.m(i).intValue();
    }

    public Long getLong(int i) {
        return j.l(get(i));
    }

    public long getLongValue(int i) {
        i = get(i);
        if (i == 0) {
            return 0;
        }
        return j.l(i).longValue();
    }

    public Float getFloat(int i) {
        return j.g(get(i));
    }

    public float getFloatValue(int i) {
        Object obj = get(i);
        if (obj == 0) {
            return 0;
        }
        return j.g(obj).floatValue();
    }

    public Double getDouble(int i) {
        return j.h(get(i));
    }

    public double getDoubleValue(int i) {
        i = get(i);
        if (i == 0) {
            return 0.0d;
        }
        return j.h(i).doubleValue();
    }

    public BigDecimal getBigDecimal(int i) {
        return j.e(get(i));
    }

    public BigInteger getBigInteger(int i) {
        return j.f(get(i));
    }

    public String getString(int i) {
        return j.a(get(i));
    }

    public Date getDate(int i) {
        return j.i(get(i));
    }

    public java.sql.Date getSqlDate(int i) {
        return j.j(get(i));
    }

    public Timestamp getTimestamp(int i) {
        return j.k(get(i));
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.list));
    }

    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public int hashCode() {
        return this.list.hashCode();
    }
}
