package com.huawei.hms.support.api.push;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;

public class HuaweiPush {
    public static final HuaweiPushApi HuaweiPushApi = new HuaweiPushApiImp();
    public static final Api<NoOptions> PUSH_API = new Api("HuaweiPush.API");
}
