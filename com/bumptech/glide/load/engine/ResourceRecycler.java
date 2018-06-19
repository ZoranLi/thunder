package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.util.Util;

class ResourceRecycler {
    private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    private boolean isRecycling;

    private static class ResourceRecyclerCallback implements Callback {
        public static final int RECYCLE_RESOURCE = 1;

        private ResourceRecyclerCallback() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return null;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }

    ResourceRecycler() {
    }

    public void recycle(Resource<?> resource) {
        Util.assertMainThread();
        if (this.isRecycling) {
            this.handler.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.isRecycling = true;
        resource.recycle();
        this.isRecycling = null;
    }
}
