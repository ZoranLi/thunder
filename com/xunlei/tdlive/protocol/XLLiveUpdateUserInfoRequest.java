package com.xunlei.tdlive.protocol;

import android.text.TextUtils;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.tdlive.util.e.h;

public class XLLiveUpdateUserInfoRequest extends XLLiveRequest {
    private String mNickName;
    private String mSex;
    private String mSign;

    protected String onGetURL() {
        return "http://biz.live.xunlei.com/caller?c=user&a=update";
    }

    protected boolean useHttpPost() {
        return true;
    }

    public XLLiveUpdateUserInfoRequest(String str, String str2, String str3) {
        this.mNickName = str;
        this.mSign = str2;
        this.mSex = str3;
    }

    protected void onAddBodyParams(h hVar) {
        int i = "u".equals(this.mSex) ? 0 : "m".equals(this.mSex) ? 1 : f.a.equals(this.mSex) ? 2 : -1;
        if (i != -1) {
            hVar.a("sex", i);
        }
        if (!TextUtils.isEmpty(this.mNickName)) {
            hVar.b("nickname", this.mNickName);
        }
        if (!TextUtils.isEmpty(this.mSign)) {
            hVar.b("sign", this.mSign);
        }
    }
}
