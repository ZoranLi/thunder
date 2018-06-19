package com.xunlei.downloadprovider.database.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 11;

    public static abstract class OpenHelper extends DatabaseOpenHelper {
        public OpenHelper(Context context, String str) {
            super(context, str, 11);
        }

        public OpenHelper(Context context, String str, CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 11);
        }

        public void onCreate(Database database) {
            DaoMaster.createAllTables(database, false);
        }
    }

    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String str) {
            super(context, str);
        }

        public DevOpenHelper(Context context, String str, CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        public void onUpgrade(Database database, int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder("Upgrading schema from version ");
            stringBuilder.append(i);
            stringBuilder.append(" to ");
            stringBuilder.append(i2);
            stringBuilder.append(" by dropping all tables");
            DaoMaster.dropAllTables(database, 1);
            onCreate(database);
        }
    }

    public static void createAllTables(Database database, boolean z) {
        CardSlideInfoDao.createTable(database, z);
        BTSubTaskVisitRecordDao.createTable(database, z);
        VideoPlayRecordDao.createTable(database, z);
        UserGridDataInfoDao.createTable(database, z);
        CollectWebsiteInfoDao.createTable(database, z);
        HistoryWebsiteInfoDao.createTable(database, z);
    }

    public static void dropAllTables(Database database, boolean z) {
        CardSlideInfoDao.dropTable(database, z);
        BTSubTaskVisitRecordDao.dropTable(database, z);
        VideoPlayRecordDao.dropTable(database, z);
        UserGridDataInfoDao.dropTable(database, z);
        CollectWebsiteInfoDao.dropTable(database, z);
        HistoryWebsiteInfoDao.dropTable(database, z);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoMaster(new DevOpenHelper(context, str).getWritableDb()).newSession();
    }

    public DaoMaster(SQLiteDatabase sQLiteDatabase) {
        this(new StandardDatabase(sQLiteDatabase));
    }

    public DaoMaster(Database database) {
        super(database, 11);
        registerDaoClass(CardSlideInfoDao.class);
        registerDaoClass(BTSubTaskVisitRecordDao.class);
        registerDaoClass(VideoPlayRecordDao.class);
        registerDaoClass(UserGridDataInfoDao.class);
        registerDaoClass(CollectWebsiteInfoDao.class);
        registerDaoClass(HistoryWebsiteInfoDao.class);
    }

    public DaoSession newSession() {
        return new DaoSession(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.db, identityScopeType, this.daoConfigMap);
    }
}
