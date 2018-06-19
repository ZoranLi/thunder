package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: PayFloatDialog */
public final class u extends XLBaseDialog {
    protected View a;
    protected TextView b = ((TextView) this.a.findViewById(R.id.dlg_title));
    protected TextView c = ((TextView) this.a.findViewById(R.id.dlg_content));
    protected TextView d = ((TextView) this.a.findViewById(R.id.dlg_cancel_btn));
    protected TextView e;
    protected View f = this.a.findViewById(R.id.dlg_btn_vertical_divider);
    protected OnClickListener g;
    protected OnClickListener h;
    TextView i;
    TextView j;
    TextView k;
    Context l;

    public u(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        this.a = LayoutInflater.from(context).inflate(R.layout.pay_float_dialog_layout, null);
        setContentView(this.a);
        this.l = context;
        this.d.setOnClickListener(new v(this));
        this.e = (TextView) this.a.findViewById(R.id.dlg_confirm_btn);
        this.e.setOnClickListener(new w(this));
        this.i = (TextView) this.a.findViewById(R.id.privilege_1);
        this.j = (TextView) this.a.findViewById(R.id.privilege_2);
        this.k = (TextView) this.a.findViewById(R.id.privilege_3);
        if (this.e != null) {
            if (this.d != null) {
                int i = 0;
                context = this.e.getVisibility() == null ? 1 : null;
                if (this.d.getVisibility() == 0) {
                    context++;
                }
                View view = this.f;
                if (this.d.getVisibility() != 0 || this.e.getVisibility() != 0) {
                    i = 8;
                }
                view.setVisibility(i);
                if (context == 1) {
                    if (this.d.getVisibility() == null) {
                        a(this.d, R.drawable.bottom_button_selector);
                    }
                    if (this.e.getVisibility() == null) {
                        a(this.e, R.drawable.bottom_button_selector);
                        return;
                    }
                }
                a(this.d, R.drawable.left_button_selector);
                a(this.e, R.drawable.right_button_selector);
            }
        }
    }

    public final void a(OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public final void b(OnClickListener onClickListener) {
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

    public final void a(int i) {
        if (this.c != null) {
            this.c.setText(i);
        }
    }

    public final void a(CharSequence charSequence) {
        if (this.d != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.d.setText(R.string.cancel);
            } else {
                this.d.setText(charSequence);
            }
        }
    }

    public final void b(CharSequence charSequence) {
        if (this.e != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.e.setText(R.string.ok);
            } else {
                this.e.setText(charSequence);
            }
        }
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

    protected final boolean isOutOfBounds(Context context, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        motionEvent = (int) motionEvent.getY();
        context = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View decorView = getWindow().getDecorView();
        int i = -context;
        if (x >= i && motionEvent >= i && x <= decorView.getWidth() + context) {
            if (motionEvent <= decorView.getHeight() + context) {
                return null;
            }
        }
        return true;
    }
}
