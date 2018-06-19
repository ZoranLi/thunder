package com.xunlei.downloadprovider.publiser.common.guide.follow;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.AnimationDot;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.publiser.common.guide.follow.a.d;
import com.xunlei.downloadprovider.publiser.common.guide.follow.d.a;
import com.xunlei.downloadprovider.publiser.common.guide.follow.d.b;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.List;

public class GuideFollowActivity extends BaseActivity implements OnClickListener, b {
    private static final String a = "GuideFollowActivity";
    private static final int[] c = new int[]{R.drawable.guide_follow_tag_bg_1, R.drawable.guide_follow_tag_bg_2, R.drawable.guide_follow_tag_bg_3, R.drawable.guide_follow_tag_bg_4, R.drawable.guide_follow_tag_bg_5};
    private a d = null;
    private View e = null;
    private TextView f = null;
    private AnimationDot g = null;
    private GridLayout h = null;
    private boolean i = true;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_guide_follow);
        this.d = new a(new d(), this);
        this.e = findViewById(R.id.btn_complete);
        this.f = (TextView) findViewById(R.id.tv_complete);
        this.g = (AnimationDot) findViewById(R.id.loading_view_complete);
        this.h = (GridLayout) findViewById(R.id.gl_tags);
        this.e.setOnClickListener(this);
        this.d.b();
    }

    public static void a(Context context) {
        Intent xLIntent = new XLIntent(context, GuideFollowActivity.class);
        xLIntent.putExtra("page_from", 1);
        context.startActivity(xLIntent);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
        }
    }

    public final void a(com.xunlei.downloadprovider.publiser.common.guide.follow.a.b bVar) {
        this.h.removeAllViews();
        bVar = bVar.a;
        if (bVar != null) {
            int i = 0;
            int i2 = i;
            while (i < bVar.size()) {
                LayoutParams layoutParams;
                View view;
                if (i2 % 2 == 0) {
                    layoutParams = new GridLayout.LayoutParams();
                    layoutParams.bottomMargin = DipPixelUtil.dip2px(18.0f);
                    layoutParams.setGravity(3);
                } else {
                    layoutParams = new GridLayout.LayoutParams();
                    layoutParams.bottomMargin = DipPixelUtil.dip2px(18.0f);
                    layoutParams.leftMargin = DipPixelUtil.dip2px(18.0f);
                    layoutParams.setGravity(5);
                }
                com.xunlei.downloadprovider.publiser.common.guide.follow.a.a aVar = (com.xunlei.downloadprovider.publiser.common.guide.follow.a.a) bVar.get(i);
                if (aVar == null || aVar.a == null || aVar.a.size() <= 0) {
                    view = null;
                } else {
                    view = new c(this);
                    view.setData(aVar);
                    if (view.i != null) {
                        view.e.setText(view.i.d);
                        view.f.setText(view.i.e);
                        view.h.setChecked(view.i.a());
                        view.b();
                    } else {
                        view.e.setText("");
                        view.f.setText("");
                        view.h.setChecked(false);
                        view.g.removeAllViews();
                    }
                }
                if (view != null) {
                    view.setBackgroundResource(c[i2 % c.length]);
                    this.h.addView(view, layoutParams);
                    i2++;
                }
                i++;
            }
        }
    }

    @NonNull
    public final List<Long> a() {
        List<Long> arrayList = new ArrayList();
        int childCount = this.h.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.h.getChildAt(i);
            if (childAt instanceof c) {
                c cVar = (c) childAt;
                if (cVar.a()) {
                    arrayList.addAll(cVar.getFollowUids());
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public final List<Integer> b() {
        List<Integer> arrayList = new ArrayList();
        int childCount = this.h.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.h.getChildAt(i);
            if (childAt instanceof c) {
                c cVar = (c) childAt;
                if (cVar.a()) {
                    int groupId = cVar.getGroupId();
                    if ((groupId != -1 ? 1 : null) != null) {
                        arrayList.add(Integer.valueOf(groupId));
                    }
                }
            }
        }
        return arrayList;
    }

    public final void a(int i) {
        Bundle bundle = new Bundle(3);
        bundle.putString("home_sub_tab_tag", "follow");
        bundle.putString("follow_tab_from", "follow_tab_guide_follow");
        bundle.putInt("guide_follow_increase_follows", i);
        MainTabActivity.b(this, "thunder", bundle);
        finish();
        overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    public final void c() {
        finish();
        overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    public final void a(boolean z) {
        this.i = z;
        this.e.setEnabled(this.i);
    }

    public final void a(String str) {
        this.f.setText(str);
    }

    public final void b(boolean z) {
        if (z) {
            this.g.show();
        } else {
            this.g.hide();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_complete) {
            if (this.i != null) {
                this.d.c();
            }
        }
    }

    public void onBackPressed() {
        if (this.i) {
            this.d.c();
        }
    }
}
