package com.xunlei.downloadprovider.personal.a.b.b;

import com.xunlei.downloadprovider.database.greendao.UserGridDataInfoDao.Properties;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UserGridDataDao */
public final class a {
    public static long a(b bVar) {
        try {
            return com.xunlei.downloadprovider.database.b.a.a().b().getUserGridDataInfoDao().insertOrReplace(bVar);
        } catch (b bVar2) {
            bVar2.printStackTrace();
            return -1;
        }
    }

    public static List<b> a() {
        List arrayList = new ArrayList();
        try {
            return com.xunlei.downloadprovider.database.b.a.a().b().getUserGridDataInfoDao().queryBuilder().orderAsc(Properties.Id).list();
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }
}
