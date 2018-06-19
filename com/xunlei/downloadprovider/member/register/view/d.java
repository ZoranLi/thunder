package com.xunlei.downloadprovider.member.register.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.xunlei.common.stat.base.XLStatCommandID;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: VerifyCodeDialog */
public final class d extends XLBaseDialog {
    public a a;
    EditText b;
    private View c;
    private View d;
    private View e;
    private ImageView f;
    private View g;
    private Handler h = new e(this);
    private Context i;

    /* compiled from: VerifyCodeDialog */
    public interface a {
        void a();

        void a(String str);
    }

    public d(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        this.i = context;
        context = LayoutInflater.from(context).inflate(R.layout.verifycode_dialog, null);
        this.c = context;
        this.g = context.findViewById(R.id.login_verify_loading_layout);
        this.f = (ImageView) context.findViewById(R.id.register_verify_code_image);
        this.f.setOnClickListener(new f(this));
        this.b = (EditText) context.findViewById(R.id.verifyCode1);
        setContentView(this.c);
        this.e = this.c.findViewById(R.id.cancel);
        this.e.setOnClickListener(new g(this));
        this.d = findViewById(R.id.login_verifycode_submit);
        this.d.setOnClickListener(new h(this));
        setCanceledOnTouchOutside(null);
    }

    public final void show() {
        super.show();
        this.h.sendEmptyMessageDelayed(XLStatCommandID.XLCID_LOGIN, 500);
    }

    public final void a() {
        this.f.setImageResource(R.drawable.bg_validcode_fail);
        this.g.setVisibility(8);
    }

    public final void a(Bitmap bitmap) {
        this.f.setImageBitmap(bitmap);
        b();
        this.b.requestFocus();
        this.g.setVisibility(8);
    }

    public final void b() {
        this.b.setText("");
    }

    public final void a(boolean z) {
        if (this.d != null) {
            this.d.setEnabled(z);
        }
    }
}
