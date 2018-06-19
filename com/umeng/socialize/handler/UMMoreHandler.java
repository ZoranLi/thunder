package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig.Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.SocializeUtils;

public class UMMoreHandler extends UMSSOHandler {
    private Activity mAct;

    public void onCreate(Context context, Platform platform) {
        super.onCreate(context, platform);
        this.mAct = (Activity) context;
    }

    public boolean share(ShareContent shareContent, UMShareListener uMShareListener) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        if (shareContent.mMedia == null || !(shareContent.mMedia instanceof UMImage)) {
            intent.setType("text/plain");
        } else {
            intent.setType("image/*");
            UMImage uMImage = (UMImage) shareContent.mMedia;
            if (uMImage.asFileImage().getPath() != null) {
                intent.putExtra("android.intent.extra.STREAM", SocializeUtils.insertImage(getContext(), uMImage.asFileImage().getPath()));
            }
        }
        intent.putExtra("android.intent.extra.SUBJECT", shareContent.subject);
        intent.putExtra("android.intent.extra.TEXT", shareContent.mText);
        shareContent = Intent.createChooser(intent, Config.MORE_TITLE);
        shareContent.addFlags(268435456);
        try {
            if (!(this.mAct == null || this.mAct.isFinishing())) {
                this.mAct.startActivity(shareContent);
            }
            uMShareListener.onResult(SHARE_MEDIA.MORE);
        } catch (ShareContent shareContent2) {
            uMShareListener.onError(SHARE_MEDIA.MORE, shareContent2);
        }
        return true;
    }

    public void release() {
        super.release();
        this.mAct = null;
    }
}
