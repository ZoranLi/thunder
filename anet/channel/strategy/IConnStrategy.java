package anet.channel.strategy;

/* compiled from: Taobao */
public interface IConnStrategy {
    int getConnectionTimeout();

    int getHeartbeat();

    String getIp();

    int getIpType();

    int getPort();

    ConnProtocol getProtocol();

    int getReadTimeout();

    int getRetryTimes();
}
