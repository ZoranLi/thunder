package com.umeng.socialize.net;

import android.content.Context;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.URequest.RequestMethod;
import com.umeng.socialize.utils.SocializeUtils;

public class PlatformTokenUploadReq extends SocializeRequest {
    private static final String a = "/share/token/";
    private static final int b = 21;

    public PlatformTokenUploadReq(Context context) {
        super(context, "", PlatformTokenUploadResponse.class, 21, RequestMethod.POST);
    }

    protected String getPath() {
        StringBuilder stringBuilder = new StringBuilder(a);
        stringBuilder.append(SocializeUtils.getAppkey(this.mContext));
        stringBuilder.append("/");
        return stringBuilder.toString();
    }
}
