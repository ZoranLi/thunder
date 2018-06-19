package com.xunlei.downloadprovider.vod.recordpublish;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: EditLengthFilter */
public final class a implements InputFilter {
    private final int a;
    private a b;

    /* compiled from: EditLengthFilter */
    public interface a {
        void a();
    }

    public a(int i, a aVar) {
        this.a = i;
        this.b = aVar;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int length = this.a - (spanned.length() - (i4 - i3));
        if (length <= 0) {
            if (this.b != null) {
                this.b.a();
            }
            return "";
        } else if (length >= i2 - i) {
            return null;
        } else {
            length += i;
            if (Character.isHighSurrogate(charSequence.charAt(length - 1)) != 0) {
                length--;
                if (length == i) {
                    return "";
                }
            }
            return charSequence.subSequence(i, length);
        }
    }
}
