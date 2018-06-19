package anet.channel.strategy;

/* compiled from: Taobao */
public class ConnEvent {
    public long connTime = Long.MAX_VALUE;
    public boolean isSuccess = false;

    public String toString() {
        return this.isSuccess ? "ConnEvent#Success" : "ConnEvent#Fail";
    }
}
