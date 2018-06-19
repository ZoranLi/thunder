package com.xunlei.common.new_ptl.member;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xunlei.common.encrypt.Base64;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class XLAvatarItem implements Parcelable {
    public static final Creator<XLAvatarItem> CREATOR = new 1();
    public int mAvatarId = -1;
    public String mAvatarUrl = "";

    public int describeContents() {
        return 0;
    }

    public XLAvatarItem(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.mAvatarId = jSONObject.getInt(AgooConstants.MESSAGE_ID);
                this.mAvatarUrl = new String(Base64.decode(jSONObject.getString("url")));
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
            }
        }
    }

    public XLAvatarItem(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAvatarUrl);
        parcel.writeInt(this.mAvatarId);
    }

    public void readFromParcel(Parcel parcel) {
        this.mAvatarUrl = parcel.readString();
        this.mAvatarId = parcel.readInt();
    }
}
