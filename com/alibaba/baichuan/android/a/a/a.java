package com.alibaba.baichuan.android.a.a;

import android.text.TextUtils;
import com.alibaba.baichuan.android.a.d;
import com.alibaba.baichuan.android.a.e;
import com.alibaba.baichuan.android.trade.utils.b;
import com.tencent.connect.common.Constants;
import java.util.Map;

public class a extends com.alibaba.baichuan.android.a.b.a {
    public static String a = "AliBCAppLink";

    public final boolean a(String str, String str2, d dVar) {
        String c;
        Exception e;
        e eVar;
        boolean z = false;
        if (!TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str)) {
                Map map = null;
                try {
                    Map d = b.d(com.alibaba.fastjson.a.parse(str2));
                    c = b.c(d.get("type"));
                    try {
                        map = b.d(d.get("params"));
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (c != null) {
                            if (map == null) {
                                if (!c.equals("shop")) {
                                    z = com.alibaba.baichuan.android.trade.adapter.b.a.a().a(this.b, map);
                                } else if (!c.equals("detail")) {
                                    z = com.alibaba.baichuan.android.trade.adapter.b.a.a().b(this.b, map);
                                } else if (c.equals("url")) {
                                    z = com.alibaba.baichuan.android.trade.adapter.b.a.a().c(this.b, map);
                                }
                                if (z) {
                                    dVar.a(e.a);
                                    return true;
                                }
                                dVar.b(e.b);
                                return true;
                            }
                        }
                        eVar = new e(Constants.VIA_SHARE_TYPE_INFO);
                        eVar.a("2");
                        dVar.b(eVar);
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    c = null;
                    e.printStackTrace();
                    if (c != null) {
                        if (map == null) {
                            if (!c.equals("shop")) {
                                z = com.alibaba.baichuan.android.trade.adapter.b.a.a().a(this.b, map);
                            } else if (!c.equals("detail")) {
                                z = com.alibaba.baichuan.android.trade.adapter.b.a.a().b(this.b, map);
                            } else if (c.equals("url")) {
                                z = com.alibaba.baichuan.android.trade.adapter.b.a.a().c(this.b, map);
                            }
                            if (z) {
                                dVar.b(e.b);
                                return true;
                            }
                            dVar.a(e.a);
                            return true;
                        }
                    }
                    eVar = new e(Constants.VIA_SHARE_TYPE_INFO);
                    eVar.a("2");
                    dVar.b(eVar);
                    return true;
                }
                if (c != null) {
                    if (map == null) {
                        if (!c.equals("shop")) {
                            z = com.alibaba.baichuan.android.trade.adapter.b.a.a().a(this.b, map);
                        } else if (!c.equals("detail")) {
                            z = com.alibaba.baichuan.android.trade.adapter.b.a.a().b(this.b, map);
                        } else if (c.equals("url")) {
                            z = com.alibaba.baichuan.android.trade.adapter.b.a.a().c(this.b, map);
                        }
                        if (z) {
                            dVar.a(e.a);
                            return true;
                        }
                        dVar.b(e.b);
                        return true;
                    }
                }
                eVar = new e(Constants.VIA_SHARE_TYPE_INFO);
                eVar.a("2");
                dVar.b(eVar);
                return true;
            }
        }
        eVar = new e(Constants.VIA_SHARE_TYPE_INFO);
        eVar.a("2");
        dVar.b(eVar);
        return false;
    }
}
