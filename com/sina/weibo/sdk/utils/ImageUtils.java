package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageUtils {
    private static void revitionImageSizeHD(java.lang.String r8, int r9, int r10) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r9 > 0) goto L_0x000a;
    L_0x0002:
        r8 = new java.lang.IllegalArgumentException;
        r9 = "size must be greater than 0!";
        r8.<init>(r9);
        throw r8;
    L_0x000a:
        r0 = isFileExisted(r8);
        if (r0 != 0) goto L_0x001a;
    L_0x0010:
        r9 = new java.io.FileNotFoundException;
        if (r8 != 0) goto L_0x0016;
    L_0x0014:
        r8 = "null";
    L_0x0016:
        r9.<init>(r8);
        throw r9;
    L_0x001a:
        r0 = com.sina.weibo.sdk.utils.BitmapHelper.verifyBitmap(r8);
        if (r0 != 0) goto L_0x0028;
    L_0x0020:
        r8 = new java.io.IOException;
        r9 = "";
        r8.<init>(r9);
        throw r8;
    L_0x0028:
        r0 = 2;
        r0 = r0 * r9;
        r1 = new java.io.FileInputStream;
        r1.<init>(r8);
        r2 = new android.graphics.BitmapFactory$Options;
        r2.<init>();
        r3 = 1;
        r2.inJustDecodeBounds = r3;
        r3 = 0;
        android.graphics.BitmapFactory.decodeStream(r1, r3, r2);
        r1.close();	 Catch:{ Exception -> 0x003f }
        goto L_0x0043;
    L_0x003f:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0043:
        r1 = 0;
        r3 = r1;
    L_0x0045:
        r4 = r2.outWidth;
        r4 = r4 >> r3;
        if (r4 > r0) goto L_0x00f6;
    L_0x004a:
        r4 = r2.outHeight;
        r4 = r4 >> r3;
        if (r4 <= r0) goto L_0x0051;
    L_0x004f:
        goto L_0x00f6;
    L_0x0051:
        r4 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r6 = (double) r3;
        r3 = java.lang.Math.pow(r4, r6);
        r0 = (int) r3;
        r2.inSampleSize = r0;
        r2.inJustDecodeBounds = r1;
        r0 = safeDecodeBimtapFile(r8, r2);
        if (r0 != 0) goto L_0x006b;
    L_0x0063:
        r8 = new java.io.IOException;
        r9 = "Bitmap decode error!";
        r8.<init>(r9);
        throw r8;
    L_0x006b:
        deleteDependon(r8);
        makesureFileExist(r8);
        r1 = r0.getWidth();
        r3 = r0.getHeight();
        if (r1 <= r3) goto L_0x0080;
    L_0x007b:
        r1 = r0.getWidth();
        goto L_0x0084;
    L_0x0080:
        r1 = r0.getHeight();
    L_0x0084:
        r9 = (float) r9;
        r1 = (float) r1;
        r9 = r9 / r1;
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r1 >= 0) goto L_0x00cc;
    L_0x008d:
        r1 = r0.getWidth();	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r1 = (float) r1;	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r1 = r1 * r9;	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r1 = (int) r1;	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r3 = r0.getHeight();	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r3 = (float) r3;	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r3 = r3 * r9;	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r3 = (int) r3;	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r4 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ OutOfMemoryError -> 0x00c0 }
        r1 = android.graphics.Bitmap.createBitmap(r1, r3, r4);	 Catch:{ OutOfMemoryError -> 0x00c0 }
        if (r1 != 0) goto L_0x00a6;
    L_0x00a3:
        r0.recycle();
    L_0x00a6:
        r3 = new android.graphics.Canvas;
        r3.<init>(r1);
        r4 = new android.graphics.Matrix;
        r4.<init>();
        r4.setScale(r9, r9);
        r9 = new android.graphics.Paint;
        r9.<init>();
        r3.drawBitmap(r0, r4, r9);
        r0.recycle();
        r0 = r1;
        goto L_0x00cc;
    L_0x00c0:
        java.lang.System.gc();
        r3 = (double) r9;
        r5 = 4605380978949069210; // 0x3fe999999999999a float:-1.5881868E-23 double:0.8;
        r3 = r3 * r5;
        r9 = (float) r3;
        goto L_0x008d;
    L_0x00cc:
        r9 = new java.io.FileOutputStream;
        r9.<init>(r8);
        r8 = r2.outMimeType;
        if (r8 == 0) goto L_0x00e5;
    L_0x00d5:
        r8 = r2.outMimeType;
        r1 = "png";
        r8 = r8.contains(r1);
        if (r8 == 0) goto L_0x00e5;
    L_0x00df:
        r8 = android.graphics.Bitmap.CompressFormat.PNG;
        r0.compress(r8, r10, r9);
        goto L_0x00ea;
    L_0x00e5:
        r8 = android.graphics.Bitmap.CompressFormat.JPEG;
        r0.compress(r8, r10, r9);
    L_0x00ea:
        r9.close();	 Catch:{ Exception -> 0x00ee }
        goto L_0x00f2;
    L_0x00ee:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x00f2:
        r0.recycle();
        return;
    L_0x00f6:
        r3 = r3 + 1;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ImageUtils.revitionImageSizeHD(java.lang.String, int, int):void");
    }

    private static void revitionImageSize(String str, int i, int i2) throws IOException {
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        } else if (!isFileExisted(str)) {
            if (str == null) {
                str = "null";
            }
            throw new FileNotFoundException(str);
        } else if (BitmapHelper.verifyBitmap(str)) {
            InputStream fileInputStream = new FileInputStream(str);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i3 = 0;
            while (true) {
                if ((options.outWidth >> i3) <= i) {
                    if ((options.outHeight >> i3) <= i) {
                        break;
                    }
                }
                i3++;
            }
            options.inSampleSize = (int) Math.pow(2.0d, (double) i3);
            options.inJustDecodeBounds = false;
            i = safeDecodeBimtapFile(str, options);
            if (i == 0) {
                throw new IOException("Bitmap decode error!");
            }
            deleteDependon(str);
            makesureFileExist(str);
            OutputStream fileOutputStream = new FileOutputStream(str);
            if (options.outMimeType == null || options.outMimeType.contains("png") == null) {
                i.compress(CompressFormat.JPEG, i2, fileOutputStream);
            } else {
                i.compress(CompressFormat.PNG, i2, fileOutputStream);
            }
            try {
                fileOutputStream.close();
            } catch (String str2) {
                str2.printStackTrace();
            }
            i.recycle();
        } else {
            throw new IOException("");
        }
    }

    public static boolean revitionPostImageSize(Context context, String str) {
        try {
            if (NetworkHelper.isWifiValid(context) != null) {
                revitionImageSizeHD(str, SecExceptionCode.SEC_ERROR_SAFETOKEN, 75);
            } else {
                revitionImageSize(str, 1024, 75);
            }
            return true;
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    private static android.graphics.Bitmap safeDecodeBimtapFile(java.lang.String r7, android.graphics.BitmapFactory.Options r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r8 != 0) goto L_0x000b;
    L_0x0002:
        r0 = new android.graphics.BitmapFactory$Options;
        r0.<init>();
        r1 = 1;
        r0.inSampleSize = r1;
        goto L_0x000c;
    L_0x000b:
        r0 = r8;
    L_0x000c:
        r1 = 0;
        r2 = 0;
        r3 = r2;
        r4 = r3;
    L_0x0010:
        r5 = 5;
        if (r1 >= r5) goto L_0x004a;
    L_0x0013:
        r5 = new java.io.FileInputStream;	 Catch:{ OutOfMemoryError -> 0x0031, FileNotFoundException -> 0x004a }
        r5.<init>(r7);	 Catch:{ OutOfMemoryError -> 0x0031, FileNotFoundException -> 0x004a }
        r3 = android.graphics.BitmapFactory.decodeStream(r5, r2, r8);	 Catch:{ OutOfMemoryError -> 0x002b, FileNotFoundException -> 0x004a }
        r5.close();	 Catch:{ IOException -> 0x0025 }
        goto L_0x0029;
    L_0x0020:
        r4 = move-exception;
        r6 = r5;
        r5 = r3;
        r3 = r6;
        goto L_0x0035;
    L_0x0025:
        r4 = move-exception;
        r4.printStackTrace();	 Catch:{ OutOfMemoryError -> 0x0020, FileNotFoundException -> 0x0029 }
    L_0x0029:
        r4 = r3;
        goto L_0x004a;
    L_0x002b:
        r3 = move-exception;
        r6 = r4;
        r4 = r3;
        r3 = r5;
        r5 = r6;
        goto L_0x0035;
    L_0x0031:
        r5 = move-exception;
        r6 = r5;
        r5 = r4;
        r4 = r6;
    L_0x0035:
        r4.printStackTrace();
        r4 = r0.inSampleSize;
        r4 = r4 * 2;
        r0.inSampleSize = r4;
        r3.close();	 Catch:{ IOException -> 0x0042 }
        goto L_0x0046;
    L_0x0042:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0046:
        r1 = r1 + 1;
        r4 = r5;
        goto L_0x0010;
    L_0x004a:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ImageUtils.safeDecodeBimtapFile(java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private static void delete(File file) {
        if (file != null && file.exists() && !file.delete()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(" doesn't be deleted!");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    private static boolean deleteDependon(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        str = true;
        while (!z && str <= 5 && file.isFile() && file.exists()) {
            z = file.delete();
            if (!z) {
                str++;
            }
        }
        return z;
    }

    private static boolean isFileExisted(String str) {
        if (TextUtils.isEmpty(str) || new File(str).exists() == null) {
            return false;
        }
        return true;
    }

    private static boolean isParentExist(File file) {
        if (file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return false;
        }
        if (file.exists() || file.mkdirs() != null) {
            return true;
        }
        return false;
    }

    public static java.lang.String copyFileToWeiboTem(android.content.Context r11, android.net.Uri r12, int r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = com.sina.weibo.sdk.WeiboAppManager.queryWbInfoInternal(r11);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r1 = r1.getPackageName();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        if (r2 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x000f:
        r1 = "com.sina.weibo";	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x0011:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r3 = "/Android/data/";	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2.append(r1);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r1 = "/files/.composerTem/";	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2.append(r1);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r1 = r2.toString();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r3.<init>();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r4 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r4 = r4.getAbsolutePath();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r3.append(r4);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r3.append(r1);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2.mkdirs();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r3 = 0;
        r4 = r12.getScheme();	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r5 = "file";	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        if (r4 == 0) goto L_0x006e;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
    L_0x0054:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r4.<init>();	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r5 = r2.getTimeInMillis();	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r4.append(r5);	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r2 = r12.getLastPathSegment();	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r4.append(r2);	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r2 = r4.toString();	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r4 = r2;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r2 = r0;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        goto L_0x009d;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
    L_0x006e:
        r4 = r11.getContentResolver();	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r2 = 1;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r6 = new java.lang.String[r2];	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r2 = "_display_name";	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r6[r3] = r2;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r7 = 0;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r8 = 0;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r9 = 0;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r5 = r12;	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r2 = r4.query(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        if (r2 == 0) goto L_0x009c;
    L_0x0083:
        r4 = r2.moveToFirst();	 Catch:{ Exception -> 0x0097, all -> 0x0094 }
        if (r4 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x0097, all -> 0x0094 }
    L_0x0089:
        r4 = "_display_name";	 Catch:{ Exception -> 0x0097, all -> 0x0094 }
        r4 = r2.getColumnIndex(r4);	 Catch:{ Exception -> 0x0097, all -> 0x0094 }
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x0097, all -> 0x0094 }
        goto L_0x009d;
    L_0x0094:
        r11 = move-exception;
        goto L_0x013f;
    L_0x0097:
        r4 = move-exception;
        r10 = r4;
        r4 = r2;
        r2 = r10;
        goto L_0x00a9;
    L_0x009c:
        r4 = r0;
    L_0x009d:
        if (r2 == 0) goto L_0x00b2;
    L_0x009f:
        r2.close();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        goto L_0x00b2;
    L_0x00a3:
        r11 = move-exception;
        r2 = r0;
        goto L_0x013f;
    L_0x00a7:
        r2 = move-exception;
        r4 = r0;
    L_0x00a9:
        r2.toString();	 Catch:{ all -> 0x013d }
        if (r4 == 0) goto L_0x00b1;
    L_0x00ae:
        r4.close();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x00b1:
        r4 = r0;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x00b2:
        r2 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        if (r2 == 0) goto L_0x00d6;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x00b8:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2.<init>();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r4 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r4 = r4.getTimeInMillis();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r2.append(r4);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        if (r13 != 0) goto L_0x00cd;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x00ca:
        r13 = "_sdk_temp.mp4";	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        goto L_0x00cf;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x00cd:
        r13 = "_sdk_temp.jpg";	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x00cf:
        r2.append(r13);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r4 = r2.toString();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x00d6:
        r11 = r11.getContentResolver();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r13 = "r";	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r11 = r11.openFileDescriptor(r12, r13);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r11 = r11.getFileDescriptor();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r12 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r13 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r13.<init>(r11);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r12.<init>(r13);	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
        r11 = new java.io.File;	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r13.<init>();	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r2 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r2 = r2.getAbsolutePath();	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r13.append(r2);	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r13.append(r1);	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r13.append(r4);	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r11.<init>(r13);	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r13 = r11.exists();	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        if (r13 == 0) goto L_0x0116;	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
    L_0x0113:
        r11.delete();	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
    L_0x0116:
        r13 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r13.<init>(r11);	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r1 = 1444; // 0x5a4 float:2.023E-42 double:7.134E-321;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x0135 }
    L_0x011f:
        r2 = r12.read(r1);	 Catch:{ Exception -> 0x0135 }
        r4 = -1;	 Catch:{ Exception -> 0x0135 }
        if (r2 == r4) goto L_0x012a;	 Catch:{ Exception -> 0x0135 }
    L_0x0126:
        r13.write(r1, r3, r2);	 Catch:{ Exception -> 0x0135 }
        goto L_0x011f;	 Catch:{ Exception -> 0x0135 }
    L_0x012a:
        r11 = r11.getPath();	 Catch:{ Exception -> 0x0135 }
        r12.close();	 Catch:{ Exception -> 0x0134 }
        r13.close();	 Catch:{ Exception -> 0x0134 }
    L_0x0134:
        return r11;
    L_0x0135:
        r11 = move-exception;
        goto L_0x014b;
    L_0x0137:
        r11 = move-exception;
        r13 = r0;
        goto L_0x015a;
    L_0x013a:
        r11 = move-exception;
        r13 = r0;
        goto L_0x014b;
    L_0x013d:
        r11 = move-exception;
        r2 = r4;
    L_0x013f:
        if (r2 == 0) goto L_0x0144;
    L_0x0141:
        r2.close();	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x0144:
        throw r11;	 Catch:{ Exception -> 0x0148, all -> 0x0145 }
    L_0x0145:
        r11 = move-exception;
        r13 = r0;
        goto L_0x015b;
    L_0x0148:
        r11 = move-exception;
        r12 = r0;
        r13 = r12;
    L_0x014b:
        r11.toString();	 Catch:{ all -> 0x0159 }
        if (r12 == 0) goto L_0x0153;
    L_0x0150:
        r12.close();	 Catch:{ Exception -> 0x0158 }
    L_0x0153:
        if (r13 == 0) goto L_0x0158;	 Catch:{ Exception -> 0x0158 }
    L_0x0155:
        r13.close();	 Catch:{ Exception -> 0x0158 }
    L_0x0158:
        return r0;
    L_0x0159:
        r11 = move-exception;
    L_0x015a:
        r0 = r12;
    L_0x015b:
        if (r0 == 0) goto L_0x0160;
    L_0x015d:
        r0.close();	 Catch:{ Exception -> 0x0165 }
    L_0x0160:
        if (r13 == 0) goto L_0x0165;	 Catch:{ Exception -> 0x0165 }
    L_0x0162:
        r13.close();	 Catch:{ Exception -> 0x0165 }
    L_0x0165:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ImageUtils.copyFileToWeiboTem(android.content.Context, android.net.Uri, int):java.lang.String");
    }

    @android.annotation.TargetApi(10)
    public static long getVideoDuring(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.File;
        r0.<init>(r5);
        r0 = r0.exists();
        r1 = 0;
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = new android.media.MediaMetadataRetriever;	 Catch:{ Exception -> 0x0021 }
        r0.<init>();	 Catch:{ Exception -> 0x0021 }
        r0.setDataSource(r5);	 Catch:{ Exception -> 0x0021 }
        r5 = 9;	 Catch:{ Exception -> 0x0021 }
        r5 = r0.extractMetadata(r5);	 Catch:{ Exception -> 0x0021 }
        r3 = java.lang.Long.parseLong(r5);	 Catch:{ Exception -> 0x0021 }
        return r3;
    L_0x0021:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ImageUtils.getVideoDuring(java.lang.String):long");
    }

    private static void makesureFileExist(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists() == null && isParentExist(file) != null) {
                if (file.exists() != null) {
                    delete(file);
                }
                try {
                    file.createNewFile();
                } catch (String str2) {
                    str2.printStackTrace();
                }
            }
        }
    }

    public static boolean isWifi(Context context) {
        context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (context == null || context.getType() != 1) ? null : true;
    }
}
