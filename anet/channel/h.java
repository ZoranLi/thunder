package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.entity.EventType;
import anet.channel.entity.d;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* compiled from: Taobao */
class h implements EventCb {
    final /* synthetic */ Session a;
    final /* synthetic */ SessionRequest b;

    h(SessionRequest sessionRequest, Session session) {
        this.b = sessionRequest;
        this.a = session;
    }

    public void onEvent(Session session, EventType eventType, d dVar) {
        ALog.d("awcn.SessionRequest", "Receive session event", null, "type", eventType);
        session = new ConnEvent();
        if (eventType == EventType.AUTH_SUCC) {
            session.isSuccess = true;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.a.getRealHost(), this.a.getConnStrategy(), session);
    }
}
