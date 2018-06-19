package com.airbnb.lottie.model;

import android.content.res.Resources;
import com.airbnb.lottie.i;
import com.airbnb.lottie.i.a;
import com.airbnb.lottie.q;
import java.io.InputStream;

/* compiled from: FileCompositionLoader */
public final class e extends b<InputStream> {
    private final Resources a;
    private final q b;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a.a(this.a, ((InputStream[]) objArr)[0]);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        this.b.a((i) obj);
    }

    public e(Resources resources, q qVar) {
        this.a = resources;
        this.b = qVar;
    }
}
