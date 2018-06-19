package com.xunlei.tdlive.base;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.tdlive.sdk.R;

/* compiled from: LoadingDialog */
public class c extends a {
    private static c c;
    private String d;

    public static void d() {
        if (c != null && c.isShowing()) {
            c.dismiss();
            c = null;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.xllive_loading);
        ImageView imageView = (ImageView) findViewById(R.id.img);
        TextView textView = (TextView) findViewById(R.id.tipTextView);
        textView.setText(this.d);
        if (this.d == null || this.d.length() <= 0) {
            textView.setVisibility(8);
        }
        imageView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.xllive_loading_circle_ani));
    }

    public void onBackPressed() {
        if (this.a == null) {
            super.onBackPressed();
        } else {
            this.a.onClick(this, 0);
        }
    }
}
