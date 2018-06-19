package me.iwf.photopicker.fragment;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: ImagePagerFragment */
final class a implements OnPreDrawListener {
    final /* synthetic */ ImagePagerFragment a;

    a(ImagePagerFragment imagePagerFragment) {
        this.a = imagePagerFragment;
    }

    public final boolean onPreDraw() {
        this.a.b.getViewTreeObserver().removeOnPreDrawListener(this);
        int[] iArr = new int[2];
        this.a.b.getLocationOnScreen(iArr);
        this.a.d = this.a.d - iArr[0];
        this.a.c = this.a.c - iArr[1];
        ImagePagerFragment.d(this.a);
        return true;
    }
}
