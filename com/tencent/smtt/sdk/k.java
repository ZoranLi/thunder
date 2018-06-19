package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class k {
    private DexLoader a;
    private ReaderCallback b;

    public k(ReaderCallback readerCallback) {
        this.a = null;
        this.b = null;
        this.a = b();
        this.b = readerCallback;
    }

    public static Drawable a(int i) {
        DexLoader b = b();
        if (b != null) {
            Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof Drawable) {
                return (Drawable) invokeStaticMethod;
            }
        }
        return null;
    }

    public static boolean a(Context context) {
        DexLoader b = b();
        if (b == null) {
            return false;
        }
        Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
        return invokeStaticMethod instanceof Boolean ? ((Boolean) invokeStaticMethod).booleanValue() : false;
    }

    public static boolean a(String str) {
        DexLoader b = b();
        if (b == null) {
            return false;
        }
        Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
        return invokeStaticMethod instanceof Boolean ? ((Boolean) invokeStaticMethod).booleanValue() : false;
    }

    private static DexLoader b() {
        ba c = l.a(true).c();
        return c != null ? c.b() : null;
    }

    public static String b(int i) {
        String str = "";
        DexLoader b = b();
        if (b == null) {
            return str;
        }
        Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i));
        return invokeStaticMethod instanceof String ? (String) invokeStaticMethod : str;
    }

    public Object a() {
        return this.a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    }

    public void a(Object obj) {
        this.b = null;
        if (this.a != null && obj != null) {
            this.a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
        }
    }

    public void a(Object obj, int i, int i2) {
        if (this.a != null) {
            Object[] objArr = new Object[]{new Integer(i), new Integer(i2)};
            Object obj2 = obj;
            this.a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, objArr);
        }
    }

    public void a(Object obj, Integer num, Object obj2, Object obj3) {
        if (this.a != null) {
            Object[] objArr = new Object[]{new Integer(num.intValue()), obj2, obj3};
            Object obj4 = obj;
            this.a.invokeMethod(obj4, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, objArr);
        }
    }

    public void a(Object obj, String str) {
        if (this.a != null) {
            Object obj2 = obj;
            this.a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
        }
    }

    public boolean a(Object obj, Context context) {
        if (this.a == null || obj == null) {
            return false;
        }
        obj = this.a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "init", new Class[]{Context.class, DexLoader.class, Object.class}, context, this.a, this);
        return !(obj instanceof Boolean) ? false : ((Boolean) obj).booleanValue();
    }

    public boolean a(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        if (this.a == null) {
            return false;
        }
        obj = this.a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
        return !(obj instanceof Boolean) ? false : ((Boolean) obj).booleanValue();
    }

    public boolean a(Object obj, Context context, String str, boolean z) {
        if (this.a == null) {
            return false;
        }
        obj = this.a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z));
        return !(obj instanceof Boolean) ? false : ((Boolean) obj).booleanValue();
    }
}
