package com.xiaomi.xmpush.thrift;

import com.tencent.open.SocialConstants;
import com.xunlei.download.DownloadManager;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum am$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    REQUEST((short) 5, SocialConstants.TYPE_REQUEST),
    ERROR_CODE((short) 6, "errorCode"),
    REASON((short) 7, DownloadManager.COLUMN_REASON),
    CATEGORY((short) 8, "category");
    
    private static final Map<String, am$a> i = null;
    private final short j;
    private final String k;

    static {
        i = new HashMap();
        Iterator it = EnumSet.allOf(am$a.class).iterator();
        while (it.hasNext()) {
            am$a com_xiaomi_xmpush_thrift_am_a = (am$a) it.next();
            i.put(com_xiaomi_xmpush_thrift_am_a.a(), com_xiaomi_xmpush_thrift_am_a);
        }
    }

    private am$a(short s, String str) {
        this.j = s;
        this.k = str;
    }

    public final String a() {
        return this.k;
    }
}
