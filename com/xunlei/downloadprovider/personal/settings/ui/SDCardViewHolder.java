package com.xunlei.downloadprovider.personal.settings.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.xllib.android.e;

public class SDCardViewHolder extends FrameLayout {
    public View a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public ProgressBar e;
    public TextView f;
    public TextView g;
    public TextView h;
    public int i;
    String j = null;
    public boolean k = false;
    public boolean l = true;
    private a m;
    private boolean n;
    private String o;
    private Context p;
    private boolean q = true;
    private View r;

    public interface a {
        void a(boolean z);
    }

    public SDCardViewHolder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = context;
    }

    public SDCardViewHolder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = context;
    }

    public SDCardViewHolder(Context context) {
        super(context);
        this.p = context;
    }

    public final void a(String str, int i, boolean z, boolean z2) {
        if (this.a == null) {
            this.a = ((LayoutInflater) this.p.getSystemService("layout_inflater")).inflate(R.layout.layout_choose_sdcard_card, null);
            addView(this.a, new LayoutParams(-1, -2));
        }
        this.o = str;
        this.n = z;
        this.i = i;
        this.d = (ImageView) this.a.findViewById(true);
        this.b = (TextView) this.a.findViewById(true);
        this.c = (TextView) this.a.findViewById(true);
        this.e = (ProgressBar) this.a.findViewById(true);
        this.f = (TextView) this.a.findViewById(true);
        this.g = (TextView) this.a.findViewById(true);
        this.h = (TextView) this.a.findViewById(true);
        this.r = this.a.findViewById(true);
        if (this.i) {
            if (z2) {
                this.b.setText(true);
            } else {
                this.b.setText(R.string.storage_query_external);
            }
            this.j = str;
        } else if (this.i) {
            this.b.setText(R.string.storage_query_external);
            this.j = str;
        } else {
            return;
        }
        this.h.setText(this.o);
        if (TextUtils.isEmpty(this.o) == null) {
            z = e.a(this.o);
            long b = e.b(this.o);
            long j = b - z;
            setUsedSize(j);
            setFreeSize(z);
            str = (int) ((((double) j) / ((double) b)) * 10000.0d);
            this.e.setIndeterminate(false);
            this.e.setMax(true);
            this.e.setProgress(str);
        } else {
            this.a.setVisibility(true);
        }
        if (this.l != null) {
            this.a.findViewById(R.id.sett_choose_sdcard_arrow).setVisibility(0);
        } else {
            this.a.findViewById(R.id.sett_choose_sdcard_arrow).setVisibility(4);
        }
        setSelected(this.n);
        this.a.setOnClickListener(new d(this));
    }

    public void setSDCardPath(String str) {
        this.o = str;
        str = this.h;
        StringBuilder stringBuilder = new StringBuilder("当前:");
        stringBuilder.append(this.o);
        str.setText(stringBuilder.toString());
    }

    public void setSelected(boolean z) {
        this.n = z;
        this.d.setSelected(this.n);
        if (z) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
        if (this.k) {
            if (z) {
                this.r.setVisibility(0);
                return;
            }
            this.r.setVisibility(8);
        }
    }

    public boolean isSelected() {
        return this.n;
    }

    public void setAllowChoosePath(boolean z) {
        this.q = z;
    }

    public void setUsedSize(long j) {
        this.f.setText(String.format(this.p.getString(R.string.sett_choose_sdcard_used), new Object[]{com.xunlei.xllib.b.e.a(j, 1)}));
    }

    public void setFreeSize(long j) {
        this.g.setText(String.format(this.p.getString(R.string.sett_choose_sdcard_available), new Object[]{com.xunlei.xllib.b.e.a(j, 1)}));
    }

    public final void a() {
        DownloadConfig.setRealDownloadPath(this.i, this.o.substring(this.j.length()));
        n.a();
        n.a(this.o);
    }

    public void setOnSelectChangedListener(a aVar) {
        this.m = aVar;
    }
}
