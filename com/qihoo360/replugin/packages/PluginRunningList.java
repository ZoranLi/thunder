package com.qihoo360.replugin.packages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;

public class PluginRunningList implements Parcelable, Cloneable, Iterable<String> {
    public static final Creator<PluginRunningList> CREATOR = new f();
    final ArrayList<String> a;
    String b;
    int c;

    public int describeContents() {
        return 0;
    }

    PluginRunningList() {
        this.c = Integer.MIN_VALUE;
        this.a = new ArrayList();
    }

    PluginRunningList(PluginRunningList pluginRunningList) {
        this.c = Integer.MIN_VALUE;
        this.b = pluginRunningList.b;
        this.c = pluginRunningList.c;
        this.a = new ArrayList(pluginRunningList.a);
    }

    final void a(String str, int i) {
        this.b = str;
        this.c = i;
    }

    final void a(String str) {
        if (!b(str)) {
            this.a.add(str);
        }
    }

    final boolean b(String str) {
        return this.a.contains(str);
    }

    public Iterator<String> iterator() {
        return this.a.iterator();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRunningL{ ");
        if (this.c == Integer.MIN_VALUE) {
            stringBuilder.append("<UNKNOWN_PID>");
        } else {
            stringBuilder.append('<');
            stringBuilder.append(this.b);
            stringBuilder.append(':');
            stringBuilder.append(this.c);
            stringBuilder.append("> ");
        }
        stringBuilder.append(this.a);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                PluginRunningList pluginRunningList = (PluginRunningList) obj;
                if (this.c != pluginRunningList.c || !this.a.equals(pluginRunningList.a)) {
                    return false;
                }
                if (this.b != null) {
                    return this.b.equals(pluginRunningList.b);
                }
                return pluginRunningList.b == null;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((this.a.hashCode() * 31) + (this.b != null ? this.b.hashCode() : 0))) + this.c;
    }

    protected Object clone() throws CloneNotSupportedException {
        return new PluginRunningList(this);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeSerializable(this.a);
    }

    private PluginRunningList(Parcel parcel) {
        this.c = Integer.MIN_VALUE;
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.a = (ArrayList) parcel.readSerializable();
    }
}
