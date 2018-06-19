package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import org.android.agoo.common.AgooConstants;

public class libwebp {
    private static final int BITMAP_ALPHA_8 = 1;
    private static final int BITMAP_ARGB_4444 = 3;
    private static final int BITMAP_ARGB_8888 = 4;
    private static final int BITMAP_RGB_565 = 2;
    private static final String LOGTAG = "[image]";
    private static boolean isMultiCore = false;
    private static libwebp mInstance = null;
    private static boolean mIsLoadLibSuccess = false;
    private int mBitmapType = 4;

    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = android.graphics.Bitmap.Config.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$android$graphics$Bitmap$Config = r0;
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.graphics.Bitmap.Config.ARGB_4444;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$android$graphics$Bitmap$Config;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.libwebp.1.<clinit>():void");
        }
    }

    public static int checkIsHuaModel() {
        String toLowerCase = Build.BRAND.trim().toLowerCase();
        String toLowerCase2 = Build.MODEL.trim().toLowerCase();
        int i = (toLowerCase == null || toLowerCase.length() <= 0 || !toLowerCase.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) ? 0 : 1;
        return (toLowerCase2 == null || toLowerCase2.length() <= 0 || !toLowerCase2.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) ? i : 1;
    }

    private String getCPUinfo() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start().getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(new String(bArr));
                str = stringBuilder.toString();
            }
            inputStream.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static libwebp getInstance(Context context) {
        if (mInstance == null) {
            loadWepLibraryIfNeed(context);
            mInstance = new libwebp();
        }
        return mInstance;
    }

    private boolean isMultiCore() {
        return getCPUinfo().contains("processor");
    }

    public static void loadWepLibraryIfNeed(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = mIsLoadLibSuccess;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = "webp_base";	 Catch:{ UnsatisfiedLinkError -> 0x000c }
        com.tencent.smtt.export.external.LibraryLoader.loadLibrary(r1, r0);	 Catch:{ UnsatisfiedLinkError -> 0x000c }
        r1 = 1;	 Catch:{ UnsatisfiedLinkError -> 0x000c }
        mIsLoadLibSuccess = r1;	 Catch:{ UnsatisfiedLinkError -> 0x000c }
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.libwebp.loadWepLibraryIfNeed(android.content.Context):void");
    }

    public static void loadWepLibraryIfNeed(android.content.Context r0, java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = mIsLoadLibSuccess;
        if (r0 != 0) goto L_0x0020;
    L_0x0004:
        r0 = new java.lang.StringBuilder;	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        r0.<init>();	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        r0.append(r1);	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        r1 = java.io.File.separator;	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        r0.append(r1);	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        r1 = "libwebp_base.so";	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        r0.append(r1);	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        r0 = r0.toString();	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        java.lang.System.load(r0);	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        r0 = 1;	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
        mIsLoadLibSuccess = r0;	 Catch:{ UnsatisfiedLinkError -> 0x0020 }
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.libwebp.loadWepLibraryIfNeed(android.content.Context, java.lang.String):void");
    }

    public int[] decodeBase(byte[] bArr, int[] iArr, int[] iArr2) {
        return !mIsLoadLibSuccess ? null : nativeDecode(bArr, isMultiCore, iArr, iArr2);
    }

    public int[] decodeBase_16bit(byte[] bArr, Config config) {
        if (!mIsLoadLibSuccess) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                this.mBitmapType = 3;
                break;
            default:
                this.mBitmapType = 2;
                break;
        }
        return nativeDecode_16bit(bArr, isMultiCore, this.mBitmapType);
    }

    public int[] decodeInto(byte[] bArr, int[] iArr, int[] iArr2) {
        return !mIsLoadLibSuccess ? null : nativeDecodeInto(bArr, isMultiCore, iArr, iArr2);
    }

    public int getInfo(byte[] bArr, int[] iArr, int[] iArr2) {
        return !mIsLoadLibSuccess ? 0 : nativeGetInfo(bArr, iArr, iArr2);
    }

    public int[] incDecode(byte[] bArr, int[] iArr, int[] iArr2) {
        return !mIsLoadLibSuccess ? null : nativeIDecode(bArr, isMultiCore, iArr, iArr2);
    }

    public native int[] nativeDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecodeInto(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecode_16bit(byte[] bArr, boolean z, int i);

    public native int nativeGetInfo(byte[] bArr, int[] iArr, int[] iArr2);

    public native int[] nativeIDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);
}
