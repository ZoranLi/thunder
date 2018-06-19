package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.d;

/* compiled from: RecommendHeaderViewHolder */
public class ag extends aq {
    protected final TextView b;
    protected final a c;
    protected d d;

    public ag(View view, a aVar) {
        super(view);
        this.c = aVar;
        this.b = (TextView) view.findViewById(R.id.tv_recommend_header);
    }

    public void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof d) {
                this.d = (d) awVar.b;
                this.b.setText(this.d.a);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be String type");
    }
}
