package com.alibaba.baichuan.android.trade.utils.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import java.util.List;

public final class a {

    public static class a {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public static synchronized String a(String str) {
        synchronized (a.class) {
            if (TextUtils.isEmpty(str)) {
                str = "";
                return str;
            }
            SharedPreferences sharedPreferences = AlibcContext.a.getSharedPreferences("ali_bc_auth_cache", 0);
            String string = sharedPreferences.getString(str, "");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("SHARE_PREFERENCE_EXPIRE");
            Long.valueOf(sharedPreferences.getLong(stringBuilder.toString(), 0));
            return string;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void a(java.lang.String r4, java.lang.String r5) {
        /*
        r0 = com.alibaba.baichuan.android.trade.utils.d.a.class;
        monitor-enter(r0);
        r1 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0029 }
        if (r1 != 0) goto L_0x0027;
    L_0x0009:
        if (r5 != 0) goto L_0x000c;
    L_0x000b:
        goto L_0x0027;
    L_0x000c:
        r1 = com.alibaba.baichuan.android.trade.AlibcContext.a;	 Catch:{ Exception -> 0x0021 }
        r2 = "ali_bc_auth_cache";
        r3 = 0;
        r1 = r1.getSharedPreferences(r2, r3);	 Catch:{ Exception -> 0x0021 }
        r1 = r1.edit();	 Catch:{ Exception -> 0x0021 }
        r1.putString(r4, r5);	 Catch:{ Exception -> 0x0021 }
        r1.apply();	 Catch:{ Exception -> 0x0021 }
        monitor-exit(r0);
        return;
    L_0x0021:
        r4 = move-exception;
        r4.printStackTrace();	 Catch:{ all -> 0x0029 }
        monitor-exit(r0);
        return;
    L_0x0027:
        monitor-exit(r0);
        return;
    L_0x0029:
        r4 = move-exception;
        monitor-exit(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.utils.d.a.a(java.lang.String, java.lang.String):void");
    }

    public static void a(List list) {
        int i = 0;
        while (i < list.size()) {
            if (!(list.get(i) == null || TextUtils.isEmpty(((a) list.get(i)).a) || ((a) list.get(i)).b == null)) {
                a(((a) list.get(i)).a, ((a) list.get(i)).b);
            }
            i++;
        }
    }
}
