package com.xunlei.downloadprovider.download.engine.task.a.a.a;

import android.support.annotation.NonNull;
import com.umeng.message.proguard.k;

/* compiled from: SQLiteTableHelper */
public abstract class a {
    protected final int a;
    protected final int b;

    public a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @NonNull
    protected static String a(String str, String[][] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS `");
        stringBuilder.append(str);
        stringBuilder.append("`(");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("`");
            stringBuilder.append(strArr[i][0]);
            stringBuilder.append("` ");
            stringBuilder.append(strArr[i][1]);
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
