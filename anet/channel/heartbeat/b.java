package anet.channel.heartbeat;

import anet.channel.Session;

/* compiled from: Taobao */
final class b implements IHeartbeatFactory {
    b() {
    }

    public final IHeartbeat createHeartbeat(Session session) {
        if (!(session == null || session.getConnStrategy() == null)) {
            if (session.getConnStrategy().getHeartbeat() > 0) {
                return new a(session);
            }
        }
        return null;
    }
}
