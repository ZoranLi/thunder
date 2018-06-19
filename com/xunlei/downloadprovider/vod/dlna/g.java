package com.xunlei.downloadprovider.vod.dlna;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: DLNAListDialog */
final class g implements OnItemClickListener {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.a.i.setContentView(this.a.l);
        this.a.e();
        adapterView = this.a.n;
        if (i >= 0) {
            if (i < adapterView.a.size()) {
                adapterView = (s) adapterView.a.get(i);
                this.a.v.obtainMessage(5, 3000, 0).sendToTarget();
                this.a.C.setText(this.a.h);
                this.a.B.setText(adapterView.b);
                b.a(this.a, adapterView.a, this.a.g);
                if (this.a.t != null) {
                    this.a.t.b();
                }
            }
        }
        adapterView = null;
        this.a.v.obtainMessage(5, 3000, 0).sendToTarget();
        this.a.C.setText(this.a.h);
        this.a.B.setText(adapterView.b);
        b.a(this.a, adapterView.a, this.a.g);
        if (this.a.t != null) {
            this.a.t.b();
        }
    }
}
