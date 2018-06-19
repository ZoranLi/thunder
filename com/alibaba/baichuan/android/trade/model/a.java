package com.alibaba.baichuan.android.trade.model;

import com.taobao.applink.util.TBAppLinkUtil;

public final class a {
    public OpenType a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    private boolean g;

    public a() {
        this.e = true;
        this.f = false;
        this.a = OpenType.Auto;
        this.c = TBAppLinkUtil.TAOBAO_SCHEME;
    }

    public a(OpenType openType) {
        this.e = true;
        this.f = false;
        this.a = openType;
        this.g = false;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AlibcShowParams{isNeedPush=");
        stringBuilder.append(this.g);
        stringBuilder.append(", openType=");
        stringBuilder.append(this.a);
        stringBuilder.append(", backUrl='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
