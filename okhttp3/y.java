package okhttp3;

import java.util.Arrays;
import java.util.Collections;
import javax.annotation.Nullable;

/* compiled from: Headers */
public final class y {
    public final String[] a;

    y(a aVar) {
        this.a = (String[]) aVar.a.toArray(new String[aVar.a.size()]);
    }

    private y(String[] strArr) {
        this.a = strArr;
    }

    @Nullable
    public final String a(String str) {
        String[] strArr = this.a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final String a(int i) {
        return this.a[i * 2];
    }

    public final String b(int i) {
        return this.a[(i * 2) + 1];
    }

    public final a a() {
        a aVar = new a();
        Collections.addAll(aVar.a, this.a);
        return aVar;
    }

    public final boolean equals(@Nullable Object obj) {
        return (!(obj instanceof y) || Arrays.equals(((y) obj).a, this.a) == null) ? null : true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = this.a.length / 2;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(a(i));
            stringBuilder.append(": ");
            stringBuilder.append(b(i));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static y a(String... strArr) {
        int i;
        strArr = (String[]) strArr.clone();
        for (i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr[i] = strArr[i].trim();
        }
        i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            if (str.length() != 0 && str.indexOf(0) == -1) {
                if (str2.indexOf(0) == -1) {
                    i += 2;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Unexpected header: ");
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return new y(strArr);
    }
}
