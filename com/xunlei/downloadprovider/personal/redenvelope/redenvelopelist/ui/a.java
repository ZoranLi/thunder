package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;

/* compiled from: RedEnvelopesActivity */
final class a implements com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.a.b.a {
    final /* synthetic */ RedEnvelopesActivity a;

    a(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.iv_red_envelope_open) {
            e eVar = (e) view.getTag();
            if (eVar != null) {
                RedEnvelopesActivity.a(this.a, this.a, eVar);
            }
        }
    }
}
