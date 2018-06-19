package com.qihoo360.replugin.component.utils;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.qihoo360.i.Factory;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.a;
import com.qihoo360.replugin.b.c;

public final class PluginClientHelper {

    public static class ShouldCallSystem extends RuntimeException {
        private static final long serialVersionUID = -2987516993124234548L;
    }

    public static Integer a(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence toLowerCase = str.toLowerCase();
            if (toLowerCase.contains(a.b.toLowerCase())) {
                return Integer.valueOf(-2);
            }
            if (TextUtils.equals(toLowerCase, b.d.toLowerCase())) {
                return Integer.valueOf(-2);
            }
            str = com.qihoo360.replugin.component.process.a.a(str.toLowerCase());
            if (com.qihoo360.replugin.component.process.a.a.containsKey(str)) {
                return (Integer) com.qihoo360.replugin.component.process.a.a.get(str);
            }
        }
        return Integer.valueOf(-1);
    }

    public static ComponentName a(Context context, ComponentName componentName) {
        if (componentName == null) {
            return null;
        }
        if (!TextUtils.equals(componentName.getPackageName(), b.c)) {
            return componentName;
        }
        context = Factory.fetchPluginName(context.getClassLoader());
        if (TextUtils.isEmpty(context)) {
            new StringBuilder("pch.iibc: pn is n. n=").append(componentName);
        } else if (!TextUtils.equals(context, RePlugin.PLUGIN_NAME_MAIN)) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("PluginClientHelper.iibc(): Call Plugin! n=");
                stringBuilder.append(componentName);
                c.a("ws001", stringBuilder.toString());
            }
            return new ComponentName(context, componentName.getClassName());
        } else if (c.a != null) {
            StringBuilder stringBuilder2 = new StringBuilder("PluginClientHelper.iibc(): Call Main! n=");
            stringBuilder2.append(componentName);
            c.a("ws001", stringBuilder2.toString());
        }
        return componentName;
    }
}
