package com.tencent.open.a;

import android.text.format.Time;
import android.util.Log;

/* compiled from: ProGuard */
public final class h {
    public static final h a = new h();

    public final String a(int i) {
        if (i == 4) {
            return "I";
        }
        if (i == 8) {
            return "W";
        }
        if (i == 16) {
            return "E";
        }
        if (i == 32) {
            return "A";
        }
        switch (i) {
            case 1:
                return "V";
            case 2:
                return "D";
            default:
                return "-";
        }
    }

    public final String a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        long j2 = j % 1000;
        Time time = new Time();
        time.set(j);
        j = new StringBuilder();
        j.append(a(i));
        j.append(47);
        j.append(time.format("%Y-%m-%d %H:%M:%S"));
        j.append(46);
        if (j2 < 10) {
            j.append("00");
        } else if (j2 < 100) {
            j.append(48);
        }
        j.append(j2);
        j.append(' ');
        j.append('[');
        if (thread == null) {
            j.append("N/A");
        } else {
            j.append(thread.getName());
        }
        j.append(']');
        j.append('[');
        j.append(str);
        j.append(']');
        j.append(' ');
        j.append(str2);
        j.append('\n');
        if (th != null) {
            j.append("* Exception : \n");
            j.append(Log.getStackTraceString(th));
            j.append('\n');
        }
        return j.toString();
    }
}
