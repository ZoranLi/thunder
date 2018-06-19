package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.QuickCommentView;

/* compiled from: CommentEmptyViewHolder */
public final class i extends aq {
    private TextView a;
    private ImageView b;
    private QuickCommentView c;
    private a d;

    public i(View view, a aVar) {
        super(view);
        this.d = aVar;
        this.a = (TextView) view.findViewById(R.id.tv_empty_comment);
        this.b = (ImageView) view.findViewById(R.id.img_shafa);
        this.c = (QuickCommentView) view.findViewById(R.id.qk_comment);
        this.c.setVisibility(8);
        if (this.c != null) {
            this.c.setOnItemListener(new j(this));
        }
        this.b.setVisibility(0);
        this.a.setVisibility(0);
    }

    public final void a(aw awVar) {
        p[] pVarArr = (awVar.b == null || !(awVar.b instanceof p[])) ? null : (p[]) awVar.b;
        this.a.setVisibility(0);
        if (this.c != null) {
            CharSequence charSequence = "暂无评论，点击一键评论吧！";
            if (awVar.c instanceof Object[]) {
                Object[] objArr = (Object[]) awVar.c;
                if (objArr[1] instanceof Boolean) {
                    this.c.setClickEnable(((Boolean) objArr[1]).booleanValue());
                }
                if ((objArr[0] instanceof Boolean) && ((Boolean) objArr[0]).booleanValue() == null) {
                    charSequence = "点击一键评论吧！";
                }
            }
            if (pVarArr != null) {
                if (pVarArr.length != 0) {
                    this.c.setContentsArray(pVarArr);
                    this.c.setVisibility(0);
                    this.b.setVisibility(8);
                    this.a.setText(charSequence);
                }
            }
            this.c.setVisibility(8);
            this.b.setVisibility(0);
            this.a.setText("暂无评论，快来抢沙发");
        }
    }
}
