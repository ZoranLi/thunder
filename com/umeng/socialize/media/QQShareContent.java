package com.umeng.socialize.media;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.UmengText;

public class QQShareContent extends SimpleShareContent {
    public int mShareType = 1;
    private String mediaTitle = "";
    private String mediades = "";

    public QQShareContent(ShareContent shareContent) {
        super(shareContent);
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof UMusic)) {
            setMusic((UMusic) shareContent.mMedia);
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof UMVideo)) {
            setVideo((UMVideo) shareContent.mMedia);
        }
    }

    public Bundle buildParams(boolean z, String str) {
        Bundle bundle = new Bundle();
        if (getmStyle() != 2) {
            if (getmStyle() != 3) {
                if (getmStyle() == 4) {
                    if (getMusic() != null) {
                        this.mShareType = 2;
                    }
                    buildAudioParams(bundle);
                } else if (getmStyle() == 16) {
                    buildWebParams(bundle);
                } else if (getmStyle() == 8) {
                    buildVideoParams(bundle);
                } else {
                    bundle.putString("error", UmengText.supportStyle(false, "text"));
                }
                bundle.putInt("req_type", this.mShareType);
                if (z) {
                    bundle.putInt("cflag", 1);
                } else {
                    bundle.putInt("cflag", 2);
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("appName", str);
                }
                return bundle;
            }
        }
        this.mShareType = 5;
        buildImageParams(bundle);
        bundle.putInt("req_type", this.mShareType);
        if (z) {
            bundle.putInt("cflag", 1);
        } else {
            bundle.putInt("cflag", 2);
        }
        if (TextUtils.isEmpty(str)) {
            bundle.putString("appName", str);
        }
        return bundle;
    }

    private void buildImageParams(android.os.Bundle r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.getImage();
        if (r0 == 0) goto L_0x0029;
    L_0x0006:
        r0 = r2.getImage();
        r0 = r0.asFileImage();
        if (r0 == 0) goto L_0x0022;
    L_0x0010:
        r0 = "imageLocalUrl";	 Catch:{ Exception -> 0x0022 }
        r1 = r2.getImage();	 Catch:{ Exception -> 0x0022 }
        r1 = r1.asFileImage();	 Catch:{ Exception -> 0x0022 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0022 }
        r3.putString(r0, r1);	 Catch:{ Exception -> 0x0022 }
        return;
    L_0x0022:
        r0 = "error";
        r1 = com.umeng.socialize.utils.UmengText.QQ_PERMISSION;
        r3.putString(r0, r1);
    L_0x0029:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.media.QQShareContent.buildImageParams(android.os.Bundle):void");
    }

    private void buildText(Bundle bundle) {
        bundle.putString("summary", getText());
    }

    private void buildVideoParams(Bundle bundle) {
        bundle.putString("title", objectSetTitle(getVideo()));
        bundle.putString("summary", objectSetDescription(getVideo()));
        UMImage thumbImage = getVideo().getThumbImage();
        if (thumbImage != null) {
            if (thumbImage.isUrlMedia()) {
                bundle.putString("imageUrl", thumbImage.toUrl());
            } else if (thumbImage == null || thumbImage.asFileImage() == null) {
                bundle.putString("error", UmengText.QQ_PERMISSION);
            } else {
                bundle.putString("imageLocalUrl", thumbImage.asFileImage().toString());
            }
        }
        bundle.putString("targetUrl", getVideo().toUrl());
    }

    private void buildWebParams(Bundle bundle) {
        bundle.putString("title", objectSetTitle(getUmWeb()));
        bundle.putString("summary", objectSetDescription(getUmWeb()));
        UMImage thumbImage = getUmWeb().getThumbImage();
        if (thumbImage != null) {
            if (thumbImage.isUrlMedia()) {
                bundle.putString("imageUrl", thumbImage.toUrl());
            } else if (thumbImage == null || thumbImage.asFileImage() == null) {
                bundle.putString("error", UmengText.QQ_PERMISSION);
            } else {
                bundle.putString("imageLocalUrl", thumbImage.asFileImage().toString());
            }
        }
        if (TextUtils.isEmpty(getUmWeb().toUrl())) {
            bundle.putString("error", UmengText.EMPTY_WEB_URL);
        }
        bundle.putString("targetUrl", getUmWeb().toUrl());
    }

    private void buildAudioParams(Bundle bundle) {
        bundle.putString("title", objectSetTitle(getMusic()));
        bundle.putString("summary", objectSetDescription(getMusic()));
        UMImage thumbImage = getMusic().getThumbImage();
        if (thumbImage != null) {
            if (thumbImage.isUrlMedia()) {
                bundle.putString("imageUrl", thumbImage.toUrl());
            } else if (thumbImage == null || thumbImage.asFileImage() == null) {
                bundle.putString("error", UmengText.QQ_PERMISSION);
            } else {
                bundle.putString("imageLocalUrl", thumbImage.asFileImage().toString());
            }
        }
        if (TextUtils.isEmpty(getMusic().getmTargetUrl())) {
            bundle.putString("targetUrl", getMusic().toUrl());
            Log.um(UmengText.QQ_MUSIC);
        } else {
            bundle.putString("targetUrl", getMusic().getmTargetUrl());
        }
        bundle.putString("audio_url", getMusic().toUrl());
    }
}
