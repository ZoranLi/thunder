package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.a;

import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.redenvelope.e;
import com.xunlei.downloadprovider.personal.user.account.address.a.d;

/* compiled from: RedEnvelopesHolder */
public final class b extends d {
    private final ImageView a;
    private final TextView b;
    private final TextView c;
    private final ImageView d;
    private TextView e;

    /* compiled from: RedEnvelopesHolder */
    public interface a {
        void onClick(View view);
    }

    public b(View view, a aVar) {
        super(view);
        this.a = (ImageView) view.findViewById(R.id.iv_red_envelopes_item_icon);
        this.b = (TextView) view.findViewById(R.id.tv_red_envelopes_item_title);
        this.c = (TextView) view.findViewById(R.id.tv_red_envelopes_left_time);
        this.d = (ImageView) view.findViewById(R.id.iv_red_envelopes_status_icon);
        this.e = (TextView) view.findViewById(R.id.iv_red_envelope_open);
        this.e.setOnClickListener(new c(this, aVar));
    }

    private void a(long j) {
        this.d.setVisibility(0);
        this.b.setTextColor(Color.parseColor("#999999"));
        this.c.setTextColor(Color.parseColor("#999999"));
        this.c.setText(e.b.replace("%s", e.b(j)));
        this.a.setImageDrawable(ResourcesCompat.getDrawable(this.itemView.getContext().getResources(), R.drawable.red_icon_default, null));
    }

    public final void a(com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e eVar) {
        if (eVar != null) {
            CharSequence charSequence = eVar.b;
            String str = eVar.d;
            long j = (long) eVar.c;
            long j2 = eVar.i - eVar.h;
            int i = eVar.e;
            this.b.setText(charSequence);
            int i2 = 8;
            if (i == 2) {
                a(j);
                this.d.setImageDrawable(ResourcesCompat.getDrawable(this.itemView.getContext().getResources(), R.drawable.red_envelopes_used, null));
            } else if (j2 <= 0) {
                a(j);
                this.d.setImageDrawable(ResourcesCompat.getDrawable(this.itemView.getContext().getResources(), R.drawable.red_envelopes_expire, null));
            } else {
                this.d.setVisibility(8);
                this.b.setTextColor(Color.parseColor("#fc4622"));
                this.c.setTextColor(Color.parseColor("#666666"));
                this.c.setText(e.a.replace("%s", e.a(1000 * j2)));
                this.a.setTag(R.id.iv_red_envelopes_item_icon, str);
                ImageView imageView = this.a;
                if (str.equals(this.a.getTag(R.id.iv_red_envelopes_item_icon).toString())) {
                    Glide.with(this.itemView.getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.red_gift_default_icon).fallback(R.drawable.red_gift_default_icon).error(R.drawable.red_gift_default_icon).dontAnimate().into(imageView);
                }
            }
            int i3 = (i == 2 || j2 <= 0) ? 0 : 1;
            TextView textView = this.e;
            if (i3 != 0) {
                i2 = 0;
            }
            textView.setVisibility(i2);
            this.e.setTag(eVar);
            eVar = (LayoutParams) this.b.getLayoutParams();
            int i4 = i3 != 0 ? -2 : -1;
            if (eVar == null) {
                eVar = new LayoutParams(i4, -2);
                eVar.leftMargin = (int) TypedValue.applyDimension(1, 13.0f, this.itemView.getContext().getResources().getDisplayMetrics());
                eVar.topMargin = (int) TypedValue.applyDimension(1, 23.0f, this.itemView.getContext().getResources().getDisplayMetrics());
            } else {
                eVar.width = i4;
            }
            this.b.setLayoutParams(eVar);
            if (i3 != 0) {
                this.b.setMaxEms(9);
                return;
            }
            this.b.setMaxEms(Integer.MAX_VALUE);
        }
    }
}
