package com.umeng.socialize.net;

import android.content.Context;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.net.utils.URequest.RequestMethod;
import com.umeng.socialize.utils.SocializeUtils;

public class SharePostRequest extends SocializeRequest {
    private static final String a = "/share/add/";
    private static final int b = 9;
    private String c;
    private String d;
    private ShareContent e;

    public SharePostRequest(Context context, String str, String str2, ShareContent shareContent) {
        super(context, "", SocializeReseponse.class, 9, RequestMethod.POST);
        this.mContext = context;
        this.c = str;
        this.d = str2;
        this.e = shareContent;
    }

    public void onPrepareRequest() {
        addStringParams("to", this.c);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_COMMENT_TEXT, this.e.mText);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_SHARE_USID, this.d);
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_AK, SocializeUtils.getAppkey(this.mContext));
        addStringParams(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY, Config.EntityKey);
        addMediaParams(this.e.mMedia);
    }

    protected String getPath() {
        StringBuilder stringBuilder = new StringBuilder(a);
        stringBuilder.append(SocializeUtils.getAppkey(this.mContext));
        stringBuilder.append("/");
        stringBuilder.append(Config.EntityKey);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }
}
