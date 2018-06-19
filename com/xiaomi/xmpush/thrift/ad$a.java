package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum ad$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    CMD_NAME((short) 5, "cmdName"),
    CMD_ARGS((short) 6, "cmdArgs"),
    PACKAGE_NAME((short) 7, Constants.KEY_PACKAGE_NAME),
    CATEGORY((short) 9, "category");
    
    private static final Map<String, ad$a> i = null;
    private final short j;
    private final String k;

    static {
        i = new HashMap();
        Iterator it = EnumSet.allOf(ad$a.class).iterator();
        while (it.hasNext()) {
            ad$a com_xiaomi_xmpush_thrift_ad_a = (ad$a) it.next();
            i.put(com_xiaomi_xmpush_thrift_ad_a.a(), com_xiaomi_xmpush_thrift_ad_a);
        }
    }

    private ad$a(short s, String str) {
        this.j = s;
        this.k = str;
    }

    public final String a() {
        return this.k;
    }
}
