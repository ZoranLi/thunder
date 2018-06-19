package org.greenrobot.greendao;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.greenrobot.greendao.database.Database;

public class DbUtils {
    public static void vacuum(Database database) {
        database.execSQL("VACUUM");
    }

    public static int executeSqlScript(Context context, Database database, String str) throws IOException {
        return executeSqlScript(context, database, str, true);
    }

    public static int executeSqlScript(Context context, Database database, String str, boolean z) throws IOException {
        context = new String(readAsset(context, str), "UTF-8").split(";(\\s)*[\n\r]");
        if (z) {
            context = executeSqlStatementsInTx(database, context);
        } else {
            context = executeSqlStatements(database, context);
        }
        database = new StringBuilder("Executed ");
        database.append(context);
        database.append(" statements from SQL script '");
        database.append(str);
        database.append("'");
        DaoLog.i(database.toString());
        return context;
    }

    public static int executeSqlStatementsInTx(Database database, String[] strArr) {
        database.beginTransaction();
        try {
            strArr = executeSqlStatements(database, strArr);
            database.setTransactionSuccessful();
            return strArr;
        } finally {
            database.endTransaction();
        }
    }

    public static int executeSqlStatements(Database database, String[] strArr) {
        int i = 0;
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            String trim = strArr[i].trim();
            if (trim.length() > 0) {
                database.execSQL(trim);
                i2++;
            }
            i++;
        }
        return i2;
    }

    public static int copyAllBytes(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            outputStream.write(bArr, 0, read);
            i += read;
        }
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyAllBytes(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readAsset(Context context, String str) throws IOException {
        context = context.getResources().getAssets().open(str);
        try {
            str = readAllBytes(context);
            return str;
        } finally {
            context.close();
        }
    }

    public static void logTableDump(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase = sQLiteDatabase.query(str, null, null, null, null, null, null);
        try {
            DaoLog.d(DatabaseUtils.dumpCursorToString(sQLiteDatabase));
        } finally {
            sQLiteDatabase.close();
        }
    }
}
