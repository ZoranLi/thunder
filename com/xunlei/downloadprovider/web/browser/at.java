package com.xunlei.downloadprovider.web.browser;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.xunlei.common.androidutil.AndroidConfig;

/* compiled from: InputAutoCompleteView */
final class at implements OnKeyListener {
    final /* synthetic */ InputAutoCompleteView a;

    at(InputAutoCompleteView inputAutoCompleteView) {
        this.a = inputAutoCompleteView;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 66) {
            if (keyEvent.getKeyCode() != 0) {
                return null;
            }
        }
        AndroidConfig.hiddenInput(this.a.h, view);
        return true;
    }
}
