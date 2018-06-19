package com.xunlei.downloadprovider.download.speedup.view;

/* compiled from: FlickerSingleProgressView */
final class b implements Runnable {
    final /* synthetic */ FlickerSingleProgressView a;

    b(FlickerSingleProgressView flickerSingleProgressView) {
        this.a = flickerSingleProgressView;
    }

    public final void run() {
        if (System.currentTimeMillis() - this.a.C < 16) {
            this.a.postDelayed(this, 16);
            this.a.C = System.currentTimeMillis();
            return;
        }
        float d;
        float b = this.a.getTranslateDx();
        this.a.m = this.a.m + b;
        if (this.a.m > this.a.B) {
            d = this.a.B;
        } else {
            d = this.a.getMaxTranslate();
        }
        if (this.a.m >= d) {
            this.a.m = d;
        }
        StringBuilder stringBuilder = new StringBuilder("dx=");
        stringBuilder.append(b);
        stringBuilder.append(";MAX_TRANSLATE=");
        stringBuilder.append(this.a.y);
        stringBuilder.append(";MIDDLE_TRANSLATE=");
        stringBuilder.append(this.a.z);
        stringBuilder.append(";LOW_TRANSLATE=");
        stringBuilder.append(this.a.A);
        stringBuilder.append(";maxtranslate=");
        stringBuilder.append(d);
        stringBuilder.append(";progressGradientWidth=");
        stringBuilder.append(this.a.getProgressGradientWidth());
        FlickerSingleProgressView.j(this.a);
        if (this.a.m == d) {
            this.a.m = 0.0f;
            this.a.m();
        }
        this.a.B = this.a.getMaxTranslate();
        this.a.invalidate();
        this.a.postDelayed(this, 16);
        FlickerSingleProgressView flickerSingleProgressView = this.a;
        Object obj = (flickerSingleProgressView.e && flickerSingleProgressView.d) ? 1 : null;
        if (obj == null) {
            this.a.i();
        }
        this.a.C = System.currentTimeMillis();
    }
}
