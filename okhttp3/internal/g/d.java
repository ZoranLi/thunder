package okhttp3.internal.g;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;

/* compiled from: OkHostnameVerifier */
public final class d implements HostnameVerifier {
    public static final d a = new d();

    private d() {
    }

    public final boolean verify(java.lang.String r2, javax.net.ssl.SSLSession r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = 0;
        r3 = r3.getPeerCertificates();	 Catch:{ SSLException -> 0x000e }
        r3 = r3[r0];	 Catch:{ SSLException -> 0x000e }
        r3 = (java.security.cert.X509Certificate) r3;	 Catch:{ SSLException -> 0x000e }
        r2 = a(r2, r3);	 Catch:{ SSLException -> 0x000e }
        return r2;
    L_0x000e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.g.d.verify(java.lang.String, javax.net.ssl.SSLSession):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r10, java.security.cert.X509Certificate r11) {
        /*
        r0 = okhttp3.internal.c.c(r10);
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x0025;
    L_0x0008:
        r0 = 7;
        r11 = a(r11, r0);
        r0 = r11.size();
        r3 = r1;
    L_0x0012:
        if (r3 >= r0) goto L_0x0024;
    L_0x0014:
        r4 = r11.get(r3);
        r4 = (java.lang.String) r4;
        r4 = r10.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x0021;
    L_0x0020:
        return r2;
    L_0x0021:
        r3 = r3 + 1;
        goto L_0x0012;
    L_0x0024:
        return r1;
    L_0x0025:
        r0 = java.util.Locale.US;
        r10 = r10.toLowerCase(r0);
        r0 = 2;
        r0 = a(r11, r0);
        r3 = r0.size();
        r4 = r1;
        r5 = r4;
    L_0x0036:
        if (r4 >= r3) goto L_0x0049;
    L_0x0038:
        r5 = r0.get(r4);
        r5 = (java.lang.String) r5;
        r5 = a(r10, r5);
        if (r5 == 0) goto L_0x0045;
    L_0x0044:
        return r2;
    L_0x0045:
        r4 = r4 + 1;
        r5 = r2;
        goto L_0x0036;
    L_0x0049:
        if (r5 != 0) goto L_0x0181;
    L_0x004b:
        r11 = r11.getSubjectX500Principal();
        r0 = new okhttp3.internal.g.c;
        r0.<init>(r11);
        r11 = "cn";
        r0.c = r1;
        r0.d = r1;
        r0.e = r1;
        r0.f = r1;
        r3 = r0.a;
        r3 = r3.toCharArray();
        r0.g = r3;
        r3 = r0.a();
        r4 = 0;
        if (r3 != 0) goto L_0x006f;
    L_0x006d:
        goto L_0x0125;
    L_0x006f:
        r5 = "";
        r6 = r0.c;
        r7 = r0.b;
        if (r6 != r7) goto L_0x0079;
    L_0x0077:
        goto L_0x0125;
    L_0x0079:
        r6 = r0.g;
        r7 = r0.c;
        r6 = r6[r7];
        switch(r6) {
            case 34: goto L_0x008e;
            case 35: goto L_0x0088;
            case 43: goto L_0x0117;
            case 44: goto L_0x0117;
            case 59: goto L_0x0117;
            default: goto L_0x0082;
        };
    L_0x0082:
        r5 = r0.c();
        goto L_0x0117;
    L_0x0088:
        r5 = r0.b();
        goto L_0x0117;
    L_0x008e:
        r5 = r0.c;
        r5 = r5 + r2;
        r0.c = r5;
        r5 = r0.c;
        r0.d = r5;
        r5 = r0.d;
        r0.e = r5;
    L_0x009b:
        r5 = r0.c;
        r6 = r0.b;
        if (r5 != r6) goto L_0x00b7;
    L_0x00a1:
        r10 = new java.lang.IllegalStateException;
        r11 = new java.lang.StringBuilder;
        r1 = "Unexpected end of DN: ";
        r11.<init>(r1);
        r0 = r0.a;
        r11.append(r0);
        r11 = r11.toString();
        r10.<init>(r11);
        throw r10;
    L_0x00b7:
        r5 = r0.g;
        r6 = r0.c;
        r5 = r5[r6];
        r6 = 34;
        if (r5 != r6) goto L_0x00eb;
    L_0x00c1:
        r5 = r0.c;
        r5 = r5 + r2;
        r0.c = r5;
    L_0x00c6:
        r5 = r0.c;
        r6 = r0.b;
        if (r5 >= r6) goto L_0x00dc;
    L_0x00cc:
        r5 = r0.g;
        r6 = r0.c;
        r5 = r5[r6];
        r6 = 32;
        if (r5 != r6) goto L_0x00dc;
    L_0x00d6:
        r5 = r0.c;
        r5 = r5 + r2;
        r0.c = r5;
        goto L_0x00c6;
    L_0x00dc:
        r5 = new java.lang.String;
        r6 = r0.g;
        r7 = r0.d;
        r8 = r0.e;
        r9 = r0.d;
        r8 = r8 - r9;
        r5.<init>(r6, r7, r8);
        goto L_0x0117;
    L_0x00eb:
        r5 = r0.g;
        r6 = r0.c;
        r5 = r5[r6];
        r6 = 92;
        if (r5 != r6) goto L_0x0100;
    L_0x00f5:
        r5 = r0.g;
        r6 = r0.e;
        r7 = r0.d();
        r5[r6] = r7;
        goto L_0x010c;
    L_0x0100:
        r5 = r0.g;
        r6 = r0.e;
        r7 = r0.g;
        r8 = r0.c;
        r7 = r7[r8];
        r5[r6] = r7;
    L_0x010c:
        r5 = r0.c;
        r5 = r5 + r2;
        r0.c = r5;
        r5 = r0.e;
        r5 = r5 + r2;
        r0.e = r5;
        goto L_0x009b;
    L_0x0117:
        r3 = r11.equalsIgnoreCase(r3);
        if (r3 == 0) goto L_0x011f;
    L_0x011d:
        r4 = r5;
        goto L_0x0125;
    L_0x011f:
        r3 = r0.c;
        r5 = r0.b;
        if (r3 < r5) goto L_0x012c;
    L_0x0125:
        if (r4 == 0) goto L_0x0181;
    L_0x0127:
        r10 = a(r10, r4);
        return r10;
    L_0x012c:
        r3 = r0.g;
        r5 = r0.c;
        r3 = r3[r5];
        r5 = 44;
        if (r3 == r5) goto L_0x0160;
    L_0x0136:
        r3 = r0.g;
        r5 = r0.c;
        r3 = r3[r5];
        r5 = 59;
        if (r3 == r5) goto L_0x0160;
    L_0x0140:
        r3 = r0.g;
        r5 = r0.c;
        r3 = r3[r5];
        r5 = 43;
        if (r3 == r5) goto L_0x0160;
    L_0x014a:
        r10 = new java.lang.IllegalStateException;
        r11 = new java.lang.StringBuilder;
        r1 = "Malformed DN: ";
        r11.<init>(r1);
        r0 = r0.a;
        r11.append(r0);
        r11 = r11.toString();
        r10.<init>(r11);
        throw r10;
    L_0x0160:
        r3 = r0.c;
        r3 = r3 + r2;
        r0.c = r3;
        r3 = r0.a();
        if (r3 != 0) goto L_0x006f;
    L_0x016b:
        r10 = new java.lang.IllegalStateException;
        r11 = new java.lang.StringBuilder;
        r1 = "Malformed DN: ";
        r11.<init>(r1);
        r0 = r0.a;
        r11.append(r0);
        r11 = r11.toString();
        r10.<init>(r11);
        throw r10;
    L_0x0181:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.g.d.a(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    public static List<String> a(X509Certificate x509Certificate) {
        Collection a = a(x509Certificate, 7);
        x509Certificate = a(x509Certificate, 2);
        List<String> arrayList = new ArrayList(a.size() + x509Certificate.size());
        arrayList.addAll(a);
        arrayList.addAll(x509Certificate);
        return arrayList;
    }

    private static java.util.List<java.lang.String> a(java.security.cert.X509Certificate r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r4 = r4.getSubjectAlternativeNames();	 Catch:{ CertificateParsingException -> 0x0046 }
        if (r4 != 0) goto L_0x0010;	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x000b:
        r4 = java.util.Collections.emptyList();	 Catch:{ CertificateParsingException -> 0x0046 }
        return r4;	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x0010:
        r4 = r4.iterator();	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x0014:
        r1 = r4.hasNext();	 Catch:{ CertificateParsingException -> 0x0046 }
        if (r1 == 0) goto L_0x0045;	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x001a:
        r1 = r4.next();	 Catch:{ CertificateParsingException -> 0x0046 }
        r1 = (java.util.List) r1;	 Catch:{ CertificateParsingException -> 0x0046 }
        if (r1 == 0) goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x0022:
        r2 = r1.size();	 Catch:{ CertificateParsingException -> 0x0046 }
        r3 = 2;	 Catch:{ CertificateParsingException -> 0x0046 }
        if (r2 < r3) goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x0029:
        r2 = 0;	 Catch:{ CertificateParsingException -> 0x0046 }
        r2 = r1.get(r2);	 Catch:{ CertificateParsingException -> 0x0046 }
        r2 = (java.lang.Integer) r2;	 Catch:{ CertificateParsingException -> 0x0046 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x0032:
        r2 = r2.intValue();	 Catch:{ CertificateParsingException -> 0x0046 }
        if (r2 != r5) goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x0038:
        r2 = 1;	 Catch:{ CertificateParsingException -> 0x0046 }
        r1 = r1.get(r2);	 Catch:{ CertificateParsingException -> 0x0046 }
        r1 = (java.lang.String) r1;	 Catch:{ CertificateParsingException -> 0x0046 }
        if (r1 == 0) goto L_0x0014;	 Catch:{ CertificateParsingException -> 0x0046 }
    L_0x0041:
        r0.add(r1);	 Catch:{ CertificateParsingException -> 0x0046 }
        goto L_0x0014;
    L_0x0045:
        return r0;
    L_0x0046:
        r4 = java.util.Collections.emptyList();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.g.d.a(java.security.cert.X509Certificate, int):java.util.List<java.lang.String>");
    }

    private static boolean a(String str, String str2) {
        if (!(str == null || str.length() == 0 || str.startsWith("."))) {
            if (!str.endsWith("..")) {
                if (!(str2 == null || str2.length() == 0 || str2.startsWith("."))) {
                    if (!str2.endsWith("..")) {
                        StringBuilder stringBuilder;
                        if (!str.endsWith(".")) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append('.');
                            str = stringBuilder.toString();
                        }
                        if (!str2.endsWith(".")) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str2);
                            stringBuilder.append('.');
                            str2 = stringBuilder.toString();
                        }
                        str2 = str2.toLowerCase(Locale.US);
                        if (!str2.contains("*")) {
                            return str.equals(str2);
                        }
                        if (str2.startsWith("*.")) {
                            if (str2.indexOf(42, 1) == -1) {
                                if (str.length() < str2.length() || "*.".equals(str2)) {
                                    return false;
                                }
                                str2 = str2.substring(1);
                                if (!str.endsWith(str2)) {
                                    return false;
                                }
                                int length = str.length() - str2.length();
                                if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
                                    return true;
                                }
                                return false;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
