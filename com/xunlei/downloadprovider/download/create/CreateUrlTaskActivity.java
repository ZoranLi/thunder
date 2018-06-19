package com.xunlei.downloadprovider.download.create;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import anet.channel.util.HttpConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.util.a;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.h.k.b;
import com.xunlei.downloadprovidershare.q;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateUrlTaskActivity extends BaseActivity implements au {
    public boolean a = false;
    private TitleBar c;
    private Button d;
    private EditText e;
    private boolean f = true;
    private ImageView g = null;
    private String h;
    private String i;
    private boolean j = false;
    private String k = "";
    private c l;
    private boolean m = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = false;
        setContentView(R.layout.activity_create_url_task);
        this.c = new TitleBar((Activity) this);
        this.c.mLeft.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        this.c.mRight.setBackgroundResource(R.drawable.commonui_nav_arrow_back_selector);
        this.c.mRight.setVisibility(4);
        this.c.mTitle.setText(R.string.createtask_input);
        this.e = (EditText) findViewById(R.id.bt_createtask_input);
        this.e.requestFocus();
        this.d = (Button) findViewById(R.id.bt_createtask_create);
        this.d.setOnClickListener(new t(this));
        this.g = (ImageView) findViewById(R.id.bt_createtask_cleaninput);
        this.g.setOnClickListener(new u(this));
        this.e.setOnClickListener(new v(this));
        this.e.setOnKeyListener(new w(this));
        this.e.addTextChangedListener(new x(this));
        CharSequence a = a();
        if (!TextUtils.isEmpty(a)) {
            int h = k.h(a);
            if (h != 1) {
                if (h != 2) {
                    if (q.a(a) != null) {
                        q.a(a, new y(this));
                    }
                }
            }
            this.m = false;
            this.e.setText(a);
            this.e.setSelection(this.e.getText().toString().length());
        }
        this.c.mLeft.setOnClickListener(new aa(this));
    }

    private String a() {
        this.h = a.b((Context) this);
        this.i = null;
        List<String> a = a.a((Context) this);
        Pattern compile = Pattern.compile("\\|file\\|([^\\|]+)");
        if (a.size() > 0) {
            for (String str : a) {
                if (str.startsWith("thundertask://")) {
                    try {
                        Matcher matcher = compile.matcher(str);
                        if (matcher.find()) {
                            Object group = matcher.group(1);
                            if (!TextUtils.isEmpty(group)) {
                                this.i = com.xunlei.xllib.b.k.b(group, "UTF-8");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        b a2 = k.a.a(this.h);
        this.j = a2.b;
        if (this.j) {
            this.k = a2.a;
        }
        return a2.a;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_between_interface_left_in, R.anim.translate_between_interface_right_out);
    }

    public void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(4);
    }

    public void onPause() {
        AndroidConfig.hiddenInput(this, this.e);
        super.onPause();
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

    public final void a(boolean z) {
        com.xunlei.downloadprovider.download.report.a.f(z ? "task_success" : "task_fail");
        this.a = false;
    }

    static /* synthetic */ void a(CreateUrlTaskActivity createUrlTaskActivity) {
        String trim = createUrlTaskActivity.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            XLToast.showToast(createUrlTaskActivity.getApplicationContext(), "下载地址不能为空");
        } else if (a(trim)) {
            XLToast.showToast(createUrlTaskActivity.getApplicationContext(), "不可用的下载地址");
        } else {
            String substring;
            String str;
            c cVar;
            com.xunlei.downloadprovider.download.report.a.f(NotificationADInfo.REPORT_STATUS_CLICK);
            int indexOf = trim.indexOf(Constants.COLON_SEPARATOR);
            StringBuilder stringBuilder;
            if (-1 != indexOf) {
                substring = trim.substring(0, indexOf);
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
                }
            }
            stringBuilder = new StringBuilder("http://");
            stringBuilder.append(trim);
            trim = stringBuilder.toString();
            substring = trim;
            createUrlTaskActivity.e.clearFocus();
            if (!substring.equals(createUrlTaskActivity.h) || TextUtils.isEmpty(createUrlTaskActivity.i)) {
                str = null;
            } else {
                str = createUrlTaskActivity.i;
            }
            TaskStatInfo taskStatInfo = new TaskStatInfo(substring, null);
            if (createUrlTaskActivity.m) {
                StringBuilder stringBuilder3 = new StringBuilder("manual/manual_newtask");
                stringBuilder3.append(com.xunlei.downloadprovider.download.report.c.d);
                taskStatInfo.a = stringBuilder3.toString();
            } else {
                taskStatInfo.a = "manual/manual_newtask";
            }
            if (createUrlTaskActivity.j && createUrlTaskActivity.k.equals(substring)) {
                taskStatInfo.g = true;
            }
            createUrlTaskActivity.a = true;
            if (createUrlTaskActivity.l != null) {
                cVar = createUrlTaskActivity.l;
            } else {
                createUrlTaskActivity.l = new ab(createUrlTaskActivity);
                cVar = createUrlTaskActivity.l;
            }
            com.xunlei.downloadprovider.download.c.a(createUrlTaskActivity, substring, str, 0, null, taskStatInfo, null, cVar);
        }
    }
}
