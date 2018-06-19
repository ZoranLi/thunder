package anet.channel.strategy;

import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.util.HttpConstant;
import java.util.ArrayList;

/* compiled from: Taobao */
public class HttpDnsAdapter {

    /* compiled from: Taobao */
    public static final class HttpDnsOrigin {
        private final IConnStrategy connStrategy;

        HttpDnsOrigin(IConnStrategy iConnStrategy) {
            this.connStrategy = iConnStrategy;
        }

        public final String getOriginIP() {
            return this.connStrategy.getIp();
        }

        public final int getOriginPort() {
            return this.connStrategy.getPort();
        }

        public final boolean canWithSPDY() {
            String str = this.connStrategy.getProtocol().protocol;
            return (str.equalsIgnoreCase(HttpConstant.HTTP) || str.equalsIgnoreCase("https")) ? false : true;
        }

        public final String toString() {
            return this.connStrategy.toString();
        }
    }

    public static void setHosts(ArrayList<String> arrayList) {
        HttpDispatcher.getInstance().addHosts(arrayList);
    }

    public static HttpDnsOrigin getOriginByHttpDns(String str) {
        str = StrategyCenter.getInstance().getConnStrategyListByHost(str);
        if (str.isEmpty()) {
            return null;
        }
        return new HttpDnsOrigin((IConnStrategy) str.get(0));
    }

    public static ArrayList<HttpDnsOrigin> getOriginsByHttpDns(String str) {
        String<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
        if (connStrategyListByHost.isEmpty()) {
            return null;
        }
        ArrayList<HttpDnsOrigin> arrayList = new ArrayList(connStrategyListByHost.size());
        for (IConnStrategy httpDnsOrigin : connStrategyListByHost) {
            arrayList.add(new HttpDnsOrigin(httpDnsOrigin));
        }
        return arrayList;
    }

    public static String getIpByHttpDns(String str) {
        str = StrategyCenter.getInstance().getConnStrategyListByHost(str);
        if (str.isEmpty()) {
            return null;
        }
        return ((IConnStrategy) str.get(0)).getIp();
    }
}
