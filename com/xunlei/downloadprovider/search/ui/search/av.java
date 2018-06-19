package com.xunlei.downloadprovider.search.ui.search;

import android.os.Handler;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;

/* compiled from: SearchOperateActivity */
final class av extends Handler {
    final /* synthetic */ SearchOperateActivity a;

    av(SearchOperateActivity searchOperateActivity) {
        this.a = searchOperateActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                message = SearchOperateActivity.a(this.a);
                message.b.requestFocus();
                ((InputMethodManager) message.b.getContext().getSystemService("input_method")).showSoftInput(message.b, 0);
                return;
            case 2:
                if (this.a.getWindow() != null) {
                    this.a.getWindow().setSoftInputMode(32);
                    break;
                }
                break;
            default:
                break;
        }
    }
}
