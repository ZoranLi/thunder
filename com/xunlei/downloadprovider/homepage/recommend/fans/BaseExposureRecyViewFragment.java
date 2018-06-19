package com.xunlei.downloadprovider.homepage.recommend.fans;

public abstract class BaseExposureRecyViewFragment<T> extends BaseRecyViewFragment<T> {
    protected boolean a = false;
    protected boolean b;
    private boolean k = true;
    private boolean l = true;

    public void a(boolean z) {
    }

    public void b(boolean z) {
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.b = z;
        if (z) {
            l();
        } else {
            k();
        }
    }

    public void onStart() {
        super.onStart();
        if (getUserVisibleHint()) {
            l();
        }
    }

    public void onStop() {
        super.onStop();
        this.i = true;
        if (getUserVisibleHint()) {
            k();
        }
    }

    private void k() {
        if (this.a) {
            this.a = false;
            if (this.k) {
                a(true);
                this.k = false;
                return;
            }
            a(false);
        }
    }

    private void l() {
        if (!(this.a || this.i)) {
            this.a = true;
            if (this.l) {
                b(true);
                this.l = false;
                return;
            }
            b(false);
        }
    }
}
