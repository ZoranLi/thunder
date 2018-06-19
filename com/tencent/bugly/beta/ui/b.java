package com.tencent.bugly.beta.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

/* compiled from: BUGLY */
public abstract class b extends Fragment {
    protected boolean m = false;

    public abstract boolean a(int i, KeyEvent keyEvent);

    public synchronized boolean b() {
        return this.m;
    }

    public synchronized void a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void onResume() {
        super.onResume();
        synchronized (this) {
            this.m = true;
        }
    }

    public void onPause() {
        super.onPause();
        synchronized (this) {
            this.m = false;
        }
    }
}
