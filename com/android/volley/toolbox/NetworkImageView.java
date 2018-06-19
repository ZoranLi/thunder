package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.Request;
import com.android.volley.toolbox.o.c;
import com.android.volley.toolbox.o.d;

public class NetworkImageView extends ImageView {
    private String a;
    private int b;
    private int c;
    private o d;
    private c e;

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDefaultImageResId(int i) {
        this.b = i;
    }

    public void setErrorImageResId(int i) {
        this.c = i;
    }

    private void a() {
        if (this.b != 0) {
            setImageResource(this.b);
        } else {
            setImageBitmap(null);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        NetworkImageView networkImageView = this;
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        ScaleType scaleType = getScaleType();
        if (getLayoutParams() != null) {
            z2 = getLayoutParams().width == -2;
            z3 = getLayoutParams().height == -2;
        } else {
            z2 = false;
            z3 = z2;
        }
        boolean z4 = z2 && z3;
        if (!(width == 0 && height == 0 && !z4)) {
            if (TextUtils.isEmpty(networkImageView.a)) {
                if (networkImageView.e != null) {
                    networkImageView.e.a();
                    networkImageView.e = null;
                }
                a();
                return;
            }
            if (!(networkImageView.e == null || networkImageView.e.c == null)) {
                if (!networkImageView.e.c.equals(networkImageView.a)) {
                    networkImageView.e.a();
                    a();
                }
            }
            if (z2) {
                width = 0;
            }
            int i5 = z3 ? 0 : height;
            o oVar = networkImageView.d;
            String str = networkImageView.a;
            d wVar = new w(networkImageView);
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
            }
            c cVar;
            StringBuilder stringBuilder = new StringBuilder(str.length() + 12);
            stringBuilder.append("#W");
            stringBuilder.append(width);
            stringBuilder.append("#H");
            stringBuilder.append(i5);
            stringBuilder.append("#S");
            stringBuilder.append(scaleType.ordinal());
            stringBuilder.append(str);
            String stringBuilder2 = stringBuilder.toString();
            Bitmap a = oVar.b.a();
            c cVar2;
            if (a != null) {
                cVar2 = new c(oVar, a, str, null, null);
                wVar.a(cVar2, true);
                cVar = cVar2;
            } else {
                cVar2 = new c(oVar, null, str, stringBuilder2, wVar);
                wVar.a(cVar2, true);
                a aVar = (a) oVar.c.get(stringBuilder2);
                if (aVar != null) {
                    aVar.c.add(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = cVar2;
                    Request sVar = new s(str, new p(oVar, stringBuilder2), width, i5, scaleType, Config.RGB_565, new q(oVar, stringBuilder2));
                    oVar.a.a(sVar);
                    oVar.c.put(stringBuilder2, new a(oVar, sVar, cVar));
                }
            }
            networkImageView.e = cVar;
        }
    }

    protected void onDetachedFromWindow() {
        if (this.e != null) {
            this.e.a();
            setImageBitmap(null);
            this.e = null;
        }
        super.onDetachedFromWindow();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
