package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class BaseMediaObject implements Parcelable {
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_MULITI_IMAGE = 6;
    public static final int MEDIA_TYPE_SOURCE_VIDEO = 7;
    public static final int MEDIA_TYPE_TEXT = 1;
    public static final int MEDIA_TYPE_WEBPAGE = 5;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    public int describeContents() {
        return 0;
    }

    public abstract int getObjType();

    protected abstract BaseMediaObject toExtraMediaObject(String str);

    protected abstract String toExtraMediaString();

    public BaseMediaObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }

    public final void setThumbImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream2);
                this.thumbData = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                } catch (Bitmap bitmap2) {
                    bitmap2.printStackTrace();
                }
            } catch (Exception e) {
                bitmap2 = e;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    bitmap2.printStackTrace();
                    LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Bitmap bitmap22) {
                            bitmap22.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    bitmap22 = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw bitmap22;
                }
            } catch (Throwable th2) {
                bitmap22 = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw bitmap22;
            }
        } catch (Exception e3) {
            bitmap22 = e3;
            bitmap22.printStackTrace();
            LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }

    protected boolean checkArgs() {
        if (this.actionUrl != null) {
            if (this.actionUrl.length() <= 512) {
                if (this.identify != null) {
                    if (this.identify.length() <= 512) {
                        if (this.thumbData != null) {
                            if (this.thumbData.length <= 32768) {
                                if (this.title != null) {
                                    if (this.title.length() <= 512) {
                                        if (this.description != null) {
                                            if (this.description.length() <= 1024) {
                                                return true;
                                            }
                                        }
                                        LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
                                        return false;
                                    }
                                }
                                LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
                                return false;
                            }
                        }
                        String str = "Weibo.BaseMediaObject";
                        StringBuilder stringBuilder = new StringBuilder("checkArgs fail, thumbData is invalid,size is ");
                        stringBuilder.append(this.thumbData != null ? this.thumbData.length : -1);
                        stringBuilder.append("! more then 32768.");
                        LogUtil.e(str, stringBuilder.toString());
                        return false;
                    }
                }
                LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
                return false;
            }
        }
        LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
        return false;
    }
}
