package anet.channel;

/* compiled from: Taobao */
public class NoNetworkException extends Exception {
    private SessionRequest a;

    public NoNetworkException(SessionRequest sessionRequest) {
        this.a = sessionRequest;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NoNetwork ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }
}
