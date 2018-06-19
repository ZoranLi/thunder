package com.xunlei.downloadprovider.download.create;

import android.text.TextUtils;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: XLFile */
public final class av implements Comparable<av> {
    public boolean a = false;
    public long b = -1;
    public String c;
    public long d;
    public long e;
    public EFileCategoryType f;
    protected String g;
    public String h;
    protected String i;

    public final /* synthetic */ int compareTo(Object obj) {
        int i;
        av avVar = (av) obj;
        String b = b();
        if (b == null) {
            b = "";
        } else {
            b = b.toLowerCase();
        }
        String b2 = avVar.b();
        if (b2 == null) {
            b2 = "";
        } else {
            b2 = b2.toLowerCase();
        }
        char[] toCharArray = b.toCharArray();
        char[] toCharArray2 = b2.toCharArray();
        int min = Math.min(toCharArray.length, toCharArray2.length);
        int i2 = 0;
        while (i2 < min) {
            char c = toCharArray[i2];
            char c2 = toCharArray2[i2];
            if (c == c2) {
                i2++;
            } else if (c >= '一' && c <= '龻' && c2 >= '一' && c2 <= '龻') {
                i = c - c2;
                if (i == 0) {
                    i = (int) (avVar.d - this.d);
                }
                if (i != 0) {
                    return 1;
                }
                return i;
            } else if (c < '一' || c > '龻' || (c2 >= '一' && c2 <= '龻')) {
                i = ((c < '一' || c > '龻') && c2 >= '一' && c2 <= '龻') ? 1 : c - c2;
                if (i == 0) {
                    i = (int) (avVar.d - this.d);
                }
                if (i != 0) {
                    return 1;
                }
                return i;
            } else {
                i = -1;
                if (i == 0) {
                    i = (int) (avVar.d - this.d);
                }
                if (i != 0) {
                    return i;
                }
                return 1;
            }
        }
        i = toCharArray.length - toCharArray2.length;
        if (i == 0) {
            i = (int) (avVar.d - this.d);
        }
        if (i != 0) {
            return i;
        }
        return 1;
    }

    public final av a(String str) {
        this.c = str;
        File file = new File(str);
        this.h = file.getName();
        if (file.canRead() && file.exists()) {
            this.d = file.lastModified();
            this.e = file.length();
            this.f = XLFileTypeUtil.getFileCategoryTypeByName(str);
        }
        return this;
    }

    public final String a() {
        if (this.i != null) {
            return this.i;
        }
        if (TextUtils.isEmpty(this.c)) {
            return "";
        }
        int lastIndexOf = this.c.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return null;
        }
        return this.c.substring(0, lastIndexOf + 1);
    }

    public final String b() {
        if (this.g != null) {
            return this.g;
        }
        int lastIndexOf = this.c.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return null;
        }
        String substring = this.c.substring(lastIndexOf + 1);
        this.g = substring;
        return substring;
    }

    public final void b(String str) {
        this.g = str;
    }

    public final synchronized String c() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.d));
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(24);
        stringBuffer.append("id:");
        stringBuffer.append(this.b);
        stringBuffer.append(" path:");
        stringBuffer.append(this.c);
        stringBuffer.append(" size:");
        stringBuffer.append(this.e);
        stringBuffer.append(" lastmodify:");
        stringBuffer.append(this.d);
        stringBuffer.append(" type:");
        stringBuffer.append(this.f);
        return stringBuffer.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof av) {
            av avVar = (av) obj;
            if (!((this.b == -1 || avVar.b == -1 || this.b != avVar.b) && this.c.equals(avVar.c) == null)) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        if (this.c != null) {
            return (int) (((long) this.c.hashCode()) + this.b);
        }
        return (int) (((long) super.hashCode()) + this.b);
    }
}
