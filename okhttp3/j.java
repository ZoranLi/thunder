package okhttp3;

import java.util.Comparator;

/* compiled from: CipherSuite */
final class j implements Comparator<String> {
    j() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        int min = Math.min(str.length(), str2.length());
        int i = 4;
        while (i < min) {
            char charAt = str.charAt(i);
            char charAt2 = str2.charAt(i);
            if (charAt != charAt2) {
                return charAt < charAt2 ? -1 : 1;
            } else {
                i++;
            }
        }
        obj = str.length();
        obj2 = str2.length();
        if (obj != obj2) {
            return obj < obj2 ? -1 : 1;
        } else {
            return null;
        }
    }
}
