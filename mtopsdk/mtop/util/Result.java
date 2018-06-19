package mtopsdk.mtop.util;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = 8852253200756618077L;
    protected String errCode;
    protected String errInfo;
    protected String errType;
    protected Object model;
    protected int statusCode;
    protected boolean success;

    public Result() {
        this.success = true;
    }

    public Result(Object obj) {
        this.success = true;
        this.model = obj;
    }

    public Result(boolean z, String str, String str2) {
        this(z, null, str, str2);
    }

    public Result(boolean z, String str, String str2, String str3) {
        this.success = true;
        this.success = z;
        this.errType = str;
        this.errCode = str2;
        this.errInfo = str3;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrInfo() {
        return this.errInfo;
    }

    public String getErrType() {
        return this.errType;
    }

    public Object getModel() {
        return this.model;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setErrCode(String str) {
        this.errCode = str;
    }

    public void setErrInfo(String str) {
        this.errInfo = str;
    }

    public void setErrType(String str) {
        this.errType = str;
    }

    public void setModel(Object obj) {
        this.model = obj;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
