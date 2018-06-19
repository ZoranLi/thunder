package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;

/* compiled from: CommentHeaderViewHolder */
public final class m extends aq {
    private final TextView a;
    private String b;

    public m(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.tv_comment_header);
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof String) {
                this.b = (String) awVar.b;
                this.a.setText(this.b);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be String type");
    }
}
