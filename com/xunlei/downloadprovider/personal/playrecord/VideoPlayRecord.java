package com.xunlei.downloadprovider.personal.playrecord;

import java.util.Calendar;
import java.util.Date;

public class VideoPlayRecord {
    public Long b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public String l;
    public String m;
    public String n;
    public String o;
    String p;

    private enum PlayTimeCategory {
        TODAY,
        YESTERDAY,
        THREE_DAYS_AGO
    }

    public enum RECORD_TYPE {
        TAG_SHORT_VIDEO,
        TAG_LONG_VIDEO
    }

    public VideoPlayRecord(Long l, String str, String str2, String str3, String str4, long j, long j2, long j3, long j4, long j5, String str5, String str6, String str7, String str8) {
        this.b = l;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = j;
        this.h = j2;
        this.i = j3;
        this.j = j4;
        this.k = j5;
        this.l = str5;
        this.m = str6;
        this.n = str7;
        this.o = str8;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("VideoPlayRecord{id=");
        stringBuilder.append(this.b);
        stringBuilder.append(", typeTag='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", name='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", playUrl='");
        stringBuilder.append(this.e);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrl='");
        stringBuilder.append(this.f);
        stringBuilder.append('\'');
        stringBuilder.append(", duration=");
        stringBuilder.append(this.g);
        stringBuilder.append(", playedTime=");
        stringBuilder.append(this.h);
        stringBuilder.append(", maxPlayedTime =");
        stringBuilder.append(this.i);
        stringBuilder.append(", lastPlayTimestamp=");
        stringBuilder.append(this.j);
        stringBuilder.append(", size=");
        stringBuilder.append(this.k);
        stringBuilder.append(", downloadUrl='");
        stringBuilder.append(this.l);
        stringBuilder.append('\'');
        stringBuilder.append(", cid='");
        stringBuilder.append(this.m);
        stringBuilder.append('\'');
        stringBuilder.append(", gcid='");
        stringBuilder.append(this.n);
        stringBuilder.append('\'');
        stringBuilder.append(", movieId='");
        stringBuilder.append(this.o);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.RECORD_TYPE g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.c;	 Catch:{ IllegalArgumentException -> 0x0007 }
        r0 = com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.RECORD_TYPE.valueOf(r0);	 Catch:{ IllegalArgumentException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.RECORD_TYPE.TAG_LONG_VIDEO;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.g():com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord$RECORD_TYPE");
    }

    public final void a(RECORD_TYPE record_type) {
        if (record_type == null) {
            this.c = RECORD_TYPE.TAG_LONG_VIDEO.toString();
        } else {
            this.c = record_type.toString();
        }
    }

    final void h() {
        if (a().equals(PlayTimeCategory.TODAY)) {
            this.p = "今天";
        } else if (a().equals(PlayTimeCategory.YESTERDAY)) {
            this.p = "昨天";
        } else {
            if (a().equals(PlayTimeCategory.THREE_DAYS_AGO)) {
                this.p = "3天前";
            }
        }
    }

    private PlayTimeCategory a() {
        if (0 != this.j) {
            Date date = new Date(this.j);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.set(1, instance.get(1));
            instance2.set(2, instance.get(2));
            instance2.set(5, instance.get(5));
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            Calendar instance3 = Calendar.getInstance();
            instance3.set(1, instance.get(1));
            instance3.set(2, instance.get(2));
            instance3.set(5, instance.get(5) - 1);
            instance3.set(11, 0);
            instance3.set(12, 0);
            instance3.set(13, 0);
            instance.setTime(date);
            if (instance.after(instance2)) {
                return PlayTimeCategory.TODAY;
            }
            if (instance.before(instance2) && instance.after(instance3)) {
                return PlayTimeCategory.YESTERDAY;
            }
        }
        return PlayTimeCategory.THREE_DAYS_AGO;
    }
}
