package com.xunlei.downloadprovider.web.website.c;

import android.text.TextUtils;
import com.xunlei.downloadprovider.database.greendao.CollectWebsiteInfoDao$Properties;
import com.xunlei.downloadprovider.web.website.b.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* compiled from: CollectWebsiteDao */
public final class a {
    public static boolean a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            str = com.xunlei.downloadprovider.database.b.a.a().b().getCollectWebsiteInfoDao().queryBuilder().where(CollectWebsiteInfoDao$Properties.WebsiteUrl.eq(str), new WhereCondition[0]).list();
            if (str != null && str.size() > 0) {
                try {
                    com.xunlei.downloadprovider.database.b.a.a().b().getCollectWebsiteInfoDao().deleteInTx(str);
                } catch (String str2) {
                    str2.printStackTrace();
                }
                z = true;
            }
        } catch (String str22) {
            str22.printStackTrace();
        }
        return z;
    }

    public static c b(String str) {
        try {
            str = com.xunlei.downloadprovider.database.b.a.a().b().getCollectWebsiteInfoDao().queryBuilder().where(CollectWebsiteInfoDao$Properties.WebsiteUrl.eq(str), new WhereCondition[0]).list();
            if (str == null || str.size() <= 0) {
                return null;
            }
            return (c) str.get(0);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static List<c> a() {
        List<c> arrayList = new ArrayList();
        Set hashSet = new HashSet();
        try {
            QueryBuilder queryBuilder = com.xunlei.downloadprovider.database.b.a.a().b().getCollectWebsiteInfoDao().queryBuilder();
            Property[] propertyArr = new Property[1];
            int i = 0;
            propertyArr[0] = CollectWebsiteInfoDao$Properties.Id;
            Collection list = queryBuilder.orderDesc(propertyArr).list();
            if (list.size() > 500) {
                while (i < 500) {
                    if (!hashSet.contains(((c) list.get(i)).b)) {
                        arrayList.add(list.get(i));
                    }
                    hashSet.add(((c) list.get(i)).b);
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

    public static List<String> b() {
        List<String> arrayList = new ArrayList();
        try {
            List<c> loadAll = com.xunlei.downloadprovider.database.b.a.a().b().getCollectWebsiteInfoDao().loadAll();
            if (loadAll != null && loadAll.size() > 0) {
                for (c cVar : loadAll) {
                    arrayList.add(cVar.b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static long a(c cVar) {
        long j = -1;
        if (!TextUtils.isEmpty(cVar.b)) {
            if (!TextUtils.isEmpty(cVar.c)) {
                try {
                    j = com.xunlei.downloadprovider.database.b.a.a().b().getCollectWebsiteInfoDao().insertOrReplace(cVar);
                } catch (c cVar2) {
                    cVar2.printStackTrace();
                }
                return j;
            }
        }
        return -1;
    }
}
