package mtopsdk.mtop.unit;

import java.io.Serializable;
import mtopsdk.mtop.domain.b;

public class ApiInfo implements Serializable, b {
    private static final long serialVersionUID = -1408374287101501181L;
    public String api;
    public String v;

    public ApiInfo(String str, String str2) {
        this.api = str;
        this.v = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApiInfo apiInfo = (ApiInfo) obj;
        if (this.api == null) {
            if (apiInfo.api != null) {
                return false;
            }
        } else if (!this.api.equalsIgnoreCase(apiInfo.api)) {
            return false;
        }
        if (this.v == null) {
            if (apiInfo.v != null) {
                return false;
            }
        } else if (!this.v.equalsIgnoreCase(apiInfo.v)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.api == null ? 0 : this.api.hashCode()) + 31) * 31;
        if (this.v != null) {
            i = this.v.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ApiInfo [");
        stringBuilder.append("api=");
        stringBuilder.append(this.api);
        stringBuilder.append(", v=");
        stringBuilder.append(this.v);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
