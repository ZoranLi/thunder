package mtopsdk.mtop.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import mtopsdk.common.util.i;
import mtopsdk.mtop.util.a;
import mtopsdk.mtop.util.h;
import org.json.JSONObject;

public class MtopResponse implements Serializable, b {
    private static final String SHARP = "::";
    private static final String TAG = "mtopsdk.MtopResponse";
    private static final long serialVersionUID = 1566423746968673499L;
    private String api;
    private volatile boolean bParsed = false;
    private byte[] bytedata;
    private byte[] data;
    private JSONObject dataJsonObject;
    private Map headerFields;
    private h mtopStat;
    private int responseCode;
    private ResponseSource responseSource = ResponseSource.NETWORK_REQUEST;
    private String[] ret;
    private String retCode;
    private String retMsg;
    private String v;

    public enum ResponseSource {
        FRESH_CACHE,
        EXPIRED_CACHE,
        NETWORK_REQUEST
    }

    public MtopResponse(String str, String str2) {
        this.retCode = str;
        this.retMsg = str2;
    }

    public MtopResponse(String str, String str2, String str3, String str4) {
        this.api = str;
        this.v = str2;
        this.retCode = str3;
        this.retMsg = str4;
    }

    private void parserRet(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            String str = strArr[0];
            if (i.a(str)) {
                strArr = str.split(SHARP);
                if (strArr != null && strArr.length > 1) {
                    this.retCode = strArr[0];
                    this.retMsg = strArr[1];
                }
            }
        }
    }

    public String getApi() {
        if (this.api == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.api;
    }

    public byte[] getBytedata() {
        return this.bytedata;
    }

    public byte[] getData() {
        return this.data;
    }

    public JSONObject getDataJsonObject() {
        if (this.dataJsonObject == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.dataJsonObject;
    }

    public String getFullKey() {
        if (!i.b(this.api)) {
            if (!i.b(this.v)) {
                return i.a(this.api, this.v);
            }
        }
        return null;
    }

    public Map getHeaderFields() {
        return this.headerFields;
    }

    public h getMtopStat() {
        return this.mtopStat;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String[] getRet() {
        if (this.ret == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.ret;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        if (this.retMsg == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.retMsg;
    }

    public ResponseSource getSource() {
        return this.responseSource;
    }

    public String getV() {
        if (this.v == null && !this.bParsed) {
            parseJsonByte();
        }
        return this.v;
    }

    public boolean is41XResult() {
        return a.h(getRetCode());
    }

    public boolean isApiLockedResult() {
        return a.i(getRetCode());
    }

    public boolean isApiSuccess() {
        return a.g(getRetCode()) && getBytedata() != null;
    }

    public boolean isExpiredRequest() {
        return a.j(getRetCode());
    }

    public boolean isIllegelSign() {
        return a.f(getRetCode());
    }

    public boolean isMtopSdkError() {
        return a.b(getRetCode());
    }

    public boolean isMtopServerError() {
        return a.k(getRetCode());
    }

    public boolean isNetworkError() {
        return a.c(getRetCode());
    }

    public boolean isNoNetwork() {
        return a.d(getRetCode());
    }

    public boolean isSessionInvalid() {
        return a.e(getRetCode());
    }

    public boolean isSystemError() {
        return a.a(getRetCode());
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setBytedata(byte[] bArr) {
        this.bytedata = bArr;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDataJsonObject(JSONObject jSONObject) {
        this.dataJsonObject = jSONObject;
    }

    public void setHeaderFields(Map map) {
        this.headerFields = map;
    }

    public void setMtopStat(h hVar) {
        this.mtopStat = hVar;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public void setRet(String[] strArr) {
        this.ret = strArr;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetMsg(String str) {
        this.retMsg = str;
    }

    public void setSource(ResponseSource responseSource) {
        this.responseSource = responseSource;
    }

    public void setV(String str) {
        this.v = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MtopResponse");
        try {
            stringBuilder.append("[api=");
            stringBuilder.append(this.api);
            stringBuilder.append(",v=");
            stringBuilder.append(this.v);
            stringBuilder.append(",responseCode=");
            stringBuilder.append(this.responseCode);
            stringBuilder.append(",headerFields=");
            stringBuilder.append(this.headerFields);
            stringBuilder.append(",retCode=");
            stringBuilder.append(this.retCode);
            stringBuilder.append(",retMsg=");
            stringBuilder.append(this.retMsg);
            stringBuilder.append(",ret=");
            stringBuilder.append(Arrays.toString(this.ret));
            stringBuilder.append(",data=");
            stringBuilder.append(this.dataJsonObject);
            stringBuilder.append(",bytedata=");
            stringBuilder.append(this.bytedata == null ? null : new String(this.bytedata));
            stringBuilder.append("]");
            return stringBuilder.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return super.toString();
        }
    }

    public void parseJsonByte() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.bParsed;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        monitor-enter(r7);
        r0 = r7.bParsed;	 Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x000c;	 Catch:{ all -> 0x00ea }
    L_0x000a:
        monitor-exit(r7);	 Catch:{ all -> 0x00ea }
        return;	 Catch:{ all -> 0x00ea }
    L_0x000c:
        r0 = r7.bytedata;	 Catch:{ all -> 0x00ea }
        r1 = 1;	 Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x00b9;	 Catch:{ all -> 0x00ea }
    L_0x0011:
        r0 = r7.bytedata;	 Catch:{ all -> 0x00ea }
        r0 = r0.length;	 Catch:{ all -> 0x00ea }
        if (r0 != 0) goto L_0x0018;
    L_0x0016:
        goto L_0x00b9;
    L_0x0018:
        r0 = new java.lang.String;	 Catch:{ Throwable -> 0x0083 }
        r2 = r7.bytedata;	 Catch:{ Throwable -> 0x0083 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0083 }
        r2 = mtopsdk.common.util.TBSdkLog$LogEnable.DebugEnable;	 Catch:{ Throwable -> 0x0083 }
        r2 = mtopsdk.common.util.j.a(r2);	 Catch:{ Throwable -> 0x0083 }
        if (r2 == 0) goto L_0x0038;	 Catch:{ Throwable -> 0x0083 }
    L_0x0027:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0083 }
        r3 = "[parseJsonByte]response : ";	 Catch:{ Throwable -> 0x0083 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0083 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0083 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0083 }
        mtopsdk.common.util.j.a(r2);	 Catch:{ Throwable -> 0x0083 }
    L_0x0038:
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0083 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0083 }
        r0 = r7.api;	 Catch:{ Throwable -> 0x0083 }
        if (r0 != 0) goto L_0x0049;	 Catch:{ Throwable -> 0x0083 }
    L_0x0041:
        r0 = "api";	 Catch:{ Throwable -> 0x0083 }
        r0 = r2.getString(r0);	 Catch:{ Throwable -> 0x0083 }
        r7.api = r0;	 Catch:{ Throwable -> 0x0083 }
    L_0x0049:
        r0 = r7.v;	 Catch:{ Throwable -> 0x0083 }
        if (r0 != 0) goto L_0x0055;	 Catch:{ Throwable -> 0x0083 }
    L_0x004d:
        r0 = "v";	 Catch:{ Throwable -> 0x0083 }
        r0 = r2.getString(r0);	 Catch:{ Throwable -> 0x0083 }
        r7.v = r0;	 Catch:{ Throwable -> 0x0083 }
    L_0x0055:
        r0 = "ret";	 Catch:{ Throwable -> 0x0083 }
        r0 = r2.getJSONArray(r0);	 Catch:{ Throwable -> 0x0083 }
        r3 = r0.length();	 Catch:{ Throwable -> 0x0083 }
        r4 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x0083 }
        r7.ret = r4;	 Catch:{ Throwable -> 0x0083 }
        r4 = 0;	 Catch:{ Throwable -> 0x0083 }
    L_0x0064:
        if (r4 >= r3) goto L_0x0071;	 Catch:{ Throwable -> 0x0083 }
    L_0x0066:
        r5 = r7.ret;	 Catch:{ Throwable -> 0x0083 }
        r6 = r0.getString(r4);	 Catch:{ Throwable -> 0x0083 }
        r5[r4] = r6;	 Catch:{ Throwable -> 0x0083 }
        r4 = r4 + 1;	 Catch:{ Throwable -> 0x0083 }
        goto L_0x0064;	 Catch:{ Throwable -> 0x0083 }
    L_0x0071:
        r0 = r7.ret;	 Catch:{ Throwable -> 0x0083 }
        r7.parserRet(r0);	 Catch:{ Throwable -> 0x0083 }
        r0 = "data";	 Catch:{ Throwable -> 0x0083 }
        r0 = r2.optJSONObject(r0);	 Catch:{ Throwable -> 0x0083 }
        r7.dataJsonObject = r0;	 Catch:{ Throwable -> 0x0083 }
        r7.bParsed = r1;	 Catch:{ all -> 0x00ea }
        goto L_0x00b4;
    L_0x0081:
        r0 = move-exception;
        goto L_0x00b6;
    L_0x0083:
        r0 = r7.mtopStat;	 Catch:{ all -> 0x0081 }
        if (r0 == 0) goto L_0x008c;	 Catch:{ all -> 0x0081 }
    L_0x0087:
        r0 = r7.mtopStat;	 Catch:{ all -> 0x0081 }
        r0 = r0.q;	 Catch:{ all -> 0x0081 }
        goto L_0x008d;	 Catch:{ all -> 0x0081 }
    L_0x008c:
        r0 = 0;	 Catch:{ all -> 0x0081 }
    L_0x008d:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r3 = "[parseJsonByte] parse bytedata error ---api=";	 Catch:{ all -> 0x0081 }
        r2.<init>(r3);	 Catch:{ all -> 0x0081 }
        r3 = r7.api;	 Catch:{ all -> 0x0081 }
        r2.append(r3);	 Catch:{ all -> 0x0081 }
        r3 = ",v=";	 Catch:{ all -> 0x0081 }
        r2.append(r3);	 Catch:{ all -> 0x0081 }
        r3 = r7.v;	 Catch:{ all -> 0x0081 }
        r2.append(r3);	 Catch:{ all -> 0x0081 }
        r2 = r2.toString();	 Catch:{ all -> 0x0081 }
        mtopsdk.common.util.j.d(r0, r2);	 Catch:{ all -> 0x0081 }
        r0 = "ANDROID_SYS_JSONDATA_PARSE_ERROR";	 Catch:{ all -> 0x0081 }
        r7.retCode = r0;	 Catch:{ all -> 0x0081 }
        r0 = "解析JSONDATA错误";	 Catch:{ all -> 0x0081 }
        r7.retMsg = r0;	 Catch:{ all -> 0x0081 }
        r7.bParsed = r1;	 Catch:{ all -> 0x00ea }
    L_0x00b4:
        monitor-exit(r7);	 Catch:{ all -> 0x00ea }
        return;	 Catch:{ all -> 0x00ea }
    L_0x00b6:
        r7.bParsed = r1;	 Catch:{ all -> 0x00ea }
        throw r0;	 Catch:{ all -> 0x00ea }
    L_0x00b9:
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.WarnEnable;	 Catch:{ all -> 0x00ea }
        r0 = mtopsdk.common.util.j.a(r0);	 Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x00de;	 Catch:{ all -> 0x00ea }
    L_0x00c1:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ea }
        r2 = "[parseJsonByte]bytedata is blank ---api=";	 Catch:{ all -> 0x00ea }
        r0.<init>(r2);	 Catch:{ all -> 0x00ea }
        r2 = r7.api;	 Catch:{ all -> 0x00ea }
        r0.append(r2);	 Catch:{ all -> 0x00ea }
        r2 = ",v=";	 Catch:{ all -> 0x00ea }
        r0.append(r2);	 Catch:{ all -> 0x00ea }
        r2 = r7.v;	 Catch:{ all -> 0x00ea }
        r0.append(r2);	 Catch:{ all -> 0x00ea }
        r0 = r0.toString();	 Catch:{ all -> 0x00ea }
        mtopsdk.common.util.j.c(r0);	 Catch:{ all -> 0x00ea }
    L_0x00de:
        r0 = "ANDROID_SYS_JSONDATA_BLANK";	 Catch:{ all -> 0x00ea }
        r7.retCode = r0;	 Catch:{ all -> 0x00ea }
        r0 = "返回JSONDATA为空";	 Catch:{ all -> 0x00ea }
        r7.retMsg = r0;	 Catch:{ all -> 0x00ea }
        r7.bParsed = r1;	 Catch:{ all -> 0x00ea }
        monitor-exit(r7);	 Catch:{ all -> 0x00ea }
        return;
    L_0x00ea:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.domain.MtopResponse.parseJsonByte():void");
    }
}
