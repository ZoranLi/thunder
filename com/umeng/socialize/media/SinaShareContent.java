package com.umeng.socialize.media;

import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.utils.Utility;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.net.LinkCardResponse;
import com.umeng.socialize.net.LinkcardRequest;
import com.umeng.socialize.net.RestAPI;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.UmengText;

public class SinaShareContent extends SimpleShareContent {
    public SinaShareContent(ShareContent shareContent) {
        super(shareContent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sina.weibo.sdk.api.WeiboMultiMessage getMessage() {
        /*
        r3 = this;
        r0 = new com.sina.weibo.sdk.api.WeiboMultiMessage;
        r0.<init>();
        r1 = r3.getmStyle();
        r2 = 2;
        if (r1 == r2) goto L_0x0049;
    L_0x000c:
        r1 = r3.getmStyle();
        r2 = 3;
        if (r1 != r2) goto L_0x0014;
    L_0x0013:
        goto L_0x0049;
    L_0x0014:
        r1 = r3.getmStyle();
        r2 = 16;
        if (r1 != r2) goto L_0x0026;
    L_0x001c:
        r1 = r3.getWebpageObj();
        r0.mediaObject = r1;
        r3.addText(r0);
        goto L_0x005f;
    L_0x0026:
        r1 = r3.getmStyle();
        r2 = 4;
        if (r1 != r2) goto L_0x0037;
    L_0x002d:
        r1 = r3.getMusicObj();
        r0.mediaObject = r1;
        r3.addText(r0);
        goto L_0x005f;
    L_0x0037:
        r1 = r3.getmStyle();
        r2 = 8;
        if (r1 != r2) goto L_0x0059;
    L_0x003f:
        r1 = r3.getVideoObj();
        r0.mediaObject = r1;
        r3.addText(r0);
        goto L_0x005f;
    L_0x0049:
        r1 = r3.getImageObj();
        r0.imageObject = r1;
        r1 = r3.getText();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x005f;
    L_0x0059:
        r1 = r3.getTextObj();
        r0.textObject = r1;
    L_0x005f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.media.SinaShareContent.getMessage():com.sina.weibo.sdk.api.WeiboMultiMessage");
    }

    private WeiboMultiMessage addText(WeiboMultiMessage weiboMultiMessage) {
        if (TextUtils.isEmpty(getText())) {
            TextObject textObject = new TextObject();
            if (!(getBaseMediaObject() == null || TextUtils.isEmpty(getBaseMediaObject().getDescription()))) {
                textObject.text = getBaseMediaObject().getDescription();
            }
            weiboMultiMessage.textObject = textObject;
        } else {
            weiboMultiMessage.textObject = getTextObj();
        }
        return weiboMultiMessage;
    }

    private WeiboMultiMessage addImage(WeiboMultiMessage weiboMultiMessage) {
        if (!(getBaseMediaObject() == null || getBaseMediaObject().getThumbImage() == null)) {
            ImageObject imageObject = new ImageObject();
            if (canFileValid(getBaseMediaObject().getThumbImage())) {
                imageObject.imagePath = getBaseMediaObject().getThumbImage().asFileImage().toString();
            } else {
                imageObject.imageData = getImageData(getBaseMediaObject().getThumbImage());
            }
            weiboMultiMessage.imageObject = imageObject;
        }
        return weiboMultiMessage;
    }

    private TextObject getTextObj() {
        TextObject textObject = new TextObject();
        textObject.text = getText();
        return textObject;
    }

    private ImageObject getImageObj() {
        ImageObject imageObject = new ImageObject();
        if (canFileValid(getImage())) {
            imageObject.imagePath = getImage().asFileImage().toString();
        } else {
            imageObject.imageData = getImageData(getImage());
        }
        imageObject.thumbData = objectSetThumb(getImage());
        imageObject.description = getText();
        return imageObject;
    }

    private WebpageObject getWebpageObj() {
        LinkcardRequest linkcardRequest = new LinkcardRequest(ContextUtil.getContext());
        linkcardRequest.setMedia(getUmWeb());
        LinkCardResponse convertLinkCard = RestAPI.convertLinkCard(linkcardRequest);
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = objectSetTitle(getUmWeb());
        webpageObject.description = objectSetDescription(getUmWeb());
        if (getUmWeb().getThumbImage() != null) {
            webpageObject.thumbData = objectSetThumb(getUmWeb());
        } else {
            Log.um(UmengText.SINA_THUMB_ERROR);
        }
        if (convertLinkCard == null || TextUtils.isEmpty(convertLinkCard.url)) {
            webpageObject.actionUrl = getUmWeb().toUrl();
        } else {
            webpageObject.actionUrl = convertLinkCard.url;
        }
        webpageObject.defaultText = getText();
        return webpageObject;
    }

    private WebpageObject getMusicObj() {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = objectSetTitle(getMusic());
        webpageObject.description = objectSetDescription(getMusic());
        if (getMusic().getThumbImage() != null) {
            webpageObject.thumbData = objectSetThumb(getMusic());
        } else {
            Log.um(UmengText.SINA_THUMB_ERROR);
        }
        webpageObject.actionUrl = getMusic().getmTargetUrl();
        if (!TextUtils.isEmpty(getText())) {
            webpageObject.defaultText = getText();
        }
        return webpageObject;
    }

    private WebpageObject getVideoObj() {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = objectSetTitle(getVideo());
        webpageObject.description = objectSetDescription(getVideo());
        if (getVideo().getThumbImage() != null) {
            webpageObject.thumbData = objectSetThumb(getVideo());
        } else {
            Log.um(UmengText.SINA_THUMB_ERROR);
        }
        webpageObject.actionUrl = getVideo().toUrl();
        if (!TextUtils.isEmpty(getVideo().getDescription())) {
            webpageObject.description = getVideo().getDescription();
        }
        webpageObject.defaultText = getText();
        return webpageObject;
    }
}
