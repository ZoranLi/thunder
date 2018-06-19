package com.ali.auth.third.core.i;

import android.os.AsyncTask;

public abstract class a<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public abstract Result a();

    public abstract void b();

    protected Result doInBackground(Params... paramsArr) {
        try {
            a();
            return null;
        } catch (Throwable th) {
            th.getMessage();
            boolean z = com.ali.auth.third.core.config.a.a;
            b();
            return null;
        }
    }
}
