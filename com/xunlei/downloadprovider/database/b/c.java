package com.xunlei.downloadprovider.database.b;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

/* compiled from: MigrationHelper */
public final class c {
    public static boolean a = false;
    private static String b = "MigrationHelper";
    private static WeakReference<a> c;

    private static boolean a(Database database, boolean z, String str) {
        if (database != null) {
            if (!TextUtils.isEmpty(str)) {
                z = z ? "sqlite_temp_master" : "sqlite_master";
                StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
                stringBuilder.append(z);
                stringBuilder.append(" WHERE type = ? AND name = ?");
                z = stringBuilder.toString();
                Cursor cursor = null;
                try {
                    database = database.rawQuery(z, new String[]{"table", str});
                    if (database != null) {
                        try {
                            if (database.moveToFirst()) {
                                z = database.getInt(0);
                                if (database != null) {
                                    database.close();
                                }
                                if (z <= false) {
                                    return true;
                                }
                                return false;
                            }
                        } catch (Exception e) {
                            z = e;
                            cursor = database;
                            try {
                                z.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                                z = false;
                                if (z <= false) {
                                    return false;
                                }
                                return true;
                            } catch (Throwable th) {
                                z = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw z;
                            }
                        } catch (Throwable th2) {
                            z = th2;
                            cursor = database;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw z;
                        }
                    }
                    if (database != null) {
                        database.close();
                    }
                    return false;
                } catch (Exception e2) {
                    z = e2;
                    z.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    z = false;
                    if (z <= false) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    private static String a(DaoConfig daoConfig) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : daoConfig.allColumns) {
            stringBuilder.append(append);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (stringBuilder.length() > null) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static void a(Database database, String str, boolean z, @NonNull Class<? extends AbstractDao<?, ?>>... clsArr) {
        if (clsArr.length > 0) {
            try {
                for (Class declaredMethod : clsArr) {
                    declaredMethod.getDeclaredMethod(str, new Class[]{Database.class, Boolean.TYPE}).invoke(null, new Object[]{database, Boolean.valueOf(z)});
                }
            } catch (Database database2) {
                database2.printStackTrace();
            } catch (Database database22) {
                database22.printStackTrace();
            } catch (Database database222) {
                database222.printStackTrace();
            }
        }
    }

    private static void b(org.greenrobot.greendao.database.Database r11, java.lang.Class<? extends org.greenrobot.greendao.AbstractDao<?, ?>>... r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r0;
    L_0x0002:
        r2 = r12.length;
        if (r1 >= r2) goto L_0x00aa;
    L_0x0005:
        r2 = new org.greenrobot.greendao.internal.DaoConfig;
        r3 = r12[r1];
        r2.<init>(r11, r3);
        r3 = r2.tablename;
        r4 = r2.tablename;
        r5 = "_TEMP";
        r4 = r4.concat(r5);
        r5 = 1;
        r5 = a(r11, r5, r4);
        if (r5 == 0) goto L_0x00a6;
    L_0x001d:
        r5 = a(r11, r4);	 Catch:{ SQLException -> 0x00a6 }
        r6 = new java.util.ArrayList;	 Catch:{ SQLException -> 0x00a6 }
        r7 = r5.size();	 Catch:{ SQLException -> 0x00a6 }
        r6.<init>(r7);	 Catch:{ SQLException -> 0x00a6 }
        r7 = r0;	 Catch:{ SQLException -> 0x00a6 }
    L_0x002b:
        r8 = r2.properties;	 Catch:{ SQLException -> 0x00a6 }
        r8 = r8.length;	 Catch:{ SQLException -> 0x00a6 }
        if (r7 >= r8) goto L_0x0055;	 Catch:{ SQLException -> 0x00a6 }
    L_0x0030:
        r8 = r2.properties;	 Catch:{ SQLException -> 0x00a6 }
        r8 = r8[r7];	 Catch:{ SQLException -> 0x00a6 }
        r8 = r8.columnName;	 Catch:{ SQLException -> 0x00a6 }
        r9 = r5.contains(r8);	 Catch:{ SQLException -> 0x00a6 }
        if (r9 == 0) goto L_0x0052;	 Catch:{ SQLException -> 0x00a6 }
    L_0x003c:
        r9 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x00a6 }
        r10 = "`";	 Catch:{ SQLException -> 0x00a6 }
        r9.<init>(r10);	 Catch:{ SQLException -> 0x00a6 }
        r9.append(r8);	 Catch:{ SQLException -> 0x00a6 }
        r8 = "`";	 Catch:{ SQLException -> 0x00a6 }
        r9.append(r8);	 Catch:{ SQLException -> 0x00a6 }
        r8 = r9.toString();	 Catch:{ SQLException -> 0x00a6 }
        r6.add(r8);	 Catch:{ SQLException -> 0x00a6 }
    L_0x0052:
        r7 = r7 + 1;	 Catch:{ SQLException -> 0x00a6 }
        goto L_0x002b;	 Catch:{ SQLException -> 0x00a6 }
    L_0x0055:
        r2 = r6.size();	 Catch:{ SQLException -> 0x00a6 }
        if (r2 <= 0) goto L_0x0092;	 Catch:{ SQLException -> 0x00a6 }
    L_0x005b:
        r2 = ",";	 Catch:{ SQLException -> 0x00a6 }
        r2 = android.text.TextUtils.join(r2, r6);	 Catch:{ SQLException -> 0x00a6 }
        r5 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x00a6 }
        r5.<init>();	 Catch:{ SQLException -> 0x00a6 }
        r6 = "REPLACE INTO ";	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r6);	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r3);	 Catch:{ SQLException -> 0x00a6 }
        r3 = " (";	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r3);	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r2);	 Catch:{ SQLException -> 0x00a6 }
        r3 = ") SELECT ";	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r3);	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r2);	 Catch:{ SQLException -> 0x00a6 }
        r2 = " FROM ";	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r2);	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r4);	 Catch:{ SQLException -> 0x00a6 }
        r2 = ";";	 Catch:{ SQLException -> 0x00a6 }
        r5.append(r2);	 Catch:{ SQLException -> 0x00a6 }
        r2 = r5.toString();	 Catch:{ SQLException -> 0x00a6 }
        r11.execSQL(r2);	 Catch:{ SQLException -> 0x00a6 }
    L_0x0092:
        r2 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x00a6 }
        r2.<init>();	 Catch:{ SQLException -> 0x00a6 }
        r3 = "DROP TABLE ";	 Catch:{ SQLException -> 0x00a6 }
        r2.append(r3);	 Catch:{ SQLException -> 0x00a6 }
        r2.append(r4);	 Catch:{ SQLException -> 0x00a6 }
        r2 = r2.toString();	 Catch:{ SQLException -> 0x00a6 }
        r11.execSQL(r2);	 Catch:{ SQLException -> 0x00a6 }
    L_0x00a6:
        r1 = r1 + 1;
        goto L_0x0002;
    L_0x00aa:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.database.b.c.b(org.greenrobot.greendao.database.Database, java.lang.Class[]):void");
    }

    private static List<String> a(Database database, String str) {
        Cursor cursor = null;
        try {
            List<String> asList;
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ");
            stringBuilder.append(str);
            stringBuilder.append(" limit 0");
            database = database.rawQuery(stringBuilder.toString(), null);
            if (database != null) {
                try {
                    if (database.getColumnCount() > null) {
                        asList = Arrays.asList(database.getColumnNames());
                    }
                } catch (Exception e) {
                    str = e;
                    cursor = database;
                    try {
                        str.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return new ArrayList();
                    } catch (Throwable th) {
                        str = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        database = new ArrayList();
                        throw str;
                    }
                } catch (Throwable th2) {
                    str = th2;
                    cursor = database;
                    if (cursor != null) {
                        cursor.close();
                    }
                    database = new ArrayList();
                    throw str;
                }
            }
            if (database != null) {
                database.close();
            }
            return asList == null ? new ArrayList() : asList;
        } catch (Exception e2) {
            str = e2;
            str.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            return new ArrayList();
        }
    }

    public static void a(org.greenrobot.greendao.database.Database r7, java.lang.Class<? extends org.greenrobot.greendao.AbstractDao<?, ?>>... r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r0;
    L_0x0002:
        r2 = r8.length;
        if (r1 >= r2) goto L_0x006f;
    L_0x0005:
        r2 = new org.greenrobot.greendao.internal.DaoConfig;
        r3 = r8[r1];
        r2.<init>(r7, r3);
        r3 = r2.tablename;
        r4 = a(r7, r0, r3);
        if (r4 == 0) goto L_0x006c;
    L_0x0014:
        r4 = r2.tablename;	 Catch:{ SQLException -> 0x006c }
        r5 = "_TEMP";	 Catch:{ SQLException -> 0x006c }
        r4 = r4.concat(r5);	 Catch:{ SQLException -> 0x006c }
        r5 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x006c }
        r5.<init>();	 Catch:{ SQLException -> 0x006c }
        r6 = "DROP TABLE IF EXISTS ";	 Catch:{ SQLException -> 0x006c }
        r5.append(r6);	 Catch:{ SQLException -> 0x006c }
        r5.append(r4);	 Catch:{ SQLException -> 0x006c }
        r6 = ";";	 Catch:{ SQLException -> 0x006c }
        r5.append(r6);	 Catch:{ SQLException -> 0x006c }
        r5 = r5.toString();	 Catch:{ SQLException -> 0x006c }
        r7.execSQL(r5);	 Catch:{ SQLException -> 0x006c }
        r5 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x006c }
        r5.<init>();	 Catch:{ SQLException -> 0x006c }
        r6 = "CREATE TEMPORARY TABLE ";	 Catch:{ SQLException -> 0x006c }
        r5.append(r6);	 Catch:{ SQLException -> 0x006c }
        r5.append(r4);	 Catch:{ SQLException -> 0x006c }
        r4 = " AS SELECT * FROM ";	 Catch:{ SQLException -> 0x006c }
        r5.append(r4);	 Catch:{ SQLException -> 0x006c }
        r5.append(r3);	 Catch:{ SQLException -> 0x006c }
        r4 = ";";	 Catch:{ SQLException -> 0x006c }
        r5.append(r4);	 Catch:{ SQLException -> 0x006c }
        r4 = r5.toString();	 Catch:{ SQLException -> 0x006c }
        r7.execSQL(r4);	 Catch:{ SQLException -> 0x006c }
        r4 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x006c }
        r5 = "【Table】";	 Catch:{ SQLException -> 0x006c }
        r4.<init>(r5);	 Catch:{ SQLException -> 0x006c }
        r4.append(r3);	 Catch:{ SQLException -> 0x006c }
        r3 = "\n ---Columns-->";	 Catch:{ SQLException -> 0x006c }
        r4.append(r3);	 Catch:{ SQLException -> 0x006c }
        r2 = a(r2);	 Catch:{ SQLException -> 0x006c }
        r4.append(r2);	 Catch:{ SQLException -> 0x006c }
    L_0x006c:
        r1 = r1 + 1;
        goto L_0x0002;
    L_0x006f:
        r1 = 0;
        r2 = c;
        if (r2 == 0) goto L_0x007c;
    L_0x0074:
        r1 = c;
        r1 = r1.get();
        r1 = (com.xunlei.downloadprovider.database.b.c.a) r1;
    L_0x007c:
        if (r1 != 0) goto L_0x0089;
    L_0x007e:
        r1 = "dropTable";
        r2 = 1;
        a(r7, r1, r2, r8);
        r1 = "createTable";
        a(r7, r1, r0, r8);
    L_0x0089:
        b(r7, r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.database.b.c.a(org.greenrobot.greendao.database.Database, java.lang.Class[]):void");
    }
}
