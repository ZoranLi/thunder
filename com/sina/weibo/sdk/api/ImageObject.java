package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageObject extends BaseMediaObject {
    public static final Creator<ImageObject> CREATOR = new Creator<ImageObject>() {
        public final ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        public final ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };
    private static final int DATA_SIZE = 2097152;
    public byte[] imageData;
    public String imagePath;

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 2;
    }

    protected BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    protected String toExtraMediaString() {
        return "";
    }

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }

    public final void setImageObject(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream2);
                this.imageData = byteArrayOutputStream2.toByteArray();
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
                    LogUtil.e("Weibo.ImageObject", "put thumb failed");
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
            LogUtil.e("Weibo.ImageObject", "put thumb failed");
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }

    public boolean checkArgs() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.imageData;
        r1 = 0;
        if (r0 != 0) goto L_0x0011;
    L_0x0005:
        r0 = r7.imagePath;
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r0 = "Weibo.ImageObject";
        r2 = "imageData and imagePath are null";
        com.sina.weibo.sdk.utils.LogUtil.e(r0, r2);
        return r1;
    L_0x0011:
        r0 = r7.imageData;
        if (r0 == 0) goto L_0x0024;
    L_0x0015:
        r0 = r7.imageData;
        r0 = r0.length;
        r2 = 2097152; // 0x200000 float:2.938736E-39 double:1.0361308E-317;
        if (r0 <= r2) goto L_0x0024;
    L_0x001c:
        r0 = "Weibo.ImageObject";
        r2 = "imageData is too large";
        com.sina.weibo.sdk.utils.LogUtil.e(r0, r2);
        return r1;
    L_0x0024:
        r0 = r7.imagePath;
        if (r0 == 0) goto L_0x003a;
    L_0x0028:
        r0 = r7.imagePath;
        r0 = r0.length();
        r2 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r0 <= r2) goto L_0x003a;
    L_0x0032:
        r0 = "Weibo.ImageObject";
        r2 = "imagePath is too length";
        com.sina.weibo.sdk.utils.LogUtil.e(r0, r2);
        return r1;
    L_0x003a:
        r0 = r7.imagePath;
        if (r0 == 0) goto L_0x0070;
    L_0x003e:
        r0 = new java.io.File;
        r2 = r7.imagePath;
        r0.<init>(r2);
        r2 = r0.exists();	 Catch:{ SecurityException -> 0x0068 }
        if (r2 == 0) goto L_0x0060;	 Catch:{ SecurityException -> 0x0068 }
    L_0x004b:
        r2 = r0.length();	 Catch:{ SecurityException -> 0x0068 }
        r4 = 0;	 Catch:{ SecurityException -> 0x0068 }
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ SecurityException -> 0x0068 }
        if (r6 == 0) goto L_0x0060;	 Catch:{ SecurityException -> 0x0068 }
    L_0x0055:
        r2 = r0.length();	 Catch:{ SecurityException -> 0x0068 }
        r4 = 10485760; // 0xa00000 float:1.469368E-38 double:5.180654E-317;	 Catch:{ SecurityException -> 0x0068 }
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ SecurityException -> 0x0068 }
        if (r0 <= 0) goto L_0x0070;	 Catch:{ SecurityException -> 0x0068 }
    L_0x0060:
        r0 = "Weibo.ImageObject";	 Catch:{ SecurityException -> 0x0068 }
        r2 = "checkArgs fail, image content is too large or not exists";	 Catch:{ SecurityException -> 0x0068 }
        com.sina.weibo.sdk.utils.LogUtil.e(r0, r2);	 Catch:{ SecurityException -> 0x0068 }
        return r1;
    L_0x0068:
        r0 = "Weibo.ImageObject";
        r2 = "checkArgs fail, image content is too large or not exists";
        com.sina.weibo.sdk.utils.LogUtil.e(r0, r2);
        return r1;
    L_0x0070:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.api.ImageObject.checkArgs():boolean");
    }
}
