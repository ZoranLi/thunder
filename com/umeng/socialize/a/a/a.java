package com.umeng.socialize.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.umeng.socialize.a.b.b;
import com.umeng.socialize.a.b.c;
import com.umeng.socialize.a.b.d;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMImage.CompressStyle;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/* compiled from: ImageImpl */
public class a {
    static {
        com.umeng.socialize.a.b.a.a();
    }

    public static byte[] a(Bitmap bitmap, CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream;
        StringBuilder stringBuilder;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        int i = 100;
                        float rowBytes = (float) ((bitmap.getRowBytes() * bitmap.getHeight()) / 1024);
                        if (rowBytes > c.g) {
                            i = (int) ((c.g / rowBytes) * 100.0f);
                        }
                        StringBuilder stringBuilder2 = new StringBuilder("compress quality:");
                        stringBuilder2.append(i);
                        Log.d("BitmapUtil", stringBuilder2.toString());
                        bitmap.compress(compressFormat, i, byteArrayOutputStream);
                        bitmap = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (CompressFormat compressFormat2) {
                            stringBuilder = new StringBuilder("bitmap2Bytes exception:");
                            stringBuilder.append(compressFormat2.getMessage());
                            Log.um(stringBuilder.toString());
                        }
                        return bitmap;
                    } catch (Exception e) {
                        bitmap = e;
                        try {
                            Log.um(bitmap.getMessage());
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Bitmap bitmap2) {
                                    compressFormat2 = new StringBuilder("bitmap2Bytes exception:");
                                    compressFormat2.append(bitmap2.getMessage());
                                    Log.um(compressFormat2.toString());
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            bitmap2 = th;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (CompressFormat compressFormat22) {
                                    stringBuilder = new StringBuilder("bitmap2Bytes exception:");
                                    stringBuilder.append(compressFormat22.getMessage());
                                    Log.um(stringBuilder.toString());
                                }
                            }
                            throw bitmap2;
                        }
                    }
                } catch (Exception e2) {
                    bitmap2 = e2;
                    byteArrayOutputStream = null;
                    Log.um(bitmap2.getMessage());
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    bitmap2 = th2;
                    byteArrayOutputStream = null;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw bitmap2;
                }
            }
        }
        return null;
    }

    public static Options a(byte[] bArr) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        bArr = (int) Math.ceil((double) (options.outWidth / UMImage.MAX_WIDTH));
        int ceil = (int) Math.ceil((double) (options.outHeight / UMImage.MAX_HEIGHT));
        if (ceil <= 1 || bArr <= 1) {
            if (ceil > 2) {
                options.inSampleSize = ceil;
            } else if (bArr > 2) {
                options.inSampleSize = bArr;
            }
        } else if (ceil > bArr) {
            options.inSampleSize = ceil;
        } else {
            options.inSampleSize = bArr;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    public static byte[] a(UMImage uMImage, int i) {
        if (!(uMImage == null || uMImage.asBinImage() == null)) {
            if (a(uMImage) >= i) {
                if (uMImage.compressStyle == CompressStyle.QUALITY) {
                    return a(uMImage.asBinImage(), i, uMImage.compressFormat);
                }
                try {
                    byte[] asBinImage = uMImage.asBinImage();
                    if (asBinImage.length <= 0) {
                        return uMImage.asBinImage();
                    }
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(asBinImage, 0, asBinImage.length);
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(asBinImage, 0, asBinImage.length);
                    while (byteArrayOutputStream.toByteArray().length > i) {
                        double sqrt = Math.sqrt((1.0d * ((double) asBinImage.length)) / ((double) i));
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, (int) (((double) decodeByteArray.getWidth()) / sqrt), (int) (((double) decodeByteArray.getHeight()) / sqrt), true);
                        byteArrayOutputStream.reset();
                        decodeByteArray.compress(uMImage.compressFormat, 100, byteArrayOutputStream);
                        asBinImage = byteArrayOutputStream.toByteArray();
                    }
                    if (byteArrayOutputStream.toByteArray().length > i) {
                        return null;
                    }
                    return asBinImage;
                } catch (UMImage uMImage2) {
                    i = new StringBuilder();
                    i.append(UmengText.OOM);
                    i.append(uMImage2.getMessage());
                    Log.um(i.toString());
                    return null;
                }
            }
        }
        return uMImage2.asBinImage();
    }

    public static byte[] a(String str) {
        return SocializeNetUtils.getNetData(str);
    }

    public static Bitmap b(byte[] bArr) {
        return bArr != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length) : null;
    }

    public static File c(byte[] bArr) {
        try {
            return a(bArr, b.a().b());
        } catch (byte[] bArr2) {
            StringBuilder stringBuilder = new StringBuilder("binary2File:");
            stringBuilder.append(bArr2.getMessage());
            Log.um(stringBuilder.toString());
            return null;
        }
    }

    private static java.io.File a(byte[] r3, java.io.File r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x001a }
        r1.<init>(r4);	 Catch:{ Exception -> 0x001a }
        r2 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x001a }
        r2.<init>(r1);	 Catch:{ Exception -> 0x001a }
        r2.write(r3);	 Catch:{ Exception -> 0x0015, all -> 0x0012 }
        r2.close();	 Catch:{ IOException -> 0x0038 }
        goto L_0x0038;
    L_0x0012:
        r3 = move-exception;
        r0 = r2;
        goto L_0x0039;
    L_0x0015:
        r3 = move-exception;
        r0 = r2;
        goto L_0x001b;
    L_0x0018:
        r3 = move-exception;
        goto L_0x0039;
    L_0x001a:
        r3 = move-exception;
    L_0x001b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0018 }
        r1.<init>();	 Catch:{ all -> 0x0018 }
        r2 = com.umeng.socialize.utils.UmengText.GET_FILE_FROM_BINARY;	 Catch:{ all -> 0x0018 }
        r1.append(r2);	 Catch:{ all -> 0x0018 }
        r3 = r3.getMessage();	 Catch:{ all -> 0x0018 }
        r1.append(r3);	 Catch:{ all -> 0x0018 }
        r3 = r1.toString();	 Catch:{ all -> 0x0018 }
        com.umeng.socialize.utils.Log.um(r3);	 Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x0038;
    L_0x0035:
        r0.close();	 Catch:{ IOException -> 0x0038 }
    L_0x0038:
        return r4;
    L_0x0039:
        if (r0 == 0) goto L_0x003e;
    L_0x003b:
        r0.close();	 Catch:{ IOException -> 0x003e }
    L_0x003e:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.a.a.a.a(byte[], java.io.File):java.io.File");
    }

    public static byte[] b(Bitmap bitmap, CompressFormat compressFormat) {
        return a(bitmap, compressFormat);
    }

    static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] a(Context context, int i, boolean z, CompressFormat compressFormat) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (z) {
            z = new byte[false];
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options).compress(compressFormat, 100, byteArrayOutputStream);
                context = byteArrayOutputStream.toByteArray();
            } catch (Context context2) {
                i = new StringBuilder("加载图片过大=");
                i.append(context2.getMessage());
                Log.um(i.toString());
                context2 = z;
            }
            return context2;
        }
        Drawable drawable;
        context2 = context2.getResources();
        if (VERSION.SDK_INT >= true) {
            drawable = context2.getDrawable(i, null);
        } else {
            drawable = context2.getDrawable(i);
        }
        a(drawable).compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] a(File file, CompressFormat compressFormat) {
        return b(file, compressFormat);
    }

    public static String d(byte[] bArr) {
        return d.a(bArr);
    }

    public static int a(UMImage uMImage) {
        if (uMImage.getImageStyle() == UMImage.FILE_IMAGE) {
            return a(uMImage.asFileImage());
        }
        return e(uMImage.asBinImage());
    }

    private static byte[] b(File file, CompressFormat compressFormat) {
        if (file != null) {
            if (file.getAbsoluteFile().exists()) {
                byte[] a = b.a().a(file);
                if (!SocializeUtils.assertBinaryInvalid(a)) {
                    return null;
                }
                if (d.m[1].equals(d.a(a))) {
                    return a;
                }
                return a(a, compressFormat);
            }
        }
        return null;
    }

    private static byte[] a(byte[] bArr, CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream;
        StringBuilder stringBuilder;
        try {
            bArr = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, a(bArr));
            byteArrayOutputStream = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    bArr.compress(compressFormat, 100, byteArrayOutputStream);
                    bArr.recycle();
                    System.gc();
                } catch (Exception e) {
                    bArr = e;
                    try {
                        compressFormat = new StringBuilder();
                        compressFormat.append(UmengText.FILE_TO_BINARY_ERROR);
                        compressFormat.append(bArr.getMessage());
                        Log.um(compressFormat.toString());
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (byte[] bArr2) {
                                compressFormat = new StringBuilder();
                                compressFormat.append(UmengText.FILE_TO_BINARY_ERROR);
                                compressFormat.append(bArr2.getMessage());
                                Log.um(compressFormat.toString());
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        bArr2 = th;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (CompressFormat compressFormat2) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(UmengText.FILE_TO_BINARY_ERROR);
                                stringBuilder.append(compressFormat2.getMessage());
                                Log.um(stringBuilder.toString());
                            }
                        }
                        throw bArr2;
                    }
                }
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return bArr2;
            } catch (CompressFormat compressFormat22) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UmengText.FILE_TO_BINARY_ERROR);
                stringBuilder.append(compressFormat22.getMessage());
                Log.um(stringBuilder.toString());
                return bArr2;
            }
        } catch (Exception e2) {
            bArr2 = e2;
            byteArrayOutputStream = null;
            compressFormat22 = new StringBuilder();
            compressFormat22.append(UmengText.FILE_TO_BINARY_ERROR);
            compressFormat22.append(bArr2.getMessage());
            Log.um(compressFormat22.toString());
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            bArr2 = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw bArr2;
        }
    }

    public static byte[] a(byte[] bArr, int i, CompressFormat compressFormat) {
        if (bArr == null || bArr.length < i) {
            return bArr;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        bArr = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        int i3 = 1;
        while (i2 == 0 && i3 <= 10) {
            bArr.compress(compressFormat, (int) (100.0d * Math.pow(0.8d, (double) i3)), byteArrayOutputStream);
            if (byteArrayOutputStream.size() < i) {
                i2 = 1;
            } else {
                byteArrayOutputStream.reset();
                i3++;
            }
        }
        i = byteArrayOutputStream.toByteArray();
        if (bArr.isRecycled() == null) {
            bArr.recycle();
        }
        if (i != 0 && i.length <= null) {
            Log.um(UmengText.THUMB_ERROR);
        }
        return i;
    }

    private static int e(byte[] bArr) {
        return bArr != null ? bArr.length : null;
    }

    private static int a(File file) {
        StringBuilder stringBuilder;
        if (file != null) {
            try {
                return new FileInputStream(file).available();
            } catch (File file2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UmengText.GET_IMAGE_SCALE_ERROR);
                stringBuilder.append(file2.getMessage());
                Log.um(stringBuilder.toString());
            } catch (File file22) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UmengText.GET_IMAGE_SCALE_ERROR);
                stringBuilder.append(file22.getMessage());
                Log.um(stringBuilder.toString());
            }
        }
        return null;
    }
}
