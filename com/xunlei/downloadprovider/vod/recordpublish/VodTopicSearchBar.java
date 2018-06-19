package com.xunlei.downloadprovider.vod.recordpublish;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.xunlei.downloadprovider.R;

public class VodTopicSearchBar extends FrameLayout {
    public EditText a;
    public ImageView b;
    public TextView c;
    private TextWatcher d;
    private TextWatcher e = new a(this);
    private boolean f = false;
    private TextView g;
    private Drawable h;
    private OnFocusChangeListener i;
    private String j;

    class a implements TextWatcher {
        final /* synthetic */ VodTopicSearchBar a;

        a(VodTopicSearchBar vodTopicSearchBar) {
            this.a = vodTopicSearchBar;
        }

        public final void afterTextChanged(Editable editable) {
            this.a.b.setVisibility(!TextUtils.isEmpty(this.a.getEditTextContent()) ? 0 : 8);
            if (this.a.d != null) {
                this.a.d.afterTextChanged(editable);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.a.d != null) {
                this.a.d.beforeTextChanged(charSequence, i, i2, i3);
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.a.d != null) {
                this.a.d.onTextChanged(charSequence, i, i2, i3);
            }
        }
    }

    public VodTopicSearchBar(@NonNull Context context) {
        super(context);
        a(context);
    }

    public VodTopicSearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.vod_search_tab_search_title_bar, this, true);
        this.a = (EditText) context.findViewById(R.id.search_really_edit);
        this.c = (TextView) context.findViewById(R.id.tex_cannel);
        this.b = (ImageView) context.findViewById(R.id.search_bar_edit_delete);
        this.a.addTextChangedListener(this.e);
        this.g = (TextView) context.findViewById(R.id.xlps_search_hint_tv);
        this.h = getResources().getDrawable(R.drawable.vod_search_icon_assiotive_item);
        this.b.setOnClickListener(new x(this));
        this.a.setOnFocusChangeListener(new y(this));
    }

    private void a(boolean z) {
        if (z) {
            this.g.setVisibility(8);
            this.a.setHint(this.j);
            this.a.setCompoundDrawablesWithIntrinsicBounds(this.h, null, null, null);
            this.a.requestFocus();
            ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 0);
            return;
        }
        if (TextUtils.isEmpty(this.a.getText())) {
            this.g.setVisibility(0);
            this.a.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            this.a.setHint("");
        }
    }

    public void setSearchTip(String str) {
        this.g.setText(str);
    }

    public void clearFocus() {
        this.a.clearFocus();
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.i = onFocusChangeListener;
    }

    public void setHideCancelView(boolean z) {
        this.f = z;
    }

    public String getEditTextContent() {
        return this.a.getEditableText().toString().trim();
    }

    public void setEditText(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.a;
        r0.setText(r2);
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 != 0) goto L_0x0018;
    L_0x000b:
        r0 = r1.a;	 Catch:{ Exception -> 0x0014 }
        r2 = r2.length();	 Catch:{ Exception -> 0x0014 }
        r0.setSelection(r2);	 Catch:{ Exception -> 0x0014 }
    L_0x0014:
        r2 = 1;
        r1.a(r2);
    L_0x0018:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.vod.recordpublish.VodTopicSearchBar.setEditText(java.lang.String):void");
    }

    public void setEditHint(String str) {
        this.j = str;
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.a.setOnEditorActionListener(onEditorActionListener);
    }

    public void setTextLocation(int i) {
        if (this.a != null) {
            this.a.setGravity(i);
        }
    }

    public void setCancelState(boolean z) {
        if (!(this.c == null || this.f)) {
            if (z) {
                this.c.setVisibility(0);
                return;
            }
            this.c.setVisibility(8);
        }
    }

    public void setCannelListener(OnClickListener onClickListener) {
        if (this.c != null) {
            this.c.setOnClickListener(onClickListener);
        }
    }

    public void setTextColorHint(int i) {
        if (this.a != null) {
            this.a.setHintTextColor(i);
        }
    }
}
