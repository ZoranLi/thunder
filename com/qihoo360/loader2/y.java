package com.qihoo360.loader2;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Set;

/* compiled from: PluginIntent */
public final class y {
    final Intent a;

    public y(Intent intent) {
        this.a = intent;
    }

    private final void a(String str) {
        Set<String> categories = this.a.getCategories();
        if (categories != null) {
            for (String str2 : categories) {
                if (str2.startsWith(str)) {
                    this.a.removeCategory(str2);
                    return;
                }
            }
        }
    }

    private final String b(String str) {
        Set<String> categories = this.a.getCategories();
        if (categories != null) {
            for (String str2 : categories) {
                if (str2.startsWith(str)) {
                    return str2.substring(str.length());
                }
            }
        }
        return null;
    }

    final void a(String str, String str2) {
        a(str);
        Intent intent = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        intent.addCategory(stringBuilder.toString());
    }

    public final int a(String str, int i) {
        Set<String> categories = this.a.getCategories();
        if (categories != null) {
            Object obj = "";
            for (String str2 : categories) {
                if (str2.startsWith(str)) {
                    obj = str2.substring(str.length());
                    break;
                }
            }
            if (TextUtils.isEmpty(obj) == null) {
                try {
                    return Integer.parseInt(obj);
                } catch (String str3) {
                    str3.getMessage();
                }
            }
        }
        return i;
    }

    private final void b(String str, int i) {
        a(str);
        Intent intent = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(i);
        intent.addCategory(stringBuilder.toString());
    }

    public final String a() {
        return b("plugin:");
    }

    public final String b() {
        return b("activity:");
    }

    public final int c() {
        return a("process:", Integer.MIN_VALUE);
    }

    final void d() {
        b("process:", Integer.MIN_VALUE);
    }

    public final String e() {
        return b("container:");
    }

    final void a(int i) {
        b("counter:", i);
    }
}
