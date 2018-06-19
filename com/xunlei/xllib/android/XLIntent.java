package com.xunlei.xllib.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

@Deprecated
public class XLIntent extends Intent {
    public XLIntent(String str) {
        super(str);
    }

    public XLIntent(String str, Uri uri) {
        super(str, uri);
    }

    public XLIntent(Context context, Class<?> cls) {
        super(context, cls);
    }

    private static android.os.Bundle a(android.content.Intent r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = android.content.Intent.class;	 Catch:{ NoSuchFieldException -> 0x0014, NoSuchFieldException -> 0x0014 }
        r2 = "mExtras";	 Catch:{ NoSuchFieldException -> 0x0014, NoSuchFieldException -> 0x0014 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0014, NoSuchFieldException -> 0x0014 }
        r2 = 1;	 Catch:{ NoSuchFieldException -> 0x0014, NoSuchFieldException -> 0x0014 }
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0014, NoSuchFieldException -> 0x0014 }
        r3 = r1.get(r3);	 Catch:{ NoSuchFieldException -> 0x0014, NoSuchFieldException -> 0x0014 }
        r3 = (android.os.Bundle) r3;	 Catch:{ NoSuchFieldException -> 0x0014, NoSuchFieldException -> 0x0014 }
        r0 = r3;
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.android.XLIntent.a(android.content.Intent):android.os.Bundle");
    }

    private android.os.Bundle a(int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = a(r2);
        if (r0 != 0) goto L_0x001a;
    L_0x0006:
        r0 = new android.os.Bundle;
        r0.<init>(r3);
        r3 = android.content.Intent.class;	 Catch:{ NoSuchFieldException -> 0x001a, NoSuchFieldException -> 0x001a }
        r1 = "mExtras";	 Catch:{ NoSuchFieldException -> 0x001a, NoSuchFieldException -> 0x001a }
        r3 = r3.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x001a, NoSuchFieldException -> 0x001a }
        r1 = 1;	 Catch:{ NoSuchFieldException -> 0x001a, NoSuchFieldException -> 0x001a }
        r3.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x001a, NoSuchFieldException -> 0x001a }
        r3.set(r2, r0);	 Catch:{ NoSuchFieldException -> 0x001a, NoSuchFieldException -> 0x001a }
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.android.XLIntent.a(int):android.os.Bundle");
    }

    public Intent putExtras(Bundle bundle) {
        a(bundle.size());
        super.putExtras(bundle);
        return this;
    }

    public Intent putExtra(String str, boolean z) {
        a(9);
        super.putExtra(str, z);
        return this;
    }

    public Intent putExtra(String str, byte b) {
        a(9);
        super.putExtra(str, b);
        return this;
    }

    public Intent putExtra(String str, char c) {
        a(9);
        super.putExtra(str, c);
        return this;
    }

    public Intent putExtra(String str, short s) {
        a(9);
        super.putExtra(str, s);
        return this;
    }

    public Intent putExtra(String str, int i) {
        a(9);
        super.putExtra(str, i);
        return this;
    }

    public Intent putExtra(String str, long j) {
        a(9);
        super.putExtra(str, j);
        return this;
    }

    public Intent putExtra(String str, float f) {
        a(9);
        super.putExtra(str, f);
        return this;
    }

    public Intent putExtra(String str, double d) {
        a(9);
        super.putExtra(str, d);
        return this;
    }

    public Intent putExtra(String str, String str2) {
        a(9);
        super.putExtra(str, str2);
        return this;
    }

    public Intent putExtra(String str, CharSequence charSequence) {
        a(9);
        super.putExtra(str, charSequence);
        return this;
    }

    public Intent putExtra(String str, Parcelable parcelable) {
        a(9);
        super.putExtra(str, parcelable);
        return this;
    }

    public Intent putExtra(String str, Parcelable[] parcelableArr) {
        a(9);
        super.putExtra(str, parcelableArr);
        return this;
    }

    public Intent putParcelableArrayListExtra(String str, ArrayList<? extends Parcelable> arrayList) {
        a(9);
        super.putExtra(str, arrayList);
        return this;
    }

    public Intent putIntegerArrayListExtra(String str, ArrayList<Integer> arrayList) {
        a(9);
        super.putExtra(str, arrayList);
        return this;
    }

    public Intent putStringArrayListExtra(String str, ArrayList<String> arrayList) {
        a(9);
        super.putExtra(str, arrayList);
        return this;
    }

    public Intent putCharSequenceArrayListExtra(String str, ArrayList<CharSequence> arrayList) {
        a(9);
        super.putExtra(str, arrayList);
        return this;
    }

    public Intent putExtra(String str, Serializable serializable) {
        a(9);
        super.putExtra(str, serializable);
        return this;
    }

    public Intent putExtra(String str, boolean[] zArr) {
        a(9);
        super.putExtra(str, zArr);
        return this;
    }

    public Intent putExtra(String str, byte[] bArr) {
        a(9);
        super.putExtra(str, bArr);
        return this;
    }

    public Intent putExtra(String str, short[] sArr) {
        a(9);
        super.putExtra(str, sArr);
        return this;
    }

    public Intent putExtra(String str, char[] cArr) {
        a(9);
        super.putExtra(str, cArr);
        return this;
    }

    public Intent putExtra(String str, int[] iArr) {
        a(9);
        super.putExtra(str, iArr);
        return this;
    }

    public Intent putExtra(String str, long[] jArr) {
        a(9);
        super.putExtra(str, jArr);
        return this;
    }

    public Intent putExtra(String str, float[] fArr) {
        a(9);
        super.putExtra(str, fArr);
        return this;
    }

    public Intent putExtra(String str, double[] dArr) {
        a(9);
        super.putExtra(str, dArr);
        return this;
    }

    public Intent putExtra(String str, String[] strArr) {
        a(9);
        super.putExtra(str, strArr);
        return this;
    }

    public Intent putExtra(String str, CharSequence[] charSequenceArr) {
        a(9);
        super.putExtra(str, charSequenceArr);
        return this;
    }

    public Intent putExtra(String str, Bundle bundle) {
        a(9);
        super.putExtra(str, bundle);
        return this;
    }

    public Intent putExtras(Intent intent) {
        a(9);
        super.putExtras(intent);
        return this;
    }
}
