package mtopsdk.mtop.unit;

import java.io.Serializable;
import java.util.HashSet;
import mtopsdk.mtop.domain.b;

public class ApiUnit implements Serializable, b {
    private static final long serialVersionUID = -1592946625198742908L;
    public HashSet apilist;
    public String version;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ApiUnit [");
        stringBuilder.append("version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", apilist=");
        stringBuilder.append(this.apilist);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
