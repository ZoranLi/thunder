package org.android.spdy;

public class NetTimeGaurd {
    public static final int CREATE = 0;
    public static final int ERROR = 2;
    public static final int PING = 1;
    public static final int STREAM = 3;
    private static final long calltime = 10;
    private static final long total = 50;
    private static long[] totaltime = new long[4];

    static void start(int i) {
        if (SpdyAgent.enableTimeGaurd) {
            totaltime[i] = 0;
        }
    }

    static long begin() {
        return SpdyAgent.enableTimeGaurd ? System.currentTimeMillis() : 0;
    }

    static void end(String str, int i, long j) {
        if (SpdyAgent.enableTimeGaurd) {
            long currentTimeMillis = System.currentTimeMillis() - j;
            totaltime[i] = totaltime[i] + currentTimeMillis;
            j = new StringBuilder("NetTimeGaurd[end]");
            j.append(str);
            j.append(" time=");
            j.append(currentTimeMillis);
            j.append(" total=");
            j.append(totaltime[i]);
            if (currentTimeMillis > 10) {
                j = new StringBuilder("CallBack:");
                j.append(str);
                j.append(" timeconsuming:");
                j.append(currentTimeMillis);
                j.append("  mustlessthan:10");
                throw new SpdyErrorException(j.toString(), -1);
            }
        }
    }

    static void finish(int i) {
        if (SpdyAgent.enableTimeGaurd) {
            new StringBuilder("NetTimeGaurd[finish]:time=").append(totaltime[i]);
            if (totaltime[i] > total) {
                StringBuilder stringBuilder = new StringBuilder("CallBack totaltimeconsuming:");
                stringBuilder.append(totaltime[i]);
                stringBuilder.append("  mustlessthan:50");
                throw new SpdyErrorException(stringBuilder.toString(), -1);
            }
        }
    }
}
