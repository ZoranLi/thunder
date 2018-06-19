package com.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.view.View;
import com.airbnb.lottie.b;
import com.airbnb.lottie.model.i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager */
public final class a {
    public final i<String> a = new i();
    public final Map<i<String>, Typeface> b = new HashMap();
    public final Map<String, Typeface> c = new HashMap();
    public final AssetManager d;
    @Nullable
    public b e;
    public String f = ".ttf";

    public a(Callback callback, @Nullable b bVar) {
        this.e = bVar;
        if ((callback instanceof View) == null) {
            this.d = null;
        } else {
            this.d = ((View) callback).getContext().getAssets();
        }
    }
}
