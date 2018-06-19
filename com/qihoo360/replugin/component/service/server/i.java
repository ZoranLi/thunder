package com.qihoo360.replugin.component.service.server;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent.FilterComparison;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.qihoo360.replugin.utils.a.a;
import java.util.ArrayList;

/* compiled from: ServiceRecord */
final class i {
    final ComponentName a;
    final String b;
    final String c;
    final FilterComparison d;
    final ServiceInfo e;
    Service f;
    ComponentName g;
    boolean h;
    final a<FilterComparison, c> i = new a();
    final a<IBinder, ArrayList<a>> j = new a();
    final String k;

    i(ComponentName componentName, FilterComparison filterComparison, ServiceInfo serviceInfo) {
        this.a = componentName;
        this.b = componentName.getPackageName();
        this.c = componentName.getClassName();
        this.k = this.a.flattenToShortString();
        this.d = filterComparison;
        this.e = serviceInfo;
    }

    public final boolean a() {
        int size = this.j.size() - 1;
        while (true) {
            int i = 0;
            if (size < 0) {
                return false;
            }
            ArrayList arrayList = (ArrayList) this.j.b(size);
            while (i < arrayList.size()) {
                if ((((a) arrayList.get(i)).c & 1) != 0) {
                    return true;
                }
                i++;
            }
            size--;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[srv=");
        stringBuilder.append(this.f);
        if (stringBuilder.toString() == null) {
            return "null";
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.f.getClass().getName());
        stringBuilder.append("; startRequested=");
        stringBuilder.append(this.h);
        stringBuilder.append("; bindings=(");
        stringBuilder.append(this.i.size());
        stringBuilder.append(") ");
        stringBuilder.append(this.i);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
