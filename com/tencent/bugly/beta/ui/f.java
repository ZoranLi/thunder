package com.tencent.bugly.beta.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.b;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.proguard.an;

/* compiled from: BUGLY */
public class f extends a {
    public DownloadTask n;
    protected TextView o;

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = e.E.j;
        layoutInflater = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.l == null) {
            viewGroup = new LayoutParams(-1, -2);
            this.o = new TextView(this.a);
            this.o.setLayoutParams(viewGroup);
            viewGroup = this.o;
            this.j.getClass();
            viewGroup.setTextColor(Color.parseColor("#757575"));
            this.o.setTextSize(16.0f);
            this.o.setTag(Beta.TAG_TIP_MESSAGE);
            this.i.addView(this.o);
        } else if (layoutInflater != null) {
            this.o = (TextView) layoutInflater.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.o.setText(Beta.strNetworkTipsMessage);
            this.f.setText(Beta.strNetworkTipsTitle);
            a(Beta.strNetworkTipsCancelBtn, new b(2, this), Beta.strNetworkTipsConfirmBtn, new b(3, this, this.n));
        } catch (Bundle bundle2) {
            if (this.l != 0) {
                an.e("please confirm your argument: [Beta.tipsDialogLayoutId] is correct", new Object[0]);
            }
            if (an.b(bundle2) == null) {
                bundle2.printStackTrace();
            }
        }
        return layoutInflater;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o = null;
    }
}
