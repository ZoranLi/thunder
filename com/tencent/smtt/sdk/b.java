package com.tencent.smtt.sdk;

import android.content.Intent;
import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.DownloadListener;
import com.tencent.smtt.sdk.a.d;

class b implements DownloadListener {
    private DownloadListener a;
    private WebView b;

    public b(WebView webView, DownloadListener downloadListener, boolean z) {
        this.a = downloadListener;
        this.b = webView;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        onDownloadStart(str, null, null, str2, str3, str4, j, null, null);
    }

    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j, String str6, String str7) {
        String str8 = str;
        if (this.a != null) {
            r0.a.onDownloadStart(str8, str3, str4, str5, j);
        } else if (QbSdk.canOpenMimeFileType(r0.b.getContext(), str5)) {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            intent.setFlags(268435456);
            intent.putExtra("key_reader_sdk_url", str8);
            intent.putExtra("key_reader_sdk_type", 1);
            intent.setData(Uri.parse(str8));
            r0.b.getContext().startActivity(intent);
        } else {
            d.a(r0.b.getContext(), str8, null, null);
        }
    }

    public void onDownloadVideo(String str, long j, int i) {
    }
}
