package mtopsdk.a.b;

import java.io.Serializable;
import mtopsdk.common.util.i;

public final class a implements Serializable, Cloneable {
    public String a;

    public final String a() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("isRequestSuccess=false");
        stringBuilder.append(",host=");
        stringBuilder.append(null);
        stringBuilder.append(",ip_port=");
        stringBuilder.append(null);
        stringBuilder.append(",isSSL=false");
        stringBuilder.append(",connType=");
        stringBuilder.append(null);
        stringBuilder.append(",oneWayTime_ANet=0");
        stringBuilder.append(",postBodyTime=0");
        stringBuilder.append(",firstDataTime=0");
        stringBuilder.append(",recDataTime=0");
        stringBuilder.append(",serverRT=0");
        stringBuilder.append(",rtt=0");
        stringBuilder.append(",sendSize=0");
        stringBuilder.append(",totalSize=0");
        stringBuilder.append(",dataSpeed=0");
        stringBuilder.append(",retryTime=0");
        return stringBuilder.toString();
    }

    public final String toString() {
        if (i.b(this.a)) {
            this.a = a();
        }
        StringBuilder stringBuilder = new StringBuilder("NetworkStats [");
        stringBuilder.append(this.a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
