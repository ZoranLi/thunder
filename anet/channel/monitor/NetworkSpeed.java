package anet.channel.monitor;

/* compiled from: Taobao */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);
    
    private final String a;
    private final int b;

    private NetworkSpeed(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final String getDesc() {
        return this.a;
    }

    public final int getCode() {
        return this.b;
    }

    public static NetworkSpeed valueOfCode(int i) {
        return i == 1 ? Slow : Fast;
    }
}
