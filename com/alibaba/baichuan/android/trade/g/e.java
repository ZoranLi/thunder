package com.alibaba.baichuan.android.trade.g;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.f.c;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;

public final class e extends b {
    public static final String[] b = new String[]{"all", "waitPay", "waitSend", "waitConfirm", "waitRate"};
    int c = 0;
    boolean d = true;

    public final boolean a() {
        if (this.c >= 0) {
            if (this.c <= 4) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(AlibcTaokeParams alibcTaokeParams) {
        return false;
    }

    public final String b() {
        return c.f;
    }

    public final String c() {
        if (this.a != null && !TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String str = AlibcContext.o;
        int indexOf = str.indexOf(63);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?tabCode=%s");
        str = stringBuilder.toString();
        if (this.c < 0 || this.c >= 5) {
            str = str.substring(0, str.indexOf("?"));
        } else {
            Object[] objArr;
            if (this.d) {
                objArr = new Object[]{b[this.c]};
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("&condition={\"extra\":{\"attributes\":{\"ttid\":\"%s\"}}}");
                str = stringBuilder2.toString();
                objArr = new Object[]{b[this.c], AlibcContext.c()};
            }
            str = String.format(str, objArr);
        }
        this.a = str;
        return this.a;
    }

    public final String e() {
        return "Order_Page";
    }

    public final String f() {
        return "myOrder";
    }

    public final boolean g() {
        return true;
    }
}
