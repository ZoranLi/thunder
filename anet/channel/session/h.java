package anet.channel.session;

import anet.channel.entity.EventType;
import anet.channel.util.ALog;

/* compiled from: Taobao */
class h implements Runnable {
    final /* synthetic */ TnetSpdySession a;

    h(TnetSpdySession tnetSpdySession) {
        this.a = tnetSpdySession;
    }

    public void run() {
        if (this.a.mHasUnrevPing) {
            ALog.e("awcn.TnetSpdySession", "send msg time out!", this.a.mSeq, "pingUnRcv:", Boolean.valueOf(this.a.mHasUnrevPing));
            try {
                this.a.handleCallbacks(EventType.DATA_TIMEOUT, null);
                if (this.a.mSessionStat != null) {
                    this.a.mSessionStat.closeReason = "ping time out";
                }
                this.a.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
