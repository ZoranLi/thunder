package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.b.c;

/* compiled from: AllLivingHostViewHolder */
final class b implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;

    b(a aVar, c cVar, int i) {
        this.c = aVar;
        this.a = cVar;
        this.b = i;
    }

    public final void onClick(View view) {
        view = this.a.b;
        int adapterPosition = this.c.getAdapterPosition();
        if (view == null) {
            this.a.b = true;
            this.c.d.e();
            this.c.d.notifyItemRangeInserted(adapterPosition, this.b - 2);
            this.c.a.postDelayed(new c(this), 300);
        } else {
            this.a.b = false;
            this.c.d.e();
            this.c.d.notifyItemRangeRemoved((adapterPosition - this.b) + 2, this.b - 2);
            this.c.a.postDelayed(new d(this), 300);
        }
        ad.a("follow_zhibo_more");
    }
}
