package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.util.h;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.c;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_APP = 6;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    private boolean c = true;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    public String mViaShareQzoneType = "";

    public void releaseResource() {
    }

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        QzoneShare qzoneShare = this;
        final Context context = activity;
        final Bundle bundle2 = bundle;
        final IUiListener iUiListener2 = iUiListener;
        f.c("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (bundle2 == null) {
            iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            f.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        String string = bundle2.getString("title");
        String string2 = bundle2.getString("summary");
        String string3 = bundle2.getString("targetUrl");
        ArrayList stringArrayList = bundle2.getStringArrayList("imageUrl");
        Object a = i.a((Context) activity);
        if (a == null) {
            a = bundle2.getString("appName");
        } else if (a.length() > 20) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.substring(0, 20));
            stringBuilder.append("...");
            a = stringBuilder.toString();
        }
        int i = bundle2.getInt("req_type");
        if (i != 1) {
            switch (i) {
                case 5:
                    qzoneShare.mViaShareQzoneType = "2";
                    break;
                case 6:
                    qzoneShare.mViaShareQzoneType = "4";
                    break;
                default:
                    qzoneShare.mViaShareQzoneType = "1";
                    break;
            }
        }
        qzoneShare.mViaShareQzoneType = "1";
        if (i != 1) {
            switch (i) {
                case 5:
                    iUiListener2.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                    return;
                case 6:
                    if (!i.f(context, "5.0.0")) {
                        string3 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", new Object[]{qzoneShare.b.getAppId(), "mqq"});
                        bundle2.putString("targetUrl", string3);
                        break;
                    }
                    iUiListener2.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                    f.e("openSDK_LOG.QzoneShare", "-->shareToQzone, app share is not support below qq5.0.");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone, app share is not support below qq5.0.");
                    return;
                default:
                    if (i.e(string) && i.e(string2)) {
                        if (stringArrayList != null && stringArrayList.size() != 0) {
                            qzoneShare.c = false;
                            break;
                        }
                        StringBuilder stringBuilder2 = new StringBuilder("来自");
                        stringBuilder2.append(a);
                        stringBuilder2.append("的分享");
                        string = stringBuilder2.toString();
                    }
                    qzoneShare.c = true;
                    break;
            }
        }
        qzoneShare.c = true;
        qzoneShare.d = false;
        qzoneShare.e = true;
        qzoneShare.f = false;
        if (i.b() || !i.f(context, "4.5.0")) {
            if (qzoneShare.c) {
                if (TextUtils.isEmpty(string3)) {
                    iUiListener2.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                    return;
                } else if (!i.g(string3)) {
                    iUiListener2.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_ERROR);
                    return;
                }
            }
            if (qzoneShare.d) {
                bundle2.putString("title", "");
                bundle2.putString("summary", "");
            } else if (qzoneShare.e && i.e(string)) {
                iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                return;
            } else {
                if (!i.e(string) && string.length() > 200) {
                    bundle2.putString("title", i.a(string, 200, null, null));
                }
                if (!i.e(string2) && string2.length() > 600) {
                    bundle2.putString("summary", i.a(string2, 600, null, null));
                }
            }
            if (!TextUtils.isEmpty(a)) {
                bundle2.putString("appName", a);
            }
            if (stringArrayList != null) {
                if (stringArrayList == null || stringArrayList.size() != 0) {
                    for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                        string = (String) stringArrayList.get(i2);
                        if (!(i.g(string) || i.h(string))) {
                            stringArrayList.remove(i2);
                        }
                    }
                    if (stringArrayList.size() == 0) {
                        iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                        f.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                        return;
                    }
                    bundle2.putStringArrayList("imageUrl", stringArrayList);
                    if (i.f(context, "4.6.0")) {
                        f.c("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                        a.a(context, stringArrayList, new c(qzoneShare) {
                            final /* synthetic */ QzoneShare d;

                            public void a(int i, String str) {
                            }

                            public void a(int i, ArrayList<String> arrayList) {
                                if (i == 0) {
                                    bundle2.putStringArrayList("imageUrl", arrayList);
                                }
                                this.d.b(context, bundle2, iUiListener2);
                            }
                        });
                    } else if (g.c(context, "4.2.0") >= 0 || g.c(context, "4.6.0") >= 0) {
                        f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                        new TDialog(context, "", a(""), null, qzoneShare.b).show();
                    } else {
                        f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                        QQShare qQShare = new QQShare(context, qzoneShare.b);
                        if (stringArrayList != null && stringArrayList.size() > 0) {
                            string = (String) stringArrayList.get(0);
                            if (i != 5 || i.h(string)) {
                                bundle2.putString("imageLocalUrl", string);
                            } else {
                                iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                                f.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                                return;
                            }
                        }
                        if (!i.f(context, "4.5.0")) {
                            bundle2.putInt("cflag", 1);
                        }
                        qQShare.shareToQQ(context, bundle2, iUiListener2);
                    }
                    f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
                    return;
                }
            }
            if (qzoneShare.f) {
                iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                return;
            }
            if (i.f(context, "4.6.0")) {
                if (g.c(context, "4.2.0") >= 0) {
                }
                f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                new TDialog(context, "", a(""), null, qzoneShare.b).show();
            } else {
                f.c("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                a.a(context, stringArrayList, /* anonymous class already generated */);
            }
            f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
            return;
        }
        iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
        f.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, qzoneShare.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
    }

    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        StringBuilder stringBuilder;
        int i;
        Activity activity2 = activity;
        Bundle bundle2 = bundle;
        IUiListener iUiListener2 = iUiListener;
        f.c("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList stringArrayList = bundle2.getStringArrayList("imageUrl");
        Object string = bundle2.getString("title");
        Object string2 = bundle2.getString("summary");
        Object string3 = bundle2.getString("targetUrl");
        String string4 = bundle2.getString("audio_url");
        int i2 = bundle2.getInt("req_type", 1);
        Object string5 = bundle2.getString("appName");
        int i3 = bundle2.getInt("cflag", 0);
        String string6 = bundle2.getString("share_qq_ext_str");
        Object appId = this.b.getAppId();
        String openId = this.b.getOpenId();
        StringBuilder stringBuilder2 = new StringBuilder("openId:");
        stringBuilder2.append(openId);
        f.a("openSDK_LOG.QzoneShare", stringBuilder2.toString());
        if (stringArrayList != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            int i4 = 9;
            if (stringArrayList.size() <= 9) {
                i4 = stringArrayList.size();
            }
            int i5 = 0;
            while (i5 < i4) {
                ArrayList arrayList = stringArrayList;
                stringBuffer2.append(URLEncoder.encode((String) stringArrayList.get(i5)));
                if (i5 != i4 - 1) {
                    stringBuffer2.append(h.b);
                }
                i5++;
                stringArrayList = arrayList;
            }
            stringBuilder = new StringBuilder("&image_url=");
            stringBuilder.append(Base64.encodeToString(i.i(stringBuffer2.toString()), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuilder = new StringBuilder("&title=");
            stringBuilder.append(Base64.encodeToString(i.i(string), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuilder = new StringBuilder("&description=");
            stringBuilder.append(Base64.encodeToString(i.i(string2), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuilder = new StringBuilder("&share_id=");
            stringBuilder.append(appId);
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuilder = new StringBuilder("&url=");
            stringBuilder.append(Base64.encodeToString(i.i(string3), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuilder = new StringBuilder("&app_name=");
            stringBuilder.append(Base64.encodeToString(i.i(string5), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!i.e(openId)) {
            stringBuilder = new StringBuilder("&open_id=");
            stringBuilder.append(Base64.encodeToString(i.i(openId), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (i.e(string4)) {
            i = 2;
        } else {
            stringBuilder = new StringBuilder("&audioUrl=");
            i = 2;
            stringBuilder.append(Base64.encodeToString(i.i(string4), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder("&req_type=");
        stringBuilder.append(Base64.encodeToString(i.i(String.valueOf(i2)), i));
        stringBuffer.append(stringBuilder.toString());
        if (!i.e(string6)) {
            stringBuilder = new StringBuilder("&share_qq_ext_str=");
            stringBuilder.append(Base64.encodeToString(i.i(string6), i));
            stringBuffer.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder("&cflag=");
        stringBuilder.append(Base64.encodeToString(i.i(String.valueOf(i3)), i));
        stringBuffer.append(stringBuilder.toString());
        StringBuilder stringBuilder3 = new StringBuilder("doshareToQzone, url: ");
        stringBuilder3.append(stringBuffer.toString());
        f.a("openSDK_LOG.QzoneShare", stringBuilder3.toString());
        a.a(com.tencent.open.utils.d.a(), r0.b, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        Context context = activity;
        intent.putExtra("pkg_name", activity.getPackageName());
        if (i.f(context, "4.6.0")) {
            if (a(intent)) {
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_QZSHARE, iUiListener);
                a((Activity) context, intent, (int) Constants.REQUEST_OLD_QZSHARE);
            }
            f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            IUiListener iUiListener3 = iUiListener;
            f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener3) != null) {
                f.c("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
            }
            if (a(intent)) {
                a(context, 10104, intent, false);
            }
        }
        if (a(intent)) {
            d.a().a(r0.b.getOpenId(), r0.b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "0", r0.mViaShareQzoneType, "0", "1", "0");
            d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, r0.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            d.a().a(r0.b.getOpenId(), r0.b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", r0.mViaShareQzoneType, "0", "1", "0");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, r0.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        f.c("openSDK_LOG", "doShareToQzone() --end");
    }
}
