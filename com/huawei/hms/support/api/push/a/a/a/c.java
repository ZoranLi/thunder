package com.huawei.hms.support.api.push.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PushPreferences */
public class c {
    protected SharedPreferences a;

    public boolean a(String str) {
        return (this.a == null || this.a.getBoolean(str, false) == null) ? false : true;
    }

    public String b(String str) {
        return this.a != null ? this.a.getString(str, "") : "";
    }

    public c(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("context is null!");
        }
        this.a = context.getSharedPreferences(str, 4);
    }

    public boolean a(String str, Object obj) {
        Editor edit = this.a.edit();
        if (obj instanceof String) {
            edit.putString(str, String.valueOf(obj));
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            edit.putInt(str, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            edit.putInt(str, ((Byte) obj).byteValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            edit.putFloat(str, (float) ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        return edit.commit();
    }

    public boolean a(String str, String str2) {
        if (this.a == null) {
            return false;
        }
        Editor edit = this.a.edit();
        if (edit != null) {
            return edit.putString(str, str2).commit();
        }
        return false;
    }

    public void a(String str, boolean z) {
        if (this.a != null) {
            Editor edit = this.a.edit();
            if (edit != null) {
                edit.putBoolean(str, z).commit();
            }
        }
    }

    public boolean c(String str) {
        return (this.a == null || this.a.contains(str) == null) ? null : true;
    }

    public boolean d(String str) {
        if (this.a == null || !this.a.contains(str)) {
            return null;
        }
        str = this.a.edit().remove(str);
        str.commit();
        return str.commit();
    }

    public Map<String, ?> a() {
        if (this.a != null) {
            return this.a.getAll();
        }
        return new HashMap();
    }
}
