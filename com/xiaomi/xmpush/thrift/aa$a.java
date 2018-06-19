package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.tencent.open.SocialConstants;
import com.xunlei.download.DownloadManager;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum aa$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    TYPE((short) 5, "type"),
    REQUEST((short) 6, SocialConstants.TYPE_REQUEST),
    ERROR_CODE((short) 7, "errorCode"),
    REASON((short) 8, DownloadManager.COLUMN_REASON),
    EXTRA((short) 9, "extra"),
    PACKAGE_NAME((short) 10, Constants.KEY_PACKAGE_NAME),
    CATEGORY((short) 11, "category");
    
    private static final Map<String, aa$a> l = null;
    private final short m;
    private final String n;

    static {
        l = new HashMap();
        Iterator it = EnumSet.allOf(aa$a.class).iterator();
        while (it.hasNext()) {
            aa$a com_xiaomi_xmpush_thrift_aa_a = (aa$a) it.next();
            l.put(com_xiaomi_xmpush_thrift_aa_a.a(), com_xiaomi_xmpush_thrift_aa_a);
        }
    }

    private aa$a(short s, String str) {
        this.m = s;
        this.n = str;
    }

    public final String a() {
        return this.n;
    }
}
