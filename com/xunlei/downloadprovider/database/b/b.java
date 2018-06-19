package com.xunlei.downloadprovider.database.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.xunlei.downloadprovider.database.greendao.CollectWebsiteInfoDao;
import com.xunlei.downloadprovider.database.greendao.DaoMaster.OpenHelper;
import com.xunlei.downloadprovider.database.greendao.HistoryWebsiteInfoDao;
import com.xunlei.downloadprovider.database.greendao.VideoPlayRecordDao;
import org.greenrobot.greendao.database.Database;

/* compiled from: GreenDaoOpenHelper */
public final class b extends OpenHelper {
    public b(Context context, String str) {
        super(context, str);
    }

    public final void onUpgrade(Database database, int i, int i2) {
        if (i2 >= 3) {
            c.a(database, VideoPlayRecordDao.class);
        }
        if (i < 7) {
            c.a(database, CollectWebsiteInfoDao.class, HistoryWebsiteInfoDao.class);
        }
        a.a().a(database);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("onDowngrade  oldVersion = ");
        stringBuilder.append(i);
        stringBuilder.append(", newVersion = ");
        stringBuilder.append(i2);
        a.a().a(sQLiteDatabase);
        a.a().b(sQLiteDatabase);
    }
}
