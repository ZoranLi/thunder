package com.xunlei.downloadprovider.web.browser;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;

/* compiled from: BrowserActivity */
final class c implements DownloadListener {
    final /* synthetic */ BrowserActivity a;

    c(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String str5 = BrowserActivity.a;
        StringBuilder stringBuilder = new StringBuilder("onDownloadStart: url --> ");
        stringBuilder.append(str);
        stringBuilder.append(", userAgent --> ");
        stringBuilder.append(str2);
        stringBuilder.append(", contentDisposition --> ");
        stringBuilder.append(str3);
        stringBuilder.append(", mimetype --> ");
        stringBuilder.append(str4);
        stringBuilder.append(", contentLength --> ");
        stringBuilder.append(j);
        if (TextUtils.isEmpty(str) == null && str.endsWith("?jump=sjxlmp4") != null) {
            str2 = str.substring(0, str.indexOf("?jump=sjxlmp4"));
            if (str2.isEmpty() == null) {
                str2 = Uri.parse(str2);
                j = new Intent("android.intent.action.VIEW");
                j.setDataAndType(str2, "video/*");
                this.a.startActivity(j);
            }
        }
        str2 = this.a.m.g();
        j = "";
        if (!TextUtils.isEmpty(str3) && str3.contains("filename=")) {
            int indexOf = str3.indexOf("filename=");
            if (indexOf >= 0) {
                indexOf += 9;
                if (indexOf < str3.length()) {
                    j = str3.substring(indexOf);
                    str3 = j.lastIndexOf("/");
                    if (str3 != -1) {
                        j = j.substring(str3);
                    }
                }
            }
        }
        if ((TextUtils.isEmpty(j) != null || j.endsWith(ShareConstants.PATCH_SUFFIX) == null) && ApkHelper.MIME_TYPE_APK.equalsIgnoreCase(str4) == null) {
            this.a.a(str, "", str2, this.a.b("browser/other"));
        } else {
            BrowserActivity.a(this.a, str, j, str2, this.a.b("browser/other"));
        }
    }
}
