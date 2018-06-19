package com.xunlei.downloadprovider.download.create;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.dialog.XLBaseDialogActivity;
import com.xunlei.downloadprovider.dialog.a;
import com.xunlei.downloadprovider.download.b;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.report.c;
import com.xunlei.xllib.android.XLIntent;

public class ClipboardHandlerActivity extends XLBaseDialogActivity {
    private static final String a = "ClipboardHandlerActivity";
    private XLAlertDialog c;
    private String d;

    protected final int a() {
        return 4;
    }

    public static void a(String str, String str2) {
        if (a.a().a(4)) {
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            Intent xLIntent = new XLIntent();
            xLIntent.setClass(applicationInstance, ClipboardHandlerActivity.class);
            xLIntent.addFlags(268435456);
            xLIntent.putExtra("copy_url", str);
            xLIntent.putExtra("type", str2);
            applicationInstance.startActivity(xLIntent);
            com.xunlei.downloadprovider.download.report.a.n(str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getIntent().getStringExtra("type");
        bundle = new q(this);
        OnClickListener rVar = new r(this);
        this.c = new XLAlertDialog(this);
        this.c.setOnDismissListener(new s(this));
        this.c.setTitle(getString(R.string.create_task_dialog_from_clip_board_title));
        this.c.setMessage(getString(R.string.create_task_dialog_from_clip_board_content));
        this.c.setOnClickCancelButtonListener(bundle);
        this.c.setOnClickConfirmButtonListener(rVar);
        this.c.show();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    static /* synthetic */ void a(ClipboardHandlerActivity clipboardHandlerActivity, String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder;
            int indexOf = str.indexOf(Constants.COLON_SEPARATOR);
            if (-1 != indexOf) {
                String substring = str.substring(0, indexOf);
                StringBuilder stringBuilder2;
                if (substring.equalsIgnoreCase(HttpConstant.HTTP)) {
                    stringBuilder2 = new StringBuilder(HttpConstant.HTTP);
                    stringBuilder2.append(str.substring(indexOf));
                    str = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("https")) {
                    stringBuilder2 = new StringBuilder("https");
                    stringBuilder2.append(str.substring(indexOf));
                    str = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("ed2k")) {
                    stringBuilder2 = new StringBuilder("ed2k");
                    stringBuilder2.append(str.substring(indexOf));
                    str = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("thunder")) {
                    stringBuilder2 = new StringBuilder("thunder");
                    stringBuilder2.append(str.substring(indexOf));
                    str = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("ftp")) {
                    stringBuilder2 = new StringBuilder("ftp");
                    stringBuilder2.append(str.substring(indexOf));
                    str = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("magnet")) {
                    stringBuilder2 = new StringBuilder("magnet");
                    stringBuilder2.append(str.substring(indexOf));
                    str = stringBuilder2.toString();
                } else {
                    stringBuilder = new StringBuilder("http://");
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                }
            } else {
                stringBuilder = new StringBuilder("http://");
                stringBuilder.append(str);
                str = stringBuilder.toString();
            }
            n.a();
            if (n.b()) {
                String str2;
                if ("download_link".equals(clipboardHandlerActivity.d)) {
                    str2 = "manual/paste_download";
                } else {
                    stringBuilder = new StringBuilder("manual/paste_download");
                    stringBuilder.append(c.d);
                    str2 = stringBuilder.toString();
                }
                b.a(clipboardHandlerActivity.getApplicationContext(), str, str2, "out_app", true);
            }
        }
    }
}
