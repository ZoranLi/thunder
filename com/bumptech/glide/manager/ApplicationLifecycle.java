package com.bumptech.glide.manager;

class ApplicationLifecycle implements Lifecycle {
    ApplicationLifecycle() {
    }

    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
