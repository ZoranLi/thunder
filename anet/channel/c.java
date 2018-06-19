package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
class c {
    Map<String, Integer> a = new HashMap();
    Map<String, SessionInfo> b = new ConcurrentHashMap();

    c() {
    }

    void a(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            throw new NullPointerException("info is null");
        } else if (TextUtils.isEmpty(sessionInfo.host)) {
            throw new IllegalArgumentException("host cannot be null or empty");
        } else {
            this.b.put(sessionInfo.host, sessionInfo);
        }
    }

    SessionInfo a(String str) {
        return (SessionInfo) this.b.remove(str);
    }

    SessionInfo b(String str) {
        return (SessionInfo) this.b.get(str);
    }

    Collection<SessionInfo> a() {
        return this.b.values();
    }

    void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("host cannot be null or empty");
        }
        synchronized (this.a) {
            this.a.put(str, Integer.valueOf(i));
        }
    }

    public int c(String str) {
        synchronized (this.a) {
            Integer num = (Integer) this.a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }
}
