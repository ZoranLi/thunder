package com.xunlei.tdlive.view;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.xunlei.tdlive.a.d;
import com.xunlei.tdlive.control.RecycleableViewPager;
import com.xunlei.tdlive.control.RoundImageView;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.b;
import com.xunlei.tdlive.util.j;

public class FloatingLayerAnchorNumView extends LinearLayout implements OnPageChangeListener, Runnable {
    private RecycleableViewPager a;
    private TextView b;
    private a c;
    private j d;

    public class a extends d<String> implements OnClickListener {
        final /* synthetic */ FloatingLayerAnchorNumView b;

        protected void a(int i, View view) {
        }

        public void a(String str, boolean z, boolean z2) {
        }

        public a(FloatingLayerAnchorNumView floatingLayerAnchorNumView) {
            this.b = floatingLayerAnchorNumView;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = new RoundImageView(viewGroup.getContext(), null);
            view.setImageResource(R.drawable.xllive_avatar_default);
            view.setSoundEffectsEnabled(false);
            view.setOnClickListener(this);
            view.setScaleType(ScaleType.CENTER_CROP);
            view.setBackgroundColor(0);
            view.setId(i);
            i = a(i);
            if (i != 0) {
                b.a(viewGroup.getContext()).a(view, i.getString("avatar", ""));
            }
            return view;
        }

        public void onClick(View view) {
            this.b.performClick();
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageSelected(int i) {
    }

    public FloatingLayerAnchorNumView(Context context) {
        super(context);
    }

    public FloatingLayerAnchorNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatingLayerAnchorNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (RecycleableViewPager) findViewById(R.id.anchorAvatar);
        this.a.setOnPageChangeListener(this);
        this.c = new a(this);
        this.a.setAdapter(this.c);
        this.b = (TextView) findViewById(R.id.tvAnchorNum);
    }

    public void refreshView(JsonWrapper jsonWrapper) {
        TextView textView = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(jsonWrapper.getLength()));
        stringBuilder.append("位关注主播");
        textView.setText(stringBuilder.toString());
        if (jsonWrapper.getLength() == 1) {
            jsonWrapper.add(jsonWrapper.getObject(0));
        }
        this.c.a(jsonWrapper);
        setVisibility(0);
        autoStep(CONFIGID.RECORD_BIT);
    }

    public void autoStep(int i) {
        if (this.d == null) {
            this.d = new j(i, this);
        }
        this.d.a(i);
        this.d.c();
    }

    public void run() {
        if (this.a != null) {
            this.a.step(true);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (f == 0 && this.d != 0) {
            this.d.c();
        }
    }
}
