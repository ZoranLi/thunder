package com.xunlei.downloadprovider.web.website.c;

import android.text.TextUtils;
import com.xunlei.downloadprovider.database.b.a;
import com.xunlei.downloadprovider.database.greendao.HistoryWebsiteInfoDao$Properties;
import com.xunlei.downloadprovider.web.website.b.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* compiled from: HistoryWebsiteDao */
public final class b {
    public static boolean a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            str = a.a().b().getHistoryWebsiteInfoDao().queryBuilder().where(HistoryWebsiteInfoDao$Properties.WebsiteUrl.eq(str), new WhereCondition[0]).list();
            if (str != null) {
                a.a().b().getHistoryWebsiteInfoDao().deleteInTx(str);
                z = true;
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return z;
    }

    public static d b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str = a.a().b().getHistoryWebsiteInfoDao().queryBuilder().where(HistoryWebsiteInfoDao$Properties.WebsiteUrl.eq(str), new WhereCondition[0]).list();
        } catch (String str2) {
            str2.printStackTrace();
            str2 = null;
        }
        if (str2 == null || str2.size() <= 0) {
            return null;
        }
        return (d) str2.get(0);
    }

    public static List<d> a() {
        List<d> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = a.a().b().getHistoryWebsiteInfoDao().queryBuilder();
            Property[] propertyArr = new Property[1];
            int i = 0;
            propertyArr[0] = HistoryWebsiteInfoDao$Properties.Id;
            Collection list = queryBuilder.orderDesc(propertyArr).list();
            if (list.size() > 500) {
                while (i < 500) {
                    arrayList.add(list.get(i));
                    i++;
                }
            } else {
                arrayList.addAll(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<d> b() {
        List arrayList = new ArrayList();
        try {
            return a.a().b().getHistoryWebsiteInfoDao().queryBuilder().orderDesc(new Property[]{HistoryWebsiteInfoDao$Properties.Id}).list();
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public static long a(d dVar) {
        long j = -1;
        if (!(dVar == null || TextUtils.isEmpty(dVar.b))) {
            if (!TextUtils.isEmpty(dVar.c)) {
                try {
                    j = a.a().b().getHistoryWebsiteInfoDao().insertOrReplace(dVar);
                } catch (d dVar2) {
                    dVar2.printStackTrace();
                }
                return j;
            }
        }
        return -1;
    }
}
