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
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class QzonePublish extends BaseApi {
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void publishToQzone(android.app.Activity r18, android.os.Bundle r19, com.tencent.tauth.IUiListener r20) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r17 = this;
        r6 = r17;
        r3 = r19;
        r7 = r20;
        r0 = "openSDK_LOG.QzonePublish";
        r1 = "publishToQzone() -- start";
        com.tencent.open.a.f.c(r0, r1);
        r8 = 0;
        if (r3 != 0) goto L_0x0043;
    L_0x0010:
        r0 = new com.tencent.tauth.UiError;
        r1 = -6;
        r2 = "传入参数不可以为空";
        r0.<init>(r1, r2, r8);
        r7.onError(r0);
        r0 = "openSDK_LOG.QzonePublish";
        r1 = "-->publishToQzone, params is null";
        com.tencent.open.a.f.e(r0, r1);
        r7 = com.tencent.open.b.d.a();
        r8 = 1;
        r9 = "SHARE_CHECK_SDK";
        r10 = "1000";
        r0 = r6.b;
        r11 = r0.getAppId();
        r12 = "4";
        r0 = android.os.SystemClock.elapsedRealtime();
        r13 = java.lang.Long.valueOf(r0);
        r14 = 0;
        r15 = 1;
        r16 = "传入参数不可以为空";
        r7.a(r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return;
    L_0x0043:
        r0 = com.tencent.open.utils.i.f(r18);
        if (r0 != 0) goto L_0x0093;
    L_0x0049:
        r0 = new com.tencent.tauth.UiError;
        r1 = -15;
        r2 = "手Q版本过低，请下载安装最新版手Q";
        r0.<init>(r1, r2, r8);
        r7.onError(r0);
        r0 = "openSDK_LOG.QzonePublish";
        r1 = "-->publishToQzone, this is not support below qq 5.9.5";
        com.tencent.open.a.f.e(r0, r1);
        r7 = com.tencent.open.b.d.a();
        r8 = 1;
        r9 = "SHARE_CHECK_SDK";
        r10 = "1000";
        r0 = r6.b;
        r11 = r0.getAppId();
        r12 = "4";
        r0 = android.os.SystemClock.elapsedRealtime();
        r13 = java.lang.Long.valueOf(r0);
        r14 = 0;
        r15 = 1;
        r16 = "publicToQzone, this is not support below qq 5.9.5";
        r7.a(r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r7 = new com.tencent.open.TDialog;
        r2 = "";
        r0 = "";
        r3 = r6.a(r0);
        r4 = 0;
        r5 = r6.b;
        r0 = r7;
        r1 = r18;
        r0.<init>(r1, r2, r3, r4, r5);
        r7.show();
        return;
    L_0x0093:
        r0 = "summary";
        r0 = r3.getString(r0);
        r1 = "imageUrl";
        r1 = r3.getStringArrayList(r1);
        r2 = com.tencent.open.utils.i.a(r18);
        r4 = 0;
        if (r2 != 0) goto L_0x00ad;
    L_0x00a6:
        r2 = "appName";
        r2 = r3.getString(r2);
        goto L_0x00ca;
    L_0x00ad:
        r5 = r2.length();
        r9 = 20;
        if (r5 <= r9) goto L_0x00ca;
    L_0x00b5:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r2 = r2.substring(r4, r9);
        r5.append(r2);
        r2 = "...";
        r5.append(r2);
        r2 = r5.toString();
    L_0x00ca:
        r5 = android.text.TextUtils.isEmpty(r2);
        if (r5 != 0) goto L_0x00d5;
    L_0x00d0:
        r5 = "appName";
        r3.putString(r5, r2);
    L_0x00d5:
        r2 = "summary";
        r3.putString(r2, r0);
        r0 = "req_type";
        r0 = r3.getInt(r0);
        r2 = 3;
        if (r0 != r2) goto L_0x0113;
    L_0x00e3:
        if (r1 == 0) goto L_0x0108;
    L_0x00e5:
        r0 = r1.size();
        if (r0 <= 0) goto L_0x0108;
    L_0x00eb:
        r0 = r1.size();
        if (r4 >= r0) goto L_0x0103;
    L_0x00f1:
        r0 = r1.get(r4);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.open.utils.i.h(r0);
        if (r0 != 0) goto L_0x0100;
    L_0x00fd:
        r1.remove(r4);
    L_0x0100:
        r4 = r4 + 1;
        goto L_0x00eb;
    L_0x0103:
        r0 = "imageUrl";
        r3.putStringArrayList(r0, r1);
    L_0x0108:
        r17.b(r18, r19, r20);
        r0 = "openSDK_LOG.QzonePublish";
        r1 = "publishToQzone() --end";
        com.tencent.open.a.f.c(r0, r1);
        return;
    L_0x0113:
        r1 = 4;
        r9 = -5;
        if (r0 != r1) goto L_0x0169;
    L_0x0117:
        r0 = "videoPath";
        r10 = r3.getString(r0);
        r0 = com.tencent.open.utils.i.h(r10);
        if (r0 != 0) goto L_0x0135;
    L_0x0123:
        r0 = "openSDK_LOG.QzonePublish";
        r1 = "publishToQzone() video url invalid";
        com.tencent.open.a.f.e(r0, r1);
        r0 = new com.tencent.tauth.UiError;
        r1 = "请选择有效的视频文件";
        r0.<init>(r9, r1, r8);
        r7.onError(r0);
        return;
    L_0x0135:
        r11 = new android.media.MediaPlayer;
        r11.<init>();
        r12 = new com.tencent.connect.share.QzonePublish$1;
        r0 = r12;
        r1 = r6;
        r2 = r10;
        r4 = r18;
        r5 = r7;
        r0.<init>(r1, r2, r3, r4, r5);
        r11.setOnPreparedListener(r12);
        r0 = new com.tencent.connect.share.QzonePublish$2;
        r0.<init>(r6, r7);
        r11.setOnErrorListener(r0);
        r11.setDataSource(r10);	 Catch:{ Exception -> 0x0157 }
        r11.prepareAsync();	 Catch:{ Exception -> 0x0157 }
        return;
    L_0x0157:
        r0 = "openSDK_LOG.QzonePublish";
        r1 = "publishToQzone() exception(s) occurred when preparing mediaplayer";
        com.tencent.open.a.f.e(r0, r1);
        r0 = new com.tencent.tauth.UiError;
        r1 = "请选择有效的视频文件";
        r0.<init>(r9, r1, r8);
        r7.onError(r0);
        return;
    L_0x0169:
        r0 = new com.tencent.tauth.UiError;
        r1 = "请选择支持的分享类型";
        r0.<init>(r9, r1, r8);
        r7.onError(r0);
        r0 = "openSDK_LOG.QzonePublish";
        r1 = "publishToQzone() error--end请选择支持的分享类型";
        com.tencent.open.a.f.e(r0, r1);
        r7 = com.tencent.open.b.d.a();
        r8 = 1;
        r9 = "SHARE_CHECK_SDK";
        r10 = "1000";
        r0 = r6.b;
        r11 = r0.getAppId();
        r12 = "4";
        r0 = android.os.SystemClock.elapsedRealtime();
        r13 = java.lang.Long.valueOf(r0);
        r14 = 0;
        r15 = 1;
        r16 = "publishToQzone() 请选择支持的分享类型";
        r7.a(r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzonePublish.publishToQzone(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        int i;
        Bundle bundle2 = bundle;
        f.c("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        ArrayList stringArrayList = bundle2.getStringArrayList("imageUrl");
        Object string = bundle2.getString("summary");
        int i2 = bundle2.getInt("req_type", 3);
        Object string2 = bundle2.getString("appName");
        String string3 = bundle2.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        int i3 = bundle2.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
        long j = bundle2.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
        Object appId = this.b.getAppId();
        String openId = this.b.getOpenId();
        StringBuilder stringBuilder3 = new StringBuilder("openId:");
        stringBuilder3.append(openId);
        f.a("openSDK_LOG.QzonePublish", stringBuilder3.toString());
        String str = "";
        if (3 == i2 && stringArrayList != null) {
            str = "7";
            StringBuffer stringBuffer2 = new StringBuffer();
            int size = stringArrayList.size();
            int i4 = 0;
            while (i4 < size) {
                ArrayList arrayList = stringArrayList;
                stringBuffer2.append(URLEncoder.encode((String) stringArrayList.get(i4)));
                if (i4 != size - 1) {
                    stringBuffer2.append(h.b);
                }
                i4++;
                stringArrayList = arrayList;
            }
            stringBuilder = new StringBuilder("&image_url=");
            stringBuilder.append(Base64.encodeToString(i.i(stringBuffer2.toString()), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (4 == i2) {
            str = "8";
            stringBuilder = new StringBuilder("&videoPath=");
            stringBuilder.append(Base64.encodeToString(i.i(string3), 2));
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("&videoDuration=");
            stringBuilder.append(Base64.encodeToString(i.i(String.valueOf(i3)), 2));
            stringBuffer.append(stringBuilder.toString());
            stringBuilder = new StringBuilder("&videoSize=");
            stringBuilder.append(Base64.encodeToString(i.i(String.valueOf(j)), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        String str2 = str;
        if (!TextUtils.isEmpty(string)) {
            stringBuilder = new StringBuilder("&description=");
            stringBuilder.append(Base64.encodeToString(i.i(string), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuilder = new StringBuilder("&share_id=");
            stringBuilder.append(appId);
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuilder2 = new StringBuilder("&app_name=");
            stringBuilder2.append(Base64.encodeToString(i.i(string2), 2));
            stringBuffer.append(stringBuilder2.toString());
        }
        if (i.e(openId)) {
            i = 2;
        } else {
            stringBuilder2 = new StringBuilder("&open_id=");
            i = 2;
            stringBuilder2.append(Base64.encodeToString(i.i(openId), 2));
            stringBuffer.append(stringBuilder2.toString());
        }
        stringBuilder2 = new StringBuilder("&req_type=");
        stringBuilder2.append(Base64.encodeToString(i.i(String.valueOf(i2)), i));
        stringBuffer.append(stringBuilder2.toString());
        stringBuilder = new StringBuilder("doPublishToQzone, url: ");
        stringBuilder.append(stringBuffer.toString());
        f.a("openSDK_LOG.QzonePublish", stringBuilder.toString());
        a.a(d.a(), r0.b, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (a(intent)) {
            a(activity, 10104, intent, false);
            com.tencent.open.b.d.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, r0.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
            com.tencent.open.b.d.a().a(r0.b.getOpenId(), r0.b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", str2, "0", "1", "0");
        } else {
            f.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
            com.tencent.open.b.d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, r0.b.getAppId(), "4", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
            com.tencent.open.b.d.a().a(r0.b.getOpenId(), r0.b.getAppId(), Constants.VIA_SHARE_TO_QZONE, "11", "3", "1", str2, "0", "1", "0");
        }
        f.c("openSDK_LOG", "doPublishToQzone() --end");
    }
}
