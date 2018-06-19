package org.android.agoo.message;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import com.xunlei.downloadprovider.ad.home.a.f;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class MessageService {
    public static final String MSG_ACCS_NOTIFY_CLICK = "8";
    public static final String MSG_ACCS_NOTIFY_DISMISS = "9";
    public static final String MSG_ACCS_READY_REPORT = "4";
    public static final String MSG_DB_COMPLETE = "100";
    public static final String MSG_DB_NOTIFY_CLICK = "2";
    public static final String MSG_DB_NOTIFY_DISMISS = "3";
    public static final String MSG_DB_NOTIFY_REACHED = "1";
    public static final String MSG_DB_READY_REPORT = "0";
    private static Context a;
    private static Map<String, Integer> c;
    private volatile SQLiteOpenHelper b = null;

    public void a(Context context) {
        c = new HashMap();
        a = context;
        this.b = new a(context);
    }

    public void a(String str, String str2) {
        if (ALog.isPrintLog(Level.I)) {
            StringBuilder stringBuilder = new StringBuilder("updateAccsMessage sqlite3--->[");
            stringBuilder.append(str);
            stringBuilder.append(",state=");
            stringBuilder.append(str2);
            stringBuilder.append("]");
            ALog.i("MessageService", stringBuilder.toString(), new Object[0]);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                    if (writableDatabase == null) {
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        return;
                    }
                    try {
                        if (TextUtils.equals(str2, "1")) {
                            writableDatabase.execSQL("UPDATE accs_message set state = ? where id = ? and state = ?", new Object[]{str2, str, "0"});
                        } else {
                            writableDatabase.execSQL("UPDATE accs_message set state = ? where id = ?", new Object[]{str2, str});
                        }
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                    } catch (Throwable th) {
                        str = th;
                        sQLiteDatabase = writableDatabase;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw str;
                    }
                }
            }
        } catch (Throwable th2) {
            str = th2;
            if (ALog.isPrintLog(Level.E) != null) {
                stringBuilder = new StringBuilder("updateAccsMessage error,e--->[");
                stringBuilder.append(str);
                stringBuilder.append("],ex=");
                stringBuilder.append(str.getStackTrace().toString());
                ALog.e("MessageService", stringBuilder.toString(), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", a.b(a), "updateAccsMessageFailed", str.toString());
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        }
    }

    public void a(String str, String str2, String str3) {
        Throwable th;
        if (ALog.isPrintLog(Level.I)) {
            StringBuilder stringBuilder = new StringBuilder("addAccsMessage sqlite3--->[");
            stringBuilder.append(str);
            stringBuilder.append(",message=");
            stringBuilder.append(str2);
            stringBuilder.append(",state=");
            stringBuilder.append(str3);
            stringBuilder.append("]");
            ALog.i("MessageService", stringBuilder.toString(), new Object[0]);
        }
        Cursor cursor = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                    if (writableDatabase != null) {
                        Cursor rawQuery = writableDatabase.rawQuery("select count(1) from accs_message where id = ?", new String[]{str});
                        if (rawQuery != null) {
                            try {
                                if (rawQuery.moveToFirst() && rawQuery.getInt(0) > 0) {
                                    rawQuery.close();
                                    if (rawQuery != null) {
                                        rawQuery.close();
                                    }
                                    return;
                                }
                            } catch (Throwable th2) {
                                str = th2;
                                cursor = rawQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw str;
                            }
                        }
                        writableDatabase.execSQL("INSERT INTO accs_message VALUES(?,?,?,date('now'))", new Object[]{str, str3, str2});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            if (ALog.isPrintLog(Level.E) != null) {
                str3 = new StringBuilder("addAccsMessage error,e--->[");
                str3.append(th);
                str3.append("],ex=");
                str3.append(a(th));
                ALog.e("MessageService", str3.toString(), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", a.b(a), "addAccsMessageFailed", th.toString());
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private String a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        th = th.getStackTrace();
        if (th != null && th.length > 0) {
            for (StackTraceElement stackTraceElement : th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(stackTraceElement.toString());
                stringBuilder.append("\n");
                stringBuffer.append(stringBuilder.toString());
            }
        }
        return stringBuffer.toString();
    }

    public void a(String str, String str2, String str3, int i) {
        a(str, str2, str3, 1, -1, -1, i);
    }

    private void a(String str, String str2, String str3, int i, long j, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder("add sqlite3--->[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        ALog.d("MessageService", stringBuilder.toString(), new Object[0]);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            int i4;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
                i4 = -1;
            } else {
                i4 = str2.hashCode();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            if (!c.containsKey(str)) {
                c.put(str, Integer.valueOf(i4));
                if (ALog.isPrintLog(Level.I)) {
                    StringBuilder stringBuilder2 = new StringBuilder("addMessage,messageId=");
                    stringBuilder2.append(str);
                    stringBuilder2.append(",messageStores＝");
                    stringBuilder2.append(c.toString());
                    ALog.i("MessageService", stringBuilder2.toString(), new Object[0]);
                }
            }
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                    } catch (String str4) {
                        if (ALog.isPrintLog(Level.E) != null) {
                            str3 = new StringBuilder("addMessage,db.close(),error,e--->[");
                            str3.append(str4);
                            str3.append("]");
                            ALog.e("MessageService", str3.toString(), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", a.b(a), "addMessageDBcloseFailed", str4.toString());
                    }
                }
                return;
            }
            try {
                writableDatabase.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[]{str4, Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(0), Long.valueOf(j), Integer.valueOf(i2), str3, str2, Integer.valueOf(i3)});
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                    } catch (Throwable th) {
                        str4 = th;
                        if (ALog.isPrintLog(Level.E) != null) {
                            str2 = "MessageService";
                            str3 = new StringBuilder("addMessage,db.close(),error,e--->[");
                            str3.append(str4);
                            str3.append("]");
                            ALog.e(str2, str3.toString(), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", a.b(a), "addMessageDBcloseFailed", str4.toString());
                    }
                }
            } catch (Throwable th2) {
                str4 = th2;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw str4;
            }
        } catch (Throwable th3) {
            str4 = th3;
            if (ALog.isPrintLog(Level.E) != null) {
                str3 = new StringBuilder("addMessage error,e--->[");
                str3.append(str4);
                str3.append("]");
                ALog.e("MessageService", str3.toString(), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.add_agoo_message", a.b(a), "addMessageFailed", str4.toString());
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        }
    }

    public void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.b;	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x0029, all -> 0x0024 }
        if (r1 != 0) goto L_0x0010;
    L_0x0009:
        if (r1 == 0) goto L_0x000f;
    L_0x000b:
        r1.close();	 Catch:{ Throwable -> 0x000f }
    L_0x000f:
        return;
    L_0x0010:
        r0 = "delete from message where create_time< date('now','-7 day') and state=1";	 Catch:{ Throwable -> 0x0022 }
        r1.execSQL(r0);	 Catch:{ Throwable -> 0x0022 }
        r0 = "delete from accs_message where create_time< date('now','-1 day') ";	 Catch:{ Throwable -> 0x0022 }
        r1.execSQL(r0);	 Catch:{ Throwable -> 0x0022 }
        if (r1 == 0) goto L_0x0021;
    L_0x001c:
        r1.close();	 Catch:{ Throwable -> 0x0020 }
        goto L_0x0021;
    L_0x0020:
        return;
    L_0x0021:
        return;
    L_0x0022:
        r0 = move-exception;
        goto L_0x002d;
    L_0x0024:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x0040;
    L_0x0029:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x002d:
        r2 = "MessageService";	 Catch:{ all -> 0x003f }
        r3 = "deleteCacheMessage sql Throwable";	 Catch:{ all -> 0x003f }
        r4 = 0;	 Catch:{ all -> 0x003f }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x003f }
        com.taobao.accs.utl.ALog.e(r2, r3, r0, r4);	 Catch:{ all -> 0x003f }
        if (r1 == 0) goto L_0x003e;
    L_0x0039:
        r1.close();	 Catch:{ Throwable -> 0x003d }
        goto L_0x003e;
    L_0x003d:
        return;
    L_0x003e:
        return;
    L_0x003f:
        r0 = move-exception;
    L_0x0040:
        if (r1 == 0) goto L_0x0045;
    L_0x0042:
        r1.close();	 Catch:{ Throwable -> 0x0045 }
    L_0x0045:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<org.android.agoo.common.MsgDO> b() {
        /*
        r15 = this;
        r0 = 0;
        r1 = 0;
        r2 = r15.b;	 Catch:{ Throwable -> 0x013d, all -> 0x0138 }
        r2 = r2.getReadableDatabase();	 Catch:{ Throwable -> 0x013d, all -> 0x0138 }
        if (r2 != 0) goto L_0x002f;
    L_0x000a:
        if (r2 == 0) goto L_0x002e;
    L_0x000c:
        r2.close();	 Catch:{ Throwable -> 0x0010 }
        goto L_0x002e;
    L_0x0010:
        r2 = move-exception;
        r3 = com.taobao.accs.utl.ALog.Level.E;
        r3 = com.taobao.accs.utl.ALog.isPrintLog(r3);
        if (r3 == 0) goto L_0x002e;
    L_0x0019:
        r3 = "MessageService";
        r4 = new java.lang.StringBuilder;
        r5 = "getUnReportMsg close cursor or db, e: ";
        r4.<init>(r5);
        r4.append(r2);
        r2 = r4.toString();
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r3, r2, r1);
    L_0x002e:
        return r0;
    L_0x002f:
        r3 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0133, all -> 0x012f }
        r3.<init>();	 Catch:{ Throwable -> 0x0133, all -> 0x012f }
        r4 = "select * from accs_message where state = ? or state = ? or state = ?";
        r5 = 3;
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x012a, all -> 0x012f }
        r6 = "0";
        r5[r1] = r6;	 Catch:{ Throwable -> 0x012a, all -> 0x012f }
        r6 = 1;
        r7 = "2";
        r5[r6] = r7;	 Catch:{ Throwable -> 0x012a, all -> 0x012f }
        r6 = 2;
        r7 = "3";
        r5[r6] = r7;	 Catch:{ Throwable -> 0x012a, all -> 0x012f }
        r4 = r2.rawQuery(r4, r5);	 Catch:{ Throwable -> 0x012a, all -> 0x012f }
        if (r4 == 0) goto L_0x00fc;
    L_0x004d:
        r5 = "id";
        r5 = r4.getColumnIndex(r5);	 Catch:{ Throwable -> 0x00fa }
        r6 = "state";
        r6 = r4.getColumnIndex(r6);	 Catch:{ Throwable -> 0x00fa }
        r7 = "message";
        r7 = r4.getColumnIndex(r7);	 Catch:{ Throwable -> 0x00fa }
        r8 = "create_time";
        r8 = r4.getColumnIndex(r8);	 Catch:{ Throwable -> 0x00fa }
    L_0x0065:
        r9 = r4.moveToNext();	 Catch:{ Throwable -> 0x00fa }
        if (r9 == 0) goto L_0x00fc;
    L_0x006b:
        r9 = r4.getString(r7);	 Catch:{ Throwable -> 0x00fa }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x00fa }
        if (r9 != 0) goto L_0x00fc;
    L_0x0075:
        r9 = r4.getString(r6);	 Catch:{ Throwable -> 0x00fa }
        r10 = r4.getString(r7);	 Catch:{ Throwable -> 0x00fa }
        r11 = com.taobao.accs.utl.ALog.Level.I;	 Catch:{ Throwable -> 0x00fa }
        r11 = com.taobao.accs.utl.ALog.isPrintLog(r11);	 Catch:{ Throwable -> 0x00fa }
        if (r11 == 0) goto L_0x00ba;
    L_0x0085:
        r11 = "MessageService";
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fa }
        r13 = "state: ";
        r12.<init>(r13);	 Catch:{ Throwable -> 0x00fa }
        r12.append(r9);	 Catch:{ Throwable -> 0x00fa }
        r13 = " ,cursor.message:";
        r12.append(r13);	 Catch:{ Throwable -> 0x00fa }
        r12.append(r10);	 Catch:{ Throwable -> 0x00fa }
        r13 = " ,cursor.id:";
        r12.append(r13);	 Catch:{ Throwable -> 0x00fa }
        r13 = r4.getString(r5);	 Catch:{ Throwable -> 0x00fa }
        r12.append(r13);	 Catch:{ Throwable -> 0x00fa }
        r13 = " ,cursor.time:";
        r12.append(r13);	 Catch:{ Throwable -> 0x00fa }
        r13 = r4.getString(r8);	 Catch:{ Throwable -> 0x00fa }
        r12.append(r13);	 Catch:{ Throwable -> 0x00fa }
        r12 = r12.toString();	 Catch:{ Throwable -> 0x00fa }
        r13 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00fa }
        com.taobao.accs.utl.ALog.i(r11, r12, r13);	 Catch:{ Throwable -> 0x00fa }
    L_0x00ba:
        r11 = "0";
        r11 = android.text.TextUtils.equals(r11, r9);	 Catch:{ Throwable -> 0x00fa }
        if (r11 == 0) goto L_0x00c5;
    L_0x00c2:
        r9 = "4";
        goto L_0x00dc;
    L_0x00c5:
        r11 = "2";
        r11 = android.text.TextUtils.equals(r11, r9);	 Catch:{ Throwable -> 0x00fa }
        if (r11 == 0) goto L_0x00d0;
    L_0x00cd:
        r9 = "8";
        goto L_0x00dc;
    L_0x00d0:
        r11 = "3";
        r9 = android.text.TextUtils.equals(r11, r9);	 Catch:{ Throwable -> 0x00fa }
        if (r9 == 0) goto L_0x00db;
    L_0x00d8:
        r9 = "9";
        goto L_0x00dc;
    L_0x00db:
        r9 = r0;
    L_0x00dc:
        r11 = new org.android.agoo.common.MsgDO;	 Catch:{ Throwable -> 0x00fa }
        r11.<init>();	 Catch:{ Throwable -> 0x00fa }
        r11 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x00fa }
        if (r11 != 0) goto L_0x0065;
    L_0x00e7:
        r11 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x00fa }
        if (r11 != 0) goto L_0x0065;
    L_0x00ed:
        r9 = r15.b(r10, r9);	 Catch:{ Throwable -> 0x00fa }
        r10 = "cache";
        r9.messageSource = r10;	 Catch:{ Throwable -> 0x00fa }
        r3.add(r9);	 Catch:{ Throwable -> 0x00fa }
        goto L_0x0065;
    L_0x00fa:
        r0 = move-exception;
        goto L_0x0142;
    L_0x00fc:
        if (r4 == 0) goto L_0x0104;
    L_0x00fe:
        r4.close();	 Catch:{ Throwable -> 0x0102 }
        goto L_0x0104;
    L_0x0102:
        r0 = move-exception;
        goto L_0x010b;
    L_0x0104:
        if (r2 == 0) goto L_0x017f;
    L_0x0106:
        r2.close();	 Catch:{ Throwable -> 0x0102 }
        goto L_0x017f;
    L_0x010b:
        r2 = com.taobao.accs.utl.ALog.Level.E;
        r2 = com.taobao.accs.utl.ALog.isPrintLog(r2);
        if (r2 == 0) goto L_0x017f;
    L_0x0113:
        r2 = "MessageService";
        r4 = new java.lang.StringBuilder;
        r5 = "getUnReportMsg close cursor or db, e: ";
        r4.<init>(r5);
    L_0x011c:
        r4.append(r0);
        r0 = r4.toString();
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r2, r0, r1);
        goto L_0x017f;
    L_0x012a:
        r4 = move-exception;
        r14 = r4;
        r4 = r0;
        r0 = r14;
        goto L_0x0142;
    L_0x012f:
        r3 = move-exception;
        r4 = r0;
        r0 = r3;
        goto L_0x0181;
    L_0x0133:
        r3 = move-exception;
        r4 = r0;
        r0 = r3;
        r3 = r4;
        goto L_0x0142;
    L_0x0138:
        r2 = move-exception;
        r4 = r0;
        r0 = r2;
        r2 = r4;
        goto L_0x0181;
    L_0x013d:
        r2 = move-exception;
        r3 = r0;
        r4 = r3;
        r0 = r2;
        r2 = r4;
    L_0x0142:
        r5 = com.taobao.accs.utl.ALog.Level.E;	 Catch:{ all -> 0x0180 }
        r5 = com.taobao.accs.utl.ALog.isPrintLog(r5);	 Catch:{ all -> 0x0180 }
        if (r5 == 0) goto L_0x015f;
    L_0x014a:
        r5 = "MessageService";
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0180 }
        r7 = "getUnReportMsg, e: ";
        r6.<init>(r7);	 Catch:{ all -> 0x0180 }
        r6.append(r0);	 Catch:{ all -> 0x0180 }
        r0 = r6.toString();	 Catch:{ all -> 0x0180 }
        r6 = new java.lang.Object[r1];	 Catch:{ all -> 0x0180 }
        com.taobao.accs.utl.ALog.e(r5, r0, r6);	 Catch:{ all -> 0x0180 }
    L_0x015f:
        if (r4 == 0) goto L_0x0167;
    L_0x0161:
        r4.close();	 Catch:{ Throwable -> 0x0165 }
        goto L_0x0167;
    L_0x0165:
        r0 = move-exception;
        goto L_0x016d;
    L_0x0167:
        if (r2 == 0) goto L_0x017f;
    L_0x0169:
        r2.close();	 Catch:{ Throwable -> 0x0165 }
        goto L_0x017f;
    L_0x016d:
        r2 = com.taobao.accs.utl.ALog.Level.E;
        r2 = com.taobao.accs.utl.ALog.isPrintLog(r2);
        if (r2 == 0) goto L_0x017f;
    L_0x0175:
        r2 = "MessageService";
        r4 = new java.lang.StringBuilder;
        r5 = "getUnReportMsg close cursor or db, e: ";
        r4.<init>(r5);
        goto L_0x011c;
    L_0x017f:
        return r3;
    L_0x0180:
        r0 = move-exception;
    L_0x0181:
        if (r4 == 0) goto L_0x0189;
    L_0x0183:
        r4.close();	 Catch:{ Throwable -> 0x0187 }
        goto L_0x0189;
    L_0x0187:
        r2 = move-exception;
        goto L_0x018f;
    L_0x0189:
        if (r2 == 0) goto L_0x01ac;
    L_0x018b:
        r2.close();	 Catch:{ Throwable -> 0x0187 }
        goto L_0x01ac;
    L_0x018f:
        r3 = com.taobao.accs.utl.ALog.Level.E;
        r3 = com.taobao.accs.utl.ALog.isPrintLog(r3);
        if (r3 == 0) goto L_0x01ac;
    L_0x0197:
        r3 = "MessageService";
        r4 = new java.lang.StringBuilder;
        r5 = "getUnReportMsg close cursor or db, e: ";
        r4.<init>(r5);
        r4.append(r2);
        r2 = r4.toString();
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r3, r2, r1);
    L_0x01ac:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.b():java.util.ArrayList<org.android.agoo.common.MsgDO>");
    }

    public boolean a(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = 0;
        r1 = 0;
        r2 = c;	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r2 = r2.containsKey(r9);	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r3 = 1;	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        if (r2 == 0) goto L_0x002a;	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
    L_0x000b:
        r2 = com.taobao.accs.utl.ALog.Level.E;	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r2 = com.taobao.accs.utl.ALog.isPrintLog(r2);	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        if (r2 == 0) goto L_0x0028;	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
    L_0x0013:
        r2 = "MessageService";	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r5 = "hasMessageDuplicate,msgid=";	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r4.append(r9);	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        r5 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
        com.taobao.accs.utl.ALog.e(r2, r4, r5);	 Catch:{ Throwable -> 0x0076, all -> 0x0069 }
    L_0x0028:
        r2 = r3;
        goto L_0x002b;
    L_0x002a:
        r2 = r1;
    L_0x002b:
        r4 = r8.b;	 Catch:{ Throwable -> 0x0067, all -> 0x0069 }
        r4 = r4.getReadableDatabase();	 Catch:{ Throwable -> 0x0067, all -> 0x0069 }
        if (r4 != 0) goto L_0x0039;
    L_0x0033:
        if (r4 == 0) goto L_0x0038;
    L_0x0035:
        r4.close();	 Catch:{ Throwable -> 0x0038 }
    L_0x0038:
        return r2;
    L_0x0039:
        r5 = "select count(1) from message where id = ?";	 Catch:{ Throwable -> 0x0078, all -> 0x0065 }
        r6 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x0078, all -> 0x0065 }
        r6[r1] = r9;	 Catch:{ Throwable -> 0x0078, all -> 0x0065 }
        r9 = r4.rawQuery(r5, r6);	 Catch:{ Throwable -> 0x0078, all -> 0x0065 }
        if (r9 == 0) goto L_0x005a;
    L_0x0045:
        r0 = r9.moveToFirst();	 Catch:{ Throwable -> 0x0058, all -> 0x0053 }
        if (r0 == 0) goto L_0x005a;	 Catch:{ Throwable -> 0x0058, all -> 0x0053 }
    L_0x004b:
        r0 = r9.getInt(r1);	 Catch:{ Throwable -> 0x0058, all -> 0x0053 }
        if (r0 <= 0) goto L_0x005a;
    L_0x0051:
        r2 = r3;
        goto L_0x005a;
    L_0x0053:
        r0 = move-exception;
        r7 = r0;
        r0 = r9;
        r9 = r7;
        goto L_0x006b;
    L_0x0058:
        r0 = r9;
        goto L_0x0078;
    L_0x005a:
        if (r9 == 0) goto L_0x005f;
    L_0x005c:
        r9.close();	 Catch:{ Throwable -> 0x0080 }
    L_0x005f:
        if (r4 == 0) goto L_0x0080;	 Catch:{ Throwable -> 0x0080 }
    L_0x0061:
        r4.close();	 Catch:{ Throwable -> 0x0080 }
        goto L_0x0080;
    L_0x0065:
        r9 = move-exception;
        goto L_0x006b;
    L_0x0067:
        r4 = r0;
        goto L_0x0078;
    L_0x0069:
        r9 = move-exception;
        r4 = r0;
    L_0x006b:
        if (r0 == 0) goto L_0x0070;
    L_0x006d:
        r0.close();	 Catch:{ Throwable -> 0x0075 }
    L_0x0070:
        if (r4 == 0) goto L_0x0075;	 Catch:{ Throwable -> 0x0075 }
    L_0x0072:
        r4.close();	 Catch:{ Throwable -> 0x0075 }
    L_0x0075:
        throw r9;
    L_0x0076:
        r4 = r0;
        r2 = r1;
    L_0x0078:
        if (r0 == 0) goto L_0x007d;
    L_0x007a:
        r0.close();	 Catch:{ Throwable -> 0x0080 }
    L_0x007d:
        if (r4 == 0) goto L_0x0080;
    L_0x007f:
        goto L_0x0061;
    L_0x0080:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String):boolean");
    }

    public boolean a(java.lang.String r8, int r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = 0;
        r2 = c;	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r2 = r2.containsKey(r8);	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r3 = 1;	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        if (r2 == 0) goto L_0x0036;	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
    L_0x000b:
        r2 = c;	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r4 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r2 = r2.containsValue(r4);	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        if (r2 == 0) goto L_0x0036;	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
    L_0x0017:
        r2 = com.taobao.accs.utl.ALog.Level.I;	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r2 = com.taobao.accs.utl.ALog.isPrintLog(r2);	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        if (r2 == 0) goto L_0x0034;	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
    L_0x001f:
        r2 = "MessageService";	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r5 = "addMessage,messageStores hasMessageDuplicate,msgid=";	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r4.append(r8);	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        r5 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
        com.taobao.accs.utl.ALog.i(r2, r4, r5);	 Catch:{ Throwable -> 0x0088, all -> 0x007b }
    L_0x0034:
        r2 = r3;
        goto L_0x0037;
    L_0x0036:
        r2 = r1;
    L_0x0037:
        r4 = r7.b;	 Catch:{ Throwable -> 0x0079, all -> 0x007b }
        r4 = r4.getReadableDatabase();	 Catch:{ Throwable -> 0x0079, all -> 0x007b }
        if (r4 != 0) goto L_0x0045;
    L_0x003f:
        if (r4 == 0) goto L_0x0044;
    L_0x0041:
        r4.close();	 Catch:{ Throwable -> 0x0044 }
    L_0x0044:
        return r2;
    L_0x0045:
        r5 = "select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')";	 Catch:{ Throwable -> 0x008a, all -> 0x0077 }
        r6 = 2;	 Catch:{ Throwable -> 0x008a, all -> 0x0077 }
        r6 = new java.lang.String[r6];	 Catch:{ Throwable -> 0x008a, all -> 0x0077 }
        r6[r1] = r8;	 Catch:{ Throwable -> 0x008a, all -> 0x0077 }
        r8 = java.lang.String.valueOf(r9);	 Catch:{ Throwable -> 0x008a, all -> 0x0077 }
        r6[r3] = r8;	 Catch:{ Throwable -> 0x008a, all -> 0x0077 }
        r8 = r4.rawQuery(r5, r6);	 Catch:{ Throwable -> 0x008a, all -> 0x0077 }
        if (r8 == 0) goto L_0x006c;
    L_0x0058:
        r9 = r8.moveToFirst();	 Catch:{ Throwable -> 0x006a, all -> 0x0066 }
        if (r9 == 0) goto L_0x006c;	 Catch:{ Throwable -> 0x006a, all -> 0x0066 }
    L_0x005e:
        r9 = r8.getInt(r1);	 Catch:{ Throwable -> 0x006a, all -> 0x0066 }
        if (r9 <= 0) goto L_0x006c;
    L_0x0064:
        r2 = r3;
        goto L_0x006c;
    L_0x0066:
        r9 = move-exception;
        r0 = r8;
        r8 = r9;
        goto L_0x007d;
    L_0x006a:
        r0 = r8;
        goto L_0x008a;
    L_0x006c:
        if (r8 == 0) goto L_0x0071;
    L_0x006e:
        r8.close();	 Catch:{ Throwable -> 0x0092 }
    L_0x0071:
        if (r4 == 0) goto L_0x0092;	 Catch:{ Throwable -> 0x0092 }
    L_0x0073:
        r4.close();	 Catch:{ Throwable -> 0x0092 }
        goto L_0x0092;
    L_0x0077:
        r8 = move-exception;
        goto L_0x007d;
    L_0x0079:
        r4 = r0;
        goto L_0x008a;
    L_0x007b:
        r8 = move-exception;
        r4 = r0;
    L_0x007d:
        if (r0 == 0) goto L_0x0082;
    L_0x007f:
        r0.close();	 Catch:{ Throwable -> 0x0087 }
    L_0x0082:
        if (r4 == 0) goto L_0x0087;	 Catch:{ Throwable -> 0x0087 }
    L_0x0084:
        r4.close();	 Catch:{ Throwable -> 0x0087 }
    L_0x0087:
        throw r8;
    L_0x0088:
        r4 = r0;
        r2 = r1;
    L_0x008a:
        if (r0 == 0) goto L_0x008f;
    L_0x008c:
        r0.close();	 Catch:{ Throwable -> 0x0092 }
    L_0x008f:
        if (r4 == 0) goto L_0x0092;
    L_0x0091:
        goto L_0x0073;
    L_0x0092:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(java.lang.String, int):boolean");
    }

    public MsgDO b(String str, String str2) {
        String str3 = str;
        if (ALog.isPrintLog(Level.I)) {
            StringBuilder stringBuilder = new StringBuilder("msgRecevie,message--->[");
            stringBuilder.append(str3);
            stringBuilder.append("],utdid=");
            stringBuilder.append(a.b(a));
            ALog.i("MessageService", stringBuilder.toString(), new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", a.b(a), "message==null");
            if (ALog.isPrintLog(Level.I)) {
                StringBuilder stringBuilder2 = new StringBuilder("handleMessage message==null,utdid=");
                stringBuilder2.append(a.b(a));
                ALog.i("MessageService", stringBuilder2.toString(), new Object[0]);
            }
            return null;
        }
        MsgDO msgDO = new MsgDO();
        try {
            JSONArray jSONArray = new JSONArray(str3);
            int length = jSONArray.length();
            Bundle bundle = new Bundle();
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder stringBuilder4 = new StringBuilder();
            StringBuilder stringBuilder5 = new StringBuilder();
            String str4 = null;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String string = jSONObject.getString("p");
                    String string2 = jSONObject.getString("i");
                    CharSequence string3 = jSONObject.getString(b.a);
                    long j = jSONObject.getLong(f.a);
                    stringBuilder3.append(string2);
                    if (!jSONObject.isNull(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND)) {
                        str4 = jSONObject.getString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
                    }
                    int i2 = length - 1;
                    if (i < i2) {
                        stringBuilder3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    msgDO.msgIds = string2;
                    msgDO.extData = str4;
                    msgDO.messageSource = "accs";
                    msgDO.type = "cache";
                    if (TextUtils.isEmpty(string3)) {
                        msgDO.errorCode = "11";
                    } else if (TextUtils.isEmpty(string)) {
                        msgDO.errorCode = "12";
                    } else if (j == -1) {
                        msgDO.errorCode = "13";
                    } else if (a(a, string)) {
                        boolean z;
                        Object string4 = a(j, msgDO).getString(AgooConstants.MESSAGE_ENCRYPTED);
                        if (!a.getPackageName().equals(string)) {
                            z = true;
                        } else if (TextUtils.equals(Integer.toString(0), string4) || TextUtils.equals(Integer.toString(4), string4)) {
                            z = false;
                        } else {
                            msgDO.errorCode = "15";
                            StringBuilder stringBuilder6 = new StringBuilder("error encrypted: ");
                            stringBuilder6.append(string4);
                            ALog.e("MessageService", stringBuilder6.toString(), new Object[0]);
                        }
                        msgDO.agooFlag = z;
                        if (!TextUtils.isEmpty(str2)) {
                            msgDO.msgStatus = str2;
                        }
                    } else {
                        StringBuilder stringBuilder7 = new StringBuilder("ondata checkpackage is del,pack=");
                        stringBuilder7.append(string);
                        ALog.d("MessageService", stringBuilder7.toString(), new Object[0]);
                        String str5 = string2;
                        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.dealMessage", a.b(a), "deletePack", string);
                        stringBuilder5.append(string);
                        stringBuilder4.append(str5);
                        msgDO.removePacks = string;
                        if (i < i2) {
                            stringBuilder5.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            stringBuilder4.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                }
                String str6 = str2;
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (ALog.isPrintLog(Level.E)) {
                stringBuilder = new StringBuilder("createMsg is error,e: ");
                stringBuilder.append(th2);
                ALog.e("MessageService", stringBuilder.toString(), new Object[0]);
            }
        }
        return msgDO;
    }

    public static final boolean a(android.content.Context r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x000d }
        r1 = r1.getApplicationInfo(r2, r0);	 Catch:{ Throwable -> 0x000d }
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        r1 = 1;
        return r1;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(android.content.Context, java.lang.String):boolean");
    }

    private static android.os.Bundle a(long r8, org.android.agoo.common.MsgDO r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.os.Bundle;
        r0.<init>();
        r8 = java.lang.Long.toBinaryString(r8);	 Catch:{ Throwable -> 0x0099 }
        r8 = r8.toCharArray();	 Catch:{ Throwable -> 0x0099 }
        if (r8 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x0099 }
    L_0x000f:
        r9 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        r1 = 8;	 Catch:{ Throwable -> 0x0099 }
        if (r1 > r9) goto L_0x0099;	 Catch:{ Throwable -> 0x0099 }
    L_0x0014:
        r9 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        r2 = 1;	 Catch:{ Throwable -> 0x0099 }
        r3 = 49;	 Catch:{ Throwable -> 0x0099 }
        if (r1 > r9) goto L_0x006b;	 Catch:{ Throwable -> 0x0099 }
    L_0x001a:
        r9 = "encrypted";	 Catch:{ Throwable -> 0x0099 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0099 }
        r4.<init>();	 Catch:{ Throwable -> 0x0099 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0099 }
        r5.<init>();	 Catch:{ Throwable -> 0x0099 }
        r6 = r8[r2];	 Catch:{ Throwable -> 0x0099 }
        r5.append(r6);	 Catch:{ Throwable -> 0x0099 }
        r6 = 2;	 Catch:{ Throwable -> 0x0099 }
        r7 = r8[r6];	 Catch:{ Throwable -> 0x0099 }
        r5.append(r7);	 Catch:{ Throwable -> 0x0099 }
        r7 = 3;	 Catch:{ Throwable -> 0x0099 }
        r7 = r8[r7];	 Catch:{ Throwable -> 0x0099 }
        r5.append(r7);	 Catch:{ Throwable -> 0x0099 }
        r7 = 4;	 Catch:{ Throwable -> 0x0099 }
        r7 = r8[r7];	 Catch:{ Throwable -> 0x0099 }
        r5.append(r7);	 Catch:{ Throwable -> 0x0099 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0099 }
        r5 = java.lang.Integer.parseInt(r5, r6);	 Catch:{ Throwable -> 0x0099 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0099 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r4);	 Catch:{ Throwable -> 0x0099 }
        r9 = 6;	 Catch:{ Throwable -> 0x0099 }
        r9 = r8[r9];	 Catch:{ Throwable -> 0x0099 }
        if (r9 != r3) goto L_0x005f;	 Catch:{ Throwable -> 0x0099 }
    L_0x0054:
        r9 = "report";	 Catch:{ Throwable -> 0x0099 }
        r4 = "1";	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r4);	 Catch:{ Throwable -> 0x0099 }
        r9 = "1";	 Catch:{ Throwable -> 0x0099 }
        r10.reportStr = r9;	 Catch:{ Throwable -> 0x0099 }
    L_0x005f:
        r9 = 7;	 Catch:{ Throwable -> 0x0099 }
        r9 = r8[r9];	 Catch:{ Throwable -> 0x0099 }
        if (r9 != r3) goto L_0x006b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0064:
        r9 = "notify";	 Catch:{ Throwable -> 0x0099 }
        r10 = "1";	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r10);	 Catch:{ Throwable -> 0x0099 }
    L_0x006b:
        r9 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        r10 = 9;	 Catch:{ Throwable -> 0x0099 }
        if (r10 > r9) goto L_0x007b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0070:
        r9 = r8[r1];	 Catch:{ Throwable -> 0x0099 }
        if (r9 != r3) goto L_0x007b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0074:
        r9 = "has_test";	 Catch:{ Throwable -> 0x0099 }
        r1 = "1";	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r1);	 Catch:{ Throwable -> 0x0099 }
    L_0x007b:
        r9 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        r1 = 10;	 Catch:{ Throwable -> 0x0099 }
        if (r1 > r9) goto L_0x008b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0080:
        r9 = r8[r10];	 Catch:{ Throwable -> 0x0099 }
        if (r9 != r3) goto L_0x008b;	 Catch:{ Throwable -> 0x0099 }
    L_0x0084:
        r9 = "duplicate";	 Catch:{ Throwable -> 0x0099 }
        r10 = "1";	 Catch:{ Throwable -> 0x0099 }
        r0.putString(r9, r10);	 Catch:{ Throwable -> 0x0099 }
    L_0x008b:
        r9 = 11;	 Catch:{ Throwable -> 0x0099 }
        r10 = r8.length;	 Catch:{ Throwable -> 0x0099 }
        if (r9 > r10) goto L_0x0099;	 Catch:{ Throwable -> 0x0099 }
    L_0x0090:
        r8 = r8[r1];	 Catch:{ Throwable -> 0x0099 }
        if (r8 != r3) goto L_0x0099;	 Catch:{ Throwable -> 0x0099 }
    L_0x0094:
        r8 = "popup";	 Catch:{ Throwable -> 0x0099 }
        r0.putInt(r8, r2);	 Catch:{ Throwable -> 0x0099 }
    L_0x0099:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.message.MessageService.a(long, org.android.agoo.common.MsgDO):android.os.Bundle");
    }
}
