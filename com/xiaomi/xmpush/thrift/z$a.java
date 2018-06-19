package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum z$a {
    DEBUG((short) 1, "debug"),
    TARGET((short) 2, "target"),
    ID((short) 3, AgooConstants.MESSAGE_ID),
    APP_ID((short) 4, "appId"),
    MESSAGE_TS((short) 5, "messageTs"),
    TOPIC((short) 6, "topic"),
    ALIAS_NAME((short) 7, "aliasName"),
    REQUEST((short) 8, SocialConstants.TYPE_REQUEST),
    PACKAGE_NAME((short) 9, Constants.KEY_PACKAGE_NAME),
    CATEGORY((short) 10, "category"),
    IS_ONLINE((short) 11, "isOnline"),
    REG_ID((short) 12, "regId"),
    CALLBACK_URL((short) 13, "callbackUrl"),
    USER_ACCOUNT((short) 14, "userAccount"),
    DEVICE_STATUS((short) 15, "deviceStatus"),
    GEO_MSG_STATUS((short) 16, "geoMsgStatus"),
    IMEI_MD5((short) 20, "imeiMd5"),
    DEVICE_ID((short) 21, "deviceId"),
    PASS_THROUGH((short) 22, "passThrough"),
    EXTRA((short) 23, "extra");
    
    private static final Map<String, z$a> u = null;
    private final short v;
    private final String w;

    static {
        u = new HashMap();
        Iterator it = EnumSet.allOf(z$a.class).iterator();
        while (it.hasNext()) {
            z$a com_xiaomi_xmpush_thrift_z_a = (z$a) it.next();
            u.put(com_xiaomi_xmpush_thrift_z_a.a(), com_xiaomi_xmpush_thrift_z_a);
        }
    }

    private z$a(short s, String str) {
        this.v = s;
        this.w = str;
    }

    public final String a() {
        return this.w;
    }
}
