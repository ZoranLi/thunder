package com.alibaba.wireless.security.framework;

import android.content.Intent;
import android.os.Parcelable;
import com.alibaba.wireless.security.framework.b.c;
import java.io.Serializable;

public class a extends Intent {
    private String a;
    private String b;

    private void a(Object obj) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        c.a = classLoader;
        setExtrasClassLoader(classLoader);
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public Intent putExtra(String str, Parcelable parcelable) {
        a((Object) parcelable);
        return super.putExtra(str, parcelable);
    }

    public Intent putExtra(String str, Serializable serializable) {
        a((Object) serializable);
        return super.putExtra(str, serializable);
    }
}
