package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.center.widget.w;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.xllib.b.d;
import java.util.List;

/* compiled from: FollowRecommendPopWindow */
public final class e extends w {
    private String a;
    private View b;
    private View c;
    private ImageView d = ((ImageView) this.c.findViewById(R.id.arrow_up));
    private ImageView e = ((ImageView) this.c.findViewById(R.id.iv_arrow_bottom));
    private List<a> f;
    private TextView g;
    private FollowRecommendItemView h;
    private FollowRecommendItemView i;
    private FollowRecommendItemView j;
    private Activity k;
    private int l;
    private LocalBroadcastManager m;
    private BroadcastReceiver n;

    public final void update(int i, int i2, int i3, int i4, boolean z) {
    }

    public e(Activity activity, View view, List<a> list, String str) {
        super(activity);
        setAnimationStyle(-1);
        this.k = activity;
        this.b = view;
        this.f = list;
        this.a = str;
        this.c = LayoutInflater.from(activity).inflate(R.layout.layout_follow_recommend, null);
        setContentView(this.c);
        setHeight(-2);
        setWidth(-1);
        this.c.setOnClickListener(new f(this));
        activity = (int) activity.getResources().getDimension(R.dimen.follow_recommend_arrow);
        str = new int[2];
        view.getLocationInWindow(str);
        this.l = (str[0] + ((view.getWidth() - activity) / 2)) - DipPixelUtil.dip2px(1.0f);
        this.g = (TextView) this.c.findViewById(R.id.followed_user_name);
        this.g.setText("可能感兴趣的人");
        this.g.setOnClickListener(new g(this));
        this.h = (FollowRecommendItemView) this.c.findViewById(R.id.fan_item1);
        this.h.setBackgroundResource(R.drawable.follow_recommend_item_selector);
        this.i = (FollowRecommendItemView) this.c.findViewById(R.id.fan_item2);
        this.i.setBackgroundResource(R.drawable.follow_recommend_item_selector);
        this.j = (FollowRecommendItemView) this.c.findViewById(R.id.fan_item3);
        this.j.setBackgroundResource(R.drawable.follow_recommend_item_selector);
        this.j.a.setVisibility(8);
        b();
        setOnDismissListener(new h(this));
        update();
    }

    private void b() {
        if (!d.a(this.f)) {
            this.h.a((a) this.f.get(0), this.a);
            this.i.a((a) this.f.get(1), this.a);
            this.j.a((a) this.f.get(2), this.a);
        }
    }

    public final void a() {
        if (!(d.a(this.f) || isShowing())) {
            if (this.b != null) {
                super.a();
                View view = this.b;
                View view2 = this.c;
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                int height = view.getHeight();
                DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
                int i = displayMetrics.heightPixels;
                int i2 = displayMetrics.widthPixels;
                view2.measure(0, 0);
                int measuredHeight = view2.getMeasuredHeight();
                int measuredWidth = view2.getMeasuredWidth();
                MarginLayoutParams marginLayoutParams;
                if (((i - iArr2[1]) - height < measuredHeight ? 1 : 0) != 0) {
                    iArr[0] = i2 - measuredWidth;
                    iArr[1] = iArr2[1] - measuredHeight;
                    this.d.setVisibility(8);
                    this.e.setVisibility(0);
                    marginLayoutParams = (MarginLayoutParams) this.e.getLayoutParams();
                    marginLayoutParams.setMargins(this.l, 0, 0, 0);
                    this.d.setLayoutParams(marginLayoutParams);
                } else {
                    iArr[0] = i2 - measuredWidth;
                    iArr[1] = iArr2[1] + height;
                    this.d.setVisibility(0);
                    this.e.setVisibility(8);
                    marginLayoutParams = (MarginLayoutParams) this.d.getLayoutParams();
                    marginLayoutParams.setMargins(this.l, 0, 0, 0);
                    this.d.setLayoutParams(marginLayoutParams);
                }
                showAtLocation(this.b, 8388659, iArr[0], iArr[1]);
                this.n = new i(this);
                this.m = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("new_follow");
                intentFilter.addAction("cancel_follow");
                intentFilter.addAction("new_user_login_success");
                intentFilter.addAction("user_logout");
                this.m.registerReceiver(this.n, intentFilter);
            }
        }
    }

    public final void dismiss() {
        super.dismiss();
        this.m.unregisterReceiver(this.n);
    }
}
