package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import anet.channel.util.HttpConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.b.l;
import com.xunlei.downloadprovider.personal.lixianspace.c.a;
import com.xunlei.downloadprovider.personal.lixianspace.d.h;
import com.xunlei.xllib.android.XLIntent;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LXSpaceCreateUrlTaskActivity extends BaseActivity {
    private static final Pattern g = Pattern.compile("\\|file\\|([^\\|]+)");
    private EditText a;
    private TextView c;
    private View d;
    private String e;
    private String f;
    private b h = new y(this);
    private XLWaitingDialog i;

    public static void a(Context context) {
        Intent xLIntent = new XLIntent(context, LXSpaceCreateUrlTaskActivity.class);
        if (!(context instanceof Activity)) {
            xLIntent.addFlags(268435456);
        }
        context.startActivity(xLIntent);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lx_space_create_url_task_activity);
        a.a.a(this.h);
        bundle = new TitleBar((Activity) this);
        bundle.mLeft.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        bundle.mRight.setBackgroundResource(R.drawable.commonui_nav_arrow_back_selector);
        bundle.mRight.setVisibility(4);
        bundle.mTitle.setText(R.string.lx_space_create_url_task);
        bundle.mLeft.setOnClickListener(new x(this));
        this.c = (TextView) findViewById(R.id.lx_space_create_task_error_tip_tv);
        this.a = (EditText) findViewById(R.id.lx_space_create_task_input_et);
        this.a.requestFocus();
        this.d = findViewById(R.id.lx_space_create_task_btn);
        this.d.setOnClickListener(new t(this));
        bundle = findViewById(R.id.lx_space_create_task_clear_view);
        bundle.setOnClickListener(new u(this));
        this.a.setOnEditorActionListener(new v(this));
        this.a.addTextChangedListener(new w(this, bundle));
        ThunderReport.reportEvent(a.d("lx_off_dl_create_task_page_show"));
    }

    public final void onResume() {
        super.onResume();
        CharSequence a = a();
        if (!TextUtils.isEmpty(a)) {
            int h = k.h(a);
            if (h == 1 || h == 2) {
                this.a.setText(a);
                this.a.setSelection(this.a.getText().toString().length());
            }
        }
        getWindow().setSoftInputMode(4);
        m.a().b = true;
    }

    public final void onPause() {
        AndroidConfig.hiddenInput(this, this.a);
        super.onPause();
    }

    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    private static boolean a(String str) {
        if (str.compareToIgnoreCase("http://") == 0 || str.compareToIgnoreCase("ed2k://") == 0 || str.compareToIgnoreCase("magnet:?") == 0 || str.compareToIgnoreCase("thunder://") == 0 || str.compareToIgnoreCase("ftp://") == 0) {
            return true;
        }
        String toLowerCase = str.toLowerCase();
        if (!toLowerCase.startsWith("http://") && !toLowerCase.startsWith("thunder://") && !toLowerCase.startsWith("ed2k://") && !toLowerCase.startsWith("ftp://") && !toLowerCase.startsWith("magnet:?") && !toLowerCase.startsWith("https://")) {
            return true;
        }
        return !TextUtils.isEmpty(str) ? Pattern.compile("^[A-Za-z0-9]+$").matcher(str).matches() : null;
    }

    private String a() {
        this.e = com.xunlei.downloadprovider.download.util.a.b((Context) this);
        this.f = null;
        List<String> a = com.xunlei.downloadprovider.download.util.a.a((Context) this);
        if (a.size() > 0) {
            for (String str : a) {
                if (str.startsWith("thundertask://")) {
                    try {
                        Matcher matcher = g.matcher(str);
                        if (matcher.find()) {
                            Object group = matcher.group(1);
                            if (!TextUtils.isEmpty(group)) {
                                this.f = com.xunlei.xllib.b.k.b(group, "UTF-8");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return k.a.a(this.e).a;
    }

    private void b() {
        if (this.i != null) {
            this.i.dismiss();
        }
    }

    protected final void onDestroy() {
        a.a.b(this.h);
        b();
        VolleyRequestManager.getRequestQueue().a("lx_tag:default");
        super.onDestroy();
    }

    static /* synthetic */ void a(LXSpaceCreateUrlTaskActivity lXSpaceCreateUrlTaskActivity) {
        ThunderReport.reportEvent(a.d("lx_off_dl_create_task_page_click"));
        String trim = lXSpaceCreateUrlTaskActivity.a.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(lXSpaceCreateUrlTaskActivity.getApplicationContext(), "下载地址不能为空");
        } else if (a(trim)) {
            XLToast.showToast(lXSpaceCreateUrlTaskActivity.getApplicationContext(), "不可用的下载地址");
        } else {
            int indexOf = trim.indexOf(Constants.COLON_SEPARATOR);
            int i = 0;
            StringBuilder stringBuilder;
            if (-1 != indexOf) {
                String substring = trim.substring(0, indexOf);
                StringBuilder stringBuilder2;
                if (substring.equalsIgnoreCase(HttpConstant.HTTP)) {
                    stringBuilder2 = new StringBuilder(HttpConstant.HTTP);
                    stringBuilder2.append(trim.substring(indexOf));
                    trim = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("https")) {
                    stringBuilder2 = new StringBuilder("https");
                    stringBuilder2.append(trim.substring(indexOf));
                    trim = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("ed2k")) {
                    stringBuilder2 = new StringBuilder("ed2k");
                    stringBuilder2.append(trim.substring(indexOf));
                    trim = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("thunder")) {
                    stringBuilder2 = new StringBuilder("thunder");
                    stringBuilder2.append(trim.substring(indexOf));
                    trim = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("ftp")) {
                    stringBuilder2 = new StringBuilder("ftp");
                    stringBuilder2.append(trim.substring(indexOf));
                    trim = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("magnet")) {
                    stringBuilder2 = new StringBuilder("magnet");
                    stringBuilder2.append(trim.substring(indexOf));
                    trim = stringBuilder2.toString();
                } else if (substring.equalsIgnoreCase("cid")) {
                    stringBuilder2 = new StringBuilder("cid");
                    stringBuilder2.append(trim.substring(indexOf));
                    trim = stringBuilder2.toString();
                } else {
                    if (!a(trim)) {
                        stringBuilder = new StringBuilder("http://");
                        stringBuilder.append(trim);
                        trim = stringBuilder.toString();
                    }
                    return;
                }
            }
            stringBuilder = new StringBuilder("http://");
            stringBuilder.append(trim);
            trim = stringBuilder.toString();
            lXSpaceCreateUrlTaskActivity.a.clearFocus();
            String str = null;
            if (trim.equals(lXSpaceCreateUrlTaskActivity.e) && !TextUtils.isEmpty(lXSpaceCreateUrlTaskActivity.f)) {
                str = lXSpaceCreateUrlTaskActivity.f;
            }
            if (!k.g(trim)) {
                if (!k.f(trim)) {
                    new h.a(trim).a = str;
                    if (lXSpaceCreateUrlTaskActivity.i == null) {
                        lXSpaceCreateUrlTaskActivity.i = new XLWaitingDialog(lXSpaceCreateUrlTaskActivity);
                    }
                    lXSpaceCreateUrlTaskActivity.i.setProHintStr("正在创建");
                    lXSpaceCreateUrlTaskActivity.i.show();
                    l.a("lx_tag:default", r2);
                    return;
                }
            }
            n.a();
            com.xunlei.downloadprovider.download.engine.task.info.b h = n.h(trim);
            if (!(h == null || h.c() == null || TextUtils.isEmpty(h.c().mLocalFileName))) {
                i = new File(h.c().mLocalFileName).exists();
            }
            if (i != 0) {
                TaskInfo c = h.c();
                lXSpaceCreateUrlTaskActivity.finish();
                LXBtFileExplorerActivity.a(lXSpaceCreateUrlTaskActivity, Uri.fromFile(new File(c.mLocalFileName)).toString(), 10);
                return;
            }
            LXSpaceCreateTaskByMagnetUrlActivity.a((Context) lXSpaceCreateUrlTaskActivity, trim);
            lXSpaceCreateUrlTaskActivity.finish();
        }
    }
}
