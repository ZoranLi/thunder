package com.xunlei.downloadprovidershare;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.BuildConfig;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMImage.CompressStyle;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMWeb;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovidershare.a.f;

/* compiled from: ShareProxy */
public final class n {
    private static boolean b = false;
    private static IWXAPI c;
    public a a;
    private UMShareListener d = new o(this);

    /* compiled from: ShareProxy */
    interface a {
        void a(int i);
    }

    public n() {
        if (!b) {
            PlatformConfig.setWeixin("wx3e6556568beeebdd", "1d0e9649237be9fc548a641487d255d6");
            PlatformConfig.setQQZone("1101105049", "NbcsjO1otax6pi3L");
            PlatformConfig.setSinaWeibo("4286195229", "93b740fa1feca6c6a3b7487107cd274c", "http://sns.whalecloud.com");
            b = true;
        }
    }

    public static void a(Activity activity) {
        if (activity != null) {
            UMShareAPI.get(activity).release();
        }
    }

    public final void a(Activity activity, ShareOperationType shareOperationType, f fVar, a aVar) {
        SHARE_MEDIA share_media;
        switch (p.a[shareOperationType.ordinal()]) {
            case 1:
                share_media = SHARE_MEDIA.WEIXIN;
                break;
            case 2:
                share_media = SHARE_MEDIA.WEIXIN_CIRCLE;
                break;
            case 3:
                share_media = SHARE_MEDIA.QQ;
                break;
            case 4:
                share_media = SHARE_MEDIA.QZONE;
                break;
            case 5:
                share_media = SHARE_MEDIA.SINA;
                break;
            default:
                fVar = new StringBuilder("operation type ");
                fVar.append(shareOperationType);
                fVar.append(" is can not share");
                throw new IllegalArgumentException(fVar.toString());
        }
        boolean z = false;
        switch (p.a[shareOperationType.ordinal()]) {
            case 1:
            case 2:
                if (c == null) {
                    c = WXAPIFactory.createWXAPI(activity.getApplicationContext(), "wx3e6556568beeebdd", false);
                }
                z = c.isWXAppInstalled();
                if (!z) {
                    XLToast.showToast(activity, "尚未安装微信");
                    break;
                }
                break;
            case 3:
            case 4:
                z = ApkHelper.isApkPackageInstalled(activity, "com.tencent.mobileqq");
                if (!z) {
                    XLToast.showToast(activity, "尚未安装QQ");
                    break;
                }
                break;
            case 5:
                z = ApkHelper.isApkPackageInstalled(activity, BuildConfig.APPLICATION_ID);
                if (!z) {
                    XLToast.showToast(activity, "尚未安装新浪微博");
                    break;
                }
                break;
            default:
                break;
        }
        if (z) {
            this.a = aVar;
            aVar = fVar.l;
            if (shareOperationType == ShareOperationType.SINA) {
                aVar = 4;
            }
            ShareAction shareAction = new ShareAction(activity);
            shareAction.setPlatform(share_media).setCallback(this.d);
            UMImage uMImage = null;
            if (fVar.g != null) {
                uMImage = new UMImage((Context) activity, fVar.g);
            } else if (!TextUtils.isEmpty(fVar.h)) {
                uMImage = new UMImage((Context) activity, fVar.h);
            } else if (fVar.i > 0) {
                uMImage = new UMImage((Context) activity, fVar.i);
            }
            switch (p.a[shareOperationType.ordinal()]) {
                case 1:
                case 2:
                    activity = fVar.a();
                    break;
                case 3:
                case 4:
                    activity = fVar.b();
                    break;
                case 5:
                    activity = new StringBuilder();
                    activity.append('【');
                    activity.append(fVar.a());
                    activity.append('】');
                    activity.append("分享自@手机迅雷 ");
                    activity.append(fVar.f);
                    activity = activity.toString();
                    break;
                default:
                    activity = "";
                    break;
            }
            switch (aVar) {
                case 1:
                    UMVideo uMVideo = new UMVideo(fVar.f);
                    uMVideo.setThumb(uMImage);
                    uMVideo.setTitle(fVar.a());
                    uMVideo.setDescription(fVar.b());
                    shareAction.withText(activity).withMedia(uMVideo).share();
                    return;
                case 2:
                    shareAction.withMedia(uMImage).share();
                    return;
                case 3:
                    UMWeb uMWeb = new UMWeb(fVar.f);
                    uMWeb.setTitle(fVar.a());
                    uMWeb.setDescription(fVar.b());
                    uMWeb.setThumb(uMImage);
                    shareAction.withText(activity).withMedia(uMWeb).share();
                    break;
                case 4:
                    if (uMImage != null) {
                        uMImage.compressStyle = CompressStyle.SCALE;
                        uMImage.setTitle(fVar.a());
                        uMImage.setDescription(fVar.b());
                    }
                    shareAction.withText(activity).withMedia(uMImage).share();
                    return;
                default:
                    break;
            }
            return;
        }
        aVar.a(1);
    }
}
