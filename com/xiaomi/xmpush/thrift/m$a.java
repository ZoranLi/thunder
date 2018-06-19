package com.xiaomi.xmpush.thrift;

import com.alipay.sdk.cons.c;
import com.taobao.accs.common.Constants;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

public enum m$a {
    ID((short) 1, AgooConstants.MESSAGE_ID),
    NAME((short) 2, c.e),
    APP_ID((short) 3, "appId"),
    PACKAGE_NAME((short) 4, Constants.KEY_PACKAGE_NAME),
    CREATE_TIME((short) 5, "createTime"),
    TYPE((short) 6, "type"),
    CIRCLE_CENTER((short) 7, "circleCenter"),
    CIRCLE_RADIUS((short) 9, "circleRadius"),
    POLYGON_POINTS((short) 10, "polygonPoints"),
    COORDINATE_PROVIDER((short) 11, "coordinateProvider");
    
    private static final Map<String, m$a> k = null;
    private final short l;
    private final String m;

    static {
        k = new HashMap();
        Iterator it = EnumSet.allOf(m$a.class).iterator();
        while (it.hasNext()) {
            m$a com_xiaomi_xmpush_thrift_m_a = (m$a) it.next();
            k.put(com_xiaomi_xmpush_thrift_m_a.a(), com_xiaomi_xmpush_thrift_m_a);
        }
    }

    private m$a(short s, String str) {
        this.l = s;
        this.m = str;
    }

    public final String a() {
        return this.m;
    }
}
