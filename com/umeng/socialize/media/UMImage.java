package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.a.a.a;
import com.umeng.socialize.media.UMediaObject.MediaType;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class UMImage extends BaseMediaObject {
    public static int BINARY_IMAGE = 5;
    public static int BITMAP_IMAGE = 4;
    public static int FILE_IMAGE = 1;
    public static int MAX_HEIGHT = 1024;
    public static int MAX_WIDTH = 768;
    public static int RES_IMAGE = 3;
    public static int URL_IMAGE = 2;
    public CompressFormat compressFormat = CompressFormat.JPEG;
    public CompressStyle compressStyle = CompressStyle.SCALE;
    private ConfiguredConvertor f = null;
    private UMImage g;
    private UMImageMark h;
    private int i = 0;
    public boolean isLoadImgByCompress = true;
    private boolean j;

    public enum CompressStyle {
        SCALE,
        QUALITY
    }

    interface IImageConvertor {
        byte[] asBinary();

        Bitmap asBitmap();

        File asFile();

        String asUrl();
    }

    static abstract class ConfiguredConvertor implements IImageConvertor {
        ConfiguredConvertor() {
        }
    }

    class BinaryConvertor extends ConfiguredConvertor {
        final /* synthetic */ UMImage a;
        private byte[] b;

        public String asUrl() {
            return null;
        }

        public BinaryConvertor(UMImage uMImage, byte[] bArr) {
            this.a = uMImage;
            this.b = bArr;
        }

        public File asFile() {
            return SocializeUtils.assertBinaryInvalid(asBinary()) ? a.c(asBinary()) : null;
        }

        public byte[] asBinary() {
            return this.b;
        }

        public Bitmap asBitmap() {
            return SocializeUtils.assertBinaryInvalid(asBinary()) ? a.b(asBinary()) : null;
        }
    }

    class BitmapConvertor extends ConfiguredConvertor {
        final /* synthetic */ UMImage a;
        private Bitmap b;

        public String asUrl() {
            return null;
        }

        public BitmapConvertor(UMImage uMImage, Bitmap bitmap) {
            this.a = uMImage;
            this.b = bitmap;
        }

        public File asFile() {
            return SocializeUtils.assertBinaryInvalid(asBinary()) ? a.c(a.b(this.b, this.a.compressFormat)) : null;
        }

        public byte[] asBinary() {
            return a.b(this.b, this.a.compressFormat);
        }

        public Bitmap asBitmap() {
            return this.b;
        }
    }

    class FileConvertor extends ConfiguredConvertor {
        final /* synthetic */ UMImage a;
        private File b;

        public String asUrl() {
            return null;
        }

        public FileConvertor(UMImage uMImage, File file) {
            this.a = uMImage;
            this.b = file;
        }

        public File asFile() {
            return this.b;
        }

        public byte[] asBinary() {
            return a.a(this.b, this.a.compressFormat);
        }

        public Bitmap asBitmap() {
            return SocializeUtils.assertBinaryInvalid(asBinary()) ? a.b(this.a.asBinImage()) : null;
        }
    }

    class ResConvertor extends ConfiguredConvertor {
        final /* synthetic */ UMImage a;
        private Context b;
        private int c = null;

        public String asUrl() {
            return null;
        }

        public ResConvertor(UMImage uMImage, Context context, int i) {
            this.a = uMImage;
            this.b = context;
            this.c = i;
        }

        public File asFile() {
            return SocializeUtils.assertBinaryInvalid(asBinary()) ? a.c(asBinary()) : null;
        }

        public byte[] asBinary() {
            return a.a(this.b, this.c, this.a.isLoadImgByCompress, this.a.compressFormat);
        }

        public Bitmap asBitmap() {
            return SocializeUtils.assertBinaryInvalid(asBinary()) ? a.b(asBinary()) : null;
        }
    }

    class UrlConvertor extends ConfiguredConvertor {
        final /* synthetic */ UMImage a;
        private String b = null;

        public UrlConvertor(UMImage uMImage, String str) {
            this.a = uMImage;
            this.b = str;
        }

        public File asFile() {
            return SocializeUtils.assertBinaryInvalid(asBinary()) ? a.c(asBinary()) : null;
        }

        public String asUrl() {
            return this.b;
        }

        public byte[] asBinary() {
            return a.a(this.b);
        }

        public Bitmap asBitmap() {
            return SocializeUtils.assertBinaryInvalid(asBinary()) ? a.b(asBinary()) : null;
        }
    }

    private float a(float f, float f2, float f3, float f4) {
        if (f <= f4 && f2 <= f4) {
            return -1.0f;
        }
        f /= f3;
        f2 /= f4;
        return f > f2 ? f : f2;
    }

    public UMImage(Context context, File file) {
        a(context, (Object) file);
    }

    public UMImage(Context context, String str) {
        super(str);
        a((Context) new WeakReference(context).get(), (Object) str);
    }

    public UMImage(Context context, int i) {
        a(context, Integer.valueOf(i));
    }

    public UMImage(Context context, byte[] bArr) {
        a(context, (Object) bArr);
    }

    public UMImage(Context context, Bitmap bitmap) {
        a(context, (Object) bitmap);
    }

    public UMImage(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        a(context, bitmap, uMImageMark);
    }

    public UMImage(Context context, int i, UMImageMark uMImageMark) {
        a(context, Integer.valueOf(i), uMImageMark);
    }

    public UMImage(Context context, byte[] bArr, UMImageMark uMImageMark) {
        a(context, bArr, uMImageMark);
    }

    private void a(Context context, Object obj) {
        a(context, obj, null);
    }

    private void a(Context context, Object obj, UMImageMark uMImageMark) {
        if (uMImageMark != null) {
            this.j = true;
            this.h = uMImageMark;
            this.h.setContext(context);
        }
        if (ContextUtil.getContext() == null) {
            ContextUtil.setContext(context.getApplicationContext());
        }
        if ((obj instanceof File) != null) {
            this.i = FILE_IMAGE;
            this.f = new FileConvertor(this, (File) obj);
        } else if ((obj instanceof String) != null) {
            this.i = URL_IMAGE;
            this.f = new UrlConvertor(this, (String) obj);
        } else {
            Bitmap bitmap = null;
            if ((obj instanceof Integer) != null) {
                this.i = RES_IMAGE;
                if (isHasWaterMark() != null) {
                    bitmap = a(context, ((Integer) obj).intValue());
                }
                if (bitmap != null) {
                    this.f = new BitmapConvertor(this, bitmap);
                } else {
                    this.f = new ResConvertor(this, context.getApplicationContext(), ((Integer) obj).intValue());
                }
            } else if ((obj instanceof byte[]) != null) {
                this.i = BINARY_IMAGE;
                if (isHasWaterMark() != null) {
                    bitmap = a((byte[]) obj);
                }
                if (bitmap != null) {
                    this.f = new BitmapConvertor(this, bitmap);
                } else {
                    this.f = new BinaryConvertor(this, (byte[]) obj);
                }
            } else if ((obj instanceof Bitmap) != null) {
                this.i = BITMAP_IMAGE;
                if (isHasWaterMark() != null) {
                    bitmap = a((Bitmap) obj, true);
                }
                if (bitmap == null) {
                    bitmap = (Bitmap) obj;
                }
                this.f = new BitmapConvertor(this, bitmap);
            } else {
                throw new RuntimeException(UmengText.UNKNOW_UMIMAGE);
            }
        }
    }

    public byte[] toByte() {
        return asBinImage();
    }

    public void setThumb(UMImage uMImage) {
        this.g = uMImage;
    }

    public UMImage getThumbImage() {
        return this.g;
    }

    public final Map<String, Object> toUrlExtraParams() {
        Map<String, Object> hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    public MediaType getMediaType() {
        return MediaType.IMAGE;
    }

    public int getImageStyle() {
        return this.i;
    }

    public File asFileImage() {
        return this.f == null ? null : this.f.asFile();
    }

    public String asUrlImage() {
        return this.f == null ? null : this.f.asUrl();
    }

    public byte[] asBinImage() {
        return this.f == null ? null : this.f.asBinary();
    }

    public Bitmap asBitmap() {
        return this.f == null ? null : this.f.asBitmap();
    }

    private Bitmap a(Bitmap bitmap, boolean z) {
        if (this.h == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z) {
            try {
                bitmap = a(bitmap);
            } catch (Bitmap bitmap2) {
                bitmap2.printStackTrace();
                return null;
            }
        }
        return this.h.compound(bitmap2);
    }

    private Bitmap a(Context context, int i) {
        Closeable openRawResource;
        if (!(i == 0 || context == null)) {
            if (this.h != null) {
                try {
                    Closeable openRawResource2;
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    openRawResource = context.getResources().openRawResource(i);
                    try {
                        BitmapFactory.decodeStream(openRawResource, null, options);
                        a(openRawResource);
                        int a = (int) a((float) options.outWidth, (float) options.outHeight, (float) MAX_WIDTH, (float) MAX_HEIGHT);
                        if (a > 0) {
                            options.inSampleSize = a;
                        }
                        options.inJustDecodeBounds = false;
                        openRawResource2 = context.getResources().openRawResource(i);
                    } catch (Exception e) {
                        context = e;
                        try {
                            context.printStackTrace();
                            a(openRawResource);
                            return null;
                        } catch (Throwable th) {
                            context = th;
                            a(openRawResource);
                            throw context;
                        }
                    }
                    try {
                        i = a(BitmapFactory.decodeStream(openRawResource2, null, options), false);
                        a(openRawResource2);
                        return i;
                    } catch (int i2) {
                        openRawResource = openRawResource2;
                        context = i2;
                        context.printStackTrace();
                        a(openRawResource);
                        return null;
                    } catch (int i22) {
                        openRawResource = openRawResource2;
                        context = i22;
                        a(openRawResource);
                        throw context;
                    }
                } catch (Exception e2) {
                    context = e2;
                    openRawResource = null;
                    context.printStackTrace();
                    a(openRawResource);
                    return null;
                } catch (Throwable th2) {
                    context = th2;
                    openRawResource = null;
                    a(openRawResource);
                    throw context;
                }
            }
        }
        return null;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                closeable2.printStackTrace();
            }
        }
    }

    private Bitmap a(byte[] bArr) {
        if (bArr != null) {
            if (this.h != null) {
                try {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    int a = (int) a((float) options.outWidth, (float) options.outHeight, (float) MAX_WIDTH, (float) MAX_HEIGHT);
                    if (a > 0) {
                        options.inSampleSize = a;
                    }
                    options.inJustDecodeBounds = false;
                    return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
                } catch (byte[] bArr2) {
                    bArr2.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float a = a((float) width, (float) height, (float) MAX_WIDTH, (float) MAX_HEIGHT);
        if (a < 0.0f) {
            return bitmap;
        }
        float f = 1.0f / a;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        b(bitmap);
        return createBitmap;
    }

    private void b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Bitmap bitmap2) {
                bitmap2.printStackTrace();
            }
        }
    }

    public boolean isHasWaterMark() {
        return this.j;
    }
}
