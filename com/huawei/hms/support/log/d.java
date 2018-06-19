package com.huawei.hms.support.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: LogRecord */
public class d {
    private String a = null;
    private String b = "HMS";
    private int c = 0;
    private long d = 0;
    private long e = 0;
    private String f;
    private int g;
    private int h;
    private int i = 0;
    private final StringBuilder j = new StringBuilder();

    d(int i, String str, int i2, String str2) {
        this.i = i;
        this.a = str;
        this.c = i2;
        if (str2 != null) {
            this.b = str2;
        }
        c();
    }

    private d c() {
        this.d = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.e = currentThread.getId();
        this.g = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        if (stackTrace.length > this.i) {
            StackTraceElement stackTraceElement = stackTrace[this.i];
            this.f = stackTraceElement.getFileName();
            this.h = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public <T> d a(T t) {
        this.j.append(t);
        return this;
    }

    public d a(Throwable th) {
        a(Character.valueOf('\n')).a(Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder);
        return stringBuilder.toString();
    }

    private StringBuilder a(StringBuilder stringBuilder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        stringBuilder.append('[');
        stringBuilder.append(simpleDateFormat.format(Long.valueOf(this.d)));
        String a = a(this.c);
        stringBuilder.append(' ');
        stringBuilder.append(a);
        stringBuilder.append('/');
        stringBuilder.append(this.b);
        stringBuilder.append('/');
        stringBuilder.append(this.a);
        stringBuilder.append(' ');
        stringBuilder.append(this.g);
        stringBuilder.append(':');
        stringBuilder.append(this.e);
        stringBuilder.append(' ');
        stringBuilder.append(this.f);
        stringBuilder.append(':');
        stringBuilder.append(this.h);
        stringBuilder.append(']');
        return stringBuilder;
    }

    public static String a(int i) {
        switch (i) {
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            default:
                return String.valueOf(i);
        }
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        return stringBuilder.toString();
    }

    private StringBuilder b(StringBuilder stringBuilder) {
        stringBuilder.append(' ');
        stringBuilder.append(this.j.toString());
        return stringBuilder;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder);
        b(stringBuilder);
        return stringBuilder.toString();
    }
}
