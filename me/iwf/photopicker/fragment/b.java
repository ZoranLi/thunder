package me.iwf.photopicker.fragment;

import android.support.v4.view.ViewPager.OnPageChangeListener;

/* compiled from: ImagePagerFragment */
final class b implements OnPageChangeListener {
    final /* synthetic */ ImagePagerFragment a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    b(ImagePagerFragment imagePagerFragment) {
        this.a = imagePagerFragment;
    }

    public final void onPageSelected(int i) {
        this.a.g = this.a.h == i;
    }
}
