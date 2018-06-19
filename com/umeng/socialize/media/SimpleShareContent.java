package com.umeng.socialize.media;

import android.text.TextUtils;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.a.a.a;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.UmengText;
import java.io.File;

public class SimpleShareContent {
    public final String DEFAULT_DESCRIPTION = "这里是描述";
    public final String DEFAULT_TITLE = "这里是标题";
    public final int IMAGE_LIMIT = 491520;
    public final int THUMB_LIMIT = 24576;
    public final int WX_THUMB_LIMIT = 18432;
    private UMImage a;
    private String b;
    private UMVideo c;
    private UMEmoji d;
    private UMusic e;
    private UMMin f;
    private UMWeb g;
    private File h;
    private BaseMediaObject i;
    private int j;
    private String k;
    private String l;

    public SimpleShareContent(ShareContent shareContent) {
        this.b = shareContent.mText;
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof UMImage)) {
            this.a = (UMImage) shareContent.mMedia;
            this.i = this.a;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof UMusic)) {
            this.e = (UMusic) shareContent.mMedia;
            this.i = this.e;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof UMVideo)) {
            this.c = (UMVideo) shareContent.mMedia;
            this.i = this.c;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof UMEmoji)) {
            this.d = (UMEmoji) shareContent.mMedia;
            this.i = this.d;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof UMWeb)) {
            this.g = (UMWeb) shareContent.mMedia;
            this.i = this.g;
        }
        if (shareContent.mMedia != null && (shareContent.mMedia instanceof UMMin)) {
            this.f = (UMMin) shareContent.mMedia;
            this.i = this.g;
        }
        if (shareContent.file != null) {
            this.h = shareContent.file;
        }
        this.l = shareContent.subject;
        this.j = shareContent.getShareType();
        this.k = a();
    }

    private String a() {
        int i = this.j;
        if (i == 8) {
            return "video";
        }
        if (i == 16) {
            return "web";
        }
        if (i == 32) {
            return "file";
        }
        if (i == 64) {
            return "emoji";
        }
        if (i == 128) {
            return "minapp";
        }
        switch (i) {
            case 1:
                return "text";
            case 2:
                return "image";
            case 3:
                return "textandimage";
            case 4:
                return "music";
            default:
                return "error";
        }
    }

    public File getFile() {
        return this.h;
    }

    public UMEmoji getUmEmoji() {
        return this.d;
    }

    public BaseMediaObject getBaseMediaObject() {
        return this.i;
    }

    public String getSubject() {
        return this.l;
    }

    public String getAssertSubject() {
        if (TextUtils.isEmpty(this.l)) {
            return "umengshare";
        }
        return this.l;
    }

    public String getStrStyle() {
        return this.k;
    }

    public int getmStyle() {
        return this.j;
    }

    public UMWeb getUmWeb() {
        return this.g;
    }

    public UMMin getUmMin() {
        return this.f;
    }

    public void setText(String str) {
        this.b = str;
    }

    public String getText() {
        return this.b;
    }

    public void setImage(UMImage uMImage) {
        this.a = uMImage;
    }

    public UMImage getImage() {
        return this.a;
    }

    public void setMusic(UMusic uMusic) {
        this.e = uMusic;
    }

    public UMusic getMusic() {
        return this.e;
    }

    public void setVideo(UMVideo uMVideo) {
        this.c = uMVideo;
    }

    public UMVideo getVideo() {
        return this.c;
    }

    public String objectSetTitle(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getTitle())) {
            return "这里是标题";
        }
        baseMediaObject = baseMediaObject.getTitle();
        if (baseMediaObject.length() > 512) {
            baseMediaObject = baseMediaObject.substring(0, 512);
        }
        return baseMediaObject;
    }

    public String objectSetDescription(BaseMediaObject baseMediaObject) {
        if (TextUtils.isEmpty(baseMediaObject.getDescription())) {
            return "这里是描述";
        }
        baseMediaObject = baseMediaObject.getDescription();
        if (baseMediaObject.length() > 1024) {
            baseMediaObject = baseMediaObject.substring(0, 1024);
        }
        return baseMediaObject;
    }

    public String objectSetText(String str) {
        if (TextUtils.isEmpty(str)) {
            return "这里是描述";
        }
        if (str.length() > 10240) {
            str = str.substring(0, 10240);
        }
        return str;
    }

    public byte[] objectSetThumb(BaseMediaObject baseMediaObject) {
        if (baseMediaObject.getThumbImage() == null) {
            return null;
        }
        baseMediaObject = a.a(baseMediaObject.getThumbImage(), 24576);
        if (baseMediaObject == null || baseMediaObject.length <= 0) {
            Log.um(UmengText.SHARECONTENT_THUMB_ERROR);
        }
        return baseMediaObject;
    }

    public String getMusicTargetUrl(UMusic uMusic) {
        if (TextUtils.isEmpty(uMusic.getmTargetUrl())) {
            return uMusic.toUrl();
        }
        return uMusic.getmTargetUrl();
    }

    public byte[] getImageThumb(UMImage uMImage) {
        if (uMImage.getThumbImage() != null) {
            uMImage = a.a(uMImage.getThumbImage(), 18432);
            if (uMImage == null || uMImage.length <= 0) {
                Log.um(UmengText.SHARECONTENT_THUMB_ERROR);
            }
            return uMImage;
        }
        uMImage = a.a(uMImage, 18432);
        if (uMImage == null || uMImage.length <= 0) {
            Log.um(UmengText.SHARECONTENT_THUMB_ERROR);
        }
        return uMImage;
    }

    public byte[] getImageData(UMImage uMImage) {
        return uMImage.asBinImage();
    }

    public byte[] getStrictImageData(UMImage uMImage) {
        if (getUMImageScale(uMImage) <= 491520) {
            return getImageData(uMImage);
        }
        uMImage = a.a(getImage(), 491520);
        if (uMImage != null && uMImage.length > 0) {
            return uMImage;
        }
        Log.um(UmengText.SHARECONTENT_THUMB_ERROR);
        return null;
    }

    public int getUMImageScale(UMImage uMImage) {
        return a.a(uMImage);
    }

    public String subString(String str, int i) {
        return (!TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public boolean canFileValid(UMImage uMImage) {
        return uMImage.asFileImage() != null ? true : null;
    }
}
