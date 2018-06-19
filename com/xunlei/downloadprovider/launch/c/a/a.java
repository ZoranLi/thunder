package com.xunlei.downloadprovider.launch.c.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: RequiredPermissionDialog */
public final class a extends XLBaseDialog {
    protected View a;
    protected TextView b = ((TextView) this.a.findViewById(R.id.dlg_title));
    protected TextView c = ((TextView) this.a.findViewById(R.id.dlg_content));
    protected TextView d = ((TextView) this.a.findViewById(R.id.dlg_cancel_btn));
    protected TextView e;
    protected View f = this.a.findViewById(R.id.dlg_btn_vertical_divider);
    protected OnClickListener g;
    protected OnClickListener h;

    /* compiled from: RequiredPermissionDialog */
    public interface a {
        void a(a aVar, View view);
    }

    public a(Context context, a aVar) {
        super(context, R.style.ThunderTheme.Dialog);
        this.a = LayoutInflater.from(context).inflate(R.layout.layout_required_permission_dialog, null);
        setContentView(this.a);
        this.d.setOnClickListener(new b(this));
        this.e = (TextView) this.a.findViewById(R.id.dlg_confirm_btn);
        this.e.setOnClickListener(new c(this));
        b();
        aVar.a(this, (ViewGroup) this.a);
    }

    private static void a(View view, int i) {
        if (VERSION.SDK_INT >= 21) {
            i = view.getResources().getDrawable(i, null);
        } else {
            i = view.getResources().getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(i);
        } else {
            view.setBackgroundDrawable(i);
        }
    }

    public final void a(OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public final void setTitle(CharSequence charSequence) {
        if (this.b != null) {
            if (charSequence != null) {
                this.b.setText(charSequence);
                return;
            }
            this.b.setText(R.string.tips);
        }
    }

    public final void setTitle(int i) {
        if (this.b != null) {
            if (i != 0) {
                this.b.setText(i);
                return;
            }
            this.b.setText(R.string.tips);
        }
    }

    public final void a(CharSequence charSequence) {
        if (this.e != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.e.setText(R.string.ok);
            } else {
                this.e.setText(charSequence);
            }
        }
    }

    public final void a() {
        if (this.d != null) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            b();
        }
    }

    private void b() {
        if (this.e != null) {
            if (this.d != null) {
                int i = 0;
                int i2 = this.e.getVisibility() == 0 ? 1 : 0;
                if (this.d.getVisibility() == 0) {
                    i2++;
                }
                View view = this.f;
                if (this.d.getVisibility() != 0 || this.e.getVisibility() != 0) {
                    i = 8;
                }
                view.setVisibility(i);
                if (i2 == 1) {
                    if (this.d.getVisibility() == 0) {
                        a(this.d, R.drawable.bottom_button_selector);
                    }
                    if (this.e.getVisibility() == 0) {
                        a(this.e, R.drawable.bottom_button_selector);
                        return;
                    }
                }
                a(this.d, R.drawable.left_button_selector);
                a(this.e, R.drawable.right_button_selector);
            }
        }
    }
}
