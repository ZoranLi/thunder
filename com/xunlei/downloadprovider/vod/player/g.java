package com.xunlei.downloadprovider.vod.player;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.xunlei.downloadprovider.R;

/* compiled from: VodPlayerMenuPopupWindow */
final class g implements OnPreDrawListener {
    final /* synthetic */ Context a;
    final /* synthetic */ VodPlayerMenuPopupWindow b;

    g(VodPlayerMenuPopupWindow vodPlayerMenuPopupWindow, Context context) {
        this.b = vodPlayerMenuPopupWindow;
        this.a = context;
    }

    public final boolean onPreDraw() {
        Resources resources = this.a.getResources();
        Drawable drawable = resources.getDrawable(R.drawable.vod_player_seekbar_thumb);
        int a = VodPlayerMenuPopupWindow.a(this.a, 23.0f);
        Drawable bitmapDrawable = new BitmapDrawable(resources, Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), a, a, true));
        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
        this.b.n.setThumb(bitmapDrawable);
        this.b.n.setThumbOffset(VodPlayerMenuPopupWindow.a(this.a, 1.5f));
        this.b.n.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }
}
