package com.xunlei.downloadprovider.download.tasklist.list.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;

/* compiled from: BasicADCardViewHolder */
public abstract class a extends f implements com.xunlei.downloadprovider.ad.downloadlist.c.a {
    protected ViewGroup c;
    protected ImageView d;
    protected ImageView e;
    protected ZHTextView f;
    protected ZHTextView g = null;
    protected RatingBar h;
    protected TextView i;
    protected View j;
    protected TextView k;
    protected TextView l;

    public /* synthetic */ Context getContext() {
        return e();
    }

    public a(View view) {
        super(view);
        this.c = (ViewGroup) view.findViewById(R.id.cardContainer);
        if (this.c == null && (view instanceof ViewGroup)) {
            this.c = (ViewGroup) view;
        }
        view = this.c;
        this.d = (ImageView) view.findViewById(R.id.iconImageView);
        this.e = (ImageView) view.findViewById(R.id.posterImageView);
        this.f = (ZHTextView) view.findViewById(R.id.titleTextView);
        this.g = (ZHTextView) view.findViewById(R.id.descTextView);
        this.j = view.findViewById(R.id.closeButton);
        this.k = (TextView) view.findViewById(R.id.actionButton);
        this.l = (TextView) view.findViewById(R.id.tagView);
        this.h = (RatingBar) view.findViewById(R.id.score_rb);
        this.i = (TextView) view.findViewById(R.id.install_count);
    }

    public final Activity e() {
        return (this.c == null || !(this.c.getContext() instanceof Activity)) ? null : (Activity) this.c.getContext();
    }
}
