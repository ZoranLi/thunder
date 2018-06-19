package com.xunlei.downloadprovider.e.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.a.b.a;
import com.xunlei.downloadprovider.personal.a.i;
import com.xunlei.downloadprovider.personal.a.j;

/* compiled from: LikeGuideDlg */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        i.a(this.a.f, "get_icon_alert", a.a, com.xunlei.downloadprovider.personal.a.a.a().e(), com.xunlei.downloadprovider.personal.a.a.a().f());
        j.a(this.a.c, this.a.d, this.a.e, "get");
    }
}
