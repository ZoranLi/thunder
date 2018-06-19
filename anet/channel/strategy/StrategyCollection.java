package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.k.b;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
class StrategyCollection implements Serializable {
    String a;
    StrategyList b = null;
    volatile long c = 0;
    volatile String d = null;
    volatile String e = null;
    boolean f = false;
    private transient long g = 0;

    protected StrategyCollection(String str) {
        this.a = str;
        this.f = DispatchConstants.isAmdcServerDomain(str);
    }

    public void checkInit() {
        if (this.b != null) {
            this.b.checkInit();
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.b == null) {
            return Collections.EMPTY_LIST;
        }
        return this.b.getStrategyList();
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (this.b != null) {
            this.b.notifyConnEvent(iConnStrategy, connEvent);
            if (connEvent.isSuccess == null && this.b.shouldRefresh() != null) {
                iConnStrategy = System.currentTimeMillis();
                if (iConnStrategy - this.g > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.a);
                    this.g = iConnStrategy;
                }
            }
        }
    }

    public String getHostWithEtag() {
        if (TextUtils.isEmpty(this.d)) {
            return this.a;
        }
        StringBuilder stringBuilder = new StringBuilder(this.a);
        stringBuilder.append(':');
        stringBuilder.append(this.d);
        return stringBuilder.toString();
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.c;
    }

    public synchronized void update(b bVar) {
        this.c = System.currentTimeMillis() + (((long) bVar.b) * 1000);
        if (!bVar.a.equalsIgnoreCase(this.a)) {
            ALog.e("StrategyCollection", "update error!", null, "host", this.a, "dnsInfo.host", bVar.a);
        } else if (!bVar.j) {
            this.e = bVar.d;
            this.d = bVar.i;
            if (!(bVar.e == null || bVar.e.length == 0 || bVar.g == null)) {
                if (bVar.g.length != 0) {
                    if (this.b == null) {
                        this.b = new StrategyList();
                    }
                    this.b.update(bVar);
                    return;
                }
            }
            this.b = null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append("\nStrategyList = ");
        stringBuilder.append(this.c);
        if (this.b != null) {
            stringBuilder.append(this.b.toString());
        } else if (this.e != null) {
            stringBuilder.append('[');
            stringBuilder.append(this.a);
            stringBuilder.append("=>");
            stringBuilder.append(this.e);
            stringBuilder.append(']');
        } else {
            stringBuilder.append("[]");
        }
        return stringBuilder.toString();
    }
}
