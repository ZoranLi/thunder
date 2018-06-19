package com.qihoo360.loader2;

import android.os.Process;
import android.text.TextUtils;
import com.qihoo360.mobilesafe.api.b;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.process.a;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: PluginManager */
public final class aa {
    @Deprecated
    static int a = 0;
    @Deprecated
    public static int b = -1;
    private static final Pattern c = Pattern.compile("^(.*):loader([0-1])$");

    static final boolean b(int i) {
        return i >= 0 && i < 2;
    }

    public static final boolean a() {
        return b >= 0 && b < 2;
    }

    public static final boolean a(int i) {
        if (!(i == -1 || i == Integer.MIN_VALUE)) {
            if (b(i) == 0) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    static final void b() {
        b.a();
        a = Process.myUid();
        b = a(com.qihoo360.replugin.a.b.a);
    }

    static final int a(String str) {
        int i = Integer.MIN_VALUE;
        try {
            if (TextUtils.equals(com.qihoo360.replugin.a.b.c, str)) {
                if (c.a != null) {
                    c.a("ws001", "plugin process checker: default, index=0");
                }
                return -1;
            } else if (TextUtils.isEmpty(str) || !str.contains(":p")) {
                StringBuilder stringBuilder;
                Matcher matcher = c.matcher(str);
                if (matcher != null) {
                    if (matcher.matches()) {
                        MatchResult toMatchResult = matcher.toMatchResult();
                        if (toMatchResult != null) {
                            if (toMatchResult.groupCount() == 2) {
                                if (TextUtils.equals(com.qihoo360.replugin.a.b.c, toMatchResult.group(1))) {
                                    str = Integer.parseInt(toMatchResult.group(2));
                                    try {
                                        if (c.a) {
                                            StringBuilder stringBuilder2 = new StringBuilder("plugin process checker: index=");
                                            stringBuilder2.append(str);
                                            c.a("ws001", stringBuilder2.toString());
                                        }
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                        i = str;
                                        str = th2;
                                        if (c.a) {
                                            c.a("ws001", str.getMessage(), str);
                                        }
                                        str = i;
                                        return str;
                                    }
                                    return str;
                                }
                                if (c.a) {
                                    stringBuilder = new StringBuilder("plugin process checker: package name not match in=");
                                    stringBuilder.append(str);
                                    c.a("ws001", stringBuilder.toString());
                                }
                                return Integer.MIN_VALUE;
                            }
                        }
                        if (c.a) {
                            stringBuilder = new StringBuilder("plugin process checker: no group in=");
                            stringBuilder.append(str);
                            c.a("ws001", stringBuilder.toString());
                        }
                        return Integer.MIN_VALUE;
                    }
                }
                if (c.a) {
                    stringBuilder = new StringBuilder("plugin process checker: non plugin process in=");
                    stringBuilder.append(str);
                    c.a("ws001", stringBuilder.toString());
                }
                return Integer.MIN_VALUE;
            } else {
                return ((Integer) a.a.get(a.a(str))).intValue();
            }
        } catch (Throwable th3) {
            str = th3;
            if (c.a) {
                c.a("ws001", str.getMessage(), str);
            }
            str = i;
            return str;
        }
    }
}
