package anet.channel.request;

import org.android.spdy.SpdySession;

/* compiled from: Taobao */
public class TnetCancelable implements Cancelable {
    public static final TnetCancelable NULL = new TnetCancelable(null, 0, null);
    private final String seq;
    private final SpdySession spdySession;
    private final int streamId;

    public void cancel() {
    }

    public TnetCancelable(SpdySession spdySession, int i, String str) {
        this.spdySession = spdySession;
        this.streamId = i;
        this.seq = str;
    }
}
