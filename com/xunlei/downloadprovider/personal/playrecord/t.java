package com.xunlei.downloadprovider.personal.playrecord;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: PlayRecordActivity */
final class t implements OnClickListener {
    final /* synthetic */ VideoPlayRecord a;
    final /* synthetic */ c b;

    t(c cVar, VideoPlayRecord videoPlayRecord) {
        this.b = cVar;
        this.a = videoPlayRecord;
    }

    public final void onClick(View view) {
        view = view.getId();
        if (view != R.id.play_record_list_item_layout) {
            if (view == R.id.play_record_list_item_btn_right) {
                if ((this.a instanceof b) != null) {
                    PlayRecordActivity.a(this.b.a, (b) this.a);
                    return;
                }
                PlayRecordActivity.b(this.b.a, this.a);
            }
            return;
        }
        if (this.b.a.C != null) {
            if (this.b.a.y.contains(this.a.b) != null) {
                this.b.a.y.remove(this.a.b);
            } else {
                this.b.a.y.add(this.a.b);
            }
            this.b.a.k();
        } else if ((this.a instanceof b) != null) {
            PlayRecordActivity.a(this.b.a, (b) this.a);
        } else {
            PlayRecordActivity.b(this.b.a, this.a);
        }
        this.b.notifyDataSetChanged();
    }
}
