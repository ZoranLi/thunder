package com.alibaba.baichuan.android.trade.c.a.a.a;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.c.a.a.a.d.a;
import com.taobao.accs.common.Constants;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f implements b {
    private a a;
    private Pattern b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private String g;

    public f(a aVar) {
        String str = (String) aVar.c.get("regexp");
        if (str != null) {
            this.b = Pattern.compile(str);
        }
        this.c = (String) aVar.c.get("key");
        this.d = (String) aVar.c.get(RequestHeaders.COLUMN_VALUE);
        this.g = (String) aVar.c.get(Constants.KEY_MODE);
        this.e = "true".equals(aVar.c.get("cacheable"));
        this.a = aVar;
    }

    public final boolean a(c cVar) {
        if (this.c == null) {
            return null;
        }
        String a;
        CharSequence b = cVar.b(this.c);
        if (!(("addIfAbsent".equals(this.g) || "update".equals(this.g)) && b == null)) {
            if (!"append".equals(this.g)) {
                if (("replace".equals(this.g) || "update".equals(this.g)) && b != null) {
                    if (!this.e || this.f == null) {
                        Map b2 = b(cVar);
                        if (this.b != null) {
                            Matcher matcher = this.b.matcher(b);
                            if (matcher.matches()) {
                                int groupCount = matcher.groupCount();
                                for (int i = 1; i <= groupCount; i++) {
                                    StringBuilder stringBuilder = new StringBuilder("group_");
                                    stringBuilder.append(i);
                                    b2.put(stringBuilder.toString(), matcher.group(i));
                                }
                            }
                            b2.put("group_0", b);
                        }
                        a = com.alibaba.baichuan.android.trade.c.a.a.a.a(this.d, b2);
                        if (this.e) {
                            this.f = a;
                        }
                    } else {
                        a = this.f;
                    }
                    if (a != null) {
                        cVar.a(this.c, a);
                    }
                    return true;
                }
                if ("delete".equals(this.g)) {
                    cVar.a(this.c);
                } else {
                    cVar = new StringBuilder("ignore the action ");
                    cVar.append(this.g);
                    cVar.append(" key ");
                    cVar.append(this.c);
                    AlibcContext.b();
                }
                return true;
            }
        }
        if (!"addAllParams".equals(this.c)) {
            if (!this.e || this.f == null || TextUtils.isEmpty(this.f)) {
                a = com.alibaba.baichuan.android.trade.c.a.a.a.a(this.d, b(cVar));
                if (this.e) {
                    this.f = a;
                }
            } else {
                a = this.f;
            }
            if (a != null) {
                cVar.b(this.c, a);
            }
        } else if (cVar.i != null) {
            for (String str : cVar.i.keySet()) {
                if (!TextUtils.isEmpty((CharSequence) cVar.i.get(str))) {
                    cVar.b(str, (String) cVar.i.get(str));
                }
            }
        }
        return true;
    }

    private Map b(c cVar) {
        Map hashMap = new HashMap();
        if (this.a.c != null) {
            hashMap.putAll(this.a.c);
        }
        hashMap.putAll(cVar.i);
        return hashMap;
    }
}
