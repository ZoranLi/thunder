package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.k.b;
import anet.channel.strategy.k.c;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: Taobao */
class SafeAislesMap implements Serializable {
    public static final String NO_RESULT = "No_Result";
    private SerialLruCache<String, String> a = null;
    private transient StrategyInfoHolder b = null;

    SafeAislesMap() {
        a();
    }

    void a(StrategyInfoHolder strategyInfoHolder) {
        this.b = strategyInfoHolder;
    }

    void a() {
        if (this.a == null) {
            this.a = new SerialLruCache(128);
        }
    }

    void a(c cVar) {
        if (cVar.c != null) {
            synchronized (this.a) {
                TreeMap treeMap = null;
                for (b bVar : cVar.c) {
                    if (bVar.h) {
                        this.a.remove(bVar.a);
                    } else if (!bVar.j) {
                        if (bVar.d != null) {
                            if (treeMap == null) {
                                treeMap = new TreeMap();
                            }
                            treeMap.put(bVar.a, bVar.d);
                        } else if (HttpConstant.HTTP.equalsIgnoreCase(bVar.c) || "https".equalsIgnoreCase(bVar.c)) {
                            this.a.put(bVar.a, bVar.c);
                        } else {
                            this.a.put(bVar.a, NO_RESULT);
                        }
                    }
                }
                if (treeMap != null) {
                    for (Entry entry : treeMap.entrySet()) {
                        String str = (String) entry.getValue();
                        if (this.a.containsKey(str)) {
                            this.a.put(entry.getKey(), this.a.get(str));
                        } else {
                            this.a.put(entry.getKey(), NO_RESULT);
                        }
                    }
                }
            }
            if (ALog.isPrintLog(1) != null) {
                ALog.d("awcn.SafeAislesMap", toString(), null, new Object[0]);
            }
        }
    }

    String a(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            if (d.b(str)) {
                String str3;
                synchronized (this.a) {
                    str3 = (String) this.a.get(str);
                    if (str3 == null) {
                        this.a.put(str, NO_RESULT);
                    }
                }
                if (str3 == null) {
                    this.b.d().a(str, false);
                } else if (NO_RESULT.equals(str3) != null) {
                    return str2;
                }
                str2 = str3;
                return str2;
            }
        }
        return null;
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.a) {
            StringBuilder stringBuilder2 = new StringBuilder("SafeAislesMap: ");
            stringBuilder2.append(this.a.toString());
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
