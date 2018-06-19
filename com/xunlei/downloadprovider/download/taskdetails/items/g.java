package com.xunlei.downloadprovider.download.taskdetails.items;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;

/* compiled from: DetailBtTaskSubFileViewHolder */
final class g implements Runnable {
    final /* synthetic */ VideoPlayRecord a;
    final /* synthetic */ f b;

    g(f fVar, VideoPlayRecord videoPlayRecord) {
        this.b = fVar;
        this.a = videoPlayRecord;
    }

    public final void run() {
        this.b.b.t.setVisibility(0);
        this.b.a.mVideoDuration = (int) this.a.g;
        this.b.a.mVideoPlayedTime = (int) this.a.h;
        if (this.a.g != this.a.h || this.a.h <= 0) {
            String str = "0%";
            if (this.a.h > 0) {
                if ((this.b.a.mVideoPlayedTime * 100) / this.b.a.mVideoDuration <= 1) {
                    str = "1%";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((this.b.a.mVideoPlayedTime * 100) / this.b.a.mVideoDuration);
                    stringBuilder.append("%");
                    str = stringBuilder.toString();
                }
            }
            this.b.b.t.setTextColor(this.b.b.itemView.getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColor));
            this.b.b.t.setText(this.b.b.itemView.getContext().getResources().getString(R.string.download_item_task_play_at, new Object[]{str}));
            return;
        }
        this.b.b.t.setTextColor(this.b.b.itemView.getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
        this.b.b.t.setText(R.string.download_item_task_played);
    }
}
