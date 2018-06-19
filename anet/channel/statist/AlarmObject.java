package anet.channel.statist;

/* compiled from: Taobao */
public class AlarmObject {
    public String arg;
    public String errorCode;
    public String errorMsg;
    public boolean isSuccess;
    public String module;
    public String modulePoint;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("[module:");
        stringBuilder.append(this.module);
        stringBuilder.append(" modulePoint:");
        stringBuilder.append(this.modulePoint);
        stringBuilder.append(" arg:");
        stringBuilder.append(this.arg);
        stringBuilder.append(" isSuccess:");
        stringBuilder.append(this.isSuccess);
        stringBuilder.append(" errorCode:");
        stringBuilder.append(this.errorCode);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
