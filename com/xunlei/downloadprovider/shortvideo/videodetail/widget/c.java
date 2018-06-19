package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: FollowDialog */
final class c implements OnClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.follow_tv:
                b.b(this.a);
                break;
            case R.id.follow_cancel_tv:
                b.a(this.a);
                return;
            default:
                break;
        }
    }
}
