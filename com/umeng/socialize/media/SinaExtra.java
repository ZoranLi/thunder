package com.umeng.socialize.media;

import android.content.Context;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.PlatformConfig.APPIDPlatform;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.HashMap;
import java.util.Map;

public class SinaExtra {

    final class AnonymousClass1 implements RequestListener {
        final /* synthetic */ UMAuthListener val$listener;

        AnonymousClass1(UMAuthListener uMAuthListener) {
            this.val$listener = uMAuthListener;
        }

        public final void onComplete(String str) {
            Map hashMap = new HashMap();
            hashMap.put("result", str);
            this.val$listener.onComplete(SHARE_MEDIA.SINA, 2, hashMap);
        }

        public final void onWeiboException(WeiboException weiboException) {
            this.val$listener.onError(SHARE_MEDIA.SINA, 2, new Throwable(weiboException));
        }
    }

    public static void judgeAccessToken(Context context, String str, UMAuthListener uMAuthListener) {
        WeiboParameters weiboParameters = new WeiboParameters(((APPIDPlatform) PlatformConfig.getPlatform(SHARE_MEDIA.SINA)).appId);
        weiboParameters.put("access_token", str);
        new AsyncWeiboRunner(context).requestAsync("https://api.weibo.com/oauth2/get_token_info", weiboParameters, "POST", new AnonymousClass1(uMAuthListener));
    }
}
