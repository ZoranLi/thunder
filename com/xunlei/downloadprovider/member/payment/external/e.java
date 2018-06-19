package com.xunlei.downloadprovider.member.payment.external;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.bean.PayConfigurationParam;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PayConfigurationParser */
public final class e {
    public static ArrayList<PayConfigurationParam> a(String str) throws Exception {
        JSONArray jSONArray = new JSONArray(str);
        str = jSONArray.length();
        ArrayList<PayConfigurationParam> arrayList = new ArrayList(str);
        for (int i = 0; i < str; i++) {
            PayConfigurationParam payConfigurationParam = new PayConfigurationParam();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            payConfigurationParam.id = jSONObject.optString(AgooConstants.MESSAGE_ID);
            payConfigurationParam.order = jSONObject.optString("order");
            payConfigurationParam.member = jSONObject.optString("member");
            payConfigurationParam.limit = jSONObject.optString("limit");
            payConfigurationParam.limittype = jSONObject.optString("limittype");
            payConfigurationParam.limitdays = jSONObject.optString("limitdays");
            payConfigurationParam.limitdays2 = jSONObject.optString("limitdays2");
            payConfigurationParam.limittype2 = jSONObject.optString("limittype2");
            payConfigurationParam.op = jSONObject.optString("op");
            payConfigurationParam.vastype = jSONObject.optString("vastype");
            payConfigurationParam.showMonth = jSONObject.optString("show_month");
            payConfigurationParam.recommondMonth = PayUtil.d(jSONObject.optString("recommond_month")).intValue();
            payConfigurationParam.recommondUpMonth = PayUtil.d(jSONObject.optString("recommond_upmonth")).intValue();
            payConfigurationParam.mode = jSONObject.optString(Constants.KEY_MODE);
            payConfigurationParam.tips = jSONObject.optString("tips");
            arrayList.add(payConfigurationParam);
        }
        return arrayList;
    }

    public static PayConfigurationParam a(ArrayList<PayConfigurationParam> arrayList, int i, PayAction payAction) {
        if (arrayList != null) {
            if (arrayList.size() != 0) {
                int i2;
                int size = arrayList.size();
                j a = j.a();
                int d = a.d();
                int i3 = 0;
                if (d == 0) {
                    i2 = 1;
                } else if (d == 5) {
                    i2 = !a.c() ? 10 : a.e() ? 7 : 4;
                } else if (d != 204) {
                    switch (d) {
                        case 2:
                            if (a.c()) {
                                if (!a.e()) {
                                    i2 = 2;
                                    break;
                                }
                                i2 = 5;
                                break;
                            }
                            i2 = 8;
                            break;
                        case 3:
                            if (a.c()) {
                                if (!a.e()) {
                                    i2 = 3;
                                    break;
                                }
                                i2 = 6;
                                break;
                            }
                            i2 = 9;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                } else {
                    i2 = 11;
                }
                if (payAction != null) {
                    for (d = 0; d < size; d++) {
                        PayConfigurationParam payConfigurationParam = (PayConfigurationParam) arrayList.get(d);
                        if (i2 == payConfigurationParam.getMember() && payAction.a == payConfigurationParam.getVastype() && payAction.b.toXLSdkOrderType() == payConfigurationParam.getOp()) {
                            if (!(TextUtils.isEmpty(payConfigurationParam.getShowMonth()) != null || payConfigurationParam.getShowMonth().contains(String.valueOf(payAction.c)) == null || payAction.b == PayUtil$OrderType.UPGRADE)) {
                                payConfigurationParam.recommondMonth = payAction.c;
                            }
                            return payConfigurationParam;
                        }
                    }
                }
                while (i3 < size) {
                    PayConfigurationParam payConfigurationParam2 = (PayConfigurationParam) arrayList.get(i3);
                    if (i2 == payConfigurationParam2.getMember()) {
                        if (i2 == 1) {
                            return payConfigurationParam2;
                        }
                        if (payConfigurationParam2.getLimit() == 1 && a(payConfigurationParam2, PayUtil.b(j.a().f()))) {
                            return payConfigurationParam2;
                        }
                        if (payConfigurationParam2.getLimit() == 2 && a(payConfigurationParam2, (long) i)) {
                            return payConfigurationParam2;
                        }
                    }
                    i3++;
                }
                return null;
            }
        }
        return null;
    }

    private static boolean a(PayConfigurationParam payConfigurationParam, long j) {
        if (payConfigurationParam.getLimittype() == 1 && j < ((long) payConfigurationParam.getLimitdays())) {
            return true;
        }
        if (payConfigurationParam.getLimittype() == 2) {
            if (payConfigurationParam.getLimittype2() == -1 && j >= ((long) payConfigurationParam.getLimitdays())) {
                return true;
            }
            if (payConfigurationParam.getLimittype2() == 1 && PayUtil.a((int) j, payConfigurationParam.getLimitdays(), payConfigurationParam.getLimitdays2()) != null) {
                return true;
            }
        }
        return null;
    }
}
