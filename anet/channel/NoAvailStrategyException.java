package anet.channel;

/* compiled from: Taobao */
public class NoAvailStrategyException extends Exception {
    private SessionRequest a;

    public NoAvailStrategyException(SessionRequest sessionRequest) {
        this.a = sessionRequest;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("No Available Strategy");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }
}
