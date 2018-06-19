package okhttp3;

import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.c;

/* compiled from: Headers */
public final class y$a {
    final List<String> a = new ArrayList(20);

    public final y$a a(String str, String str2) {
        c(str, str2);
        return b(str, str2);
    }

    final y$a b(String str, String str2) {
        this.a.add(str);
        this.a.add(str2.trim());
        return this;
    }

    public final y$a a(String str) {
        int i = 0;
        while (i < this.a.size()) {
            if (str.equalsIgnoreCase((String) this.a.get(i))) {
                this.a.remove(i);
                this.a.remove(i);
                i -= 2;
            }
            i += 2;
        }
        return this;
    }

    static void c(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        } else {
            char charAt;
            int length = str.length();
            int i = 0;
            while (i < length) {
                charAt = str.charAt(i);
                if (charAt > ' ') {
                    if (charAt < '') {
                        i++;
                    }
                }
                throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
            }
            if (str2 == null) {
                StringBuilder stringBuilder = new StringBuilder("value for name ");
                stringBuilder.append(str);
                stringBuilder.append(" == null");
                throw new NullPointerException(stringBuilder.toString());
            }
            length = str2.length();
            i = 0;
            while (i < length) {
                charAt = str2.charAt(i);
                if ((charAt > '\u001f' || charAt == '\t') && charAt < '') {
                    i++;
                } else {
                    throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str, str2));
                }
            }
        }
    }

    public final y a() {
        return new y(this);
    }
}
