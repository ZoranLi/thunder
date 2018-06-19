package com.xunlei.downloadprovider.download.giftdispatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.giftdispatch.widget.DispatchingItemView;
import com.xunlei.downloadprovider.download.giftdispatch.widget.GetGiftAlertDialog;
import com.xunlei.downloadprovider.download.giftdispatch.widget.GetGiftAlertDialog.ResultType;
import com.xunlei.downloadprovider.download.giftdispatch.widget.GetGiftAlertDialog.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.f;
import com.xunlei.downloadprovider.download.tasklist.list.banner.f.k;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.b.d;
import java.util.List;
import org.json.JSONArray;

public class GiftDispatchingActivity extends BaseActivity {
    public static final String a = "GiftDispatchingActivity";
    ImageView c;
    ImageView d;
    ViewGroup e;
    RelativeLayout f;
    boolean g;
    GetGiftAlertDialog h = null;
    a i = new a(this);
    private RelativeLayout j;
    private RelativeLayout k;
    private ImageView l;
    private TextView m;
    private ImageView n;
    private LinearLayout o;
    private UnifiedLoadingView p = null;
    private String q;
    private JSONArray r = null;
    private ResultType s;
    private int t;
    private com.xunlei.downloadprovider.download.giftdispatch.utils.a.a u = new b(this);
    private boolean v;

    private void a() {
        if (this.h != null) {
            if (this.h.isShowing()) {
                this.h.dismiss();
            }
            this.h = null;
        }
        this.h = new GetGiftAlertDialog(this, this.i, this.s, this.v);
        this.h.show();
    }

    public static void a(Context context, String[] strArr, String str) {
        Intent xLIntent = new XLIntent(context, GiftDispatchingActivity.class);
        xLIntent.putExtra("gifts", strArr);
        xLIntent.putExtra("topIconUrl", str);
        xLIntent.putExtra("is_from_voucher_packet", null);
        context.startActivity(xLIntent);
    }

    public static void b(Context context, String[] strArr, String str) {
        Intent xLIntent = new XLIntent(context, GiftDispatchingActivity.class);
        xLIntent.putExtra("gifts", strArr);
        xLIntent.putExtra("topIconUrl", str);
        xLIntent.putExtra("is_from_voucher_packet", null);
        xLIntent.putExtra("extra_source", 8);
        context.startActivity(xLIntent);
    }

    public static void c(Context context, String[] strArr, String str) {
        Intent xLIntent = new XLIntent(context, GiftDispatchingActivity.class);
        xLIntent.putExtra("gifts", strArr);
        xLIntent.putExtra("topIconUrl", str);
        xLIntent.putExtra("is_from_voucher_packet", true);
        context.startActivity(xLIntent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.gift_dispatching_activity_layout);
        bundle = getWindow();
        LayoutParams attributes = bundle.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        bundle.setAttributes(attributes);
        this.t = DipPixelUtil.dip2px(80.0f);
        bundle = getIntent();
        if (bundle != null) {
            int i = 0;
            this.v = bundle.getBooleanExtra("is_from_voucher_packet", false);
            this.q = bundle.getStringExtra("topIconUrl");
            bundle = bundle.getStringArrayExtra("gifts");
            if (bundle != null) {
                if (bundle.length > 0) {
                    if (this.r == null) {
                        this.r = new JSONArray();
                    }
                    int length = bundle.length;
                    while (i < length) {
                        this.r.put(Integer.parseInt(bundle[i]));
                        i++;
                    }
                }
            }
        }
        this.j = (RelativeLayout) findViewById(R.id.gift_dispatching_activity_layout);
        this.k = (RelativeLayout) findViewById(R.id.gift_dispatching_layout);
        this.l = (ImageView) findViewById(R.id.iv_top_close_btn);
        this.c = (ImageView) findViewById(R.id.iv_top_icon);
        this.m = (TextView) findViewById(R.id.tv_top_gift_count);
        this.f = (RelativeLayout) findViewById(R.id.rl_bottom_target_position);
        this.n = (ImageView) findViewById(R.id.iv_bottom_target_position_red_point);
        this.f.setVisibility(4);
        this.d = new ImageView(this);
        this.l.setOnClickListener(new f(this));
        this.p = (UnifiedLoadingView) findViewById(R.id.ul_loading_view);
        this.o = (LinearLayout) findViewById(R.id.ll_gift_item_list);
        b();
        bundle = this.q;
        if (!(TextUtils.isEmpty(bundle) || this.c == null)) {
            Glide.with(this).load(bundle).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(this.c);
            Glide.with(this).load(bundle).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(this.d);
        }
        com.xunlei.downloadprovider.download.giftdispatch.utils.a.a().a = this.u;
        com.xunlei.downloadprovider.download.giftdispatch.utils.a.a().a(this.r);
    }

    private void b() {
        this.p.show();
        this.k.setVisibility(8);
    }

    private void c() {
        this.p.hide();
        this.k.setVisibility(8);
        this.s = ResultType.get_failed;
        a();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.u != null) {
            com.xunlei.downloadprovider.download.giftdispatch.utils.a.a().a = null;
            this.u = null;
        }
        super.onDestroy();
    }

    static void a(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(204, 204);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        view.setLayoutParams(layoutParams);
    }

    public void onBackPressed() {
        if (!this.g) {
            super.onBackPressed();
            finish();
        }
    }

    static /* synthetic */ void a(GiftDispatchingActivity giftDispatchingActivity, List list) {
        if (d.a(list)) {
            giftDispatchingActivity.c();
            return;
        }
        giftDispatchingActivity.p.hide();
        int i = 0;
        giftDispatchingActivity.k.setVisibility(0);
        giftDispatchingActivity.m.setText(giftDispatchingActivity.getString(R.string.gift_dispatching_item_count, new Object[]{Integer.valueOf(list.size())}));
        giftDispatchingActivity.o.removeAllViews();
        while (i < list.size()) {
            View dispatchingItemView = new DispatchingItemView(giftDispatchingActivity);
            com.xunlei.downloadprovider.download.giftdispatch.a.a aVar = (com.xunlei.downloadprovider.download.giftdispatch.a.a) list.get(i);
            if (aVar != null) {
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, giftDispatchingActivity.t);
                dispatchingItemView.setGiftItemData(aVar);
                giftDispatchingActivity.o.addView(dispatchingItemView, layoutParams);
            }
            i++;
        }
        f.a().a(true);
        if (giftDispatchingActivity.v != null) {
            giftDispatchingActivity = f.a();
            giftDispatchingActivity.a.putBoolean(f.b(), true).commit();
            giftDispatchingActivity.b = true;
            XLThreadPool.execute(new k(giftDispatchingActivity));
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_viphb_pop_show"));
        }
    }

    static /* synthetic */ void i(GiftDispatchingActivity giftDispatchingActivity) {
        giftDispatchingActivity.j.setBackgroundColor(giftDispatchingActivity.getResources().getColor(R.color.gift_dispacthing_background_color_normal));
        giftDispatchingActivity.k.setVisibility(8);
        giftDispatchingActivity.k.startAnimation(AnimationUtils.loadAnimation(giftDispatchingActivity, R.anim.gift_view_hide));
    }

    static /* synthetic */ void j(GiftDispatchingActivity giftDispatchingActivity) {
        giftDispatchingActivity.f.setVisibility(0);
        giftDispatchingActivity.f.startAnimation(AnimationUtils.loadAnimation(giftDispatchingActivity, R.anim.gift_bottom_position_show));
    }
}
