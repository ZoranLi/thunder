package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;

/* compiled from: RecommendFooterViewHolder */
public final class ae extends aq {
    private final TextView a;
    private final a b;
    private String c;

    public ae(View view, a aVar) {
        super(view);
        this.b = aVar;
        this.a = (TextView) view.findViewById(R.id.tv_more_recommend);
        this.a.setOnClickListener(new af(this));
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof String) {
                this.c = (String) awVar.b;
                this.a.setText(this.c);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be String type");
    }
}
