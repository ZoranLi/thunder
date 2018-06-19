package com.xunlei.downloadprovider.shortvideo.videodetail;

/* compiled from: ShortMovieDetailFragment */
final class am implements Runnable {
    final /* synthetic */ ShortMovieDetailFragment a;

    am(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void run() {
        this.a.aF.setVisibility(8);
        this.a.aG.setImageAssetsFolder("lottie/detailsharejump/images");
        this.a.aG.setAnimation("lottie/detailsharejump/data.json");
        this.a.aF.setImageAssetsFolder("lottie/detailsharepack/images");
        this.a.aF.setAnimation("lottie/detailsharepack/data.json");
        this.a.aG.a();
        this.a.aG.a(true);
        this.a.aG.a(new an(this));
        this.a.aF.a(new ao(this));
    }
}
