package com.ali.auth.third.core.i;

import android.app.Activity;

public abstract class b<Params, Progress, Result> extends a<Params, Progress, Result> {
    protected Activity a;

    public b(Activity activity) {
        this.a = activity;
    }

    protected void onPreExecute() {
    }
}
