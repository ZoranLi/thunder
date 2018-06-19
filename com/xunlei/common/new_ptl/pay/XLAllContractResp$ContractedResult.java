package com.xunlei.common.new_ptl.pay;

public class XLAllContractResp$ContractedResult {
    public String bizno;
    public int payType;
    public String signTime;
    public String xunleiId;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("payType:");
        stringBuffer.append(this.payType);
        stringBuffer.append(", bizno:");
        stringBuffer.append(this.bizno);
        stringBuffer.append(", signTime:");
        stringBuffer.append(this.signTime);
        stringBuffer.append(", xunleiId:");
        stringBuffer.append(this.xunleiId);
        return stringBuffer.toString();
    }
}
