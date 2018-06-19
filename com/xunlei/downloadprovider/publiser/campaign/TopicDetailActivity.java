package com.xunlei.downloadprovider.publiser.campaign;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.publiser.campaign.a.d;
import com.xunlei.downloadprovider.publiser.campaign.a.m;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.b;

public class TopicDetailActivity extends BaseActivity implements OnOffsetChangedListener, OnClickListener, m {
    private String A;
    private String B;
    private d C;
    private boolean D = false;
    private boolean E = false;
    private int F;
    private int G;
    private int a;
    private String c;
    private String d;
    private AppBarLayout e;
    private CollapsingToolbarLayout f;
    private Toolbar g;
    private PagerSlidingTabStrip h;
    private ViewPager i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private View o;
    private TextView p;
    private View q;
    private ImageView r;
    private View s;
    private UnifiedLoadingView t;
    private ErrorBlankView u;
    private TopicNewFragment v;
    private TopicHotFragment w;
    private TextView x;
    private TextView y;
    private a z;

    public enum From {
        PUSH("push"),
        HOME_COLLECT("home_collect"),
        VIDEODETAIL("videoDetail"),
        TOPIC_LINK("huati"),
        DISCOVERY("discovery");
        
        private final String mText;

        private From(String str) {
            this.mText = str;
        }

        public final String getText() {
            return this.mText;
        }
    }

    private class a extends FragmentPagerAdapter {
        final /* synthetic */ TopicDetailActivity a;

        public final int getCount() {
            return 2;
        }

        public a(TopicDetailActivity topicDetailActivity, FragmentManager fragmentManager) {
            this.a = topicDetailActivity;
            super(fragmentManager);
        }

        public final Fragment getItem(int i) {
            switch (i) {
                case 0:
                    if (this.a.v == 0) {
                        this.a.v = TopicNewFragment.a(this.a.a, this.a.A);
                        this.a.v.k = this.a;
                    }
                    return this.a.v;
                case 1:
                    if (this.a.w == 0) {
                        this.a.w = TopicHotFragment.a(this.a.a, this.a.A);
                        this.a.w.k = this.a;
                    }
                    return this.a.w;
                default:
                    return 0;
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        a(context, 1, str, null, str2);
    }

    public static void a(Context context, int i, String str, String str2, String str3) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (context instanceof TopicDetailActivity) {
                    TopicDetailActivity topicDetailActivity = (TopicDetailActivity) context;
                    String str4 = topicDetailActivity.A;
                    if (i == topicDetailActivity.a && str.equals(str4)) {
                        return;
                    }
                }
                Intent xLIntent = new XLIntent(context, TopicDetailActivity.class);
                xLIntent.putExtra("type", i);
                xLIntent.putExtra("topic_tag", str);
                xLIntent.putExtra("topic_from", str3);
                if (i == 3) {
                    xLIntent.putExtra("location_name", str2);
                } else if (i == 2) {
                    xLIntent.putExtra("audio_title", str2);
                }
                context.startActivity(xLIntent);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_campaign);
        bundle = getIntent();
        this.a = bundle.getIntExtra("type", 1);
        this.A = bundle.getStringExtra("topic_tag");
        this.B = bundle.getStringExtra("topic_from");
        this.c = bundle.getStringExtra("location_name");
        this.d = bundle.getStringExtra("audio_title");
        this.C = new d();
        if (this.a == 3) {
            this.C.e = this.c;
        } else if (this.a == 2) {
            this.C.e = this.d;
        } else {
            this.C.e = this.A;
        }
        if (TextUtils.isEmpty(this.B) == null) {
            m.a(this.a, this.A, this.c, this.B);
        }
        this.e = (AppBarLayout) findViewById(R.id.lyt_appbar);
        this.f = (CollapsingToolbarLayout) findViewById(R.id.lyt_collapsing);
        this.g = (Toolbar) findViewById(R.id.toolbar);
        this.h = (PagerSlidingTabStrip) findViewById(R.id.tb_fragment);
        this.i = (ViewPager) findViewById(R.id.vp_fragment);
        this.j = (ImageView) findViewById(R.id.iv_back);
        this.k = (TextView) findViewById(R.id.tv_title);
        this.l = (TextView) findViewById(R.id.tv_menu_edit);
        this.m = (TextView) findViewById(R.id.topic_title);
        this.n = (TextView) findViewById(R.id.tv_publish_count);
        this.o = findViewById(R.id.layout_description);
        this.o.setVisibility(8);
        this.p = (TextView) findViewById(R.id.tv_description);
        this.q = findViewById(R.id.layout_expand);
        this.r = (ImageView) findViewById(R.id.bg_header);
        this.s = findViewById(R.id.layout_topic_header);
        this.t = (UnifiedLoadingView) findViewById(R.id.loading_view);
        this.u = (ErrorBlankView) findViewById(R.id.error_view);
        this.j.setOnClickListener(this);
        bundle = b.a(BrothersApplication.getApplicationInstance());
        this.u.setErrorType(2);
        this.u.setActionButtonListener(new j(this));
        if (bundle == null) {
            this.u.setVisibility(0);
        }
        if (this.a == 3) {
            this.k.setText("位置");
        } else if (this.a == 2) {
            this.k.setText("音乐");
        } else {
            this.k.setText("话题");
        }
        this.l.setVisibility(8);
        this.m.setText(this.C.e);
        if (this.a == 3) {
            this.G = R.drawable.lbs_default_bg;
            this.r.setImageResource(R.drawable.lbs_default_bg);
        } else if (this.a == 2) {
            this.G = R.drawable.music_default_bg;
            this.r.setImageResource(R.drawable.music_default_bg);
        } else {
            this.G = R.drawable.topic_default_bg;
        }
        this.z = new a(this, getSupportFragmentManager());
        this.i.setAdapter(this.z);
        this.i.setCurrentItem(0);
        this.i.addOnPageChangeListener(new k(this));
        this.x = new TextView(this);
        this.x.setText("最新");
        this.x.setGravity(17);
        this.y = new TextView(this);
        this.y.setText("排行榜");
        this.y.setGravity(17);
        this.h.a(this.x);
        this.h.a(this.y);
        this.h.setViewPager(this.i);
        this.t.setType(2);
        this.t.setBackgroundColor(Color.parseColor("#ffffff"));
        this.t.hidePageLoadingViewBack();
        this.e.addOnOffsetChangedListener(this);
        this.q.setOnClickListener(new i(this));
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        i = (Math.abs(i) * 100) / appBarLayout.getTotalScrollRange();
        if (this.C != null) {
            if (TextUtils.isEmpty(this.C.e) == null) {
                if (i <= 85 || this.C.e.equals(this.k.getText().toString()) != null) {
                    if (i < 95 && "话题".equals(this.k.getText().toString()) == null) {
                        if (this.a == 3) {
                            this.k.setText("位置");
                            return;
                        } else if (this.a == 2) {
                            this.k.setText("音乐");
                            return;
                        } else {
                            this.k.setText("话题");
                        }
                    }
                    return;
                }
                this.k.setText(this.C.e);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a((Activity) this, i, i2, intent);
    }

    public final void a(boolean z) {
        if (z) {
            this.E = true;
            a();
            return;
        }
        this.D = true;
        a();
    }

    public final void a(com.xunlei.downloadprovider.publiser.campaign.a.b bVar) {
        if (bVar != null) {
            if (!f.a(this)) {
                TextView textView;
                StringBuilder stringBuilder;
                if (this.a == 1) {
                    bVar = bVar.e;
                    if (bVar != null) {
                        this.F = bVar.h;
                        Glide.with(this).load(bVar.d).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.choiceness_icon_default).error(this.G).crossFade(200).into(this.r);
                        ViewTreeObserver viewTreeObserver = this.p.getViewTreeObserver();
                        viewTreeObserver.addOnPreDrawListener(new l(this, viewTreeObserver));
                        CharSequence charSequence = bVar.b;
                        if (TextUtils.isEmpty(charSequence)) {
                            this.o.setVisibility(8);
                        } else {
                            this.o.setVisibility(0);
                            this.p.setText(charSequence);
                        }
                        textView = this.n;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(bVar.f);
                        stringBuilder.append("个视频");
                        textView.setText(stringBuilder.toString());
                    } else {
                        return;
                    }
                } else if (this.a == 2) {
                    bVar = bVar.f;
                    if (bVar != null) {
                        textView = this.n;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(bVar.c);
                        stringBuilder.append("个视频");
                        textView.setText(stringBuilder.toString());
                    } else {
                        return;
                    }
                } else if (this.a == 3) {
                    bVar = bVar.g;
                    if (bVar != null) {
                        textView = this.n;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(bVar.e);
                        stringBuilder.append("个视频");
                        textView.setText(stringBuilder.toString());
                    } else {
                        return;
                    }
                }
                this.t.hide();
            }
        }
    }

    private void a() {
        if (this.D && this.E) {
            this.u.setVisibility(0);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24) {
            Intent xLIntent = new XLIntent();
            xLIntent.setAction("com.xunlei.action.ACTION_VOLUME_UP_KEY_DOWN");
            LocalBroadcastManager.getInstance(this).sendBroadcast(xLIntent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onBackPressed() {
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(this, "thunder", null);
        }
        finish();
    }
}
