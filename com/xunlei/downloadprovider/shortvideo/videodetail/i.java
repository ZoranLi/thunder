package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: CommentMenuDialog */
public final class i extends Dialog {
    public CommentInfo a;
    private View b;
    private Button c = ((Button) this.b.findViewById(R.id.btn_copy));
    private Button d = ((Button) this.b.findViewById(R.id.btn_report));
    private Button e = ((Button) this.b.findViewById(R.id.btn_cancel));
    private Button f = ((Button) this.b.findViewById(R.id.btn_delete));

    public i(Context context) {
        super(context);
        this.b = LayoutInflater.from(context).inflate(R.layout.menu_dialog, null);
        this.e.setOnClickListener(new j(this));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        getContext();
        setContentView(this.b);
        bundle = getWindow();
        bundle.setGravity(81);
        bundle.setWindowAnimations(R.style.bottom_dialog_animation);
        bundle.setBackgroundDrawable(new ColorDrawable(0));
        bundle.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        bundle.setAttributes(attributes);
    }

    public final void show() {
        super.show();
    }

    public final void a(OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    public final void b(OnClickListener onClickListener) {
        this.d.setOnClickListener(onClickListener);
    }

    public final void c(OnClickListener onClickListener) {
        this.f.setOnClickListener(onClickListener);
    }

    public final void d(OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    public final void a() {
        this.d.setVisibility(8);
    }

    public final void b() {
        this.c.setVisibility(8);
    }

    public final void c() {
        this.f.setVisibility(0);
    }

    public final void a(CommentInfo commentInfo) {
        if (commentInfo == null) {
            throw new IllegalArgumentException("target comment info is NULL");
        }
        this.a = commentInfo;
        LoginHelper.a();
        int i = 0;
        if (l.c() == null) {
            this.f.setVisibility(8);
            commentInfo = this.d;
        } else {
            long c = LoginHelper.a().g.c();
            this.f.setVisibility(c == this.a.getUserId() ? 0 : 8);
            commentInfo = this.d;
            if (c == this.a.getUserId()) {
                i = 8;
            }
        }
        commentInfo.setVisibility(i);
    }
}
