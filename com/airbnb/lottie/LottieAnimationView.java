package com.airbnb.lottie;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.BaseSavedState;
import com.airbnb.lottie.c.c;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.i.a;
import com.airbnb.lottie.model.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class LottieAnimationView extends AppCompatImageView {
    private static final String b = "LottieAnimationView";
    private static final SparseArray<i> c = new SparseArray();
    private static final SparseArray<WeakReference<i>> d = new SparseArray();
    private static final Map<String, i> e = new HashMap();
    private static final Map<String, WeakReference<i>> f = new HashMap();
    public final j a = new j();
    private final q g = new e(this);
    private CacheStrategy h;
    private String i;
    @RawRes
    private int j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    @Nullable
    private a n;
    @Nullable
    private i o;

    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new h();
        String a;
        int b;
        float c;
        boolean d;
        boolean e;
        String f;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            boolean z = false;
            this.d = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            this.e = z;
            this.f = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeString(this.f);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(@Nullable AttributeSet attributeSet) {
        boolean hasValue;
        attributeSet = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        this.h = CacheStrategy.values()[attributeSet.getInt(R.styleable.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
        if (!isInEditMode()) {
            hasValue = attributeSet.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = attributeSet.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use use only one at once.");
            } else if (hasValue) {
                int resourceId = attributeSet.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string = attributeSet.getString(R.styleable.LottieAnimationView_lottie_fileName);
                if (string != null) {
                    setAnimation(string);
                }
            }
        }
        if (attributeSet.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.a.c();
            this.l = true;
        }
        this.a.a(attributeSet.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(attributeSet.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(attributeSet.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        hasValue = attributeSet.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        j jVar = this.a;
        if (VERSION.SDK_INT >= 19) {
            jVar.l = hasValue;
            if (jVar.a != null) {
                jVar.b();
            }
        }
        if (attributeSet.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            ColorFilter uVar = new u(attributeSet.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0));
            j jVar2 = this.a;
            a aVar = new a(uVar);
            jVar2.d.add(new a(uVar));
            if (jVar2.m != null) {
                jVar2.m.a(null, null, uVar);
            }
        }
        if (attributeSet.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.a.d(attributeSet.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        attributeSet.recycle();
        if (g.a(getContext()) == null) {
            this.a.b.a = true;
        }
        j();
    }

    public void setImageResource(int i) {
        h();
        i();
        super.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.a) {
            h();
        }
        i();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        h();
        i();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        if (getDrawable() == this.a) {
            super.invalidateDrawable(this.a);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.i;
        savedState.b = this.j;
        savedState.c = this.a.b.d;
        savedState.d = this.a.b.isRunning();
        savedState.e = this.a.b.getRepeatCount() == -1;
        savedState.f = this.a.g;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.i = savedState.a;
            if (!TextUtils.isEmpty(this.i)) {
                setAnimation(this.i);
            }
            this.j = savedState.b;
            if (this.j != 0) {
                setAnimation(this.j);
            }
            setProgress(savedState.c);
            a(savedState.e);
            if (savedState.d) {
                a();
            }
            this.a.g = savedState.f;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l && this.k) {
            a();
        }
    }

    @VisibleForTesting
    private void h() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void setAnimation(@RawRes int i) {
        CacheStrategy cacheStrategy = this.h;
        this.j = i;
        this.i = null;
        if (d.indexOfKey(i) > 0) {
            i iVar = (i) ((WeakReference) d.get(i)).get();
            if (iVar != null) {
                setComposition(iVar);
                return;
            }
        } else if (c.indexOfKey(i) > 0) {
            setComposition((i) c.get(i));
            return;
        }
        this.a.f();
        i();
        Context context = getContext();
        this.n = a.a(context, context.getResources().openRawResource(i), new f(this, cacheStrategy, i));
    }

    public void setAnimation(String str) {
        CacheStrategy cacheStrategy = this.h;
        this.i = str;
        this.j = 0;
        if (f.containsKey(str)) {
            i iVar = (i) ((WeakReference) f.get(str)).get();
            if (iVar != null) {
                setComposition(iVar);
                return;
            }
        } else if (e.containsKey(str)) {
            setComposition((i) e.get(str));
            return;
        }
        this.a.f();
        i();
        this.n = a.a(getContext(), str, new g(this, cacheStrategy, str));
    }

    public void setAnimation(JSONObject jSONObject) {
        i();
        a hVar = new h(getResources(), this.g);
        hVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[]{jSONObject});
        this.n = hVar;
    }

    private void i() {
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
    }

    public void setComposition(@NonNull i iVar) {
        Object obj;
        this.a.setCallback(this);
        j jVar = this.a;
        if (jVar.a == iVar) {
            obj = null;
        } else {
            jVar.a();
            if (jVar.b.isRunning()) {
                jVar.b.cancel();
            }
            jVar.a = null;
            jVar.m = null;
            jVar.f = null;
            jVar.invalidateSelf();
            jVar.a = iVar;
            jVar.b();
            c cVar = jVar.b;
            cVar.b = iVar.a();
            cVar.b();
            jVar.c(jVar.b.d);
            jVar.d(jVar.c);
            jVar.e();
            if (jVar.m != null) {
                for (a aVar : jVar.d) {
                    jVar.m.a(aVar.a, aVar.b, aVar.c);
                }
            }
            Iterator it = new ArrayList(jVar.e).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
                it.remove();
            }
            jVar.e.clear();
            iVar.a(jVar.n);
            obj = 1;
        }
        j();
        if (obj != null) {
            setImageDrawable(null);
            setImageDrawable(this.a);
            this.o = iVar;
            requestLayout();
        }
    }

    public final void a() {
        this.a.c();
        j();
    }

    public void setMinFrame(int i) {
        this.a.a(i);
    }

    public void setMinProgress(float f) {
        this.a.a(f);
    }

    public void setMaxFrame(int i) {
        this.a.b(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.a.b(f);
    }

    public void setSpeed(float f) {
        c cVar = this.a.b;
        cVar.c = f;
        cVar.b();
    }

    public float getSpeed() {
        return this.a.b.c;
    }

    public final void a(AnimatorListener animatorListener) {
        this.a.b.addListener(animatorListener);
    }

    public final void a(boolean z) {
        this.a.a(z);
    }

    public final boolean b() {
        return this.a.b.isRunning();
    }

    public void setImageAssetsFolder(String str) {
        this.a.g = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.a.g;
    }

    public void setImageAssetDelegate(c cVar) {
        j jVar = this.a;
        jVar.h = cVar;
        if (jVar.f != null) {
            jVar.f.b = cVar;
        }
    }

    public void setFontAssetDelegate(b bVar) {
        j jVar = this.a;
        jVar.j = bVar;
        if (jVar.i != null) {
            jVar.i.e = bVar;
        }
    }

    public void setTextDelegate(v vVar) {
        this.a.k = vVar;
    }

    public void setScale(float f) {
        this.a.d(f);
        if (getDrawable() == this.a) {
            setImageDrawable(0.0f);
            setImageDrawable(this.a);
        }
    }

    public float getScale() {
        return this.a.c;
    }

    public final void c() {
        this.a.f();
        j();
    }

    public void setFrame(int i) {
        this.a.c(i);
    }

    public int getFrame() {
        j jVar = this.a;
        if (jVar.a == null) {
            return 0;
        }
        return (int) (jVar.b.d * jVar.a.b());
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.a.c(f);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.a.b.d;
    }

    public long getDuration() {
        return this.o != null ? this.o.a() : 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        j jVar = this.a;
        jVar.n = z;
        if (jVar.a != null) {
            jVar.a.a(z);
        }
    }

    @Nullable
    public s getPerformanceTracker() {
        j jVar = this.a;
        return jVar.a != null ? jVar.a.g : null;
    }

    private void j() {
        int i = 1;
        int i2 = (this.m && this.a.b.isRunning()) ? 1 : 0;
        if (i2 != 0) {
            i = 2;
        }
        setLayerType(i, null);
    }

    protected void onDetachedFromWindow() {
        if (this.a.b.isRunning()) {
            c();
            this.k = true;
        }
        h();
        super.onDetachedFromWindow();
    }
}
