package com.xunlei.downloadprovider.player.xmp.ui;

/* compiled from: PlayerOperationViewDetail */
final class be implements Runnable {
    final /* synthetic */ PlayerOperationViewDetail a;

    be(PlayerOperationViewDetail playerOperationViewDetail) {
        this.a = playerOperationViewDetail;
    }

    public final void run() {
        this.a.o.setImageAssetsFolder("lottie/detailliveguide/images");
        this.a.o.setAnimation("lottie/detailliveguide/data.json");
        this.a.o.a();
    }
}
