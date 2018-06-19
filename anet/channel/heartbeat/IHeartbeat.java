package anet.channel.heartbeat;

/* compiled from: Taobao */
public interface IHeartbeat {
    long getInterval();

    void heartbeat();

    void reSchedule();

    void start();

    void stop();
}
