package com.xunlei.downloadprovider.launch.guide.b;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.launch.guide.p.a;

/* compiled from: GuideBottomExperienceView */
public final class b extends d implements OnClickListener {
    private TextView d;

    protected final int a() {
        return R.layout.guide_bottom_experience_view;
    }

    public b(Activity activity, ViewStub viewStub, a aVar) {
        super(activity, viewStub, aVar);
        this.d = null;
        this.d = (TextView) this.a.findViewById(R.id.btn_experience);
        this.d.setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.btn_experience) {
            this.c.g();
        }
    }
}
