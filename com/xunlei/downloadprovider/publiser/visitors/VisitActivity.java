package com.xunlei.downloadprovider.publiser.visitors;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.TextView;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper;
import com.xunlei.downloadprovider.publiser.common.w;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.b;

public class VisitActivity extends BaseActivity {
    public String a;
    public long c;
    private String d;
    private XRecyclerView e;
    private g f;
    private View g;
    private ErrorBlankView h;
    private UnifiedLoadingView i;
    private int j;
    private Long k = Long.valueOf(0);
    private aa l;
    private TextView m;

    public static void a(Context context, long j, String str) {
        a(context, j, "", -1, str);
    }

    public static void a(Context context, long j, String str, int i, String str2) {
        Intent xLIntent = new XLIntent(context, VisitActivity.class);
        xLIntent.putExtra(SocializeConstants.TENCENT_UID, j);
        xLIntent.putExtra("kind", str);
        xLIntent.putExtra("visit_count", i);
        xLIntent.putExtra("from", str2);
        context.startActivity(xLIntent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_visit);
        this.c = getIntent().getLongExtra(SocializeConstants.TENCENT_UID, 0);
        this.a = getIntent().getStringExtra("kind");
        this.j = getIntent().getIntExtra("visit_count", 0);
        this.d = getIntent().getStringExtra("from");
        a.a(this.c, this.d);
        findViewById(R.id.titlebar_left).setOnClickListener(new a(this));
        this.m = (TextView) findViewById(R.id.titlebar_title);
        this.g = findViewById(R.id.layout_empty);
        if (this.j == -1) {
            this.m.setText("访客");
            VisitorNetworkHelper.a().a(this.c, new d(this));
        } else {
            bundle = this.m;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j.a((long) this.j));
            stringBuilder.append("次访问");
            bundle.setText(stringBuilder.toString());
            if (this.j == null) {
                this.g.setVisibility(0);
                return;
            }
        }
        this.h = (ErrorBlankView) findViewById(R.id.error_view);
        this.i = (UnifiedLoadingView) findViewById(R.id.loading_view);
        bundle = b.a(BrothersApplication.getApplicationInstance());
        this.h.setErrorType(2);
        this.h.setActionButtonListener(new b(this));
        if (bundle == null) {
            this.h.setVisibility(0);
        }
        this.e = (XRecyclerView) findViewById(R.id.recycler_view);
        this.e.setLayoutManager(new LinearLayoutManager(this));
        this.e.setPullRefreshEnabled(false);
        ((SimpleItemAnimator) this.e.getItemAnimator()).setSupportsChangeAnimations(false);
        this.f = new g(this, this.d);
        this.e.setAdapter(this.f);
        this.e.setLoadingListener(new e(this));
        this.i.setVisibility(0);
        a();
        if (this.l == null) {
            this.l = new c(this);
        }
        ab.a().a(this.l);
    }

    public final void a() {
        this.e.setLoadingMoreEnabled(true);
        XLThreadPool.execute(new w(VisitorNetworkHelper.a(), this.c, this.k.longValue(), new f(this)));
    }

    protected void onDestroy() {
        if (this.l != null) {
            ab.a().b(this.l);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(this, MessageInfo.USER, null);
        }
        finish();
    }
}
