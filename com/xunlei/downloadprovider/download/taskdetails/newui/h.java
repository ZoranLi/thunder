package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: DetailsTitleHeaderBar */
final class h implements OnClickListener {
    final /* synthetic */ d a;

    h(d dVar) {
        this.a = dVar;
    }

    public final void onClick(View view) {
        this.a.b.dismiss();
        if (view.getId() == R.id.delete_Button) {
            if (this.a.d != null) {
                this.a.d.a(4);
            }
        }
    }
}
