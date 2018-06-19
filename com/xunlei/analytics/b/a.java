package com.xunlei.analytics.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.xunlei.analytics.c.c;
import com.xunlei.analytics.c.e;
import com.xunlei.analytics.c.f;
import java.util.HashMap;

public class a {
    private static a a = null;
    private static final int b = 10000;
    private static final String c = "MSG_EVENT_INTERID";
    private static final String d = "MSG_EVENT_EVENTID";
    private HandlerThread e = new HandlerThread("InsertThread");
    private Callback f = new Callback(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public boolean handleMessage(Message message) {
            if (message.what == 10000) {
                Bundle data = message.getData();
                if (data != null) {
                    String str = (String) data.get(a.c);
                    if (str == "1") {
                        this.a.c();
                        return true;
                    }
                    String str2 = (String) data.get(a.d);
                    HashMap hashMap = null;
                    if (message.obj != null) {
                        hashMap = (HashMap) message.obj;
                    }
                    this.a.b(str, str2, hashMap);
                }
            }
            return false;
        }
    };
    private Handler g;

    private a() {
        this.e.start();
        this.g = new Handler(this.e.getLooper(), this.f);
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private void a(String str) {
        if (e.a()) {
            StringBuilder stringBuilder = new StringBuilder("generate data =");
            stringBuilder.append(str);
            e.a(stringBuilder.toString());
        }
    }

    private void b(String str, String str2, HashMap<String, String> hashMap) {
        str2 = c.b(com.xunlei.analytics.config.a.d(), str, str2, hashMap);
        a(str2);
        com.xunlei.analytics.dbstore.a.a().a(com.xunlei.analytics.config.a.a(), str, str2);
    }

    private void c() {
        if (d()) {
            b("1", "1", null);
            f.e(com.xunlei.analytics.config.a.d());
        }
    }

    private boolean d() {
        return !c.a(System.currentTimeMillis(), f.f(com.xunlei.analytics.config.a.d()));
    }

    public void a(String str, String str2, HashMap<String, String> hashMap) {
        try {
            Message message = new Message();
            message.what = 10000;
            if (hashMap != null && hashMap.size() > 0) {
                message.obj = hashMap;
            }
            Bundle bundle = new Bundle();
            bundle.putString(c, str);
            bundle.putString(d, str2);
            message.setData(bundle);
            this.g.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        a("1", "1", null);
    }
}
