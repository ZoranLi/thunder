package com.airbnb.lottie.model;

import android.os.AsyncTask;
import com.airbnb.lottie.a;
import com.airbnb.lottie.i;

/* compiled from: CompositionLoader */
public abstract class b<Params> extends AsyncTask<Params, Void, i> implements a {
    public final void a() {
        cancel(true);
    }
}
