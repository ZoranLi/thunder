package com.xunlei.downloadprovider.personal.lixianspace.a;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: LXSpacePreference */
public final class a {
    public PreferenceHelper a;
    public long b;
    private String c;

    /* compiled from: LXSpacePreference */
    private static class a {
        private static final a a = new a();
    }

    private a() {
        this.b = 0;
        this.a = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "lx-space-sp");
    }

    public final List<Long> a() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = this.a.getString("key:downloading_task_id", "");
        }
        if (TextUtils.isEmpty(this.c)) {
            return null;
        }
        String[] split = this.c.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split == null || split.length <= 0) {
            return null;
        }
        List<Long> arrayList = new ArrayList(split.length);
        for (Object obj : split) {
            if (!TextUtils.isEmpty(obj)) {
                arrayList.add(Long.valueOf(Long.parseLong(obj)));
            }
        }
        return arrayList;
    }

    public final void a(Set<Long> set) {
        if (set != null) {
            if (!set.isEmpty()) {
                this.c = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, set);
                if (TextUtils.isEmpty(this.c) != null) {
                    this.c = "";
                }
                this.a.putString("key:downloading_task_id", this.c);
            }
        }
    }
}
