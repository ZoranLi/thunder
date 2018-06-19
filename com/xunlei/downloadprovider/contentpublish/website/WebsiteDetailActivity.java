package com.xunlei.downloadprovider.contentpublish.website;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailFragment.a;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.widget.DetailCardUserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.c;
import com.xunlei.downloadprovidershare.view.SharePopView;

public class WebsiteDetailActivity extends BaseActivity implements a {
    private View a;
    private ImageView c;
    private View d;
    private TextView e;
    private ImageView f;
    private DetailCardUserInfoTagView g;
    private FollowBtnView h;
    private SharePopView i;
    private VideoUserInfo j;
    private WebsiteDetailFragment k;
    private WebsiteInfo l;
    private boolean m;
    private boolean n;
    private String o;
    private Handler p = new Handler();
    private Runnable q = new a(this);

    public final void a(boolean z) {
        int i = 0;
        this.c.setVisibility(z ? 4 : 0);
        FollowBtnView followBtnView = this.h;
        if (z) {
            i = 4;
        }
        followBtnView.setVisibility(i);
    }

    public final void a(VideoUserInfo videoUserInfo) {
        if (videoUserInfo != null) {
            this.j = videoUserInfo;
            b(videoUserInfo);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_website_detail);
        bundle = getIntent();
        this.j = (VideoUserInfo) bundle.getParcelableExtra(VideoUserInfo.JSON_KEY);
        if (this.j == null) {
            this.j = new VideoUserInfo();
        }
        this.l = (WebsiteInfo) bundle.getParcelableExtra("website_info");
        this.m = bundle.getBooleanExtra("seek_to_comment", false);
        this.n = bundle.getBooleanExtra("auto_show_dialog", false);
        this.o = bundle.getStringExtra("page_from");
        this.a = findViewById(R.id.fl_title_container);
        this.a.setVisibility(0);
        this.c = (ImageView) findViewById(R.id.iv_menu);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        imageView.setOnClickListener(new b(this));
        this.c.setOnClickListener(new c(this));
        this.d = findViewById(R.id.lyt_channel);
        this.e = (TextView) findViewById(R.id.tv_channel_title);
        this.f = (ImageView) findViewById(R.id.iv_channel_icon);
        this.g = (DetailCardUserInfoTagView) findViewById(R.id.tv_from_youliao_shot);
        this.h = (FollowBtnView) findViewById(R.id.btn_follow);
        this.h.setDrawableId(R.drawable.follow_btn_solid_animation_drawable);
        this.h.setUserInfo(this.j);
        b(this.j);
        this.e.setOnClickListener(new d(this));
        this.f.setOnClickListener(new e(this));
        this.h.setOnClickListener(new f(this));
        this.i = (SharePopView) findViewById(R.id.tv_follow_popup);
        this.a.setBackgroundColor(-1);
        imageView.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        this.c.setImageResource(R.drawable.ic_menu_gray);
        this.k = new WebsiteDetailFragment();
        bundle = new Bundle(9);
        Parcelable parcelable = this.l;
        Parcelable parcelable2 = this.j;
        bundle.putParcelable("video_nfo", parcelable);
        bundle.putParcelable(VideoUserInfo.JSON_KEY, parcelable2);
        bundle.putBoolean("seek_to_comment", this.m);
        bundle.putBoolean("auto_show_comment_dialog", this.n);
        bundle.putString("from", this.o);
        this.k.setArguments(bundle);
        bundle = getSupportFragmentManager().beginTransaction();
        bundle.add(R.id.detail_layout, this.k);
        bundle.commit();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        this.p.removeCallbacks(this.q);
        super.onDestroy();
    }

    public static void a(Context context, VideoUserInfo videoUserInfo, WebsiteInfo websiteInfo, String str, boolean z) {
        context.startActivity(a(context, videoUserInfo, websiteInfo, str, true, z));
    }

    private static Intent a(Context context, VideoUserInfo videoUserInfo, WebsiteInfo websiteInfo, String str, boolean z, boolean z2) {
        Intent intent = new Intent(context, WebsiteDetailActivity.class);
        intent.putExtra(VideoUserInfo.JSON_KEY, videoUserInfo);
        intent.putExtra("page_from", str);
        intent.putExtra("website_info", websiteInfo);
        intent.putExtra("seek_to_comment", z);
        intent.putExtra("auto_show_dialog", z2);
        return intent;
    }

    private void b(VideoUserInfo videoUserInfo) {
        long parseLong;
        int i;
        this.d.setVisibility(0);
        if (!TextUtils.isEmpty(videoUserInfo.getPortraitUrl())) {
            b.a();
            b.a(videoUserInfo.getPortraitUrl(), this.f, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new);
        }
        this.e.setText(videoUserInfo.getNickname());
        this.g.setUserInfo(videoUserInfo);
        if (!"per".equals(videoUserInfo.getKind())) {
            if (!"pub".equals(videoUserInfo.getKind())) {
                this.e.setMaxWidth(DipPixelUtil.dip2px(80.0f));
                parseLong = Long.parseLong(videoUserInfo.getUid());
                i = 1;
                videoUserInfo = parseLong <= 0 ? 1 : null;
                if (parseLong == LoginHelper.a().g.c()) {
                    i = 0;
                }
                if ((videoUserInfo & i) == null) {
                    this.h.setVisibility(8);
                } else {
                    this.h.setVisibility(0);
                }
            }
        }
        this.e.setMaxWidth(DipPixelUtil.dip2px(140.0f));
        parseLong = Long.parseLong(videoUserInfo.getUid());
        i = 1;
        if (parseLong <= 0) {
        }
        if (parseLong == LoginHelper.a().g.c()) {
            i = 0;
        }
        if ((videoUserInfo & i) == null) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    public void onBackPressed() {
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        if (runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity)) {
            MainTabActivity.b(this, "thunder", null);
        } else {
            super.onBackPressed();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.xunlei.downloadprovider.f.a.a();
        com.xunlei.downloadprovider.f.a.a((Activity) this, i, i2, intent);
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.p.removeCallbacks(this.q);
            if (this.i != null) {
                if (this.h != null) {
                    if (cVar.a && cVar.b) {
                        this.i.setVisibility(0);
                        this.p.postDelayed(this.q, 3000);
                    } else {
                        this.i.setVisibility(4);
                    }
                    this.h.setEnabled(cVar.c);
                }
            }
        }
    }

    public static void a(Context context, VideoUserInfo videoUserInfo, WebsiteInfo websiteInfo, String str) {
        context.startActivity(a(context, videoUserInfo, websiteInfo, str, false, false));
    }
}
