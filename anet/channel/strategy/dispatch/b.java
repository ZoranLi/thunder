package anet.channel.strategy.dispatch;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
class b {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";
    private static int b = 2;
    private Map<String, Object> a;

    /* compiled from: Taobao */
    private class a implements Runnable {
        final /* synthetic */ b a;
        private Map<String, Object> b;

        a(b bVar, Map<String, Object> map) {
            this.a = bVar;
            this.b = map;
        }

        a(b bVar) {
            this.a = bVar;
        }

        public void run() {
            try {
                Map map = this.b;
                if (map == null) {
                    Map a;
                    synchronized (b.class) {
                        a = this.a.a;
                        this.a.a = null;
                    }
                    map = a;
                }
                if (!NetworkStatusHelper.g()) {
                    return;
                }
                if (GlobalAppRuntimeInfo.getEnv() != map.get("Env")) {
                    ALog.w(b.TAG, "task's env changed", null, new Object[0]);
                } else {
                    c.a(e.a(map));
                }
            } catch (Throwable e) {
                ALog.e(b.TAG, "exec amdc task failed.", null, e, new Object[0]);
            }
        }
    }

    b() {
    }

    public void a(Map<String, Object> map) {
        map.put("Env", GlobalAppRuntimeInfo.getEnv());
        synchronized (this) {
            if (this.a == null) {
                this.a = map;
                map = b;
                b = map - 1;
                ALog.i(TAG, "merge amdc request", null, "delay", Integer.valueOf(map > null ? 500 : 3000));
                anet.channel.strategy.utils.a.a(new a(this), (long) map);
            } else {
                Set set = (Set) this.a.get(DispatchConstants.HOSTS);
                Set set2 = (Set) map.get(DispatchConstants.HOSTS);
                if (map.get("Env") != this.a.get("Env")) {
                    this.a = map;
                } else if (set.size() + set2.size() <= 40) {
                    set2.addAll(set);
                    this.a = map;
                } else {
                    anet.channel.strategy.utils.a.a(new a(this, map));
                }
            }
        }
    }
}
