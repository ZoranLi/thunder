package com.xunlei.downloadprovider.personal.playrecord;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: PlayRecordActivity */
final class f implements OnClickListener {
    final /* synthetic */ b a;
    final /* synthetic */ PlayRecordActivity b;

    f(PlayRecordActivity playRecordActivity, b bVar) {
        this.b = playRecordActivity;
        this.a = bVar;
    }

    public final void onClick(View view) {
        PlayRecordActivity.b(this.b.L);
        if (view.getId() == R.id.play_record_list_btn_delete) {
            this.b.y.add(this.a.b);
            this.b.a(true);
        }
    }
}
