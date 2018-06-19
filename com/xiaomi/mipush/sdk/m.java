package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

class m {
    int a = 0;
    String b = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            m mVar = (m) obj;
            if (!TextUtils.isEmpty(mVar.b) && mVar.b.equals(this.b)) {
                return true;
            }
        }
        return false;
    }
}
