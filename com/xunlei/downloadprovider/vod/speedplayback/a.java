package com.xunlei.downloadprovider.vod.speedplayback;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;

/* compiled from: VodSpeedRateController */
public final class a {
    View a;
    OnClickListener b;
    public VodSpeedRate c;
    f d;
    public a e;
    private VodSpeedRateTextView f;
    private View g;

    /* compiled from: VodSpeedRateController */
    public interface a {
        void a(VodSpeedRate vodSpeedRate);
    }

    public a(View view, OnClickListener onClickListener) {
        this.a = view;
        this.b = onClickListener;
        if (this.f == null) {
            this.f = (VodSpeedRateTextView) this.a.findViewById(R.id.vod_speed_rate_view);
            this.g = this.a.findViewById(R.id.vod_speed_rate_container);
            this.g.setOnClickListener(new b(this));
            this.f.getPaint().setFlags(32);
            this.f.getPaint().setAntiAlias(true);
        }
        this.f.setRate(this.c);
        this.g.setVisibility(8);
    }

    public final void a() {
        if (this.d != null) {
            this.d.dismiss();
        }
    }

    public final void a(boolean z) {
        if (this.g != null) {
            View view = this.g;
            z = (z && d.a()) ? false : true;
            view.setVisibility(z);
            if (!this.g.getVisibility()) {
                ThunderReport.reportEvent(e.a("triple_speed_btn_show"));
            }
        }
    }

    public final void a(VodSpeedRate vodSpeedRate, boolean z) {
        if (this.f != null) {
            if (this.e != null) {
                this.e.a(vodSpeedRate);
            }
            this.c = vodSpeedRate;
            this.f.setRate(vodSpeedRate);
            if (!z) {
                XLToast.showToast(this.f.getContext(), !TextUtils.isEmpty(vodSpeedRate == null ? "" : String.valueOf(vodSpeedRate.getRateValue())) ? this.f.getContext().getResources().getString(R.string.vod_play_speed_change_toast, new Object[]{vodSpeedRate == null ? "" : String.valueOf(vodSpeedRate.getRateValue())}) : "");
            }
        }
    }
}
