package com.xunlei.common.androidutil;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import com.xunlei.common.commonview.XLToast;

public class ClipboardUtil {

    final class AnonymousClass1 implements OnPrimaryClipChangedListener {
        final /* synthetic */ Context val$appContext;
        final /* synthetic */ ClipboardManager val$clipboardManager;

        AnonymousClass1(ClipboardManager clipboardManager, Context context) {
            this.val$clipboardManager = clipboardManager;
            this.val$appContext = context;
        }

        public final void onPrimaryClipChanged() {
            try {
                this.val$clipboardManager.removePrimaryClipChangedListener(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            XLToast.showToast(this.val$appContext, "复制成功");
        }
    }

    public static void copyToClipboard(Context context, String str, String str2) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (str2 == null) {
            str2 = "";
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(str2, str));
    }

    public static void copyToClipboardWithToast(Context context, String str) {
        if (str != null) {
            Context applicationContext = context.getApplicationContext();
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            clipboardManager.addPrimaryClipChangedListener(new AnonymousClass1(clipboardManager, applicationContext));
            clipboardManager.setPrimaryClip(ClipData.newPlainText("thunder", str));
        }
    }

    public static String getClipboardText(Context context) {
        try {
            context = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
        } catch (Context context2) {
            context2.printStackTrace();
            context2 = null;
        }
        if (context2 != null && context2.getItemCount() > 0) {
            context2 = context2.getItemAt(0);
            if (context2.getText() != null) {
                return context2.getText().toString().trim();
            }
        }
        return null;
    }
}
