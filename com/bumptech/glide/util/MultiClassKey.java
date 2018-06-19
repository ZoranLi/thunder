package com.bumptech.glide.util;

public class MultiClassKey {
    private Class<?> first;
    private Class<?> second;

    public MultiClassKey(Class<?> cls, Class<?> cls2) {
        set(cls, cls2);
    }

    public void set(Class<?> cls, Class<?> cls2) {
        this.first = cls;
        this.second = cls2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MultiClassKey{first=");
        stringBuilder.append(this.first);
        stringBuilder.append(", second=");
        stringBuilder.append(this.second);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                MultiClassKey multiClassKey = (MultiClassKey) obj;
                return this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second) != null;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.first.hashCode()) + this.second.hashCode();
    }
}
