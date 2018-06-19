package com.xunlei.downloadprovider.web.browser;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/* compiled from: BrowserTitleBarFragment */
final class ai implements OnClickListener {
    final /* synthetic */ BrowserTitleBarFragment a;

    ai(BrowserTitleBarFragment browserTitleBarFragment) {
        this.a = browserTitleBarFragment;
    }

    public final void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.c.getText());
        stringBuilder.append(((TextView) view).getText().toString());
        view = stringBuilder.toString();
        this.a.c.setText(view);
        this.a.c.setSelection(view.length());
    }
}
