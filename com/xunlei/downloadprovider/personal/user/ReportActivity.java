package com.xunlei.downloadprovider.personal.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.comment.entity.e;
import com.xunlei.downloadprovider.comment.p;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.b.k;

public class ReportActivity extends BaseActivity {
    private RadioGroup a;
    private EditText c;
    private Button d;
    private EditText e;
    private int f = -1;
    private String g;
    private String h;
    private ReportInfo i;

    private static String a(int i) {
        String str = "";
        if (i == -2) {
            return "host";
        }
        if (i == 1) {
            return "shortvideo";
        }
        if (i == 5) {
            return "web_url";
        }
        switch (i) {
            case 8:
                return "cinecism";
            case 9:
                return "news";
            default:
                return str;
        }
    }

    private static void a(Context context, ReportInfo reportInfo, String str) {
        Intent xLIntent = new XLIntent(context, ReportActivity.class);
        xLIntent.putExtra("report_info", reportInfo);
        xLIntent.putExtra("from", str);
        context.startActivity(xLIntent);
    }

    public static void a(Context context, long j, String str) {
        a(context, new ReportInfo(-2, String.valueOf(j)), str);
    }

    public static void a(Context context, int i, String str, String str2, String str3) {
        ReportInfo reportInfo = new ReportInfo(i, str);
        ReportInfo.a(reportInfo, str2);
        a(context, reportInfo, str3);
    }

    public static void a(Context context, int i, long j, String str, String str2, String str3) {
        ReportInfo reportInfo = new ReportInfo(-1, String.valueOf(j));
        ReportInfo.a(reportInfo, i);
        ReportInfo.a(reportInfo, str);
        ReportInfo.b(reportInfo, str2);
        a(context, reportInfo, str3);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_report);
        findViewById(R.id.iv_back).setOnClickListener(new g(this));
        this.a = (RadioGroup) findViewById(R.id.rgp_type);
        this.c = (EditText) findViewById(R.id.et_desc);
        this.e = (EditText) findViewById(R.id.et_focus);
        this.d = (Button) findViewById(R.id.btn_commit);
        this.a.clearCheck();
        this.c.setEnabled(true);
        this.c.clearFocus();
        this.e.requestFocus();
        a();
        this.a.setOnCheckedChangeListener(new k(this));
        this.c.setOnClickListener(new l(this));
        this.c.addTextChangedListener(new m(this));
        this.c.setOnFocusChangeListener(new n(this));
        this.d.setOnClickListener(new o(this));
        findViewById(R.id.tv_copyright_report_protocol).setOnClickListener(new p(this));
        bundle = getIntent();
        if (bundle.hasExtra("report_info")) {
            this.i = (ReportInfo) bundle.getParcelableExtra("report_info");
            this.h = bundle.getStringExtra("from");
            bundle = "";
            String str = "";
            if (ReportInfo.a(this.i) == -2) {
                bundle = this.i.b;
            } else {
                str = this.i.b;
            }
            a.a(this.h, bundle, str, a(this.i.a));
            return;
        }
        throw new IllegalArgumentException("You must deliver EXTRA_REPORT_INFO value when start ReportActivity");
    }

    protected final int e() {
        return getResources().getColor(R.color.common_blue);
    }

    private void a() {
        int checkedRadioButtonId = this.a.getCheckedRadioButtonId();
        boolean z = true;
        if (checkedRadioButtonId >= 0) {
            if (checkedRadioButtonId == R.id.rbtn_other && TextUtils.isEmpty(this.c.getText())) {
            }
            this.d.setEnabled(z);
        }
        z = false;
        this.d.setEnabled(z);
    }

    public final void a(XLWaitingDialog xLWaitingDialog) {
        xLWaitingDialog.dismiss();
        XLToast.showToast(this, "举报失败");
    }

    public final void b(XLWaitingDialog xLWaitingDialog) {
        xLWaitingDialog.dismiss();
        XLToast.showToast(this, "举报成功");
        onBackPressed();
    }

    static /* synthetic */ void f(ReportActivity reportActivity) {
        XLWaitingDialog xLWaitingDialog = new XLWaitingDialog(reportActivity);
        xLWaitingDialog.setProHintStr("正在提交...");
        xLWaitingDialog.show();
        com.xunlei.downloadprovider.comment.a aVar = new com.xunlei.downloadprovider.comment.a();
        e eVar = new e();
        eVar.c = reportActivity.i.d;
        eVar.b = reportActivity.i.c;
        eVar.a = 1;
        aVar.a(eVar);
        long parseLong = Long.parseLong(reportActivity.i.b);
        int i = reportActivity.f;
        com.xunlei.downloadprovider.comment.a.a qVar = new q(reportActivity, xLWaitingDialog);
        if (aVar.c == null) {
            throw new IllegalStateException("no comment resource attached");
        }
        XLThreadPool.execute(new p(aVar, parseLong, i, qVar));
    }

    static /* synthetic */ void g(ReportActivity reportActivity) {
        XLWaitingDialog xLWaitingDialog = new XLWaitingDialog(reportActivity);
        xLWaitingDialog.setProHintStr("正在提交...");
        xLWaitingDialog.show();
        String obj = reportActivity.c.getText().toString();
        com.xunlei.downloadprovider.homepage.recommend.a.a.a().a(reportActivity.i.b, 3, null, AndroidConfig.getPeerid(), reportActivity.f, k.a(obj, "UTF-8"), new r(reportActivity, xLWaitingDialog), new h(reportActivity, xLWaitingDialog));
    }

    static /* synthetic */ void b(ReportActivity reportActivity, int i) {
        XLWaitingDialog xLWaitingDialog = new XLWaitingDialog(reportActivity);
        xLWaitingDialog.setProHintStr("正在提交...");
        xLWaitingDialog.show();
        String obj = reportActivity.c.getText().toString();
        int i2 = i;
        com.xunlei.downloadprovider.homepage.recommend.a.a.a().a(reportActivity.i.b, i2, reportActivity.i.c, AndroidConfig.getPeerid(), reportActivity.f, k.a(obj, "UTF-8"), new i(reportActivity, xLWaitingDialog), new j(reportActivity, xLWaitingDialog));
    }

    static /* synthetic */ void h(ReportActivity reportActivity) {
        String a;
        String str = "";
        String str2 = "";
        if (ReportInfo.a(reportActivity.i) == -2) {
            str = reportActivity.i.b;
        } else {
            str2 = reportActivity.i.b;
        }
        Object obj = reportActivity.c.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            a = k.a(reportActivity.g, "UTF-8");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(k.a(reportActivity.g, "UTF-8"));
            stringBuilder.append("|");
            stringBuilder.append(k.a(obj, "UTF-8"));
            a = stringBuilder.toString();
        }
        a.b(str, str2, a, a(reportActivity.i.a));
    }
}
