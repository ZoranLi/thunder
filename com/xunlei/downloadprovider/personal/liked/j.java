package com.xunlei.downloadprovider.personal.liked;

/* compiled from: LikeContentActivity */
final class j implements Runnable {
    final /* synthetic */ LikeContentActivity a;

    j(LikeContentActivity likeContentActivity) {
        this.a = likeContentActivity;
    }

    public final void run() {
        boolean z = true;
        if (this.a.c != 1) {
            if (this.a.d != 1) {
                if (this.a.c != 0) {
                    if (this.a.d != 0) {
                        if (this.a.c == 2 && this.a.d == 2) {
                            LikeCinecismFragment d = this.a.m;
                            if (d.a != null) {
                                if (d.a.getItemCount() != 0) {
                                    z = false;
                                }
                            }
                            if (z) {
                                this.a.f.setVisibility(8);
                                this.a.i.setVisibility(8);
                                this.a.e.setScrollble(false);
                            }
                            this.a.j.hide();
                        }
                    }
                }
                this.a.j.show();
                this.a.k.setVisibility(4);
                return;
            }
        }
        this.a.k.setVisibility(0);
        this.a.j.hide();
    }
}
