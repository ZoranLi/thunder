package com.xunlei.downloadprovider.member.payment.bean;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.e.comm.constants.Constants.KEYS;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONObject;

public class OpenPriceParam {
    private static final int DEFAULT_DIV_SCALE = 2;
    private SparseArray<Float> mPriceArray = new SparseArray();
    private float monthPrice;
    private String msg;
    private int ret;
    private String toStr;

    public OpenPriceParam() {
        StringBuilder stringBuilder = new StringBuilder("OpenPriceParam{ret=");
        stringBuilder.append(this.ret);
        stringBuilder.append(", mPriceArray=");
        stringBuilder.append(this.mPriceArray);
        stringBuilder.append('}');
        this.toStr = stringBuilder.toString();
    }

    public SparseArray<Float> getPriceArray() {
        return this.mPriceArray;
    }

    public float getMonthPrice() {
        return this.monthPrice;
    }

    public static OpenPriceParam parseFrom(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = new OpenPriceParam();
            str.ret = jSONObject.optInt(KEYS.RET);
            str.msg = jSONObject.optString("msg");
            jSONObject = jSONObject.optJSONObject("data");
            if (jSONObject != null) {
                parseData(jSONObject, str);
            }
            return str;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static void parseData(JSONObject jSONObject, OpenPriceParam openPriceParam) throws Exception {
        openPriceParam.monthPrice = (float) div(jSONObject.optDouble("month", 0.0d), 100.0d);
        jSONObject = jSONObject.getJSONObject("prize");
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (TextUtils.isDigitsOnly(str)) {
                openPriceParam.mPriceArray.put(Integer.parseInt(str), Float.valueOf((float) div((double) ((float) jSONObject.getDouble(str)), 100.0d)));
            }
        }
    }

    public String toString() {
        return this.toStr;
    }

    public static double div(double d, double d2) {
        return div(d, d2, 2);
    }

    public static double div(double d, double d2, int i) {
        if (i < 0) {
            return 0.0d;
        }
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 4).doubleValue();
    }
}
