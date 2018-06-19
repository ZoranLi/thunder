package com.taobao.accs.net;

import anet.channel.entity.ConnType;
import anet.channel.entity.ConnType.TypeLevel;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class h {
    private int a = 0;
    private List<IConnStrategy> b = new ArrayList();

    public h(String str) {
        HttpDispatcher.getInstance().addListener(new i(this));
        a(str);
    }

    public List<IConnStrategy> a(String str) {
        if (this.a == 0 || this.b.isEmpty()) {
            String<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
            if (!(connStrategyListByHost == null || connStrategyListByHost.isEmpty())) {
                this.b.clear();
                for (IConnStrategy iConnStrategy : connStrategyListByHost) {
                    ConnType valueOf = ConnType.valueOf(iConnStrategy.getProtocol());
                    if (valueOf.getTypeLevel() == TypeLevel.SPDY && valueOf.isSSL()) {
                        this.b.add(iConnStrategy);
                    }
                }
            }
        }
        return this.b;
    }

    public IConnStrategy a() {
        return a(this.b);
    }

    public IConnStrategy a(List<IConnStrategy> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (this.a < 0 || this.a >= list.size()) {
                    this.a = 0;
                }
                return (IConnStrategy) list.get(this.a);
            }
        }
        ALog.d("HttpDnsProvider", "strategys null or 0", new Object[0]);
        return null;
    }

    public void b() {
        this.a++;
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder = new StringBuilder("updateStrategyPos StrategyPos:");
            stringBuilder.append(this.a);
            ALog.d("HttpDnsProvider", stringBuilder.toString(), new Object[0]);
        }
    }

    public int c() {
        return this.a;
    }

    public void b(String str) {
        StrategyCenter.getInstance().forceRefreshStrategy(str);
    }
}
