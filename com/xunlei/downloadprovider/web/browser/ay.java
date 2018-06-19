package com.xunlei.downloadprovider.web.browser;

import android.text.TextUtils;
import com.umeng.message.proguard.k;
import java.util.regex.Pattern;

/* compiled from: SearchKeywordUtil */
class ay {
    private static ay j;
    Pattern a = Pattern.compile("(?:\\?|&)keyword=([^&]*)");
    Pattern b = Pattern.compile(this.k, 2);
    Pattern c = Pattern.compile("(\\?|&)(wd|word)=([^&]*)");
    Pattern d = Pattern.compile("#\\|src_([^\\|]+)\\|");
    Pattern e;
    Pattern f;
    Pattern g;
    Pattern h;
    Pattern i;
    private String k = "(?:m|wap)\\.sogou\\.com[\\S]*/web/searchList[\\.jsp]*?\\?";
    private String l = "(m|www)\\.baidu\\.com[\\S]*?(/s\\?|/#|/src_)";
    private String m = "(m|www)\\.baidu\\.com[\\S]*?(/\\?[\\S]*#\\|src_[^\\|]+\\|)";
    private String n;
    private String o;
    private String p;

    ay() {
        StringBuilder stringBuilder = new StringBuilder("(?:");
        stringBuilder.append(this.l);
        stringBuilder.append(")|(?:");
        stringBuilder.append(this.m);
        stringBuilder.append(k.t);
        this.e = Pattern.compile(stringBuilder.toString());
        this.n = "(?:m|www)\\.so\\.com[\\S]*/s\\?";
        this.o = "(?:m|www)\\.so\\.com[\\S]*/index[\\.\\w]*\\?a=index";
        this.f = Pattern.compile("(?:\\?|&)q=([^&]*)");
        stringBuilder = new StringBuilder(k.s);
        stringBuilder.append(this.n);
        stringBuilder.append(")|(");
        stringBuilder.append(this.o);
        stringBuilder.append(k.t);
        this.g = Pattern.compile(stringBuilder.toString());
        this.p = "(?:m|www)\\.sm\\.cn[\\S]*/s\\?";
        this.h = Pattern.compile("(?:\\?|&)q=([^&]*)");
        this.i = Pattern.compile(this.p);
    }

    public static ay a() {
        if (j == null) {
            synchronized (ay.class) {
                if (j == null) {
                    j = new ay();
                }
            }
        }
        return j;
    }

    static String a(String str, Pattern pattern, int i) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        pattern = pattern.matcher(str);
        if (!pattern.find()) {
            return null;
        }
        try {
            pattern = pattern.toMatchResult();
            str = com.xunlei.xllib.b.k.f(str.substring(pattern.start(i), pattern.end(i)));
            try {
                return TextUtils.isEmpty(str) == null ? str.replace('+', 32) : str;
            } catch (Exception e) {
                pattern = e;
                str2 = str;
                pattern.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            pattern = e2;
            pattern.printStackTrace();
            return str2;
        }
    }
}
