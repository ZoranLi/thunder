package com.xunlei.downloadprovider.personal.playrecord;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: PlayRecordActivity */
final class e implements OnClickListener {
    final /* synthetic */ VideoPlayRecord a;
    final /* synthetic */ PlayRecordActivity b;

    e(PlayRecordActivity playRecordActivity, VideoPlayRecord videoPlayRecord) {
        this.b = playRecordActivity;
        this.a = videoPlayRecord;
    }

    public final void onClick(View view) {
        PlayRecordActivity.b(this.b.L);
        view = view.getId();
        if (view == R.id.play_record_list_btn_delete) {
            this.b.y.add(this.a.b);
            this.b.a(true);
        } else if (view == R.id.play_record_list_btn_download) {
            PlayRecordActivity.d(this.b, this.a);
        }
    }
}
