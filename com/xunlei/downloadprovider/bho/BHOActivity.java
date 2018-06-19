package com.xunlei.downloadprovider.bho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.c;
import com.xunlei.downloadprovider.download.create.ad;
import com.xunlei.downloadprovider.download.create.au;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.d;
import com.xunlei.downloadprovider.launch.dispatch.e;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.xllib.b.b;
import java.net.URL;

public class BHOActivity extends FragmentActivity implements au {
    private RelativeLayout a;
    private TextView b;
    private TextView c;
    private TextView d;
    private String e;
    private String f;
    private ad g;
    private boolean h = false;
    private d i = new d(new a(this));

    private static class a {
        static String[] a = new String[]{"wma", "mp3", "wav", "acc", "ape", "7z", "rar", "zip", "exe", "3gp", "apk", "asf", "asx", "avi", "avi", "f4v", "flv", "m4v", "mkv", "mov", "mp4", "mpeg", "mpg", "rm", "rmvb", "torrent", "wmv"};

        static boolean a(String str) {
            if (str == null || (!str.startsWith("magnet") && !str.startsWith("thunder") && !str.startsWith("ed2k") && str.contains("gcidtask.xunlei.com") == null)) {
                return null;
            }
            return true;
        }

        static boolean b(String str) {
            try {
                return c(new URL(str).getPath());
            } catch (String str2) {
                str2.printStackTrace();
                return null;
            }
        }

        private static boolean c(String str) {
            str = str.toLowerCase();
            for (CharSequence contains : a) {
                if (str.contains(contains)) {
                    return true;
                }
            }
            return false;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bho);
        this.a = (RelativeLayout) findViewById(R.id.content_layout);
        findViewById(R.id.dlg_2btn_layout).setVisibility(0);
        this.b = (TextView) findViewById(R.id.xl_dlg_message);
        this.d = (TextView) findViewById(R.id.dlg_left_btn);
        this.c = (TextView) findViewById(R.id.dlg_right_btn);
        this.d.setOnClickListener(new b(this));
        this.c.setOnClickListener(new c(this));
        this.a.setVisibility(8);
        c.a(this, this);
        a(getIntent());
    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
        a(intent);
    }

    protected void onDestroy() {
        this.i.a();
        super.onDestroy();
    }

    public final void a(boolean z) {
        if (!z) {
            finish();
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.VIEW")) {
                action = intent.getDataString();
                if (action == null || action.equals("")) {
                    this.e = "";
                } else {
                    this.e = action.replace("\r\n", "");
                    if (action.contains("#name=")) {
                        this.h = true;
                        int indexOf = action.indexOf("#name=");
                        this.e = action.substring(0, indexOf);
                        this.f = b.a(action.substring(indexOf + 6), "UTF-8");
                    }
                }
            }
            intent = intent.getData();
            if (intent != null && "xunleiapp".equals(intent.getScheme()) && "xunlei.com".equals(intent.getHost()) && "/sharePage".equals(intent.getPath())) {
                ad adVar = new ad();
                e.a(intent, adVar, "BHO/thunder");
                if (TextUtils.isEmpty(adVar.a()) != null) {
                    XLToast.showToast(this, "该链接已失效");
                    this.e = "";
                } else {
                    this.g = adVar;
                    this.e = adVar.a();
                    this.f = adVar.c();
                }
            }
        }
        if (a.b(this.e) == null && a.a(this.e) == null) {
            if (this.h == null) {
                if (TextUtils.isEmpty(this.e) == null) {
                    com.xunlei.downloadprovider.web.a.a();
                    com.xunlei.downloadprovider.web.a.a(this, this.e, true, BrowserFrom.OTHER);
                }
                finish();
                return;
            }
        }
        if (TextUtils.isEmpty(this.f) != null) {
            this.b.setText(this.e);
        } else {
            this.b.setText(this.f);
        }
        this.a.setVisibility(0);
    }

    static /* synthetic */ void a(BHOActivity bHOActivity) {
        String str = bHOActivity.e;
        String str2 = "";
        TaskStatInfo taskStatInfo = new TaskStatInfo(str, str2);
        taskStatInfo.a = "BHO/other";
        if (bHOActivity.g != null) {
            taskStatInfo.a = bHOActivity.g.c("");
            taskStatInfo.d = bHOActivity.g.d();
            taskStatInfo.e = bHOActivity.g.e();
            taskStatInfo.f = bHOActivity.g.f();
            str2 = bHOActivity.g.b();
        }
        String str3 = str2;
        c.a(bHOActivity, str, bHOActivity.f, 0, str3, taskStatInfo, null, bHOActivity.i);
    }
}
