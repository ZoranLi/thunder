package com.xunlei.downloadprovider.download.engine.util;

import android.text.TextUtils;
import com.xunlei.xllib.b.k;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CidUrl implements Serializable {
    private static final long serialVersionUID = 0;
    private String mCid;
    private String mFile;
    private String mGcid;
    private long mSize;
    private String mUrl;

    private static class a {
        private static final Pattern a = Pattern.compile("cid://([A-Fa-f0-9]+)");
        private static final Pattern b = Pattern.compile("\\|gcid\\|([A-Fa-f0-9]+)");
        private static final Pattern c = Pattern.compile("\\|size\\|(\\d+)");
        private static final Pattern d = Pattern.compile("\\|file\\|([^\\|]+)");
        private String e;

        public a(String str) throws MalformedURLException {
            Object obj = 1;
            if (str != null) {
                if (!str.isEmpty()) {
                    if (a.matcher(str).find()) {
                        if (c.matcher(str).find()) {
                            obj = null;
                        }
                    }
                }
            }
            if (obj != null) {
                throw new MalformedURLException("Malformed cid url.");
            }
            this.e = str;
        }

        public final long a() {
            Matcher matcher = c.matcher(this.e);
            if (matcher.find()) {
                try {
                    return Long.valueOf(this.e.substring(matcher.start(1), matcher.end(1))).longValue();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }

        public final String b() {
            String str = "";
            Matcher matcher = a.matcher(this.e);
            if (!matcher.find()) {
                return str;
            }
            try {
                return this.e.substring(matcher.start(1), matcher.end(1));
            } catch (IllegalStateException e) {
                e.printStackTrace();
                return str;
            }
        }

        public final String c() {
            String str = "";
            Matcher matcher = b.matcher(this.e);
            if (!matcher.find()) {
                return str;
            }
            try {
                return this.e.substring(matcher.start(1), matcher.end(1));
            } catch (IllegalStateException e) {
                e.printStackTrace();
                return str;
            }
        }

        public final String d() {
            IllegalStateException illegalStateException;
            String str = "";
            Matcher matcher = d.matcher(this.e);
            if (matcher.find()) {
                try {
                    String substring = this.e.substring(matcher.start(1), matcher.end(1));
                    try {
                        str = k.f(substring);
                    } catch (IllegalStateException e) {
                        String str2 = substring;
                        illegalStateException = e;
                        str = str2;
                        illegalStateException.printStackTrace();
                        return str;
                    }
                } catch (IllegalStateException e2) {
                    illegalStateException = e2;
                    illegalStateException.printStackTrace();
                    return str;
                }
            }
            return str;
        }
    }

    public CidUrl(String str) throws MalformedURLException {
        a aVar = new a(str);
        this.mCid = aVar.b().toUpperCase();
        this.mGcid = aVar.c().toUpperCase();
        this.mSize = aVar.a();
        this.mFile = aVar.d();
        this.mUrl = str;
    }

    public CidUrl(String str, long j) {
        this(str, j, null);
    }

    public CidUrl(String str, long j, String str2) {
        this(str, j, str2, null);
    }

    public CidUrl(String str, long j, String str2, String str3) throws IllegalArgumentException {
        if (!(str == null || str.isEmpty())) {
            if (j >= 0) {
                this.mCid = str;
                this.mSize = j;
                this.mGcid = str2 == null ? "" : str2;
                this.mFile = str3 == null ? "" : str3;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("cid://");
                stringBuilder.append(str);
                stringBuilder.append("|size|");
                stringBuilder.append(String.valueOf(j));
                if (TextUtils.isEmpty(str2) == null) {
                    stringBuilder.append("|gcid|");
                    stringBuilder.append(str2);
                }
                if (TextUtils.isEmpty(str3) == null) {
                    str = k.c(str3, "UTF-8");
                    stringBuilder.append("|file|");
                    stringBuilder.append(str);
                }
                this.mUrl = stringBuilder.toString();
                return;
            }
        }
        throw new IllegalArgumentException("Invalid cid or size.");
    }

    public String getFile() {
        return this.mFile;
    }

    public String getCid() {
        return this.mCid;
    }

    public String getGcid() {
        return this.mGcid;
    }

    public long getSize() {
        return this.mSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                CidUrl cidUrl = (CidUrl) obj;
                if (this.mSize != cidUrl.mSize || !this.mCid.equals(cidUrl.mCid)) {
                    return false;
                }
                if (this.mGcid == null) {
                    return cidUrl.mGcid == null;
                } else {
                    if (this.mGcid.equals(cidUrl.mGcid) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((this.mCid.hashCode() * 31) + (this.mGcid != null ? this.mGcid.hashCode() : 0))) + ((int) (this.mSize ^ (this.mSize >>> 32)));
    }

    public String toString() {
        return this.mUrl;
    }
}
