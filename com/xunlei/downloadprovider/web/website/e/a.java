package com.xunlei.downloadprovider.web.website.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.website.a.c;
import com.xunlei.downloadprovider.web.website.b.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CollectionUpdateViewHolder */
public final class a extends e {
    private List<ImageView> A = new ArrayList();
    private OnClickListener B = new b(this);
    private OnClickListener C = new c(this);
    private Context p;
    private TextView q;
    private View r;
    private View s;
    private ImageView t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private c z;

    public a(Context context, View view, c cVar) {
        super(view);
        this.p = context;
        this.z = cVar;
        this.q = (TextView) view.findViewById(R.id.collect_update_title);
        this.r = view.findViewById(R.id.closeButton);
        this.s = view.findViewById(R.id.jump_container);
        this.t = (ImageView) view.findViewById(R.id.website_image1);
        this.u = (ImageView) view.findViewById(R.id.website_image2);
        this.v = (ImageView) view.findViewById(R.id.website_image3);
        this.w = (ImageView) view.findViewById(R.id.website_image4);
        this.x = (ImageView) view.findViewById(R.id.website_image5);
        this.y = (ImageView) view.findViewById(R.id.website_image6);
        this.A.add(this.t);
        this.A.add(this.u);
        this.A.add(this.v);
        this.A.add(this.w);
        this.A.add(this.x);
        this.A.add(this.y);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(8);
        this.r.setOnClickListener(this.B);
        this.s.setOnClickListener(this.C);
        b();
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_url_action", "collect_website_update_show"));
    }

    private void b() {
        b bVar = com.xunlei.downloadprovider.web.website.g.a.a().a;
        if (bVar != null) {
            this.q.setText(bVar.c);
            List list = bVar.d;
            if (list != null) {
                if (list.size() > 0) {
                    int i = 6;
                    if (list.size() <= 6) {
                        i = list.size();
                    }
                    for (int i2 = 0; i2 < i; i2++) {
                        ImageView imageView = (ImageView) this.A.get(i2);
                        Object obj = ((com.xunlei.downloadprovider.web.website.b.a) list.get(i2)).b;
                        if (!(TextUtils.isEmpty(obj) || imageView == null)) {
                            if (!TextUtils.isEmpty(obj)) {
                                imageView.setVisibility(0);
                                Glide.with(this.p).load(obj).asBitmap().fallback(R.drawable.website_icon_default_square).error(R.drawable.website_icon_default_square).placeholder(R.drawable.website_icon_default_square).centerCrop().into(imageView);
                            }
                        }
                    }
                }
            }
        }
    }
}
