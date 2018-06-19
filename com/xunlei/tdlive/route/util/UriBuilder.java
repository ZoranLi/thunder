package com.xunlei.tdlive.route.util;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Pair;
import anet.channel.util.HttpConstant;
import java.util.ArrayList;

public final class UriBuilder {
    private String a;
    private String b;
    private String c = "";
    private ArrayList<Pair<String, String>> d = new ArrayList();

    public UriBuilder(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final UriBuilder path(String str) {
        this.c = str;
        return this;
    }

    public final UriBuilder addParam(String str, int i) {
        return addParam(str, String.valueOf(i));
    }

    public final UriBuilder addParam(String str, long j) {
        return addParam(str, String.valueOf(j));
    }

    public final UriBuilder addParam(String str, float f) {
        return addParam(str, String.valueOf(f));
    }

    public final UriBuilder addParam(String str, double d) {
        return addParam(str, String.valueOf(d));
    }

    public final UriBuilder addParam(String str, boolean z) {
        return addParam(str, String.valueOf(z));
    }

    public final UriBuilder addParam(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        this.d.add(new Pair(str, str2));
        return this;
    }

    public final String build() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(HttpConstant.SCHEME_SPLIT);
        stringBuilder.append(this.b);
        stringBuilder.append(this.c);
        Builder buildUpon = Uri.parse(stringBuilder.toString()).buildUpon();
        for (int i = 0; i < this.d.size(); i++) {
            Pair pair = (Pair) this.d.get(i);
            buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        return buildUpon.toString();
    }

    public final String toString() {
        return build();
    }
}
