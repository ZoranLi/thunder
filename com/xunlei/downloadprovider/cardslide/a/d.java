package com.xunlei.downloadprovider.cardslide.a;

import android.text.TextUtils;
import com.xunlei.downloadprovider.database.b.a;
import com.xunlei.downloadprovider.database.greendao.CardSlideInfoDao$Properties;
import org.greenrobot.greendao.query.WhereCondition;

/* compiled from: CardSlideDao */
public final class d {
    public static boolean a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            e eVar = (e) a.a().b().getCardSlideInfoDao().queryBuilder().where(CardSlideInfoDao$Properties.ResId.eq(str), new WhereCondition[0]).unique();
            if (eVar != null) {
                try {
                    a.a().b().getCardSlideInfoDao().delete(eVar);
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

    public static long a(e eVar) {
        long j = -1;
        if (TextUtils.isEmpty(eVar.b)) {
            return -1;
        }
        try {
            j = a.a().b().getCardSlideInfoDao().insertOrReplace(eVar);
        } catch (e eVar2) {
            eVar2.printStackTrace();
        }
        return j;
    }
}
