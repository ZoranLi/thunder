package com.xunlei.downloadprovider.personal.message;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.message.data.d;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.pushmessage.l;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import java.util.HashMap;
import java.util.Map;

public class MessageActivty extends BaseActivity implements OnClickListener, com.xunlei.downloadprovider.personal.message.d.a {
    private static final String a = "MessageActivty";
    private String c;
    private AppBarLayout d;
    private CollapsingToolbarLayout e;
    private Toolbar f;
    private PagerSlidingTabStrip g;
    private ViewPager h;
    private TextView i;
    private TextView j;
    private a k;
    private MessageTitleView l;
    private MessageTitleView m;
    private MessageTitleView n;
    private MessageItemFragment o;
    private MessageItemFragment p;
    private MessageItemFragment q;
    private int r = 0;
    private Map<Integer, MessageTitleView> s = new HashMap();
    private Map<Integer, MessageItemFragment> t = new HashMap();

    private class a extends FragmentPagerAdapter {
        final /* synthetic */ MessageActivty a;

        public final int getCount() {
            return 3;
        }

        public a(MessageActivty messageActivty, FragmentManager fragmentManager) {
            this.a = messageActivty;
            super(fragmentManager);
        }

        public final Fragment getItem(int i) {
            switch (i) {
                case 0:
                    if (this.a.o == 0) {
                        this.a.o = MessageItemFragment.a(MessageType.COMMENT);
                        this.a.t.put(Integer.valueOf(0), this.a.o);
                    }
                    return this.a.o;
                case 1:
                    if (this.a.p == 0) {
                        this.a.p = MessageItemFragment.a(MessageType.STAR);
                        this.a.t.put(Integer.valueOf(1), this.a.p);
                    }
                    return this.a.p;
                case 2:
                    if (this.a.q == 0) {
                        this.a.q = MessageItemFragment.a(MessageType.FOLLOW);
                        this.a.t.put(Integer.valueOf(2), this.a.q);
                    }
                    return this.a.q;
                default:
                    return 0;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_message_layout);
        this.d = (AppBarLayout) findViewById(R.id.message_appbar);
        this.e = (CollapsingToolbarLayout) findViewById(R.id.message_collapsing);
        this.f = (Toolbar) findViewById(R.id.message_toolbar);
        this.g = (PagerSlidingTabStrip) findViewById(R.id.message_fragment);
        this.h = (ViewPager) findViewById(R.id.message_viewPager);
        this.i = (TextView) findViewById(R.id.tv_title);
        this.j = (TextView) findViewById(R.id.tv_menu_edit);
        findViewById(R.id.iv_back).setOnClickListener(this);
        c();
        this.i.setText("消息中心");
        this.j.setVisibility(8);
        this.k = new a(this, getSupportFragmentManager());
        this.h.setAdapter(this.k);
        this.h.setCurrentItem(this.r);
        this.h.addOnPageChangeListener(new a(this));
        this.l = new MessageTitleView(this);
        this.l.setTexTitle("评论");
        this.m = new MessageTitleView(this);
        this.m.setTexTitle("赞");
        this.n = new MessageTitleView(this);
        this.n.setTexTitle("新的粉丝");
        this.s.put(Integer.valueOf(0), this.l);
        this.s.put(Integer.valueOf(1), this.m);
        this.s.put(Integer.valueOf(2), this.n);
        this.g.a(this.l);
        this.g.a(this.m);
        this.g.a(this.n);
        this.g.setViewPager(this.h);
        d.a().a(this);
    }

    protected void onResume() {
        super.onResume();
        d();
    }

    protected void onPause() {
        super.onPause();
        if (this.t != null && this.r >= 0 && this.r < this.t.size()) {
            MessageItemFragment messageItemFragment = (MessageItemFragment) this.t.get(Integer.valueOf(this.r));
            if (messageItemFragment != null) {
                messageItemFragment.a();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        d.a().b(this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        c();
    }

    private void c() {
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("message_page_from");
            this.r = intent.getIntExtra("tab_index", this.r);
            if (!TextUtils.isEmpty(this.c)) {
                q.a(this.c);
                if ("push_click".equals(this.c)) {
                    l.a(BrothersApplication.getApplicationInstance());
                }
            }
            intent.removeExtra("message_page_from");
            intent.removeExtra("tab_index");
            if (this.h != null) {
                this.h.setCurrentItem(this.r);
            }
        }
    }

    private void d() {
        LoginHelper.a();
        if (com.xunlei.downloadprovider.member.login.b.l.c()) {
            d.a(BrothersApplication.getApplicationInstance()).a(LoginHelper.a().g.c(), new b(this));
            return;
        }
        LoginHelper.a().a(this, null, LoginFrom.MESSAGE_CENTER, null);
    }

    private void a(int i) {
        if (i >= 0 && i < this.s.size()) {
            ((MessageTitleView) this.s.get(Integer.valueOf(i))).a.setVisibility(8);
        }
    }

    public void onBackPressed() {
        finish();
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(this, MessageInfo.USER, null);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    public final void a() {
        LoginHelper.a();
        if (com.xunlei.downloadprovider.member.login.b.l.c()) {
            d();
        } else {
            onBackPressed();
        }
    }

    public final void a(Object obj) {
        LoginHelper.a();
        if (com.xunlei.downloadprovider.member.login.b.l.c() != null) {
            d();
        }
        if (this.o != null) {
            this.o.a(true);
        }
        if (this.p != null) {
            this.p.a(true);
        }
        if (this.q != null) {
            this.q.a(true);
        }
    }

    static /* synthetic */ void a(MessageActivty messageActivty, MessageTitleView messageTitleView, long j, int i) {
        if (messageTitleView != null) {
            if (messageActivty.r == i || j <= 0) {
                messageActivty.a(i);
            } else {
                messageTitleView.a.setVisibility(null);
            }
        }
    }
}
