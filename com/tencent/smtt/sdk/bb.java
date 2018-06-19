package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

class bb {
    protected DexLoader a = null;

    public bb(DexLoader dexLoader) {
        this.a = dexLoader;
    }

    public Object a(Context context) {
        return this.a.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, this.a.getClassLoader());
    }

    public void a(Object obj) {
        this.a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    }

    public void a(Object obj, Activity activity, int i) {
        Object obj2 = obj;
        this.a.invokeMethod(obj2, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
    }

    public boolean a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        DexLoader dexLoader;
        String str;
        String str2;
        Class[] clsArr;
        Object[] objArr;
        if (obj2 != null) {
            dexLoader = this.a;
            str = "com.tencent.tbs.player.TbsPlayerProxy";
            str2 = "play";
            clsArr = new Class[]{Bundle.class, FrameLayout.class, Object.class};
            objArr = new Object[]{bundle, frameLayout, obj2};
        } else {
            dexLoader = this.a;
            str = "com.tencent.tbs.player.TbsPlayerProxy";
            str2 = "play";
            clsArr = new Class[]{Bundle.class, FrameLayout.class};
            objArr = new Object[]{bundle, frameLayout};
        }
        obj = dexLoader.invokeMethod(obj, str, str2, clsArr, objArr);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
    }
}
