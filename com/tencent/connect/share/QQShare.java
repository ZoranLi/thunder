package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.b;
import com.tencent.open.utils.c;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class QQShare extends BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 60;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 45;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_APP = 6;
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public String mViaShareQQType = "";

    public void releaseResource() {
    }

    public QQShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.QQShare", "shareToQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("imageLocalUrl");
        int i = bundle.getInt("req_type", 1);
        StringBuilder stringBuilder = new StringBuilder("shareToQQ -- type: ");
        stringBuilder.append(i);
        f.c("openSDK_LOG.QQShare", stringBuilder.toString());
        switch (i) {
            case 1:
                this.mViaShareQQType = "1";
                break;
            case 2:
                this.mViaShareQQType = "3";
                break;
            case 5:
                this.mViaShareQQType = "2";
                break;
            case 6:
                this.mViaShareQQType = "4";
                break;
            default:
                break;
        }
        if (i == 6) {
            if (i.f(activity, "5.0.0")) {
                iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                f.e("openSDK_LOG.QQShare", "shareToQQ, app share is not support below qq5.0.");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, app share is not support below qq5.0.");
                return;
            }
            string4 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", new Object[]{this.b.getAppId(), "mqq"});
            bundle.putString("targetUrl", string4);
        }
        if (i.b() || !i.f(activity, "4.5.0")) {
            if (i == 5) {
                if (i.f(activity, "4.3.0")) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_QQ_VERSION_ERROR, null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                    return;
                } else if (!i.h(string5)) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR);
                    return;
                }
            }
            if (i != 5) {
                if (!TextUtils.isEmpty(string4)) {
                    if (string4.startsWith("http://") || string4.startsWith("https://")) {
                        if (TextUtils.isEmpty(string2)) {
                            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                            f.e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                            return;
                        }
                    }
                }
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_ERROR, null));
                f.e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                return;
            }
            if (TextUtils.isEmpty(string) || string.startsWith("http://") || string.startsWith("https://") || new File(string).exists()) {
                if (!TextUtils.isEmpty(string2) && string2.length() > 45) {
                    bundle.putString("title", i.a(string2, 45, null, null));
                }
                if (!TextUtils.isEmpty(string3) && string3.length() > 60) {
                    bundle.putString("summary", i.a(string3, 60, null, null));
                }
                if (i.e((Context) activity)) {
                    f.c("openSDK_LOG.QQShare", "shareToQQ, support share");
                    b(activity, bundle, iUiListener);
                } else {
                    try {
                        f.d("openSDK_LOG.QQShare", "shareToQQ, don't support share, will show download dialog");
                        new TDialog(activity, "", a(""), null, this.b).show();
                    } catch (Activity activity2) {
                        f.b("openSDK_LOG.QQShare", " shareToQQ, TDialog.show not in main thread", activity2);
                        activity2.printStackTrace();
                        iUiListener.onError(new UiError(-6, Constants.MSG_NOT_CALL_ON_MAIN_THREAD, null));
                    }
                }
                f.c("openSDK_LOG.QQShare", "shareToQQ() -- end.");
                return;
            }
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
            f.e("openSDK_LOG.QQShare", "shareToQQ, image url is emprty or illegal.");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
            return;
        }
        iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
        f.e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
    }

    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        final String string2 = bundle.getString("title");
        final String string3 = bundle.getString("summary");
        StringBuilder stringBuilder = new StringBuilder("shareToMobileQQ -- imageUrl: ");
        stringBuilder.append(string);
        f.a("openSDK_LOG.QQShare", stringBuilder.toString());
        if (!TextUtils.isEmpty(string)) {
            final Bundle bundle2;
            final IUiListener iUiListener2;
            final Activity activity2;
            if (!i.g(string)) {
                bundle.putString("imageUrl", null);
                if (i.f(activity, "4.3.0")) {
                    f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                } else {
                    f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0 ");
                    bundle2 = bundle;
                    iUiListener2 = iUiListener;
                    activity2 = activity;
                    a.a((Context) activity, string, new c(this) {
                        final /* synthetic */ QQShare f;

                        public void a(int i, ArrayList<String> arrayList) {
                        }

                        public void a(int i, String str) {
                            if (i == 0) {
                                bundle2.putString("imageLocalUrl", str);
                            } else if (!(TextUtils.isEmpty(string2) == 0 || TextUtils.isEmpty(string3) == 0)) {
                                if (iUiListener2 != 0) {
                                    iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                    f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                                }
                                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                                return;
                            }
                            this.f.c(activity2, bundle2, iUiListener2);
                        }
                    });
                    f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
                }
            } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                    f.e("openSDK_LOG.QQShare", Constants.MSG_SHARE_NOSD_ERROR);
                }
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
                return;
            } else if (i.f(activity, "4.3.0")) {
                bundle2 = bundle;
                iUiListener2 = iUiListener;
                activity2 = activity;
                new b(activity).a(string, new c(this) {
                    final /* synthetic */ QQShare f;

                    public void a(int i, ArrayList<String> arrayList) {
                    }

                    public void a(int i, String str) {
                        if (i == 0) {
                            bundle2.putString("imageLocalUrl", str);
                        } else if (!(TextUtils.isEmpty(string2) == 0 || TextUtils.isEmpty(string3) == 0)) {
                            if (iUiListener2 != 0) {
                                iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        this.f.c(activity2, bundle2, iUiListener2);
                    }
                });
                f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
            }
        }
        c(activity, bundle, iUiListener);
        f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    private void c(Activity activity, Bundle bundle, IUiListener iUiListener) {
        StringBuilder stringBuilder;
        boolean z;
        String str;
        String str2;
        QQShare qQShare = this;
        Activity activity2 = activity;
        Bundle bundle2 = bundle;
        IUiListener iUiListener2 = iUiListener;
        f.c("openSDK_LOG.QQShare", "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        Object string = bundle2.getString("imageUrl");
        Object string2 = bundle2.getString("title");
        Object string3 = bundle2.getString("summary");
        Object string4 = bundle2.getString("targetUrl");
        Object string5 = bundle2.getString("audio_url");
        int i = bundle2.getInt("req_type", 1);
        boolean z2 = bundle2.getInt("cflag", 0);
        Object string6 = bundle2.getString("share_qq_ext_str");
        String a = i.a((Context) activity);
        if (a == null) {
            a = bundle2.getString("appName");
        }
        Object string7 = bundle2.getString("imageLocalUrl");
        Object appId = qQShare.b.getAppId();
        Object openId = qQShare.b.getOpenId();
        StringBuilder stringBuilder2 = new StringBuilder("doShareToQQ -- openid: ");
        stringBuilder2.append(openId);
        f.a("openSDK_LOG.QQShare", stringBuilder2.toString());
        if (!TextUtils.isEmpty(string)) {
            stringBuilder = new StringBuilder("&image_url=");
            stringBuilder.append(Base64.encodeToString(i.i(string), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string7)) {
            stringBuilder = new StringBuilder("&file_data=");
            stringBuilder.append(Base64.encodeToString(i.i(string7), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuilder = new StringBuilder("&title=");
            stringBuilder.append(Base64.encodeToString(i.i(string2), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuilder = new StringBuilder("&description=");
            stringBuilder.append(Base64.encodeToString(i.i(string3), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuilder = new StringBuilder("&share_id=");
            stringBuilder.append(appId);
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuilder = new StringBuilder("&url=");
            stringBuilder.append(Base64.encodeToString(i.i(string4), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(a)) {
            if (a.length() > 20) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a.substring(0, 20));
                stringBuilder.append("...");
                a = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder("&app_name=");
            stringBuilder.append(Base64.encodeToString(i.i(a), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuilder = new StringBuilder("&open_id=");
            stringBuilder.append(Base64.encodeToString(i.i(openId), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuilder = new StringBuilder("&audioUrl=");
            stringBuilder.append(Base64.encodeToString(i.i(string5), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder("&req_type=");
        stringBuilder.append(Base64.encodeToString(i.i(String.valueOf(i)), 2));
        stringBuffer.append(stringBuilder.toString());
        if (!TextUtils.isEmpty(string6)) {
            stringBuilder = new StringBuilder("&share_qq_ext_str=");
            stringBuilder.append(Base64.encodeToString(i.i(string6), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder("&cflag=");
        stringBuilder.append(Base64.encodeToString(i.i(String.valueOf(z2)), 2));
        stringBuffer.append(stringBuilder.toString());
        stringBuilder2 = new StringBuilder("doShareToQQ -- url: ");
        stringBuilder2.append(stringBuffer.toString());
        f.a("openSDK_LOG.QQShare", stringBuilder2.toString());
        a.a(com.tencent.open.utils.d.a(), this.b, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        Context context = activity;
        intent.putExtra("pkg_name", activity.getPackageName());
        if (i.f(context, "4.6.0")) {
            f.c("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            if (a(intent)) {
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_SHARE, iUiListener);
                a((Activity) context, intent, (int) Constants.REQUEST_OLD_SHARE);
            }
        } else {
            IUiListener iUiListener3 = iUiListener;
            f.c("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQQ", iUiListener3) != null) {
                f.c("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            if (a(intent)) {
                z = true;
                a(context, 10103, intent, true);
                str = "10";
                if (z2 == z) {
                    str = "11";
                }
                str2 = str;
                if (a(intent)) {
                    d.a().a(r1.b.getOpenId(), r1.b.getAppId(), Constants.VIA_SHARE_TO_QQ, str2, "3", "1", r1.mViaShareQQType, "0", "1", "0");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, r1.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                } else {
                    d.a().a(r1.b.getOpenId(), r1.b.getAppId(), Constants.VIA_SHARE_TO_QQ, str2, "3", "0", r1.mViaShareQQType, "0", "1", "0");
                    d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, r1.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                }
                f.c("openSDK_LOG.QQShare", "doShareToQQ() --end");
            }
        }
        z = true;
        str = "10";
        if (z2 == z) {
            str = "11";
        }
        str2 = str;
        if (a(intent)) {
            d.a().a(r1.b.getOpenId(), r1.b.getAppId(), Constants.VIA_SHARE_TO_QQ, str2, "3", "1", r1.mViaShareQQType, "0", "1", "0");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, r1.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        } else {
            d.a().a(r1.b.getOpenId(), r1.b.getAppId(), Constants.VIA_SHARE_TO_QQ, str2, "3", "0", r1.mViaShareQQType, "0", "1", "0");
            d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, r1.b.getAppId(), "0", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        }
        f.c("openSDK_LOG.QQShare", "doShareToQQ() --end");
    }
}
