package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.an;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    public static class a {
        public long a;
        public String b;
        public long c;
        public Map<String, String[]> d;
    }

    public static a readTargetDumpInfo(String str, String str2, boolean z) {
        if (str != null) {
            if (str2 != null) {
                str = new a();
                readTraceFile(str2, new 1(str, z));
                if (str.a <= null || str.c <= null || str.b == null) {
                    return null;
                }
                return str;
            }
        }
        return null;
    }

    public static a readFirstDumpInfo(String str, boolean z) {
        if (str == null) {
            an.e("path:%s", str);
            return null;
        }
        a aVar = new a();
        readTraceFile(str, new 2(aVar, z));
        if (aVar.a > null && aVar.c > null && aVar.b != null) {
            return aVar;
        }
        z = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aVar.a);
        stringBuilder.append(" ");
        stringBuilder.append(aVar.c);
        stringBuilder.append(" ");
        stringBuilder.append(aVar.b);
        z[0] = stringBuilder.toString();
        an.e("first dump error %s", z);
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        BufferedReader bufferedReader;
        StringBuilder stringBuilder;
        Throwable e;
        Throwable th;
        String str2 = str;
        b bVar2 = bVar;
        if (str2 != null) {
            if (bVar2 != null) {
                File file = new File(str2);
                if (file.exists()) {
                    if (bVar2.a(str2, file.lastModified(), file.length())) {
                        try {
                            bufferedReader = new BufferedReader(new FileReader(file));
                            Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                            Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                            Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                            Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                            while (true) {
                                Object[] a = a(bufferedReader, compile);
                                if (a != null) {
                                    String[] split = a[1].toString().split("\\s");
                                    long parseLong = Long.parseLong(split[2]);
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(split[4]);
                                    stringBuilder.append(" ");
                                    stringBuilder.append(split[5]);
                                    long time = simpleDateFormat.parse(stringBuilder.toString()).getTime();
                                    a = a(bufferedReader, compile3);
                                    if (a == null) {
                                        try {
                                            bufferedReader.close();
                                            return;
                                        } catch (Throwable e2) {
                                            if (!an.a(e2)) {
                                                e2.printStackTrace();
                                            }
                                            return;
                                        }
                                    }
                                    Matcher matcher = compile3.matcher(a[1].toString());
                                    matcher.find();
                                    matcher.group(1);
                                    SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                                    if (bVar2.a(parseLong, time, matcher.group(1))) {
                                        while (true) {
                                            try {
                                                a = a(bufferedReader, compile4, compile2);
                                                if (a != null) {
                                                    if (a[0] != compile4) {
                                                        break;
                                                    }
                                                    CharSequence obj = a[1].toString();
                                                    Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                                    matcher2.find();
                                                    str2 = matcher2.group();
                                                    str2 = str2.substring(1, str2.length() - 1);
                                                    boolean contains = obj.contains("NATIVE");
                                                    matcher = Pattern.compile("tid=\\d+").matcher(obj);
                                                    matcher.find();
                                                    String group = matcher.group();
                                                    if (!bVar2.a(str2, Integer.parseInt(group.substring(group.indexOf("=") + 1)), a(bufferedReader), b(bufferedReader), contains)) {
                                                        try {
                                                            bufferedReader.close();
                                                            return;
                                                        } catch (Throwable e22) {
                                                            if (!an.a(e22)) {
                                                                e22.printStackTrace();
                                                            }
                                                            return;
                                                        }
                                                    }
                                                }
                                                break;
                                            } catch (Exception e3) {
                                                e22 = e3;
                                            }
                                        }
                                        if (bVar2.a(Long.parseLong(a[1].toString().split("\\s")[2]))) {
                                            simpleDateFormat = simpleDateFormat2;
                                        } else {
                                            try {
                                                bufferedReader.close();
                                                return;
                                            } catch (Throwable e222) {
                                                if (!an.a(e222)) {
                                                    e222.printStackTrace();
                                                }
                                                return;
                                            }
                                        }
                                    }
                                    try {
                                        bufferedReader.close();
                                        return;
                                    } catch (Throwable e2222) {
                                        if (!an.a(e2222)) {
                                            e2222.printStackTrace();
                                        }
                                        return;
                                    }
                                }
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (Throwable e22222) {
                                    if (!an.a(e22222)) {
                                        e22222.printStackTrace();
                                    }
                                    return;
                                }
                            }
                        } catch (Exception e4) {
                            e22222 = e4;
                            bufferedReader = null;
                            th = e22222;
                            try {
                                if (!an.a(th)) {
                                    th.printStackTrace();
                                }
                                Object[] objArr = new Object[2];
                                objArr[0] = th.getClass().getName();
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(th.getMessage());
                                objArr[1] = stringBuilder.toString();
                                an.d("trace open fail:%s : %s", objArr);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e222222) {
                                        if (!an.a(e222222)) {
                                            e222222.printStackTrace();
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                e222222 = th2;
                                th = e222222;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e2222222) {
                                        if (!an.a(e2222222)) {
                                            e2222222.printStackTrace();
                                        }
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            e2222222 = th3;
                            bufferedReader = null;
                            th = e2222222;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    }
                }
            }
        }
    }

    protected static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null) {
            if (patternArr == null) {
            }
            while (true) {
                CharSequence readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return null;
                }
                for (Pattern matcher : patternArr) {
                    if (matcher.matcher(readLine).matches()) {
                        return new Object[]{patternArr[r4], readLine};
                    }
                }
            }
        }
        return null;
    }

    protected static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(readLine);
            stringBuilder.append("\n");
            stringBuffer.append(stringBuilder.toString());
        }
        return stringBuffer.toString();
    }

    protected static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.trim().length() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(readLine);
                stringBuilder.append("\n");
                stringBuffer.append(stringBuilder.toString());
            }
        }
        return stringBuffer.toString();
    }
}
