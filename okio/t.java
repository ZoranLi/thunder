package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* compiled from: SegmentPool */
final class t {
    @Nullable
    static s a;
    static long b;

    private t() {
    }

    static s a() {
        synchronized (t.class) {
            if (a != null) {
                s sVar = a;
                a = sVar.f;
                sVar.f = null;
                b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return sVar;
            }
            return new s();
        }
    }

    static void a(s sVar) {
        if (sVar.f == null) {
            if (sVar.g == null) {
                if (!sVar.d) {
                    synchronized (t.class) {
                        if (b + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                            return;
                        }
                        b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                        sVar.f = a;
                        sVar.c = 0;
                        sVar.b = 0;
                        a = sVar;
                        return;
                    }
                }
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
