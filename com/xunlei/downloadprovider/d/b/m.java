package com.xunlei.downloadprovider.d.b;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.d.a;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

/* compiled from: PushConfig */
public final class m extends a {
    @NonNull
    public final Set<String> a() {
        Set<String> hashSet = new HashSet();
        JSONArray b = b("should_report_display_types");
        int i = 0;
        new StringBuilder("displayTypeArray ==null: ").append(b == null);
        if (b != null) {
            int length = b.length();
            while (i < length) {
                hashSet.add(String.valueOf(b.optInt(i)));
                i++;
            }
        }
        return hashSet;
    }
}
