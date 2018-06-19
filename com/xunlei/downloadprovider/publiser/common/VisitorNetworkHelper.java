package com.xunlei.downloadprovider.publiser.common;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.a.e;

public final class VisitorNetworkHelper extends e {
    private static VisitorNetworkHelper a;

    public enum Entrance {
        OTHER(-1),
        VIDEO_PLAY(1),
        PER_SPACE_VISIT(2),
        LIVE_ROOM_VISIT(3),
        COMMENT(4);
        
        private final int value;

        private Entrance(int i) {
            this.value = i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(name());
            stringBuilder.append("[");
            stringBuilder.append(this.value);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public final int value() {
            return this.value;
        }
    }

    public interface a {
        void a(int i);
    }

    private VisitorNetworkHelper() {
    }

    public static final synchronized VisitorNetworkHelper a() {
        VisitorNetworkHelper visitorNetworkHelper;
        synchronized (VisitorNetworkHelper.class) {
            if (a == null) {
                a = new VisitorNetworkHelper();
            }
            visitorNetworkHelper = a;
        }
        return visitorNetworkHelper;
    }

    public final void a(long j) {
        a(j, Entrance.OTHER, "", "", "", "");
    }

    public final void a(long j, Entrance entrance, String str, String str2, String str3, String str4) {
        XLThreadPool.execute(new q(this, j, entrance, str, str2, str3, str4));
    }

    public final void a(long j, a aVar) {
        XLThreadPool.execute(new t(this, j, aVar));
    }
}
