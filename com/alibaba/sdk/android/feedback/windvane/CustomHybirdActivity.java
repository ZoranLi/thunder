package com.alibaba.sdk.android.feedback.windvane;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.k;
import com.alibaba.sdk.android.feedback.util.o;
import com.alibaba.sdk.android.feedback.xblink.e.a;

public class CustomHybirdActivity extends WXBaseHybridActivity {
    public static final String FROM = "from";
    public static final String NEED_SHOW_BACK = "need_show_back";
    public static final String NEED_TRANS = "need_trans";
    public static final String PLUGIN_TITLE = "plugin_title";
    private static final String TAG = "CustomHybirdActivity";
    private String from;
    private boolean hideTitle;
    private int mTitleClickCount = 0;
    private boolean needShowBack;
    private boolean needTrans = false;
    private String pluginTitle = "";
    private TextView rightTitleBtn;

    static /* synthetic */ int access$204(CustomHybirdActivity customHybirdActivity) {
        int i = customHybirdActivity.mTitleClickCount + 1;
        customHybirdActivity.mTitleClickCount = i;
        return i;
    }

    private void controlTitleBar() {
        this.hideTitle = getIntent().getBooleanExtra(WXBaseHybridActivity.HIDE_TITLE, false);
        this.needShowBack = getIntent().getBooleanExtra("need_show_back", true);
        View findViewById = findViewById(R.id.title_back);
        if (this.needShowBack) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
        findViewById.setOnClickListener(new a(this));
        if (this.hideTitle) {
            findViewById(R.id.title).setVisibility(8);
            findViewById(R.id.title_bar_shadow_view).setVisibility(8);
            findViewById = findViewById(R.id.webview_icon_back);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new b(this));
            return;
        }
        this.pluginTitle = getIntent().getStringExtra(PLUGIN_TITLE);
        TextView textView = (TextView) findViewById(R.id.title_text);
        this.mUrl = getIntent().getStringExtra("URL");
        this.from = getIntent().getStringExtra("from");
        this.needTrans = getIntent().getBooleanExtra(NEED_TRANS, false);
        this.rightTitleBtn = (TextView) findViewById(R.id.title_button);
        textView.setOnClickListener(new c(this, textView));
        String str = (String) FeedbackAPI.mUICustomInfo.get("themeColor");
        String str2 = (String) FeedbackAPI.mUICustomInfo.get("textColor");
        if (!TextUtils.isEmpty(str)) {
            try {
                k.a((Context) this, Color.parseColor(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                k.a(Color.parseColor(str2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean isCanGoBack() {
        if (!this.needShowNav && this.webview.canGoBack()) {
            WebBackForwardList copyBackForwardList = this.webview.copyBackForwardList();
            if (copyBackForwardList.getCurrentIndex() > 0 && o.a(copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1).getUrl())) {
                return true;
            }
        }
        return false;
    }

    protected a createFilter() {
        return null;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ali_feedback_container_layout);
        ((ViewGroup) findViewById(R.id.hybird_container)).addView(this.mViewController);
        FeedbackAPI.activity = this;
        if (TextUtils.isEmpty(this.url)) {
            this.url = getIntent().getDataString();
            this.mUrl = getIntent().getDataString();
        }
        controlTitleBar();
        loadUrl();
    }

    protected void onDestroy() {
        super.onDestroy();
        FeedbackAPI.cleanActivity();
        try {
            if (FeedbackAPI.leaveCallback != null) {
                FeedbackAPI.leaveCallback.call();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void onUrlIntercept(com.alibaba.sdk.android.feedback.xblink.e.a.a aVar, int i) {
    }
}
