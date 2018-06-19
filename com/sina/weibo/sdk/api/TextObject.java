package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.utils.LogUtil;

public class TextObject extends BaseMediaObject {
    public static final Creator<TextObject> CREATOR = new Creator<TextObject>() {
        public final TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        public final TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    };
    public String text;

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 1;
    }

    protected BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    protected String toExtraMediaString() {
        return "";
    }

    public TextObject(Parcel parcel) {
        this.text = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.text);
    }

    public boolean checkArgs() {
        if (!(this.text == null || this.text.length() == 0)) {
            if (this.text.length() <= 1024) {
                return true;
            }
        }
        LogUtil.e("Weibo.TextObject", "checkArgs fail, text is invalid");
        return false;
    }
}
