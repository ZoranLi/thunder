package com.xunlei.common.new_ptl.pay.c;

import com.qq.e.comm.constants.Constants.KEYS;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.pay.XLAllContractResp$ContractedResult;
import com.xunlei.common.new_ptl.pay.XLContractor$XLContractStatus;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.b.a.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: XLContractQueryTask */
final class b$1 extends b {
    private /* synthetic */ b a;

    b$1(b bVar) {
        this.a = bVar;
    }

    public final void a(String str) {
        String g = b.g();
        StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder buffer = ");
        stringBuilder.append(str);
        XLLog.v(g, stringBuilder.toString());
        try {
            JSONObject jSONObject = new JSONObject(XLUtilTools.parseJSONPString(str));
            if (jSONObject.optInt(KEYS.RET, XLPayErrorCode.XLP_CONTRACT_QUERY_ERROR) == -1) {
                b.a(this.a, jSONObject.optString("msg"));
                b.a(this.a, jSONObject.optInt("errcode", XLPayErrorCode.XLP_CONTRACT_QUERY_ERROR), 0, null);
                return;
            }
            List list;
            str = jSONObject.getJSONObject("data");
            String optString = str.optString("status");
            int i = XLContractor$XLContractStatus.XL_CONTRACT_SYSTEMERROR;
            if ("UNSIGN".compareTo(optString) == 0) {
                i = XLContractor$XLContractStatus.XL_CONTRACT_NO;
            }
            if ("SIGN".compareTo(optString) == 0) {
                i = XLContractor$XLContractStatus.XL_CONTRACT_NORMAL;
            }
            str = str.optJSONArray("agreement");
            if (str == null || str.length() <= 0) {
                list = null;
            } else {
                list = new ArrayList();
                for (int i2 = 0; i2 < str.length(); i2++) {
                    JSONObject optJSONObject = str.optJSONObject(i2);
                    if (optJSONObject != null) {
                        XLAllContractResp$ContractedResult xLAllContractResp$ContractedResult = new XLAllContractResp$ContractedResult();
                        xLAllContractResp$ContractedResult.bizno = optJSONObject.optString("bizno");
                        xLAllContractResp$ContractedResult.signTime = optJSONObject.optString("signTime");
                        xLAllContractResp$ContractedResult.payType = XLPayType.getPayTypeInt(optJSONObject.optString("payType"));
                        xLAllContractResp$ContractedResult.xunleiId = optJSONObject.optString("xunleiId");
                        list.add(xLAllContractResp$ContractedResult);
                    }
                }
            }
            b.a(this.a, 0, i, list);
        } catch (String str2) {
            str2.printStackTrace();
            XLLog.e(b.g(), "getPayBusinessOrder json error.");
            b.a(this.a, 1);
            b.a(this.a, XLPayErrorCode.XLP_CONTRACT_QUERY_ERROR, 0, null);
        }
    }

    public final void a(Throwable th) {
        String g = b.g();
        StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e(g, stringBuilder.toString());
        b.a(this.a, h.a(th), 0, null);
    }
}
