package anet.channel.statist;

/* compiled from: Taobao */
public class CountObject {
    public String arg;
    public String module;
    public String modulePoint;
    public double value;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("[module:");
        stringBuilder.append(this.module);
        stringBuilder.append(" modulePoint:");
        stringBuilder.append(this.modulePoint);
        stringBuilder.append(" arg:");
        stringBuilder.append(this.arg);
        stringBuilder.append(" value:");
        stringBuilder.append(this.value);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
