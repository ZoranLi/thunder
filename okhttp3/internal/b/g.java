package okhttp3.internal.b;

/* compiled from: HttpMethod */
public final class g {
    public static boolean a(String str) {
        if (!(str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH"))) {
            if (str.equals("REPORT") == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean b(String str) {
        if (!(a(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL"))) {
            if (str.equals("LOCK") == null) {
                return null;
            }
        }
        return true;
    }
}
