package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xunlei.xllib.android.XLIntent;

public final class StateSyncManager {

    public static class CommentSateInfo implements Parcelable {
        public static final Creator<CommentSateInfo> CREATOR = new ax();
        public long a;
        public boolean b;
        public long c;
        public String d;
        public long e;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.a);
            parcel.writeByte(this.b);
            parcel.writeLong(this.c);
            parcel.writeString(this.d);
            parcel.writeLong(this.e);
        }

        protected CommentSateInfo(Parcel parcel) {
            this.a = parcel.readLong();
            this.b = parcel.readByte() != (byte) 0;
            this.c = parcel.readLong();
            this.d = parcel.readString();
            this.e = parcel.readLong();
        }
    }

    public enum SourceFrom {
        PAGE_SHORMOVIE_DETAIL,
        PAGE_PERSONAL_SPACE,
        PAGE_FEED_FLOW
    }

    public static void a(Context context, SourceFrom sourceFrom, CommentSateInfo commentSateInfo) {
        Intent xLIntent = new XLIntent();
        xLIntent.setAction("action_comment_zan_state_changed");
        xLIntent.putExtra("comment_info", commentSateInfo);
        xLIntent.putExtra("source_from", sourceFrom.name());
        context.sendBroadcast(xLIntent);
    }
}
