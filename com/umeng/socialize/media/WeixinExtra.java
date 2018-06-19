package com.umeng.socialize.media;

import com.umeng.socialize.UMAuthListener;

public class WeixinExtra {

    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ UMAuthListener val$umAuthListener;
        final /* synthetic */ String val$url;

        AnonymousClass1(String str, UMAuthListener uMAuthListener) {
            this.val$url = str;
            this.val$umAuthListener = uMAuthListener;
        }

        public final void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.val$url;
            r0 = com.umeng.socialize.weixin.net.WXAuthUtils.request(r0);
            r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0014 }
            r1.<init>(r0);	 Catch:{ JSONException -> 0x0014 }
            r0 = new com.umeng.socialize.media.WeixinExtra$1$1;	 Catch:{ JSONException -> 0x0014 }
            r0.<init>(r1);	 Catch:{ JSONException -> 0x0014 }
            com.umeng.socialize.common.QueuedWork.runInMain(r0);	 Catch:{ JSONException -> 0x0014 }
            return;
        L_0x0014:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.media.WeixinExtra.1.run():void");
        }
    }

    public static void isAccessTokenValid(String str, String str2, UMAuthListener uMAuthListener) {
        StringBuilder stringBuilder = new StringBuilder("https://api.weixin.qq.com/sns/auth?access_token=");
        stringBuilder.append(str);
        stringBuilder.append("&openid=");
        stringBuilder.append(str2);
        new Thread(new AnonymousClass1(stringBuilder.toString(), uMAuthListener)).start();
    }
}
