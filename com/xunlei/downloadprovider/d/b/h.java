package com.xunlei.downloadprovider.d.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: HomeTabConfig */
public final class h extends com.xunlei.downloadprovider.d.a {
    public List<a> a = new ArrayList();

    /* compiled from: HomeTabConfig */
    public static class a {
        public String a = "";
        public String b = "";
        public String c = "";

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("HomeTabItemConfig{mKey='");
            stringBuilder.append(this.a);
            stringBuilder.append('\'');
            stringBuilder.append(", mTitle='");
            stringBuilder.append(this.b);
            stringBuilder.append('\'');
            stringBuilder.append(", mUrl='");
            stringBuilder.append(this.c);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static a a() {
        a aVar = new a();
        aVar.a = "download";
        aVar.b = "下载";
        return aVar;
    }
}
