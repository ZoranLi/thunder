package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.tencent.open.SocialConstants;
import com.xunlei.download.DownloadManager;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum ae$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    CMD_NAME((short) 5, "cmdName"),
    REQUEST((short) 6, SocialConstants.TYPE_REQUEST),
    ERROR_CODE((short) 7, "errorCode"),
    REASON((short) 8, DownloadManager.COLUMN_REASON),
    PACKAGE_NAME((short) 9, Constants.KEY_PACKAGE_NAME),
    CMD_ARGS((short) 10, "cmdArgs"),
    CATEGORY((short) 12, "category");
    
    private static final Map<String, ae$a> l = null;
    private final short m;
    private final String n;

    static {
        l = new HashMap();
        Iterator it = EnumSet.allOf(ae$a.class).iterator();
        while (it.hasNext()) {
            ae$a com_xiaomi_xmpush_thrift_ae_a = (ae$a) it.next();
            l.put(com_xiaomi_xmpush_thrift_ae_a.a(), com_xiaomi_xmpush_thrift_ae_a);
        }
    }

    private ae$a(short s, String str) {
        this.m = s;
        this.n = str;
    }

    public final String a() {
        return this.n;
    }
}
