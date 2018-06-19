package com.qiniu.android.http;

import com.alipay.sdk.cons.c;
import com.qiniu.android.a.b.a;
import com.qiniu.android.d.f;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: ResponseInfo */
final class p extends a {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ int e;
    final /* synthetic */ long f;
    final /* synthetic */ String g;
    final /* synthetic */ long h;
    final /* synthetic */ String i;
    final /* synthetic */ long j;

    p(int i, String str, String str2, String str3, int i2, long j, String str4, long j2, String str5, long j3) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i2;
        this.f = j;
        this.g = str4;
        this.h = j2;
        this.i = str5;
        this.j = j3;
    }

    public final String a() {
        StringBuilder stringBuilder;
        r0 = new String[10];
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.a);
        int i = 0;
        r0[0] = stringBuilder2.toString();
        r0[1] = this.b;
        r0[2] = this.c;
        r0[3] = this.d;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.e);
        r0[4] = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.f);
        r0[5] = stringBuilder2.toString();
        r0[6] = this.g;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.h);
        r0[7] = stringBuilder2.toString();
        String str = this.i;
        if (str != null) {
            if (str.startsWith("/")) {
                if ("/".equals(str)) {
                    str = c.c;
                } else {
                    int indexOf = str.indexOf(47, 1);
                    if (indexOf > 0) {
                        str = str.substring(1, indexOf);
                        int hashCode = str.hashCode();
                        if (hashCode == -1072430054) {
                            if (str.equals("mkfile")) {
                                i = 2;
                                switch (i) {
                                    case 0:
                                        str = "mkblk";
                                        break;
                                    case 1:
                                        str = "bput";
                                        break;
                                    case 2:
                                        str = "mkfile";
                                        break;
                                    case 3:
                                        str = "put";
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } else if (hashCode == 111375) {
                            if (str.equals("put")) {
                                i = 3;
                                switch (i) {
                                    case 0:
                                        str = "mkblk";
                                        break;
                                    case 1:
                                        str = "bput";
                                        break;
                                    case 2:
                                        str = "mkfile";
                                        break;
                                    case 3:
                                        str = "put";
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } else if (hashCode == 3030893) {
                            if (str.equals("bput")) {
                                i = 1;
                                switch (i) {
                                    case 0:
                                        str = "mkblk";
                                        break;
                                    case 1:
                                        str = "bput";
                                        break;
                                    case 2:
                                        str = "mkfile";
                                        break;
                                    case 3:
                                        str = "put";
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } else if (hashCode == 103949059) {
                            if (str.equals("mkblk")) {
                                switch (i) {
                                    case 0:
                                        str = "mkblk";
                                        break;
                                    case 1:
                                        str = "bput";
                                        break;
                                    case 2:
                                        str = "mkfile";
                                        break;
                                    case 3:
                                        str = "put";
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        i = -1;
                        switch (i) {
                            case 0:
                                str = "mkblk";
                                break;
                            case 1:
                                str = "bput";
                                break;
                            case 2:
                                str = "mkfile";
                                break;
                            case 3:
                                str = "put";
                                break;
                            default:
                                break;
                        }
                    }
                    str = "";
                }
                r0[8] = str;
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.j);
                r0[9] = stringBuilder.toString();
                return f.a(r0, Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        str = "";
        r0[8] = str;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.j);
        r0[9] = stringBuilder.toString();
        return f.a(r0, Constants.ACCEPT_TIME_SEPARATOR_SP);
    }
}
