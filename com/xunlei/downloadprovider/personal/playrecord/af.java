package com.xunlei.downloadprovider.personal.playrecord;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.database.a.a;
import com.xunlei.downloadprovider.database.greendao.BTSubTaskVisitRecordDao;
import com.xunlei.downloadprovider.database.greendao.BTSubTaskVisitRecordDao$Properties;
import com.xunlei.downloadprovider.database.greendao.VideoPlayRecordDao;
import com.xunlei.downloadprovider.database.greendao.VideoPlayRecordDao$Properties;
import com.xunlei.xllib.b.d;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* compiled from: PlayRecordDatabaseImpl */
class af {
    private static final String a = "af";
    private static volatile af b;

    public static af a() {
        if (b == null) {
            synchronized (af.class) {
                if (b == null) {
                    b = new af();
                }
            }
        }
        return b;
    }

    private af() {
    }

    static com.xunlei.downloadprovider.database.greendao.VideoPlayRecordDao b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.downloadprovider.database.b.a.a();	 Catch:{ Exception -> 0x000d }
        r0 = r0.b();	 Catch:{ Exception -> 0x000d }
        r0 = r0.getVideoPlayRecordDao();	 Catch:{ Exception -> 0x000d }
        return r0;
    L_0x000d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.playrecord.af.b():com.xunlei.downloadprovider.database.greendao.VideoPlayRecordDao");
    }

    static void a(@NonNull VideoPlayRecord videoPlayRecord) {
        VideoPlayRecordDao b = b();
        if (!(b == null || videoPlayRecord == null || videoPlayRecord.e == null)) {
            try {
                b.insertOrReplace(videoPlayRecord);
            } catch (VideoPlayRecord videoPlayRecord2) {
                videoPlayRecord2.printStackTrace();
                new StringBuilder("insertOrReplaceVideoPlayRecord error : ").append(videoPlayRecord2.getMessage());
            }
        }
    }

    static VideoPlayRecord a(String str) {
        VideoPlayRecordDao b = b();
        if (b == null) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = b.queryBuilder();
            queryBuilder.where(VideoPlayRecordDao$Properties.PlayUrl.eq(str), new WhereCondition[0]);
            queryBuilder.orderDesc(new Property[]{VideoPlayRecordDao$Properties.LastPlayTimestamp});
            str = queryBuilder.build().list();
            if (!d.a(str)) {
                return (VideoPlayRecord) str.get(0);
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return null;
    }

    static VideoPlayRecord b(String str) {
        VideoPlayRecordDao b = b();
        if (b == null) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = b.queryBuilder();
            queryBuilder.where(VideoPlayRecordDao$Properties.MovieId.eq(str), new WhereCondition[0]);
            str = queryBuilder.build().list();
            if (!d.a(str)) {
                return (VideoPlayRecord) str.get(0);
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return null;
    }

    static com.xunlei.downloadprovider.database.greendao.BTSubTaskVisitRecordDao c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.downloadprovider.database.b.a.a();	 Catch:{ Exception -> 0x000d }
        r0 = r0.b();	 Catch:{ Exception -> 0x000d }
        r0 = r0.getBTSubTaskVisitRecordDao();	 Catch:{ Exception -> 0x000d }
        return r0;
    L_0x000d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.playrecord.af.c():com.xunlei.downloadprovider.database.greendao.BTSubTaskVisitRecordDao");
    }

    static a c(String str) {
        BTSubTaskVisitRecordDao c = c();
        if (c == null) {
            return null;
        }
        try {
            QueryBuilder queryBuilder = c.queryBuilder();
            queryBuilder.where(BTSubTaskVisitRecordDao$Properties.InfoHash.eq(str), new WhereCondition[0]);
            str = queryBuilder.build().list();
            if (!d.a(str)) {
                return (a) str.get(0);
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return null;
    }
}
