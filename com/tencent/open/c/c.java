package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.a.f;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.open.web.security.a;

/* compiled from: ProGuard */
public class c extends b {
    public static boolean a;
    private KeyEvent b;
    private a c;

    public c(Context context) {
        super(context);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        StringBuilder stringBuilder = new StringBuilder("-->dispatchKeyEvent, is device support: ");
        stringBuilder.append(a);
        f.b("openSDK_LOG.SecureWebView", stringBuilder.toString());
        if (!a) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        switch (keyCode) {
            case 66:
                return super.dispatchKeyEvent(keyEvent);
            case 67:
                a.b = true;
                return super.dispatchKeyEvent(keyEvent);
            default:
                if (keyEvent.getUnicodeChar() == 0) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (SecureJsInterface.isPWDEdit) {
                    keyCode = keyEvent.getUnicodeChar();
                    if ((keyCode >= 33 && keyCode <= 95) || (keyCode >= 97 && keyCode <= 125)) {
                        this.b = new KeyEvent(0, 17);
                        return super.dispatchKeyEvent(this.b);
                    }
                }
                return super.dispatchKeyEvent(keyEvent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        StringBuilder stringBuilder = new StringBuilder("-->onKeyDown, is device support: ");
        stringBuilder.append(a);
        f.b("openSDK_LOG.SecureWebView", stringBuilder.toString());
        if (!a) {
            return super.onKeyDown(i, keyEvent);
        }
        if (keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4) {
            return super.onKeyDown(i, keyEvent);
        }
        switch (keyCode) {
            case 66:
                return super.onKeyDown(i, keyEvent);
            case 67:
                a.b = true;
                return super.onKeyDown(i, keyEvent);
            default:
                if (keyEvent.getUnicodeChar() == 0) {
                    return super.onKeyDown(i, keyEvent);
                }
                if (SecureJsInterface.isPWDEdit) {
                    keyCode = keyEvent.getUnicodeChar();
                    if ((keyCode >= 33 && keyCode <= 95) || (keyCode >= 97 && keyCode <= 125)) {
                        this.b = new KeyEvent(null, 17);
                        return super.onKeyDown(this.b.getKeyCode(), this.b);
                    }
                }
                return super.onKeyDown(i, keyEvent);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        StringBuilder stringBuilder = new StringBuilder("-->create input connection, is edit: ");
        stringBuilder.append(SecureJsInterface.isPWDEdit);
        f.c("openSDK_LOG.SecureWebView", stringBuilder.toString());
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        StringBuilder stringBuilder2 = new StringBuilder("-->onCreateInputConnection, inputConn is ");
        stringBuilder2.append(onCreateInputConnection);
        f.a("openSDK_LOG.SecureWebView", stringBuilder2.toString());
        if (onCreateInputConnection != null) {
            a = true;
            this.c = new a(super.onCreateInputConnection(editorInfo), false);
            return this.c;
        }
        a = false;
        return onCreateInputConnection;
    }
}
