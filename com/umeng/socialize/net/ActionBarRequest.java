package com.umeng.socialize.net;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest.RequestMethod;
import com.umeng.socialize.utils.SocializeUtils;

public class ActionBarRequest extends SocializeRequest {
    private static final String a = "/bar/get/";
    private static final int b = 1;
    private int c = 0;

    public ActionBarRequest(Context context, boolean z) {
        super(context, "", ActionBarResponse.class, 1, RequestMethod.GET);
        this.mContext = context;
        this.c = z;
        this.mMethod = RequestMethod.GET;
    }

    public void onPrepareRequest() {
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_DESCRIPTOR, Config.Descriptor);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_NEW_INSTALL, String.valueOf(this.c));
        if (!TextUtils.isEmpty(Config.EntityName)) {
            addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_NAME, Config.EntityName);
        }
    }

    protected String getPath() {
        StringBuilder stringBuilder = new StringBuilder(a);
        stringBuilder.append(SocializeUtils.getAppkey(this.mContext));
        stringBuilder.append("/");
        return stringBuilder.toString();
    }
}
