package com.xunlei.downloadprovider.personal.a.c;

import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.a.d.b;
import com.xunlei.downloadprovider.personal.a.d.c;
import com.xunlei.downloadprovider.personal.a.f.a;
import com.xunlei.downloadprovider.personal.a.j;

/* compiled from: UserCard2ViewHolder */
public class f extends a {
    private static final String a = "f";
    private ImageView b;
    private FragmentActivity c;
    private c d;

    static /* synthetic */ void a() {
    }

    public f(View view, FragmentActivity fragmentActivity) {
        super(view);
        this.c = fragmentActivity;
        this.b = (ImageView) view.findViewById(R.id.iv_card_icon);
        fragmentActivity = new DisplayMetrics();
        this.c.getWindowManager().getDefaultDisplay().getMetrics(fragmentActivity);
        fragmentActivity = fragmentActivity.widthPixels;
        this.b.setLayoutParams(new LayoutParams(fragmentActivity, (fragmentActivity * 220) / 1080));
        view.setOnClickListener(new g(this));
    }

    public final void a(Object obj) {
        this.d = (c) obj;
        new StringBuilder("UserCard2ViewHolder bindData ").append(this.d.a);
        j.a(SocializeConstants.KEY_PIC, this.d.a);
        a.a(((b) this.d.b.get(0)).c, this.b);
    }
}
