package com.xunlei.downloadprovider.database.greendao;

import com.alipay.sdk.cons.c;
import org.android.agoo.common.AgooConstants;
import org.greenrobot.greendao.Property;

public class CollectWebsiteInfoDao$Properties {
    public static final Property IconUrl = new Property(3, String.class, "iconUrl", false, "iconUrl");
    public static final Property Id = new Property(0, Long.class, AgooConstants.MESSAGE_ID, true, "_id");
    public static final Property OperateTime = new Property(4, String.class, "operateTime", false, "collectTime");
    public static final Property WebsiteName = new Property(2, String.class, "websiteName", false, c.e);
    public static final Property WebsiteUrl = new Property(1, String.class, "websiteUrl", false, "WEBSITE_URL");
}
