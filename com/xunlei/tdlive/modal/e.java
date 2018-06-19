package com.xunlei.tdlive.modal;

import android.content.Context;
import android.preference.PreferenceManager;
import com.xunlei.tdlive.protocol.XLLiveGetTaskStateRequest;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;
import java.util.Calendar;

/* compiled from: TaskManager */
public class e {
    private static String a = "unreceive_reward_num";
    private static String b = "check_task_day";
    private static e c;
    private int d = 0;
    private JsonWrapper e = new JsonWrapper("{}");

    public static e a() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e();
                }
            }
        }
        return c;
    }

    private e() {
    }

    public void a(final Runnable runnable) {
        new XLLiveGetTaskStateRequest().send(new JsonCallBack(this) {
            final /* synthetic */ e b;

            public void onResponse(int i, String str, JsonWrapper jsonWrapper) {
                e.a().a((JsonWrapper) jsonWrapper.getObject("data", "{}"));
                if (runnable != 0) {
                    runnable.run();
                }
            }
        });
    }

    private void a(JsonWrapper jsonWrapper) {
        this.e = jsonWrapper;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Context r5) {
        /*
        r4 = this;
        r0 = com.xunlei.tdlive.sdk.b.a();
        r0 = r0.b();
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r0 = com.xunlei.tdlive.sdk.b.a();
        r0 = r0.e();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r3 = "unreceive_reward_num";
        r2.append(r3);
        r2 = r2.toString();
        a = r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = "check_task_day";
        r2.append(r0);
        r0 = r2.toString();
        b = r0;
        r0 = r4.e;
        r2 = "unget_reward_num";
        r0 = r0.getInt(r2, r1);
        r4.d = r0;
        r0 = r4.d;
        r2 = r4.d(r5);
        r3 = 1;
        if (r0 <= r2) goto L_0x004e;
    L_0x004d:
        return r3;
    L_0x004e:
        r0 = r4.d;
        r2 = r4.d(r5);
        if (r0 >= r2) goto L_0x005c;
    L_0x0056:
        r5 = r4.d;
        if (r5 <= 0) goto L_0x005b;
    L_0x005a:
        return r3;
    L_0x005b:
        return r1;
    L_0x005c:
        r0 = r4.d;
        r2 = r4.d(r5);
        if (r0 != r2) goto L_0x0070;
    L_0x0064:
        r5 = r4.c(r5);
        if (r5 == 0) goto L_0x0070;
    L_0x006a:
        r5 = r4.d;
        if (r5 <= 0) goto L_0x006f;
    L_0x006e:
        return r3;
    L_0x006f:
        return r1;
    L_0x0070:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.e.a(android.content.Context):boolean");
    }

    private boolean c(Context context) {
        context = PreferenceManager.getDefaultSharedPreferences(context).getInt(b, 0);
        int i = Calendar.getInstance().get(5);
        if (context != null) {
            if (context == i) {
                return false;
            }
        }
        return true;
    }

    private int d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(a, 0);
    }

    public void b(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(a, this.d).apply();
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(b, Calendar.getInstance().get(5)).apply();
    }
}
