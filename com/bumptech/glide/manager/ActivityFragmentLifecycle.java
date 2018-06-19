package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle implements Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final Set<LifecycleListener> lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());

    ActivityFragmentLifecycle() {
    }

    public void addListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.isDestroyed) {
            lifecycleListener.onDestroy();
        } else if (this.isStarted) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    void onStart() {
        this.isStarted = true;
        for (LifecycleListener onStart : Util.getSnapshot(this.lifecycleListeners)) {
            onStart.onStart();
        }
    }

    void onStop() {
        this.isStarted = false;
        for (LifecycleListener onStop : Util.getSnapshot(this.lifecycleListeners)) {
            onStop.onStop();
        }
    }

    void onDestroy() {
        this.isDestroyed = true;
        for (LifecycleListener onDestroy : Util.getSnapshot(this.lifecycleListeners)) {
            onDestroy.onDestroy();
        }
    }
}
