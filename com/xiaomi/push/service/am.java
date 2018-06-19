package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.c;
import java.util.List;

public class am {
    private static volatile am b;
    protected SharedPreferences a;

    private am(Context context) {
        this.a = context.getSharedPreferences("mipush_extra", 0);
    }

    public static am a(Context context) {
        if (b == null) {
            synchronized (am.class) {
                if (b == null) {
                    b = new am(context);
                }
            }
        }
        return b;
    }

    private String a(int i) {
        StringBuilder stringBuilder = new StringBuilder("normal_oc_");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    private void a(Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            editor.putString(str, (String) pair.second);
        } else {
            if (pair.second instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
            }
        }
    }

    private String b(int i) {
        StringBuilder stringBuilder = new StringBuilder("custom_oc_");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public int a(int i, int i2) {
        String b = b(i);
        if (this.a.contains(b)) {
            return this.a.getInt(b, 0);
        }
        String a = a(i);
        return this.a.contains(a) ? this.a.getInt(a, 0) : i2;
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (!c.a(list)) {
            Editor edit = this.a.edit();
            for (Pair pair : list) {
                if (!(pair.first == null || pair.second == null)) {
                    a(edit, pair, a(((Integer) pair.first).intValue()));
                }
            }
            edit.commit();
        }
    }

    public boolean a(int i, boolean z) {
        String b = b(i);
        if (this.a.contains(b)) {
            return this.a.getBoolean(b, false);
        }
        String a = a(i);
        return this.a.contains(a) ? this.a.getBoolean(a, false) : z;
    }

    public void b(List<Pair<Integer, Object>> list) {
        if (!c.a(list)) {
            Editor edit = this.a.edit();
            for (Pair pair : list) {
                if (pair.first != null) {
                    String b = b(((Integer) pair.first).intValue());
                    if (pair.second == null) {
                        edit.remove(b);
                    } else {
                        a(edit, pair, b);
                    }
                }
            }
            edit.commit();
        }
    }
}
