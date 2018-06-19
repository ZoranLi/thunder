package com.qihoo360.replugin.component.service.server;

import android.os.Messenger;
import java.util.ArrayList;

/* compiled from: ProcessRecord */
final class h {
    final int a;
    final Messenger b;
    final ArrayList<a> c = new ArrayList();
    private String d;

    h(int i, Messenger messenger) {
        this.a = i;
        this.b = messenger;
    }

    public final String toString() {
        if (this.d != null) {
            return this.d;
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("ProcessRecord{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" p");
        stringBuilder.append(this.a);
        stringBuilder.append('}');
        this.d = stringBuilder.toString();
        return this.d;
    }
}
