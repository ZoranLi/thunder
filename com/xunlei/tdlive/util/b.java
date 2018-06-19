package com.xunlei.tdlive.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.StreamStringLoader;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: BitmapDisplay */
public class b {
    private static b a;
    private Context b;
    private String c = this.b.getPackageName();

    /* compiled from: BitmapDisplay */
    private static class a<T extends View, R> {
        public void a(T t, String str, Drawable drawable) {
        }

        public void a(T t, String str, b bVar) {
        }

        private a() {
        }

        public void a(T t, String str, R r, b bVar) {
            if (bVar != null) {
                a((View) t, bVar.a());
            }
        }

        public void a(T t, Drawable drawable) {
            if (t instanceof ImageView) {
                ((ImageView) t).setImageDrawable(drawable);
            } else if (t instanceof TextView) {
                TextView textView = (TextView) t;
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (compoundDrawables == null || compoundDrawables.length <= 0) {
                    g.a((View) t, drawable);
                } else if (compoundDrawables[0] != null) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                } else if (compoundDrawables[1] != null) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                } else if (compoundDrawables[2] != null) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                } else if (compoundDrawables[3] != null) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable);
                } else {
                    g.a((View) t, drawable);
                }
            } else {
                g.a((View) t, drawable);
            }
        }

        Drawable a(T t) {
            if (t instanceof ImageView) {
                return ((ImageView) t).getDrawable();
            }
            if (t instanceof TextView) {
                Drawable[] compoundDrawables = ((TextView) t).getCompoundDrawables();
                if (compoundDrawables != null && compoundDrawables.length > 0) {
                    for (Drawable drawable : compoundDrawables) {
                        if (drawable != null) {
                            return drawable;
                        }
                    }
                }
            }
            return t.getBackground();
        }

        void a(T r5, android.view.animation.Animation r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            if (r6 == 0) goto L_0x0020;
        L_0x0002:
            r0 = android.view.animation.Animation.class;	 Catch:{ Throwable -> 0x001d }
            r1 = "clone";	 Catch:{ Throwable -> 0x001d }
            r2 = 0;	 Catch:{ Throwable -> 0x001d }
            r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x001d }
            r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ Throwable -> 0x001d }
            r1 = 1;	 Catch:{ Throwable -> 0x001d }
            r0.setAccessible(r1);	 Catch:{ Throwable -> 0x001d }
            r1 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x001d }
            r0 = r0.invoke(r6, r1);	 Catch:{ Throwable -> 0x001d }
            r0 = (android.view.animation.Animation) r0;	 Catch:{ Throwable -> 0x001d }
            r5.startAnimation(r0);	 Catch:{ Throwable -> 0x001d }
            return;
        L_0x001d:
            r5.startAnimation(r6);
        L_0x0020:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.b.a.a(android.view.View, android.view.animation.Animation):void");
        }
    }

    /* compiled from: BitmapDisplay */
    public static class b {
        private Animation a;
        private Drawable b;
        private Drawable c;
        private d d;

        public Animation a() {
            return this.a;
        }

        public Drawable b() {
            return this.b;
        }

        public b a(Drawable drawable) {
            this.b = drawable;
            return this;
        }

        public Drawable c() {
            return this.c;
        }

        public b b(Drawable drawable) {
            this.c = drawable;
            return this;
        }

        public d d() {
            return this.d;
        }
    }

    /* compiled from: BitmapDisplay */
    private static class d {
        int a;
        int b;

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }
    }

    /* compiled from: BitmapDisplay */
    public static abstract class c<T extends View> extends a<T, Bitmap> {
        public abstract void a(T t, String str, Bitmap bitmap, b bVar);

        public c() {
            super();
        }

        public /* bridge */ /* synthetic */ void a(View view, Drawable drawable) {
            super.a(view, drawable);
        }
    }

    /* compiled from: BitmapDisplay */
    private class g extends StreamLocalUriFetcher {
        final /* synthetic */ b a;

        public g(b bVar, Context context, Uri uri) {
            this.a = bVar;
            super(context, uri);
        }

        protected InputStream loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
            try {
                String path = uri.getPath();
                return this.a.b.getResources().openRawResource(Integer.valueOf(path.substring(path.lastIndexOf(47) + 1)).intValue());
            } catch (Throwable th) {
                th.printStackTrace();
                return super.loadResource(uri, contentResolver);
            }
        }
    }

    /* compiled from: BitmapDisplay */
    private class h extends StreamStringLoader {
        final /* synthetic */ b a;

        public h(b bVar, Context context) {
            this.a = bVar;
            super(context);
        }

        public DataFetcher<InputStream> getResourceFetcher(String str, int i, int i2) {
            if (str == null || !str.startsWith("android.resource://")) {
                return super.getResourceFetcher(str, i, i2);
            }
            return new g(this.a, this.a.b, Uri.parse(str));
        }
    }

    /* compiled from: BitmapDisplay */
    private static class e<R> extends SimpleTarget<R> {
        View a;
        String b;
        a<View, R> c;
        b d;
        R e;

        public e(Context context, String str, b bVar, a<View, R> aVar) {
            this.b = str;
            this.c = aVar;
            this.d = bVar;
            this.a = new View(context);
        }

        public void onLoadStarted(Drawable drawable) {
            if (this.c != null) {
                this.c.a(this.a, this.b, this.d);
            }
        }

        public void onLoadFailed(Exception exception, Drawable drawable) {
            if (this.c != null) {
                this.c.a(this.a, this.b, drawable);
            }
        }

        public void onResourceReady(R r, GlideAnimation<? super R> glideAnimation) {
            this.e = r;
            if ((this.e instanceof GifDrawable) != null) {
                ((GifDrawable) this.e).setLoopCount(-1);
                ((GifDrawable) this.e).start();
            }
            if (this.c != null) {
                this.c.a(this.a, this.b, this.e, this.d);
            }
        }

        public void onStart() {
            if (this.e instanceof GifDrawable) {
                ((GifDrawable) this.e).start();
            }
        }

        public void onStop() {
            if (this.e instanceof GifDrawable) {
                ((GifDrawable) this.e).stop();
            }
        }
    }

    /* compiled from: BitmapDisplay */
    private static class f<T extends View, R> extends ViewTarget<T, R> implements ViewAdapter {
        String a;
        a<T, R> b;
        b c;
        R d;

        public f(T t, String str, b bVar, a<T, R> aVar) {
            super(t);
            this.a = str;
            this.b = aVar;
            this.c = bVar;
            if (this.b == null) {
                this.b = new a();
            }
        }

        public void getSize(SizeReadyCallback sizeReadyCallback) {
            if (this.view.getViewTreeObserver().isAlive()) {
                if (this.view.getVisibility() != 8) {
                    super.getSize(sizeReadyCallback);
                    return;
                }
            }
            sizeReadyCallback.onSizeReady(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        public Drawable getCurrentDrawable() {
            return this.b.a(this.view);
        }

        public void setDrawable(Drawable drawable) {
            this.b.a(this.view, drawable);
        }

        public void onLoadStarted(Drawable drawable) {
            if (drawable != null) {
                setDrawable(drawable);
            }
            this.b.a(this.view, this.a, this.c);
        }

        public void onLoadFailed(Exception exception, Drawable drawable) {
            if (drawable != null) {
                setDrawable(drawable);
            }
            this.b.a(this.view, this.a, drawable);
        }

        public void onLoadCleared(Drawable drawable) {
            if (drawable != null) {
                setDrawable(drawable);
            }
        }

        public void onResourceReady(R r, GlideAnimation<? super R> glideAnimation) {
            this.d = r;
            if ((this.d instanceof Bitmap) != null) {
                setDrawable(new BitmapDrawable(this.view.getResources(), (Bitmap) this.d));
            } else if ((this.d instanceof Drawable) != null) {
                setDrawable((Drawable) this.d);
            }
            if ((this.d instanceof GifDrawable) != null) {
                ((GifDrawable) this.d).setLoopCount(-1);
                ((GifDrawable) this.d).start();
            }
            this.b.a(this.view, this.a, this.d, this.c);
        }

        public void onStart() {
            if (this.d instanceof GifDrawable) {
                ((GifDrawable) this.d).start();
            }
        }

        public void onStop() {
            if (this.d instanceof GifDrawable) {
                ((GifDrawable) this.d).stop();
            }
        }
    }

    private b(Context context) {
        this.b = context.getApplicationContext();
    }

    public static b a(Context context) {
        if (a == null) {
            a = new b(context);
        }
        return a;
    }

    public static b a(Context context, int i) {
        return a(context, i, i);
    }

    public static b a(Context context, int i, int i2) {
        return a(g.a(context, i), g.a(context, i2));
    }

    public static com.xunlei.tdlive.util.b.b a(android.graphics.drawable.Drawable r1, android.graphics.drawable.Drawable r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new com.xunlei.tdlive.util.b$b;	 Catch:{ Throwable -> 0x000c }
        r0.<init>();	 Catch:{ Throwable -> 0x000c }
        r0.b(r1);	 Catch:{ Throwable -> 0x000c }
        r0.a(r2);	 Catch:{ Throwable -> 0x000c }
        return r0;
    L_0x000c:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.b.a(android.graphics.drawable.Drawable, android.graphics.drawable.Drawable):com.xunlei.tdlive.util.b$b");
    }

    public <T extends View> void a(T t, String str) {
        a(t, str, null, null);
    }

    public <T extends View> void a(T t, String str, b bVar) {
        a(t, str, bVar, null);
    }

    public <T extends View> void a(T t, String str, c<T> cVar) {
        a(t, str, null, cVar);
    }

    public <T extends View> void a(T t, String str, b bVar, c<T> cVar) {
        String b = b(str);
        BitmapTypeRequest asBitmap = a(b).asBitmap();
        if (c(b)) {
            asBitmap.diskCacheStrategy(DiskCacheStrategy.NONE);
        }
        if (bVar != null) {
            Drawable b2 = bVar.b();
            if (b2 != null) {
                asBitmap.placeholder(b2);
            }
            b2 = bVar.c();
            if (b2 != null) {
                asBitmap.error(b2);
            }
            d d = bVar.d();
            if (d != null) {
                asBitmap.override(d.a(), d.b());
            }
        }
        if (t == null) {
            asBitmap.into(new e(this.b, str, bVar, cVar));
        } else {
            asBitmap.into(new f(t, str, bVar, cVar));
        }
    }

    private DrawableTypeRequest<?> a(String str) {
        if (d(str)) {
            return Glide.with(this.b).using(new h(this, this.b)).load(str);
        }
        return Glide.with(this.b).load(str);
    }

    private String b(String str) {
        if (str != null) {
            StringBuilder stringBuilder;
            if (str.startsWith("drawable://")) {
                stringBuilder = new StringBuilder("android.resource://");
                stringBuilder.append(this.c);
                stringBuilder.append("/");
                stringBuilder.append(str.substring(11));
                return stringBuilder.toString();
            } else if (str.startsWith("assets://")) {
                stringBuilder = new StringBuilder("file:///android_asset/");
                stringBuilder.append(str.substring(9));
                return stringBuilder.toString();
            }
        }
        return str;
    }

    private boolean c(String str) {
        if (str == null) {
            return false;
        }
        if (!str.startsWith("android.resource://")) {
            if (str.startsWith("file://") == null) {
                return false;
            }
        }
        return true;
    }

    private boolean d(String str) {
        return (str == null || str.startsWith("android.resource://") == null) ? null : true;
    }
}
