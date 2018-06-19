package com.xunlei.downloadprovider.web.browser;

import android.view.View;
import android.view.View.OnClickListener;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.web.website.b.e;

/* compiled from: InputAutoCompleteView */
final class ax implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ a b;

    ax(a aVar, e eVar) {
        this.b = aVar;
        this.a = eVar;
    }

    public final void onClick(View view) {
        if (this.b.a.n != null) {
            this.b.a.n.a(this.a.a(), RePlugin.PROCESS_UI.equals(this.a.b()) ^ 1);
        }
    }
}
