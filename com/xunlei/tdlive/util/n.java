package com.xunlei.tdlive.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import anet.channel.util.HttpConstant;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.ViewTarget;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/* compiled from: XImage */
public class n {
    private static Context a;

    /* compiled from: XImage */
    public static class a<V extends View, T> {
        protected void a(V v, Drawable drawable) {
        }

        protected void a(V v, Exception exception, Drawable drawable) {
        }

        protected void a(V v, T t, int i, int i2) {
        }

        protected void b(V v, Drawable drawable) {
        }
    }

    /* compiled from: XImage */
    public static class b {
        DrawableTypeRequest a;
        Drawable b;
        a c;
        String d;

        b(DrawableTypeRequest drawableTypeRequest, String str) {
            this.d = str;
            this.a = drawableTypeRequest;
            this.a.override(Integer.MIN_VALUE, Integer.MIN_VALUE);
            this.a.transform(new BitmapTransformation[]{new BitmapTransformation(this, n.a) {
                final /* synthetic */ b a;

                protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
                    bitmapPool = bitmap.getWidth();
                    i = bitmap.getHeight();
                    i2 = 8192;
                    if (bitmapPool < 8192) {
                        if (i < 8192) {
                            return bitmap;
                        }
                    }
                    bitmapPool = (float) bitmapPool;
                    float f = bitmapPool / 8192.0f;
                    i = (float) i;
                    float f2 = i / 8192.0f;
                    if (f > f2) {
                        i2 = (int) (i / f);
                        bitmapPool = 8192;
                    } else {
                        bitmapPool = (int) (bitmapPool / f2);
                    }
                    return Bitmap.createScaledBitmap(bitmap, bitmapPool, i2, 1);
                }

                public String getId() {
                    return this.a.d;
                }
            }});
        }

        public b a(int i) {
            this.a.animate(i);
            return this;
        }

        public b b(int i) {
            return a(g.a(n.a, i));
        }

        public b a(Drawable drawable) {
            DrawableTypeRequest drawableTypeRequest = this.a;
            this.b = drawable;
            drawableTypeRequest.placeholder(drawable);
            return this;
        }

        public b a(a aVar) {
            this.c = aVar;
            return this;
        }

        public <T extends View> void a(T t) {
            a((View) t, this.c);
        }

        public <T extends View> void a(T t, a<T, ?> aVar) {
            a((a) aVar);
            if (this.c != null) {
                this.c.a(t, this.b);
            }
            if (t instanceof ImageView) {
                if (b((a) aVar) != null) {
                    this.a.asBitmap().into(a((ImageView) t));
                } else {
                    this.a.into(a((ImageView) t));
                }
            } else if (b((a) aVar) != null) {
                this.a.asBitmap().into(b((View) t));
            } else {
                this.a.into(b((View) t));
            }
        }

        private ViewTarget b(View view) {
            return new ViewTarget<View, Object>(this, view) {
                final /* synthetic */ b a;

                public void onLoadStarted(Drawable drawable) {
                    super.onLoadStarted(drawable);
                    if (this.a.c != null) {
                        this.a.c.b(this.view, drawable);
                    }
                }

                public void onLoadFailed(Exception exception, Drawable drawable) {
                    Drawable a = b.b(this.a.d, exception);
                    if (a != null) {
                        onResourceReady(a, null);
                        return;
                    }
                    super.onLoadFailed(exception, drawable);
                    if (this.a.c != null) {
                        this.a.c.a(this.view, exception, drawable);
                    }
                }

                public void onResourceReady(Object obj, GlideAnimation glideAnimation) {
                    if (this.a.c != null) {
                        int i = 0;
                        if ((obj instanceof Drawable) != null) {
                            Drawable drawable = (Drawable) obj;
                            i = drawable.getIntrinsicWidth();
                            glideAnimation = drawable.getIntrinsicHeight();
                        } else if ((obj instanceof Bitmap) != null) {
                            Bitmap bitmap = (Bitmap) obj;
                            i = bitmap.getWidth();
                            glideAnimation = bitmap.getHeight();
                        } else {
                            glideAnimation = null;
                        }
                        if (this.a.c != null) {
                            this.a.c.a(this.view, obj, i, glideAnimation);
                        }
                    }
                }
            };
        }

        private ImageViewTarget a(ImageView imageView) {
            return new ImageViewTarget(this, imageView) {
                Object a;
                final /* synthetic */ b b;

                public void onLoadStarted(Drawable drawable) {
                    super.onLoadStarted(drawable);
                    if (this.b.c != null) {
                        this.b.c.b(this.view, drawable);
                    }
                }

                public void onLoadFailed(Exception exception, Drawable drawable) {
                    Drawable a = b.b(this.b.d, exception);
                    if (a != null) {
                        onResourceReady(a, null);
                        return;
                    }
                    super.onLoadFailed(exception, drawable);
                    if (this.b.c != null) {
                        this.b.c.a(this.view, exception, drawable);
                    }
                }

                public void onResourceReady(Object obj, GlideAnimation glideAnimation) {
                    if (obj instanceof GifDrawable) {
                        setResource(obj);
                    } else {
                        super.onResourceReady(obj, glideAnimation);
                    }
                }

                protected void setResource(Object obj) {
                    int intrinsicHeight;
                    this.a = obj;
                    int i = 0;
                    if (obj instanceof Drawable) {
                        Drawable drawable = (Drawable) obj;
                        i = drawable.getIntrinsicWidth();
                        intrinsicHeight = drawable.getIntrinsicHeight();
                        ((ImageView) this.view).setImageDrawable(drawable);
                    } else if (obj instanceof Bitmap) {
                        Bitmap bitmap = (Bitmap) obj;
                        i = bitmap.getWidth();
                        intrinsicHeight = bitmap.getHeight();
                        ((ImageView) this.view).setImageBitmap(bitmap);
                    } else {
                        intrinsicHeight = 0;
                    }
                    if (this.a instanceof GifDrawable) {
                        ((GifDrawable) this.a).setLoopCount(-1);
                        ((GifDrawable) this.a).start();
                    }
                    if (this.b.c != null) {
                        this.b.c.a(this.view, obj, i, intrinsicHeight);
                    }
                }

                public void onStart() {
                    if (this.a instanceof GifDrawable) {
                        ((GifDrawable) this.a).start();
                    }
                }

                public void onStop() {
                    if (this.a instanceof GifDrawable) {
                        ((GifDrawable) this.a).stop();
                    }
                }
            };
        }

        private static Drawable b(String str, Exception exception) {
            if (TextUtils.isEmpty(str) != null) {
                return null;
            }
            if (str.startsWith("android.resource://drawable/") != null) {
                return g.a(n.a, str.substring(28));
            }
            if (str.startsWith("drawable://") != null) {
                return g.a(n.a, str.substring(11));
            }
            if (str.contains(HttpConstant.SCHEME_SPLIT) == null) {
                return g.a(n.a, str);
            }
            return null;
        }

        private static boolean b(a<?, ?> aVar) {
            if (aVar == null) {
                return false;
            }
            aVar = aVar.getClass().getGenericSuperclass();
            if (aVar == null) {
                return false;
            }
            aVar = ((ParameterizedType) aVar).getActualTypeArguments();
            if (aVar != null && aVar.length > 0) {
                for (Object obj : aVar) {
                    if (Bitmap.class.equals((Class) obj)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: XImage */
    public static class d implements Headers {
        RequestManager a;
        HashMap<String, String> b = new HashMap();

        d(RequestManager requestManager) {
            this.a = requestManager;
        }

        public Map<String, String> getHeaders() {
            return this.b;
        }

        public b a(String str) {
            DrawableTypeRequest load;
            if (TextUtils.isEmpty(str)) {
                load = this.a.load(str);
            } else {
                load = this.a.using(new c()).load(new GlideUrl(str, this));
            }
            return new b(load, str);
        }
    }

    /* compiled from: XImage */
    private static class c implements StreamModelLoader<GlideUrl> {
        private static final int a = 22;

        private c() {
        }

        public /* synthetic */ DataFetcher getResourceFetcher(Object obj, int i, int i2) {
            return a((GlideUrl) obj, i, i2);
        }

        public DataFetcher<InputStream> a(GlideUrl glideUrl, int i, int i2) {
            i = glideUrl.toStringUrl();
            i2 = Uri.parse(i);
            if (!a(i2.getScheme())) {
                return new HttpUrlFetcher(glideUrl);
            }
            if (b(i2) != null) {
                return new StreamAssetPathFetcher(n.a.getAssets(), a((Uri) i2));
            }
            if (i.startsWith("drawable://") != null) {
                i2 = Uri.parse(i.replace("drawable://", "android.resource://drawable/"));
            }
            return new StreamLocalUriFetcher(n.a, i2);
        }

        private static String a(Uri uri) {
            return uri.toString().substring(a);
        }

        private static boolean b(Uri uri) {
            if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || "android_asset".equals(uri.getPathSegments().get(0)) == null) {
                return false;
            }
            return true;
        }

        private static boolean a(String str) {
            if (!("file".equals(str) || "content".equals(str) || "android.resource".equals(str))) {
                if ("drawable".equals(str) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    private static void b(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
    }

    public static d a(View view) {
        return a(view.getContext());
    }

    public static d a(Context context) {
        b(context);
        return new d(Glide.with(context));
    }
}
