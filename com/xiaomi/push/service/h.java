package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.m;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.xmpush.thrift.j;
import com.xiaomi.xmpush.thrift.n;
import com.xiaomi.xmpush.thrift.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    private static volatile h b = null;
    private static String c = "GeoFenceDao.";
    private Context a;

    private h(Context context) {
        this.a = context;
    }

    private synchronized android.database.Cursor a(android.database.sqlite.SQLiteDatabase r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = 0;
        com.xiaomi.channel.commonutils.misc.m.a(r0);	 Catch:{ all -> 0x0017 }
        r2 = "geofence";	 Catch:{ Exception -> 0x0014 }
        r3 = 0;	 Catch:{ Exception -> 0x0014 }
        r4 = 0;	 Catch:{ Exception -> 0x0014 }
        r5 = 0;	 Catch:{ Exception -> 0x0014 }
        r6 = 0;	 Catch:{ Exception -> 0x0014 }
        r7 = 0;	 Catch:{ Exception -> 0x0014 }
        r8 = 0;	 Catch:{ Exception -> 0x0014 }
        r1 = r10;	 Catch:{ Exception -> 0x0014 }
        r10 = r1.query(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0014 }
        monitor-exit(r9);
        return r10;
    L_0x0014:
        r10 = 0;
        monitor-exit(r9);
        return r10;
    L_0x0017:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.h.a(android.database.sqlite.SQLiteDatabase):android.database.Cursor");
    }

    public static h a(Context context) {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h(context);
                }
            }
        }
        return b;
    }

    private synchronized n a(Cursor cursor) {
        try {
            for (n nVar : n.values()) {
                if (TextUtils.equals(cursor.getString(cursor.getColumnIndex("type")), nVar.name())) {
                    return nVar;
                }
            }
            return null;
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
    }

    private synchronized String a(List<o> list) {
        if (list != null) {
            if (list.size() >= 3) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (o oVar : list) {
                        if (oVar != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("point_lantitude", oVar.c());
                            jSONObject.put("point_longtitude", oVar.a());
                            jSONArray.put(jSONObject);
                        }
                    }
                    return jSONArray.toString();
                } catch (JSONException e) {
                    b.d(e.toString());
                    return null;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append(" points unvalidated");
        b.a(stringBuilder.toString());
        return null;
    }

    private synchronized o b(Cursor cursor) {
        o oVar;
        oVar = new o();
        try {
            oVar.b(Double.parseDouble(cursor.getString(cursor.getColumnIndex("center_lantitude"))));
            oVar.a(Double.parseDouble(cursor.getString(cursor.getColumnIndex("center_longtitude"))));
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
        return oVar;
    }

    private synchronized ArrayList<o> c(Cursor cursor) {
        ArrayList<o> arrayList;
        arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(cursor.getString(cursor.getColumnIndex("polygon_points")));
            for (int i = 0; i < jSONArray.length(); i++) {
                o oVar = new o();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                oVar.b(jSONObject.getDouble("point_lantitude"));
                oVar.a(jSONObject.getDouble("point_longtitude"));
                arrayList.add(oVar);
            }
        } catch (JSONException e) {
            b.d(e.toString());
            return null;
        }
        return arrayList;
    }

    private synchronized j d(Cursor cursor) {
        try {
        } catch (IllegalArgumentException e) {
            b.d(e.toString());
            return null;
        }
        return j.valueOf(cursor.getString(cursor.getColumnIndex("coordinate_provider")));
    }

    public synchronized int a(String str, String str2) {
        m.a(false);
        try {
            if (!"Enter".equals(str2) && !"Leave".equals(str2) && !"Unknown".equals(str2)) {
                return 0;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_status", str2);
            int update = i.a(this.a).a().update("geofence", contentValues, "id=?", new String[]{str});
            i.a(this.a).b();
            return update;
        } catch (Exception e) {
            b.d(e.toString());
            return 0;
        }
    }

    public synchronized long a(com.xiaomi.xmpush.thrift.m mVar) {
        long insert;
        m.a(false);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(AgooConstants.MESSAGE_ID, mVar.a());
            contentValues.put("appId", Long.valueOf(mVar.e()));
            contentValues.put(c.e, mVar.c());
            contentValues.put(Constants.PACKAGE_NAME, mVar.g());
            contentValues.put("create_time", Long.valueOf(mVar.i()));
            contentValues.put("type", mVar.k().name());
            contentValues.put("center_longtitude", String.valueOf(mVar.m().a()));
            contentValues.put("center_lantitude", String.valueOf(mVar.m().c()));
            contentValues.put("circle_radius", Double.valueOf(mVar.o()));
            contentValues.put("polygon_point", a(mVar.q()));
            contentValues.put("coordinate_provider", mVar.s().name());
            contentValues.put("current_status", "Unknown");
            insert = i.a(this.a).a().insert("geofence", null, contentValues);
            i.a(this.a).b();
        } catch (Exception e) {
            b.d(e.toString());
            return -1;
        }
        return insert;
    }

    public synchronized com.xiaomi.xmpush.thrift.m a(String str) {
        m.a(false);
        try {
            Iterator it = a().iterator();
            while (it.hasNext()) {
                com.xiaomi.xmpush.thrift.m mVar = (com.xiaomi.xmpush.thrift.m) it.next();
                if (TextUtils.equals(mVar.a(), str)) {
                    return mVar;
                }
            }
            return null;
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
    }

    public synchronized ArrayList<com.xiaomi.xmpush.thrift.m> a() {
        ArrayList<com.xiaomi.xmpush.thrift.m> arrayList;
        m.a(false);
        try {
            Cursor a = a(i.a(this.a).a());
            arrayList = new ArrayList();
            if (a != null) {
                while (a.moveToNext()) {
                    try {
                        String stringBuilder;
                        com.xiaomi.xmpush.thrift.m mVar = new com.xiaomi.xmpush.thrift.m();
                        mVar.a(a.getString(a.getColumnIndex(AgooConstants.MESSAGE_ID)));
                        mVar.b(a.getString(a.getColumnIndex(c.e)));
                        mVar.a((long) a.getInt(a.getColumnIndex("appId")));
                        mVar.c(a.getString(a.getColumnIndex(Constants.PACKAGE_NAME)));
                        mVar.b((long) a.getInt(a.getColumnIndex("create_time")));
                        n a2 = a(a);
                        StringBuilder stringBuilder2;
                        if (a2 == null) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(c);
                            stringBuilder2.append("findAllGeoFencing: geo type null");
                            stringBuilder = stringBuilder2.toString();
                        } else {
                            mVar.a(a2);
                            if (TextUtils.equals("Circle", a2.name())) {
                                mVar.a(b(a));
                                mVar.a(a.getDouble(a.getColumnIndex("circle_radius")));
                            } else if (TextUtils.equals("Polygon", a2.name())) {
                                List c = c(a);
                                if (c != null) {
                                    if (c.size() >= 3) {
                                        mVar.a(c);
                                    }
                                }
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(c);
                                stringBuilder2.append("findAllGeoFencing: geo points null or size<3");
                                stringBuilder = stringBuilder2.toString();
                            }
                            j d = d(a);
                            if (d == null) {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(c);
                                stringBuilder2.append("findAllGeoFencing: geo Coordinate Provider null ");
                                b.c(stringBuilder2.toString());
                            } else {
                                mVar.a(d);
                                arrayList.add(mVar);
                            }
                        }
                        b.c(stringBuilder);
                    } catch (Exception e) {
                        b.d(e.toString());
                    }
                }
                a.close();
            }
            i.a(this.a).b();
        } catch (Exception e2) {
            b.d(e2.toString());
            return null;
        }
        return arrayList;
    }

    public synchronized ArrayList<com.xiaomi.xmpush.thrift.m> b(String str) {
        ArrayList<com.xiaomi.xmpush.thrift.m> arrayList;
        m.a(false);
        try {
            ArrayList a = a();
            arrayList = new ArrayList();
            Iterator it = a.iterator();
            while (it.hasNext()) {
                com.xiaomi.xmpush.thrift.m mVar = (com.xiaomi.xmpush.thrift.m) it.next();
                if (TextUtils.equals(mVar.g(), str)) {
                    arrayList.add(mVar);
                }
            }
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
        return arrayList;
    }

    public synchronized String c(String str) {
        m.a(false);
        try {
            Cursor a = a(i.a(this.a).a());
            if (a != null) {
                while (a.moveToNext()) {
                    if (TextUtils.equals(a.getString(a.getColumnIndex(AgooConstants.MESSAGE_ID)), str)) {
                        String string = a.getString(a.getColumnIndex("current_status"));
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(c);
                        stringBuilder.append("findGeoStatueByGeoId: geo current statue is ");
                        stringBuilder.append(string);
                        stringBuilder.append(" geoId:");
                        stringBuilder.append(str);
                        b.c(stringBuilder.toString());
                        a.close();
                        return string;
                    }
                }
                a.close();
            }
            i.a(this.a).b();
            return "Unknown";
        } catch (Exception e) {
            b.d(e.toString());
            return "Unknown";
        }
    }

    public synchronized int d(String str) {
        m.a(false);
        try {
            if (a(str) == null) {
                return 0;
            }
            int delete = i.a(this.a).a().delete("geofence", "id = ?", new String[]{str});
            i.a(this.a).b();
            return delete;
        } catch (Exception e) {
            b.d(e.toString());
            return 0;
        }
    }

    public synchronized int e(String str) {
        m.a(false);
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int delete = i.a(this.a).a().delete("geofence", "package_name = ?", new String[]{str});
            i.a(this.a).b();
            return delete;
        } catch (Exception e) {
            b.d(e.toString());
            return 0;
        }
    }
}
