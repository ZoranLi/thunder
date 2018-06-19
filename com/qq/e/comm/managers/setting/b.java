package com.qq.e.comm.managers.setting;

import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public final class b extends c {
    public b() {
        a(KEYS.SDKServerGetADReportSamplingRate, Integer.valueOf(1));
        a(KEYS.SDKServerExpReportSamplingRate, Integer.valueOf(1));
        a(KEYS.SDKServerClickReportSamplingRate, Integer.valueOf(100));
        a(KEYS.RequireWindowFocus, Integer.valueOf(1));
        a(KEYS.SHOW_LOGO, Integer.valueOf(1));
        a(KEYS.INNER_BROWSER_SCHEME, "weixin,tel,openapp.jdmobile");
        a(KEYS.THIRD_PARTY_BROWSER, "com.android.browser,com.android.chrome,com.baidu.browser.apps,com.UCMobile,com.tencent.mtt");
        a(KEYS.FLOW_CONTROL, Integer.valueOf(1));
        a(KEYS.Banner_RF, Integer.valueOf(a.MAX_USERDATA_VALUE_LENGTH));
        a(KEYS.SPLASH_LOADTIMEOUT, Integer.valueOf(3000));
        a(KEYS.SPLASH_EXPOSURE_TIME, Integer.valueOf(ReaderCallback.GET_BAR_ANIMATING));
        a(KEYS.SPLASH_NETWORK_PERMISION, Integer.valueOf(26));
        a(KEYS.SPLASH_MAX_REQUEST_NUM, Integer.valueOf(100));
        a(KEYS.FORCE_EXPOSURE, Integer.valueOf(1));
    }
}
