package mtopsdk.mtop.domain;

import java.io.Serializable;
import java.util.Map;
import mtopsdk.common.util.i;

public class MtopRequest implements Serializable, b {
    private static final long serialVersionUID = -439476282014493612L;
    private String apiName;
    private String data = "{}";
    public Map dataParams;
    private boolean needEcode;
    private boolean needSession;
    private String version;

    public String getApiName() {
        return this.apiName;
    }

    public String getData() {
        return this.data;
    }

    public String getKey() {
        if (!i.b(this.apiName)) {
            if (!i.b(this.version)) {
                return i.a(this.apiName, this.version);
            }
        }
        return null;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isLegalRequest() {
        return i.a(this.apiName) && i.a(this.version) && i.a(this.data);
    }

    public boolean isNeedEcode() {
        return this.needEcode;
    }

    public boolean isNeedSession() {
        return this.needSession;
    }

    public void setApiName(String str) {
        this.apiName = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setNeedEcode(boolean z) {
        this.needEcode = z;
    }

    public void setNeedSession(boolean z) {
        this.needSession = z;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MtopRequest [");
        stringBuilder.append(" apiName=");
        stringBuilder.append(this.apiName);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", data=");
        stringBuilder.append(this.data);
        stringBuilder.append(", needEcode=");
        stringBuilder.append(this.needEcode);
        stringBuilder.append(", needSession=");
        stringBuilder.append(this.needSession);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
