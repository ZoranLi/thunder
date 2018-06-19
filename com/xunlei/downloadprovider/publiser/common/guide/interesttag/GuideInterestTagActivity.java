package com.xunlei.downloadprovider.publiser.common.guide.interesttag;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.c;
import com.xunlei.downloadprovider.publiser.common.guide.interesttag.c.a;
import com.xunlei.downloadprovider.publiser.common.guide.interesttag.c.b;
import com.xunlei.xllib.android.XLIntent;
import java.util.List;

public class GuideInterestTagActivity extends BaseActivity implements OnClickListener, b {
    private a a = null;
    private TextView c = null;
    private GridLayout d = null;

    public static void a(Context context) {
        context.startActivity(new XLIntent(context, GuideInterestTagActivity.class));
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_guide_interest_tag);
        this.a = new b(new c(), this);
        this.c = (TextView) findViewById(R.id.btn_complete);
        this.d = (GridLayout) findViewById(R.id.gl_tags);
        this.c.setOnClickListener(this);
        this.a.a();
    }

    public final void a(List<com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.b> list) {
        this.d.removeAllViews();
        if (list != null) {
            int i = 0;
            int i2 = i;
            while (i < list.size()) {
                LayoutParams layoutParams;
                if ((i2 % 2 == 0 ? 1 : 0) != 0) {
                    layoutParams = new GridLayout.LayoutParams();
                    a((GridLayout.LayoutParams) layoutParams);
                    layoutParams.bottomMargin = DipPixelUtil.dip2px(13.0f);
                    layoutParams.setGravity(3);
                } else {
                    layoutParams = new GridLayout.LayoutParams();
                    a((GridLayout.LayoutParams) layoutParams);
                    layoutParams.bottomMargin = DipPixelUtil.dip2px(13.0f);
                    layoutParams.leftMargin = DipPixelUtil.dip2px(20.0f);
                    layoutParams.setGravity(5);
                }
                com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.b bVar = (com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.b) list.get(i);
                View checkBox = new CheckBox(this);
                checkBox.setText(bVar.a);
                checkBox.setTextColor(getResources().getColorStateList(R.color.text_guide_interest_tag_single_tag_selector));
                checkBox.setBackgroundResource(R.drawable.btn_guide_interest_tag_single_tag_selector);
                checkBox.setGravity(17);
                checkBox.setButtonDrawable(new ColorDrawable(0));
                checkBox.setTag(bVar);
                checkBox.setOnCheckedChangeListener(new a(this));
                this.d.addView(checkBox, layoutParams);
                i2++;
                i++;
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            z = new Bundle(1);
            z.putString("short_toast_msg", "已根据您的兴趣为您推荐");
        } else {
            z = false;
        }
        MainTabActivity.b(this, "thunder", z);
        finish();
        overridePendingTransition(true, R.anim.translate_between_interface_left_out);
    }

    public final void b(boolean z) {
        this.c.setEnabled(z);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_complete) {
            this.a.b();
        }
    }

    public void onBackPressed() {
        this.a.b();
    }

    private static void a(GridLayout.LayoutParams layoutParams) {
        int dip2px = DipPixelUtil.dip2px(126.0f);
        int dip2px2 = DipPixelUtil.dip2px(38.0f);
        layoutParams.width = dip2px;
        layoutParams.height = dip2px2;
    }
}
