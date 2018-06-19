package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter.RefreshType;

/* compiled from: AbsListInfo */
public abstract class a implements Cloneable {
    public int e;
    public String f;
    public int g;
    public int h = -1;
    public String i;
    public RefreshType j;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return f();
    }

    public String b() {
        return this.i;
    }

    public a f() throws CloneNotSupportedException {
        return (a) super.clone();
    }
}
