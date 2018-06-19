package me.iwf.photopicker.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoPagerAdapter */
final class f implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ e b;

    f(e eVar, Context context) {
        this.b = eVar;
        this.a = context;
    }

    public final void onClick(View view) {
        if ((this.a instanceof Activity) != null && ((Activity) this.a).isFinishing() == null) {
            ((Activity) this.a).onBackPressed();
        }
    }
}
