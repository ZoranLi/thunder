package com.qihoo360.mobilesafe.parser.manifest.a;

import android.content.IntentFilter;
import java.util.List;

/* compiled from: ComponentBean */
public final class a {
    public String a;
    public List<IntentFilter> b;

    public final String toString() {
        return String.format("{name:%s, intent-filter.size():%s}", new Object[]{this.a, Integer.valueOf(this.b.size())});
    }
}
