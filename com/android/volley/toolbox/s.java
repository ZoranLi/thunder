package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView.ScaleType;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.d;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.q;

/* compiled from: ImageRequest */
public final class s extends Request<Bitmap> {
    private static final Object g = new Object();
    private final Object a = new Object();
    private b<Bitmap> b;
    private final Config c;
    private final int d;
    private final int e;
    private final ScaleType f;

    protected final /* synthetic */ void deliverResponse(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        synchronized (this.a) {
            b bVar = this.b;
        }
        if (bVar != null) {
            bVar.onResponse(bitmap);
        }
    }

    public s(String str, b<Bitmap> bVar, int i, int i2, ScaleType scaleType, Config config, a aVar) {
        super(0, str, aVar);
        setRetryPolicy(new d(1000, 2, 2.0f));
        this.b = bVar;
        this.c = config;
        this.d = i;
        this.e = i2;
        this.f = scaleType;
    }

    public final Priority getPriority() {
        return Priority.LOW;
    }

    private static int a(int i, int i2, int i3, int i4, ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        } else {
            if (i == 0) {
                return (int) (((double) i3) * (((double) i2) / ((double) i4)));
            } else if (i2 == 0) {
                return i;
            } else {
                double d = ((double) i4) / ((double) i3);
                double d2;
                if (scaleType == ScaleType.CENTER_CROP) {
                    d2 = (double) i2;
                    if (((double) i) * d < d2) {
                        i = (int) (d2 / d);
                    }
                    return i;
                }
                d2 = (double) i2;
                if (((double) i) * d > d2) {
                    i = (int) (d2 / d);
                }
                return i;
            }
        }
    }

    protected final n<Bitmap> parseNetworkResponse(j jVar) {
        n<Bitmap> a;
        synchronized (g) {
            try {
                Object decodeByteArray;
                byte[] bArr = jVar.b;
                Options options = new Options();
                if (this.d == 0 && this.e == 0) {
                    options.inPreferredConfig = this.c;
                    decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                } else {
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    int i = options.outWidth;
                    int i2 = options.outHeight;
                    int a2 = a(this.d, this.e, i, i2, this.f);
                    int a3 = a(this.e, this.d, i2, i, this.f);
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = a(i, i2, a2, a3);
                    decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    if (decodeByteArray != null && (decodeByteArray.getWidth() > a2 || decodeByteArray.getHeight() > a3)) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a2, a3, true);
                        decodeByteArray.recycle();
                        decodeByteArray = createScaledBitmap;
                    }
                }
                if (decodeByteArray == null) {
                    a = n.a(new ParseError(jVar));
                } else {
                    a = n.a(decodeByteArray, k.a(jVar));
                }
            } catch (Throwable e) {
                q.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(jVar.b.length), getUrl());
                return n.a(new ParseError(e));
            }
        }
        return a;
    }

    public final void cancel() {
        super.cancel();
        synchronized (this.a) {
            this.b = null;
        }
    }

    private static int a(int i, int i2, int i3, int i4) {
        i = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        i3 = 1065353216;
        while (true) {
            i4 = 1073741824 * i3;
            if (((double) i4) > i) {
                return (int) i3;
            }
            i3 = i4;
        }
    }
}
