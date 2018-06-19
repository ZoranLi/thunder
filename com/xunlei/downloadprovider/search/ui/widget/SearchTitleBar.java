package com.xunlei.downloadprovider.search.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.search.ui.search.bq;

public class SearchTitleBar extends FrameLayout {
    public ImageView a;
    public EditText b;
    public ImageView c;
    public TextView d;
    public TextWatcher e;
    private TextWatcher f = new a(this);
    private String g = bq.a().a;

    class a implements TextWatcher {
        final /* synthetic */ SearchTitleBar a;

        a(SearchTitleBar searchTitleBar) {
            this.a = searchTitleBar;
        }

        public final void afterTextChanged(Editable editable) {
            this.a.c.setVisibility(!TextUtils.isEmpty(this.a.getEditTextContent()) ? 0 : 8);
            if (this.a.e != null) {
                this.a.e.afterTextChanged(editable);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.a.e != null) {
                this.a.e.beforeTextChanged(charSequence, i, i2, i3);
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.a.e != null) {
                this.a.e.onTextChanged(charSequence, i, i2, i3);
            }
        }
    }

    public SearchTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public SearchTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SearchTitleBar(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.search_tab_search_title_bar, this, true);
        this.a = (ImageView) findViewById(R.id.search_back_btn);
        this.b = (EditText) findViewById(R.id.search_really_edit);
        this.b.addTextChangedListener(this.f);
        this.d = (TextView) findViewById(R.id.go_to_search_btn);
        this.b.setHint(this.g);
        a(this.g.equals("搜索或输入网址") ^ 1);
        this.c = (ImageView) findViewById(R.id.search_bar_edit_delete);
    }

    public final void a(boolean z) {
        if (this.d != null) {
            if (com.xunlei.downloadprovider.h.k.a.d(getEditTextContent())) {
                this.d.setText("前往");
            } else {
                this.d.setText("搜索");
            }
            this.d.setEnabled(z);
            this.d.setTextColor(Color.parseColor(z ? "#1294f6" : "#979aa0"));
        }
    }

    public String getEditTextContent() {
        return this.b.getEditableText().toString().trim();
    }

    public void setEditText(String str) {
        this.b.setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.b.setSelection(str.length());
        }
    }

    public void setEditHint(String str) {
        this.b.setHint(str);
    }

    public final void a() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
    }

    public void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.b.setOnEditorActionListener(onEditorActionListener);
    }
}
