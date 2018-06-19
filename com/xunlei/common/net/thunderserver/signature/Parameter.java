package com.xunlei.common.net.thunderserver.signature;

import android.support.annotation.NonNull;
import com.xunlei.xllib.b.k;

public class Parameter implements Comparable<Parameter> {
    public final boolean encoded;
    public final String name;
    public final String value;

    public Parameter(@NonNull String str, @NonNull String str2) {
        this.name = str;
        this.value = str2;
        this.encoded = null;
    }

    public Parameter(@NonNull String str, @NonNull String str2, boolean z) {
        this.name = str;
        this.value = str2;
        this.encoded = z;
    }

    public String getEncodedValue() {
        return this.encoded ? this.value : k.c(this.value, "UTF-8");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) obj;
        return parameter.name.equals(this.name) && parameter.value.equals(this.value) != null;
    }

    public int hashCode() {
        return this.name.hashCode() + this.value.hashCode();
    }

    public int compareTo(@NonNull Parameter parameter) {
        int compareTo = this.name.compareTo(parameter.name);
        return compareTo == 0 ? this.value.compareTo(parameter.value) : compareTo;
    }
}
