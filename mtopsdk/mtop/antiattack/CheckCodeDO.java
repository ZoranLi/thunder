package mtopsdk.mtop.antiattack;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.Serializable;
import java.util.Map;
import mtopsdk.common.util.i;
import mtopsdk.mtop.domain.b;

public class CheckCodeDO implements Serializable, b {
    public static final String CHECKCODE_CHECK_URL_KEY = "check";
    public static final String CHECKCODE_IMAGE_URL_KEY = "image";
    public static final String CHECKCODE_USER_INPUT_KEY = "code";
    private static final long serialVersionUID = 1095959954944984636L;
    public Map checkParams;
    public String checkPath;
    public String imageUrl;

    public enum CheckCodeFieldEnum {
        APPLY("app"),
        BACK("back"),
        HOW("how"),
        IP("ip"),
        RAND("rand"),
        SESSION("session"),
        V("v"),
        W(IXAdRequestInfo.WIDTH),
        NATIVE("native");
        
        private String field;

        private CheckCodeFieldEnum(String str) {
            this.field = str;
        }

        public final String getField() {
            return this.field;
        }
    }

    public boolean isValid() {
        if (!(i.b(this.imageUrl) || i.b(this.checkPath))) {
            if (this.checkParams != null) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("CheckCodeDO [imageUrl=");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append(", checkPath=");
        stringBuilder.append(this.checkPath);
        stringBuilder.append(", checkParams=");
        stringBuilder.append(this.checkParams);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
