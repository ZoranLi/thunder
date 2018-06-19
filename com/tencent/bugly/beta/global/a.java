package com.tencent.bugly.beta.global;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.bugly.beta.utils.c;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.p;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* compiled from: BUGLY */
public class a {
    public static int a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return 0;
                    }
                }
            }
            return 0;
        } catch (Context context2) {
            if (!an.a(context2)) {
                context2.printStackTrace();
            }
        }
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public static BitmapDrawable a(Bitmap bitmap, int i, int i2, float f) {
        int i3 = (int) (((float) (e.E.B.widthPixels * e.E.B.heightPixels)) * 0.8f);
        if (bitmap != null) {
            if (i * i2 <= i3) {
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, i, i2);
                RectF rectF = new RectF(rect);
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-16777216);
                canvas.drawRoundRect(rectF, f, f, paint);
                canvas.drawRect(0.0f, f, (float) i, (float) i2, paint);
                paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
                return new BitmapDrawable(createBitmap);
            }
        }
        return null;
    }

    public static Bitmap a(Context context, int i, Object... objArr) {
        int i2 = i;
        Object[] objArr2 = objArr;
        if (objArr2 != null && objArr2.length > 0) {
            boolean z = true;
            if (i2 == 0 || i2 == 1) {
                File file;
                int intValue;
                int i3;
                Options options;
                int i4;
                int min;
                double d;
                double d2;
                int i5;
                int i6;
                boolean z2;
                int i7;
                double d3;
                if (i2 == 0) {
                    try {
                        if (TextUtils.isEmpty((String) objArr2[0])) {
                            return null;
                        }
                        file = new File((String) objArr2[0]);
                        if (!file.exists() || file.length() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                            return null;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (i2 == 1) {
                    intValue = ((Integer) objArr2[0]).intValue();
                    file = null;
                    i3 = e.E.B.widthPixels;
                    if (i3 <= 0) {
                        options = new Options();
                        options.inJustDecodeBounds = true;
                        if (i2 == 0) {
                            BitmapFactory.decodeFile(file.getPath(), options);
                        } else if (i2 == 1) {
                            BitmapFactory.decodeResource(context.getResources(), intValue, options);
                        }
                        i4 = (int) (((float) i3) * (((float) options.outHeight) / ((float) options.outWidth)));
                        min = Math.min(i3, i4);
                        d = (double) options.outWidth;
                        d2 = (double) options.outHeight;
                        i5 = i3 * i4;
                        i6 = -1;
                        if (i5 == -1) {
                            z = (int) Math.ceil(Math.sqrt(((double) i4) * ((d * d2) / ((double) i3))));
                        }
                        if (min != -1) {
                            z2 = z;
                            i7 = 128;
                        } else {
                            z2 = z;
                            d3 = (double) min;
                            i7 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
                            i6 = -1;
                        }
                        if (i5 != i6 && min == i6) {
                            i7 = 1;
                        } else if (min == i6) {
                            i7 = z2;
                        }
                        if (i7 > 8) {
                            i6 = 1;
                            while (i6 < i7) {
                                i6 <<= 1;
                            }
                        } else {
                            i6 = 8 * ((i7 + 7) / 8);
                        }
                        options.inSampleSize = i6;
                        options.inJustDecodeBounds = false;
                        options.inInputShareable = true;
                        options.inPurgeable = true;
                    } else {
                        options = null;
                    }
                    if (i2 == 0) {
                        return BitmapFactory.decodeFile(file.getPath(), options);
                    }
                    if (i2 == 1) {
                        return BitmapFactory.decodeResource(context.getResources(), intValue, options);
                    }
                    return null;
                } else {
                    file = null;
                }
                intValue = 0;
                i3 = e.E.B.widthPixels;
                if (i3 <= 0) {
                    options = null;
                } else {
                    options = new Options();
                    options.inJustDecodeBounds = true;
                    if (i2 == 0) {
                        BitmapFactory.decodeFile(file.getPath(), options);
                    } else if (i2 == 1) {
                        BitmapFactory.decodeResource(context.getResources(), intValue, options);
                    }
                    i4 = (int) (((float) i3) * (((float) options.outHeight) / ((float) options.outWidth)));
                    min = Math.min(i3, i4);
                    d = (double) options.outWidth;
                    d2 = (double) options.outHeight;
                    i5 = i3 * i4;
                    i6 = -1;
                    if (i5 == -1) {
                        z = (int) Math.ceil(Math.sqrt(((double) i4) * ((d * d2) / ((double) i3))));
                    }
                    if (min != -1) {
                        z2 = z;
                        d3 = (double) min;
                        i7 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
                        i6 = -1;
                    } else {
                        z2 = z;
                        i7 = 128;
                    }
                    if (i5 != i6) {
                    }
                    if (min == i6) {
                        i7 = z2;
                    }
                    if (i7 > 8) {
                        i6 = 8 * ((i7 + 7) / 8);
                    } else {
                        i6 = 1;
                        while (i6 < i7) {
                            i6 <<= 1;
                        }
                    }
                    options.inSampleSize = i6;
                    options.inJustDecodeBounds = false;
                    options.inInputShareable = true;
                    options.inPurgeable = true;
                }
                if (i2 == 0) {
                    return BitmapFactory.decodeFile(file.getPath(), options);
                }
                if (i2 == 1) {
                    return BitmapFactory.decodeResource(context.getResources(), intValue, options);
                }
                return null;
            }
        }
        return null;
    }

    public static boolean a(Context context, File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(ShareConstants.PATCH_SUFFIX)) {
                    String a = ap.a(file, "MD5");
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str.toUpperCase(), a)) {
                        str = new StringBuilder("chmod 777 ");
                        str.append(file.getAbsolutePath());
                        Runtime.getRuntime().exec(str.toString());
                        str = new Intent("android.intent.action.VIEW");
                        String str2 = ApkHelper.MIME_TYPE_APK;
                        if (VERSION.SDK_INT >= 24) {
                            String str3 = "android.support.v4.content.FileProvider";
                            str.addFlags(1);
                            if (Class.forName(str3) == null) {
                                an.e("can't find class android.support.v4.content.FileProvider", new Object[0]);
                                return false;
                            }
                            Class[] clsArr = new Class[]{Context.class, String.class, File.class};
                            Object[] objArr = new Object[3];
                            objArr[0] = context;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(com.tencent.bugly.crashreport.common.info.a.a(context).d);
                            stringBuilder.append(".fileProvider");
                            objArr[1] = stringBuilder.toString();
                            objArr[2] = file;
                            Uri uri = (Uri) ap.a(str3, "getUriForFile", null, clsArr, objArr);
                            if (uri == null) {
                                context = new StringBuilder("file location is ");
                                context.append(file.toString());
                                an.e(context.toString(), new Object[0]);
                                an.e("install failed, contentUri is null!", new Object[0]);
                                return false;
                            }
                            file = new StringBuilder("contentUri is ");
                            file.append(uri);
                            an.c(file.toString(), new Object[0]);
                            str.setDataAndType(uri, str2);
                        } else {
                            str.setDataAndType(Uri.fromFile(file), str2);
                        }
                        str.addFlags(268435456);
                        context.startActivity(str);
                        a("installApkMd5", a);
                        return true;
                    }
                    an.a("md5 error [file md5: %s] [target md5: %s]", a, str);
                    return false;
                }
            } catch (Context context2) {
                if (an.b(context2) == null) {
                    context2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean a(java.io.File r3, java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x0034;
    L_0x0003:
        r1 = r3.exists();	 Catch:{ Exception -> 0x002d }
        if (r1 == 0) goto L_0x0034;	 Catch:{ Exception -> 0x002d }
    L_0x0009:
        r3 = com.tencent.bugly.proguard.ap.a(r3, r5);	 Catch:{ Exception -> 0x002d }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x002d }
        r1 = 1;	 Catch:{ Exception -> 0x002d }
        if (r5 != 0) goto L_0x0020;	 Catch:{ Exception -> 0x002d }
    L_0x0014:
        r5 = r4.toUpperCase();	 Catch:{ Exception -> 0x002d }
        r5 = android.text.TextUtils.equals(r5, r3);	 Catch:{ Exception -> 0x002d }
        if (r5 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x002d }
    L_0x001e:
        goto L_0x0020;	 Catch:{ Exception -> 0x002d }
    L_0x001f:
        return r1;	 Catch:{ Exception -> 0x002d }
    L_0x0020:
        r5 = "checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]";	 Catch:{ Exception -> 0x002d }
        r2 = 2;	 Catch:{ Exception -> 0x002d }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x002d }
        r2[r0] = r3;	 Catch:{ Exception -> 0x002d }
        r2[r1] = r4;	 Catch:{ Exception -> 0x002d }
        com.tencent.bugly.proguard.an.a(r5, r2);	 Catch:{ Exception -> 0x002d }
        return r0;
    L_0x002d:
        r3 = "checkFileUniqueId exception";
        r4 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.an.e(r3, r4);
    L_0x0034:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(java.io.File, java.lang.String, java.lang.String):boolean");
    }

    public static boolean a(File file, File file2) {
        boolean z = false;
        if (file != null) {
            FileInputStream fileInputStream = null;
            try {
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            file = new FileOutputStream(file2, false);
                        } catch (Exception e) {
                            file2 = e;
                            file = null;
                            fileInputStream = fileInputStream2;
                            try {
                                file2.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (file != null) {
                                    file.close();
                                }
                                return z;
                            } catch (Throwable th) {
                                file2 = th;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (File file3) {
                                        file3.printStackTrace();
                                        throw file2;
                                    }
                                }
                                if (file3 != null) {
                                    file3.close();
                                }
                                throw file2;
                            }
                        } catch (Throwable th2) {
                            file2 = th2;
                            file3 = null;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (file3 != null) {
                                file3.close();
                            }
                            throw file2;
                        }
                        try {
                            file2 = new byte[1048576];
                            while (true) {
                                int read = fileInputStream2.read(file2);
                                if (read <= 0) {
                                    break;
                                }
                                file3.write(file2, 0, read);
                            }
                            z = true;
                        } catch (Exception e2) {
                            file2 = e2;
                            fileInputStream = fileInputStream2;
                            file2.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (file3 != null) {
                                file3.close();
                            }
                            return z;
                        } catch (Throwable th3) {
                            file2 = th3;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (file3 != null) {
                                file3.close();
                            }
                            throw file2;
                        }
                        try {
                            fileInputStream2.close();
                            file3.close();
                        } catch (File file32) {
                            file32.printStackTrace();
                        }
                        return z;
                    }
                }
            } catch (Exception e3) {
                file2 = e3;
                file32 = null;
                file2.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (file32 != null) {
                    file32.close();
                }
                return z;
            } catch (Throwable th4) {
                file2 = th4;
                file32 = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (file32 != null) {
                    file32.close();
                }
                throw file2;
            }
        }
        return false;
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap createBitmap;
        Canvas canvas;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0) {
            if (drawable.getIntrinsicHeight() > 0) {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
                canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            }
        }
        createBitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static void a(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                file = file.listFiles();
                if (file != null) {
                    if (file.length > 0) {
                        for (File delete : file) {
                            if (!delete.delete()) {
                                an.e("cannot delete file:%s", file[r2].getAbsolutePath());
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized <T extends android.os.Parcelable> boolean a(java.lang.String r4, T r5) {
        /*
        r0 = com.tencent.bugly.beta.global.a.class;
        monitor-enter(r0);
        r1 = 0;
        if (r5 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r0);
        return r1;
    L_0x0008:
        r5 = com.tencent.bugly.proguard.ap.a(r5);	 Catch:{ all -> 0x001d }
        if (r5 == 0) goto L_0x001b;
    L_0x000e:
        r2 = com.tencent.bugly.proguard.p.a;	 Catch:{ all -> 0x001d }
        r3 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r4 = r2.a(r3, r4, r5);	 Catch:{ all -> 0x001d }
        if (r4 == 0) goto L_0x001b;
    L_0x0018:
        r4 = 1;
        monitor-exit(r0);
        return r4;
    L_0x001b:
        monitor-exit(r0);
        return r1;
    L_0x001d:
        r4 = move-exception;
        monitor-exit(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(java.lang.String, android.os.Parcelable):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized <T extends android.os.Parcelable> T a(java.lang.String r3, android.os.Parcelable.Creator<T> r4) {
        /*
        r0 = com.tencent.bugly.beta.global.a.class;
        monitor-enter(r0);
        r1 = com.tencent.bugly.proguard.p.a;	 Catch:{ all -> 0x0024 }
        r1 = r1.c();	 Catch:{ all -> 0x0024 }
        r2 = 0;
        if (r1 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r0);
        return r2;
    L_0x000e:
        r3 = r1.get(r3);	 Catch:{ all -> 0x0024 }
        r3 = (byte[]) r3;	 Catch:{ all -> 0x0024 }
        if (r3 == 0) goto L_0x0022;
    L_0x0016:
        r1 = r3.length;	 Catch:{ all -> 0x0024 }
        if (r1 > 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0022;
    L_0x001a:
        r3 = com.tencent.bugly.proguard.ap.a(r3, r4);	 Catch:{ all -> 0x0024 }
        r3 = (android.os.Parcelable) r3;	 Catch:{ all -> 0x0024 }
        monitor-exit(r0);
        return r3;
    L_0x0022:
        monitor-exit(r0);
        return r2;
    L_0x0024:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(java.lang.String, android.os.Parcelable$Creator):T");
    }

    public static synchronized boolean a(String str) {
        synchronized (a.class) {
            str = p.a.c(str);
        }
        return str;
    }

    public static String b(String str) {
        return new c(str).a();
    }

    public static void a(String str, String str2) {
        if (e.E.A != null) {
            e.E.A.edit().putString(str, str2).apply();
        }
    }

    public static void a(String str, boolean z) {
        if (e.E.A != null) {
            e.E.A.edit().putBoolean(str, z).apply();
        }
    }

    public static String b(String str, String str2) {
        return e.E.A != null ? e.E.A.getString(str, str2) : str2;
    }

    public static boolean b(String str, boolean z) {
        return e.E.A != null ? e.E.A.getBoolean(str, z) : z;
    }

    public static String a(Context context, String str) {
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (context != null) {
                if (context.metaData != null) {
                    context = context.metaData.get(str);
                    return context != null ? String.valueOf(context) : null;
                }
            }
            return null;
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder("getManifestMetaDataValue exception:");
            stringBuilder.append(context2.getMessage());
            an.c(a.class, stringBuilder.toString(), new Object[0]);
            return null;
        }
    }
}
