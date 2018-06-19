package com.xunlei.downloadprovider.contentpublish.website;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Selection;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.contentpublish.website.a.m;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.h.k.a;
import com.xunlei.xllib.android.b;

public class WebsiteEditActivity extends BaseActivity {
    private EditText a;
    private View c;
    private boolean d;
    private XLWaitingDialog e;
    private TextView f;
    private String g;
    private Handler h = new an(this);
    private BroadcastReceiver i = new ao(this);

    static /* synthetic */ void c() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = getIntent().getStringExtra("from");
        bf.a(this.g);
        setContentView(R.layout.website_edit_activity);
        this.c = findViewById(R.id.next_step_btn);
        this.a = (EditText) findViewById(R.id.website_edit_text);
        this.a.setOnEditorActionListener(new ap(this));
        this.a.addTextChangedListener(new aq(this));
        this.f = (TextView) findViewById(R.id.error_tips);
        bundle = new IntentFilter();
        bundle.addAction("action_website_publish_success");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.i, bundle);
        String clipboardText = ClipboardUtil.getClipboardText(this);
        if (!TextUtils.isEmpty(clipboardText) && a.d(clipboardText)) {
            if (k.h(clipboardText) != 1) {
                if (m.a().d(clipboardText)) {
                    az.a();
                    if (!az.b(clipboardText)) {
                        this.a.setText("");
                        this.a.setText(clipboardText);
                        az.a();
                        az.c(clipboardText);
                        Selection.selectAll(this.a.getText());
                        this.d = true;
                        bf.b(this.g, "paste", g());
                    }
                }
            }
        }
        d();
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void a(String str) {
        com.xunlei.downloadprovider.member.register.view.a.a(this, 2, str).a();
    }

    private void d() {
        if (TextUtils.isEmpty(g())) {
            this.c.setEnabled(false);
        } else {
            this.c.setEnabled(true);
        }
    }

    public void onClickCancel(View view) {
        finish();
    }

    public void onClickNextStep(View view) {
        String g = g();
        if (bg.a(g)) {
            bf.b(this.g, "edit_next", g);
            if (!TextUtils.isEmpty(g)) {
                if (a.d(g)) {
                    if (k.h(g) != 1) {
                        if (m.a().d(g)) {
                            au auVar = az.a().a;
                            if (auVar == null) {
                                b(g);
                                return;
                            } else if (g.equals(auVar.a)) {
                                b();
                                return;
                            } else {
                                az.a().a = null;
                                b(g);
                                return;
                            }
                        }
                        a("暂不支持此链接，请重新输入");
                        h();
                        bf.c(this.g, g, "no_allow");
                        return;
                    }
                }
                a("链接格式错误，请重新输入");
                h();
                bf.c(this.g, g, "type_error");
                return;
            }
            return;
        }
        a("链接过长，请重新输入");
    }

    private void b(String str) {
        if (b.a(this)) {
            this.h.removeMessages(1);
            this.h.sendEmptyMessageDelayed(1, 500);
            az.a().a(str, new ar(this, str));
            return;
        }
        XLToast.showToast(this, "网络异常，请稍后重试");
        bf.c(this.g, str, "no_connect");
    }

    public final void a() {
        this.h.removeMessages(1);
        if (this.e != null) {
            this.e.dismiss();
        }
    }

    public final void b() {
        WebsitePublishActivity.a(this, this.g, "edit");
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, WebsiteEditActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("from", str);
        context.startActivity(intent);
    }

    private String g() {
        return this.a.getText().toString().trim();
    }

    private void h() {
        this.a.setSelection(0);
        this.a.selectAll();
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.a, 0);
    }

    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.i);
        az.a().a(g());
        az.a().a = null;
        super.onDestroy();
    }

    static /* synthetic */ void a(WebsiteEditActivity websiteEditActivity) {
        if (websiteEditActivity.e == null) {
            websiteEditActivity.e = new XLWaitingDialog(websiteEditActivity);
            websiteEditActivity.e.setProHintStr("正在解析中");
            websiteEditActivity.e.setOnDismissListener(new as(websiteEditActivity));
        }
        websiteEditActivity.e.show();
    }

    static /* synthetic */ void a(WebsiteEditActivity websiteEditActivity, String str, String str2) {
        websiteEditActivity.a(str2);
        websiteEditActivity.h();
        bf.c(websiteEditActivity.g, str, "fail");
    }
}
