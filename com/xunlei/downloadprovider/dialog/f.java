package com.xunlei.downloadprovider.dialog;

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

/* compiled from: XLManagedAlertDialog */
public final class f extends i {
    protected View a;
    protected TextView b = ((TextView) this.a.findViewById(R.id.dlg_title));
    protected TextView c = ((TextView) this.a.findViewById(R.id.dlg_content));
    protected TextView d = ((TextView) this.a.findViewById(R.id.dlg_cancel_btn));
    protected TextView e;
    protected View f = this.a.findViewById(R.id.dlg_btn_vertical_divider);
    protected OnClickListener g;
    protected OnClickListener h;

    public f(Context context) {
        super(context);
        this.a = LayoutInflater.from(context).inflate(R.layout.xl_alert_dialog, null);
        setContentView(this.a);
        this.d.setOnClickListener(new g(this));
        this.e = (TextView) this.a.findViewById(R.id.dlg_confirm_btn);
        this.e.setOnClickListener(new h(this));
        g();
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

    @Deprecated
    public final void a(CharSequence charSequence) {
        b(charSequence);
    }

    public final void c() {
        if (this.c != null) {
            this.c.setText(R.string.thunder_browser_addtask_failed_already_exist);
        }
    }

    public final void b(CharSequence charSequence) {
        if (this.c != null) {
            TextView textView = this.c;
            if (charSequence == null) {
                charSequence = "";
            }
            textView.setText(charSequence);
        }
    }

    public final void c(CharSequence charSequence) {
        if (this.d != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.d.setText(R.string.cancel);
            } else {
                this.d.setText(charSequence);
            }
        }
    }

    public final void d() {
        if (this.e != null) {
            this.e.setText(R.string.thunder_browser_addtask_failed_check);
        }
    }

    public final void d(CharSequence charSequence) {
        if (this.e != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.e.setText(R.string.ok);
            } else {
                this.e.setText(charSequence);
            }
        }
    }

    public final void e() {
        if (this.d != null) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            g();
        }
    }

    public final void f() {
        if (this.e != null) {
            int i = 0;
            this.e.setVisibility(0);
            View view = this.f;
            if (this.d.getVisibility() != 0) {
                i = 8;
            }
            view.setVisibility(i);
            g();
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

    private void g() {
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
