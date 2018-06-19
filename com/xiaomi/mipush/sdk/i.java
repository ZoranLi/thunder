package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.qihoo360.replugin.RePlugin;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.av;
import com.xiaomi.push.service.h;
import com.xiaomi.push.service.j;
import com.xiaomi.push.service.k;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.m;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.thrift.a;
import org.apache.thrift.f;

public class i {
    private static volatile i a;
    private final String b = "GeoFenceRegMessageProcessor.";
    private Context c;

    private i(Context context) {
        this.c = context;
    }

    public static i a(Context context) {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i(context);
                }
            }
        }
        return a;
    }

    private m a(ai aiVar, boolean z) {
        if (z && !k.a(this.c)) {
            return null;
        }
        if (z && !k.c(this.c)) {
            return null;
        }
        try {
            a mVar = new m();
            au.a(mVar, aiVar.m());
            return mVar;
        } catch (f e) {
            e.printStackTrace();
            return null;
        }
    }

    private v a(boolean z) {
        v vVar = new v();
        Set treeSet = new TreeSet();
        if (z) {
            Iterator it = h.a(this.c).a().iterator();
            while (it.hasNext()) {
                treeSet.add((m) it.next());
            }
        }
        vVar.a(treeSet);
        return vVar;
    }

    public static void a(Context context, boolean z) {
        a aiVar = new ai(MiPushClient.generatePacketID(), false);
        aiVar.b(c.a(context).c());
        aiVar.c(r.GeoAuthorized.W);
        aiVar.h = new HashMap();
        aiVar.h.put("permission_to_location", String.valueOf(z));
        ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, null);
    }

    private void a(m mVar) {
        byte[] a = au.a(mVar);
        a aiVar = new ai(MiPushClient.generatePacketID(), false);
        aiVar.c(r.GeoPackageUninstalled.W);
        aiVar.a(a);
        ac.a(this.c).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
        StringBuilder stringBuilder = new StringBuilder("GeoFenceRegMessageProcessor. report package not exist geo_fencing id:");
        stringBuilder.append(mVar.a());
        b.c(stringBuilder.toString());
    }

    private void a(m mVar, boolean z, boolean z2) {
        byte[] a = au.a(mVar);
        a aiVar = new ai(MiPushClient.generatePacketID(), false);
        aiVar.c((z ? r.GeoRegsiterResult : r.GeoUnregsiterResult).W);
        aiVar.a(a);
        if (z2) {
            aiVar.a("permission_to_location", av.b);
        }
        ac.a(this.c).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, true, null);
        StringBuilder stringBuilder = new StringBuilder("GeoFenceRegMessageProcessor. report geo_fencing id:");
        stringBuilder.append(mVar.a());
        stringBuilder.append(" ");
        stringBuilder.append(z ? "geo_reg" : "geo_unreg");
        stringBuilder.append("  isUnauthorized:");
        stringBuilder.append(z2);
        b.c(stringBuilder.toString());
    }

    public static boolean a(Map<String, String> map) {
        return map == null ? false : TextUtils.equals("1", (CharSequence) map.get("__geo_local_cache"));
    }

    private boolean d(ai aiVar) {
        return a(aiVar.i()) && k.d(this.c);
    }

    public void a(ai aiVar) {
        String stringBuilder;
        boolean d = d(aiVar);
        m a = a(aiVar, d);
        StringBuilder stringBuilder2;
        if (a == null) {
            stringBuilder2 = new StringBuilder("GeoFenceRegMessageProcessor. registration convert geofence object failed notification_id:");
            stringBuilder2.append(aiVar.c());
            stringBuilder = stringBuilder2.toString();
        } else if (!k.e(this.c)) {
            a(a, true, true);
            return;
        } else if (!com.xiaomi.channel.commonutils.android.a.e(this.c, a.g())) {
            if (d) {
                a(a);
            }
            return;
        } else if (d) {
            if (h.a(this.c).a(a) == -1) {
                stringBuilder2 = new StringBuilder("GeoFenceRegMessageProcessor. insert a new geofence failed about geo_id:");
                stringBuilder2.append(a.a());
                b.a(stringBuilder2.toString());
            }
            new j(this.c).a(a);
            a(a, true, false);
            stringBuilder = "GeoFenceRegMessageProcessor. receive geo reg notification";
        } else {
            a(a, true, false);
            return;
        }
        b.c(stringBuilder);
    }

    public void b(ai aiVar) {
        boolean d = d(aiVar);
        m a = a(aiVar, d);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder("GeoFenceRegMessageProcessor. unregistration convert geofence object failed notification_id:");
            stringBuilder.append(aiVar.c());
            b.c(stringBuilder.toString());
        } else if (!k.e(this.c)) {
            a(a, false, true);
        } else if (!com.xiaomi.channel.commonutils.android.a.e(this.c, a.g())) {
            if (d) {
                a(a);
            }
        } else if (d) {
            StringBuilder stringBuilder2;
            if (h.a(this.c).d(a.a()) == 0) {
                stringBuilder2 = new StringBuilder("GeoFenceRegMessageProcessor. delete a geofence about geo_id:");
                stringBuilder2.append(a.a());
                stringBuilder2.append(" falied");
                b.a(stringBuilder2.toString());
            }
            if (j.a(this.c).b(a.a()) == 0) {
                stringBuilder2 = new StringBuilder("GeoFenceRegMessageProcessor. delete all geofence messages about geo_id:");
                stringBuilder2.append(a.a());
                stringBuilder2.append(" failed");
                b.a(stringBuilder2.toString());
            }
            new j(this.c).a(a.a());
            a(a, false, false);
            b.c("GeoFenceRegMessageProcessor. receive geo unreg notification");
        } else {
            a(a, false, false);
        }
    }

    public void c(ai aiVar) {
        if (k.e(this.c)) {
            boolean d = d(aiVar);
            if (d && !k.a(this.c)) {
                return;
            }
            if ((!d || k.c(this.c)) && com.xiaomi.channel.commonutils.android.a.e(this.c, aiVar.i)) {
                Object a = a(d);
                byte[] a2 = au.a(a);
                a aiVar2 = new ai(RePlugin.PROCESS_UI, false);
                aiVar2.c(r.GeoUpload.W);
                aiVar2.a(a2);
                ac.a(this.c).a(aiVar2, com.xiaomi.xmpush.thrift.a.Notification, true, null);
                StringBuilder stringBuilder = new StringBuilder("GeoFenceRegMessageProcessor. sync_geo_data. geos size:");
                stringBuilder.append(a.a().size());
                b.c(stringBuilder.toString());
            }
        }
    }
}
