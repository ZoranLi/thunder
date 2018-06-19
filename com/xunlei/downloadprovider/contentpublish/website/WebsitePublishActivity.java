package com.xunlei.downloadprovider.contentpublish.website;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.browser.ab.a;

public class WebsitePublishActivity extends BaseActivity {
    private static a f;
    private String a;
    private au c;
    private EditText d;
    private XLWaitingDialog e;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = getIntent().getStringExtra("publish_from");
        setContentView(R.layout.website_publish_activity);
        this.c = az.a().a;
        this.d = (EditText) findViewById(R.id.website_desc);
        this.d.setText(this.c.d);
        this.d.setFilters(new InputFilter[]{new LengthFilter(Opcodes.DOUBLE_TO_FLOAT)});
        this.d.addTextChangedListener(new av(this));
        ImageView imageView = (ImageView) findViewById(R.id.website_icon);
        if (TextUtils.isEmpty(this.c.b)) {
            imageView.setImageResource(R.drawable.ic_website_default_vertical_pic);
        } else {
            b.a().a(this, imageView, this.c.b, R.drawable.ic_website_default_vertical_pic);
        }
        ((TextView) findViewById(R.id.website_title)).setText(this.c.c);
        ((TextView) findViewById(R.id.website_url)).setText(this.c.a);
        bf.b(this.a, getIntent().getStringExtra("enter_type"));
    }

    public void onClickCancel(View view) {
        bf.b(this.a, "publish_pre", this.c.a);
        a(2);
        finish();
    }

    public void onBackPressed() {
        bf.b(this.a, "publish_pre", this.c.a);
        a(2);
        super.onBackPressed();
    }

    public void onClickParseLayout(View view) {
        bf.b(this.a, "link", this.c.a);
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(this, this.c.a, true, BrowserFrom.LINK_MAKE_URL);
    }

    public void onClickPublish(View view) {
        bf.b(this.a, "publish", this.c.a);
        LoginHelper.a();
        if (l.c() != null) {
            a();
        } else {
            LoginHelper.a().a(this, new aw(this), LoginFrom.SELF_LOGIN_VIDEO, null);
        }
    }

    private void a(int i) {
        if (f != null) {
            f.a(i);
            f = 0;
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
        }
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, WebsitePublishActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("publish_from", str);
        intent.putExtra("enter_type", str2);
        context.startActivity(intent);
    }

    public static void a(Context context, a aVar) {
        f = aVar;
        aVar = new Intent(context, WebsitePublishActivity.class);
        aVar.addFlags(268435456);
        aVar.putExtra("publish_from", "browser_website_share");
        aVar.putExtra("enter_type", "direct");
        context.startActivity(aVar);
    }

    public final void a() {
        if (this.e == null) {
            this.e = new XLWaitingDialog(this);
            this.e.setProHintStr("链接发布中");
            this.e.setOnDismissListener(new ay(this));
        }
        this.e.show();
        az.a().a(this.c, new ax(this));
    }

    static /* synthetic */ String a(WebsitePublishActivity websitePublishActivity) {
        if (websitePublishActivity.d != null) {
            if (websitePublishActivity.d.getText() != null) {
                return websitePublishActivity.d.getText().toString();
            }
        }
        return "";
    }

    static /* synthetic */ void c(WebsitePublishActivity websitePublishActivity) {
        if (websitePublishActivity.e != null) {
            websitePublishActivity.e.dismiss();
        }
    }
}
