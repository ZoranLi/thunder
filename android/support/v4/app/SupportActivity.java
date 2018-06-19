package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.State;
import android.arch.lifecycle.b;
import android.arch.lifecycle.c;
import android.arch.lifecycle.h;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.SimpleArrayMap;

@RestrictTo({Scope.LIBRARY_GROUP})
public class SupportActivity extends Activity implements b {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap();
    private c mLifecycleRegistry = new c(this);

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class ExtraData {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void putExtraData(ExtraData extraData) {
        this.mExtraDataMap.put(extraData.getClass(), extraData);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        h.a((Activity) this);
    }

    @CallSuper
    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.a = State.CREATED;
        super.onSaveInstanceState(bundle);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        return (ExtraData) this.mExtraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }
}
