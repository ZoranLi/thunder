package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
public class a extends InputConnectionWrapper {
    public static String a = null;
    public static boolean b = false;
    public static boolean c = false;

    public a(InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        c = true;
        a = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder("-->setComposingText: ");
        stringBuilder.append(charSequence.toString());
        f.a("openSDK_LOG.CaptureInputConnection", stringBuilder.toString());
        return super.setComposingText(charSequence, i);
    }

    public boolean commitText(CharSequence charSequence, int i) {
        c = true;
        a = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder("-->commitText: ");
        stringBuilder.append(charSequence.toString());
        f.a("openSDK_LOG.CaptureInputConnection", stringBuilder.toString());
        return super.commitText(charSequence, i);
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        StringBuilder stringBuilder;
        if (keyEvent.getAction() == 0) {
            f.c("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            a = String.valueOf((char) keyEvent.getUnicodeChar());
            c = true;
            stringBuilder = new StringBuilder("s: ");
            stringBuilder.append(a);
            f.b("openSDK_LOG.CaptureInputConnection", stringBuilder.toString());
        }
        stringBuilder = new StringBuilder("-->sendKeyEvent: ");
        stringBuilder.append(a);
        f.b("openSDK_LOG.CaptureInputConnection", stringBuilder.toString());
        return super.sendKeyEvent(keyEvent);
    }
}
