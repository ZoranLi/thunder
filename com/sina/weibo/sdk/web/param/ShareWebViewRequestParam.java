package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam.ExtraTaskCallback;
import com.taobao.accs.common.Constants;
import com.tencent.open.SocialConstants;

public class ShareWebViewRequestParam extends BaseWebViewRequestParam {
    private static final String SHARE_URL = "http://service.weibo.com/share/mobilesdk.php";
    private static final String UPLOAD_PIC_URL = "http://service.weibo.com/share/mobilesdk_uppic.php";
    private String hashKey;
    private byte[] mBase64ImgData;
    private String mShareContent;
    private WeiboMultiMessage multiMessage;
    private String packageName;
    private String picId;
    private String token;

    public ShareWebViewRequestParam(Context context) {
        this.context = context;
    }

    public ShareWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        this(authInfo, webRequestType, str, 0, str2, str3, context);
    }

    public ShareWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, int i, String str2, String str3, Context context) {
        super(authInfo, webRequestType, str, i, str2, str3, context);
    }

    public boolean hasExtraTask() {
        if (this.mBase64ImgData == null || this.mBase64ImgData.length <= 0) {
            return super.hasExtraTask();
        }
        return true;
    }

    public void doExtraTask(final ExtraTaskCallback extraTaskCallback) {
        super.doExtraTask(extraTaskCallback);
        WeiboParameters weiboParameters = new WeiboParameters(getBaseData().getAuthInfo().getAppKey());
        weiboParameters.put(SocialConstants.PARAM_IMG_URL, new String(this.mBase64ImgData));
        new AsyncWeiboRunner(this.context).requestAsync(UPLOAD_PIC_URL, weiboParameters, "POST", new RequestListener() {
            public void onWeiboException(WeiboException weiboException) {
                if (extraTaskCallback != null) {
                    extraTaskCallback.onException("upload pic fail");
                }
            }

            public void onComplete(String str) {
                str = WebPicUploadResult.parse(str);
                if (str != null && str.getCode() == 1 && !TextUtils.isEmpty(str.getPicId())) {
                    ShareWebViewRequestParam.this.picId = str.getPicId();
                    if (extraTaskCallback != null) {
                        extraTaskCallback.onComplete(ShareWebViewRequestParam.this.picId);
                    }
                } else if (extraTaskCallback != null) {
                    extraTaskCallback.onException("upload pic fail");
                }
            }
        });
    }

    protected void childFillBundle(Bundle bundle) {
        if (this.multiMessage != null) {
            this.multiMessage.toBundle(bundle);
        }
        bundle.putString("token", this.token);
        bundle.putString(Constants.KEY_PACKAGE_NAME, this.packageName);
        bundle.putString("hashKey", this.hashKey);
    }

    protected void transformChildBundle(Bundle bundle) {
        this.multiMessage = new WeiboMultiMessage();
        this.multiMessage.toObject(bundle);
        this.token = bundle.getString("token");
        this.packageName = bundle.getString(Constants.KEY_PACKAGE_NAME);
        this.hashKey = bundle.getString("hashKey");
        getBaseUrl();
    }

    public String getRequestUrl() {
        String appKey = getBaseData().getAuthInfo().getAppKey();
        Builder buildUpon = Uri.parse(SHARE_URL).buildUpon();
        buildUpon.appendQueryParameter("title", this.mShareContent);
        buildUpon.appendQueryParameter("version", WbSdkVersion.WEIBO_SDK_VERSION_CODE);
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.token)) {
            buildUpon.appendQueryParameter("access_token", this.token);
        }
        if (this.context != null) {
            Object aid = Utility.getAid(this.context, appKey);
            if (!TextUtils.isEmpty(aid)) {
                buildUpon.appendQueryParameter("aid", aid);
            }
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            buildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.hashKey)) {
            buildUpon.appendQueryParameter("key_hash", this.hashKey);
        }
        if (!TextUtils.isEmpty(this.picId)) {
            buildUpon.appendQueryParameter("picinfo", this.picId);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        StringBuilder stringBuilder = new StringBuilder("OP_");
        stringBuilder.append(appKey);
        buildUpon.appendQueryParameter("lfid", stringBuilder.toString());
        return buildUpon.build().toString();
    }

    public void updateRequestUrl(String str) {
        this.picId = str;
    }

    public void setMultiMessage(WeiboMultiMessage weiboMultiMessage) {
        this.multiMessage = weiboMultiMessage;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setHashKey(String str) {
        this.hashKey = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    private void getBaseUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.multiMessage.textObject instanceof TextObject) {
            TextObject textObject = this.multiMessage.textObject;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(textObject.text);
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (!(this.multiMessage.mediaObject == null || !(this.multiMessage.mediaObject instanceof WebpageObject) || TextUtils.isEmpty(this.multiMessage.mediaObject.actionUrl))) {
            stringBuilder.append(this.multiMessage.mediaObject.actionUrl);
        }
        if (this.multiMessage.imageObject instanceof ImageObject) {
            ImageObject imageObject = this.multiMessage.imageObject;
            handleMblogPic(imageObject.imagePath, imageObject.imageData);
        }
        this.mShareContent = stringBuilder.toString();
    }

    private void handleMblogPic(java.lang.String r6, byte[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = android.text.TextUtils.isEmpty(r6);	 Catch:{  }
        if (r0 != 0) goto L_0x004d;	 Catch:{  }
    L_0x0006:
        r0 = new java.io.File;	 Catch:{  }
        r0.<init>(r6);	 Catch:{  }
        r6 = r0.exists();	 Catch:{  }
        if (r6 == 0) goto L_0x004d;	 Catch:{  }
    L_0x0011:
        r6 = r0.canRead();	 Catch:{  }
        if (r6 == 0) goto L_0x004d;	 Catch:{  }
    L_0x0017:
        r1 = r0.length();	 Catch:{  }
        r3 = 0;	 Catch:{  }
        r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{  }
        if (r6 <= 0) goto L_0x004d;	 Catch:{  }
    L_0x0021:
        r1 = r0.length();	 Catch:{  }
        r6 = (int) r1;	 Catch:{  }
        r6 = new byte[r6];	 Catch:{  }
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0048, all -> 0x0040 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0048, all -> 0x0040 }
        r2.read(r6);	 Catch:{ IOException -> 0x003e, all -> 0x003c }
        r6 = com.sina.weibo.sdk.utils.Base64.encodebyte(r6);	 Catch:{ IOException -> 0x003e, all -> 0x003c }
        r5.mBase64ImgData = r6;	 Catch:{ IOException -> 0x003e, all -> 0x003c }
        r2.close();	 Catch:{ Exception -> 0x003b }
        return;
    L_0x003b:
        return;
    L_0x003c:
        r6 = move-exception;
        goto L_0x0042;
    L_0x003e:
        r1 = r2;
        goto L_0x0048;
    L_0x0040:
        r6 = move-exception;
        r2 = r1;
    L_0x0042:
        if (r2 == 0) goto L_0x0047;
    L_0x0044:
        r2.close();	 Catch:{ Exception -> 0x0047 }
    L_0x0047:
        throw r6;	 Catch:{  }
    L_0x0048:
        if (r1 == 0) goto L_0x004d;
    L_0x004a:
        r1.close();	 Catch:{ SecurityException -> 0x004d }
    L_0x004d:
        if (r7 == 0) goto L_0x0058;
    L_0x004f:
        r6 = r7.length;
        if (r6 <= 0) goto L_0x0058;
    L_0x0052:
        r6 = com.sina.weibo.sdk.utils.Base64.encodebyte(r7);
        r5.mBase64ImgData = r6;
    L_0x0058:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.web.param.ShareWebViewRequestParam.handleMblogPic(java.lang.String, byte[]):void");
    }
}
