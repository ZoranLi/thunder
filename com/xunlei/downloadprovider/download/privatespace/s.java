package com.xunlei.downloadprovider.download.privatespace;

import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: PrivateSpaceDialog */
class s extends XLBaseDialog implements OnClickListener {
    private Context a;
    View b = LayoutInflater.from(this.a).inflate(R.layout.activity_private_space, null);
    private TextView c = ((TextView) this.b.findViewById(R.id.dlg_title));
    private TextView d = ((TextView) this.b.findViewById(R.id.dlg_message));
    private EditText e = ((EditText) this.b.findViewById(R.id.password_et));
    private ImageView f = ((ImageView) this.b.findViewById(R.id.password_visible_iv));
    private EditText g = ((EditText) this.b.findViewById(R.id.password_re_et));
    private ImageView h = ((ImageView) this.b.findViewById(R.id.password_visible_re_iv));
    private TextView i = ((TextView) this.b.findViewById(R.id.dlg_cancel_btn));
    private TextView j = ((TextView) this.b.findViewById(R.id.dlg_confirm_btn));
    private View k = this.b.findViewById(R.id.password_re_ll);

    public s(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        this.a = context;
        this.f.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.j.setTextColor(getContext().getResources().getColor(R.color.button_text_gray));
        this.j.setEnabled(false);
        this.e.addTextChangedListener(new t(this));
        this.g.addTextChangedListener(new u(this));
        setContentView(this.b);
    }

    public void c(String str) {
        this.c.setText(str);
    }

    public void b(String str) {
        this.d.setText(str);
    }

    public void a(boolean z) {
        this.k.setVisibility(z ? false : true);
        if (this.k.getVisibility()) {
            this.e.setImeOptions(6);
        } else {
            this.e.setImeOptions(5);
        }
    }

    public void a(String str) {
        this.j.setText(str);
    }

    public String c() {
        return this.e.getText().toString();
    }

    public String b() {
        return this.g.getText().toString();
    }

    public void a() {
        this.e.setText("");
        this.g.setText("");
    }

    public void b(OnClickListener onClickListener) {
        this.j.setOnClickListener(onClickListener);
    }

    public void a(OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == R.id.dlg_cancel_btn) {
            dismiss();
        } else if (view == R.id.password_visible_iv) {
            if (this.f.isSelected() != null) {
                this.e.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f.setSelected(false);
            } else {
                this.e.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                this.f.setSelected(true);
            }
            this.e.setSelection(this.e.getText().length());
        } else if (view == R.id.password_visible_re_iv) {
            if (this.h.isSelected() != null) {
                this.h.setSelected(false);
                this.g.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                this.h.setSelected(true);
                this.g.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            this.g.setSelection(this.g.getText().length());
        }
    }
}
