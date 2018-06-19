package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.QuickCommentView;
import java.util.HashMap;

/* compiled from: CommentDialog */
public final class a extends Dialog {
    EditText a;
    public CommentInfo b;
    HashMap<Long, String> c;
    public a d;
    public p e;
    public TextView f;
    public ImageView g;
    public CheckBox h;
    public OnClickListener i;
    public boolean j;
    public boolean k = true;
    private View l;
    private Button m;
    private TextView n;
    private OnDismissListener o;
    private View p;
    private ImageView q;
    private TextView r;
    private QuickCommentView s;
    private Context t;
    private OnClickListener u;

    /* compiled from: CommentDialog */
    public interface a {
        void a(p pVar);
    }

    public a(Context context) {
        super(context);
        this.t = context;
        this.l = LayoutInflater.from(context).inflate(R.layout.comment_dialog, null);
        this.l.setOnClickListener(new b(this));
        this.l.findViewById(R.id.lyt_wrap).setOnClickListener(new c(this));
        this.f = (TextView) this.l.findViewById(R.id.tv_qk_title);
        this.g = (ImageView) this.l.findViewById(R.id.iv_refresh);
        this.g.setVisibility(8);
        this.g.setOnClickListener(new d(this));
        this.s = (QuickCommentView) this.l.findViewById(R.id.qk_comment);
        this.s.setOnItemListener(new e(this));
        this.p = this.l.findViewById(R.id.lyt_target);
        this.q = (ImageView) this.l.findViewById(R.id.iv_avatar);
        this.r = (TextView) this.l.findViewById(R.id.tv_target_content);
        this.a = (EditText) this.l.findViewById(R.id.et_content);
        this.n = (TextView) this.l.findViewById(R.id.tv_left_count);
        this.a.setOnEditorActionListener(new f(this));
        this.a.addTextChangedListener(new g(this));
        this.m = (Button) this.l.findViewById(R.id.btn_send);
        this.h = (CheckBox) this.l.findViewById(R.id.show_progress_checkbox);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        getContext();
        setContentView(this.l);
        bundle = getWindow();
        bundle.setGravity(81);
        bundle.setWindowAnimations(R.style.bottom_dialog_animation);
        bundle.setBackgroundDrawable(new ColorDrawable(0));
        bundle.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        bundle.setAttributes(attributes);
        this.c = new HashMap();
        super.setOnDismissListener(new h(this));
    }

    public final void show() {
        getWindow().setSoftInputMode(this.k ? 5 : 3);
        super.show();
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.o = onDismissListener;
    }

    public final void a(OnClickListener onClickListener) {
        this.u = onClickListener;
        this.m.setOnClickListener(onClickListener);
    }

    public final CharSequence a() {
        return this.a.getText().toString();
    }

    public final CharSequence b() {
        return this.c != null ? (CharSequence) this.c.get(Long.valueOf(-1)) : null;
    }

    public final void a(String str) {
        this.a.setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.a.setSelection(str.length());
        }
    }

    public final void c() {
        this.a.setHint(R.string.tips_write_comment);
    }

    public final void b(String str) {
        this.a.setHint(str);
    }

    public final void a(CommentInfo commentInfo) {
        if (commentInfo != this.b) {
            if (commentInfo == null || this.b == null || commentInfo.getId() != this.b.getId()) {
                this.b = commentInfo;
                commentInfo = null;
                int i = 0;
                if (this.b != null) {
                    if (this.c != null) {
                        commentInfo = (String) this.c.get(Long.valueOf(this.b.getId()));
                    }
                    this.p.setVisibility(0);
                    this.r.setText(this.b.getContent());
                    String userAvatar = this.b.getUserAvatar();
                    if (!TextUtils.isEmpty(userAvatar)) {
                        b.a();
                        b.a(userAvatar, this.q);
                    }
                } else {
                    if (this.c != null) {
                        commentInfo = (String) this.c.get(Long.valueOf(-1));
                    }
                    this.p.setVisibility(8);
                }
                this.a.setText(commentInfo);
                EditText editText = this.a;
                if (commentInfo != null) {
                    i = commentInfo.length();
                }
                editText.setSelection(i);
            }
        }
    }

    public final void a(p[] pVarArr) {
        if (this.s != null) {
            int i = 8;
            if (pVarArr != null) {
                if (pVarArr.length != 0) {
                    this.s.setContentsArray(pVarArr);
                    this.s.setVisibility(0);
                    this.f.setVisibility(0);
                    pVarArr = this.g;
                    if (this.j) {
                        i = 0;
                    }
                    pVarArr.setVisibility(i);
                }
            }
            this.s.setVisibility(8);
            this.f.setVisibility(8);
            pVarArr = this.g;
            pVarArr.setVisibility(i);
        }
    }

    public final void a(boolean z) {
        this.m.setEnabled(z);
    }

    public final void a(long j) {
        if (this.c != null) {
            if (j == -1) {
                this.c.remove(Long.valueOf(-1));
            } else {
                this.c.remove(Long.valueOf(j));
            }
        }
    }

    public final void a(int i) {
        this.h.setVisibility(i);
    }
}
