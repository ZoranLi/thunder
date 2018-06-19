package com.airbnb.lottie.model;

import android.content.res.Resources;
import com.airbnb.lottie.i;
import com.airbnb.lottie.i.a;
import com.airbnb.lottie.q;
import org.json.JSONObject;

/* compiled from: JsonCompositionLoader */
public final class h extends b<JSONObject> {
    private final Resources a;
    private final q b;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a.a(this.a, ((JSONObject[]) objArr)[0]);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        this.b.a((i) obj);
    }

    public h(Resources resources, q qVar) {
        this.a = resources;
        this.b = qVar;
    }
}
