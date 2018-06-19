package com.xunlei.downloadprovider.download.create;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.download.TorrentParser$OnTorrentParserListener;
import com.xunlei.downloadprovider.download.a;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.taskdetails.DownloadDetailPageActivity;
import com.xunlei.downloadprovider.service.DownloadService;
import com.xunlei.xllib.android.XLIntent;

public class DownloadBtFileExplorerActivity extends BaseBtFileExplorerActivity implements TorrentParser$OnTorrentParserListener {
    public static void a(Context context, String str, int i) {
        a(context, str, -1, i, null, null, null);
    }

    public static void a(Context context, String str, long j, int i, String str2, String str3, String str4) {
        a(context, str, "", j, i, str2, str3, str4);
    }

    public static void a(Context context, String str, String str2, long j, int i, String str3, String str4, String str5) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(context, DownloadBtFileExplorerActivity.class);
        xLIntent.setData(Uri.parse(str));
        str = BaseBtFileExplorerActivity.a(str2, j, i, str3, str4, str5);
        if ((context instanceof DownloadDetailPageActivity) != null) {
            str.putString("quit_way", "finish_only");
        }
        xLIntent.putExtras(str);
        xLIntent.setFlags(268435456);
        context.startActivity(xLIntent);
    }

    protected final void a() {
        if (this.h != 2074) {
            a.a(this, 0, this.g);
        }
    }

    protected final void a(long[] jArr) {
        if (this.c != -1) {
            a aVar = new a(this, this.c, jArr, this.e);
        } else {
            Uri data = getIntent().getData();
            CharSequence stringExtra = getIntent().getStringExtra("createOriginFrom");
            DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
            downloadAdditionInfo.e = getIntent().getStringExtra("refurl");
            downloadAdditionInfo.d = getIntent().getStringExtra("website");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "manual/manual_downloadedlist(bt)";
            }
            long[] jArr2 = jArr;
            a aVar2 = new a(this, data, jArr2, this.d, stringExtra, this.e, downloadAdditionInfo);
        }
        if (DownloadService.a() == null) {
            DownloadService.a(new ae(r0));
        } else {
            r0.a(DownloadService.a());
        }
    }
}
