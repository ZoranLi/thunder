package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.channel.commonutils.misc.c;
import com.xiaomi.xmpush.thrift.ag;
import com.xiaomi.xmpush.thrift.ah;
import com.xiaomi.xmpush.thrift.h;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.q;
import com.xiaomi.xmpush.thrift.s;
import java.util.ArrayList;
import java.util.List;

public class an {
    public static int a(am amVar, h hVar) {
        String a = a(hVar);
        int i = 0;
        switch (ao.a[hVar.ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
                break;
            default:
                break;
        }
        return amVar.a.getInt(a, i);
    }

    private static String a(h hVar) {
        StringBuilder stringBuilder = new StringBuilder("oc_version_");
        stringBuilder.append(hVar.a());
        return stringBuilder.toString();
    }

    private static List<Pair<Integer, Object>> a(List<s> list, boolean z) {
        if (c.a(list)) {
            return null;
        }
        List<Pair<Integer, Object>> arrayList = new ArrayList();
        for (s sVar : list) {
            int a = sVar.a();
            i a2 = i.a(sVar.c());
            if (a2 != null) {
                if (z && sVar.c) {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                } else {
                    Object pair;
                    switch (ao.b[a2.ordinal()]) {
                        case 1:
                            pair = new Pair(Integer.valueOf(a), Integer.valueOf(sVar.f()));
                            break;
                        case 2:
                            pair = new Pair(Integer.valueOf(a), Long.valueOf(sVar.h()));
                            break;
                        case 3:
                            pair = new Pair(Integer.valueOf(a), sVar.j());
                            break;
                        case 4:
                            pair = new Pair(Integer.valueOf(a), Boolean.valueOf(sVar.l()));
                            break;
                        default:
                            pair = null;
                            break;
                    }
                    arrayList.add(pair);
                }
            }
        }
        return arrayList;
    }

    public static void a(am amVar, ag agVar) {
        amVar.b(a(agVar.a(), true));
    }

    public static void a(am amVar, ah ahVar) {
        for (q qVar : ahVar.a()) {
            if (qVar.a() > a(amVar, qVar.d())) {
                a(amVar, qVar.d(), qVar.a());
                amVar.a(a(qVar.b, false));
            }
        }
    }

    public static void a(am amVar, h hVar, int i) {
        amVar.a.edit().putInt(a(hVar), i).commit();
    }
}
