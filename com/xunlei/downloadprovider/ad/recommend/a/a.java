package com.xunlei.downloadprovider.ad.recommend.a;

/* compiled from: IBaseModel */
public interface a {

    /* compiled from: IBaseModel */
    public static class a {
        public static final a a = new a(-1, "无数据！");
        public static final a b = new a(-1001, "获取数据失败！");
        public static final a c = new a(-1002, "数据解析失败！");
        public static final a d = new a(-1003, "超时失败！");
        public int e;
        public String f;

        public a(int i, String str) {
            this.e = i;
            this.f = str;
        }
    }
}
