package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: CipherSuite */
public final class i {
    public static final i A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
    public static final i B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
    public static final i C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
    public static final i D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
    public static final i E = a("TLS_RSA_WITH_AES_128_CBC_SHA");
    public static final i F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
    public static final i G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
    public static final i H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA");
    public static final i I = a("TLS_RSA_WITH_AES_256_CBC_SHA");
    public static final i J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
    public static final i K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
    public static final i L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA");
    public static final i M = a("TLS_RSA_WITH_NULL_SHA256");
    public static final i N = a("TLS_RSA_WITH_AES_128_CBC_SHA256");
    public static final i O = a("TLS_RSA_WITH_AES_256_CBC_SHA256");
    public static final i P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
    public static final i Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
    public static final i R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
    public static final i S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
    public static final i T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
    public static final i U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
    public static final i V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
    public static final i W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
    public static final i X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
    public static final i Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
    public static final i Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
    static final Comparator<String> a = new j();
    public static final i aA = a("TLS_ECDH_RSA_WITH_NULL_SHA");
    public static final i aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA");
    public static final i aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final i aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
    public static final i aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
    public static final i aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA");
    public static final i aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
    public static final i aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final i aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
    public static final i aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
    public static final i aK = a("TLS_ECDH_anon_WITH_NULL_SHA");
    public static final i aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA");
    public static final i aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
    public static final i aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
    public static final i aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
    public static final i aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
    public static final i aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
    public static final i aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
    public static final i aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
    public static final i aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
    public static final i aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
    public static final i aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
    public static final i aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
    public static final i aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final i aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final i aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final i aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
    public static final i ab = a("TLS_PSK_WITH_RC4_128_SHA");
    public static final i ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
    public static final i ad = a("TLS_PSK_WITH_AES_128_CBC_SHA");
    public static final i ae = a("TLS_PSK_WITH_AES_256_CBC_SHA");
    public static final i af = a("TLS_RSA_WITH_SEED_CBC_SHA");
    public static final i ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256");
    public static final i ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384");
    public static final i ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final i aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final i ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
    public static final i al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
    public static final i am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
    public static final i an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
    public static final i ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
    public static final i ap = a("TLS_FALLBACK_SCSV");
    public static final i aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA");
    public static final i ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
    public static final i as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
    public static final i at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
    public static final i au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
    public static final i av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
    public static final i aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
    public static final i ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
    public static final i ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
    public static final i az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
    public static final i b = a("SSL_RSA_WITH_NULL_MD5");
    public static final i ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final i bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final i bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final i bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
    public static final i be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
    public static final i bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
    public static final i bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
    public static final i bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final i bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
    private static final Map<String, i> bk = new TreeMap(a);
    public static final i c = a("SSL_RSA_WITH_NULL_SHA");
    public static final i d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
    public static final i e = a("SSL_RSA_WITH_RC4_128_MD5");
    public static final i f = a("SSL_RSA_WITH_RC4_128_SHA");
    public static final i g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
    public static final i h = a("SSL_RSA_WITH_DES_CBC_SHA");
    public static final i i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final i j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
    public static final i k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA");
    public static final i l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
    public static final i m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
    public static final i n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA");
    public static final i o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final i p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
    public static final i q = a("SSL_DH_anon_WITH_RC4_128_MD5");
    public static final i r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
    public static final i s = a("SSL_DH_anon_WITH_DES_CBC_SHA");
    public static final i t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
    public static final i u = a("TLS_KRB5_WITH_DES_CBC_SHA");
    public static final i v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
    public static final i w = a("TLS_KRB5_WITH_RC4_128_SHA");
    public static final i x = a("TLS_KRB5_WITH_DES_CBC_MD5");
    public static final i y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
    public static final i z = a("TLS_KRB5_WITH_RC4_128_MD5");
    final String bj;

    public static synchronized i a(String str) {
        i iVar;
        synchronized (i.class) {
            iVar = (i) bk.get(str);
            if (iVar == null) {
                iVar = new i(str);
                bk.put(str, iVar);
            }
        }
        return iVar;
    }

    static List<i> a(String... strArr) {
        List arrayList = new ArrayList(strArr.length);
        for (String a : strArr) {
            arrayList.add(a(a));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private i(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.bj = str;
    }

    public final String toString() {
        return this.bj;
    }
}
