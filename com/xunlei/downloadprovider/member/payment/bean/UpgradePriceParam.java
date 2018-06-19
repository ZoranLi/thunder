package com.xunlei.downloadprovider.member.payment.bean;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.xunlei.downloadprovider.member.payment.i;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class UpgradePriceParam {
    private static final int DIVISOR_TEN = 10;
    private static final float FLOAT_ONE = 1.0f;
    private static final float FLOAT_ZERO = 0.0f;
    private static final int MAX_PRICE = 1500;
    private static final int ONE = 1;
    private static final int PAY_SUCCESS_REUSLT_CODE = 200;
    public static final String UPGRADE_UPRATE_PROMOTION = "uprate";
    private static final int ZERO = 0;
    private float discount = FLOAT_ONE;
    private int hUpprice;
    private int hdays;
    private float hprice;
    private int mdays;
    private float mprice;
    private int nUpprice;
    private int ndays;
    private float nprice;
    private float price;
    private int ret;
    private int sdays;
    private float sprice;
    private int tdays;
    private String tostr;
    private TreeMap<Integer, Float> upgrateCfgMap;

    public UpgradePriceParam() {
        StringBuilder stringBuilder = new StringBuilder("UpgradePriceParam{ret=");
        stringBuilder.append(this.ret);
        stringBuilder.append(", mdays=");
        stringBuilder.append(this.mdays);
        stringBuilder.append(", ndays=");
        stringBuilder.append(this.ndays);
        stringBuilder.append(", hdays=");
        stringBuilder.append(this.hdays);
        stringBuilder.append(", mprice=");
        stringBuilder.append(this.mprice);
        stringBuilder.append(", nprice=");
        stringBuilder.append(this.nprice);
        stringBuilder.append(", hprice=");
        stringBuilder.append(this.hprice);
        stringBuilder.append(", price=");
        stringBuilder.append(this.price);
        stringBuilder.append(", tdays=");
        stringBuilder.append(this.tdays);
        stringBuilder.append(", discount=");
        stringBuilder.append(this.discount);
        stringBuilder.append('}');
        this.tostr = stringBuilder.toString();
    }

    public boolean isSuccess() {
        return this.ret == 200;
    }

    public int getTdays() {
        return this.tdays;
    }

    public float getUprate() {
        return this.discount;
    }

    public String toString() {
        return this.tostr;
    }

    public static UpgradePriceParam parseFrom(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = new UpgradePriceParam();
            str.ret = jSONObject.getInt(KEYS.RET);
            if (str.isSuccess()) {
                jSONObject = jSONObject.getJSONObject("data");
                str.price = (float) OpenPriceParam.div(jSONObject.getDouble("price"), 100.0d);
                str.tdays = jSONObject.getInt("tdays");
                str.discount = (float) jSONObject.optDouble("discount", 1.0d);
                jSONObject = jSONObject.optJSONObject("config");
                if (jSONObject != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("discount");
                    int length = optJSONArray.length();
                    TreeMap treeMap = new TreeMap(new Comparator<Integer>() {
                        public final int compare(Integer num, Integer num2) {
                            if (num.intValue() < num2.intValue()) {
                                return 1;
                            }
                            return num.intValue() > num2.intValue() ? -1 : null;
                        }
                    });
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            treeMap.put(Integer.valueOf(optJSONObject.optInt("num")), Float.valueOf((float) optJSONObject.optDouble("discount")));
                        }
                    }
                    str.upgrateCfgMap = treeMap;
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("updays");
                    if (optJSONObject2 != null) {
                        str.mdays = optJSONObject2.optInt("min");
                        str.ndays = optJSONObject2.optInt("openvip");
                        str.hdays = optJSONObject2.optInt("baijin");
                    }
                    jSONObject = jSONObject.optJSONObject("price");
                    if (jSONObject != null) {
                        str.mprice = (float) jSONObject.optInt("mini");
                        str.nprice = (float) jSONObject.optInt("openvip");
                        str.hprice = (float) jSONObject.optInt("baijin");
                        str.sprice = (float) jSONObject.optInt("supervip");
                    }
                }
            }
            return str;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public float getPayCountOfDays(int i, int i2) {
        if (this.tdays == i2) {
            return this.price;
        }
        if (i2 % 31 != 0) {
            return 1065353216;
        }
        float uprateFromMap;
        if (this.hdays >= i2) {
            uprateFromMap = ((((float) i2) * (this.sprice - this.hprice)) * getUprateFromMap(i2)) / 31.0f;
        } else if (this.hdays <= 0) {
            uprateFromMap = ((((float) i2) * ((i.b(i) != 0 ? this.sprice : this.hprice) - this.nprice)) * getUprateFromMap(i2)) / 31.0f;
        } else {
            uprateFromMap = (round(((this.sprice - this.hprice) * ((float) this.hdays)) / 31.0f, 1) + round(((this.sprice - this.nprice) * ((float) (i2 - this.hdays))) / 31.0f, 1)) * getUprateFromMap(i2);
        }
        int round = ((float) Math.round(uprateFromMap * 10.0f)) / 10.0f;
        i = 1153138688;
        if (round < 1500.0f) {
            i = round;
        }
        StringBuilder stringBuilder = new StringBuilder("hdays=");
        stringBuilder.append(this.hdays);
        stringBuilder.append(" ,currentDays=");
        stringBuilder.append(i2);
        stringBuilder.append(" , price=");
        stringBuilder.append(i);
        return i;
    }

    public float getUprateFromMap(int i) {
        if (this.upgrateCfgMap != null) {
            if (this.upgrateCfgMap.size() > 0) {
                for (Entry key : this.upgrateCfgMap.entrySet()) {
                    Integer num = (Integer) key.getKey();
                    if (i >= num.intValue()) {
                        return ((Float) this.upgrateCfgMap.get(num)).floatValue();
                    }
                }
                return FLOAT_ONE;
            }
        }
        return FLOAT_ONE;
    }

    private static float round(float f, int i) {
        return new BigDecimal((double) f).setScale(i, Float.MIN_VALUE).floatValue();
    }
}
