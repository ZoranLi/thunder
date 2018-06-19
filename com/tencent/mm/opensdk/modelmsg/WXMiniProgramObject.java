package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.a.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;

public class WXMiniProgramObject implements IMediaObject {
    private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
    public String path;
    public String userName;
    public String webpageUrl;

    public boolean checkArgs() {
        return (d.h(this.webpageUrl) || d.h(this.userName)) ? false : true;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
    }

    public int type() {
        return 36;
    }

    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
    }
}
