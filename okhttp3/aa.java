package okhttp3;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: MediaType */
public final class aa {
    private static final Pattern c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final String a;
    public final String b;
    private final String e;
    @Nullable
    private final String f;

    private aa(String str, String str2, String str3, @Nullable String str4) {
        this.e = str;
        this.a = str2;
        this.b = str3;
        this.f = str4;
    }

    @Nullable
    public static aa a(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = d.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                group = matcher2.group(2);
                if (group == null) {
                    group = matcher2.group(3);
                } else if (group.startsWith("'") && group.endsWith("'") && group.length() > 2) {
                    group = group.substring(1, group.length() - 1);
                }
                if (str2 != null && !group.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group;
            }
        }
        return new aa(str, toLowerCase, toLowerCase2, str2);
    }

    public final String toString() {
        return this.e;
    }

    public final boolean equals(@Nullable Object obj) {
        return (!(obj instanceof aa) || ((aa) obj).e.equals(this.e) == null) ? null : true;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }
}
