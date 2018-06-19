package com.xunlei.thunder.commonui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.xunlei.thunder.commonui.R;

/* compiled from: XLBasicAlertDialog */
public final class b extends XLBaseDialog implements OnClickListener {
    public final a a;
    public OnClickListener b;
    public OnClickListener c;
    public OnClickListener d;

    public b(@NonNull Context context) {
        this(context, R.style.ThemeCommonUI_Dialog);
    }

    private b(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        context = LayoutInflater.from(context).inflate(R.layout.commonui_basic_alert_dialog_view, null);
        this.a = new a(context);
        setContentView(context);
        this.a.d.setOnClickListener(new c(this));
        this.a.e.setOnClickListener(new d(this));
        this.a.f.setOnClickListener(new e(this));
        this.a.f.setVisibility(8);
        this.a.a();
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case -3:
                if (this.c == null) {
                    dismiss();
                    break;
                } else {
                    this.c.onClick(this, i);
                    return;
                }
            case -2:
                if (this.d != null) {
                    this.d.onClick(this, i);
                    return;
                } else {
                    dismiss();
                    return;
                }
            case -1:
                if (this.b != null) {
                    this.b.onClick(this, i);
                    return;
                } else {
                    dismiss();
                    return;
                }
            default:
                break;
        }
    }

    public final b a(int i, int i2) {
        a aVar = this.a;
        switch (i) {
            case -3:
                if (aVar.f != 0) {
                    aVar.f.setVisibility(i2);
                    break;
                }
                break;
            case -2:
                if (aVar.d != 0) {
                    aVar.d.setVisibility(i2);
                    break;
                }
                break;
            case -1:
                if (aVar.e != 0) {
                    aVar.e.setVisibility(i2);
                    break;
                }
                break;
            default:
                break;
        }
        aVar.a();
        return this;
    }

    public final b a() {
        return a(-2, 8);
    }

    public final b a(boolean z) {
        return a(-3, z ? true : false);
    }

    public final void setTitle(CharSequence charSequence) {
        if (this.a.b != null) {
            if (charSequence != null) {
                this.a.b.setText(charSequence);
                return;
            }
            this.a.b.setText(R.string.commonui_dialog_title_tips);
        }
    }

    public final void setTitle(@StringRes int i) {
        if (this.a.b != null) {
            if (i != 0) {
                this.a.b.setText(i);
                return;
            }
            this.a.b.setText(R.string.commonui_dialog_title_tips);
        }
    }

    public final b a(@StringRes int i) {
        if (this.a.c != null) {
            this.a.c.setText(i);
        }
        return this;
    }

    public final b a(CharSequence charSequence) {
        if (this.a.c != null) {
            TextView textView = this.a.c;
            if (charSequence == null) {
                charSequence = "";
            }
            textView.setText(charSequence);
        }
        return this;
    }

    public final b b(@StringRes int i) {
        if (this.a.d != null) {
            this.a.d.setText(i);
        }
        return this;
    }

    public final b b(CharSequence charSequence) {
        if (this.a.d != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.a.d.setText(R.string.dialog_button_text_cancel);
            } else {
                this.a.d.setText(charSequence);
            }
        }
        return this;
    }

    public final b c(@StringRes int i) {
        if (this.a.e != null) {
            this.a.e.setText(i);
        }
        return this;
    }

    public final b d(@StringRes int i) {
        if (this.a.f != null) {
            this.a.f.setText(i);
        }
        return this;
    }
}
