package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a;
import com.xunlei.xllib.b.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ChatSQLiteOpenHelper */
public final class o extends SQLiteOpenHelper {
    private static o b;
    private static long c;
    public List<a> a = null;
    private SQLiteDatabase d;
    private AtomicInteger e = new AtomicInteger();

    private o(String str) {
        super(BrothersApplication.getApplicationInstance().getApplicationContext(), str, null, 1);
    }

    public static o a() {
        if (a.a().b) {
            long userId = a.a().a.userId();
            if (c != userId || b == null) {
                c = userId;
                StringBuilder stringBuilder = new StringBuilder("thunder_personal_chat_user");
                stringBuilder.append(g.a(String.valueOf(userId).getBytes()));
                b = new o(stringBuilder.toString());
            }
            return b;
        }
        throw new IllegalStateException("非法操作，未登录状态下使用聊天数据库！");
    }

    public static boolean b() {
        return a.a().b;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (a a : this.a) {
            a.a(sQLiteDatabase);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase = this.a.iterator();
        while (sQLiteDatabase.hasNext() != 0) {
            sQLiteDatabase.next();
        }
    }

    public final synchronized SQLiteDatabase c() {
        if (this.e.incrementAndGet() == 1) {
            this.d = getWritableDatabase();
        }
        return this.d;
    }

    public final synchronized void d() {
        if (this.e.decrementAndGet() == 0) {
            this.d.close();
            this.d = null;
        }
    }
}
