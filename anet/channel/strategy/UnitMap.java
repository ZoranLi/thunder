package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.k.c;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
class UnitMap implements Serializable {
    private Map<String, String> a;

    UnitMap() {
        a();
    }

    void a() {
        if (this.a == null) {
            this.a = new SerialLruCache(6);
        }
    }

    void a(c cVar) {
        Object obj = cVar.b;
        int i = (TextUtils.isEmpty(obj) || obj.equalsIgnoreCase("center")) ? 0 : 1;
        cVar = b(cVar.d, cVar.e);
        if (i == 0) {
            synchronized (this.a) {
                this.a.remove(cVar);
            }
        } else if (cVar != null) {
            synchronized (this.a) {
                this.a.put(cVar, obj);
            }
        }
        if (ALog.isPrintLog(1) != null) {
            synchronized (this.a) {
                StringBuilder stringBuilder = new StringBuilder("UnitMap : ");
                stringBuilder.append(toString());
                ALog.d("awcn.UnitMap", stringBuilder.toString(), null, new Object[0]);
            }
        }
    }

    String a(String str, String str2) {
        str = b(str, str2);
        if (str == null) {
            return null;
        }
        synchronized (this.a) {
            str = (String) this.a.get(str);
        }
        return str;
    }

    void a(String str, String str2, String str3) {
        str = b(str, str2);
        if (str != null) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.UnitMap", "set unit prefix", null, "key", str, "unitPrefix", str3);
            }
            if (TextUtils.isEmpty(str3) == null) {
                if (str3.equalsIgnoreCase("center") == null) {
                    synchronized (this.a) {
                        this.a.put(str, str3);
                    }
                    return;
                }
            }
            synchronized (this.a) {
                this.a.remove(str);
            }
        }
    }

    private String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return TextUtils.isEmpty(str2) == null ? str2 : null;
        } else {
            return str;
        }
    }

    public String toString() {
        String stringBuilder;
        synchronized (this.a) {
            StringBuilder stringBuilder2 = new StringBuilder("UnitMap: ");
            stringBuilder2.append(this.a.toString());
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
