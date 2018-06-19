package com.xunlei.downloadprovider.ad.common.adget;

import com.umeng.message.util.HttpRequest;
import com.xunlei.common.androidutil.AndroidConfig;
import java.util.HashMap;

final class AgGet$ReportRequest$1 extends HashMap<String, String> {
    AgGet$ReportRequest$1() {
        put(HttpRequest.HEADER_USER_AGENT, AndroidConfig.getUserAgent());
    }
}
