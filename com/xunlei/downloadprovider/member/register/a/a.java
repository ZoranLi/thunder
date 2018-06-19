package com.xunlei.downloadprovider.member.register.a;

import anet.channel.util.HttpConstant;
import com.alipay.sdk.util.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: CookiesParser */
public final class a {
    public Map<String, List<String>> a;
    public Map<String, String> b = new HashMap();
    private final String c = "CookiesParser";

    public final void a() {
        for (Entry entry : this.a.entrySet()) {
            if (HttpConstant.SET_COOKIE.equalsIgnoreCase((String) entry.getKey())) {
                for (String split : (List) entry.getValue()) {
                    String[] split2 = split.split(h.b);
                    int i = 0;
                    while (split2 != null && i < split2.length) {
                        String[] split3 = split2[i].split("=");
                        if (split3 != null) {
                            if (split3.length == 1) {
                                StringBuilder stringBuilder = new StringBuilder("++[parse]cookie:");
                                stringBuilder.append(split3[0]);
                                stringBuilder.append("=");
                                this.b.put(split3[0], "");
                            } else if (split3.length == 2) {
                                StringBuilder stringBuilder2 = new StringBuilder("++[parse]cookie:");
                                stringBuilder2.append(split3[0]);
                                stringBuilder2.append("=");
                                stringBuilder2.append(split3[1]);
                                this.b.put(split3[0], split3[1]);
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }
}
