package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.utils.c;
import com.tencent.open.utils.i;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class a {

    /* compiled from: ProGuard */
    final class AnonymousClass1 extends Handler {
        final /* synthetic */ c a;

        AnonymousClass1(Looper looper, c cVar) {
            this.a = cVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 101:
                    this.a.a(0, (String) message.obj);
                    return;
                case 102:
                    this.a.a(message.arg1, null);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* compiled from: ProGuard */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Handler b;

        AnonymousClass2(String str, Handler handler) {
            this.a = str;
            this.b = handler;
        }

        public final void run() {
            Bitmap a = a.a(this.a, (int) Opcodes.DOUBLE_TO_FLOAT);
            if (a != null) {
                String a2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(Environment.getExternalStorageDirectory());
                stringBuilder.append("/tmp/");
                String stringBuilder2 = stringBuilder.toString();
                String f = i.f(this.a);
                StringBuilder stringBuilder3 = new StringBuilder("share2qq_temp");
                stringBuilder3.append(f);
                stringBuilder3.append(".jpg");
                f = stringBuilder3.toString();
                if (a.b(this.a, (int) Opcodes.DOUBLE_TO_FLOAT, (int) Opcodes.DOUBLE_TO_FLOAT)) {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound,compress!");
                    a2 = a.a(a, stringBuilder2, f);
                } else {
                    f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                    a2 = this.a;
                }
                stringBuilder = new StringBuilder("-->destFilePath: ");
                stringBuilder.append(a2);
                f.b("openSDK_LOG.AsynScaleCompressImage", stringBuilder.toString());
                if (a2 != null) {
                    Message obtainMessage = this.b.obtainMessage(101);
                    obtainMessage.obj = a2;
                    this.b.sendMessage(obtainMessage);
                    return;
                }
            }
            Message obtainMessage2 = this.b.obtainMessage(102);
            obtainMessage2.arg1 = 3;
            this.b.sendMessage(obtainMessage2);
        }
    }

    /* compiled from: ProGuard */
    final class AnonymousClass3 extends Handler {
        final /* synthetic */ c a;

        AnonymousClass3(Looper looper, c cVar) {
            this.a = cVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what != 101) {
                super.handleMessage(message);
                return;
            }
            this.a.a(0, message.getData().getStringArrayList("images"));
        }
    }

    /* compiled from: ProGuard */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ Handler b;

        AnonymousClass4(ArrayList arrayList, Handler handler) {
            this.a = arrayList;
            this.b = handler;
        }

        public final void run() {
            for (int i = 0; i < this.a.size(); i++) {
                Object obj = (String) this.a.get(i);
                if (!i.g((String) obj) && i.h(obj)) {
                    Bitmap a = a.a((String) obj, 10000);
                    if (a != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(Environment.getExternalStorageDirectory());
                        stringBuilder.append("/tmp/");
                        String stringBuilder2 = stringBuilder.toString();
                        String f = i.f((String) obj);
                        StringBuilder stringBuilder3 = new StringBuilder("share2qzone_temp");
                        stringBuilder3.append(f);
                        stringBuilder3.append(".jpg");
                        f = stringBuilder3.toString();
                        if (a.b((String) obj, 640, 10000)) {
                            f.b("openSDK_LOG.AsynScaleCompressImage", "out of bound, compress!");
                            obj = a.a(a, stringBuilder2, f);
                        } else {
                            f.b("openSDK_LOG.AsynScaleCompressImage", "not out of bound,not compress!");
                        }
                        if (obj != null) {
                            this.a.set(i, obj);
                        }
                    }
                }
            }
            Message obtainMessage = this.b.obtainMessage(101);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images", this.a);
            obtainMessage.setData(bundle);
            this.b.sendMessage(obtainMessage);
        }
    }

    public static final void a(Context context, String str, c cVar) {
        f.b("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage");
        if (TextUtils.isEmpty(str)) {
            cVar.a(1, null);
        } else if (i.b()) {
            new Thread(new AnonymousClass2(str, new AnonymousClass1(context.getMainLooper(), cVar))).start();
        } else {
            cVar.a(2, null);
        }
    }

    public static final void a(Context context, ArrayList<String> arrayList, c cVar) {
        f.b("openSDK_LOG.AsynScaleCompressImage", "batchScaleCompressImage");
        if (arrayList == null) {
            cVar.a(1, null);
        } else {
            new Thread(new AnonymousClass4(arrayList, new AnonymousClass3(context.getMainLooper(), cVar))).start();
        }
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        i = ((float) i) / ((float) width);
        matrix.postScale(i, i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    protected static final String a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(str2);
        str = stringBuffer.toString();
        str2 = new File(str);
        if (str2.exists()) {
            str2.delete();
        }
        if (bitmap != null) {
            try {
                OutputStream fileOutputStream = new FileOutputStream(str2);
                bitmap.compress(CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return str;
            } catch (Bitmap bitmap2) {
                bitmap2.printStackTrace();
            } catch (Bitmap bitmap22) {
                bitmap22.printStackTrace();
            }
        }
        return null;
    }

    private static final boolean b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (String str2) {
            str2.printStackTrace();
        }
        str2 = options.outWidth;
        int i3 = options.outHeight;
        if (!(options.mCancel || options.outWidth == -1)) {
            if (options.outHeight != -1) {
                int i4 = str2 > i3 ? str2 : i3;
                if (str2 >= i3) {
                    str2 = i3;
                }
                StringBuilder stringBuilder = new StringBuilder("longSide=");
                stringBuilder.append(i4);
                stringBuilder.append("shortSide=");
                stringBuilder.append(str2);
                f.b("openSDK_LOG.AsynScaleCompressImage", stringBuilder.toString());
                options.inPreferredConfig = Config.RGB_565;
                if (i4 <= i2) {
                    if (str2 <= i) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static final Bitmap a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (!(options.mCancel || options.outWidth == -1)) {
            if (options.outHeight != -1) {
                Bitmap decodeFile;
                if (i2 <= i3) {
                    i2 = i3;
                }
                options.inPreferredConfig = Config.RGB_565;
                if (i2 > i) {
                    options.inSampleSize = a(options, -1, i * i);
                }
                options.inJustDecodeBounds = false;
                try {
                    decodeFile = BitmapFactory.decodeFile(str, options);
                } catch (String str2) {
                    str2.printStackTrace();
                    decodeFile = null;
                }
                if (decodeFile == null) {
                    return null;
                }
                int i4 = options.outWidth;
                int i5 = options.outHeight;
                if (i4 > i5) {
                    i5 = i4;
                }
                return i5 > i ? a(decodeFile, i) : decodeFile;
            }
        }
        return null;
    }

    public static final int a(Options options, int i, int i2) {
        options = b(options, i, i2);
        if (options > 8) {
            return 8 * ((options + 7) / 8);
        }
        i = 1;
        while (i < options) {
            i <<= 1;
        }
        return i;
    }

    private static int b(Options options, int i, int i2) {
        int i3;
        int i4;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i2 == -1) {
            i3 = 1;
        } else {
            i3 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        }
        if (i == -1) {
            i4 = 128;
        } else {
            double d3 = (double) i;
            i4 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i4 < i3) {
            return i3;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? i3 : i4;
    }
}
