package com.xunlei.downloadprovider.personal.playrecord;

import android.text.TextUtils;
import com.xunlei.common.concurrent.XLThreadPool.ForDatabase;
import com.xunlei.downloadprovider.database.a.a;
import com.xunlei.downloadprovider.download.engine.kernel.i;
import com.xunlei.downloadprovider.download.tasklist.list.download.TaskDownloadCardViewHolder;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.RECORD_TYPE;
import java.util.HashMap;
import java.util.Set;

/* compiled from: PlayRecordDataManager */
public class v {
    private static volatile v c;
    final HashMap<String, VideoPlayRecord> a = new HashMap();
    public b b;
    private final af d = af.a();

    /* compiled from: PlayRecordDataManager */
    public interface b {
        void a(VideoPlayRecord videoPlayRecord);
    }

    public static v a() {
        if (c == null) {
            synchronized (v.class) {
                if (c == null) {
                    c = new v();
                }
            }
        }
        return c;
    }

    private v() {
    }

    static String a(String str) {
        if (!str.contains("http://127.0.0.1")) {
            return str;
        }
        Object a = i.a(str);
        return TextUtils.isEmpty(a) ? str : a;
    }

    public final void a(VideoPlayRecord videoPlayRecord, boolean z) {
        if (videoPlayRecord != null) {
            this.a.put(videoPlayRecord.e, videoPlayRecord);
            String str = TaskDownloadCardViewHolder.TAG;
            StringBuilder stringBuilder = new StringBuilder(" --- ");
            stringBuilder.append((((double) videoPlayRecord.h) * 1.0d) / ((double) videoPlayRecord.g));
            stringBuilder.append("  ");
            stringBuilder.append(videoPlayRecord.e);
            if (z) {
                videoPlayRecord.a(RECORD_TYPE.TAG_SHORT_VIDEO);
            } else {
                videoPlayRecord.a(RECORD_TYPE.TAG_LONG_VIDEO);
            }
            if (videoPlayRecord.j == 0) {
                videoPlayRecord.j = System.currentTimeMillis();
            }
            ForDatabase.executeWrite(new x(this, videoPlayRecord));
        }
    }

    public final void a(String str, b bVar, String str2) {
        a(str, bVar, str2, false);
    }

    public final void a(String str, b bVar, String str2, boolean z) {
        this.b = bVar;
        if (TextUtils.isEmpty(str) == null) {
            str = a(str);
            if (this.a.size() <= null || this.a.containsKey(str) == null) {
                ForDatabase.executeRead(new z(this, str, str2, z));
                return;
            }
            if (this.b != null) {
                this.b.a((VideoPlayRecord) this.a.get(str));
            }
            return;
        }
        if (this.b != null) {
            this.b.a(null);
        }
    }

    public final void a(Set<Long> set) {
        if (!set.isEmpty()) {
            this.a.clear();
            ForDatabase.executeWrite(new aa(this, set));
        }
    }

    public final void a(c cVar) {
        this.a.clear();
        ForDatabase.executeRead(new ab(this, cVar));
    }

    public final void a(String str, String str2) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            if (!TextUtils.equals(str, str2)) {
                ForDatabase.executeWrite(new ac(this, str, str2));
            }
        }
    }

    public final void a(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            aVar.a(null);
        }
        ForDatabase.executeRead(new ae(this, aVar, str));
    }

    public final void a(a aVar) {
        if (aVar != null) {
            if (!TextUtils.isEmpty(aVar.c)) {
                ForDatabase.executeWrite(new ad(this, aVar));
            }
        }
    }
}
