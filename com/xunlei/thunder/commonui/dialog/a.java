package com.xunlei.thunder.commonui.dialog;

import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.thunder.commonui.R;

/* compiled from: BasicAlertDialogViewHolder */
public final class a {
    public View a;
    public TextView b = ((TextView) this.a.findViewById(R.id.dlg_title));
    public TextView c = ((TextView) this.a.findViewById(R.id.dlg_content));
    public TextView d = ((TextView) this.a.findViewById(R.id.dlg_cancel_btn));
    public TextView e = ((TextView) this.a.findViewById(R.id.dlg_confirm_btn));
    public TextView f = ((TextView) this.a.findViewById(R.id.dlg_neutral_btn));
    public FrameLayout g = ((FrameLayout) this.a.findViewById(R.id.dlg_custom));
    private View h = this.a.findViewById(R.id.dlg_btn_vertical_divider);
    private View i = this.a.findViewById(R.id.dlg_btn_vertical_divider_2);

    public a(View view) {
        this.a = view;
    }

    private static void a(View view, @DrawableRes int i) {
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

    public final void a() {
        if (this.e != null) {
            if (this.d != null) {
                int i = 0;
                int i2 = this.d.getVisibility() == 0 ? 1 : 0;
                if (this.f != null && this.f.getVisibility() == 0) {
                    i2++;
                }
                if (this.e.getVisibility() == 0) {
                    i2++;
                }
                if (i2 == 0) {
                    this.h.setVisibility(8);
                    if (this.i != null) {
                        this.i.setVisibility(8);
                        return;
                    }
                }
                if (this.d.getVisibility() == 0) {
                    if (i2 == 1) {
                        a(this.d, R.drawable.commonui_dlg_single_btn_bg_selector);
                    } else {
                        a(this.d, R.drawable.commonui_dlg_left_btn_bg_selector);
                    }
                    this.h.setVisibility(i2 > 1 ? 0 : 8);
                } else {
                    this.h.setVisibility(8);
                }
                if (this.f != null && this.f.getVisibility() == 0) {
                    if (i2 == 1) {
                        a(this.f, R.drawable.commonui_dlg_single_btn_bg_selector);
                    } else if (i2 != 2) {
                        a(this.f, R.drawable.commonui_dlg_middle_btn_bg_selector);
                    } else if (this.d.getVisibility() == 0) {
                        a(this.f, R.drawable.commonui_dlg_right_btn_bg_selector);
                    } else {
                        a(this.f, R.drawable.commonui_dlg_left_btn_bg_selector);
                    }
                    if (this.i != null) {
                        View view = this.i;
                        if (i2 <= 2) {
                            i = 8;
                        }
                        view.setVisibility(i);
                    }
                } else if (this.i != null) {
                    this.i.setVisibility(8);
                }
                if (this.e.getVisibility() == 0) {
                    if (i2 == 1) {
                        a(this.e, R.drawable.commonui_dlg_single_btn_bg_selector);
                        return;
                    }
                    a(this.e, R.drawable.commonui_dlg_right_btn_bg_selector);
                }
            }
        }
    }
}
