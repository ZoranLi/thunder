package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.support.annotation.RequiresApi;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.FileNotFoundException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    private final PrintHelperVersionImpl mImpl;

    @Retention(RetentionPolicy.SOURCE)
    private @interface ColorMode {
    }

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface Orientation {
    }

    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ScaleMode {
    }

    @RequiresApi(19)
    private static class PrintHelperApi19 implements PrintHelperVersionImpl {
        private static final String LOG_TAG = "PrintHelperApi19";
        private static final int MAX_PRINT_SIZE = 3500;
        int mColorMode = 2;
        final Context mContext;
        Options mDecodeOptions = null;
        protected boolean mIsMinMarginsHandlingCorrect = true;
        private final Object mLock = new Object();
        int mOrientation;
        protected boolean mPrintActivityRespectsOrientation = true;
        int mScaleMode = 2;

        PrintHelperApi19(Context context) {
            this.mContext = context;
        }

        public void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        public int getScaleMode() {
            return this.mScaleMode;
        }

        public void setColorMode(int i) {
            this.mColorMode = i;
        }

        public void setOrientation(int i) {
            this.mOrientation = i;
        }

        public int getOrientation() {
            if (this.mOrientation == 0) {
                return 1;
            }
            return this.mOrientation;
        }

        public int getColorMode() {
            return this.mColorMode;
        }

        private static boolean isPortrait(Bitmap bitmap) {
            return bitmap.getWidth() <= bitmap.getHeight() ? true : null;
        }

        protected Builder copyAttributes(PrintAttributes printAttributes) {
            Builder minMargins = new Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
            if (printAttributes.getColorMode() != 0) {
                minMargins.setColorMode(printAttributes.getColorMode());
            }
            return minMargins;
        }

        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            if (bitmap != null) {
                MediaSize mediaSize;
                final int i = this.mScaleMode;
                PrintManager printManager = (PrintManager) this.mContext.getSystemService(SharePatchInfo.FINGER_PRINT);
                if (isPortrait(bitmap)) {
                    mediaSize = MediaSize.UNKNOWN_PORTRAIT;
                } else {
                    mediaSize = MediaSize.UNKNOWN_LANDSCAPE;
                }
                final String str2 = str;
                final Bitmap bitmap2 = bitmap;
                final OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
                printManager.print(str, new PrintDocumentAdapter() {
                    private PrintAttributes mAttributes;

                    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
                        this.mAttributes = printAttributes2;
                        layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(str2).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ^ 1);
                    }

                    public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
                        PrintHelperApi19.this.writeBitmap(this.mAttributes, i, bitmap2, parcelFileDescriptor, cancellationSignal, writeResultCallback);
                    }

                    public void onFinish() {
                        if (onPrintFinishCallback2 != null) {
                            onPrintFinishCallback2.onFinish();
                        }
                    }
                }, new Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build());
            }
        }

        private Matrix getMatrix(int i, int i2, RectF rectF, int i3) {
            Matrix matrix = new Matrix();
            i = (float) i;
            float width = rectF.width() / i;
            if (i3 == 2) {
                i3 = Math.max(width, rectF.height() / ((float) i2));
            } else {
                i3 = Math.min(width, rectF.height() / ((float) i2));
            }
            matrix.postScale(i3, i3);
            matrix.postTranslate((rectF.width() - (i * i3)) / 2.0f, (rectF.height() - (((float) i2) * i3)) / 1073741824);
            return matrix;
        }

        private void writeBitmap(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
            PrintAttributes printAttributes2;
            if (this.mIsMinMarginsHandlingCorrect) {
                printAttributes2 = printAttributes;
            } else {
                printAttributes2 = copyAttributes(printAttributes).setMinMargins(new Margins(0, 0, 0, 0)).build();
            }
            final CancellationSignal cancellationSignal2 = cancellationSignal;
            final Bitmap bitmap2 = bitmap;
            final PrintAttributes printAttributes3 = printAttributes;
            final int i2 = i;
            final ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
            final WriteResultCallback writeResultCallback2 = writeResultCallback;
            new AsyncTask<Void, Void, Throwable>() {
                protected java.lang.Throwable doInBackground(java.lang.Void... r9) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                    /*
                    r8 = this;
                    r9 = r2;	 Catch:{ Throwable -> 0x00e9 }
                    r9 = r9.isCanceled();	 Catch:{ Throwable -> 0x00e9 }
                    r0 = 0;	 Catch:{ Throwable -> 0x00e9 }
                    if (r9 == 0) goto L_0x000a;	 Catch:{ Throwable -> 0x00e9 }
                L_0x0009:
                    return r0;	 Catch:{ Throwable -> 0x00e9 }
                L_0x000a:
                    r9 = new android.print.pdf.PrintedPdfDocument;	 Catch:{ Throwable -> 0x00e9 }
                    r1 = android.support.v4.print.PrintHelper.PrintHelperApi19.this;	 Catch:{ Throwable -> 0x00e9 }
                    r1 = r1.mContext;	 Catch:{ Throwable -> 0x00e9 }
                    r2 = r3;	 Catch:{ Throwable -> 0x00e9 }
                    r9.<init>(r1, r2);	 Catch:{ Throwable -> 0x00e9 }
                    r1 = android.support.v4.print.PrintHelper.PrintHelperApi19.this;	 Catch:{ Throwable -> 0x00e9 }
                    r2 = r4;	 Catch:{ Throwable -> 0x00e9 }
                    r3 = r3;	 Catch:{ Throwable -> 0x00e9 }
                    r3 = r3.getColorMode();	 Catch:{ Throwable -> 0x00e9 }
                    r1 = r1.convertBitmapForColorMode(r2, r3);	 Catch:{ Throwable -> 0x00e9 }
                    r2 = r2;	 Catch:{ Throwable -> 0x00e9 }
                    r2 = r2.isCanceled();	 Catch:{ Throwable -> 0x00e9 }
                    if (r2 == 0) goto L_0x002c;
                L_0x002b:
                    return r0;
                L_0x002c:
                    r2 = 1;
                    r3 = r9.startPage(r2);	 Catch:{ all -> 0x00d4 }
                    r4 = android.support.v4.print.PrintHelper.PrintHelperApi19.this;	 Catch:{ all -> 0x00d4 }
                    r4 = r4.mIsMinMarginsHandlingCorrect;	 Catch:{ all -> 0x00d4 }
                    if (r4 == 0) goto L_0x0045;	 Catch:{ all -> 0x00d4 }
                L_0x0037:
                    r2 = new android.graphics.RectF;	 Catch:{ all -> 0x00d4 }
                    r4 = r3.getInfo();	 Catch:{ all -> 0x00d4 }
                    r4 = r4.getContentRect();	 Catch:{ all -> 0x00d4 }
                    r2.<init>(r4);	 Catch:{ all -> 0x00d4 }
                    goto L_0x0068;	 Catch:{ all -> 0x00d4 }
                L_0x0045:
                    r4 = new android.print.pdf.PrintedPdfDocument;	 Catch:{ all -> 0x00d4 }
                    r5 = android.support.v4.print.PrintHelper.PrintHelperApi19.this;	 Catch:{ all -> 0x00d4 }
                    r5 = r5.mContext;	 Catch:{ all -> 0x00d4 }
                    r6 = r5;	 Catch:{ all -> 0x00d4 }
                    r4.<init>(r5, r6);	 Catch:{ all -> 0x00d4 }
                    r2 = r4.startPage(r2);	 Catch:{ all -> 0x00d4 }
                    r5 = new android.graphics.RectF;	 Catch:{ all -> 0x00d4 }
                    r6 = r2.getInfo();	 Catch:{ all -> 0x00d4 }
                    r6 = r6.getContentRect();	 Catch:{ all -> 0x00d4 }
                    r5.<init>(r6);	 Catch:{ all -> 0x00d4 }
                    r4.finishPage(r2);	 Catch:{ all -> 0x00d4 }
                    r4.close();	 Catch:{ all -> 0x00d4 }
                    r2 = r5;	 Catch:{ all -> 0x00d4 }
                L_0x0068:
                    r4 = android.support.v4.print.PrintHelper.PrintHelperApi19.this;	 Catch:{ all -> 0x00d4 }
                    r5 = r1.getWidth();	 Catch:{ all -> 0x00d4 }
                    r6 = r1.getHeight();	 Catch:{ all -> 0x00d4 }
                    r7 = r6;	 Catch:{ all -> 0x00d4 }
                    r4 = r4.getMatrix(r5, r6, r2, r7);	 Catch:{ all -> 0x00d4 }
                    r5 = android.support.v4.print.PrintHelper.PrintHelperApi19.this;	 Catch:{ all -> 0x00d4 }
                    r5 = r5.mIsMinMarginsHandlingCorrect;	 Catch:{ all -> 0x00d4 }
                    if (r5 != 0) goto L_0x008c;	 Catch:{ all -> 0x00d4 }
                L_0x007e:
                    r5 = r2.left;	 Catch:{ all -> 0x00d4 }
                    r6 = r2.top;	 Catch:{ all -> 0x00d4 }
                    r4.postTranslate(r5, r6);	 Catch:{ all -> 0x00d4 }
                    r5 = r3.getCanvas();	 Catch:{ all -> 0x00d4 }
                    r5.clipRect(r2);	 Catch:{ all -> 0x00d4 }
                L_0x008c:
                    r2 = r3.getCanvas();	 Catch:{ all -> 0x00d4 }
                    r2.drawBitmap(r1, r4, r0);	 Catch:{ all -> 0x00d4 }
                    r9.finishPage(r3);	 Catch:{ all -> 0x00d4 }
                    r2 = r2;	 Catch:{ all -> 0x00d4 }
                    r2 = r2.isCanceled();	 Catch:{ all -> 0x00d4 }
                    if (r2 == 0) goto L_0x00b2;
                L_0x009e:
                    r9.close();	 Catch:{ Throwable -> 0x00e9 }
                    r9 = r7;	 Catch:{ Throwable -> 0x00e9 }
                    if (r9 == 0) goto L_0x00aa;
                L_0x00a5:
                    r9 = r7;	 Catch:{ IOException -> 0x00aa }
                    r9.close();	 Catch:{ IOException -> 0x00aa }
                L_0x00aa:
                    r9 = r4;	 Catch:{ Throwable -> 0x00e9 }
                    if (r1 == r9) goto L_0x00b1;	 Catch:{ Throwable -> 0x00e9 }
                L_0x00ae:
                    r1.recycle();	 Catch:{ Throwable -> 0x00e9 }
                L_0x00b1:
                    return r0;
                L_0x00b2:
                    r2 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00d4 }
                    r3 = r7;	 Catch:{ all -> 0x00d4 }
                    r3 = r3.getFileDescriptor();	 Catch:{ all -> 0x00d4 }
                    r2.<init>(r3);	 Catch:{ all -> 0x00d4 }
                    r9.writeTo(r2);	 Catch:{ all -> 0x00d4 }
                    r9.close();	 Catch:{ Throwable -> 0x00e9 }
                    r9 = r7;	 Catch:{ Throwable -> 0x00e9 }
                    if (r9 == 0) goto L_0x00cc;
                L_0x00c7:
                    r9 = r7;	 Catch:{ IOException -> 0x00cc }
                    r9.close();	 Catch:{ IOException -> 0x00cc }
                L_0x00cc:
                    r9 = r4;	 Catch:{ Throwable -> 0x00e9 }
                    if (r1 == r9) goto L_0x00d3;	 Catch:{ Throwable -> 0x00e9 }
                L_0x00d0:
                    r1.recycle();	 Catch:{ Throwable -> 0x00e9 }
                L_0x00d3:
                    return r0;	 Catch:{ Throwable -> 0x00e9 }
                L_0x00d4:
                    r0 = move-exception;	 Catch:{ Throwable -> 0x00e9 }
                    r9.close();	 Catch:{ Throwable -> 0x00e9 }
                    r9 = r7;	 Catch:{ Throwable -> 0x00e9 }
                    if (r9 == 0) goto L_0x00e1;
                L_0x00dc:
                    r9 = r7;	 Catch:{ IOException -> 0x00e1 }
                    r9.close();	 Catch:{ IOException -> 0x00e1 }
                L_0x00e1:
                    r9 = r4;	 Catch:{ Throwable -> 0x00e9 }
                    if (r1 == r9) goto L_0x00e8;	 Catch:{ Throwable -> 0x00e9 }
                L_0x00e5:
                    r1.recycle();	 Catch:{ Throwable -> 0x00e9 }
                L_0x00e8:
                    throw r0;	 Catch:{ Throwable -> 0x00e9 }
                L_0x00e9:
                    r9 = move-exception;
                    return r9;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintHelperApi19.2.doInBackground(java.lang.Void[]):java.lang.Throwable");
                }

                protected void onPostExecute(Throwable th) {
                    if (cancellationSignal2.isCanceled()) {
                        writeResultCallback2.onWriteCancelled();
                    } else if (th == null) {
                        writeResultCallback2.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    } else {
                        writeResultCallback2.onWriteFailed(null);
                    }
                }
            }.execute(new Void[0]);
        }

        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
            final int i = this.mScaleMode;
            final String str2 = str;
            final Uri uri2 = uri;
            final OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
            PrintDocumentAdapter anonymousClass3 = new PrintDocumentAdapter() {
                private PrintAttributes mAttributes;
                Bitmap mBitmap = null;
                AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;

                public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
                    synchronized (this) {
                        this.mAttributes = printAttributes2;
                    }
                    if (cancellationSignal.isCanceled() != null) {
                        layoutResultCallback.onLayoutCancelled();
                    } else if (this.mBitmap != null) {
                        layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(str2).setContentType(1).setPageCount(1).build(), printAttributes2.equals(printAttributes) ^ 1);
                    } else {
                        final CancellationSignal cancellationSignal2 = cancellationSignal;
                        final PrintAttributes printAttributes3 = printAttributes2;
                        final PrintAttributes printAttributes4 = printAttributes;
                        final LayoutResultCallback layoutResultCallback2 = layoutResultCallback;
                        this.mLoadBitmap = new AsyncTask<Uri, Boolean, Bitmap>() {
                            protected void onPreExecute() {
                                cancellationSignal2.setOnCancelListener(new OnCancelListener() {
                                    public void onCancel() {
                                        AnonymousClass3.this.cancelLoad();
                                        AnonymousClass1.this.cancel(false);
                                    }
                                });
                            }

                            protected android.graphics.Bitmap doInBackground(android.net.Uri... r2) {
                                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                                /*
                                r1 = this;
                                r2 = android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3.this;	 Catch:{ FileNotFoundException -> 0x000d }
                                r2 = android.support.v4.print.PrintHelper.PrintHelperApi19.this;	 Catch:{ FileNotFoundException -> 0x000d }
                                r0 = android.support.v4.print.PrintHelper.PrintHelperApi19.AnonymousClass3.this;	 Catch:{ FileNotFoundException -> 0x000d }
                                r0 = r3;	 Catch:{ FileNotFoundException -> 0x000d }
                                r2 = r2.loadConstrainedBitmap(r0);	 Catch:{ FileNotFoundException -> 0x000d }
                                return r2;
                            L_0x000d:
                                r2 = 0;
                                return r2;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintHelperApi19.3.1.doInBackground(android.net.Uri[]):android.graphics.Bitmap");
                            }

                            protected void onPostExecute(Bitmap bitmap) {
                                super.onPostExecute(bitmap);
                                if (bitmap != null && (!PrintHelperApi19.this.mPrintActivityRespectsOrientation || PrintHelperApi19.this.mOrientation == 0)) {
                                    MediaSize mediaSize;
                                    synchronized (this) {
                                        mediaSize = AnonymousClass3.this.mAttributes.getMediaSize();
                                    }
                                    if (!(mediaSize == null || mediaSize.isPortrait() == PrintHelperApi19.isPortrait(bitmap))) {
                                        Matrix matrix = new Matrix();
                                        matrix.postRotate(90.0f);
                                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                    }
                                }
                                AnonymousClass3.this.mBitmap = bitmap;
                                if (bitmap != null) {
                                    layoutResultCallback2.onLayoutFinished(new PrintDocumentInfo.Builder(str2).setContentType(1).setPageCount(1).build(), true ^ printAttributes3.equals(printAttributes4));
                                } else {
                                    layoutResultCallback2.onLayoutFailed(null);
                                }
                                AnonymousClass3.this.mLoadBitmap = null;
                            }

                            protected void onCancelled(Bitmap bitmap) {
                                layoutResultCallback2.onLayoutCancelled();
                                AnonymousClass3.this.mLoadBitmap = null;
                            }
                        }.execute(new Uri[null]);
                    }
                }

                private void cancelLoad() {
                    synchronized (PrintHelperApi19.this.mLock) {
                        if (PrintHelperApi19.this.mDecodeOptions != null) {
                            PrintHelperApi19.this.mDecodeOptions.requestCancelDecode();
                            PrintHelperApi19.this.mDecodeOptions = null;
                        }
                    }
                }

                public void onFinish() {
                    super.onFinish();
                    cancelLoad();
                    if (this.mLoadBitmap != null) {
                        this.mLoadBitmap.cancel(true);
                    }
                    if (onPrintFinishCallback2 != null) {
                        onPrintFinishCallback2.onFinish();
                    }
                    if (this.mBitmap != null) {
                        this.mBitmap.recycle();
                        this.mBitmap = null;
                    }
                }

                public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, WriteResultCallback writeResultCallback) {
                    PrintHelperApi19.this.writeBitmap(this.mAttributes, i, this.mBitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
                }
            };
            PrintManager printManager = (PrintManager) this.mContext.getSystemService(SharePatchInfo.FINGER_PRINT);
            onPrintFinishCallback = new Builder();
            onPrintFinishCallback.setColorMode(this.mColorMode);
            if (this.mOrientation != 1) {
                if (this.mOrientation != 0) {
                    if (this.mOrientation == 2) {
                        onPrintFinishCallback.setMediaSize(MediaSize.UNKNOWN_PORTRAIT);
                    }
                    printManager.print(str, anonymousClass3, onPrintFinishCallback.build());
                }
            }
            onPrintFinishCallback.setMediaSize(MediaSize.UNKNOWN_LANDSCAPE);
            printManager.print(str, anonymousClass3, onPrintFinishCallback.build());
        }

        private Bitmap loadConstrainedBitmap(Uri uri) throws FileNotFoundException {
            if (uri != null) {
                if (this.mContext != null) {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    loadBitmap(uri, options);
                    int i = options.outWidth;
                    int i2 = options.outHeight;
                    if (i > 0) {
                        if (i2 > 0) {
                            int max = Math.max(i, i2);
                            int i3 = 1;
                            while (max > 3500) {
                                max >>>= 1;
                                i3 <<= 1;
                            }
                            if (i3 > 0) {
                                if (Math.min(i, i2) / i3 > 0) {
                                    Options options2;
                                    synchronized (this.mLock) {
                                        this.mDecodeOptions = new Options();
                                        this.mDecodeOptions.inMutable = true;
                                        this.mDecodeOptions.inSampleSize = i3;
                                        options2 = this.mDecodeOptions;
                                    }
                                    try {
                                        uri = loadBitmap(uri, options2);
                                        synchronized (this.mLock) {
                                            this.mDecodeOptions = null;
                                        }
                                        return uri;
                                    } catch (Throwable th) {
                                        synchronized (this.mLock) {
                                            this.mDecodeOptions = null;
                                        }
                                    }
                                }
                            }
                            return null;
                        }
                    }
                    return null;
                }
            }
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }

        private android.graphics.Bitmap loadBitmap(android.net.Uri r3, android.graphics.BitmapFactory.Options r4) throws java.io.FileNotFoundException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            if (r3 == 0) goto L_0x0026;
        L_0x0002:
            r0 = r2.mContext;
            if (r0 != 0) goto L_0x0007;
        L_0x0006:
            goto L_0x0026;
        L_0x0007:
            r0 = 0;
            r1 = r2.mContext;	 Catch:{ all -> 0x001f }
            r1 = r1.getContentResolver();	 Catch:{ all -> 0x001f }
            r3 = r1.openInputStream(r3);	 Catch:{ all -> 0x001f }
            r4 = android.graphics.BitmapFactory.decodeStream(r3, r0, r4);	 Catch:{ all -> 0x001c }
            if (r3 == 0) goto L_0x001b;
        L_0x0018:
            r3.close();	 Catch:{ IOException -> 0x001b }
        L_0x001b:
            return r4;
        L_0x001c:
            r4 = move-exception;
            r0 = r3;
            goto L_0x0020;
        L_0x001f:
            r4 = move-exception;
        L_0x0020:
            if (r0 == 0) goto L_0x0025;
        L_0x0022:
            r0.close();	 Catch:{ IOException -> 0x0025 }
        L_0x0025:
            throw r4;
        L_0x0026:
            r3 = new java.lang.IllegalArgumentException;
            r4 = "bad argument to loadBitmap";
            r3.<init>(r4);
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintHelperApi19.loadBitmap(android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
        }

        private Bitmap convertBitmapForColorMode(Bitmap bitmap, int i) {
            if (i != 1) {
                return bitmap;
            }
            i = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(i);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return i;
        }
    }

    private static final class PrintHelperStub implements PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        public final void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        public final void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }

        private PrintHelperStub() {
            this.mScaleMode = 2;
            this.mColorMode = 2;
            this.mOrientation = 1;
        }

        public final void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        public final int getScaleMode() {
            return this.mScaleMode;
        }

        public final int getColorMode() {
            return this.mColorMode;
        }

        public final void setColorMode(int i) {
            this.mColorMode = i;
        }

        public final void setOrientation(int i) {
            this.mOrientation = i;
        }

        public final int getOrientation() {
            return this.mOrientation;
        }
    }

    @RequiresApi(20)
    private static class PrintHelperApi20 extends PrintHelperApi19 {
        PrintHelperApi20(Context context) {
            super(context);
            this.mPrintActivityRespectsOrientation = null;
        }
    }

    @RequiresApi(23)
    private static class PrintHelperApi23 extends PrintHelperApi20 {
        protected Builder copyAttributes(PrintAttributes printAttributes) {
            Builder copyAttributes = super.copyAttributes(printAttributes);
            if (printAttributes.getDuplexMode() != 0) {
                copyAttributes.setDuplexMode(printAttributes.getDuplexMode());
            }
            return copyAttributes;
        }

        PrintHelperApi23(Context context) {
            super(context);
            this.mIsMinMarginsHandlingCorrect = null;
        }
    }

    @RequiresApi(24)
    private static class PrintHelperApi24 extends PrintHelperApi23 {
        PrintHelperApi24(Context context) {
            super(context);
            this.mIsMinMarginsHandlingCorrect = true;
            this.mPrintActivityRespectsOrientation = true;
        }
    }

    public static boolean systemSupportsPrint() {
        return VERSION.SDK_INT >= 19;
    }

    public PrintHelper(Context context) {
        if (VERSION.SDK_INT >= 24) {
            this.mImpl = new PrintHelperApi24(context);
        } else if (VERSION.SDK_INT >= 23) {
            this.mImpl = new PrintHelperApi23(context);
        } else if (VERSION.SDK_INT >= 20) {
            this.mImpl = new PrintHelperApi20(context);
        } else if (VERSION.SDK_INT >= 19) {
            this.mImpl = new PrintHelperApi19(context);
        } else {
            this.mImpl = new PrintHelperStub();
        }
    }

    public final void setScaleMode(int i) {
        this.mImpl.setScaleMode(i);
    }

    public final int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public final void setColorMode(int i) {
        this.mImpl.setColorMode(i);
    }

    public final int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public final void setOrientation(int i) {
        this.mImpl.setOrientation(i);
    }

    public final int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public final void printBitmap(String str, Bitmap bitmap) {
        this.mImpl.printBitmap(str, bitmap, null);
    }

    public final void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        this.mImpl.printBitmap(str, bitmap, onPrintFinishCallback);
    }

    public final void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.mImpl.printBitmap(str, uri, null);
    }

    public final void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        this.mImpl.printBitmap(str, uri, onPrintFinishCallback);
    }
}
