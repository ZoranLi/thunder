package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;

public class u {
    private static volatile u a;
    private Context b;
    private List<m> c = new ArrayList();

    private u(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
    }

    public static u a(Context context) {
        if (a == null) {
            synchronized (u.class) {
                if (a == null) {
                    a = new u(context);
                }
            }
        }
        return a;
    }

    public synchronized String a(aj ajVar) {
        return this.b.getSharedPreferences("mipush_extra", 0).getString(ajVar.name(), "");
    }

    public synchronized void a(aj ajVar, String str) {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(ajVar.name(), str).commit();
    }

    public void a(String str) {
        synchronized (this.c) {
            m mVar = new m();
            mVar.a = 0;
            mVar.b = str;
            if (this.c.contains(mVar)) {
                this.c.remove(mVar);
            }
            this.c.add(mVar);
        }
    }

    public void b(String str) {
        synchronized (this.c) {
            m mVar = new m();
            mVar.b = str;
            if (this.c.contains(mVar)) {
                for (m mVar2 : this.c) {
                    if (mVar.equals(mVar2)) {
                        mVar = mVar2;
                        break;
                    }
                }
            }
            mVar.a++;
            this.c.remove(mVar);
            this.c.add(mVar);
        }
    }

    public int c(String str) {
        synchronized (this.c) {
            m mVar = new m();
            mVar.b = str;
            if (this.c.contains(mVar)) {
                for (m mVar2 : this.c) {
                    if (mVar2.equals(mVar)) {
                        int i = mVar2.a;
                        return i;
                    }
                }
            }
            return 0;
        }
    }

    public void d(String str) {
        synchronized (this.c) {
            m mVar = new m();
            mVar.b = str;
            if (this.c.contains(mVar)) {
                this.c.remove(mVar);
            }
        }
    }

    public boolean e(String str) {
        synchronized (this.c) {
            m mVar = new m();
            mVar.b = str;
            if (this.c.contains(mVar)) {
                return true;
            }
            return false;
        }
    }
}
