package com.xunlei.downloadprovider.member.payment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class PayConfigurationParam implements Parcelable, Serializable {
    public static final Creator<PayConfigurationParam> CREATOR = new Creator<PayConfigurationParam>() {
        public final PayConfigurationParam createFromParcel(Parcel parcel) {
            return new PayConfigurationParam(parcel);
        }

        public final PayConfigurationParam[] newArray(int i) {
            return new PayConfigurationParam[i];
        }
    };
    public static final String defaultShowMonth = "12,6,3,1";
    private static final long serialVersionUID = 1000001;
    public String id;
    public String limit;
    public String limitdays;
    public String limitdays2;
    public String limittype;
    public String limittype2;
    private Comparator<Integer> mIntegerComparator = new Comparator<Integer>() {
        public int compare(Integer num, Integer num2) {
            num = num.intValue();
            num2 = num2.intValue();
            if (num > num2) {
                return -1;
            }
            return num < num2 ? 1 : null;
        }
    };
    public String member;
    public String mode;
    public String op;
    public String order;
    public int recommondMonth;
    public int recommondUpMonth;
    public String showMonth;
    public String tips;
    public int type;
    public String vastype;

    public static String getTabTitle(int i) {
        String str = "";
        if (i != 5) {
            if (i == 204) {
                return "快鸟会员";
            }
            if (i != 209) {
                switch (i) {
                    case 2:
                        return "普通会员";
                    case 3:
                        return "白金会员";
                    default:
                        return str;
                }
            }
        }
        return "超级会员";
    }

    public final int describeContents() {
        return 0;
    }

    protected PayConfigurationParam(Parcel parcel) {
        this.order = parcel.readString();
        this.id = parcel.readString();
        this.member = parcel.readString();
        this.limit = parcel.readString();
        this.limittype = parcel.readString();
        this.limitdays = parcel.readString();
        this.limittype2 = parcel.readString();
        this.limitdays2 = parcel.readString();
        this.op = parcel.readString();
        this.vastype = parcel.readString();
        this.showMonth = parcel.readString();
        this.recommondMonth = parcel.readInt();
        this.recommondUpMonth = parcel.readInt();
        this.mode = parcel.readString();
        this.tips = parcel.readString();
        this.type = parcel.readInt();
    }

    public final int getMember() {
        return PayUtil.d(this.member).intValue();
    }

    public final int getLimit() {
        return PayUtil.d(this.limit).intValue();
    }

    public final int getLimittype() {
        return PayUtil.d(this.limittype).intValue();
    }

    public final int getLimitdays() {
        return PayUtil.d(this.limitdays).intValue();
    }

    public final int getLimittype2() {
        return PayUtil.d(this.limittype2).intValue();
    }

    public final int getLimitdays2() {
        return PayUtil.d(this.limitdays2).intValue();
    }

    public final int getOp() {
        return PayUtil.d(this.op).intValue();
    }

    public final int getVastype() {
        return PayUtil.d(this.vastype).intValue();
    }

    public final String getShowMonth() {
        return this.showMonth;
    }

    public final int getRecommondMonth() {
        return this.recommondMonth;
    }

    public final int getRecommondUpMonth() {
        if (this.recommondUpMonth == -1) {
            return 0;
        }
        return this.recommondUpMonth;
    }

    public final int getMode() {
        return PayUtil.d(this.mode).intValue();
    }

    public final String getTips() {
        return this.tips;
    }

    public final int getType() {
        return this.type;
    }

    public final ArrayList<Integer> getMonthList(boolean z) {
        ArrayList<Integer> arrayList = new ArrayList();
        if (z) {
            arrayList.add(Integer.valueOf(true));
            arrayList.add(Integer.valueOf(true));
            arrayList.add(Integer.valueOf(true));
            arrayList.add(Integer.valueOf(true));
        } else {
            z = this.showMonth.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (z.length > 0) {
                for (String d : z) {
                    arrayList.add(PayUtil.d(d));
                }
            }
            Collections.sort(arrayList, this.mIntegerComparator);
        }
        return arrayList;
    }

    public static PayConfigurationParam getDefaultMatchParams(int i, int i2, int i3) {
        return getDefaultMatchParams(i, i2, i3, 3);
    }

    public static PayConfigurationParam getDefaultMatchParams(int i, int i2, int i3, int i4) {
        PayConfigurationParam payConfigurationParam = new PayConfigurationParam();
        payConfigurationParam.op = String.valueOf(i);
        payConfigurationParam.mode = String.valueOf(i3);
        payConfigurationParam.vastype = String.valueOf(i2);
        payConfigurationParam.showMonth = defaultShowMonth;
        payConfigurationParam.tips = "";
        if (i == 0) {
            payConfigurationParam.recommondMonth = i4;
        } else {
            payConfigurationParam.recommondUpMonth = 0;
        }
        return payConfigurationParam;
    }

    public final PayUtil$OrderType getOrderType(int i) {
        if (i == 1) {
            return PayUtil$OrderType.UPGRADE;
        }
        return PayUtil$OrderType.OPEN;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.order);
        parcel.writeString(this.id);
        parcel.writeString(this.member);
        parcel.writeString(this.limit);
        parcel.writeString(this.limittype);
        parcel.writeString(this.limitdays);
        parcel.writeString(this.limittype2);
        parcel.writeString(this.limitdays2);
        parcel.writeString(this.op);
        parcel.writeString(this.vastype);
        parcel.writeString(this.showMonth);
        parcel.writeInt(this.recommondMonth);
        parcel.writeInt(this.recommondUpMonth);
        parcel.writeString(this.mode);
        parcel.writeString(this.tips);
        parcel.writeInt(this.type);
    }
}
