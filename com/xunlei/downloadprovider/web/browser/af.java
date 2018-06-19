package com.xunlei.downloadprovider.web.browser;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.xunlei.downloadprovider.R;

/* compiled from: BrowserTitleBarFragment */
final class af implements OnEditorActionListener {
    final /* synthetic */ BrowserTitleBarFragment a;

    af(BrowserTitleBarFragment browserTitleBarFragment) {
        this.a = browserTitleBarFragment;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        textView = textView.getText().toString().trim();
        if (TextUtils.isEmpty(textView) != 0) {
            Toast.makeText(this.a.getActivity(), R.string.browser_input_empty_tip, 0).show();
        } else if (this.a.k != 0) {
            this.a.k.a(textView);
        }
        return true;
    }
}
