package anet.channel;

import anet.channel.SessionRequest.AnonymousClass1;
import anet.channel.entity.EventCb;
import anet.channel.entity.EventType;
import anet.channel.entity.d;
import anet.channel.util.ALog;

/* compiled from: Taobao */
class g implements EventCb {
    final /* synthetic */ IConnCb a;
    final /* synthetic */ long b;
    final /* synthetic */ SessionRequest c;

    g(SessionRequest sessionRequest, IConnCb iConnCb, long j) {
        this.c = sessionRequest;
        this.a = iConnCb;
        this.b = j;
    }

    public void onEvent(Session session, EventType eventType, d dVar) {
        g gVar = this;
        Session session2 = session;
        EventType eventType2 = eventType;
        d dVar2 = dVar;
        if (session2 != null) {
            if (eventType2 != null) {
                String str;
                int i = dVar2 == null ? 0 : dVar2.d;
                if (dVar2 == null) {
                    str = "";
                } else {
                    str = dVar2.e;
                }
                switch (AnonymousClass1.a[eventType.ordinal()]) {
                    case 1:
                        ALog.d("awcn.SessionRequest", null, session2 != null ? session2.mSeq : null, "Session", session2, "EventType", eventType2, "Event", dVar2);
                        gVar.c.a(session2, 0, null);
                        gVar.a.onSuccess(session2, gVar.b);
                        return;
                    case 2:
                        ALog.d("awcn.SessionRequest", null, session2 != null ? session2.mSeq : null, "Session", session2, "EventType", eventType2, "Event", dVar2);
                        gVar.c.a(session2, i, str);
                        if (gVar.c.c.c(gVar.c, session2)) {
                            gVar.a.onDisConnect(session2, gVar.b, eventType2);
                            return;
                        } else {
                            gVar.a.onFailed(session2, gVar.b, eventType2, i);
                            return;
                        }
                    case 3:
                        ALog.d("awcn.SessionRequest", null, session2 != null ? session2.mSeq : null, "Session", session2, "EventType", eventType2, "Event", dVar2);
                        gVar.c.a(session2, i, str);
                        gVar.a.onFailed(session2, gVar.b, eventType2, i);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
