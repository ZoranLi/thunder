package org.android.agoo.message;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.a;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.message.proguard.k;

/* compiled from: Taobao */
class MessageService$a extends SQLiteOpenHelper {
    public MessageService$a(Context context) {
        super(context, "message_accs_db", null, 3);
    }

    public SQLiteDatabase getWritableDatabase() {
        if (a.a(super.getWritableDatabase().getPath(), ShareConstants.MD5_FILE_BUF_LENGTH)) {
            return super.getWritableDatabase();
        }
        return null;
    }

    private String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table accs_message");
        stringBuffer.append(k.s);
        stringBuffer.append("id text UNIQUE not null,");
        stringBuffer.append("state text,");
        stringBuffer.append("message text,");
        stringBuffer.append("create_time date");
        stringBuffer.append(");");
        return stringBuffer.toString();
    }

    private String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table message");
        stringBuffer.append(k.s);
        stringBuffer.append("id text UNIQUE not null,");
        stringBuffer.append("state integer,");
        stringBuffer.append("body_code integer,");
        stringBuffer.append("report long,");
        stringBuffer.append("target_time long,");
        stringBuffer.append("interval integer,");
        stringBuffer.append("type text,");
        stringBuffer.append("message text,");
        stringBuffer.append("notify integer,");
        stringBuffer.append("create_time date");
        stringBuffer.append(");");
        return stringBuffer.toString();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL(b());
                sQLiteDatabase.execSQL("CREATE INDEX id_index ON message(id)");
                sQLiteDatabase.execSQL("CREATE INDEX body_code_index ON message(body_code)");
                sQLiteDatabase.execSQL(a());
            } catch (SQLiteDatabase sQLiteDatabase2) {
                ALog.e("MessageService", "messagedbhelper create", sQLiteDatabase2, new Object[0]);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
            } catch (SQLiteDatabase sQLiteDatabase2) {
                ALog.e("MessageService", "MessageService onUpgrade is error", sQLiteDatabase2, new Object[0]);
                return;
            }
        }
        sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS accs_message");
        sQLiteDatabase2.execSQL(a());
    }
}
