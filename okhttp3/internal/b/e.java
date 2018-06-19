package okhttp3.internal.b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import okhttp3.internal.c;

/* compiled from: HttpDate */
final class e extends ThreadLocal<DateFormat> {
    e() {
    }

    protected final /* synthetic */ Object initialValue() {
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(c.f);
        return simpleDateFormat;
    }
}
