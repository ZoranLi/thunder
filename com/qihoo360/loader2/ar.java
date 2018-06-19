package com.qihoo360.loader2;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.qihoo360.a.a.a;
import com.qihoo360.a.a.d;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.g;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.utils.a.h;
import com.qihoo360.replugin.utils.b;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xiaomi.push.service.av;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: V5FileInfo */
public final class ar {
    private static final Pattern d = Pattern.compile("^v-plugin-([^.-]+).jar$");
    private static final Pattern e = Pattern.compile("^plugin-s-([^.-]+).jar$");
    private static final Pattern f = Pattern.compile("^p-n-([^.-]+).jar$");
    private static final Pattern g = Pattern.compile("^p-m-([^.-]+).jar$");
    String a;
    File b;
    int c;

    static final String a(String str) {
        StringBuilder stringBuilder = new StringBuilder("p-n-");
        stringBuilder.append(str);
        stringBuilder.append(ShareConstants.JAR_SUFFIX);
        return stringBuilder.toString();
    }

    static final ar a(File file, int i) {
        Matcher matcher;
        CharSequence name = file.getName();
        if (i == 3) {
            matcher = d.matcher(name);
        } else if (i == 2) {
            matcher = e.matcher(name);
        } else if (i == 4) {
            matcher = g.matcher(name);
        } else {
            matcher = f.matcher(name);
        }
        if (matcher != null) {
            if (matcher.matches()) {
                MatchResult toMatchResult = matcher.toMatchResult();
                if (toMatchResult != null) {
                    if (toMatchResult.groupCount() == 1) {
                        if (file.exists()) {
                            if (file.isFile()) {
                                ar arVar = new ar();
                                arVar.a = toMatchResult.group(1);
                                arVar.b = file;
                                arVar.c = i;
                                if (c.a != 0) {
                                    StringBuilder stringBuilder = new StringBuilder("V5FileInfo.build: found plugin, name=");
                                    stringBuilder.append(arVar.a);
                                    stringBuilder.append(" file=");
                                    stringBuilder.append(file.getAbsolutePath());
                                    c.a("ws001", stringBuilder.toString());
                                }
                                return arVar;
                            }
                        }
                        return null;
                    }
                }
                return null;
            }
        }
        return null;
    }

    final PluginInfo a(Context context, File file, boolean z) {
        Closeable fileInputStream;
        Closeable dataInputStream;
        Throwable th;
        File file2 = file;
        try {
            fileInputStream = new FileInputStream(this.b);
            try {
                dataInputStream = new DataInputStream(fileInputStream);
                b.a(fileInputStream);
                b.a(dataInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                b.a(fileInputStream);
                b.a(dataInputStream);
                throw th;
            }
            PackageInfo a;
            try {
                int i;
                if (r1.c == 3) {
                    dataInputStream.skip(16);
                    i = 16;
                } else {
                    i = 0;
                }
                int readInt = dataInputStream.readInt();
                i += 4;
                int readInt2 = dataInputStream.readInt();
                i += 4;
                int readInt3 = dataInputStream.readInt();
                i += 4;
                String readUTF = dataInputStream.readUTF();
                StringBuilder stringBuilder;
                if (readUTF.length() == 32) {
                    i += 2 + readUTF.length();
                    int readInt4 = dataInputStream.readInt();
                    i += 4;
                    dataInputStream.skip((long) readInt4);
                    i += readInt4;
                    int readInt5 = dataInputStream.readInt();
                    i += 4;
                    if (c.a) {
                        StringBuilder stringBuilder2 = new StringBuilder("update v5 plugin: low=");
                        stringBuilder2.append(readInt);
                        stringBuilder2.append(" high=");
                        stringBuilder2.append(readInt2);
                        stringBuilder2.append(" ver=");
                        stringBuilder2.append(readInt3);
                        stringBuilder2.append(" md5=");
                        stringBuilder2.append(readUTF);
                        stringBuilder2.append(" custom=");
                        stringBuilder2.append(readInt4);
                        stringBuilder2.append(" length=");
                        stringBuilder2.append(readInt5);
                        stringBuilder2.append(" name=");
                        stringBuilder2.append(r1.a);
                        c.a("ws001", stringBuilder2.toString());
                    }
                    StringBuilder stringBuilder3;
                    if (((long) (i + readInt5)) != r1.b.length()) {
                        if (c.a) {
                            stringBuilder3 = new StringBuilder("update v5 plugin: invalid length: calc.length=");
                            stringBuilder3.append(r1.b.length() - ((long) i));
                            stringBuilder3.append(" name=");
                            stringBuilder3.append(r1.a);
                            c.a("ws001", stringBuilder3.toString());
                        }
                    } else if (readInt >= e.a) {
                        if (readInt2 >= readInt) {
                            if (readInt2 - readInt <= 1024) {
                                PluginInfo build;
                                PluginInfo.build(r1.a, readInt, readInt2, readInt3);
                                RePlugin.getConfig();
                                if (z) {
                                    StringBuilder stringBuilder4;
                                    int i2;
                                    StringBuilder stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append(PluginInfo.format(r1.a, readInt, readInt2, readInt3));
                                    stringBuilder5.append(ShareConstants.JAR_SUFFIX);
                                    File file3 = new File(file2, stringBuilder5.toString());
                                    if (file3.exists() && file3.length() == ((long) readInt5)) {
                                        if (c.a) {
                                            stringBuilder4 = new StringBuilder("update v5 plugin: checking target ...  name=");
                                            stringBuilder4.append(r1.a);
                                            c.a("ws001", stringBuilder4.toString());
                                        }
                                        byte[] a2 = h.a(file3);
                                        if (readUTF.equals((a2 != null ? d.a(a2) : "").toLowerCase(Locale.ENGLISH))) {
                                            if (c.a) {
                                                stringBuilder3 = new StringBuilder("update v5 plugin: target match name=");
                                                stringBuilder3.append(r1.a);
                                                c.a("ws001", stringBuilder3.toString());
                                            }
                                            build = PluginInfo.build(file3);
                                        }
                                    }
                                    if (c.a) {
                                        stringBuilder4 = new StringBuilder("update v5 plugin: extract ... name=");
                                        stringBuilder4.append(r1.a);
                                        c.a("ws001", stringBuilder4.toString());
                                    }
                                    readInt = 1;
                                    File file4 = new File(file2, String.format("%s_plugin.tmp", new Object[]{r1.a}));
                                    com.qihoo360.replugin.utils.c.a((InputStream) dataInputStream, file4);
                                    if (file4.length() != ((long) readInt5)) {
                                        if (c.a) {
                                            stringBuilder4 = new StringBuilder("update v5 plugin: extract file length=");
                                            stringBuilder4.append(file4.length());
                                            stringBuilder4.append(" expected=");
                                            stringBuilder4.append(readInt5);
                                            c.a("ws001", stringBuilder4.toString());
                                        }
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    if (i2 == 0) {
                                        byte[] a3 = h.a(file4);
                                        String toLowerCase = (a3 != null ? d.a(a3) : "").toLowerCase(Locale.ENGLISH);
                                        if (!readUTF.equals(toLowerCase)) {
                                            if (c.a) {
                                                StringBuilder stringBuilder6 = new StringBuilder("update v5 plugin: extract=");
                                                stringBuilder6.append(toLowerCase);
                                                stringBuilder6.append(" orig=");
                                                stringBuilder6.append(readUTF);
                                                stringBuilder6.append(", delete tmpfile name=");
                                                stringBuilder6.append(r1.a);
                                                c.a("ws001", stringBuilder6.toString());
                                            }
                                            i2 = 1;
                                        }
                                    }
                                    if (i2 == 0) {
                                        a = a.a(context.getPackageManager(), file4.getAbsolutePath());
                                        if (a == null) {
                                            if (c.a) {
                                                stringBuilder4 = new StringBuilder("update v5 plugin: can't fetch package info:  name=");
                                                stringBuilder4.append(r1.a);
                                                c.a("ws001", stringBuilder4.toString());
                                            }
                                            i2 = 1;
                                        }
                                        if (!d.a(a)) {
                                            if (c.a) {
                                                stringBuilder4 = new StringBuilder("update v5 plugin: invalid cert:  name=");
                                                stringBuilder4.append(r1.a);
                                                c.a("ws001", stringBuilder4.toString());
                                            }
                                            new StringBuilder("uv5p ic n=").append(r1.a);
                                            if (!g.a) {
                                                i2 = 1;
                                            }
                                        }
                                        if (c.a) {
                                            readUTF = "ws001";
                                            stringBuilder4 = new StringBuilder("update v5 plugin: package=");
                                            stringBuilder4.append(a != null ? a.packageName : "");
                                            stringBuilder4.append(" delete=");
                                            stringBuilder4.append(i2 != 0 ? "true" : av.b);
                                            stringBuilder4.append(" name=");
                                            stringBuilder4.append(r1.a);
                                            c.a(readUTF, stringBuilder4.toString());
                                        }
                                    }
                                    build = PluginInfo.build(file3);
                                    if (build == null) {
                                        i2 = 1;
                                    }
                                    if (i2 == 0) {
                                        if (!ab.a(file4.getAbsolutePath(), build.getNativeLibsDir())) {
                                            if (readInt == 0) {
                                                com.qihoo360.replugin.utils.c.c(file4);
                                            } else {
                                                if (c.a) {
                                                    stringBuilder4 = new StringBuilder("update v5 plugin: extract success name=");
                                                    stringBuilder4.append(r1.a);
                                                    c.a("ws001", stringBuilder4.toString());
                                                }
                                                if (file3.exists()) {
                                                    com.qihoo360.replugin.utils.c.c(file3);
                                                }
                                                com.qihoo360.replugin.utils.c.c(file4, file3);
                                            }
                                        }
                                    }
                                    readInt = i2;
                                    if (readInt == 0) {
                                        if (c.a) {
                                            stringBuilder4 = new StringBuilder("update v5 plugin: extract success name=");
                                            stringBuilder4.append(r1.a);
                                            c.a("ws001", stringBuilder4.toString());
                                        }
                                        if (file3.exists()) {
                                            com.qihoo360.replugin.utils.c.c(file3);
                                        }
                                        com.qihoo360.replugin.utils.c.c(file4, file3);
                                    } else {
                                        com.qihoo360.replugin.utils.c.c(file4);
                                    }
                                } else {
                                    if (c.a) {
                                        stringBuilder = new StringBuilder("update v5 plugin: delay extract f=");
                                        stringBuilder.append(r1.b);
                                        c.a("ws001", stringBuilder.toString());
                                    }
                                    build = PluginInfo.buildV5(r1.a, readInt, readInt2, readInt3, r1.c, r1.b.getAbsolutePath(), -1, -1, -1, null);
                                }
                                b.a(fileInputStream);
                                b.a(dataInputStream);
                                return build;
                            }
                        }
                        if (c.a) {
                            stringBuilder = new StringBuilder("update v5 plugin: invalid plugin.high=");
                            stringBuilder.append(readInt2);
                            stringBuilder.append(" plugin.low=");
                            stringBuilder.append(readInt);
                            c.a("ws001", stringBuilder.toString());
                        }
                    } else if (c.a) {
                        stringBuilder = new StringBuilder("update v5 plugin: not supported plugin.low=");
                        stringBuilder.append(readInt);
                        stringBuilder.append(" host.compatible.ver=");
                        stringBuilder.append(e.a);
                        stringBuilder.append(" name=");
                        stringBuilder.append(r1.a);
                        c.a("ws001", stringBuilder.toString());
                    }
                } else if (c.a) {
                    stringBuilder = new StringBuilder("update v5 plugin: invalid md5 length: length=");
                    stringBuilder.append(readUTF.length());
                    stringBuilder.append(" name=");
                    stringBuilder.append(r1.a);
                    c.a("ws001", stringBuilder.toString());
                }
            } catch (Throwable th22) {
                th = th22;
                if (c.a) {
                    c.a("ws001", th.getMessage(), th);
                }
                b.a(fileInputStream);
                b.a(dataInputStream);
                return null;
            }
        } catch (Throwable th222) {
            th = th222;
            fileInputStream = null;
            dataInputStream = fileInputStream;
            b.a(fileInputStream);
            b.a(dataInputStream);
            throw th;
        }
    }
}
