package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.xunlei.download.DownloadManager;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum aj$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    APP_VERSION((short) 5, "appVersion"),
    PACKAGE_NAME((short) 6, Constants.KEY_PACKAGE_NAME),
    TOKEN((short) 7, "token"),
    DEVICE_ID((short) 8, "deviceId"),
    ALIAS_NAME((short) 9, "aliasName"),
    SDK_VERSION((short) 10, Constants.KEY_SDK_VERSION),
    REG_ID((short) 11, "regId"),
    PUSH_SDK_VERSION_NAME((short) 12, "pushSdkVersionName"),
    PUSH_SDK_VERSION_CODE((short) 13, "pushSdkVersionCode"),
    APP_VERSION_CODE((short) 14, Constants.KEY_APP_VERSION_CODE),
    ANDROID_ID((short) 15, "androidId"),
    IMEI((short) 16, "imei"),
    SERIAL((short) 17, "serial"),
    IMEI_MD5((short) 18, "imeiMd5"),
    SPACE_ID((short) 19, "spaceId"),
    REASON((short) 20, DownloadManager.COLUMN_REASON),
    CONNECTION_ATTRS((short) 100, "connectionAttrs"),
    CLEAN_OLD_REG_INFO((short) 101, "cleanOldRegInfo"),
    OLD_REG_ID((short) 102, "oldRegId");
    
    private static final Map<String, aj$a> x = null;
    private final short y;
    private final String z;

    static {
        x = new HashMap();
        Iterator it = EnumSet.allOf(aj$a.class).iterator();
        while (it.hasNext()) {
            aj$a com_xiaomi_xmpush_thrift_aj_a = (aj$a) it.next();
            x.put(com_xiaomi_xmpush_thrift_aj_a.a(), com_xiaomi_xmpush_thrift_aj_a);
        }
    }

    private aj$a(short s, String str) {
        this.y = s;
        this.z = str;
    }

    public final String a() {
        return this.z;
    }
}
